package com.bytedance.android.annie.business.latch;

import com.bytedance.android.annie.Annie;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends hx.a {
    public final String a;
    public final String b;
    public final String c;

    public final void a(com.bytedance.android.latch.a.d r10, dx.a r11) {
        Intrinsics.checkNotNullParameter(r10, "process");
        Intrinsics.checkNotNullParameter(r11, "jsError");
        super.a(r10, r11);
        HybridLogger r12 = HybridLogger.a;
        HybridLogger.f("AnnieBusinessLatchService", "onJSError：" + r11, null, 12);
    }

    public final void b(com.bytedance.android.latch.a.d r20, com.bytedance.android.latch.internal.perf.a r21) {
        Intrinsics.checkNotNullParameter(r20, "process");
        Intrinsics.checkNotNullParameter(r21, "jsbPromiseMetric");
        super.b(r20, r21);
        HybridLogger r10 = HybridLogger.a;
        HybridLogger.f("AnnieBusinessLatchService", "onJsbPromiseResult: " + r21.a.get("status_code"), null, 12);
        j9.b r11 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r12 = this.a;
        JSONObject r13 = r21.a;
        JSONObject r14 = new JSONObject();
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r15 = com.bytedance.android.annie.ng.g.c;
        com.bytedance.android.annie.ng.a r16 = r15.get(this.c);
        if (r16 == null) goto L8;
        o8.f r17 = r16.b;
        if (r17 == null) goto L8;
        String r18 = r17.a;
        if (r18 == null) goto L8;
    L9:
        r14.put("virtual_aid", r18);
        Unit r19 = Unit.INSTANCE;
        r11.b(null, "latch_jsb_promise", r12, r13, null, null, r14, 1, this.b);
        Object r22 = r21.a.get("status_code");
        if ((r22 instanceof Integer) == false) goto L12;
        Integer r23 = (Integer) r22;
    L13:
        if (r23 != null) goto L16;
        return;
    L16:
        if (r23.intValue() != 1) goto L26;
        j9.b r24 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r25 = this.a;
        JSONObject r26 = r21.a;
        JSONObject r27 = r21.b;
        JSONObject r110 = r21.c;
        JSONObject r111 = new JSONObject();
        com.bytedance.android.annie.ng.a r1 = r15.get(this.c);
        if (r1 == null) goto L23;
        o8.f r28 = r1.b;
        if (r28 == null) goto L23;
        String r29 = r28.a;
        if (r29 == null) goto L23;
    L24:
        r111.put("virtual_aid", r29);
        r24.b(null, "latch_jsb_promise_fail", r25, r26, r27, r110, r111, 0, this.b);
        return;
    L23:
        r29 = "88888";
        goto L24
    L26:
        return;
    L12:
        r23 = null;
    L8:
        r18 = "88888";
        goto L9
    }

    public final void c(com.bytedance.android.latch.a.d r10, dx.b r11) {
        Intrinsics.checkNotNullParameter(r10, "process");
        Intrinsics.checkNotNullParameter(r11, "logModel");
        super.c(r10, r11);
        HybridLogger r12 = HybridLogger.a;
        HybridLogger.f("AnnieBusinessLatchService", "logModel：" + r11, null, 12);
    }

    public final void d(com.bytedance.android.latch.a.d r11, com.bytedance.android.latch.internal.perf.e r12) {
        Intrinsics.checkNotNullParameter(r11, "process");
        Intrinsics.checkNotNullParameter(r12, "perfMetric");
        super.d(r11, r12);
        HybridLogger.f("AnnieBusinessLatchService", "onPerfReady", null, 12);
        j9.b r0 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r10 = this.a;
        JSONObject r13 = r12.b;
        JSONObject r14 = r12.a;
        JSONObject r15 = r12.c;
        JSONObject r16 = new JSONObject();
        com.bytedance.android.annie.ng.a r17 = com.bytedance.android.annie.ng.g.c.get(this.c);
        if (r17 == null) goto L8;
        o8.f r18 = r17.b;
        if (r18 == null) goto L8;
        String r19 = r18.a;
        if (r19 == null) goto L8;
    L9:
        r16.put("virtual_aid", r19);
        Unit r110 = Unit.INSTANCE;
        r0.b(null, "latch_timeline", r10, r13, r14, r15, r16, 1, this.b);
        return;
    L8:
        r19 = "88888";
        goto L9
    }

    public final void e(com.bytedance.android.latch.a.d r23, dx.c r24) {
        Intrinsics.checkNotNullParameter(r23, "process");
        Intrinsics.checkNotNullParameter(r24, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        super.e(r23, r24);
        HybridLogger r10 = HybridLogger.a;
        HybridLogger.f("AnnieBusinessLatchService", "onResult: " + r24.a, null, 12);
        j9.b r11 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r12 = this.a;
        JSONObject r13 = new JSONObject();
        r13.put("cached", r24.b);
        r13.put("status_code", r24.a);
        r13.put("transfer_type", r24.c);
        r13.put("err_msg", r24.d);
        r13.put("timeout", r24.e);
        r13.put("engine_type", r24.f);
        Iterator r14 = r24.g.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry r15 = (Map.Entry) r14.next();
        r13.put((String) r15.getKey(), r15.getValue());
        goto L4
    L6:
        Unit r16 = Unit.INSTANCE;
        JSONObject r17 = new JSONObject();
        com.bytedance.android.annie.ng.a r18 = com.bytedance.android.annie.ng.g.c.get(this.c);
        if (r18 == null) goto L12;
        o8.f r19 = r18.b;
        if (r19 == null) goto L12;
        String r20 = r19.a;
        if (r20 == null) goto L12;
    L13:
        r17.put("virtual_aid", r20);
        r11.b(null, "latch_result_all", r12, r13, null, null, r17, 1, this.b);
        if (r24.a == 1) goto L30;
        j9.b r21 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r22 = this.a;
        JSONObject r25 = new JSONObject();
        r25.put("status_code", r24.a);
        r25.put("err_msg", r24.d);
        r25.put("timeout", r24.e);
        Iterator r1 = r24.g.entrySet().iterator();
    L17:
        if (r1.hasNext() == false) goto L19;
        Map.Entry r26 = (Map.Entry) r1.next();
        r25.put((String) r26.getKey(), r26.getValue());
        goto L17
    L19:
        Unit r27 = Unit.INSTANCE;
        JSONObject r110 = new JSONObject();
        com.bytedance.android.annie.ng.a r28 = com.bytedance.android.annie.ng.g.c.get(this.c);
        if (r28 == null) goto L25;
        o8.f r29 = r28.b;
        if (r29 == null) goto L25;
        String r30 = r29.a;
        if (r30 == null) goto L25;
    L26:
        r110.put("virtual_aid", r30);
        r21.b(null, "latch_result_error", r22, r25, null, null, r110, 0, this.b);
        return;
    L25:
        r30 = "88888";
        goto L26
    L30:
        return;
    L12:
        r20 = "88888";
        goto L13
    }

    public a(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "uuid");
        Intrinsics.checkNotNullParameter(r12, "mBizKey");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
