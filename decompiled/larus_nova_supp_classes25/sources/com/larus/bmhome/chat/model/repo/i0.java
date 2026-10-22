package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i0 implements Function1 {
    public final /* synthetic */ BotModel a;

    public /* synthetic */ i0(BotModel r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        BotModel r0 = this.a;
        int r1 = BotRepo.g;
        Intrinsics.checkNotNullParameter((BotModel) r3, "$this$updateLocalBot");
        return r0;
    }
}
