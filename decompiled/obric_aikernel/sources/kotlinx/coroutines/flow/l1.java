package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
public final class l1 extends kotlinx.coroutines.flow.internal.c<SharedFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public long f10502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public Continuation<? super Unit> f10503b;

    public l1() {
        this.f10502a = -1;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* bridge */ /* synthetic */ boolean a(SharedFlowImpl<?> r10) {
        return c(r10);
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* bridge */ /* synthetic */ Continuation[] b(SharedFlowImpl<?> r10) {
        return d(r10);
    }

    public boolean c(SharedFlowImpl<?> r10) {
        if (this.f10502a < 0) goto L6;
        return false;
    L6:
        this.f10502a = r10.X();
        return true;
    }

    public Continuation<Unit>[] d(SharedFlowImpl<?> r10) {
        if (kotlinx.coroutines.n0.a() == true) goto L5;
    L12:
        long r11 = this.f10502a;
        this.f10502a = -1;
        this.f10503b = null;
        return r10.W(r11);
    L5:
        if (this.f10502a < 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L12;
        throw new AssertionError();
    L7:
        r12 = false;
        goto L8
    }
}
