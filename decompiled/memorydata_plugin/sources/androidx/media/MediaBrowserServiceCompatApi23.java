package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserServiceCompatApi23 {

    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context r3, ServiceCompatProxy r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (ServiceCompatProxy) ZeusTransformUtils.wrapperContextForParams(r4, ServiceCompatProxy.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String r3, MediaBrowserService.Result<MediaBrowser.MediaItem> r4) {
            ((ServiceCompatProxy) ZeusTransformUtils.preCheckCast(this.mServiceProxy, ServiceCompatProxy.class, "com.obric.memorydata.plugin")).onLoadItem(r3, new MediaBrowserServiceCompatApi21.ResultWrapper(r4));
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String r1, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> r2);
    }

    private MediaBrowserServiceCompatApi23() {
    }

    public static Object createService(Context r2, ServiceCompatProxy r3) {
        return new MediaBrowserServiceAdaptor((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (ServiceCompatProxy) ZeusTransformUtils.wrapperContextForParams(r3, ServiceCompatProxy.class, "com.obric.memorydata.plugin"));
    }
}
