package com.bytedance.android.annie.business.latch;

import com.bytedance.android.latch.LatchOptions;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieBusinessLatchMonitorImpl implements LatchOptions.a {
    public final Lazy a;

    public AnnieBusinessLatchMonitorImpl() {
        this.a = LazyKt.lazy(AnnieBusinessLatchMonitorImpl$monitor$2.INSTANCE);
    }

    public final void a(String r18, int r19, long r20) {
        Intrinsics.checkNotNullParameter(r18, "pageUrl");
        HybridLogger r10 = HybridLogger.a;
        HybridLogger.f("AnnieBusinessLatchService", "=======duration: " + r19 + "========", null, 12);
        if (r19 >= 4) goto L13;
        j9.b r11 = (j9.b) this.a.getValue();
        JSONObject r12 = new JSONObject();
        r12.put("stage", r19);
        Unit r1 = Unit.INSTANCE;
        JSONObject r13 = new JSONObject();
        r13.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r20);
        JSONObject r14 = new JSONObject();
        com.bytedance.android.annie.ng.a r15 = com.bytedance.android.annie.ng.g.c.get("host");
        if (r15 == null) goto L10;
        o8.f r16 = r15.b;
        if (r16 == null) goto L10;
        String r17 = r16.a;
        if (r17 == null) goto L10;
    L11:
        r14.put("virtual_aid", r17);
        j9.b.a.a(r11, null, "latch_ng_duration", r18, r12, r13, null, r14, 0, 256);
        return;
    L10:
        r17 = "88888";
        goto L11
    L13:
        if (r19 != 5) goto L31;
        j9.b r21 = (j9.b) this.a.getValue();
        JSONObject r22 = new JSONObject();
        r22.put("optimize_type", 1);
        Unit r23 = Unit.INSTANCE;
        JSONObject r110 = new JSONObject();
        r110.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r20);
        JSONObject r111 = new JSONObject();
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r24 = com.bytedance.android.annie.ng.g.c;
        com.bytedance.android.annie.ng.a r25 = r24.get("host");
        if (r25 == null) goto L20;
        o8.f r26 = r25.b;
        if (r26 == null) goto L20;
        String r27 = r26.a;
        if (r27 == null) goto L20;
    L21:
        r111.put("virtual_aid", r27);
        j9.b.a.a(r21, null, "latch_ng_callback", r18, r22, r110, null, r111, 0, 256);
        j9.b r28 = (j9.b) this.a.getValue();
        JSONObject r29 = new JSONObject();
        JSONObject r112 = new JSONObject();
        JSONObject r113 = new JSONObject();
        com.bytedance.android.annie.ng.a r30 = r24.get("host");
        if (r30 == null) goto L27;
        o8.f r31 = r30.b;
        if (r31 == null) goto L27;
        String r32 = r31.a;
        if (r32 == null) goto L27;
    L28:
        r113.put("virtual_aid", r32);
        j9.b.a.a(r28, null, "latch_ng_success", r18, r29, r112, null, r113, 0, 256);
        return;
    L27:
        r32 = "88888";
    L20:
        r27 = "88888";
        goto L21
    }

    public final void b(String r16, int r17, String r18, Map<String, ? extends Object> r19) {
        Intrinsics.checkNotNullParameter(r16, "pageUrl");
        Intrinsics.checkNotNullParameter(r18, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Intrinsics.checkNotNullParameter(r19, "extra");
        HybridLogger r10 = HybridLogger.a;
        HybridLogger.f("AnnieBusinessLatchService", "=======error==== pageUrl:" + r16 + ", message:" + r18, null, 12);
        j9.b r11 = (j9.b) this.a.getValue();
        JSONObject r12 = new JSONObject();
        r12.put("stage", r17);
        Unit r13 = Unit.INSTANCE;
        JSONObject r14 = new JSONObject();
        r14.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r18);
        r14.put("extra", new JSONObject(r19));
        JSONObject r15 = new JSONObject();
        com.bytedance.android.annie.ng.a r0 = com.bytedance.android.annie.ng.g.c.get("host");
        if (r0 == null) goto L8;
        o8.f r1 = r0.b;
        if (r1 == null) goto L8;
        String r20 = r1.a;
        if (r20 == null) goto L8;
    L9:
        r15.put("virtual_aid", r20);
        j9.b.a.a(r11, null, "latch_ng_error", r16, r12, null, r14, r15, 0, 256);
        return;
    L8:
        r20 = "88888";
        goto L9
    }
}
