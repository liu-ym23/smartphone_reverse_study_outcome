package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputMentionPanelController;
import com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x5 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ x5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        ReplyOption r3 = (ReplyOption) r2;
        ChatInputMentionPanelController r4 = this.a.k1;
        if (r4 == null) goto L8;
        MultiTypeMentionPanelController r5 = r4.g;
        if (r5 == null) goto L8;
        r5.m();
    L8:
        return Unit.INSTANCE;
    }
}
