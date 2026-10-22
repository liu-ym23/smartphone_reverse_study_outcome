package com.ss.android.lark.message.card.utils;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.setting.MessageCardTimeFormatConfig;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CardTimeFormatUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(CardTimeFormatUtils$defaultFormat$2.INSTANCE);
        b = LazyKt.lazy(CardTimeFormatUtils$messageCardTimeFormatConfig$2.INSTANCE);
    }

    public static MessageCardTimeFormatConfig b() {
        return (MessageCardTimeFormatConfig) b.getValue();
    }

    public static String a(String r8, Locale r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "formatType");
        boolean r1 = true;
        String r5 = "";
        if (com.ss.android.lark.message.card.b.a().is12HourClock() == false) goto L74;
        if (r10 == false) goto L74;
        String r11 = r8 + "_12";
        MessageCardTimeFormatConfig r0 = b();     // Catch: JSONException -> L18
        if (r0 == null) goto L17;
        JSONObject r2 = r0.localeLanguageFormat;     // Catch: JSONException -> L18
        if (r2 == null) goto L17;
        if (r9 == null) goto L12;
        String r7 = r9.toLanguageTag();     // Catch: JSONException -> L18
    L13:
        JSONObject r3 = r2.optJSONObject(r7);     // Catch: JSONException -> L18
        if (r3 == null) goto L17;
        String r12 = JSONObjectProtectorUtils.getString(r3, r11);     // Catch: JSONException -> L18
    L20:
        if (r12 != null) goto L22;
    L25:
        boolean r4 = true;
    L26:
        if (r4 == true) goto L76;
        return r12;
    L76:
        MessageCardTimeFormatConfig r13 = b();     // Catch: JSONException -> L40
        if (r13 == null) goto L39;
        JSONObject r14 = r13.localeLanguageFormat;     // Catch: JSONException -> L40
        if (r14 == null) goto L39;
        if (r9 == null) goto L34;
        String r15 = r9.toLanguageTag();     // Catch: JSONException -> L40
    L35:
        JSONObject r16 = r14.optJSONObject(r15);     // Catch: JSONException -> L40
        if (r16 == null) goto L39;
        r5 = JSONObjectProtectorUtils.getString(r16, r8);     // Catch: JSONException -> L40
    L42:
        if (r5 != null) goto L44;
    L47:
        if (r1 == true) goto L71;
        return r5;
    L71:
        return (String) ((Map) a.getValue()).get(r8);
    L44:
        if (r5.length() == 0) goto L47;
        r1 = false;
        goto L47
    L34:
        r15 = null;
    L39:
        r5 = null;
    L40:
        e = move-exception;
        Log.e("TimeFormatUtil", "getLocaleFormatTypeFormat is exception", e);
        goto L42
    L22:
        if (r12.length() == 0) goto L25;
        r4 = false;
        goto L26
    L12:
        r7 = null;
    L17:
        r12 = null;
    L18:
        e = move-exception;
        Log.e("TimeFormatUtil", "getLocaleFormatTypeFormat is exception", e);
        r12 = "";
    L74:
        MessageCardTimeFormatConfig r17 = b();     // Catch: JSONException -> L61
        if (r17 == null) goto L60;
        JSONObject r18 = r17.localeLanguageFormat;     // Catch: JSONException -> L61
        if (r18 == null) goto L60;
        if (r9 == null) goto L55;
        String r19 = r9.toLanguageTag();     // Catch: JSONException -> L61
    L56:
        JSONObject r20 = r18.optJSONObject(r19);     // Catch: JSONException -> L61
        if (r20 == null) goto L60;
        r5 = JSONObjectProtectorUtils.getString(r20, r8);     // Catch: JSONException -> L61
    L63:
        if (r5 != null) goto L65;
    L68:
        if (r1 == true) goto L71;
        return r5;
    L65:
        if (r5.length() == 0) goto L68;
        r1 = false;
        goto L68
    L55:
        r19 = null;
    L60:
        r5 = null;
    L61:
        e = move-exception;
        Log.e("TimeFormatUtil", "getLocaleFormatTypeFormat is exception", e);
        goto L63
    }

    public static String c(String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "formatType");
        Intrinsics.checkNotNullParameter(r8, "translateLanguage");
        boolean r1 = true;
        String r3 = null;
        String r6 = "";
        if (com.ss.android.lark.message.card.b.a().is12HourClock() == false) goto L65;
        if (r9 == false) goto L65;
        String r10 = r7 + "_12";
        MessageCardTimeFormatConfig r0 = b();     // Catch: JSONException -> L15
        if (r0 == null) goto L14;
        JSONObject r2 = r0.translateFormat;     // Catch: JSONException -> L15
        if (r2 == null) goto L14;
        JSONObject r4 = r2.optJSONObject(r8);     // Catch: JSONException -> L15
        if (r4 == null) goto L14;
        String r11 = JSONObjectProtectorUtils.getString(r4, r10);     // Catch: JSONException -> L15
    L17:
        if (r11 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == true) goto L61;
        return r11;
    L61:
        MessageCardTimeFormatConfig r12 = b();     // Catch: JSONException -> L33
        if (r12 == null) goto L32;
        JSONObject r13 = r12.translateFormat;     // Catch: JSONException -> L33
        if (r13 == null) goto L32;
        JSONObject r14 = r13.optJSONObject(r8);     // Catch: JSONException -> L33
        if (r14 == null) goto L32;
        r3 = JSONObjectProtectorUtils.getString(r14, r7);     // Catch: JSONException -> L33
    L32:
        r6 = r3;
    L35:
        if (r6 != null) goto L37;
    L40:
        if (r1 == true) goto L60;
        return r6;
    L60:
        return (String) ((Map) a.getValue()).get(r7);
    L37:
        if (r6.length() == 0) goto L40;
        r1 = false;
    L33:
        e = move-exception;
        Log.e("TimeFormatUtil", "getTranslateFormatTypeFormat is exception", e);
        goto L35
    L19:
        if (r11.length() == 0) goto L22;
        r5 = false;
    L14:
        r11 = null;
    L15:
        e = move-exception;
        Log.e("TimeFormatUtil", "getTranslateFormatTypeFormat is exception", e);
        r11 = "";
    L65:
        MessageCardTimeFormatConfig r15 = b();     // Catch: JSONException -> L50
        if (r15 == null) goto L49;
        JSONObject r16 = r15.translateFormat;     // Catch: JSONException -> L50
        if (r16 == null) goto L49;
        JSONObject r17 = r16.optJSONObject(r8);     // Catch: JSONException -> L50
        if (r17 == null) goto L49;
        r3 = JSONObjectProtectorUtils.getString(r17, r7);     // Catch: JSONException -> L50
    L49:
        r6 = r3;
    L52:
        if (r6 != null) goto L54;
    L57:
        if (r1 == true) goto L60;
        return r6;
    L54:
        if (r6.length() == 0) goto L57;
        r1 = false;
    L50:
        e = move-exception;
        Log.e("TimeFormatUtil", "getTranslateFormatTypeFormat is exception", e);
        goto L52
    }
}
