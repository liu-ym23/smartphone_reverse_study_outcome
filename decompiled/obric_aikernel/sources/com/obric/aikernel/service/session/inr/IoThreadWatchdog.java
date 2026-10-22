package com.obric.aikernel.service.session.inr;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class IoThreadWatchdog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f5563f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f5564g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f5565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Runnable f5566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f5567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l0 f5568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f5569e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    @SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n*L\n1#1,18:1\n*E\n"})
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IoThreadWatchdog f5570c;

        public b(IoThreadWatchdog r10) {
            this.f5570c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IoThreadWatchdog.a(this.f5570c);
        }
    }

    @SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n*L\n1#1,18:1\n*E\n"})
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IoThreadWatchdog f5571c;

        public c(IoThreadWatchdog r10) {
            this.f5571c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IoThreadWatchdog.c(this.f5571c);
        }
    }

    static {
        new a(null);
        Duration.Companion r10 = Duration.Companion;
        DurationUnit r11 = DurationUnit.MINUTES;
        long r12 = DurationKt.toDuration(20, r11);
        DurationUnit r13 = DurationUnit.MILLISECONDS;
        f5563f = Duration.m1430toLongimpl(r12, r13);
        f5564g = Duration.m1430toLongimpl(DurationKt.toDuration(10, r11), r13);
    }

    public IoThreadWatchdog() {
        this.f5565a = new Handler(Looper.getMainLooper());
        this.f5566b = new b(this);
        this.f5567c = new c(this);
        this.f5568d = m0.a(z0.b());
        this.f5569e = LazyKt.lazy(IoThreadWatchdog$service$2.INSTANCE);
    }

    public static final /* synthetic */ void a(IoThreadWatchdog r10) {
        r10.d();
    }

    public static final /* synthetic */ void b(IoThreadWatchdog r10) {
        r10.g();
    }

    public static final /* synthetic */ void c(IoThreadWatchdog r10) {
        r10.i();
    }

    private final void d() {
        h();
        this.f5565a.postDelayed(this.f5566b, f5563f);
    }

    private final Class<? extends TriggerAnrService> e() {
        return (Class) this.f5569e.getValue();
    }

    private final void g() {
        this.f5565a.removeCallbacks(this.f5567c);
        AIKLog.INSTANCE.i("IoThreadWatchdog", "removeTriggerMsg");
    }

    private final void h() {
        AIKLog.INSTANCE.i("IoThreadWatchdog", "startCheck IoThread state");
        this.f5565a.postDelayed(this.f5567c, f5564g);
        h.d(this.f5568d, null, null, new IoThreadWatchdog$startCheck$1(this, null), 3, null);
    }

    private final void i() {
        int r10 = Process.myPid();
        AIKLog r11 = AIKLog.INSTANCE;
        r11.i("IoThreadWatchdog", "triggerIoThreadBlockingDump by " + r10);
        Context r12 = AppContext.INSTANCE.getContext();
        Class<? extends TriggerAnrService> r13 = e();
        if (r13 == null) goto L8;
        Intent r14 = new Intent(r12, r13);
        r14.putExtra("pid", r10);
        if (r12.startService(r14) != null) goto L9;
        r11.e("IoThreadWatchdog", "triggerIoThreadBlockingDump but " + Process.myProcessName() + " not configured!");
        return;
    L9:
        return;
    }

    public final void f() {
        this.f5565a.postDelayed(this.f5566b, f5563f);
    }
}
