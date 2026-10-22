package com.larus.utils;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.service.BotChangeType;
import com.larus.im.service.y;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c0 implements y {
    public c0() {
    }

    public final void a(List<BotModel> r2, BotChangeType r3) {
        Intrinsics.checkNotNullParameter(r2, "changedBots");
        Intrinsics.checkNotNullParameter(r3, "changeType");
        BotModel r4 = (BotModel) CollectionsKt.getOrNull(r2, 0);
        if (r4 == null) goto L6;
        MainBotInfoUtil.a = r4;
        return;
    }
}
