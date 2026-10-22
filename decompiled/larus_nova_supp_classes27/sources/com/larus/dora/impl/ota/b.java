package com.larus.dora.impl.ota;

import com.bytedance.dora.device.DoraDevice;
import g49.d;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final b a = null;
    public static final StateFlowImpl b = null;
    public static final b1 c = null;

    public b() {
    }

    static {
        a = new b();
        StateFlowImpl r0 = j1.a(MapsKt.emptyMap());
        b = r0;
        c = kotlinx.coroutines.flow.e.b(r0);
    }

    public static String a(DoraDevice r1) {
        Intrinsics.checkNotNullParameter(r1, "device");
        String r2 = (String) ((Map) c.getValue()).get(r1.sn);
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public final synchronized void b(String r4, String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "sn");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r5, "version");     // Catch: Throwable -> L7
        d.d("DoraOTACompat", "notifyNewVersionChanged: sn=" + r4 + ", version=" + r5);     // Catch: Throwable -> L7
        StateFlowImpl r0 = b;     // Catch: Throwable -> L7
        Map r1 = MapsKt.toMutableMap((Map) r0.getValue());     // Catch: Throwable -> L7
        r1.put(r4, r5);     // Catch: Throwable -> L7
        r0.setValue(r1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
