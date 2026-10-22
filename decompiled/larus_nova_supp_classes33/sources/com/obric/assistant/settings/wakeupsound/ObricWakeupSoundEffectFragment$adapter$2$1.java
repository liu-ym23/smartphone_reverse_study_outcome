package com.obric.assistant.settings.wakeupsound;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricWakeupSoundEffectFragment$adapter$2$1 extends FunctionReferenceImpl implements Function1<g, Unit> {
    public ObricWakeupSoundEffectFragment$adapter$2$1(Object r8) {
        super(1, r8, ObricWakeupSoundEffectViewModel.class, "onWakeupSoundEffectSelected", "onWakeupSoundEffectSelected(Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectItemUiModel;)V", 0);
    }

    public final void invoke(g r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((ObricWakeupSoundEffectViewModel) ((CallableReference) this).receiver).onWakeupSoundEffectSelected(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((g) r1);
        return Unit.INSTANCE;
    }
}
