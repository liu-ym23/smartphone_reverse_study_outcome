package kotlinx.coroutines.flow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J'\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\r2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "()V", "cont", "Lkotlin/coroutines/Continuation;", "", "index", "", "allocateLocked", "", "flow", "freeLocked", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;)[Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class al extends kotlinx.coroutines.flow.internal.c<aj<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Continuation<? super Unit> f17419b;

    public al() {
        this.f17418a = -1;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* synthetic */ boolean a(aj<?> r3) {
        return a2((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(aj<?> r5) {
        if (this.f17418a < 0) goto L6;
        return false;
    L6:
        this.f17418a = r5.e();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* synthetic */ Continuation[] b(aj<?> r3) {
        return b2((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public Continuation<Unit>[] b2(aj<?> r5) {
        if (kotlinx.coroutines.an.a() == true) goto L5;
    L12:
        long r0 = this.f17418a;
        this.f17418a = -1;
        this.f17419b = null;
        return r5.a(r0);
    L5:
        if (this.f17418a < 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }
}
