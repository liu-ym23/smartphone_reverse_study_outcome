package com.larus.bmhome.chat.list.cell.prompt;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function0 {
    public final /* synthetic */ PromptCell a;

    public /* synthetic */ i(PromptCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        PromptCell r0 = this.a;
        Keva r1 = PromptCell.Y;
        return lf8.a.a(r0, ICoreInputAbility.class);
    }
}
