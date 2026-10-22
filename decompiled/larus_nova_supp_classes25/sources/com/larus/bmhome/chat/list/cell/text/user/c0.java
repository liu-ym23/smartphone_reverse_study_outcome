package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c0 implements Function2 {
    public /* synthetic */ c0() {
    }

    public final Object invoke(Object r2, Object r3) {
        BotModel r4 = (BotModel) r2;
        BotModel r5 = (BotModel) r3;
        int r0 = UserTextCell.z;
        String r1 = null;
        if (r4 == null) goto L5;
        String r6 = r4.getBotId();
    L6:
        if (r5 == null) goto L9;
        r1 = r5.getBotId();
    L9:
        return Boolean.valueOf(Intrinsics.areEqual(r6, r1));
    L5:
        r6 = null;
        goto L6
    }
}
