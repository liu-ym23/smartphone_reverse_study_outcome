package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.WantListenInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w {
    public static final String a(MusicPanel r9) {
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L7;
        Boolean r1 = r0.isAnchor();
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        bb0.a r3 = bb0.b.a;
        long r4 = 0;
        if (r9 == null) goto L13;
        KtvMusic r5 = r9.a;
        if (r5 == null) goto L13;
        long r6 = r5.getMId();
    L14:
        bb0.a r7 = bb0.b.a;
        if (r7 == null) goto L17;
        boolean r8 = r7.i(r6);
    L18:
        if (r9 == null) goto L25;
        KtvMusic r11 = r9.a;
        if (r11 == null) goto L25;
        WantListenInfo r12 = r11.getWantListenInfo();
        if (r12 == null) goto L25;
        r4 = r12.getWantListenCount().longValue();
    L25:
        if (r4 <= 1) goto L30;
        if (r2 == true) goto L38;
        if (r8 == false) goto L38;
        return s1.C(2131918582, new Object[]{Long.valueOf(r4 - 1)});
    L38:
        return s1.C(2131918465, new Object[]{Long.valueOf(r4)});
    L30:
        if (r4 != 1) goto L35;
        if (r2 == true) goto L40;
        if (r8 == false) goto L40;
        return s1.B(2131918466);
    L40:
        return s1.C(2131918465, new Object[]{Long.valueOf(r4)});
    L35:
        return "";
    L17:
        r8 = false;
    L13:
        r6 = 0;
    L7:
        r2 = false;
        goto L8
    }
}
