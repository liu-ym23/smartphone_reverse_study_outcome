package com.larus.suggest.impl.popup;

import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.sdk.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class t implements l4 {
    public final /* synthetic */ String a;
    public final /* synthetic */ z3 b;

    public t(String r1, z3 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r10, a r11) {
        if (Intrinsics.areEqual(this.a, r10) == false) goto L13;
        FLogger r12 = FLogger.a;
        StringBuilder r0 = new StringBuilder("start preload video ");
        Float r1 = null;
        if (r11 == null) goto L7;
        Float r2 = Float.valueOf(r11.b());
    L8:
        r0.append(r2);
        r0.append('-');
        if (r11 == null) goto L11;
        r1 = Float.valueOf(r11.a());
    L11:
        r0.append(r1);
        r12.i("NexPulseDialogManager", r0.toString());
        z3.a.a(this.b, r11, null, 30720000, new s(), 10);
        return;
    L7:
        r2 = null;
        goto L8
    }
}
