package com.obric.assistant.settings.memory;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricReferenceMemorySettingFragment$handleSwitchChanged$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public ObricReferenceMemorySettingFragment$handleSwitchChanged$2(Object r8) {
        super(1, r8, ObricReferenceMemorySettingFragment.class, "handleSwitchResult", "handleSwitchResult(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r2) {
        ObricReferenceMemorySettingFragment.U90((ObricReferenceMemorySettingFragment) ((CallableReference) this).receiver, r2);
    }
}
