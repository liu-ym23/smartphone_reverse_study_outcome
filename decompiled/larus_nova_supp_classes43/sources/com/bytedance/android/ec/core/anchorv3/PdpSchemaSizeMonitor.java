package com.bytedance.android.ec.core.anchorv3;

import com.bytedance.android.ec.core.utils.b2;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PdpSchemaSizeMonitor {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(PdpSchemaSizeMonitor$config$2.INSTANCE);
    }

    public static void a(final String r10, final String r11) {
        Lazy r0 = a;
        if (((p) r0.getValue()).b() == true) goto L5;
        return;
    L5:
        final int r1 = r10.length();
        if (r1 >= ((p) r0.getValue()).c()) goto L8;
        return;
    L8:
        b2.b(new PdpSchemaSizeMonitor$monitor$1(r1, r10, r11));
    }
}
