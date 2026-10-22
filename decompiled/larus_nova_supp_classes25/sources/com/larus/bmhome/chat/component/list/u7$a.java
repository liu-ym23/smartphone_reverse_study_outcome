package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.im.bean.conversation.ForkType;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u7$a {
    public static /* synthetic */ void d(u7 r1) {
        r1.TP(false);
    }

    public static /* synthetic */ void a(u7 r1, boolean r2) {
        r1.vk(r2, new t7());
    }

    public static /* synthetic */ void b(u7 r2, String r3, ForkType r4, ReplyOption r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        r2.Ee(r3, r4, r5, null);
    }

    public static /* synthetic */ void c(u7 r12, wc9.e r13, Message r14, String r15, by7.e r16, boolean r17, String r18, long r19, String r21, int r22) {
        if ((r22 & 16) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r22 & 32) == 0) goto L9;
        String r8 = "";
    L11:
        if ((r22 & 128) == 0) goto L13;
        String r11 = null;
    L14:
        r12.g3(r13, r14, r15, r16, r7, r8, r19, r11);
        return;
    L13:
        r11 = r21;
        goto L14
    L9:
        r8 = r18;
        goto L11
    L5:
        r7 = r17;
        goto L7
    }
}
