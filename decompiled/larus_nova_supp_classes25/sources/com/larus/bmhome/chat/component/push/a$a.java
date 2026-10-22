package com.larus.bmhome.chat.component.push;

import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.OpenPushReminderScene;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a$a {
    public static /* synthetic */ void a(a r8, OpenPushReminderScene r9, e r10, BotModel r11, Map r12, Function1 r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        e r4 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        BotModel r5 = null;
    L11:
        if ((r14 & 8) == 0) goto L13;
        Map r6 = null;
    L15:
        if ((r14 & 16) == 0) goto L17;
        Function1 r7 = null;
    L18:
        r8.dK(r9, r4, r5, r6, r7);
        return;
    L17:
        r7 = r13;
        goto L18
    L13:
        r6 = r12;
        goto L15
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
