package com.bytedance.android.ec.common.impl.hybrid.bridges;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import ul.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/ECOpenSkuMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenSkuMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECOpenSkuMethod() {
        this.e = "openNativeSKU";
    }

    public final String getName() {
        return this.e;
    }

    public final d d(JSONObject r10) {
        String r0 = r10.optString("btm");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        JSONObject r11 = r10.optJSONObject("bcm");
        d r12 = new d();
        r12.a = r0;
        r12.b = PageFinder.via(b().a);
        BcmParams.Companion.getClass();
        r12.c = BcmParams.a.b(r11);
        return r12;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void c(JSONObject r123, ECBaseBridgeMethod.a r124) {
        Intrinsics.checkNotNullParameter(r123, "params");
        Intrinsics.checkNotNullParameter(r124, "iReturn");
        String r10 = r123.optString(a.KEY_PAGE_NAME, "");
        String r23 = r123.optString(a.KEY_PROMOTION_ID, "");
        String r15 = r123.optString(a.KEY_PRODUCT_ID, "");
        JSONArray r11 = r123.optJSONArray("selected_ids");
        String r27 = r123.optString(a.KEY_SKU_ID, "");
        long r12 = r123.optLong("selected_count", 1);
        String r13 = r123.optString(a.KEY_COMMODITY_ID, "");
        String r14 = r123.optString(a.KEY_AUTHOR_ID, "");
        String r34 = r123.optString(a.KEY_SEC_AUTHOR_ID, "");
        String r35 = r123.optString(a.KEY_ROOM_ID, "");
        long r20 = r123.optLong(a.KEY_BUTTON_TYPE, 0);
        String r50 = r123.optString("address_id", "");
        String r62 = r123.optString(a.KEY_MARKET_CHANNEL, "");
        String r73 = r123.optString(a.KEY_ENTRANCE_INFO, "");
        String r36 = r123.optString(a.KEY_COMBINATION_ID, "");
        String r103 = r123.optString("extra_params", "");
        String r43 = r123.optString("channel_id", "");
        int r16 = r123.optInt("channel_type", 0);
        int r17 = r123.optInt("force_yata_sku", 0);
        String r42 = r123.optString("biz_identifier", "");
        String r18 = r123.optString("mask_background_color", "");
        if (r23.length() != 0) goto L5;
        boolean r19 = true;
    L6:
        if (r19 == true) goto L102;
        if (r15.length() != 0) goto L10;
        boolean r21 = true;
    L11:
        if (r21 == true) goto L102;
        if (r12 <= 0) goto L102;
        Activity r22 = ECAppInfoService.e.getCurrentActivity();
        if ((r22 instanceof FragmentActivity) == true) goto L18;
        r22 = null;
    L18:
        FragmentActivity r24 = (FragmentActivity) r22;
        if (r24 == null) goto L100;
        FragmentManager r1 = r24.getSupportFragmentManager();
        if (r1 == null) goto L100;
        if (r11 != null) goto L105;
        String[] r25 = null;
    L28:
        JSONObject r26 = new JSONObject(r123.optString("event_params", "{}"));     // Catch: Exception -> L25
        LinkedHashMap r28 = new LinkedHashMap();     // Catch: Exception -> L25
        Iterator<String> r29 = r26.keys();     // Catch: Exception -> L25
    L30:
        if (r29.hasNext() == false) goto L34;
        Iterator<String> r210 = r29;
        String r30 = r29.next();     // Catch: Exception -> L25
        JSONObject r211 = r26;
        r28.put(r30, r26.get(r30).toString());     // Catch: Exception -> L25
        r29 = r210;
        r26 = r211;
        goto L30
    L34:
        if (r10 != null) goto L37;
    L54:
        long r212 = 999;
    L55:
        long r31 = r212;
        int r32 = r123.optInt("scene_type", h.a(r31, null, false, null, false, 30));     // Catch: Exception -> L25
        int r33 = 0;
        int r37 = r123.optInt(a.KEY_ACTION_TYPE, ul.d.b(r31, false, 6));     // Catch: Exception -> L94
        if (r32 != 101) goto L60;
    L74:
        String r38 = a.VALUE_PRODUCT_DETAIL;
    L75:
        String r77 = r38;
    L76:
        int r39 = ECSdk.a;     // Catch: Exception -> L94
        IECCommonService r117 = (IECCommonService) ECSdk.a(IECCommonService.class);     // Catch: Exception -> L94
        if (r117 == null) goto L89;
        if (r11 == null) goto L81;
        int r40 = r11.length();     // Catch: Exception -> L94
    L82:
        SkuRestoreState r110 = new SkuRestoreState(r40);     // Catch: Exception -> L94
        SkuRestoreState.saveSelectedSpec$default(r110, r25, Long.valueOf(r12), r27, null, null, null, 0, 120, null);     // Catch: Exception -> L94
        Unit r41 = Unit.INSTANCE;     // Catch: Exception -> L94
        LinkedHashMap r111 = new LinkedHashMap();     // Catch: Exception -> L94
        r111.put(a.KEY_COMMODITY_ID, r13);     // Catch: Exception -> L94
        r111.put(a.KEY_PRODUCT_ID, r15);     // Catch: Exception -> L94
        r111.put(a.KEY_AUTHOR_ID, r14);     // Catch: Exception -> L94
        r111.put(a.KEY_PAGE_NAME, r10);     // Catch: Exception -> L94
        r111.putAll(r28);     // Catch: Exception -> L94
        IECCommonService.a.d(r117, r1, new SkuParams(null, new SkuExtraData(null, null, false, null, null, null, null, null, null, null, r62, null, null, 7167, null), r110, null, null, 0, null, null, null, false, false, null, null, false, r15, r23, null, false, null, r36, r14, r34, null, null, r35, Long.valueOf(r20).equals(1L), r37, r32, null, null, 0, null, null, null, r42, r43, Integer.valueOf(r16), null, null, null, null, null, r50, null, null, null, false, null, null, null, Integer.valueOf(r17), false, false, false, null, null, null, r18, 0.0f, null, null, null, null, null, null, r73, null, r111, null, r77, null, 0, "ECOpenSkuMethod-handle", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, false, null, r103, null, null, null, null, null, null, -255377415, -33817629, -1073742123, 31, null), null, d(r123), null, null, null, ECOpenSkuMethod$handle$3.INSTANCE, null, new ECOpenSkuMethod$handle$4(this), null, 0, null, null, null, 30720);     // Catch: Exception -> L86
    L86:
        e = e;
    L96:
        ECBaseBridgeMethod.a r44 = r124;
    L97:
        ECExceptionMonitor.e(e);
        r44.onFailed(r33, e.toString());
        return;
    L81:
        r40 = 1;
    L89:
        r44 = r124;
        r44.onSuccess("{}");     // Catch: Exception -> L92
        return;
    L92:
        e = e;
        goto L97
    L60:
        if (r32 == 102) goto L74;
        if (r32 != 201) goto L64;
        r38 = "live";
        goto L75
    L64:
        if (r32 != 901) goto L66;
        r38 = "cart";
        goto L75
    L66:
        if (r32 != 1001) goto L68;
        r38 = "exchange";
        goto L75
    L68:
        if (r32 == 1301) goto L70;
        r38 = "jsb";
        goto L75
    L70:
        r77 = "mix_page";
    L94:
        e = e;
    L25:
        e = e;
        r44 = r124;
        r33 = 0;
        goto L97
    L37:
        switch(r10.hashCode()) {
            case -1320774386: goto L52;
            case -1172298460: goto L49;
            case -1081930094: goto L46;
            case -828405016: goto L43;
            case -688094775: goto L40;
            default: goto L54;
        };     // Catch: Exception -> L25
    L40:
        if (r10.equals("insurance_apply") == false) goto L54;
        r212 = 4;
        goto L55
    L43:
        if (r10.equals("supermarket_cart") == false) goto L54;
        r212 = 13;
        goto L55
    L46:
        if (r10.equals("mix_page") == false) goto L54;
        r212 = 11;
        goto L55
    L49:
        if (r10.equals("shop_cart_tag") == false) goto L54;
        r212 = 2;
        goto L55
    L52:
        if (r10.equals("onecent") == false) goto L54;
        r212 = 12;
        goto L55
    L105:
        r25 = (String[]) new Gson().fromJson(r11.toString(), String[].class);     // Catch: Exception -> L25
    L100:
        return;
    L10:
        r21 = false;
    L102:
        return;
    L5:
        r19 = false;
        goto L6
    }
}
