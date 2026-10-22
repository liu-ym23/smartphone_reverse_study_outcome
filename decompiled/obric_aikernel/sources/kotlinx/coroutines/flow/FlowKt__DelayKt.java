package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n1#2:416\n*E\n"})
final /* synthetic */ class FlowKt__DelayKt {
    public static final ReceiveChannel<Unit> a(kotlinx.coroutines.l0 r10, long r11, long r13) {
        boolean r12 = true;
        if (r11 < 0) goto L5;
        boolean r14 = true;
    L7:
        if (r14 == false) goto L18;
        if (r13 >= 0) goto L12;
        r12 = false;
    L12:
        if (r12 == false) goto L16;
        return ProduceKt.d(r10, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(r13, r11, null), 1, null);
    L16:
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + r13 + " ms").toString());
    L18:
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + r11 + " ms").toString());
    L5:
        r14 = false;
        goto L7
    }

    public static /* synthetic */ ReceiveChannel b(kotlinx.coroutines.l0 r10, long r11, long r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r11;
    L6:
        return e.t(r10, r11, r12);
    }
}
