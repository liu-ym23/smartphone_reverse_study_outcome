package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
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

    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context r10, ServiceCompatProxy r11) {
            super(r10, r11);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r10, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r11, Bundle r12) {
            MediaSessionCompat.a(r12);
            ((ServiceCompatProxy) this.mServiceProxy).onLoadChildren(r10, new ResultWrapper(r11), r12);
        }
    }

    static class ResultWrapper {
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

        public void sendResult(List<Parcel> r10, int r11) {
            MediaBrowserServiceCompatApi26.sResultFlags.setInt(this.mResultObj, r11);     // Catch: IllegalAccessException -> L4
        L6:
            this.mResultObj.sendResult(parcelListToItemList(r10));
            return;
        L4:
            e = move-exception;
            Log.w(MediaBrowserServiceCompatApi26.TAG, e);
            goto L6
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String r10, ResultWrapper r11, Bundle r12);
    }

    static {
        Field r10 = MediaBrowserService.Result.class.getDeclaredField("mFlags");     // Catch: NoSuchFieldException -> L4
        sResultFlags = r10;     // Catch: NoSuchFieldException -> L4
        r10.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    L4:
        e = move-exception;
        Log.w(TAG, e);
    }

    private MediaBrowserServiceCompatApi26() {
    }

    public static Object createService(Context r10, ServiceCompatProxy r11) {
        return new MediaBrowserServiceAdaptor(r10, r11);
    }

    public static Bundle getBrowserRootHints(Object r10) {
        return ((MediaBrowserService) r10).getBrowserRootHints();
    }

    public static void notifyChildrenChanged(Object r10, String r11, Bundle r12) {
        ((MediaBrowserService) r10).notifyChildrenChanged(r11, r12);
    }
}
