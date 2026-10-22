package com.larus.bmhome.chat.component.bottom.core;

import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f7 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ CoreInputComponent a;

    public f7(CoreInputComponent r1) {
        this.a = r1;
    }

    public final void c(Object r5) {
        BotModel r6 = (BotModel) r5;
        Intrinsics.checkNotNullParameter(r6, "new");
        CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        r0.getClass();
        FLogger.a.i("CoreInputComponent", "[updateBotAbility] newBotModel.disabled = " + r6.getDisabled() + ' ' + r6.getBotId());
        r0.F4().updateBotAbility(r6.getDisabled() ^ true);
    }
}
