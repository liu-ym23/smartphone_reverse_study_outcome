package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserServiceCompatApi26 {
    private static final String TAG = "MBSCompatApi26";
    static Field sResultFlags;

    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context r3, ServiceCompatProxy r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (ServiceCompatProxy) ZeusTransformUtils.wrapperContextForParams(r4, ServiceCompatProxy.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r3, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r4, Bundle r5) {
            MediaSessionCompat.a(r5);
            ((ServiceCompatProxy) ZeusTransformUtils.preCheckCast(this.mServiceProxy, ServiceCompatProxy.class, "com.obric.memorydata.plugin")).onLoadChildren(r3, new ResultWrapper(r4), r5);
        }
    }

    static class ResultWrapper {
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

        public void sendResult(List<Parcel> r3, int r4) {
            List<Parcel> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            MediaBrowserServiceCompatApi26.sResultFlags.setInt(this.mResultObj, r4);     // Catch: IllegalAccessException -> L5
        L7:
            this.mResultObj.sendResult(parcelListToItemList(r5));
            return;
        L5:
            e = move-exception;
            Log.w(MediaBrowserServiceCompatApi26.TAG, e);
            goto L7
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String r1, ResultWrapper r2, Bundle r3);
    }

    static {
        Field r0 = MediaBrowserService.Result.class.getDeclaredField("mFlags");     // Catch: NoSuchFieldException -> L4
        sResultFlags = r0;     // Catch: NoSuchFieldException -> L4
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    L4:
        e = move-exception;
        Log.w(TAG, e);
    }

    private MediaBrowserServiceCompatApi26() {
    }

    public static Object createService(Context r2, ServiceCompatProxy r3) {
        return new MediaBrowserServiceAdaptor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (ServiceCompatProxy) ZeusTransformUtils.wrapperContextForParams(r3, ServiceCompatProxy.class, "com.obric.memorydata.plugin"));
    }

    public static Bundle getBrowserRootHints(Object r2) {
        return ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.memorydata.plugin")).getBrowserRootHints();
    }

    public static void notifyChildrenChanged(Object r2, String r3, Bundle r4) {
        ((MediaBrowserService) ZeusTransformUtils.preCheckCast(r2, MediaBrowserService.class, "com.obric.memorydata.plugin")).notifyChildrenChanged(r3, r4);
    }
}
