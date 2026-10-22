package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class a {

    /* JADX INFO: renamed from: android.support.v4.media.a$a, reason: collision with other inner class name */
    interface InterfaceC0007a {
        void a();

        void b();

        void c();
    }

    static class b<T extends InterfaceC0007a> extends MediaBrowser.ConnectionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f191a;

        public b(T r10) {
            this.f191a = r10;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.f191a.a();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.f191a.c();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.f191a.b();
        }
    }

    static class c {
        public static Object a(Object r10) {
            return ((MediaBrowser.MediaItem) r10).getDescription();
        }

        public static int b(Object r10) {
            return ((MediaBrowser.MediaItem) r10).getFlags();
        }
    }

    interface d {
        void a(@NonNull String r10);

        void d(@NonNull String r10, List<?> r11);
    }

    static class e<T extends d> extends MediaBrowser.SubscriptionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f192a;

        public e(T r10) {
            this.f192a = r10;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String r10, List<MediaBrowser.MediaItem> r11) {
            this.f192a.d(r10, r11);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@NonNull String r10) {
            this.f192a.a(r10);
        }
    }

    public static void a(Object r10) {
        ((MediaBrowser) r10).connect();
    }

    public static Object b(Context r10, ComponentName r11, Object r12, Bundle r13) {
        return new MediaBrowser(r10, r11, (MediaBrowser.ConnectionCallback) r12, r13);
    }

    public static Object c(InterfaceC0007a r10) {
        return new b(r10);
    }

    public static Object d(d r10) {
        return new e(r10);
    }

    public static void e(Object r10) {
        ((MediaBrowser) r10).disconnect();
    }

    public static Bundle f(Object r10) {
        return ((MediaBrowser) r10).getExtras();
    }

    public static Object g(Object r10) {
        return ((MediaBrowser) r10).getSessionToken();
    }
}
