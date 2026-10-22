package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends DSLMonitor {
    public static final String d = null;
    public static boolean e;
    public static final o f = null;

    static {
        f = new o();
        d = "Live_Slice";
        e = true;
    }

    public o() {
    }

    @Override // com.bytedance.android.livesdk.dslservice.util.DSLMonitor
    public final String c() {
        return d;
    }

    public final void i(long r8, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "loadType");
        HashMap r9 = DSLMonitor.b(r8, r10, DSLType.Slice, e, r11);
        e = false;
        h(this.a, r9);
    }
}
