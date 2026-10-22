package com.bytedance.sdk.xbridge.cn.protocol;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bj.a f7458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7459b;

    public e(bj.a r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        this.f7458a = r5;
    }

    public abstract JSONObject a();

    public abstract void b(Object r5);

    public final void c(Object r10) {
        long r5 = System.currentTimeMillis();
        bj.a r11 = this.f7458a;
        r11.f937j = r5;
        b(r10);
        r11.f936i = System.currentTimeMillis();
        if (StringsKt.isBlank(r11.d) == true) goto L5;
        String r12 = r11.d;
    L7:
        if (Intrinsics.areEqual(r12, "Loki") == false) goto L14;
        LinkedHashMap r13 = r11.H;
        Lazy r14 = com.bytedance.sdk.xbridge.cn.optimize.b.f7355a;
        if (Intrinsics.areEqual(r13.get("loki_jsb_log_drop_switch"), Boolean.TRUE) == false) goto L14;
        s6.c r15 = (s6.c) ki.a.d.f5321c;
        if (r15 == null) goto L29;
        r15.f(r11);
        return;
    L29:
        return;
    L14:
        ki.a.d.getClass();
        if (r11.f940m == false) goto L17;
    L22:
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_CALL);
        ExecutorService r16 = com.bytedance.sdk.xbridge.cn.utils.b.f7499a;
        jm.a r17 = new jm.a(r11, 16);
        Intrinsics.checkNotNullParameter(r17, "runnable");
        if (com.bytedance.sdk.xbridge.cn.utils.b.f7499a != null) goto L25;
        com.bytedance.sdk.xbridge.cn.utils.b.f7499a = Executors.newSingleThreadExecutor();
    L25:
        ExecutorService r18 = com.bytedance.sdk.xbridge.cn.utils.b.f7499a;
        Intrinsics.checkNotNull(r18);
        r18.submit(r17);
        s6.c r19 = (s6.c) ki.a.d.f5321c;
        if (r19 == null) goto L30;
        r19.f(r11);
        return;
    L30:
        return;
    L17:
        if (Intrinsics.areEqual(r11.d, "webcast") == true) goto L22;
        Lazy r110 = com.bytedance.sdk.xbridge.cn.utils.e.f7504a;
        Pair r20 = TuplesKt.to("url", r11.d());
        Pair r21 = TuplesKt.to("methodName", r11.f932a);
        Pair r22 = TuplesKt.to("code", Integer.valueOf(r11.f938k));
        Pair r23 = TuplesKt.to("message", r11.f939l);
        Pair r24 = TuplesKt.to("data", a().toString());
        String r25 = r11.f934c;
        Map r26 = MapsKt.mapOf(new Pair[]{r20, r21, r22, r23, r24, TuplesKt.to("callId", r25)});
        com.bytedance.sdk.xbridge.cn.utils.c r27 = new com.bytedance.sdk.xbridge.cn.utils.c();
        String r28 = this.f7459b;
        if (r28 != null) goto L21;
        r28 = "";
    L21:
        Intrinsics.checkNotNullParameter("bulletSession", "name");
        Intrinsics.checkNotNullParameter(r28, "sessionId");
        ArrayList r29 = r27.f7501a;
        r29.add(new com.bytedance.sdk.xbridge.cn.utils.d("bulletSession", r28));
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r25, "sessionId");
        r29.add(new com.bytedance.sdk.xbridge.cn.utils.d("callId", r25));
        Unit r30 = Unit.INSTANCE;
        com.bytedance.sdk.xbridge.cn.utils.e.a("BDXBridge end handle method", "BridgeResult", r26, r27);
        goto L22
    L5:
        r12 = r11.e;
        goto L7
    }
}
