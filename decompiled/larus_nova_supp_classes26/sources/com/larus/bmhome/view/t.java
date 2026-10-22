package com.larus.bmhome.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class t implements Function0 {
    public final /* synthetic */ ChatConstraintLayout a;
    public final /* synthetic */ Object b;

    public /* synthetic */ t(ChatConstraintLayout r1, Object r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        ChatConstraintLayout r0 = this.a;
        Object r1 = this.b;
        g2 r2 = r0.C;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "token");
        if (r2.a.remove(r1) == true) goto L5;
        boolean r3 = false;
    L6:
        if (r3 == false) goto L9;
        r0.G.removeMessages(1);
        r0.G.sendEmptyMessageDelayed(1, 50);
    L9:
        return Unit.INSTANCE;
    L5:
        r2.b = true;
        r3 = true;
        goto L6
    }
}
