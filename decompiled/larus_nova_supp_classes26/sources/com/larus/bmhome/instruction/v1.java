package com.larus.bmhome.instruction;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v1 implements IIMCallback<BotModel> {
    public final /* synthetic */ InstructionInputComponent a;
    public final /* synthetic */ String b;

    public final boolean mustInMain() {
        return false;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        if (this.a.D == true) goto L5;
        return;
    L5:
        this.a.D = false;
        FLogger.a.w("InstructionInputComponent", "[ActionBarEarlyRender] bot preload failed, botId=" + this.b + ", error=" + r4);
    }

    public final void onSuccess(Object r4) {
        BotModel r5 = (BotModel) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        if (this.a.D == false) goto L7;
        this.a.C = r5;
        this.a.D = false;
        FLogger.a.i("InstructionInputComponent", "[ActionBarEarlyRender] bot preload success, botId=" + r5.getBotId());
        return;
    }

    public v1(InstructionInputComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
