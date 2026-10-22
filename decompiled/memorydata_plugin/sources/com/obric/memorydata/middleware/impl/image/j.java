package com.obric.memorydata.middleware.impl.image;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0086@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXUploadAwaiter;", "", "timeoutMs", "", "maxUploads", "", "<init>", "(JI)V", "slots", "Ljava/util/concurrent/Semaphore;", "upload", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", "create", "Lkotlin/Function0;", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadHandle;", "diagnostic", "Lkotlin/Function2;", "", "", "unusedCleanup", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Session", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f11737a = null;
    private static final ExecutorService d = null;
    private static final ExecutorService e = null;
    private static final ScheduledThreadPoolExecutor f = null;
    private static final Set<String> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11738b;
    private final Semaphore c;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\n \b*\u0004\u0018\u00010\u00070\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXUploadAwaiter$Companion;", "", "<init>", "()V", "WORKER_COUNT", "", "STARTS", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getSTARTS", "()Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ExecutorService;", "CLEANUPS", "getCLEANUPS", "DEADLINES", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "getDEADLINES", "()Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "LOCAL_CODES", "", "", "getLOCAL_CODES", "()Ljava/util/Set;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ExecutorService a() {
            return j.c();
        }

        public final ScheduledThreadPoolExecutor b() {
            return j.d();
        }

        public final Set<String> c() {
            return j.e();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00020\u0001B5\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0016\u001a\u00020\u0005J\"\u0010\u0017\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\bJ\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u001e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0002J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0005H\u0002R \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXUploadAwaiter$Session;", "", "diagnostic", "Lkotlin/Function2;", "", "", "deliver", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", "<init>", "(Lcom/obric/memorydata/middleware/impl/image/ImageXUploadAwaiter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "terminal", "Ljava/util/concurrent/atomic/AtomicReference;", "handle", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadHandle;", "deadline", "Ljava/util/concurrent/ScheduledFuture;", "cleanupStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "startDone", "cleanupDone", "released", "armDeadline", CommonConsts.APM_INNER_EVENT_COST_START, "create", "Lkotlin/Function0;", "unusedCleanup", "finish", "result", "requestCleanup", "sdkCleanup", "stage", "action", "report", "event", "code", "releaseIfDone", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f11739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function2<String, String, Unit> f11740b;
        private final Function1<com.obric.memorydata.middleware.impl.image.d, Unit> c;
        private final AtomicReference<com.obric.memorydata.middleware.impl.image.d> d;
        private final AtomicReference<l> e;
        private final AtomicReference<ScheduledFuture<?>> f;
        private final AtomicBoolean g;
        private final AtomicBoolean h;
        private final AtomicBoolean i;
        private final AtomicBoolean j;

        public b(j r3, Function2<? super String, ? super String, Unit> r4, Function1<? super com.obric.memorydata.middleware.impl.image.d, Unit> r5) {
            Function2<String, String, Unit> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            Function1<com.obric.memorydata.middleware.impl.image.d, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "diagnostic");
            Intrinsics.checkNotNullParameter(r7, "deliver");
            this.f11739a = r3;
            this.f11740b = r6;
            this.c = r7;
            this.d = new AtomicReference();
            this.e = new AtomicReference();
            this.f = new AtomicReference();
            this.g = new AtomicBoolean(false);
            this.h = new AtomicBoolean(false);
            this.i = new AtomicBoolean(false);
            this.j = new AtomicBoolean(false);
        }

        private static final Unit a(l r2) {
            ((l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.memorydata.plugin")).a();
            return Unit.INSTANCE;
        }

        private static final void a(b r7) {
            r7.a(new com.obric.memorydata.middleware.impl.image.d(null, null, "UPLOAD_TIMEOUT", 3, null));
        }

        private static final void a(b r6, com.obric.memorydata.middleware.impl.image.d r7, l r8) {
            final l r9 = (l) ZeusTransformUtils.wrapperContextForParams(r8, l.class, "com.obric.memorydata.plugin");
            String r3 = r7.c();     // Catch: Throwable -> L30
            boolean r4 = false;
            if (r3 != null) goto L6;
        L10:
            CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
            if (r5 != null) goto L13;
        L16:
            boolean r10 = true;
        L17:
            if (r10 == false) goto L19;
            r3 = "UPLOAD_SDK_FAILED";
        L20:
            r6.a("upload_terminal", r3);     // Catch: Throwable -> L30
            CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.a(), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
            if (r11 != null) goto L23;
        L24:
            r4 = true;
        L25:
            if (r4 == false) goto L27;
            r6.a(ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, new $$Lambda$j$b$p22q9BrZyXngb_lckbC_Bzc2pVA(r9));     // Catch: Throwable -> L30
        L27:
            r6.a(IslandSession.REOPEN_VALUE_CLOSE, new $$Lambda$j$b$p9wE1PcBYvTlmQV40C7pj0VCqsc(r9));     // Catch: Throwable -> L30
            r6.i.set(true);
            r6.c();
            return;
        L23:
            if (StringsKt.isBlank(r11) == false) goto L25;
        L19:
            r3 = "NONE";
            goto L20
        L13:
            if (StringsKt.isBlank(r5) == true) goto L16;
            r10 = false;
            goto L17
        L6:
            if (j.a().c().contains(r3) == true) goto L9;
            r3 = null;
        L9:
            if (r3 != null) goto L20;
        L30:
            th = move-exception;
            r6.i.set(true);
            r6.c();
            throw th;
        }

        private final void a(String r3, String r4) {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f11740b.invoke(r3, r4);     // Catch: Throwable -> L4
            Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
        }

        private final void a(String r4, Function0<Unit> r5) {
            Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            String r2 = "NONE";
            a("upload_" + r4 + "_start", "NONE");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Object r7 = Result.m1421constructorimpl(r6.invoke());     // Catch: Throwable -> L5
        L8:
            if (Result.m1428isSuccessimpl(r7) == true) goto L11;
            r2 = "UPLOAD_CLEANUP_FAILED";
        L11:
            a("upload_" + r4 + "_end", r2);
            return;
        L5:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L8
        }

        private static final Unit b(l r2) {
            ((l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.memorydata.plugin")).b();
            return Unit.INSTANCE;
        }

        private final void b() {
            final com.obric.memorydata.middleware.impl.image.d r0 = (com.obric.memorydata.middleware.impl.image.d) ZeusTransformUtils.preCheckCast(this.d.get(), com.obric.memorydata.middleware.impl.image.d.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            return;
        L5:
            final l r1 = (l) ZeusTransformUtils.preCheckCast(this.e.get(), l.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L9;
            return;
        L9:
            if (this.g.compareAndSet(false, true) == true) goto L11;
            return;
        L11:
            j.a().a().execute(new $$Lambda$j$b$_jvFdnV_QEQ3QszJIA3iAAUvysc(this, r0, r1));
        }

        private final void c() {
            if (this.h.get() == true) goto L5;
            return;
        L5:
            if (this.i.get() == true) goto L7;
            return;
        L7:
            if (this.j.compareAndSet(false, true) == false) goto L12;
            j.b(this.f11739a).release();
            return;
        }

        public static /* synthetic */ void lambda$BX1p0sf20fSQmV0pUJ3ZXIKRhFw(b r0) {
            a(r0);
        }

        public static /* synthetic */ void lambda$_jvFdnV_QEQ3QszJIA3iAAUvysc(b r0, com.obric.memorydata.middleware.impl.image.d r1, l r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ Unit lambda$p22q9BrZyXngb_lckbC_Bzc2pVA(l r0) {
            return a(r0);
        }

        public static /* synthetic */ Unit lambda$p9wE1PcBYvTlmQV40C7pj0VCqsc(l r0) {
            return b(r0);
        }

        public final void a() {
            ScheduledFuture<?> r0 = j.a().b().schedule(new $$Lambda$j$b$BX1p0sf20fSQmV0pUJ3ZXIKRhFw(this), j.a(this.f11739a), TimeUnit.MILLISECONDS);
            this.f.set(r0);
            if (this.d.get() == null) goto L6;
            r0.cancel(false);
            return;
        }

        public final void a(com.obric.memorydata.middleware.impl.image.d r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            if (this.d.compareAndSet(null, r4) == true) goto L5;
            return;
        L5:
            ScheduledFuture r0 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(this.f.get(), ScheduledFuture.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L8;
            r0.cancel(false);
        L8:
            this.c.invoke(r4);
            b();
        }

        public final void a(Function0<? extends l> r8, Function0<Unit> r9) {
            Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
            Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "create");
            Intrinsics.checkNotNullParameter(r11, "unusedCleanup");
        L33:
            th = move-exception;
            this.h.set(true);
            if (this.e.get() == null) goto L47;
        L41:
            b();
            c();
            throw th;
        L47:
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L38
            Result.m1421constructorimpl(r11.invoke());     // Catch: Throwable -> L38
        L40:
            this.i.set(true);
        L38:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L40
        L4:
            if (this.d.get() == null) goto L45;
            this.h.set(true);
            if (this.e.get() == null) goto L51;
        L12:
            b();
            c();
            return;
        L51:
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
            Result.m1421constructorimpl(r11.invoke());     // Catch: Throwable -> L9
        L11:
            this.i.set(true);
        L9:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L11
        L45:
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
            b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            r4.a("upload_start", "NONE");     // Catch: Throwable -> L19
            l r14 = (l) ZeusTransformUtils.preCheckCast(r10.invoke(), l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
            r4.e.set(r14);     // Catch: Throwable -> L19
            if (r4.d.get() != null) goto L17;
            r14.a((Function1) ZeusTransformUtils.preCheckCast(new ImageXUploadAwaiter$Session$start$1$1(r4), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        L17:
            Object r15 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L22:
            if (Result.m1424exceptionOrNullimpl(r15) == null) goto L24;
            a(new com.obric.memorydata.middleware.impl.image.d(null, null, "UPLOAD_SDK_START_FAILED", 3, null));     // Catch: Throwable -> L33
        L24:
            this.h.set(true);
            if (this.e.get() == null) goto L49;
        L31:
            b();
            c();
            return;
        L49:
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L28
            Result.m1421constructorimpl(r11.invoke());     // Catch: Throwable -> L28
        L30:
            this.i.set(true);
        L28:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
        L19:
            th = move-exception;
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L33
            r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
            goto L22
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class c implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11741a;

        c(b r1) {
            this.f11741a = r1;
        }

        public final void a(Throwable r7) {
            this.f11741a.a(new com.obric.memorydata.middleware.impl.image.d(null, null, "UPLOAD_CANCELLED", 3, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f11742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<l> f11743b;
        final /* synthetic */ Function0<Unit> c;

        d(b r3, Function0<? extends l> r4, Function0<Unit> r5) {
            Function0<l> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            this.f11742a = r3;
            this.f11743b = r6;
            this.c = r7;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f11742a.a(this.f11743b, this.c);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class e implements Function1<com.obric.memorydata.middleware.impl.image.d, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<com.obric.memorydata.middleware.impl.image.d> f11744a;

        e(n<? super com.obric.memorydata.middleware.impl.image.d> r3) {
            this.f11744a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
        }

        public final void a(com.obric.memorydata.middleware.impl.image.d r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            if (this.f11744a.a() == false) goto L6;
            Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this.f11744a, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r0 = Result.Companion;
            r2.resumeWith(Result.m1421constructorimpl(r3));
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.memorydata.middleware.impl.image.d r3) {
            a((com.obric.memorydata.middleware.impl.image.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.middleware.impl.image.d.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    static {
        f11737a = new a(null);
        d = Executors.newFixedThreadPool(2, $$Lambda$j$RT7FNVuv6XA6Db4GTq7FzWqYvEQ.INSTANCE);
        e = Executors.newFixedThreadPool(2, $$Lambda$j$zyGdEnBbrjesibjSToNhc6jliI.INSTANCE);
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(1, $$Lambda$j$49Vwqmq13ZSEKno_UFwPaSXfu9c.INSTANCE);
        r0.setRemoveOnCancelPolicy(true);
        f = r0;
        g = SetsKt.setOf(new String[]{"UPLOAD_TIMEOUT", "UPLOAD_CANCELLED", "UPLOAD_SDK_START_FAILED", "UPLOAD_AUTH_FAILED", "UPLOAD_EMPTY_RESULT", "UPLOAD_MISSING_RESULT"});
    }

    public j() {
        this(0, 0, 3, null);
    }

    public j(long r1, int r3) {
        this.f11738b = r1;
        this.c = new Semaphore(r3);
    }

    public /* synthetic */ j(long r3, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r3 = TimeUnit.MINUTES.toMillis(5);
    L6:
        if ((r6 & 2) == 0) goto L8;
        r5 = 2;
    L8:
        this(r3, r5);
    }

    public static final /* synthetic */ long a(j r2) {
        return r2.f11738b;
    }

    public static final /* synthetic */ a a() {
        return f11737a;
    }

    public static /* synthetic */ Object a(j r1, Function0 r2, Function2 r3, Function0 r4, Continuation r5, int r6, Object r7) {
        Function0<? extends l> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Function2<? super String, ? super String, Unit> r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Function0<Unit> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Continuation<? super com.obric.memorydata.middleware.impl.image.d> r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = $$Lambda$j$qUHBIGJfZB6pVjFszVdY99kfw8A.INSTANCE;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r10 = $$Lambda$j$zFmsvrZh6JCQBSbutfEwMKbHLY4.INSTANCE;
    L9:
        return r1.a(r8, r9, r10, r11);
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "ImageXUploadStart");
        r0.setDaemon(true);
        return r0;
    }

    private static final Unit a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<unused var>");
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        return Unit.INSTANCE;
    }

    private static final Thread b(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "ImageXUploadCleanup");
        r0.setDaemon(true);
        return r0;
    }

    public static final /* synthetic */ ExecutorService b() {
        return d;
    }

    public static final /* synthetic */ Semaphore b(j r0) {
        return r0.c;
    }

    private static final Thread c(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "ImageXUploadDeadline");
        r0.setDaemon(true);
        return r0;
    }

    public static final /* synthetic */ ExecutorService c() {
        return e;
    }

    public static final /* synthetic */ ScheduledThreadPoolExecutor d() {
        return f;
    }

    public static final /* synthetic */ Set e() {
        return g;
    }

    private static final Unit f() {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Thread lambda$49Vwqmq13ZSEKno_UFwPaSXfu9c(Runnable r0) {
        return c(r0);
    }

    public static /* synthetic */ Thread lambda$RT7FNVuv6XA6Db4GTq7FzWqYvEQ(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$qUHBIGJfZB6pVjFszVdY99kfw8A(String r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$zFmsvrZh6JCQBSbutfEwMKbHLY4() {
        return f();
    }

    /* JADX INFO: renamed from: lambda$zyGdEn-BbrjesibjSToNhc6jliI, reason: not valid java name */
    public static /* synthetic */ Thread m1019lambda$zyGdEnBbrjesibjSToNhc6jliI(Runnable r0) {
        return b(r0);
    }

    public final Object a(Function0<? extends l> r9, Function2<? super String, ? super String, Unit> r10, Function0<Unit> r11, Continuation<? super com.obric.memorydata.middleware.impl.image.d> r12) {
        Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        Function2 r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (this.c.tryAcquire() == false) goto L5;
        o r0 = new o(IntrinsicsKt.intercepted(r16), 1);
        r0.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        b r3 = new b(this, r14, (Function1) ZeusTransformUtils.preCheckCast(new e(r2), Function1.class, "com.obric.memorydata.plugin"));
        r2.a((Function1) ZeusTransformUtils.preCheckCast(new c(r3), Function1.class, "com.obric.memorydata.plugin"));
        r3.a();
        b().execute((Runnable) ZeusTransformUtils.preCheckCast(new d(r3, r13, r15), Runnable.class, "com.obric.memorydata.plugin"));
        Object r8 = r0.h();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r16);
    L9:
        return r8;
    L5:
        return new com.obric.memorydata.middleware.impl.image.d(null, null, "UPLOAD_BUSY", 3, null);
    }
}
