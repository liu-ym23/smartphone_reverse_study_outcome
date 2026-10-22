package com.larksuite.component.card.settings;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.log.Log;
import idb.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@AppConfig(key = LynxCardCommonConfig.COMMON_CONFIG, parse = "parseConfig")
public class LynxCardCommonConfig {
    public static final String COMMON_CONFIG = "msg_card_common_config";
    private static final String TAG = "LynxCardCommonConfig";

    @SerializedName("blackMonitorQueryKey")
    public JSONArray blackMonitorQueryKey;
    public JSONObject mConfig;

    @SerializedName("screenConfig")
    public JSONObject screenConfig;

    @SerializedName("toastJumpUrlMap")
    public Map<String, String> toastJumpUrlMap;

    @SerializedName("trackDomains")
    public JSONArray trackDomains;

    public LynxCardCommonConfig() {
    }

    public void parseConfig(String r7) {
        this.mConfig = new JSONObject(r7);     // Catch: JSONException -> L15
        if (f.a().isEnable("openplatform.universal_card.chart_settings_memopt") == false) goto L6;
        Log.i(TAG, "enable memory opt");     // Catch: JSONException -> L15
        this.mConfig.remove("chart");     // Catch: JSONException -> L15
        this.mConfig.remove("chartMediaQuery");     // Catch: JSONException -> L15
    L7:
        this.mConfig.remove("screenConfig");     // Catch: JSONException -> L15
        JSONObject r8 = this.mConfig.optJSONObject("toastJumpUrlMap");     // Catch: JSONException -> L15
        if (r8 == null) goto L13;
        this.toastJumpUrlMap = new HashMap();     // Catch: JSONException -> L15
        Iterator<String> r2 = r8.keys();     // Catch: JSONException -> L15
    L11:
        if (r2.hasNext() == false) goto L13;
        String r3 = r2.next();     // Catch: JSONException -> L15
        this.toastJumpUrlMap.put(r3, r8.optString(r3));     // Catch: JSONException -> L15
    L13:
        this.screenConfig = this.mConfig.optJSONObject("screenConfig");     // Catch: JSONException -> L15
        this.trackDomains = JSONObjectProtectorUtils.getJSONArray(this.mConfig, "trackDomains");     // Catch: JSONException -> L15
        this.blackMonitorQueryKey = JSONObjectProtectorUtils.getJSONArray(this.mConfig, "blackMonitorQueryKey");     // Catch: JSONException -> L15
        return;
    L6:
        Log.i(TAG, "disable memory opt");     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        Log.e(TAG, e);
    }
}
