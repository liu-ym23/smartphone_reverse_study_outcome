package com.obric.assistant.chat.component.interaction;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l implements y.a<BotModel> {
    public final /* synthetic */ y a;
    public final /* synthetic */ kotlinx.coroutines.i<BotModel> b;

    public final void c(Object r2) {
        BotModel r3 = (BotModel) r2;
        Intrinsics.checkNotNullParameter(r3, "new");
        this.a.lQ(this);
        if (this.b.isActive() == false) goto L6;
        this.b.resumeWith(Result.constructor-impl(r3));
        return;
    }

    public l(y r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }
}
