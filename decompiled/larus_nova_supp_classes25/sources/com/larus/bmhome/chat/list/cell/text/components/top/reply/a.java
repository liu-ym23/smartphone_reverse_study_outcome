package com.larus.bmhome.chat.list.cell.text.components.top.reply;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.manager.l0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import dg8.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements tg8.b {
    public a() {
    }

    public final boolean c(t1a.b r3, Message r4, q0 r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Integer r6 = null;
        if (r3 == null) goto L5;
        y r7 = (y) r3.getAbility(y.class);
    L6:
        int r0 = l0.a;
        BotModel r1 = t.d(r7);
        if (r1 == null) goto L10;
        r6 = r1.getBotType();
    L10:
        if (l0.a(r6) == true) goto L22;
        BotModel r8 = t.d(r7);
        if (r8 != null) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == true) goto L22;
        if (com.larus.bmhome.chat.bean.d.G0(r4) == false) goto L22;
        return false;
    L14:
        if (ce8.a.b(r8) != true) goto L16;
        r9 = true;
    L22:
        if (com.larus.bmhome.chat.bean.d.b1(r4) != null) goto L24;
        return false;
    L24:
        return true;
    L5:
        r7 = null;
        goto L6
    }
}
