package com.larus.bmhome.chat.standarduikit.vlm.view;

import com.larus.utils.y;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class VLMContainerView$bindData$1$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public VLMContainerView$bindData$1$2(Object r8) {
        super(1, r8, VLMContainerView.class, "onUserScrollImage", "onUserScrollImage(I)V", 0);
    }

    public final void invoke(int r5) {
        final VLMContainerView r0 = (VLMContainerView) ((CallableReference) this).receiver;
        int r1 = VLMContainerView.k;
        Map<Integer, Integer> r2 = r0.y();
        LinkedHashMap r3 = (LinkedHashMap) r2;
        final Integer r6 = (Integer) r3.get(Integer.valueOf(r5));
        if (r6 == null) goto L6;
        r6.intValue();
        SoftReference r4 = y.a;
        Runnable r7 = new f(r0, r6);
        Intrinsics.checkNotNullParameter(r7, "action");
        y.d(r7, 200);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
