package com.bytedance.android.live.revlink.impl.perf;

import com.bytedance.android.live.revlink.impl.utils.z;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements Runnable {
    public final /* synthetic */ LinkPerfManager a;

    public d(LinkPerfManager r1) {
        this.a = r1;
    }

    public final void a() {
        int r0 = z.a;
        b r1 = this.a.i;
        Intrinsics.checkNotNullParameter(r1, Constants.Keys.DATA);
        com.bytedance.android.live.revlink.impl.settings.live.b r2 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        if (r2.b().getEnable() == false) goto L45;
        r11.e.d r3 = r2.b().M();
        if (r3 != null) goto L7;
    L9:
        r1.getClass();
        LinkedHashMap r4 = new LinkedHashMap();
        e r5 = r1.c;
        Double r6 = null;
        if (r5 == null) goto L12;
        Double r7 = Double.valueOf(r5.a);
    L13:
        r4.put("cpu", String.valueOf(r7));
        e r8 = r1.c;
        if (r8 == null) goto L16;
        Double r9 = Double.valueOf(r8.b);
    L17:
        r4.put("cpu_speed", String.valueOf(r9));
        e r10 = r1.c;
        if (r10 == null) goto L20;
        Double r12 = Double.valueOf(r10.d);
    L21:
        r4.put("stream_preview_fps", String.valueOf(r12));
        e r13 = r1.c;
        if (r13 == null) goto L24;
        r6 = Double.valueOf(r13.c);
    L24:
        r4.put("gpu", String.valueOf(r6));
        e r14 = r1.c;
        long r15 = 0;
        if (r14 == null) goto L27;
        long r16 = r14.e;
    L28:
        r4.put("mem_pss_total", String.valueOf((r16 / 1024.0d) / 1024.0d));
        e r17 = r1.c;
        if (r17 == null) goto L31;
        long r18 = r17.f;
    L32:
        r4.put("mem_native", String.valueOf((r18 / 1024.0d) / 1024.0d));
        e r19 = r1.c;
        if (r19 == null) goto L35;
        long r20 = r19.g;
    L36:
        r4.put("mem_java", String.valueOf((r20 / 1024.0d) / 1024.0d));
        e r22 = r1.c;
        if (r22 == null) goto L39;
        r15 = r22.h;
    L39:
        r4.put("mem_graphics", String.valueOf((r15 / 1024.0d) / 1024.0d));
        if (r1.b == false) goto L42;
        r4.putAll(r1.e);
    L43:
        z.b(r4);
        z.c();
        z.d("livesdk_rd_con_perf_scene_monitor", r4);
        return;
    L42:
        r4.put("cur_rev_scene", String.valueOf(r1.a));
        r4.put("last_rev_scene", String.valueOf(r1.a));
        goto L43
    L35:
        r20 = 0;
        goto L36
    L31:
        r18 = 0;
        goto L32
    L27:
        r16 = 0;
        goto L28
    L20:
        r12 = null;
        goto L21
    L16:
        r9 = null;
        goto L17
    L12:
        r7 = null;
        goto L13
    L7:
        if (r3.getEnable() == true) goto L9;
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
