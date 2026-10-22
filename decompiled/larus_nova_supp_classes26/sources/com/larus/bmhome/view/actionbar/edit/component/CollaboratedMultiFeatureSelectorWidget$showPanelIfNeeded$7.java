package com.larus.bmhome.view.actionbar.edit.component;

import com.larus.commercemembership.api.ICommerceMembershipService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$7 extends FunctionReferenceImpl implements Function1<k0, Unit> {
    public CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$7(Object r8) {
        super(1, r8, CollaboratedMultiFeatureSelectorWidget.class, "reportSubscribeGuidanceShow", "reportSubscribeGuidanceShow(Lcom/larus/bmhome/view/actionbar/edit/component/CollaboratedParamSubscribeRequest;)V", 0);
    }

    public final void invoke(k0 r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        CollaboratedMultiFeatureSelectorWidget r0 = (CollaboratedMultiFeatureSelectorWidget) ((CallableReference) this).receiver;
        t1 r1 = CollaboratedMultiFeatureSelectorWidget.o;
        r0.getClass();
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r2 = ICommerceMembershipService.a.a();
        if (r2 == null) goto L6;
        r2.s(r3.c, null);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((k0) r1);
        return Unit.INSTANCE;
    }
}
