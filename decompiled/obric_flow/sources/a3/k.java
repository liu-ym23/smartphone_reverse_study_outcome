package a3;

import b3.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static void a(j r5) {
        Intrinsics.checkNotNullParameter(r5, "traceEvent");
        o r10 = r5.f86a;
        Long r11 = com.bytedance.android.anniex.base.service.f.b(r10, "fe_send_call", "native_receive_call");
        b3.k r12 = r5.f87b;
        if (r11 == null) goto L5;
        r12.a("call_fe_to_native_duration", Long.valueOf(r11.longValue()));
    L5:
        Long r13 = com.bytedance.android.anniex.base.service.f.b(r10, "fe_send_call", "fe_receive_callback");
        if (r13 == null) goto L9;
        r12.a("total_duration", Long.valueOf(r13.longValue()));
        return;
    }
}
