package com.obric.assistant.chat.component.bottom.core.mention;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricMentionInputController$attachHighlight$4 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public ObricMentionInputController$attachHighlight$4(Object r8) {
        super(1, r8, ObricMentionInputController.class, "onRemoveSelectedMention", "onRemoveSelectedMention(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        ObricMentionInputController r0 = (ObricMentionInputController) ((CallableReference) this).receiver;
        paa.c r1 = r0.c;
        if (r1 == null) goto L5;
        r1.Zu(r3);
    L5:
        paa.c r2 = r0.c;
        if (r2 == null) goto L8;
        r2.Kz(r3);
    L8:
        r0.g();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
