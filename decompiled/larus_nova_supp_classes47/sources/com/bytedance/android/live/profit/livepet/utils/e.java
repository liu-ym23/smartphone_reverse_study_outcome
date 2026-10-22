package com.bytedance.android.live.profit.livepet.utils;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.scope.m;
import com.bytedance.badger.collect.impl.constants.Constants;
import cy0.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static void a(long r7, String r9, boolean r10, long r12) {
        Intrinsics.checkNotNullParameter(r9, "scheme");
        Intrinsics.checkNotNullParameter("", "error");
        n r3 = new n();
        Map<String, String> r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "map");
        String r8 = String.valueOf(r7);
        Intrinsics.checkNotNullParameter("pet_type", "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r4.put("pet_type", r8);
        Intrinsics.checkNotNullParameter("scheme", "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        r4.put("scheme", r9);
        if (r10 == false) goto L5;
        String r13 = DataType.TRUE;
    L6:
        Intrinsics.checkNotNullParameter("success", "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r4.put("success", r13);
        String r14 = String.valueOf(r12);
        Intrinsics.checkNotNullParameter(Constants.Keys.duration, "key");
        Intrinsics.checkNotNullParameter(r14, "value");
        r4.put(Constants.Keys.duration, r14);
        if (r10 == true) goto L9;
        Intrinsics.checkNotNullParameter("error", "key");
        Intrinsics.checkNotNullParameter("", "value");
        r4.put("error", "");
    L9:
        cy0.e.a.getClass();
        j r15 = cy0.e.a.a;
        m.e.getClass();
        Object r16 = m.b(r15).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r16);
        ((i) ((f80.a) r16)).w3("livesdk_pet_open_container_result_tech", r3.a, r3.b);
        return;
    L5:
        r13 = DataType.FALSE;
        goto L6
    }

    public static final void b(long r6, String r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "scheme");
        Intrinsics.checkNotNullParameter(r10, "error");
        n r2 = new n();
        Map<String, String> r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        String r7 = String.valueOf(r6);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r3.put("gift_id", r7);
        Intrinsics.checkNotNullParameter("scheme", "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r3.put("scheme", r8);
        if (r9 == false) goto L5;
        String r12 = DataType.TRUE;
    L6:
        Intrinsics.checkNotNullParameter("success", "key");
        Intrinsics.checkNotNullParameter(r12, "value");
        r3.put("success", r12);
        if (r9 == true) goto L9;
        Intrinsics.checkNotNullParameter("error", "key");
        Intrinsics.checkNotNullParameter(r10, "value");
        r3.put("error", r10);
    L9:
        cy0.e.a.getClass();
        j r13 = cy0.e.a.a;
        m.e.getClass();
        Object r14 = m.b(r13).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r14);
        ((i) ((f80.a) r14)).w3("livesdk_pet_open_trace_container_tech", r2.a, r2.b);
        return;
    L5:
        r12 = DataType.FALSE;
        goto L6
    }
}
