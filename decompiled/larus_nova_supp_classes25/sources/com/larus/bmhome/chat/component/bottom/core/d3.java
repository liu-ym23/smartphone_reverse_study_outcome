package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.component.bottom.voice.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d3 implements Function0 {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ a b;
    public final /* synthetic */ int c;
    public final /* synthetic */ com.larus.bmhome.chat.component.bottom.voice.d0 d;
    public final /* synthetic */ String e;

    public /* synthetic */ d3(CoreInputComponent r1, a r2, int r3, com.larus.bmhome.chat.component.bottom.voice.d0 r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke() {
        CoreInputComponent r0 = this.a;
        a r1 = this.b;
        int r2 = this.c;
        com.larus.bmhome.chat.component.bottom.voice.d0 r3 = this.d;
        String r4 = this.e;
        int r5 = CoreInputComponent.d3;
        r0.C6();
        com.larus.bmhome.chat.component.bottom.voice.d0.e(r3, r2, RangesKt.coerceAtLeast(r1.Hw().a.length() - r2, 0), r4, "error");
        r0.k4().k0();
        return Unit.INSTANCE;
    }
}
