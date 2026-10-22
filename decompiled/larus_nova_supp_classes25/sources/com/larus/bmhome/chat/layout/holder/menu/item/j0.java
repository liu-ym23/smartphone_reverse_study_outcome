package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.im.bean.bot.AnswerAction;
import com.larus.platform.service.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j0 {
    public static com.larus.bmhome.view.screenmenu.l0 a(AnswerAction r42) {
        Integer r0 = z2.a.attachmentEditConfig().getReplaceQuoteText();
        if (r0 != null) goto L6;
    L8:
        int r2 = 2131909189;
    L10:
        if (r42 == null) goto L12;
        String r3 = r42.getName();
    L14:
        return new com.larus.bmhome.view.screenmenu.l0(2131907406, r2, r3, null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971804, null, 2131241851)), null, false, false, null, null, "cite", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528392, 127);
    L12:
        r3 = null;
        goto L14
    L6:
        if (r0.intValue() != 1) goto L8;
        r2 = 2131907183;
        goto L10
    }
}
