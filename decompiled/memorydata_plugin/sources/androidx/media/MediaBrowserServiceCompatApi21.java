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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserServiceCompatApi21 {

    static class BrowserRoot {
        final Bundle mExtras;
        final String mRootId;

        BrowserRoot(String r1, Bundle r2) {
            this.mRootId = r1;
            this.mExtras = r2;
        }
    }

    static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        MediaBrowserServiceAdaptor(Context r3, ServiceCompatProxy r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            ServiceCompatProxy r6 = (ServiceCompatProxy) ZeusTransformUtils.wrapperContextForParams(r4, ServiceCompatProxy.class, "com.obric.memorydata.plugin");
            attachBaseContext(r5);
            this.mServiceProxy = r6;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String r3, int r4, Bundle r5) {
            MediaSessionCompat.a(r5);
            ServiceCompatProxy r2 = this.mServiceProxy;
            if (r5 != null) goto L5;
            Bundle r1 = null;
        L6:
            BrowserRoot r6 = r2.onGetRoot(r3, r4, r1);
            if (r6 != null) goto L10;
            return null;
        L10:
            return new MediaBrowserService.BrowserRoot(r6.mRootId, r6.mExtras);
        L5:
            r1 = new Bundle(r5);
            goto L6
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r2, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r3) {
            this.mServiceProxy.onLoadChildren(r2, new ResultWrapper(r3));
        }
    }

    static class ResultWrapper<T> {
        MediaBrowserService.Result mResultObj;

        ResultWrapper(MediaBrowserService.Result r1) {
            this.mResultObj = r1;
        }

        public void detach() {
            this.mResultObj.detach();
        }

        List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> r4) {
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L6;
            return null;
        L6:
            ArrayList r5 = new ArrayList();
            Iterator r6 = r3.iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            Parcel r1 = (Parcel) ZeusTransformUtils.preCheckCast(r6.next(), Parcel.class, "com.obric.memorydata.plugin");
            r1.setDataPosition(0);
            r5.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(r1));
            r1.recycle();
            goto L8
        L10:
            return r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void sendResult(T r4) {
            if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L6;
            this.mResultObj.sendResult(parcelListToItemList((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")));
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, Parcel.class) == false) goto L8;
            Parcel r5 = (Parcel) ZeusTransformUtils.preCheckCast(r4, Parcel.class, "com.obric.memorydata.plugin");
            r5.setDataPosition(0);
            this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(r5));
            r5.recycle();
            return;
        L8:
            this.mResultObj.sendResult(null);
        }
    }

    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String r1, int r2, Bundle r3);

        void onLoadChildren(String r1, ResultWrapper<List<Parcel>> r2);
    }

    private MediaBrowserServiceCompatApi21() {
    }

    public static Object createService(Context r2, ServiceCompatProxy r3) {
        return new MediaBrowserServiceAdaptor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (ServiceCompatProxy) ZeusTransformUtils.wrapperContextForParams(r3, ServiceCompatProxy.class, "com.obric.memorydata.plugin"));
    }

    public static void notifyChildrenChanged(Object r2, String r3) {
        ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.memorydata.plugin")).notifyChildrenChanged(r3);
    }

    public static IBinder onBind(Object r2, Intent r3) {
        return ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.memorydata.plugin")).onBind(r3);
    }

    public static void onCreate(Object r2) {
        ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.memorydata.plugin")).onCreate();
    }

    public static void setSessionToken(Object r2, Object r3) {
        ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.memorydata.plugin")).setSessionToken((MediaSession.Token) ZeusTransformUtils.preCheckCast(r3, MediaSession.Token.class, "com.obric.memorydata.plugin"));
    }
}
