package com.larus.bmhome.chat.component.bottom.core;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class y6 implements Function2 {
    public /* synthetic */ y6() {
    }

    public final Object invoke(Object r4, Object r5) {
        BotModel r6 = (BotModel) r4;
        BotModel r7 = (BotModel) r5;
        int r0 = CoreInputComponent.d3;
        Boolean r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.getBotId();
    L6:
        if (r7 == null) goto L8;
        String r3 = r7.getBotId();
    L10:
        if (Intrinsics.areEqual(r2, r3) == false) goto L19;
        if (r6 == null) goto L13;
        Boolean r8 = Boolean.valueOf(r6.getDisabled());
    L14:
        if (r7 == null) goto L17;
        r1 = Boolean.valueOf(r7.getDisabled());
    L17:
        if (Intrinsics.areEqual(r8, r1) == false) goto L19;
        boolean r9 = true;
    L21:
        return Boolean.valueOf(r9);
    L13:
        r8 = null;
    L19:
        r9 = false;
        goto L21
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
