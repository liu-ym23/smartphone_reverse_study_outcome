package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final kotlinx.coroutines.internal.i0 f10501a = null;

    static {
        f10501a = new kotlinx.coroutines.internal.i0("NO_VALUE");
    }

    public static final <T> f1<T> a(int r10, int r11, BufferOverflow r12) {
        boolean r13 = true;
        if (r10 < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L28;
        if (r11 < 0) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L26;
        if (r10 > 0) goto L17;
        if (r11 > 0) goto L17;
        if (r12 == BufferOverflow.SUSPEND) goto L17;
        r13 = false;
    L17:
        if (r13 == false) goto L24;
        int r16 = r11 + r10;
        if (r16 >= 0) goto L22;
        r16 = Integer.MAX_VALUE;
    L22:
        return new SharedFlowImpl(r10, r16, r12);
    L24:
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + r12).toString());
    L26:
        throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + r11).toString());
    L9:
        r15 = false;
        goto L10
    L28:
        throw new IllegalArgumentException(("replay cannot be negative, but was " + r10).toString());
    L5:
        r14 = false;
        goto L6
    }

    public static /* synthetic */ f1 b(int r10, int r11, BufferOverflow r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = BufferOverflow.SUSPEND;
    L12:
        return a(r10, r11, r12);
    }

    public static final /* synthetic */ Object c(Object[] r10, long r11) {
        return f(r10, r11);
    }

    public static final /* synthetic */ void d(Object[] r10, long r11, Object r12) {
        g(r10, r11, r12);
    }

    public static final <T> c<T> e(j1<? extends T> r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        if (r12 == 0) goto L6;
        if (r12 == (-3)) goto L6;
    L9:
        return new kotlinx.coroutines.flow.internal.f(r10, r11, r12, r13);
    L6:
        if (r13 != BufferOverflow.SUSPEND) goto L9;
        return r10;
    }

    private static final Object f(Object[] r10, long r11) {
        return r10[((int) r11) & (r10.length - 1)];
    }

    private static final void g(Object[] r10, long r11, Object r12) {
        r10[((int) r11) & (r10.length - 1)] = r12;
    }
}
