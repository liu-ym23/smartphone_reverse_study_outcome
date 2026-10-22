package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECMallDeliveryRecordMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallDeliveryRecordMethod extends ECBaseBridgeMethod {
    public final Lazy e;

    public final s83.h d() {
        return (s83.h) this.e.getValue();
    }

    public final String getName() {
        return "mall.deliveryRecord";
    }

    public ECMallDeliveryRecordMethod() {
        this.e = LazyKt.lazy(ECMallDeliveryRecordMethod$monitorServer$2.INSTANCE);
    }

    public static void e(ECBaseBridgeMethod.a r10, Map r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L10
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L10
        if (r11 == null) goto L8;
        Iterator r13 = r11.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r13.hasNext() == false) goto L8;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L10
        r12.putOpt((String) r14.getKey(), r14.getValue());     // Catch: Throwable -> L10
    L8:
        r1.putOpt("deliveryInfo", r12);     // Catch: Throwable -> L10
        r10.a(r1);     // Catch: Throwable -> L10
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r0 = r10.optString("actionType");
        String r1 = r10.optString("sessionID");
        boolean r12 = true;
        if (r0.length() != 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
    L101:
        r11.onFailed(0, "actionType or sessionId is null");
        return;
    L8:
        if (r1.length() != 0) goto L10;
        boolean r14 = true;
    L11:
        if (r14 == true) goto L101;
        JSONObject r15 = r10.optJSONObject("deliveryRecord");
        LinkedHashMap r16 = new LinkedHashMap();
        if (r15 == null) goto L20;
        Iterator<String> r17 = r15.keys();
        if (r17 == null) goto L20;
    L18:
        if (r17.hasNext() == false) goto L20;
        String r18 = r17.next();
        r16.put(r18, r15.opt(r18));
    L20:
        Map r19 = null;
        switch(r0.hashCode()) {
            case -1246914851: goto L62;
            case -235365105: goto L48;
            case 96417: goto L39;
            case 102230: goto L33;
            case 1919834714: goto L24;
            default: goto L99;
        };
    L99:
        r11.onFailed(0, "actionType is error");
        return;
    L24:
        if (r0.equals("publishTTI") == false) goto L99;
        s83.h r110 = d();
        if (r110 == null) goto L28;
        r110.a();
    L28:
        s83.h r111 = d();
        if (r111 == null) goto L31;
        r19 = r111.c();
    L31:
        e(r11, r19);
        return;
    L33:
        if (r0.equals("get") == false) goto L99;
        s83.h r112 = d();
        if (r112 == null) goto L37;
        r19 = r112.c();
    L37:
        e(r11, r19);
        return;
    L39:
        if (r0.equals("add") == false) goto L99;
        s83.h r113 = d();
        if (r113 == null) goto L43;
        r113.d();
    L43:
        s83.h r114 = d();
        if (r114 == null) goto L46;
        r19 = r114.c();
    L46:
        e(r11, r19);
        return;
    L48:
        if (r0.equals("publish") == false) goto L99;
        Object r115 = r10.get("isSuccess");
        if ((r115 instanceof Boolean) == true) goto L52;
        r115 = null;
    L52:
        Boolean r116 = (Boolean) r115;
        s83.h r20 = d();
        if (r20 == null) goto L57;
        if (r116 == null) goto L56;
        r116.booleanValue();
    L56:
        r20.b();
    L57:
        s83.h r117 = d();
        if (r117 == null) goto L60;
        r19 = r117.c();
    L60:
        e(r11, r19);
        return;
    L62:
        if (r0.equals("addStage") == false) goto L99;
        Object r21 = r10.get("deliveryStage");
        if ((r21 instanceof String) == true) goto L66;
        r21 = null;
    L66:
        String r22 = (String) r21;
        if (r22 != null) goto L70;
        r22 = "";
    L70:
        if (r22.length() == 0) goto L73;
        r12 = false;
    L73:
        if (r12 == false) goto L76;
        r11.onFailed(0, "deliveryStage is empty");
        return;
    L76:
        Object r118 = r10.get("timestamp");
        if ((r118 instanceof Long) == true) goto L79;
        r118 = null;
    L79:
        Long r119 = (Long) r118;
        if (r119 == null) goto L82;
        long r23 = r119.longValue();
    L83:
        LinkedHashMap r120 = new LinkedHashMap();
        if (r15 == null) goto L92;
        Iterator<String> r24 = r15.keys();
        if (r24 == null) goto L92;
    L88:
        if (r24.hasNext() == false) goto L92;
        String r25 = r24.next();
        Object r26 = r15.opt(r25);
        if (r26 == null) goto L88;
        r120.put(r25, r26);
    L92:
        r120.put("delivery_session_id", r1);
        int r27 = ECSdk.a;
        s83.g r28 = (s83.g) ECSdk.a(s83.g.class);
        if (r28 == null) goto L95;
        r28.H(r22, r23, r120);
    L95:
        s83.h r121 = d();
        if (r121 == null) goto L98;
        r19 = r121.c();
    L98:
        e(r11, r19);
        return;
    L82:
        r23 = System.currentTimeMillis();
        goto L83
    L10:
        r14 = false;
        goto L11
    L5:
        r13 = false;
        goto L6
    }
}
