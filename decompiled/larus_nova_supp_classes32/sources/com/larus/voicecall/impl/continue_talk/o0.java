package com.larus.voicecall.impl.continue_talk;

import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o0 implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
    public final /* synthetic */ ChatContinuousTalkComponent a;
    public final /* synthetic */ Ref.ObjectRef<Function1<BotModel, Unit>> b;

    public final void c(Object r3) {
        BotModel r4 = (BotModel) r3;
        Intrinsics.checkNotNullParameter(r4, "new");
        ChatContinuousTalkComponent r0 = this.a;
        int r1 = ChatContinuousTalkComponent.M;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 == null) goto L5;
        r2.lQ(this);
    L5:
        Function1 r5 = (Function1) this.b.element;
        if (r5 == null) goto L8;
        r5.invoke(r4);
    L8:
        this.b.element = null;
    }

    public o0(ChatContinuousTalkComponent r1, Ref.ObjectRef<Function1<BotModel, Unit>> r2) {
        this.a = r1;
        this.b = r2;
    }
}
