package com.obric.assistant.settings.autogui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricAutoExecuteAuthFragment$adapter$2$1 extends FunctionReferenceImpl implements Function2<a, Boolean, Unit> {
    public ObricAutoExecuteAuthFragment$adapter$2$1(Object r8) {
        super(2, r8, ObricAutoExecuteAuthViewModel.class, "onAuthorizationCheckedChanged", "onAuthorizationCheckedChanged(Lcom/obric/assistant/settings/autogui/AuthorizationItem;Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((a) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((ObricAutoExecuteAuthViewModel) ((CallableReference) this).receiver).onAuthorizationCheckedChanged(r2, r3);
    }
}
