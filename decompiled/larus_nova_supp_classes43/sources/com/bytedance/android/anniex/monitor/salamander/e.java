package com.bytedance.android.anniex.monitor.salamander;

import b8a.l;
import com.lynx.tasm.LynxViewClientV2;
import java.util.HashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends LynxViewClientV2 {
    public final Function0<String> a;

    public e(Function0<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        this.a = r10;
    }

    public final void onPerformanceEvent(l r10) {
        Intrinsics.checkNotNullParameter(r10, "entry");
        SLMonitorCompat r0 = SLMonitorCompat.a;
        String r1 = (String) this.a.invoke();
        HashMap r11 = r10.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "lynxData");
        if (SLMonitorCompat.b == false) goto L7;
        c.a.a(r1).o(MapsKt.toMutableMap(r11));
        return;
    }
}
