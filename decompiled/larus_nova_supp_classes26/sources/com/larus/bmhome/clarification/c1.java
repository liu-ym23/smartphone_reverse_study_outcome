package com.larus.bmhome.clarification;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c1 implements Function1 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ c1(ClarificationComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        ClarificationComponent r0 = this.a;
        boolean r7 = ((Boolean) r6).booleanValue();
        View r1 = r0.A;
        if (r1 == null) goto L6;
        r1.postDelayed(new s1(r0, r7), 100);
    L6:
        return Unit.INSTANCE;
    }
}
