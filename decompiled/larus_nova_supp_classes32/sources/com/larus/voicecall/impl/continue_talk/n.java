package com.larus.voicecall.impl.continue_talk;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class n implements Function1 {
    public final /* synthetic */ ChatContinuousTalkComponent a;

    public /* synthetic */ n(ChatContinuousTalkComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        ChatContinuousTalkComponent r0 = this.a;
        final Continuation r6 = (Continuation) r5;
        int r1 = ChatContinuousTalkComponent.M;
        Intrinsics.checkNotNullParameter(r6, "cont");
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = new q(r6);
        com.larus.bmhome.chat.component.cvs.y r7 = r0.u0();
        if (r7 == null) goto L6;
        r7.rh(new r(), new p0(r0, r2));
    L6:
        return Unit.INSTANCE;
    }
}
