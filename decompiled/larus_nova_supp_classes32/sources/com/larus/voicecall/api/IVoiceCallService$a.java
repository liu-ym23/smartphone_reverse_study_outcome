package com.larus.voicecall.api;

import com.larus.im.bean.bot.BotModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class IVoiceCallService$a {
    public static /* synthetic */ boolean a(VoiceCallServiceDelegate r1, BotModel r2, String r3, boolean r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r4 = false;
    L6:
        return r1.x(r2, r3, r4, false);
    }
}
