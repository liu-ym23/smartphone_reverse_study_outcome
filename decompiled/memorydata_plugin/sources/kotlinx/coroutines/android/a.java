package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.ci;
import kotlinx.coroutines.cl;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u001c\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010 \u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", ActivityLifecycle.NAME, "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "cancelOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f17214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17215b;
    private final boolean c;
    private final a d;

    /* JADX INFO: renamed from: kotlinx.coroutines.android.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class RunnableC0878a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f17216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f17217b;

        public RunnableC0878a(n r3, a r4) {
            this.f17216a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin");
            this.f17217b = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f17216a.a((ah) ZeusTransformUtils.preCheckCast(this.f17217b, ah.class, "com.obric.memorydata.plugin"), Unit.INSTANCE);
        }
    }

    public a(Handler r2, String r3) {
        this(r2, r3, false);
    }

    public /* synthetic */ a(Handler r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    private a(Handler r2, String r3, boolean r4) {
        super(null);
        this.f17214a = r2;
        this.f17215b = r3;
        this.c = r4;
        if (r4 == false) goto L5;
        a r5 = this;
    L6:
        this.d = r5;
        return;
    L5:
        r5 = new a(r2, r3, true);
        goto L6
    }

    public static final /* synthetic */ Handler a(a r0) {
        return r0.f17214a;
    }

    private final void a(CoroutineContext r4, Runnable r5) {
        CoroutineContext r6 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        ca.a(r6, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        ba.c().dispatch(r6, r7);
    }

    private static final void a(a r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        r2.f17214a.removeCallbacks(r4);
    }

    public static /* synthetic */ void lambda$aSUn0RfXBNndDCKFY7g1QWDaJsM(a r0, Runnable r1) {
        a(r0, r1);
    }

    @Override // kotlinx.coroutines.android.b, kotlinx.coroutines.at
    public bc a(long r5, Runnable r7, CoroutineContext r8) {
        final Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
        CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r8, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (this.f17214a.postDelayed(r9, RangesKt.coerceAtMost(r5, DurationKt.MAX_MILLIS)) == true) goto L5;
        a(r10, r9);
        return (bc) ZeusTransformUtils.preCheckCast(cl.f17297a, bc.class, "com.obric.memorydata.plugin");
    L5:
        return new $$Lambda$a$aSUn0RfXBNndDCKFY7g1QWDaJsM(this, r9);
    }

    @Override // kotlinx.coroutines.ci
    public /* synthetic */ ci a() {
        return (ci) ZeusTransformUtils.preCheckCast(c(), ci.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.at
    public void a(long r6, n<? super Unit> r8) {
        n r9 = (n) ZeusTransformUtils.wrapperContextForParams(r8, n.class, "com.obric.memorydata.plugin");
        final Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(new RunnableC0878a(r9, this), Runnable.class, "com.obric.memorydata.plugin");
        if (this.f17214a.postDelayed(r0, RangesKt.coerceAtMost(r6, DurationKt.MAX_MILLIS)) == false) goto L5;
        r9.a((Function1) ZeusTransformUtils.preCheckCast(new HandlerContext$scheduleResumeAfterDelay$1(this, r0), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        a(r9.getContext(), r0);
    }

    public a c() {
        return this.d;
    }

    @Override // kotlinx.coroutines.ah
    public void dispatch(CoroutineContext r3, Runnable r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (this.f17214a.post(r6) == true) goto L6;
        a(r5, r6);
        return;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).f17214a != this.f17214a) goto L9;
        if (((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).c != this.c) goto L9;
        return true;
    }

    public int hashCode() {
        int r0 = System.identityHashCode(this.f17214a);
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r1 ^ r0;
    L5:
        r1 = 1237;
        goto L7
    }

    @Override // kotlinx.coroutines.ah
    public boolean isDispatchNeeded(CoroutineContext r3) {
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (this.c == true) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), this.f17214a.getLooper()) == false) goto L8;
        return false;
    }

    @Override // kotlinx.coroutines.ci, kotlinx.coroutines.ah
    public String toString() {
        String r0 = b();
        if (r0 != null) goto L11;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        String r1 = r2.f17215b;
        if (r1 != null) goto L8;
        r1 = r2.f17214a.toString();
    L8:
        if (r2.c == true) goto L10;
        return r1;
    L10:
        return r1 + ".immediate";
    L11:
        return r0;
    }
}
