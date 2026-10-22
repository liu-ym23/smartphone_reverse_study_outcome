package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaBrowserServiceCompatApi21 {

    static class BrowserRoot {
        final Bundle mExtras;
        final String mRootId;

        BrowserRoot(String r10, Bundle r11) {
            this.mRootId = r10;
            this.mExtras = r11;
        }
    }

    static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        MediaBrowserServiceAdaptor(Context r10, ServiceCompatProxy r11) {
            attachBaseContext(r10);
            this.mServiceProxy = r11;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String r10, int r11, Bundle r12) {
            MediaSessionCompat.a(r12);
            ServiceCompatProxy r13 = this.mServiceProxy;
            if (r12 != null) goto L5;
            Bundle r14 = null;
        L6:
            BrowserRoot r15 = r13.onGetRoot(r10, r11, r14);
            if (r15 != null) goto L10;
            return null;
        L10:
            return new MediaBrowserService.BrowserRoot(r15.mRootId, r15.mExtras);
        L5:
            r14 = new Bundle(r12);
            goto L6
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r10, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r11) {
            this.mServiceProxy.onLoadChildren(r10, new ResultWrapper(r11));
        }
    }

    static class ResultWrapper<T> {
        MediaBrowserService.Result mResultObj;

        ResultWrapper(MediaBrowserService.Result r10) {
            this.mResultObj = r10;
        }

        public void detach() {
            this.mResultObj.detach();
        }

        List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            ArrayList r11 = new ArrayList();
            Iterator<Parcel> r12 = r10.iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            Parcel r13 = r12.next();
            r13.setDataPosition(0);
            r11.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(r13));
            r13.recycle();
            goto L7
        L9:
            return r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void sendResult(T r10) {
            if ((r10 instanceof List) == false) goto L6;
            this.mResultObj.sendResult(parcelListToItemList((List) r10));
            return;
        L6:
            if ((r10 instanceof Parcel) == false) goto L8;
            Parcel r11 = (Parcel) r10;
            r11.setDataPosition(0);
            this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(r11));
            r11.recycle();
            return;
        L8:
            this.mResultObj.sendResult(null);
        }
    }

    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String r10, int r11, Bundle r12);

        void onLoadChildren(String r10, ResultWrapper<List<Parcel>> r11);
    }

    private MediaBrowserServiceCompatApi21() {
    }

    public static Object createService(Context r10, ServiceCompatProxy r11) {
        return new MediaBrowserServiceAdaptor(r10, r11);
    }

    public static void notifyChildrenChanged(Object r10, String r11) {
        ((MediaBrowserService) r10).notifyChildrenChanged(r11);
    }

    public static IBinder onBind(Object r10, Intent r11) {
        return ((MediaBrowserService) r10).onBind(r11);
    }

    public static void onCreate(Object r10) {
        ((MediaBrowserService) r10).onCreate();
    }

    public static void setSessionToken(Object r10, Object r11) {
        ((MediaBrowserService) r10).setSessionToken((MediaSession.Token) r11);
    }
}
