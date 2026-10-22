package com.larus.bmhome.chat.component.bottom.core;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b8 implements Function1 {
    public final /* synthetic */ BotModel a;
    public final /* synthetic */ int b;

    public /* synthetic */ b8(BotModel r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return CoreInputViewModel.ep(this.a, this.b, (CoreInputComponentState) r3);
    }
}
