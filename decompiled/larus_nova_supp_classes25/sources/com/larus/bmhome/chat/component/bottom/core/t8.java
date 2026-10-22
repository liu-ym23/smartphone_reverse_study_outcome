package com.larus.bmhome.chat.component.bottom.core;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t8 implements Function0 {
    public final /* synthetic */ com.larus.bmhome.actionbar.model.z0 a;
    public final /* synthetic */ BotModel b;
    public final /* synthetic */ wc9.e c;

    public /* synthetic */ t8(com.larus.bmhome.actionbar.model.z0 r1, BotModel r2, wc9.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        return CoreInputViewModel.sp(this.a, this.b, this.c);
    }
}
