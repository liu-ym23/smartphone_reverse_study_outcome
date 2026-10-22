package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,428:1\n1#2:429\n*E\n"})
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.i0 f10509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.i0 f10510b = null;

    static {
        f10509a = new kotlinx.coroutines.internal.i0("NONE");
        f10510b = new kotlinx.coroutines.internal.i0("PENDING");
    }

    public static final <T> g1<T> a(T r10) {
        if (r10 != null) goto L6;
        r10 = (T) kotlinx.coroutines.flow.internal.n.f10495a;
    L6:
        return new StateFlowImpl(r10);
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.i0 b() {
        return f10509a;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.i0 c() {
        return f10510b;
    }

    public static final <T> c<T> d(p1<? extends T> r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        boolean r14 = true;
        if (kotlinx.coroutines.n0.a() == true) goto L5;
    L12:
        if (r12 >= 0) goto L14;
    L16:
        r14 = false;
    L17:
        if (r14 == true) goto L21;
        if (r12 == (-2)) goto L21;
    L24:
        return k1.e(r10, r11, r12, r13);
    L21:
        if (r13 != BufferOverflow.DROP_OLDEST) goto L24;
        return r10;
    L14:
        if (r12 >= 2) goto L16;
    L5:
        if (r12 == (-1)) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == true) goto L12;
        throw new AssertionError();
    L7:
        r15 = false;
        goto L8
    }
}
