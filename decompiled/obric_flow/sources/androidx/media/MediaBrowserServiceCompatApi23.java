package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class MediaBrowserServiceCompatApi23 {

    public static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        public MediaBrowserServiceAdaptor(Context r5, ServiceCompatProxy r10) {
            super(r5, r10);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String r5, MediaBrowserService.Result<MediaBrowser.MediaItem> r10) {
            ((ServiceCompatProxy) this.mServiceProxy).onLoadItem(r5, new MediaBrowserServiceCompatApi21.ResultWrapper(r10));
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String r5, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> r10);
    }

    private MediaBrowserServiceCompatApi23() {
    }

    public static Object createService(Context r5, ServiceCompatProxy r10) {
        return new MediaBrowserServiceAdaptor(r5, r10);
    }
}
