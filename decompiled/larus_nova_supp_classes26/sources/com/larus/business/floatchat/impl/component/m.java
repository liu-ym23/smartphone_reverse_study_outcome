package com.larus.business.floatchat.impl.component;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class m implements Function0 {
    public final /* synthetic */ AIChatInputConfigComponent a;
    public final /* synthetic */ View b;

    public /* synthetic */ m(AIChatInputConfigComponent r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        AIChatInputConfigComponent r0 = this.a;
        View r1 = this.b;
        if (r0.x == false) goto L6;
        r1.setVisibility(0);
        r0.C3(r1);
    L6:
        return Unit.INSTANCE;
    }
}
