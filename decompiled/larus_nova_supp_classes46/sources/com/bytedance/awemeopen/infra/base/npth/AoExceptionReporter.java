package com.bytedance.awemeopen.infra.base.npth;

import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.event.b;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.servicesapi.monitor.AoEnsureService;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import j64.a;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoExceptionReporter {
    public static final AoNpthService a = null;
    public static final AoEnsureService b = null;
    public static final String c = null;

    public AoExceptionReporter() {
    }

    static {
        AoNpthService r0 = a.a(AoNpthService.class);
        Intrinsics.checkNotNull(r0);
        a = r0;
        AoEnsureService r1 = a.a(AoEnsureService.class);
        Intrinsics.checkNotNull(r1);
        b = r1;
        c = "aosdk";
    }

    public static void a(ErrorPriority r10, String r11, String r12, String r13, final Throwable r14) {
        Intrinsics.checkNotNullParameter(r10, "priority");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "sign");
        Intrinsics.checkNotNullParameter(r13, "errInfo");
        Intrinsics.checkNotNullParameter(r14, "throwable");
        HashMap r3 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("priority", String.valueOf(r10.getPriorityNum())), TuplesKt.to("type", r11), TuplesKt.to("sign", r12), TuplesKt.to("errInfo", r13)});
        b.ensureNotReachHere(r14, c + '_' + r10.name() + '_' + r11 + '_' + r12, r3);
        int r5 = r10.getPriorityNum();
        if (r13.length() <= 300) goto L5;
        r13 = r13.substring(0, 300);
    L5:
        b.C0189b r6 = b.a("ao_special_error");
        r6.d("priority", Integer.valueOf(r5));
        r6.d("type", r11);
        r6.d("sign", r12);
        r6.d("err_info", r13);
        r6.d("throwable", r14);
        r6.a().b();
        final String r15 = r3.toString();
        AoLogger.c("AoExceptionReporter", new Object[]{"reportCustomException: data:" + r15 + ",exception: " + r14});
        if (AoEnv.i() == true) goto L8;
        return;
    L8:
        if (r10 != ErrorPriority.p0) goto L12;
        final long r16 = 3000;
        AoPool.e(new AoExceptionReporter$reportCustomException$1(r16, r15, r14), 3000);
        return;
    }

    public static /* synthetic */ void b(ErrorPriority r1, String r2, String r3, String r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 16) == 0) goto L8;
        Throwable r6 = new Throwable();
    L9:
        a(r1, r2, r3, r4, r6);
        return;
    L8:
        r6 = null;
        goto L9
    }
}
