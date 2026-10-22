package uj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import uf2.a0;
import uf2.d0;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements uj0.d {
    public final Map<String, Disposable> b;
    public final Map<String, a> c;
    public final Map<String, z.a> d;
    public final Map<String, com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> e;
    public final ConcurrentLinkedQueue<C0281b> f;
    public Disposable g;
    public final CompositeDisposable h;
    public boolean i;
    public final d0 j;

    public static final class a {
        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == false) goto L6;
            a r3 = (a) r2;
            r3.getClass();
            r3.getClass();
            r3.getClass();
            return true;
        L6:
            return false;
        }

        public final int hashCode() {
            return (((0 * 31) + 0) * 31) + 0;
        }

        public final String toString() {
            return "GLTexture(textureId=0, width=0, height=0)";
        }
    }

    /* JADX INFO: renamed from: uj0.b$b, reason: collision with other inner class name */
    public static final class C0281b {
        public final com.bytedance.android.live.liveinteract.videotalk.avatarmix.d a;
        public final Bitmap b;
        public final z.a c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0281b) == false) goto L12;
            C0281b r4 = (C0281b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Bitmap r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            z.a r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "RenderTask(struct=" + this.a + ", bitmap=" + this.b + ", videoSink=" + this.c + ")";
        }

        public C0281b(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r2, Bitmap r3, z.a r4) {
            Intrinsics.checkNotNullParameter(r2, "struct");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Long r7 = (Long) r6;
            Iterator<T> r8 = ((LinkedHashMap) this.a.d).entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L8;
            Map.Entry r0 = (Map.Entry) r8.next();
            Map<String, com.bytedance.android.live.liveinteract.videotalk.avatarmix.d> r1 = this.a.e;
            LinkedHashMap r2 = (LinkedHashMap) r1;
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r3 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r2.get(r0.getKey());
            if (r3 == null) goto L4;
            this.a.f.add(new C0281b(r3, null, (z.a) r0.getValue()));
            this.a.c();
            goto L4
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ C0281b b;

        public d(b r1, C0281b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r11) {
            a r12 = (a) r11;
            Map<String, a> r0 = this.a.c;
            int r1 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.b;
            r0.put(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C0097a.a(this.b.a), r12);
            b r2 = this.a;
            z.a r3 = this.b.c;
            r2.getClass();
            r12.getClass();
            r12.getClass();
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r4 = ILiveWrappedLivePusher.a.b();
            if (r4 == null) goto L5;
            r12.getClass();
            r4.newVideoMixerTexture(0, 0, 0, 1, new int[]{0, 0, 0}, null, 0);
        L5:
            if (r3 == null) goto L8;
            r3.a();
        L8:
            if ((r3 instanceof a0.a) == true) goto L10;
            r3 = null;
        L10:
            a0.a r5 = (a0.a) r3;
            if (r5 == null) goto L13;
            r5.c();
        L13:
            this.a.c();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ b a;

        public e(b r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
            this.a.c();
        }
    }

    public final void c() {
        Disposable r0 = this.g;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        if (r0.isDisposed() == true) goto L7;
        return;
    L7:
        C0281b r1 = this.f.poll();
        if (r1 != null) goto L10;
        return;
    L10:
        Disposable r2 = Single.create(new uj0.c(this, r1.a, r1.b)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r1), new e(this));
        this.g = r2;
        uj0.d.a r3 = uj0.d.a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r4 = r1.a;
        r3.getClass();
        String r5 = uj0.d.a.a(r4);
        this.b.put(r5, r2);
    }

    @Override // uj0.d
    public final void init() {
        if (this.i == false) goto L5;
        return;
    L5:
        this.i = true;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
        if (r0 == null) goto L8;
        r0.getSafeHandlerThreadPoolExecutor();
    L8:
        ALogger.d("MicseatMixer", "GLRenderer init");
        f.a(Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), this.h);
    }

    @Override // uj0.d
    public final void release() {
        if (this.i == true) goto L5;
        return;
    L5:
        this.i = false;
        ALogger.d("MicseatMixer", "GLRenderer release");
        ((LinkedHashMap) this.c).clear();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
        if (r0 == null) goto L8;
        r0.getSafeHandlerThreadPoolExecutor();
    L8:
        Iterator r1 = ((LinkedHashMap) this.d).entrySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) r1.next();
        ((z.a) r2.getValue()).a();
        ((z.a) r2.getValue()).dispose();
        goto L10
    L12:
        ((LinkedHashMap) this.d).clear();
        ((LinkedHashMap) this.e).clear();
        ((LinkedHashMap) this.b).clear();
        this.h.clear();
    }

    public b(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, "liveCore");
        this.j = r2;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new ConcurrentLinkedQueue();
        this.h = new CompositeDisposable();
    }

    @Override // uj0.d
    public final void a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r4) {
        Intrinsics.checkNotNullParameter(r4, "struct");
        if (this.i == true) goto L5;
        return;
    L5:
        ALogger.d("MicseatMixer", "GLRenderer clear " + r4);
        uj0.d.a.getClass();
        String r0 = uj0.d.a.a(r4);
        Map<String, a> r1 = this.c;
        int r2 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.b;
        r1.remove(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C0097a.a(r4));
        Disposable r5 = this.b.remove(r0);
        if (r5 == null) goto L8;
        r5.dispose();
    L8:
        z.a r6 = this.d.remove(r0);
        if (r6 == null) goto L11;
        r6.a();
        r6.dispose();
    L11:
        this.e.remove(r0);
    }

    @Override // uj0.d
    public final void b(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r19, Bitmap r20) {
        Intrinsics.checkNotNullParameter(r19, "struct");
        Intrinsics.checkNotNullParameter(r20, "bitmap");
        if (this.i == true) goto L5;
        return;
    L5:
        ALogger.d("MicseatMixer", "GLRenderer render " + r19);
        uj0.d.a.getClass();
        String r5 = uj0.d.a.a(r19);
        ti6.f r6 = r19.d;
        z.a r7 = (z.a) ((LinkedHashMap) this.d).get(r5);
        if (r7 == null) goto L27;
    L20:
        if (r7 == null) goto L25;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r8 = ILiveWrappedLivePusher.a.b();
        if (r8 == null) goto L24;
        double r9 = r6.d;
        double r11 = r6.e;
        r8.newVideoMixerDescription((float) r9, (float) r11, (float) (r9 + r6.f), (float) (r11 + r6.g), 1, 2);
    L24:
        r7.b();
    L25:
        this.e.put(r5, r19);
        this.f.add(new C0281b(r19, r20, r7));
        c();
        return;
    L27:
        z r0 = this.j.C();     // Catch: Throwable -> L18
        if (r0 == null) goto L13;
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L18
        ILiveWrappedLivePusher r10 = ILiveWrappedLivePusher.a.b();     // Catch: Throwable -> L18
        if (r10 == null) goto L12;
        double r12 = r6.d;     // Catch: Throwable -> L18
        double r13 = r6.e;     // Catch: Throwable -> L18
        r10.newVideoMixerDescription((float) r12, (float) r13, (float) (r12 + r6.f), (float) (r13 + r6.g), 1, 2);     // Catch: Throwable -> L18
    L12:
        r20.getWidth();     // Catch: Throwable -> L18
        r20.getHeight();     // Catch: Throwable -> L18
        z.a r1 = r0.b();     // Catch: Throwable -> L18
    L14:
        r7 = r1;
        if (r7 == null) goto L20;
        r7.a();     // Catch: Throwable -> L18
        this.d.put(r5, r7);     // Catch: Throwable -> L18
        goto L20
    L13:
        r1 = null;
    L18:
        th = move-exception;
        ALogger.e("MicseatMixer", "create layer failed", th);
        goto L20
    }
}
