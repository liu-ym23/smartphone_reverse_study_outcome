package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m extends DSLMonitor {
    public static final String d = null;
    public static boolean e;
    public static boolean f;
    public static final String g = null;
    public static final m h = null;

    static {
        h = new m();
        d = "Live_LynxAir";
        e = true;
        f = true;
        g = "ttlive_dsl_load_component_lynx_air_cost";
    }

    public m() {
    }

    @Override // com.bytedance.android.livesdk.dslservice.util.DSLMonitor
    public final String c() {
        return d;
    }

    public final void i(long r8, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "loadType");
        HashMap r9 = DSLMonitor.b(r8, r10, DSLType.LynxAir, e, r11);
        e = false;
        h(this.a, r9);
    }
}
