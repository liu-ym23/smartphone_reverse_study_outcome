package kotlin;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"UIntArray", "Lkotlin/UIntArray;", "size", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "Lkotlin/Function1;", "Lkotlin/UInt;", "(ILkotlin/jvm/functions/Function1;)[I", "uintArrayOf", "elements", "uintArrayOf--ajY-9A", "([I)[I", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UIntArrayKt {
    private static final int[] UIntArray(int r5, Function1<? super Integer, UInt> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, CommonConsts.APM_INNER_EVENT_COST_INIT);
        int[] r0 = new int[r5];
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L6;
        r0[r2] = ((UInt) ZeusTransformUtils.preCheckCast(r7.invoke(Integer.valueOf(r2)), UInt.class, "com.obric.memorydata.plugin")).m1568unboximpl();
        r2 = r2 + 1;
        goto L3
    L6:
        return UIntArray.m1571constructorimpl(r0);
    }

    /* JADX INFO: renamed from: uintArrayOf--ajY-9A, reason: not valid java name */
    private static final int[] m1587uintArrayOfajY9A(int... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        return r1;
    }
}
