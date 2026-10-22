package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
class b {

    interface a extends android.support.v4.media.a.d {
        void b(@NonNull String r10, @NonNull Bundle r11);

        void c(@NonNull String r10, List<?> r11, @NonNull Bundle r12);
    }

    /* JADX INFO: renamed from: android.support.v4.media.b$b, reason: collision with other inner class name */
    static class C0008b<T extends a> extends android.support.v4.media.a.e<T> {
        C0008b(T r10) {
            super(r10);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String r10, List<MediaBrowser.MediaItem> r11, @NonNull Bundle r12) {
            MediaSessionCompat.a(r12);
            ((a) this.f192a).c(r10, r11, r12);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@NonNull String r10, @NonNull Bundle r11) {
            MediaSessionCompat.a(r11);
            ((a) this.f192a).b(r10, r11);
        }
    }

    static Object a(a r10) {
        return new C0008b(r10);
    }
}
