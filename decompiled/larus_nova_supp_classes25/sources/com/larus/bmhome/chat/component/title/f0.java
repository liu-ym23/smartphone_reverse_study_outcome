package com.larus.bmhome.chat.component.title;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f0 implements Function1 {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ f0(ChatTitleComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9) {
        ChatTitleComponent r0 = this.a;
        boolean r10 = ((Boolean) r9).booleanValue();
        int r1 = ChatTitleComponent.P1;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 == null) goto L9;
        BotModel r3 = r2.j0();
        if (r3 == null) goto L9;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), Dispatchers.getMain().getImmediate(), null, new ChatTitleComponent$addOnBotListener$4$1(r0, r3, r10, null), 2, null);
        return Unit.INSTANCE;
    L9:
        return Unit.INSTANCE;
    }
}
