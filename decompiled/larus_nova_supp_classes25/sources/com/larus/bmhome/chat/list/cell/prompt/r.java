package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ PromptCell b;

    public /* synthetic */ r(Message r1, PromptCell r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        Message r0 = this.a;
        PromptCell r1 = this.b;
        String r5 = (String) r4;
        Keva r2 = PromptCell.Y;
        if (com.larus.bmhome.chat.bean.d.z0(r0) == true) goto L5;
    L6:
        fx9.a r6 = r1.C();
        if (r6 == null) goto L10;
        r6.pi();
    L10:
        return Unit.INSTANCE;
    L5:
        if (Intrinsics.areEqual(r5, PromptContent.SuggestItemType.Text.getValue()) == false) goto L10;
        goto L6
    }
}
