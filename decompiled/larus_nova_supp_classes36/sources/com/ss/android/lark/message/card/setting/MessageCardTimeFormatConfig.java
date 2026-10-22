package com.ss.android.lark.message.card.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "messagecard_time_format_i18n_config", parse = "parseConfig")
public class MessageCardTimeFormatConfig {
    public static final String LOCALE_LANGUAGE_FORMAT_KEY = "locale_language_format_mobile";
    public static final String TAG = "TimeFormatConfig";
    public static final String TRANSLATE_LANGUAGE_FORMAT_KEY = "translate_format_mobile";

    @SerializedName(LOCALE_LANGUAGE_FORMAT_KEY)
    public JSONObject localeLanguageFormat;

    @SerializedName(TRANSLATE_LANGUAGE_FORMAT_KEY)
    public JSONObject translateFormat;

    public MessageCardTimeFormatConfig() {
    }

    public void parseConfig(String r2) {
        JSONObject r0 = new JSONObject(r2);     // Catch: JSONException -> L4
        this.localeLanguageFormat = r0.optJSONObject(LOCALE_LANGUAGE_FORMAT_KEY);     // Catch: JSONException -> L4
        this.translateFormat = r0.optJSONObject(TRANSLATE_LANGUAGE_FORMAT_KEY);     // Catch: JSONException -> L4
        return;
    }
}
