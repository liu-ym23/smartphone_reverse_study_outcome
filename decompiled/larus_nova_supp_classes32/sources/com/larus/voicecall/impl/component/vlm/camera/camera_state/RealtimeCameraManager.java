package com.larus.voicecall.impl.component.vlm.camera.camera_state;

import android.content.Context;
import android.opengl.EGLContext;
import android.view.TextureView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.im.service.audio.vlm.VideoFrameBufferType;
import com.larus.im.service.audio.y0;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.voicecall.impl.component.vlm.camera.core.CameraOpenScene;
import com.larus.voicecall.impl.component.vlm.h1;
import com.larus.voicecall.impl.component.vlm.i1;
import com.larus.voicecall.impl.plugins.o1;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.vesdk.VEDisplaySettings;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeCameraManager implements f, q3a.p {
    public final r3a.k a;
    public final e b;
    public final String c;
    public Function0<Unit> d;
    public Function0<? extends o1> e;
    public final AtomicBoolean f;
    public final Lazy g;
    public final Lazy h;
    public final AtomicInteger i;
    public final Lazy j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/camera/camera_state/RealtimeCameraManager$RetryPhase;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "ENUMERATE", "STARTUP", "RUNNING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RetryPhase extends Enum<RetryPhase> {
        public static final RetryPhase ENUMERATE = null;
        public static final RetryPhase RUNNING = null;
        public static final RetryPhase STARTUP = null;
        public static final /* synthetic */ RetryPhase[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<RetryPhase> getEntries() {
            return b;
        }

        static {
            RetryPhase r0 = new RetryPhase("ENUMERATE", 0);
            ENUMERATE = r0;
            RetryPhase r1 = new RetryPhase("STARTUP", 1);
            STARTUP = r1;
            RetryPhase r3 = new RetryPhase("RUNNING", 2);
            RUNNING = r3;
            RetryPhase[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static RetryPhase[] values() {
            return (RetryPhase[]) a.clone();
        }

        public static RetryPhase valueOf(String r1) {
            return (RetryPhase) r27.a.a(RetryPhase.class, r1);
        }

        public RetryPhase(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final class a {
        public final AtomicInteger a;
        public final AtomicInteger b;
        public final AtomicBoolean c;
        public final AtomicLong d;
        public final AtomicBoolean e;
        public volatile boolean f;
        public volatile boolean g;
        public volatile boolean h;
        public volatile int i;
        public volatile int j;
        public volatile int k;
        public final /* synthetic */ RealtimeCameraManager l;

        /* JADX INFO: renamed from: com.larus.voicecall.impl.component.vlm.camera.camera_state.RealtimeCameraManager$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0018a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[RetryPhase.values().length];
                r0[RetryPhase.ENUMERATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[RetryPhase.STARTUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[RetryPhase.RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final void c() {
            this.f = false;
            this.g = false;
            this.e.set(false);
            if (b() == true) goto L5;
            return;
        L5:
            this.a.incrementAndGet();
            this.b.incrementAndGet();
            this.c.set(false);
        }

        public static boolean b() {
            return z2.a.isRealtimeCameraRetryEnable();
        }

        public a(RealtimeCameraManager r4) {
            this.l = r4;
            this.a = new AtomicInteger(0);
            this.b = new AtomicInteger(0);
            this.c = new AtomicBoolean(false);
            this.d = new AtomicLong(0);
            this.e = new AtomicBoolean(false);
            this.h = z2.a.enableCamera2();
        }

        public final void a(final int r4) {
            if (this.e.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            t0.b(new o(this, r4), 2000);
        }

        public final boolean d(c r4) {
            Intrinsics.checkNotNullParameter(r4, "openTaskToken");
            if (this.f == true) goto L5;
        L18:
            return true;
        L5:
            if (this.l.i.get() != r4.a) goto L18;
            Integer r5 = r4.b;
            if (r5 == null) goto L17;
            int r6 = r5.intValue();
            if (b() == true) goto L13;
            return true;
        L13:
            if (this.b.get() != r6) goto L19;
            return false;
        L19:
            return true;
        L17:
            return false;
        }

        public final void e(final RetryPhase r12, final String r13, boolean r14) {
            if (b() == true) goto L6;
            return;
        L6:
            if (this.f == true) goto L10;
            FLogger.a.i("RealtimeCameraManager", "skip camera retry because camera is not user opened, phase=" + r12 + " reason=" + r13);
            return;
        L10:
            if (r14 == false) goto L12;
            this.c.set(false);
        L12:
            boolean r3 = true;
            if (this.c.compareAndSet(false, true) == true) goto L16;
            FLogger.a.i("RealtimeCameraManager", "skip camera retry because retrying, phase=" + r12 + " reason=" + r13);
            return;
        L16:
            int r15 = C0018a.a[r12.ordinal()];
            if (r15 == 1) goto L45;
            if (r15 == 2) goto L34;
            if (r15 != 3) goto L32;
            if (this.k >= 2) goto L46;
            this.k++;
            if (this.k != 1) goto L27;
            r3 = this.l.a.q();
        L30:
            Boolean r16 = Boolean.valueOf(r3);
        L47:
            final Boolean r5 = r16;
            if (r5 != null) goto L59;
            this.c.set(false);
            FLogger.a.w("RealtimeCameraManager", "camera retry exhausted, phase=" + r12 + " reason=" + r13);
            return;
        L59:
            final int r10 = this.a.incrementAndGet();
            int r17 = this.b.incrementAndGet();
            final c r9 = new c(this.l.i.get(), Integer.valueOf(r17));
            FLogger.a.w("RealtimeCameraManager", "triggerCameraRetry, phase=" + r12 + " reason=" + r13 + " targetUseCamera2=" + r5 + " retryGen=" + r10 + " retryOpenGen=" + r17 + " enumerateRetryCount=" + this.i + " startupRetryCount=" + this.j + " runningRetryCount=" + this.k);
            final RealtimeCameraManager r4 = this.l;
            t0.a(new m(r4, r5, r12, r13, this, r9, r10));
            return;
        L27:
            if (this.l.a.q() == false) goto L30;
            r3 = false;
        L46:
            r16 = null;
            goto L47
        L32:
            throw new NoWhenBranchMatchedException();
        L34:
            if (this.j >= 2) goto L46;
            this.j++;
            if (this.j != 1) goto L40;
            r3 = this.l.a.q();
        L43:
            r16 = Boolean.valueOf(r3);
            goto L47
        L40:
            if (this.l.a.q() == false) goto L43;
            r3 = false;
            goto L43
        L45:
            if (this.i >= 3) goto L46;
            this.i++;
            if ((this.i % 2) == 1) goto L51;
            r3 = this.h;
        L55:
            r16 = Boolean.valueOf(r3);
            goto L47
        L51:
            if (this.h == false) goto L55;
            r3 = false;
            goto L55
        }
    }

    public static final class b {
    }

    public static final class c {
        public final int a;
        public final Integer b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            Integer r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "OpenTaskToken(asyncOpenGeneration=" + this.a + ", retryOpenGeneration=" + this.b + ')';
        }

        public c(int r1, Integer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // q3a.p
    public final void n() {
    }

    @Override // q3a.p
    public final void p(boolean r1, int r2) {
    }

    @Override // q3a.p
    public final void r() {
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final r3a.l getCurrentState() {
        e r0 = this.b;
        ReentrantReadWriteLock.ReadLock r1 = r0.d.readLock();
        r1.lock();
        r3a.l r2 = r0.c;     // Catch: Throwable -> L6
        r1.unlock();
        return r2;
    L6:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final boolean isCameraTorchSupported() {
        return this.a.isCameraTorchSupported();
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void openCamera() {
        RealtimeCallUtil.a.getClass();
        if (((Boolean) RealtimeCallUtil.s.getValue()).booleanValue() == false) goto L16;
        Fragment r0 = this.a.getFragment();
        if (r0 == null) goto L16;
        Context r1 = r0.getContext();
        if (r1 == null) goto L16;
        if (ContextCompat.checkSelfPermission(r1, "android.permission.CAMERA") != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L16;
        FLogger.a.e("RealtimeCameraManager", "Camera permission not granted");
        u().c();
        return;
    L11:
        r2 = false;
    L16:
        if (((Boolean) this.g.getValue()).booleanValue() == true) goto L18;
    L23:
        a r3 = u();
        r3.f = true;
        r3.g = false;
        r3.d.set(0);
        r3.i = 0;
        r3.j = 0;
        r3.k = 0;
        r3.e.set(false);
        r3.c.set(false);
        r3.l.a.a();
        if (a.b() == true) goto L26;
        int r5 = 0;
    L27:
        v(new c(this.i.get(), null), r5, "openCamera", CameraOpenScene.PRIMARY_START, true);
        return;
    L26:
        r3.h = r3.l.a.q();
        r5 = r3.a.incrementAndGet();
        goto L27
    L18:
        if (e2.a.isPad() == true) goto L23;
        if (this.f.compareAndSet(false, true) == true) goto L23;
        FLogger.a.i("RealtimeCameraManager", "openCamera skip: already opened since last close");
    }

    public final a u() {
        return (a) this.j.getValue();
    }

    public final void w() {
        if (this.a.n() == true) goto L5;
    L7:
        FLogger.a.w("RealtimeCameraManager", "on CameraOpenState reached. but resources not available. do not start preview. isRecorderPrepared=" + this.a.j().e);
        return;
    L5:
        if (this.a.j().f == false) goto L7;
        this.a.k();
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void closeCamera() {
        u().c();
        this.i.incrementAndGet();
        this.f.set(false);
        this.a.d("closeCamera_RealtimeCameraManager");
    }

    @Override // q3a.p
    public final void g() {
        a r0 = u();
        r0.getClass();
        if (a.b() == false) goto L6;
        r0.g = true;
        r0.j = 0;
        r0.d.set(System.currentTimeMillis());
        r0.a(r0.a.get());
    L6:
        this.d.invoke();
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void onDestroy() {
        u().c();
        this.i.incrementAndGet();
        this.a.s();
    }

    @Override // q3a.p
    public final void a() {
        w();
    }

    @Override // q3a.p
    public final String o() {
        return this.c;
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void b(boolean r4) {
        FLogger.a.i("RealtimeCameraManager", "switchCamera request useBack=" + r4);
        this.a.b(r4);
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final boolean c(boolean r2) {
        return this.a.c(r2);
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void d(float r2) {
        this.a.u(r2);
    }

    @Override // q3a.p
    public final void i(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "captureParams");
        this.f.set(false);
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void j(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    @Override // q3a.p
    public final void k(int r5) {
        FLogger.a.w("RealtimeCameraManager", "onCameraOpenFailed cameraType=" + r5 + ", reset hasOpened to allow retry");
        this.f.set(false);
        a r0 = u();
        r0.getClass();
        r0.e(RetryPhase.ENUMERATE, "cameraOpenFailed_" + r5, true);
    }

    @Override // q3a.p
    public final void l(s3a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void m(TextureView r3) {
        Intrinsics.checkNotNullParameter(r3, "glSurfaceView");
        this.a.m(r3);
        FLogger.a.i("RealtimeCameraManager", "Render initialized successfully");
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void q(i1 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    @Override // q3a.p
    public final void s(r3a.i r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        this.f.set(false);
        a r1 = u();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "error");
        if (a.b() == true) goto L6;
        return;
    L6:
        if (z2.a.getRealtimeCameraRetryAllowErrorCodes().contains(Integer.valueOf(r6.a)) == true) goto L9;
        FLogger.a.i("RealtimeCameraManager", "skip camera retry for errorCode=" + r6.a + ", message=" + r6.b);
        return;
    L9:
        if (r1.g == false) goto L11;
        RetryPhase r0 = RetryPhase.RUNNING;
    L12:
        r1.e(r0, "onError_" + r6.a + '_' + r6.b, false);
        return;
    L11:
        r0 = RetryPhase.STARTUP;
        goto L12
    }

    @Override // q3a.p
    public final void t(r3a.j r13) {
        Intrinsics.checkNotNullParameter(r13, "frame");
        a r0 = u();
        r0.getClass();
        if (a.b() == false) goto L23;
        r0.d.set(System.currentTimeMillis());
        if (r0.g == false) goto L23;
        r0.a(r0.a.get());
    L23:
        o1 r1 = (o1) this.e.invoke();     // Catch: Exception -> L20
        if (r1 != null) goto L11;
        return;
    L11:
        if (y0.b(this.a.g().j) == false) goto L13;
        int r2 = r13.b;     // Catch: Exception -> L20
    L14:
        int r6 = r2;
        if (y0.b(this.a.g().j) == false) goto L17;
        int r3 = r13.c;     // Catch: Exception -> L20
    L18:
        EGLContext r4 = r13.g;     // Catch: Exception -> L20
        int r5 = r13.a;     // Catch: Exception -> L20
        float[] r7 = r13.e;     // Catch: Exception -> L20
        tf9.b r8 = new tf9.b(r4, r5, r7, r6, r3, r13.f, r13.d, false);     // Catch: Exception -> L20
        VideoFrameBufferType r14 = r13.h;     // Catch: Exception -> L20
        Intrinsics.checkNotNullParameter(r14, "<set-?>");     // Catch: Exception -> L20
        r8.i = r14;     // Catch: Exception -> L20
        r1.h(r8);     // Catch: Exception -> L20
        this.a.t(new s3a.a(r8));     // Catch: Exception -> L20
        return;
    L17:
        r3 = r13.b;     // Catch: Exception -> L20
        goto L18
    L13:
        r2 = r13.c;     // Catch: Exception -> L20
    L20:
        e = move-exception;
        FLogger.a.e("RealtimeCameraManager", "Error pushing video frame", e);
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void f(float r2, float r3) {
        this.a.f(r2, r3);
    }

    @Override // q3a.p
    public final void h(r3a.l r2, r3a.l r3) {
        Intrinsics.checkNotNullParameter(r2, "oldState");
        Intrinsics.checkNotNullParameter(r3, "newState");
        if ((r3 instanceof com.larus.voicecall.impl.component.vlm.camera.camera_state.a) == false) goto L6;
        this.a.d("onStateChanged_RealtimeCameraManager");
        return;
    L6:
        if ((r3 instanceof com.larus.voicecall.impl.component.vlm.camera.camera_state.c) == false) goto L10;
        w();
        return;
    }

    public RealtimeCameraManager(r3a.f r2, e r3, q3a.o r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "stateManager");
        Intrinsics.checkNotNullParameter(r4, "eventDispatcher");
        this.a = r2;
        this.b = r3;
        this.c = "RealtimeCameraManager";
        this.d = new i();
        this.e = q.a;
        this.f = new AtomicBoolean(false);
        this.g = LazyKt.lazy(new j());
        this.h = LazyKt.lazy(new k());
        this.i = new AtomicInteger(0);
        this.j = LazyKt.lazy(new l(this));
        r4.a(this);
    }

    @Override // com.larus.voicecall.impl.component.vlm.camera.camera_state.f
    public final void e(int r2, int r3, VEDisplaySettings.VEDisplayFitMode r4) {
        Intrinsics.checkNotNullParameter(r4, "fitMode");
        this.a.e(r2, r3, r4);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.voicecall.impl.component.vlm.camera.camera_state.g] */
    public final void v(final c r8, final int r9, final String r10, final CameraOpenScene r11, boolean r12) {
        final ?? r6 = new g(this, r8, r10, r11, r9);
        if (r12 == true) goto L5;
    L9:
        r6.run();
        return;
    L5:
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L9;
        if (e2.a.isPad() == true) goto L9;
        t0.a(new h(r6));
    }
}
