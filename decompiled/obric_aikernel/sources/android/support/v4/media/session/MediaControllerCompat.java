package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f193a;

    private static class MediaControllerExtraData extends ComponentActivity.ExtraData {
        private final MediaControllerCompat mMediaController;

        MediaControllerExtraData(MediaControllerCompat r10) {
            this.mMediaController = r10;
        }

        MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    @RequiresApi(21)
    static class MediaControllerImplApi21 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Object f194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @GuardedBy("mLock")
        private final List<a> f196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private HashMap<a, a> f197d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final MediaSessionCompat.Token f198e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 r10) {
                super(null);
                this.mMediaControllerImpl = new WeakReference(r10);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int r10, Bundle r11) {
                MediaControllerImplApi21 r12 = this.mMediaControllerImpl.get();
                if (r12 == null) goto L14;
                if (r11 == null) goto L17;
                Object r13 = r12.f195b;
                monitor-enter(r13);
                r12.f198e.setExtraBinder(android.support.v4.media.session.b.a.U0(BundleCompat.getBinder(r11, "android.support.v4.media.session.EXTRA_BINDER")));     // Catch: Throwable -> L11
                r12.f198e.setSessionToken2Bundle(r11.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));     // Catch: Throwable -> L11
                r12.b();     // Catch: Throwable -> L11
                monitor-exit(r13);     // Catch: Throwable -> L11
                return;
            L11:
                th = move-exception;
                throw th;
            L17:
                return;
            }
        }

        private static class a extends a.b {
            a(a r10) {
                super(r10);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.b, android.support.v4.media.session.a
            public void G1(MediaMetadataCompat r10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.b, android.support.v4.media.session.a
            public void M(Bundle r10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.b, android.support.v4.media.session.a
            public void Q(List<MediaSessionCompat.QueueItem> r10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.b, android.support.v4.media.session.a
            public void j0(CharSequence r10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.b, android.support.v4.media.session.a
            public void k0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.b, android.support.v4.media.session.a
            public void o2(ParcelableVolumeInfo r10) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context r10, MediaSessionCompat.Token r11) {
            this.f195b = new Object();
            this.f196c = new ArrayList();
            this.f197d = new HashMap();
            this.f198e = r11;
            Object r12 = android.support.v4.media.session.c.c(r10, r11.getToken());
            this.f194a = r12;
            if (r12 == null) goto L9;
            if (r11.getExtraBinder() != null) goto L10;
            c();
            return;
        L10:
            return;
        L9:
            throw new RemoteException();
        }

        private void c() {
            d("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent r10) {
            return android.support.v4.media.session.c.b(this.f194a, r10);
        }

        @GuardedBy("mLock")
        void b() {
            if (this.f198e.getExtraBinder() != null) goto L5;
            return;
        L5:
            Iterator<a> r10 = this.f196c.iterator();
        L7:
            if (r10.hasNext() == false) goto L13;
            a r11 = r10.next();
            a r12 = new a(r11);
            this.f197d.put(r11, r12);
            r11.f200b = r12;
            this.f198e.getExtraBinder().T0(r12);     // Catch: RemoteException -> L11
            r11.i(13, null, null);
        L11:
            e = move-exception;
            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
        L13:
            this.f196c.clear();
        }

        public void d(String r10, Bundle r11, ResultReceiver r12) {
            android.support.v4.media.session.c.d(this.f194a, r10, r11, r12);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        android.support.v4.media.session.a f200b;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        private static class C0009a implements android.support.v4.media.session.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f201a;

            C0009a(a r10) {
                this.f201a = new WeakReference(r10);
            }

            @Override // android.support.v4.media.session.c.a
            public void M(Bundle r10) {
                a r11 = this.f201a.get();
                if (r11 == null) goto L6;
                r11.b(r10);
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void Q(List<?> r10) {
                a r11 = this.f201a.get();
                if (r11 == null) goto L6;
                r11.e(MediaSessionCompat.QueueItem.fromQueueItemList(r10));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Object r10) {
                a r11 = this.f201a.get();
                if (r11 == null) goto L6;
                r11.c(MediaMetadataCompat.fromMediaMetadata(r10));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void b(int r10, int r11, int r12, int r13, int r14) {
                a r15 = this.f201a.get();
                if (r15 == null) goto L6;
                r15.a(new f(r10, r11, r12, r13, r14));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void c(Object r10) {
                a r11 = this.f201a.get();
                if (r11 != null) goto L5;
                return;
            L5:
                if (r11.f200b != null) goto L10;
                r11.d(PlaybackStateCompat.fromPlaybackState(r10));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void d(String r10, Bundle r11) {
                a r12 = this.f201a.get();
                if (r12 != null) goto L5;
                return;
            L5:
                if (r12.f200b != null) goto L7;
            L9:
                r12.h(r10, r11);
                return;
            L7:
                if (Build.VERSION.SDK_INT >= 23) goto L9;
            }

            @Override // android.support.v4.media.session.c.a
            public void j0(CharSequence r10) {
                a r11 = this.f201a.get();
                if (r11 == null) goto L6;
                r11.f(r10);
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void k0() {
                a r10 = this.f201a.get();
                if (r10 == null) goto L6;
                r10.g();
                return;
            }
        }

        private static class b extends android.support.v4.media.session.a.AbstractBinderC0010a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final WeakReference<a> f202c;

            b(a r10) {
                this.f202c = new WeakReference(r10);
            }

            @Override // android.support.v4.media.session.a
            public void D1(boolean r10) {
            }

            public void G1(MediaMetadataCompat r10) {
                a r11 = this.f202c.get();
                if (r11 == null) goto L6;
                r11.i(3, r10, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void L0(String r10, Bundle r11) {
                a r12 = this.f202c.get();
                if (r12 == null) goto L6;
                r12.i(1, r10, r11);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void L1(int r10) {
                a r11 = this.f202c.get();
                if (r11 == null) goto L6;
                r11.i(9, Integer.valueOf(r10), null);
                return;
            }

            public void M(Bundle r10) {
                a r11 = this.f202c.get();
                if (r11 == null) goto L6;
                r11.i(7, r10, null);
                return;
            }

            public void Q(List<MediaSessionCompat.QueueItem> r10) {
                a r11 = this.f202c.get();
                if (r11 == null) goto L6;
                r11.i(5, r10, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void T1(int r10) {
                a r11 = this.f202c.get();
                if (r11 == null) goto L6;
                r11.i(12, Integer.valueOf(r10), null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void i1() {
                a r10 = this.f202c.get();
                if (r10 == null) goto L6;
                r10.i(13, null, null);
                return;
            }

            public void j0(CharSequence r10) {
                a r11 = this.f202c.get();
                if (r11 == null) goto L6;
                r11.i(6, r10, null);
                return;
            }

            public void k0() {
                a r10 = this.f202c.get();
                if (r10 == null) goto L6;
                r10.i(8, null, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void m2(PlaybackStateCompat r10) {
                a r11 = this.f202c.get();
                if (r11 == null) goto L6;
                r11.i(2, r10, null);
                return;
            }

            public void o2(ParcelableVolumeInfo r10) {
                a r11 = this.f202c.get();
                if (r11 != null) goto L5;
                return;
            L5:
                if (r10 == null) goto L7;
                f r12 = new f(r10.volumeType, r10.audioStream, r10.controlType, r10.maxVolume, r10.currentVolume);
            L8:
                r11.i(4, r12, null);
                return;
            L7:
                r12 = null;
                goto L8
            }

            @Override // android.support.v4.media.session.a
            public void y1(boolean r10) {
                a r11 = this.f202c.get();
                if (r11 == null) goto L6;
                r11.i(11, Boolean.valueOf(r10), null);
                return;
            }
        }

        public a() {
            if (Build.VERSION.SDK_INT < 21) goto L5;
            this.f199a = android.support.v4.media.session.c.a(new C0009a(this));
            return;
        L5:
            this.f200b = new b(this);
        }

        public void a(f r10) {
        }

        public void b(Bundle r10) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            i(8, null, null);
        }

        public void c(MediaMetadataCompat r10) {
        }

        public void d(PlaybackStateCompat r10) {
        }

        public void e(List<MediaSessionCompat.QueueItem> r10) {
        }

        public void f(CharSequence r10) {
        }

        public void g() {
        }

        public void h(String r10, Bundle r11) {
        }

        void i(int r10, Object r11, Bundle r12) {
        }
    }

    interface b {
        boolean a(KeyEvent r10);
    }

    @RequiresApi(23)
    static class c extends MediaControllerImplApi21 {
        public c(Context r10, MediaSessionCompat.Token r11) {
            super(r10, r11);
        }
    }

    @RequiresApi(24)
    static class d extends c {
        public d(Context r10, MediaSessionCompat.Token r11) {
            super(r10, r11);
        }
    }

    static class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private android.support.v4.media.session.b f203a;

        public e(MediaSessionCompat.Token r10) {
            this.f203a = android.support.v4.media.session.b.a.U0((IBinder) r10.getToken());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent r10) {
            if (r10 == null) goto L10;
            this.f203a.C1(r10);     // Catch: RemoteException -> L5
            return false;
        L5:
            e = move-exception;
            Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
            return false;
        L10:
            throw new IllegalArgumentException("event may not be null.");
        }
    }

    public static final class f {
        f(int r10, int r11, int r12, int r13, int r14) {
        }
    }

    public MediaControllerCompat(Context r10, @NonNull MediaSessionCompat.Token r11) {
        new HashSet();
        if (r11 == null) goto L17;
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 24) goto L9;
        b r13 = new d(r10, r11);
    L7:
        this.f193a = r13;
        return;
    L9:
        if (r12 < 23) goto L12;
        r13 = new c(r10, r11);
        goto L7
    L12:
        if (r12 < 21) goto L14;
        r13 = new MediaControllerImplApi21(r10, r11);
        goto L7
    L14:
        this.f193a = new e(r11);
        return;
    L17:
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public boolean a(KeyEvent r10) {
        if (r10 == null) goto L6;
        return this.f193a.a(r10);
    L6:
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
}
