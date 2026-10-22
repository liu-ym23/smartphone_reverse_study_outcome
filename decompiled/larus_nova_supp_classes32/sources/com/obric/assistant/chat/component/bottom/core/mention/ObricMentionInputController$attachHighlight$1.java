package com.obric.assistant.chat.component.bottom.core.mention;

import com.obric.assistant.special_input.j;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricMentionInputController$attachHighlight$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    public ObricMentionInputController$attachHighlight$1(Object r8) {
        super(0, r8, ObricMentionInputController.class, "isMentionEnabled", "isMentionEnabled()Z", 0);
    }

    public final Boolean invoke() {
        ObricMentionInputController r0 = (ObricMentionInputController) ((CallableReference) this).receiver;
        int r1 = ObricMentionInputController.o;
        r0.getClass();
        if (com.obric.assistant.task.skill.f.d() == true) goto L5;
    L7:
        boolean r2 = false;
    L9:
        return Boolean.valueOf(r2);
    L5:
        if (j.b() == false) goto L7;
        r2 = true;
        goto L9
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m412invoke() {
        return invoke();
    }
}
