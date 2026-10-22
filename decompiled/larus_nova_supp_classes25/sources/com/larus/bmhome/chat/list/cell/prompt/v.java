package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v implements Function0 {
    public final /* synthetic */ PromptCell a;
    public final /* synthetic */ Message b;

    public /* synthetic */ v(PromptCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        PromptCell r0 = this.a;
        Message r1 = this.b;
        if (r0.u == false) goto L17;
        if (Intrinsics.areEqual(r0.v, r1.getLocalMessageId()) == false) goto L17;
        if (r0.D().f == true) goto L17;
        PromptSpan r2 = r0.e;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("span");
        r2 = null;
    L12:
        if (r2.isShown() == false) goto L17;
        u7 r3 = r0.B();
        if (r3 == null) goto L17;
        r3.O5(false);
    L17:
        return Unit.INSTANCE;
    }
}
