package kotlin;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"ULongArray", "Lkotlin/ULongArray;", "size", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "Lkotlin/Function1;", "Lkotlin/ULong;", "(ILkotlin/jvm/functions/Function1;)[J", "ulongArrayOf", "elements", "ulongArrayOf-QwZRm1k", "([J)[J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ULongArrayKt {
    private static final long[] ULongArray(int r5, Function1<? super Integer, ULong> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, CommonConsts.APM_INNER_EVENT_COST_INIT);
        long[] r0 = new long[r5];
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L6;
        r0[r2] = ((ULong) ZeusTransformUtils.preCheckCast(r7.invoke(Integer.valueOf(r2)), ULong.class, "com.obric.memorydata.plugin")).m1647unboximpl();
        r2 = r2 + 1;
        goto L3
    L6:
        return ULongArray.m1650constructorimpl(r0);
    }

    /* JADX INFO: renamed from: ulongArrayOf-QwZRm1k, reason: not valid java name */
    private static final long[] m1666ulongArrayOfQwZRm1k(long... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        return r1;
    }
}
