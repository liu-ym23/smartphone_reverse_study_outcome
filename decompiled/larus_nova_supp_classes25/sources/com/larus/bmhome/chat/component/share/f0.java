package com.larus.bmhome.chat.component.share;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f0 implements Function1 {
    public final /* synthetic */ ChatShareBottomComponent a;

    public /* synthetic */ f0(ChatShareBottomComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ChatShareBottomComponent r0 = this.a;
        Pair r5 = (Pair) r4;
        int r1 = ChatShareBottomComponent.R;
        u7 r2 = r0.Z3();
        MessageAdapter r3 = null;
        if (r2 == null) goto L5;
        MessageAdapter r6 = r2.MF();
    L7:
        if ((r6 instanceof MessageAdapter) == false) goto L9;
        r3 = r6;
    L9:
        if (r3 == null) goto L12;
        r3.notifyItemRangeChanged(((Number) r5.getFirst()).intValue(), ((Number) r5.getSecond()).intValue());
    L12:
        return Unit.INSTANCE;
    L5:
        r6 = null;
        goto L7
    }
}
