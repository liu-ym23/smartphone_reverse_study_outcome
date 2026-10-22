package com.bytedance.android.btm.bridge;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmBridgeProvider {
    public static final /* synthetic */ KProperty[] a = null;
    public static final cd.c b = null;
    public static final BtmBridgeProvider c = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmBridgeProvider.class), "hybridContainerContext", "getHybridContainerContext()Lcom/bytedance/android/btm/bridge/IHybridContainerContext;"))};
        c = new BtmBridgeProvider();
        b = new cd.c(BtmBridgeProvider$hybridContainerContext$2.INSTANCE);
    }

    public BtmBridgeProvider() {
    }

    public static BtmItemBuilder a(JSONObject r10, View r11, final String r12) {
        if (r12 != null) goto L5;
        r12 = r10.optString("btm");
    L5:
        Object r1 = null;
        if (TextUtils.isEmpty(r12) == false) goto L8;
        return null;
    L8:
        ArrayList r0 = new ArrayList();
        JSONArray r13 = r10.optJSONArray("target_pages");
        if (r13 == null) goto L13;
        int r14 = r13.length();
        int r15 = 0;
    L11:
        if (r15 >= r14) goto L13;
        r0.add(r13.optString(r15));
        r15 = r15 + 1;
    L13:
        Object r16 = r10.opt("bcm_description");
        if (r16 != null) goto L16;
    L25:
        final boolean r17 = r10.optBoolean("enter_new_page", false);
        if (r11 != null) goto L28;
        g$a.a(BtmSDK.INSTANCE.getService().getMonitor(), 2025, null, null, new BtmBridgeProvider$createBtmBuilder$2(r12, r17), 30);
    L28:
        BtmItemBuilder r18 = new BtmItemBuilder(r12, Boolean.valueOf(r17)).withView(r11);
        r18.internalSetUnitParams("description", r1);
        return r18.setTargetPagesBtm(r0);
    L16:
        if ((r16 instanceof JSONObject) == false) goto L18;
        BcmParams.a r19 = BcmParams.Companion;
        Map<String, Object> r20 = cd.a.e((JSONObject) r16);
        r19.getClass();
        r1 = BcmParams.a.c(r20);
        goto L25
    L18:
        boolean r21 = r16 instanceof Map;
        if (r21 == false) goto L25;
        BcmParams.a r22 = BcmParams.Companion;
        if (r21 == false) goto L24;
        r1 = r16;
    L24:
        r22.getClass();
        r1 = BcmParams.a.c((Map) r1);
        goto L25
    }

    public static void c(final JSONObject r16, final View r17, Function3 r18) {
        final String r10 = r16.optString("btm");
        ALogger.c(ALogger.d, "FE_createBtmChain", new BtmBridgeProvider$createBtmChain$2(r16));
        if (TextUtils.isEmpty(r10.toString()) == false) goto L6;
        r18.invoke(Boolean.FALSE, null, "createBtmChain must have a btm param");
        return;
    L6:
        final BtmItemBuilder r11 = a(r16, r17, r10);
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = null;
        if (r11 == null) goto L15;
        final com.bytedance.android.btm.api.model.c r12 = r11.build();
        BtmSDK r1 = BtmSDK.INSTANCE;
        String r13 = r1.createBtmId(r12);
        r15.element = r13;
        if (r17 == null) goto L15;
        if (Intrinsics.areEqual(r13, "") == false) goto L15;
        g$a.a(r1.getService().getMonitor(), 2024, r10, null, new BtmBridgeProvider$createBtmChain$$inlined$apply$lambda$1(r12, r11, r15, r17, r10), 28);
    L15:
        if (r16.optBoolean("add_btm_chain") == false) goto L17;
        int r14 = r16.optInt("chain_length", 10);
    L18:
        BtmSDK r19 = BtmSDK.INSTANCE;
        Map r20 = r19.getService().generateBtmEventParams((String) r15.element, r14, null);
        if (r20 != null) goto L21;
    L24:
        boolean r21 = true;
    L25:
        if (r21 == false) goto L27;
        g$a.b(r19.getService().getMonitor(), 1112, null, null, false, 30);
    L27:
        LinkedHashMap r22 = new LinkedHashMap();
        Iterator r23 = r20.entrySet().iterator();
    L29:
        if (r23.hasNext() == false) goto L37;
        Map.Entry r24 = (Map.Entry) r23.next();
        if (r24.getValue() == null) goto L29;
        Object r25 = r24.getKey();
        Object r26 = r24.getValue();
        if (r26 != null) goto L35;
        Intrinsics.throwNpe();
    L35:
        r22.put(r25, r26);
        goto L29
    L37:
        if (r16.optBoolean("enter_new_page", false) == false) goto L43;
        String r0 = (String) r15.element;
        if (r0 == null) goto L43;
        if (r0 != null) goto L42;
        Intrinsics.throwNpe();
    L42:
        r22.put("btm_enter_page", r0);
    L43:
        r18.invoke(Boolean.TRUE, r22, "");
        return;
    L21:
        if (r20.isEmpty() == true) goto L24;
        r21 = false;
        goto L25
    L17:
        r14 = 0;
        goto L18
    }

    public static void b(XReadableMap r1, final XBridgeMethod.Callback r10, g66.c r11, final XCoreBridgeMethod r12) {
        if (r11 != null) goto L10;
        View r13 = null;
    L5:
        c(cd.a.c(r1.toMap()), r13, new BtmBridgeProvider$createBtmChain$1(r12, r10));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        int r14 = j.a;
        j.a(r12, r10, "Exception：" + e.getMessage());
        return;
    L10:
        r13 = HybridContainerContextManager.c(r11);     // Catch: Exception -> L7
        goto L5
    }
}
