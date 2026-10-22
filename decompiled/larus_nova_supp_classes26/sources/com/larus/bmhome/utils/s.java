package com.larus.bmhome.utils;

import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s {
    static {
    }

    public static String a(BotModel r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        Integer r1 = r4.getBotType();
    L6:
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
    L22:
        return "other_default";
    L14:
        if (r1.intValue() != 0) goto L22;
        BotCreatorInfo r5 = r4.getBotCreatorInfo();
        if (r5 == null) goto L19;
        r0 = r5.getId();
    L19:
        if (Intrinsics.areEqual(r0, AccountService.a.getUserId()) == false) goto L21;
        return "self_created";
    L21:
        return "others_created";
    L9:
        if (r1.intValue() != 1) goto L11;
        return "default";
    L5:
        r1 = null;
        goto L6
    }
}
