package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.f;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaBrowserServiceCompatApi21 {

    public static class BrowserRoot {
        final Bundle mExtras;
        final String mRootId;

        public BrowserRoot(String r5, Bundle r10) {
            this.mRootId = r5;
            this.mExtras = r10;
        }
    }

    public static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        public MediaBrowserServiceAdaptor(Context r5, ServiceCompatProxy r10) {
            attachBaseContext(r5);
            this.mServiceProxy = r10;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String r5, int r10, Bundle r11) {
            f.a(r11);
            ServiceCompatProxy r12 = this.mServiceProxy;
            if (r11 != null) goto L5;
            Bundle r13 = null;
        L6:
            BrowserRoot r14 = r12.onGetRoot(r5, r10, r13);
            if (r14 != null) goto L10;
            return null;
        L10:
            return new MediaBrowserService.BrowserRoot(r14.mRootId, r14.mExtras);
        L5:
            r13 = new Bundle(r11);
            goto L6
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r5, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r10) {
            this.mServiceProxy.onLoadChildren(r5, new ResultWrapper(r10));
        }
    }

    public static class ResultWrapper<T> {
        MediaBrowserService.Result mResultObj;

        public ResultWrapper(MediaBrowserService.Result r5) {
            this.mResultObj = r5;
        }

        public void detach() {
            this.mResultObj.detach();
        }

        public List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            ArrayList r10 = new ArrayList();
            Iterator<Parcel> r11 = r5.iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            Parcel r12 = r11.next();
            r12.setDataPosition(0);
            r10.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(r12));
            r12.recycle();
            goto L7
        L9:
            return r10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void sendResult(T r5) {
            if ((r5 instanceof List) == false) goto L6;
            this.mResultObj.sendResult(parcelListToItemList((List) r5));
            return;
        L6:
            if ((r5 instanceof Parcel) == false) goto L8;
            Parcel r10 = (Parcel) r5;
            r10.setDataPosition(0);
            this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(r10));
            r10.recycle();
            return;
        L8:
            this.mResultObj.sendResult(null);
        }
    }

    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String r5, int r10, Bundle r11);

        void onLoadChildren(String r5, ResultWrapper<List<Parcel>> r10);
    }

    private MediaBrowserServiceCompatApi21() {
    }

    public static Object createService(Context r5, ServiceCompatProxy r10) {
        return new MediaBrowserServiceAdaptor(r5, r10);
    }

    public static void notifyChildrenChanged(Object r5, String r10) {
        ((MediaBrowserService) r5).notifyChildrenChanged(r10);
    }

    public static IBinder onBind(Object r5, Intent r10) {
        return ((MediaBrowserService) r5).onBind(r10);
    }

    public static void onCreate(Object r5) {
        ((MediaBrowserService) r5).onCreate();
    }

    public static void setSessionToken(Object r5, Object r10) {
        ((MediaBrowserService) r5).setSessionToken((MediaSession.Token) r10);
    }
}
