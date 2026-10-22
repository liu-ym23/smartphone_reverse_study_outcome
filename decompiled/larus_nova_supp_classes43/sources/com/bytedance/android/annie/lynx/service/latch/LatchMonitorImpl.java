package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.android.latch.LatchOptions;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LatchMonitorImpl implements LatchOptions.a {
    public static final LatchMonitorImpl a = null;
    public static final Lazy b = null;

    public LatchMonitorImpl() {
    }

    static {
        a = new LatchMonitorImpl();
        b = LazyKt.lazy(LatchMonitorImpl$monitor$2.INSTANCE);
    }

    public final void a(String r18, int r19, long r20) {
        Intrinsics.checkNotNullParameter(r18, "pageUrl");
        String r15 = "88888";
        if (r19 >= 4) goto L14;
        j9.b r10 = (j9.b) b.getValue();
        JSONObject r11 = new JSONObject();
        r11.put("stage", r19);
        Unit r0 = Unit.INSTANCE;
        JSONObject r12 = new JSONObject();
        r12.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r20);
        JSONObject r13 = new JSONObject();
        com.bytedance.android.annie.ng.a r1 = com.bytedance.android.annie.ng.g.c.get("host");
        if (r1 == null) goto L12;
        o8.f r14 = r1.b;
        if (r14 == null) goto L12;
        String r16 = r14.a;
        if (r16 == null) goto L12;
        r15 = r16;
    L12:
        r13.put("virtual_aid", r15);
        j9.b.a.a(r10, null, "latch_ng_duration", r18, r11, r12, null, r13, 0, 256);
        return;
    L14:
        if (r19 != 5) goto L33;
        Lazy r17 = b;
        j9.b r21 = (j9.b) r17.getValue();
        JSONObject r22 = new JSONObject();
        r22.put("optimize_type", 1);
        Unit r23 = Unit.INSTANCE;
        JSONObject r24 = new JSONObject();
        r24.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, r20);
        JSONObject r110 = new JSONObject();
        ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r25 = com.bytedance.android.annie.ng.g.c;
        com.bytedance.android.annie.ng.a r26 = r25.get("host");
        if (r26 == null) goto L21;
        o8.f r27 = r26.b;
        if (r27 == null) goto L21;
        String r28 = r27.a;
        if (r28 == null) goto L21;
    L22:
        r110.put("virtual_aid", r28);
        j9.b.a.a(r21, null, "latch_ng_callback", r18, r22, r24, null, r110, 0, 256);
        j9.b r29 = (j9.b) r17.getValue();
        JSONObject r30 = new JSONObject();
        JSONObject r31 = new JSONObject();
        JSONObject r111 = new JSONObject();
        com.bytedance.android.annie.ng.a r32 = r25.get("host");
        if (r32 == null) goto L30;
        o8.f r33 = r32.b;
        if (r33 == null) goto L30;
        String r34 = r33.a;
        if (r34 == null) goto L30;
        r15 = r34;
    L30:
        r111.put("virtual_aid", r15);
        j9.b.a.a(r29, null, "latch_ng_success", r18, r30, r31, null, r111, 0, 256);
        return;
    L21:
        r28 = "88888";
        goto L22
    }

    public final void b(String r14, int r15, String r16, Map<String, ? extends Object> r17) {
        Intrinsics.checkNotNullParameter(r14, "pageUrl");
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Intrinsics.checkNotNullParameter(r17, "extra");
        j9.b r10 = (j9.b) b.getValue();
        JSONObject r11 = new JSONObject();
        r11.put("stage", r15);
        Unit r12 = Unit.INSTANCE;
        JSONObject r13 = new JSONObject();
        r13.put(com.bytedance.android.ec.core.event.a.KEY_MSG, r16);
        r13.put("extra", new JSONObject(r17));
        JSONObject r0 = new JSONObject();
        com.bytedance.android.annie.ng.a r1 = com.bytedance.android.annie.ng.g.c.get("host");
        if (r1 == null) goto L8;
        o8.f r18 = r1.b;
        if (r18 == null) goto L8;
        String r19 = r18.a;
        if (r19 == null) goto L8;
    L9:
        r0.put("virtual_aid", r19);
        j9.b.a.a(r10, null, "latch_ng_error", r14, r11, null, r13, r0, 0, 256);
        return;
    L8:
        r19 = "88888";
        goto L9
    }
}
