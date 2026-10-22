package com.obric.assistant.settings.experience;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricUserExperiencePlanFragment$bindSwitches$1$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public ObricUserExperiencePlanFragment$bindSwitches$1$1(Object r8) {
        super(1, r8, ObricUserExperiencePlanFragment.class, "updateAll", "updateAll(Z)V", 0);
    }

    public final void invoke(boolean r9) {
        ObricUserExperiencePlanFragment r0 = (ObricUserExperiencePlanFragment) ((CallableReference) this).receiver;
        int r1 = ObricUserExperiencePlanFragment.j;
        r0.getClass();
        ObricUserExperiencePlanManager r2 = ObricUserExperiencePlanManager.a;
        r0.X90(ObricUserExperiencePlanManager.a.a(ObricUserExperiencePlanManager.b(), r9, r9, 4));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0.getViewLifecycleOwner()), null, null, new ObricUserExperiencePlanFragment$updateAll$1(r9, r0, null), 3, null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
