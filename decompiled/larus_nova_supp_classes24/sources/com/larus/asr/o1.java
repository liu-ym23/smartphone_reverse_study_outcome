package com.larus.asr;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o1 implements y.a<BotModel> {
    public final /* synthetic */ ChatBottomSpeakerComponent a;

    public o1(ChatBottomSpeakerComponent r1) {
        this.a = r1;
    }

    public final void c(Object r4) {
        BotModel r5 = (BotModel) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        FLogger.a.i("ChatBottomSpeakerComponent", "[onBotChanged] previous botId=" + this.a.u + ", new botId=" + r5.getBotId());
        this.a.u = r5.getBotId();
    }
}
