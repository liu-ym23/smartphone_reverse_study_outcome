package com.larus.bmhome.chat.layout.item;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w1 implements Function1 {
    public final /* synthetic */ z1 a;
    public final /* synthetic */ double b;
    public final /* synthetic */ double c;

    public /* synthetic */ w1(z1 r1, double r2, double r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final Object invoke(Object r9) {
        z1 r0 = this.a;
        double r1 = this.b;
        double r3 = this.c;
        List<wq9.a> r10 = (List) r9;
        if (r10 == null) goto L7;
        com.larus.bmhome.chat.map.o r2 = r0.y;
        if (r2 == null) goto L11;
        r2.b(r10);
    L11:
        return Unit.INSTANCE;
    L7:
        com.larus.bmhome.chat.map.o r11 = r0.y;
        if (r11 == null) goto L11;
        r11.c(new wq9.a(r1, r3), new wq9.a(r0.z, r0.A));
        goto L11
    }
}
