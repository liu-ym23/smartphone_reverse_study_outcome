package com.obric.assistant.chat.component.bottom.core.mention;

import com.obric.assistant.ability.chat.input.SkillSelectSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricMentionInputController$attachHighlight$3 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public ObricMentionInputController$attachHighlight$3(Object r8) {
        super(1, r8, ObricMentionInputController.class, "onSelectMention", "onSelectMention(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        ObricMentionInputController r0 = (ObricMentionInputController) ((CallableReference) this).receiver;
        paa.c r1 = r0.c;
        if (r1 == null) goto L5;
        r1.YW(r4, SkillSelectSource.MENTION);
    L5:
        r0.g();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
