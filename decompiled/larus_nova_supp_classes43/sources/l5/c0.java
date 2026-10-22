package l5;

import kotlin.jvm.internal.Intrinsics;
import m5.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c0 {
    public c0() {
    }

    public static void a(a0 r10) {
        Intrinsics.checkNotNullParameter(r10, "traceEvent");
        h1 r0 = r10.a;
        Long r11 = b0.a(r0, "fe_send_call", "native_receive_call");
        if (r11 == null) goto L5;
        long r12 = r11.longValue();
        r10.b.d("call_fe_to_native_duration", Long.valueOf(r12));
    L5:
        Long r1 = b0.a(r0, "fe_send_call", "fe_receive_callback");
        if (r1 == null) goto L9;
        long r13 = r1.longValue();
        r10.b.d("total_duration", Long.valueOf(r13));
        return;
    }
}
