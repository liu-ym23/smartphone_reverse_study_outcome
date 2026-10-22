package kotlin;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class UShortArrayKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    private static final short[] UShortArray(int r10, Function1<? super Integer, UShort> r11) {
        Intrinsics.checkNotNullParameter(r11, CommonConsts.APM_INNER_EVENT_COST_INIT);
        short[] r12 = new short[r10];
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L6;
        r12[r13] = r11.invoke(Integer.valueOf(r13)).m363unboximpl();
        r13 = r13 + 1;
        goto L3
    L6:
        return UShortArray.m366constructorimpl(r12);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* JADX INFO: renamed from: ushortArrayOf-rL5Bavg, reason: not valid java name */
    private static final short[] m382ushortArrayOfrL5Bavg(short... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        return r10;
    }
}
