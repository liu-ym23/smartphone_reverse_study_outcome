package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.component.bottom.voice.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c3 implements Function0 {
    public final /* synthetic */ a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.larus.bmhome.chat.component.bottom.voice.d0 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ CoreInputComponent e;

    public /* synthetic */ c3(a r1, int r2, com.larus.bmhome.chat.component.bottom.voice.d0 r3, String r4, CoreInputComponent r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke() {
        a r0 = this.a;
        int r1 = this.b;
        com.larus.bmhome.chat.component.bottom.voice.d0 r2 = this.c;
        String r3 = this.d;
        CoreInputComponent r4 = this.e;
        int r5 = CoreInputComponent.d3;
        com.larus.bmhome.chat.component.bottom.voice.d0.e(r2, r1, RangesKt.coerceAtLeast(r0.Hw().a.length() - r1, 0), r3, "mute_overtime");
        r4.k4().k0();
        return Unit.INSTANCE;
    }
}
