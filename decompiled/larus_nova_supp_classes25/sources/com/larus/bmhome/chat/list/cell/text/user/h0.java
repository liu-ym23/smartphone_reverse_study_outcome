package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ UserTextCell a;
    public final /* synthetic */ Message b;

    public final void c(Object r4) {
        BotModel r5 = (BotModel) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        FLogger r0 = FLogger.a;
        int r1 = UserTextCell.z;
        r0.i("UserTextCell", "[onBotModelChanged] botId:" + r5.getBotId());
        com.larus.bmhome.chat.component.cvs.y r2 = this.a.B();
        if (r2 == null) goto L5;
        r2.lQ(this);
    L5:
        this.a.P(this.b, r5);
    }

    public h0(UserTextCell r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }
}
