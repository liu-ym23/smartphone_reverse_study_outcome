package com.larus.bmhome.chat.component.servicebot;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m implements y.a<BotModel> {
    public final /* synthetic */ ServiceBotComponent a;

    public m(ServiceBotComponent r1) {
        this.a = r1;
    }

    public final void c(Object r4) {
        BotModel r5 = (BotModel) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        Integer r0 = r5.getBotType();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 4) goto L17;
        String r6 = r5.getName();
        if (r6 == null) goto L14;
        String r7 = p0.a(r6);
        if (r7 == null) goto L15;
        ServiceBotComponent r1 = this.a;
        r1.m = r7;
        NovaTitleBarEx.Y5(r1.P2(), r7, null, null, 6);
        return;
    L15:
        return;
    L14:
        return;
    }
}
