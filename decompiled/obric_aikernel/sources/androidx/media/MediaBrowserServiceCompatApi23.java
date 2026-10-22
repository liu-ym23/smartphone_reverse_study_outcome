package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class MediaBrowserServiceCompatApi23 {

    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context r10, ServiceCompatProxy r11) {
            super(r10, r11);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String r10, MediaBrowserService.Result<MediaBrowser.MediaItem> r11) {
            ((ServiceCompatProxy) this.mServiceProxy).onLoadItem(r10, new MediaBrowserServiceCompatApi21.ResultWrapper(r11));
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String r10, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> r11);
    }

    private MediaBrowserServiceCompatApi23() {
    }

    public static Object createService(Context r10, ServiceCompatProxy r11) {
        return new MediaBrowserServiceAdaptor(r10, r11);
    }
}
