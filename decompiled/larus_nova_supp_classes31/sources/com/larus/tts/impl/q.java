package com.larus.tts.impl;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ ChatTitleTtsComponent a;

    public q(ChatTitleTtsComponent r1) {
        this.a = r1;
    }

    public final void c(Object r8) {
        BotModel r9 = (BotModel) r8;
        Intrinsics.checkNotNullParameter(r9, "new");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), new m(CoroutineExceptionHandler.Key), null, new ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2(this.a, r9, null), 2, null);
    }
}
