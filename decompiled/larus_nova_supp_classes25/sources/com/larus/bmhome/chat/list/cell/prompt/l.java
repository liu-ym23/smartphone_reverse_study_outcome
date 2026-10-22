package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.ChatParam;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Function0 {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ l(PromptCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        PromptCell r0 = this.a;
        Keva r1 = PromptCell.Y;
        return (ChatParam) lf8.a.c(r0, ChatParam.class);
    }
}
