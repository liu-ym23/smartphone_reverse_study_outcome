package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.bean.PromptContent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u implements Function1 {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ u(PromptCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        PromptContent.SuggestItem r4 = (PromptContent.SuggestItem) r3;
        i1 r0 = this.a.U;
        if (r0 == null) goto L6;
        r0.g(null, r4);
    L6:
        return Unit.INSTANCE;
    }
}
