package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECVerifyReport;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECVerifyReport extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECVerifyReport() {
        this.e = "ecVerifyReport";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(final JSONObject r43, final ECBaseBridgeMethod.a r44) {
        String r14 = "attribute";
        String r13 = "owner";
        String r12 = "level";
        String r11 = MessageIndication.MESSAGE_TYPE_MSG;
        String r10 = com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME;
        String r15 = "context";
        String r16 = "params";
        Intrinsics.checkNotNullParameter(r43, "params");
        Intrinsics.checkNotNullParameter(r44, "iReturn");
        JSONObject r17 = r43.optJSONObject("errorContent");     // Catch: Exception -> L25
        if (r17 == null) goto L23;
        JSONArray r18 = r17.optJSONArray("errorList");     // Catch: Exception -> L25
        if (r18 != null) goto L34;
    L18:
        ECBaseBridgeMethod.a r1 = r44;
        String r19 = null;
        r1.onSuccess(null);     // Catch: Exception -> L21
        return;
    L21:
        e = e;
    L27:
        ECExceptionMonitor.e(e);
    L28:
        r1.onFailed(0, r19);
        return;
    L34:
    L14:
        e = e;
        r1 = r44;
    L16:
        r19 = null;
        goto L27
    L8:
        if (r18.length() <= 0) goto L18;
        UUID r20 = UUID.randomUUID();     // Catch: Exception -> L14
        int r21 = ECSdk.a;     // Catch: Exception -> L14
        pi.b r22 = (pi.b) ECSdk.a(pi.b.class);     // Catch: Exception -> L14
        if (r22 == null) goto L18;
        String r23 = r17.optString("params");     // Catch: Exception -> L14
        String r24 = r17.optString("context");     // Catch: Exception -> L14
        String r25 = r17.optString("errorEvent");     // Catch: Exception -> L14
        ih.a.d.getClass();     // Catch: Exception -> L14
        ih.a.b.getClass();     // Catch: Exception -> L14
        JSONObject r0 = ih.a.b();     // Catch: Exception -> L14
        final StringBuilder r26 = new StringBuilder();     // Catch: Exception -> L14
        final StringBuilder r27 = new StringBuilder();     // Catch: Exception -> L14
        final StringBuilder r28 = new StringBuilder();     // Catch: Exception -> L14
        Ref.IntRef r110 = new Ref.IntRef();     // Catch: Exception -> L14
        JSONObject r111 = r17;
        r110.element = 1;     // Catch: Exception -> L14
        int r29 = r18.length();     // Catch: Exception -> L14
        Ref.IntRef r112 = r110;
        int r113 = 0;
    L12:
        if (r113 >= r29) goto L17;
        int r210 = r29;
        JSONObject r30 = JSONArrayProtectorUtils.getJSONObject(r18, r113);     // Catch: Exception -> L14
        final JSONArray r211 = r18;
        String r31 = r30.optString(r10);     // Catch: Exception -> L14
        int r212 = r113;
        String r114 = r30.optString(r11);     // Catch: Exception -> L14
        final pi.b r213 = r22;
        final int r32 = r30.optInt(r12);     // Catch: Exception -> L14
        final JSONObject r214 = r0;
        final String r33 = r30.optString(r13);     // Catch: Exception -> L14
        final String r215 = r24;
        final String r34 = r30.optString("errorType");     // Catch: Exception -> L14
        final String r35 = r30.optString(r14);     // Catch: Exception -> L14
        String r216 = r15;
        JSONObject r36 = new JSONObject();     // Catch: Exception -> L14
        final String r37 = r23;
        r36.put("error_event", r25);     // Catch: Exception -> L14
        r36.put(r13, r33);     // Catch: Exception -> L14
        r36.put(r11, r114);     // Catch: Exception -> L14
        r36.put(r10, r31);     // Catch: Exception -> L14
        r36.put("error_id", r20);     // Catch: Exception -> L14
        r36.put(r12, r32);     // Catch: Exception -> L14
        r36.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_TYPE, r34);     // Catch: Exception -> L14
        r36.put(r14, r35);     // Catch: Exception -> L14
        Unit r38 = Unit.INSTANCE;     // Catch: Exception -> L14
        JSONObject r39 = new JSONObject();     // Catch: Exception -> L14
        r39.put(r16, r37);     // Catch: Exception -> L14
        final String r217 = r25;
        r39.put(r216, r215);     // Catch: Exception -> L14
        r39.put("btm_chain", r214);     // Catch: Exception -> L14
        final UUID r115 = r20;
        r213.monitorEvent("ecom_vmsdk_check_param", r36, null, r39);     // Catch: Exception -> L14
        final JSONObject r218 = r111;
        String r310 = r11;
        final Ref.IntRef r116 = r112;
        com.bytedance.android.ec.sdk.helper.l.a(new ECVerifyReport$handle$$inlined$let$lambda$1(r34, r33, r35, r32, r213, r217, r37, r215, r214, r116, r27, r26, r28, r218, r211, r115, r43, r44));     // Catch: Exception -> L14
        r113 = r212 + 1;     // Catch: Exception -> L14
        r18 = r211;
        r111 = r218;
        r29 = r210;
        r112 = r112;
        r24 = r215;
        r25 = r217;
        r22 = r213;
        r23 = r37;
        r15 = r216;
        r20 = r115;
        r16 = r16;
        r10 = r10;
        r11 = r310;
        r12 = r12;
        r13 = r13;
        r14 = r14;
        r0 = r214;
        goto L12
    L17:
        final JSONObject r40 = r0;
        final UUID r311 = r20;
        final JSONArray r41 = r18;
        final String r219 = r24;
        final String r220 = r25;
        final JSONObject r221 = r111;
        com.bytedance.android.ec.sdk.helper.l.a(new ECVerifyReport$handle$$inlined$let$lambda$2(r220, r26, r40, r219, r27, r28, r221, r41, r311, r43, r44));     // Catch: Exception -> L14
        goto L18
    L23:
        r1 = r44;
        r19 = null;
    L25:
        e = e;
        r1 = r44;
        goto L16
    }
}
