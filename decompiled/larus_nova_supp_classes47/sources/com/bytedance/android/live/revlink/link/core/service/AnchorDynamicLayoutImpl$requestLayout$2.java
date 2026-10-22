package com.bytedance.android.live.revlink.link.core.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class AnchorDynamicLayoutImpl$requestLayout$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public AnchorDynamicLayoutImpl$requestLayout$2(AnchorDynamicLayoutImpl r8) {
        super(1, r8, AnchorDynamicLayoutImpl.class, "onSnapShotRefreshFailed", "onSnapShotRefreshFailed(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        AnchorDynamicLayoutImpl r0 = (AnchorDynamicLayoutImpl) ((CallableReference) this).receiver;
        int r1 = AnchorDynamicLayoutImpl.g;
        r0.getClass();
        jy0.b.c("RevenueDynamicLayoutClient", "requestLayout fail for snapshot no change with reason: " + r4, null, 4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
