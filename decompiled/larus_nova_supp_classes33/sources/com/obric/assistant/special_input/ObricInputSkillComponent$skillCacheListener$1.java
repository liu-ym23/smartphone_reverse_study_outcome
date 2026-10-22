package com.obric.assistant.special_input;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricInputSkillComponent$skillCacheListener$1 extends FunctionReferenceImpl implements Function1<s0, Unit> {
    public ObricInputSkillComponent$skillCacheListener$1(Object r8) {
        super(1, r8, ObricInputSkillComponent.class, "refreshSkillListFromCache", "refreshSkillListFromCache(Lcom/obric/assistant/special_input/SkillCacheSnapshot;)V", 0);
    }

    public final void invoke(s0 r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ObricInputSkillComponent r0 = (ObricInputSkillComponent) ((CallableReference) this).receiver;
        int r1 = ObricInputSkillComponent.w;
        r0.Y2(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((s0) r1);
        return Unit.INSTANCE;
    }
}
