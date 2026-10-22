package com.larus.bmhome.view.actionbar.edit.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$4 extends FunctionReferenceImpl implements Function4<com.larus.bmhome.actionbar.model.h, com.larus.bmhome.actionbar.model.w, Integer, String, Unit> {
    public CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$4(Object r8) {
        super(4, r8, CollaboratedMultiFeatureSelectorWidget.class, "reportDropdownOptionClick", "reportDropdownOptionClick(Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;ILjava/lang/String;)V", 0);
    }

    public final void invoke(com.larus.bmhome.actionbar.model.h r2, com.larus.bmhome.actionbar.model.w r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        Intrinsics.checkNotNullParameter(r5, "p3");
        CollaboratedMultiFeatureSelectorWidget.s6((CollaboratedMultiFeatureSelectorWidget) ((CallableReference) this).receiver, r2, r3, r4, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((com.larus.bmhome.actionbar.model.h) r1, (com.larus.bmhome.actionbar.model.w) r2, ((Number) r3).intValue(), (String) r4);
        return Unit.INSTANCE;
    }
}
