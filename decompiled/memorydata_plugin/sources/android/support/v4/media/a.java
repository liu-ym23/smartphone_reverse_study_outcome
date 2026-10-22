package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: android.support.v4.media.a$a, reason: collision with other inner class name */
    interface InterfaceC0008a {
        void a();

        void b();

        void c();
    }

    static class b<T extends InterfaceC0008a> extends MediaBrowser.ConnectionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f55a;

        public b(T r3) {
            this.f55a = (T) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0008a.class, "com.obric.memorydata.plugin");
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.f55a.a();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.f55a.c();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.f55a.b();
        }
    }

    static class c {
        public static int a(Object r2) {
            return ((MediaBrowser.MediaItem) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.MediaItem.class, "com.obric.memorydata.plugin")).getFlags();
        }

        public static Object b(Object r2) {
            return ((MediaBrowser.MediaItem) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.MediaItem.class, "com.obric.memorydata.plugin")).getDescription();
        }
    }

    interface d {
        void a(String r1);

        void a(String r1, List<?> r2);
    }

    static class e<T extends d> extends MediaBrowser.SubscriptionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f56a;

        public e(T r3) {
            this.f56a = (T) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String r3, List<MediaBrowser.MediaItem> r4) {
            List<?> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f56a.a(r3, r5);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String r1) {
            this.f56a.a(r1);
        }
    }

    public static Object a(Context r3, ComponentName r4, Object r5, Bundle r6) {
        return new MediaBrowser((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, (MediaBrowser.ConnectionCallback) ZeusTransformUtils.preCheckCast(r5, MediaBrowser.ConnectionCallback.class, "com.obric.memorydata.plugin"), r6);
    }

    public static Object a(InterfaceC0008a r2) {
        return new b((InterfaceC0008a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0008a.class, "com.obric.memorydata.plugin"));
    }

    public static Object a(d r2) {
        return new e((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin"));
    }

    public static void a(Object r2) {
        ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.memorydata.plugin")).connect();
    }

    public static void b(Object r2) {
        ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.memorydata.plugin")).disconnect();
    }

    public static Bundle c(Object r2) {
        return ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.memorydata.plugin")).getExtras();
    }

    public static Object d(Object r2) {
        return ((MediaBrowser) ZeusTransformUtils.preCheckCast(r2, MediaBrowser.class, "com.obric.memorydata.plugin")).getSessionToken();
    }
}
