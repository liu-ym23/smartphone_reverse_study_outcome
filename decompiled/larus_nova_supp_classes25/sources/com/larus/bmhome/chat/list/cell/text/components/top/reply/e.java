package com.larus.bmhome.chat.list.cell.text.components.top.reply;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements y.a<BotModel> {
    public final /* synthetic */ ReplyHeaderComponent a;
    public final /* synthetic */ Message b;

    public final void c(Object r4) {
        BotModel r5 = (BotModel) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        FLogger.a.i("ReplyHeaderComponent", "[onBotModelChanged] botId:" + r5.getBotId());
        y r0 = (y) this.a.m.getValue();
        if (r0 == null) goto L5;
        r0.lQ(this);
    L5:
        this.a.J(this.b, r5);
    }

    public e(ReplyHeaderComponent r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }
}
