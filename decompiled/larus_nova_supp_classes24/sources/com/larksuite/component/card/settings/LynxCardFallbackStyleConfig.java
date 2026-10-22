package com.larksuite.component.card.settings;

import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.log.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@AppConfig(key = "open_card_fallback_style_config_mobile", parse = "parseConfig")
public class LynxCardFallbackStyleConfig {
    public static final String TAG = "LynxCardFallbackStyleConfig";
    public JSONObject styleJson;

    public LynxCardFallbackStyleConfig() {
    }

    public void parseConfig(String r3) {
        this.styleJson = new JSONObject(r3);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "parseConfig exception", e);
    }
}
