package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "mall.deliveryRecord")
public final class ECMallDeliveryRecordXMethod extends f {
    public final Lazy d;

    public final s83.h a() {
        return (s83.h) this.d.getValue();
    }

    public ECMallDeliveryRecordXMethod() {
        this.d = LazyKt.lazy(ECMallDeliveryRecordXMethod$monitorServer$2.INSTANCE);
    }

    public final void b(String r10, CompletionBlock<f.c> r11) {
        r11.onFailure(0, r10, ne7.e.c(Reflection.getOrCreateKotlinClass(f.c.class)));
    }

    public final void c(CompletionBlock<f.c> r10, Map<String, ? extends Object> r11) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L10
        if (r11 == null) goto L8;
        Iterator<Map.Entry<String, ? extends Object>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r13 = r12.next();     // Catch: Throwable -> L10
        r1.putOpt(r13.getKey(), r13.getValue());     // Catch: Throwable -> L10
    L8:
        f.c r14 = ne7.e.c(Reflection.getOrCreateKotlinClass(f.c.class));     // Catch: Throwable -> L10
        r14.setDeliveryInfo(r1);     // Catch: Throwable -> L10
        CompletionBlock.DefaultImpls.onSuccess$default(r10, r14, null, 2, null);     // Catch: Throwable -> L10
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L19;
        b("getRecord failed: " + r16.getMessage(), r10);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void handle(IBDXBridgeContext r10, XBaseParamModel r11, CompletionBlock r12) {
        f.b r13 = (f.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r14 = r13.getActionType();
        String r0 = r13.getSessionID();
        boolean r15 = false;
        if (r14.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L115:
        b("actionType or sessionId is null", r12);
        return;
    L8:
        if (r0.length() != 0) goto L10;
        boolean r16 = true;
    L11:
        if (r16 == true) goto L115;
        Object r17 = r13.getDeliveryRecord();
        Map<String, ? extends Object> r18 = null;
        if ((r17 instanceof JSONObject) == false) goto L17;
        JSONObject r19 = (JSONObject) r17;
    L38:
        LinkedHashMap r20 = new LinkedHashMap();
        if (r19 == null) goto L46;
        Iterator<String> r21 = r19.keys();
        if (r21 == null) goto L46;
    L43:
        if (r21.hasNext() == false) goto L46;
        String r22 = r21.next();
        r20.put(r22, r19.opt(r22));
    L46:
        switch(r14.hashCode()) {
            case -1246914851: goto L84;
            case -235365105: goto L73;
            case 96417: goto L64;
            case 102230: goto L58;
            case 1919834714: goto L49;
            default: goto L113;
        };
    L113:
        b("actionType is error", r12);
        return;
    L49:
        if (r14.equals("publishTTI") == false) goto L113;
        s83.h r110 = a();
        if (r110 == null) goto L53;
        r110.a();
    L53:
        s83.h r111 = a();
        if (r111 == null) goto L56;
        r18 = r111.c();
    L56:
        c(r12, r18);
        return;
    L58:
        if (r14.equals("get") == false) goto L113;
        s83.h r112 = a();
        if (r112 == null) goto L62;
        r18 = r112.c();
    L62:
        c(r12, r18);
        return;
    L64:
        if (r14.equals("add") == false) goto L113;
        s83.h r113 = a();
        if (r113 == null) goto L68;
        r113.d();
    L68:
        s83.h r114 = a();
        if (r114 == null) goto L71;
        r18 = r114.c();
    L71:
        c(r12, r18);
        return;
    L73:
        if (r14.equals("publish") == false) goto L113;
        Boolean r115 = r13.isSuccess();
        s83.h r116 = a();
        if (r116 == null) goto L79;
        if (r115 == null) goto L78;
        r115.booleanValue();
    L78:
        r116.b();
    L79:
        s83.h r117 = a();
        if (r117 == null) goto L82;
        r18 = r117.c();
    L82:
        c(r12, r18);
        return;
    L84:
        if (r14.equals("addStage") == false) goto L113;
        String r118 = r13.getDeliveryStage();
        if (r118 != null) goto L89;
        r118 = "";
    L89:
        if (r118.length() != 0) goto L91;
        r15 = true;
    L91:
        if (r15 == false) goto L93;
        b("deliveryStage is empty", r12);
        return;
    L93:
        Long r119 = r13.getTimestamp();
        if (r119 == null) goto L96;
        long r23 = r119.longValue();
    L97:
        LinkedHashMap r120 = new LinkedHashMap();
        if (r19 == null) goto L106;
        Iterator<String> r24 = r19.keys();
        if (r24 == null) goto L106;
    L102:
        if (r24.hasNext() == false) goto L106;
        String r25 = r24.next();
        Object r26 = r19.opt(r25);
        if (r26 == null) goto L102;
        r120.put(r25, r26);
    L106:
        r120.put("delivery_session_id", r0);
        int r27 = ECSdk.a;
        s83.g r28 = (s83.g) ECSdk.a(s83.g.class);
        if (r28 == null) goto L109;
        r28.H(r118, r23, r120);
    L109:
        s83.h r121 = a();
        if (r121 == null) goto L112;
        r18 = r121.c();
    L112:
        c(r12, r18);
        return;
    L96:
        r23 = System.currentTimeMillis();
        goto L97
    L17:
        if ((r17 instanceof Map) == false) goto L36;
        JSONObject r29 = new JSONObject();
        Set r30 = ((Map) r17).entrySet();
        ArrayList r31 = new ArrayList();
        Iterator r32 = r30.iterator();
    L20:
        if (r32.hasNext() == false) goto L24;
        Object r33 = r32.next();
        if ((((Map.Entry) r33).getKey() instanceof String) == false) goto L20;
        r31.add(r33);
        goto L20
    L24:
        Iterator r34 = r31.iterator();
    L26:
        if (r34.hasNext() == false) goto L35;
        Map.Entry r35 = (Map.Entry) r34.next();
        Object r36 = r35.getKey();
        if (r36 == null) goto L34;
        r29.putOpt((String) r36, r35.getValue());     // Catch: Exception -> L32
        goto L26
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L35:
        r19 = r29;
        goto L38
    L36:
        if (r17 != null) goto L114;
        r19 = null;
        goto L38
    L114:
        b("deliveryRecord type not supported: ".concat(r17.getClass().getSimpleName()), r12);
        return;
    L10:
        r16 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }
}
