package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ kj4.a a;

    public /* synthetic */ a(kj4.a r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        kj4.a r0 = this.a;
        int r7 = ((Integer) r6).intValue();
        ak4.a r1 = r0.c.d;
        DoraDevice r2 = r1.a.A;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L13;
        if (r7 == 0) goto L12;
        if (r7 != 1) goto L13;
    L12:
        int r4 = r1.i(2, 5, new byte[]{111, 1, (byte) r7});
    L14:
        if (r7 != 0) goto L16;
        String r5 = "assistant";
    L19:
        pk4.j.d("DoraBuds", "setGlassesMode: mode=" + r5 + "(" + r7 + "), ret=" + r4);
        return Integer.valueOf(r4);
    L16:
        if (r7 != 1) goto L18;
        r5 = "headphone";
        goto L19
    L18:
        r5 = "unknown";
    L13:
        r4 = -5;
        goto L14
    L5:
        if (r2.isSupportGlassesModeControl() == false) goto L7;
        r3 = true;
        goto L8
    }
}
