package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.ci;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class aa extends ci implements kotlinx.coroutines.at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Throwable f17554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17555b;

    public aa(Throwable r1, String r2) {
        this.f17554a = r1;
        this.f17555b = r2;
    }

    private final Void c() {
        if (this.f17554a == null) goto L11;
        StringBuilder r0 = new StringBuilder().append("Module with the Main dispatcher had failed to initialize");
        String r1 = this.f17555b;
        if (r1 == null) goto L8;
        String r2 = ". " + r1;
        if (r2 == null) goto L8;
    L10:
        throw new IllegalStateException(r0.append(r2).toString(), this.f17554a);
    L8:
        r2 = "";
        goto L10
    L11:
        z.a();
        throw new KotlinNothingValueException();
    }

    public Void a(CoroutineContext r3, Runnable r4) {
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.at
    public bc a(long r1, Runnable r3, CoroutineContext r4) {
        Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        CoroutineContext r5 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.ci
    public ci a() {
        return (ci) ZeusTransformUtils.preCheckCast(this, ci.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.at
    public /* synthetic */ void a(long r3, kotlinx.coroutines.n r5) {
        b(r3, (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"));
    }

    public Void b(long r1, kotlinx.coroutines.n<? super Unit> r3) {
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.ah
    public /* synthetic */ void dispatch(CoroutineContext r3, Runnable r4) {
        a((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin"), (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.ah
    public boolean isDispatchNeeded(CoroutineContext r3) {
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin");
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.ci, kotlinx.coroutines.ah
    public kotlinx.coroutines.ah limitedParallelism(int r1) {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.ci, kotlinx.coroutines.ah
    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Dispatchers.Main[missing");
        if (this.f17554a == null) goto L5;
        String r3 = ", cause=" + this.f17554a;
    L7:
        return r0.append(r3).append(']').toString();
    L5:
        r3 = "";
        goto L7
    }
}
