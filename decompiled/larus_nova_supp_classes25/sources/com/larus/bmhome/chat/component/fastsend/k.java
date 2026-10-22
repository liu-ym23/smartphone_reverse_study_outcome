package com.larus.bmhome.chat.component.fastsend;

import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements Function0 {
    public final /* synthetic */ FastSendImageComponent a;
    public final /* synthetic */ int b;

    public /* synthetic */ k(FastSendImageComponent r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        FastSendImageComponent r0 = this.a;
        int r1 = this.b;
        KProperty[] r2 = FastSendImageComponent.M;
        f1 r3 = r0.N2();
        if (r3 == null) goto L6;
        r3.Vx(false, r1);
    L6:
        return Unit.INSTANCE;
    }
}
