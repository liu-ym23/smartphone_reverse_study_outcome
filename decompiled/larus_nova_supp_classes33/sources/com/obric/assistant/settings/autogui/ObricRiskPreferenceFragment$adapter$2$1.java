package com.obric.assistant.settings.autogui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricRiskPreferenceFragment$adapter$2$1 extends FunctionReferenceImpl implements Function1<u0, Unit> {
    public ObricRiskPreferenceFragment$adapter$2$1(Object r8) {
        super(1, r8, ObricRiskPreferenceViewModel.class, "onRiskPreferenceSelected", "onRiskPreferenceSelected(Lcom/obric/assistant/settings/autogui/RiskPreferenceItemUiModel;)V", 0);
    }

    public final void invoke(u0 r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((ObricRiskPreferenceViewModel) ((CallableReference) this).receiver).onRiskPreferenceSelected(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((u0) r1);
        return Unit.INSTANCE;
    }
}
