package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.AnnieParamUtil;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.verify.utils.IIdentityVerifyService;
import com.bytedance.android.livesdk.config.tj;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getClientSetting")
public final class ca extends com.bytedance.ies.web.jsbridge2.f<c, JsonObject> {
    public static final boolean a = false;

    public class a extends TypeToken<List<Object>> {
        public a() {
        }
    }

    public class b extends TypeToken<List<Object>> {
        public b() {
        }
    }

    public static final class c {

        @SerializedName("key")
        public String key;

        @SerializedName("path")
        public String path;

        @SerializedName("type")
        public String type;

        public c() {
        }
    }

    public final void onTerminate() {
    }

    static {
        a = ((Boolean) com.bytedance.android.livesdk.config.d4.a.getValue()).booleanValue();
    }

    public ca() {
    }

    public final /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r2) throws Exception {
        j((c) r1, r2);
    }

    public final void j(c r12, CallContext r13) throws Exception {
        JsonObject r5 = new JsonObject();
        JsonObject r3 = new JsonObject();
        if (TextUtils.isEmpty(r12.key) == true) goto L5;
    L8:
        String r4 = r12.key;
        String r0 = r12.path;
        int r2 = 0;
        if (TextUtils.isEmpty(r0) == true) goto L69;
        if (TextUtils.isEmpty(r12.key) == true) goto L69;
        Object r14 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r4);
        String[] r15 = r0.split("\\.");
        Gson r1 = GsonHelper.get();
        int r7 = 0;
    L14:
        if (r7 >= r15.length) goto L53;
        String r8 = r15[r7];
        if ((r14 instanceof JSONObject) == false) goto L21;
        JSONObject r16 = (JSONObject) r14;
        if (r16.has(r8) == false) goto L51;
        r14 = r16.get(r8);
    L52:
        r7 = r7 + 1;
    L51:
        r14 = null;
        goto L53
    L21:
        if ((r14 instanceof JSONArray) == false) goto L27;
        JSONArray r17 = (JSONArray) r14;
        int r9 = r17.length();
        int r11 = CastIntegerProtector.parseInt(r8);
        if (r11 < 0) goto L51;
        if (r11 >= r9) goto L51;
        r14 = r17.get(r11);
        goto L52
    L27:
        if ((r14 instanceof String) == false) goto L52;
        String r18 = (String) r14;
        if (TextUtils.isEmpty(r18) == false) goto L110;
    L34:
        boolean r19 = false;
    L35:
        if (r19 == false) goto L40;
        JSONObject r110 = new JSONObject(r18);
        if (r110.has(r8) == false) goto L51;
        r14 = r110.get(r8);
        goto L52
    L40:
        if (TextUtils.isEmpty(r18) == false) goto L108;
    L45:
        boolean r111 = false;
    L46:
        if (r111 == false) goto L52;
        JSONArray r112 = new JSONArray(r18);
        int r21 = r112.length();
        int r22 = CastIntegerProtector.parseInt(r8);
        if (r22 < 0) goto L51;
        if (r22 >= r21) goto L51;
        r14 = r112.get(r22);
        goto L52
    L108:
        new JSONArray(r18);     // Catch: Exception -> L44
        r111 = true;
        goto L46
    L110:
        JsonUtil.parseObject(r18);     // Catch: Exception -> L33
        r19 = true;
    L53:
        if (r14 != null) goto L55;
    L106:
        r5.add("data", r3);
        finishWithResult(r5);
        return;
    L55:
        if ((r14 instanceof JSONObject) == false) goto L58;
        JsonElement r113 = GsonProtectorUtils.toJsonTree(r1, GsonProtectorUtils.fromJson(r1, ((JSONObject) r14).toString(), Object.class));
    L67:
        r3.add(r4 + "." + r0, r113);
        goto L106
    L58:
        if ((r14 instanceof JSONArray) == false) goto L61;
        r113 = GsonProtectorUtils.toJsonTree(r1, GsonProtectorUtils.fromJson(r1, ((JSONArray) r14).toString(), new a().getType()));
        goto L67
    L61:
        if ((r14 instanceof Boolean) == true) goto L63;
        r113 = GsonProtectorUtils.toJsonTree(r1, r14);
        goto L67
    L63:
        if (((Boolean) r14).booleanValue() == false) goto L65;
        r113 = GsonProtectorUtils.toJsonTree(r1, 1);
        goto L67
    L65:
        r113 = GsonProtectorUtils.toJsonTree(r1, 0);
    L69:
        if ("live_certification_setting_dic".equals(r4) == false) goto L87;
        IIdentityVerifyService r114 = (IIdentityVerifyService) jc1.k.f(IIdentityVerifyService.class);
        if (r114 != null) goto L73;
    L76:
        if (r114 == null) goto L106;
        JsonObject r115 = new JsonObject();
        String r6 = r114.getRealFaceIdentify();
        com.bytedance.android.livesdk.model.n r23 = (com.bytedance.android.livesdk.model.n) tj.a.getValue();
        if (r23 == null) goto L106;
        boolean r116 = r114.hostOCRSdkReady();
        r115.addProperty("live_certification_setting_face_identify", r6);
        if (r116 == false) goto L82;
        String r24 = r23.b();
    L83:
        r115.addProperty("live_certification_setting_info_input", r24);
        r115.addProperty("live_certification_setting_show_artificial_entrance", Boolean.valueOf(r23.a()));
        if (r116 == false) goto L86;
        r2 = r23.c();
    L86:
        r115.addProperty("live_certification_setting_manual_use_ocr", Integer.valueOf(r2));
        r3.add(r4, r115);
        goto L106
    L82:
        r24 = "default";
        goto L83
    L73:
        if (r114.supportTryPreload() == false) goto L76;
        r114.getRealFaceIdentifySync(r13.getContext(), true, new ba(this, r114, r3, r4, r5));
        return;
    L87:
        Gson r117 = GsonHelper.get();
        if (a == false) goto L90;
        Object r118 = AnnieParamUtil.h(r4);
    L91:
        if (r118 == null) goto L106;
        if ((r118 instanceof JSONObject) == false) goto L96;
        JsonElement r119 = GsonProtectorUtils.toJsonTree(r117, GsonProtectorUtils.fromJson(r117, ((JSONObject) r118).toString(), Object.class));
    L105:
        r3.add(r4, r119);
        goto L106
    L96:
        if ((r118 instanceof JSONArray) == false) goto L99;
        r119 = GsonProtectorUtils.toJsonTree(r117, GsonProtectorUtils.fromJson(r117, ((JSONArray) r118).toString(), new b().getType()));
        goto L105
    L99:
        if ((r118 instanceof Boolean) == true) goto L101;
        r119 = GsonProtectorUtils.toJsonTree(r117, r118);
        goto L105
    L101:
        if (((Boolean) r118).booleanValue() == false) goto L103;
        r119 = GsonProtectorUtils.toJsonTree(r117, 1);
        goto L105
    L103:
        r119 = GsonProtectorUtils.toJsonTree(r117, 0);
        goto L105
    L90:
        r118 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r4);
        goto L91
    L5:
        if (TextUtils.isEmpty(r12.path) == false) goto L8;
        finishWithResult(r5);
    }
}
