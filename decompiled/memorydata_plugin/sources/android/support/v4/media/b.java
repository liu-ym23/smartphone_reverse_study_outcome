package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class b {

    interface a extends android.support.v4.media.a.d {
        void a(String r1, Bundle r2);

        void a(String r1, List<?> r2, Bundle r3);
    }

    /* JADX INFO: renamed from: android.support.v4.media.b$b, reason: collision with other inner class name */
    static class C0009b<T extends a> extends android.support.v4.media.a.e<T> {
        C0009b(T r3) {
            super((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String r3, List<MediaBrowser.MediaItem> r4, Bundle r5) {
            List<?> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            MediaSessionCompat.a(r5);
            ((a) ZeusTransformUtils.preCheckCast(this.f56a, a.class, "com.obric.memorydata.plugin")).a(r3, r6, r5);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String r3, Bundle r4) {
            MediaSessionCompat.a(r4);
            ((a) ZeusTransformUtils.preCheckCast(this.f56a, a.class, "com.obric.memorydata.plugin")).a(r3, r4);
        }
    }

    static Object a(a r2) {
        return new C0009b((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin"));
    }
}
