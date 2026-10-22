package com.larus.bmhome.chat.component.title;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j1 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ ChatTitleComponent a;

    public j1(ChatTitleComponent r1) {
        this.a = r1;
    }

    public final void c(Object r8) {
        BotModel r9 = (BotModel) r8;
        Intrinsics.checkNotNullParameter(r9, "new");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), Dispatchers.getMain().getImmediate(), null, new ChatTitleComponent$addOnBotListener$3$1(this.a, r9, null), 2, null);
    }
}
