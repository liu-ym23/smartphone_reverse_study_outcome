package com.ss.android.lark.integrator.security.compliance.export;

import com.ss.lark.android.encryption.utils.MonitorStatus;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void a(e r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        ikc.b r1 = ikc.f.a.b;
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Map r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("source", "officesdk_api"), TuplesKt.to("operation", r8.a), TuplesKt.to("result", Boolean.valueOf(r8.b))});
        Integer r0 = r8.d;
        if (r0 == null) goto L5;
        r3.put("error_code", Integer.valueOf(r0.intValue()));
    L5:
        String r2 = r8.e;
        if (r2 == null) goto L8;
        r3.put("failure_reason", r2);
    L8:
        Map r4 = MapsKt.mapOf(TuplesKt.to("duration_ms", Long.valueOf(r8.c)));
        if (r8.b == false) goto L11;
        MonitorStatus r9 = MonitorStatus.SUCCESS;
    L12:
        ikc.a.a(r1, "scs_file_stream_encryption", r3, r4, r9.getValue(), 8);
        return;
    L11:
        r9 = MonitorStatus.FAILED;
        goto L12
    }
}
