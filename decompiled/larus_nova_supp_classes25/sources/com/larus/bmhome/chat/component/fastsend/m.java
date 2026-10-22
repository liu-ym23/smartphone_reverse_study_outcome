package com.larus.bmhome.chat.component.fastsend;

import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m implements Function0 {
    public final /* synthetic */ FastSendImageComponent a;

    public /* synthetic */ m(FastSendImageComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        FastSendImageComponent r0 = this.a;
        KProperty[] r1 = FastSendImageComponent.M;
        f1 r2 = r0.N2();
        if (r2 == null) goto L6;
        r2.Vx(true, 0);
    L6:
        return Unit.INSTANCE;
    }
}
