package com.larus.bmhome.chat.component.action;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w implements y.a<BotModel> {
    public final /* synthetic */ SuggestedActionComponent a;
    public final /* synthetic */ kotlinx.coroutines.i<BotModel> b;

    public final void c(Object r3) {
        BotModel r4 = (BotModel) r3;
        Intrinsics.checkNotNullParameter(r4, "new");
        SuggestedActionComponent r0 = this.a;
        int r1 = SuggestedActionComponent.G;
        y r2 = r0.u0();
        if (r2 == null) goto L6;
        r2.lQ(this);
    L6:
        if (this.b.isActive() == false) goto L9;
        this.b.resumeWith(Result.constructor-impl(r4));
        return;
    }

    public w(SuggestedActionComponent r1, kotlinx.coroutines.j r2) {
        this.a = r1;
        this.b = r2;
    }
}
