package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.f;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
class MediaBrowserServiceCompatApi26 {
    private static final String TAG = "MBSCompatApi26";
    static Field sResultFlags;

    public static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        public MediaBrowserServiceAdaptor(Context r5, ServiceCompatProxy r10) {
            super(r5, r10);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r5, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r10, Bundle r11) {
            f.a(r11);
            ((ServiceCompatProxy) this.mServiceProxy).onLoadChildren(r5, new ResultWrapper(r10), r11);
        }
    }

    public static class ResultWrapper {
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

        public void sendResult(List<Parcel> r5, int r10) {
            MediaBrowserServiceCompatApi26.sResultFlags.setInt(this.mResultObj, r10);     // Catch: IllegalAccessException -> L4
        L6:
            this.mResultObj.sendResult(parcelListToItemList(r5));
            return;
        L4:
            e = move-exception;
            Log.w(MediaBrowserServiceCompatApi26.TAG, e);
            goto L6
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String r5, ResultWrapper r10, Bundle r11);
    }

    static {
        Field r5 = MediaBrowserService.Result.class.getDeclaredField("mFlags");     // Catch: NoSuchFieldException -> L4
        sResultFlags = r5;     // Catch: NoSuchFieldException -> L4
        r5.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    L4:
        e = move-exception;
        Log.w(TAG, e);
    }

    private MediaBrowserServiceCompatApi26() {
    }

    public static Object createService(Context r5, ServiceCompatProxy r10) {
        return new MediaBrowserServiceAdaptor(r5, r10);
    }

    public static Bundle getBrowserRootHints(Object r5) {
        return ((MediaBrowserService) r5).getBrowserRootHints();
    }

    public static void notifyChildrenChanged(Object r5, String r10, Bundle r11) {
        ((MediaBrowserService) r5).notifyChildrenChanged(r10, r11);
    }
}
