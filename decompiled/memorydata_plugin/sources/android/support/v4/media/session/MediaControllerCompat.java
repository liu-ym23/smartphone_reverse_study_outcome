package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f57a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaSessionCompat.Token f58b;
    private final HashSet<a> c;

    private static class MediaControllerExtraData extends ComponentActivity.ExtraData {
        private final MediaControllerCompat mMediaController;

        MediaControllerExtraData(MediaControllerCompat r1) {
            this.mMediaController = r1;
        }

        MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    static class MediaControllerImplApi21 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Object f59a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f60b;
        final MediaSessionCompat.Token c;
        private final List<a> d;
        private HashMap<a, a> e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 r2) {
                super(null);
                this.mMediaControllerImpl = new WeakReference(r2);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int r3, Bundle r4) {
                MediaControllerImplApi21 r2 = (MediaControllerImplApi21) ZeusTransformUtils.preCheckCast(this.mMediaControllerImpl.get(), MediaControllerImplApi21.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L14;
                if (r4 == null) goto L17;
                Object r5 = r2.f60b;
                monitor-enter(r5);
                r2.c.setExtraBinder(android.support.v4.media.session.b.a.a(BundleCompat.getBinder(r4, "android.support.v4.media.session.EXTRA_BINDER")));     // Catch: Throwable -> L11
                r2.c.setSessionToken2Bundle(r4.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));     // Catch: Throwable -> L11
                r2.a();     // Catch: Throwable -> L11
                monitor-exit(r5);     // Catch: Throwable -> L11
                return;
            L11:
                th = move-exception;
                throw th;
            L17:
                return;
            }
        }

        private static class a extends a.c {
            a(a r1) {
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(Bundle r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(MediaMetadataCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(ParcelableVolumeInfo r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(CharSequence r2) {
                CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(List<MediaSessionCompat.QueueItem> r2) {
                List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context r3, MediaSessionCompat.Token r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this.f60b = new Object();
            this.d = new ArrayList();
            this.e = new HashMap();
            this.c = r4;
            Object r6 = android.support.v4.media.session.c.a(r5, r4.getToken());
            this.f59a = r6;
            if (r6 == null) goto L9;
            if (r4.getExtraBinder() != null) goto L10;
            b();
            return;
        L10:
            return;
        L9:
            throw new RemoteException();
        }

        private void b() {
            a("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        void a() {
            if (this.c.getExtraBinder() != null) goto L5;
            return;
        L5:
            Iterator<a> r0 = this.d.iterator();
        L7:
            if (r0.hasNext() == false) goto L13;
            a r1 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin");
            a r2 = new a(r1);
            this.e.put(r1, r2);
            r1.c = r2;
            this.c.getExtraBinder().a(r2);     // Catch: RemoteException -> L11
            r1.a(13, null, null);
        L11:
            e = move-exception;
            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
        L13:
            this.d.clear();
        }

        public void a(String r1, Bundle r2, ResultReceiver r3) {
            android.support.v4.media.session.c.a(this.f59a, r1, r2, r3);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent r1) {
            return android.support.v4.media.session.c.a(this.f59a, r1);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f61a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        HandlerC0010a f62b;
        android.support.v4.media.session.a c;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        private class HandlerC0010a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f63a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f64b;

            @Override // android.os.Handler
            public void handleMessage(Message r4) {
                if (this.f63a == true) goto L6;
                return;
            L6:
                switch(r4.what) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L14;
                    case 7: goto L13;
                    case 8: goto L12;
                    case 9: goto L11;
                    case 10: goto L32;
                    case 11: goto L10;
                    case 12: goto L9;
                    case 13: goto L8;
                    default: goto L32;
                };
            L8:
                this.f64b.a();
                return;
            L9:
                this.f64b.b(((Integer) ZeusTransformUtils.preCheckCast(r4.obj, Integer.class, "com.obric.memorydata.plugin")).intValue());
                return;
            L10:
                this.f64b.a(((Boolean) ZeusTransformUtils.preCheckCast(r4.obj, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
                return;
            L11:
                this.f64b.a(((Integer) ZeusTransformUtils.preCheckCast(r4.obj, Integer.class, "com.obric.memorydata.plugin")).intValue());
                return;
            L12:
                this.f64b.b();
                return;
            L13:
                Bundle r5 = (Bundle) ZeusTransformUtils.preCheckCast(r4.obj, Bundle.class, "com.obric.memorydata.plugin");
                MediaSessionCompat.a(r5);
                this.f64b.a(r5);
                return;
            L14:
                this.f64b.a((CharSequence) ZeusTransformUtils.preCheckCast(r4.obj, CharSequence.class, "com.obric.memorydata.plugin"));
                return;
            L15:
                this.f64b.a((List) ZeusTransformUtils.preCheckCast(r4.obj, List.class, "com.obric.memorydata.plugin"));
                return;
            L16:
                this.f64b.a((f) ZeusTransformUtils.preCheckCast(r4.obj, f.class, "com.obric.memorydata.plugin"));
                return;
            L17:
                this.f64b.a((MediaMetadataCompat) ZeusTransformUtils.preCheckCast(r4.obj, MediaMetadataCompat.class, "com.obric.memorydata.plugin"));
                return;
            L18:
                this.f64b.a((PlaybackStateCompat) ZeusTransformUtils.preCheckCast(r4.obj, PlaybackStateCompat.class, "com.obric.memorydata.plugin"));
                return;
            L19:
                Bundle r0 = r4.getData();
                MediaSessionCompat.a(r0);
                this.f64b.a((String) ZeusTransformUtils.preCheckCast(r4.obj, String.class, "com.obric.memorydata.plugin"), r0);
                return;
            }
        }

        private static class b implements android.support.v4.media.session.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f65a;

            b(a r2) {
                this.f65a = new WeakReference(r2);
            }

            @Override // android.support.v4.media.session.c.a
            public void a() {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f65a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.b();
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void a(int r8, int r9, int r10, int r11, int r12) {
                a r7 = (a) ZeusTransformUtils.preCheckCast(this.f65a.get(), a.class, "com.obric.memorydata.plugin");
                if (r7 == null) goto L6;
                r7.a(new f(r8, r9, r10, r11, r12));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Bundle r3) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f65a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(r3);
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void a(CharSequence r3) {
                CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f65a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(r4);
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Object r3) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f65a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 != null) goto L5;
                return;
            L5:
                if (r2.c != null) goto L10;
                r2.a(PlaybackStateCompat.fromPlaybackState(r3));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void a(String r3, Bundle r4) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f65a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 != null) goto L5;
                return;
            L5:
                if (r2.c != null) goto L7;
            L9:
                r2.a(r3, r4);
                return;
            L7:
                if (Build.VERSION.SDK_INT >= 23) goto L9;
            }

            @Override // android.support.v4.media.session.c.a
            public void a(List<?> r3) {
                List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f65a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(MediaSessionCompat.QueueItem.fromQueueItemList(r4));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void b(Object r3) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f65a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(MediaMetadataCompat.fromMediaMetadata(r3));
                return;
            }
        }

        private static class c extends android.support.v4.media.session.a.AbstractBinderC0011a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f66a;

            c(a r2) {
                this.f66a = new WeakReference(r2);
            }

            public void a() {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(8, null, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void a(int r3) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(9, Integer.valueOf(r3), null);
                return;
            }

            public void a(Bundle r3) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(7, r3, null);
                return;
            }

            public void a(MediaMetadataCompat r3) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(3, r3, null);
                return;
            }

            public void a(ParcelableVolumeInfo r9) {
                a r8 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r8 != null) goto L5;
                return;
            L5:
                if (r9 == null) goto L7;
                f r7 = new f(r9.volumeType, r9.audioStream, r9.controlType, r9.maxVolume, r9.currentVolume);
            L8:
                r8.a(4, r7, null);
                return;
            L7:
                r7 = null;
                goto L8
            }

            @Override // android.support.v4.media.session.a
            public void a(PlaybackStateCompat r3) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(2, r3, null);
                return;
            }

            public void a(CharSequence r3) {
                CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(6, r4, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void a(String r3, Bundle r4) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(1, r3, r4);
                return;
            }

            public void a(List<MediaSessionCompat.QueueItem> r3) {
                List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(5, r4, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void a(boolean r1) {
            }

            @Override // android.support.v4.media.session.a
            public void b() {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(13, null, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void b(int r3) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(12, Integer.valueOf(r3), null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void b(boolean r3) {
                a r2 = (a) ZeusTransformUtils.preCheckCast(this.f66a.get(), a.class, "com.obric.memorydata.plugin");
                if (r2 == null) goto L6;
                r2.a(11, Boolean.valueOf(r3), null);
                return;
            }
        }

        public a() {
            if (Build.VERSION.SDK_INT < 21) goto L5;
            Object r0 = android.support.v4.media.session.c.a(new b(this));
        L6:
            this.f61a = r0;
            return;
        L5:
            c r1 = new c(this);
            this.c = r1;
            r0 = r1;
            goto L6
        }

        public void a() {
        }

        public void a(int r1) {
        }

        void a(int r1, Object r2, Bundle r3) {
            HandlerC0010a r0 = this.f62b;
            if (r0 == null) goto L6;
            Message r4 = r0.obtainMessage(r1, r2);
            r4.setData(r3);
            r4.sendToTarget();
            return;
        }

        public void a(Bundle r1) {
        }

        public void a(MediaMetadataCompat r1) {
        }

        public void a(f r1) {
        }

        public void a(PlaybackStateCompat r1) {
        }

        public void a(CharSequence r2) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        }

        public void a(String r1, Bundle r2) {
        }

        public void a(List<MediaSessionCompat.QueueItem> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        }

        public void a(boolean r1) {
        }

        public void b() {
        }

        public void b(int r1) {
        }
    }

    interface b {
        boolean a(KeyEvent r1);
    }

    static class c extends MediaControllerImplApi21 {
        public c(Context r3, MediaSessionCompat.Token r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static class d extends c {
        public d(Context r3, MediaSessionCompat.Token r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private android.support.v4.media.session.b f67a;

        public e(MediaSessionCompat.Token r3) {
            this.f67a = android.support.v4.media.session.b.a.a((IBinder) ZeusTransformUtils.preCheckCast(r3.getToken(), IBinder.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent r2) {
            if (r2 == null) goto L10;
            this.f67a.a(r2);     // Catch: RemoteException -> L5
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f68a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f69b;
        private final int c;
        private final int d;
        private final int e;

        f(int r1, int r2, int r3, int r4, int r5) {
            this.f68a = r1;
            this.f69b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public MediaControllerCompat(Context r3, MediaSessionCompat.Token r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.c = new HashSet();
        if (r4 == null) goto L17;
        this.f58b = r4;
        if (Build.VERSION.SDK_INT < 24) goto L9;
        b r0 = new d(r5, r4);
    L7:
        this.f57a = r0;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        r0 = new c(r5, r4);
        goto L7
    L12:
        if (Build.VERSION.SDK_INT < 21) goto L14;
        r0 = new MediaControllerImplApi21(r5, r4);
        goto L7
    L14:
        this.f57a = new e(r4);
        return;
    L17:
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public boolean a(KeyEvent r1) {
        if (r1 == null) goto L6;
        return this.f57a.a(r1);
    L6:
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
}
