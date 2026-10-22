package com.ss.android.lark.chameleon.util;

import android.text.TextUtils;
import com.ss.android.lark.chameleon.idependency.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LanguageUtil {
    private static final Map<String, String> LANGUAGE_MAP = null;
    private static final Map<String, String> LANGUAGE_TRANSFORM = null;
    private static final String TAG = "LanguageUtil";

    public LanguageUtil() {
    }

    static {
        HashMap r0 = new HashMap();
        LANGUAGE_MAP = r0;
        HashMap r1 = new HashMap();
        LANGUAGE_TRANSFORM = r1;
        r0.put(Locale.ENGLISH.getLanguage(), "en-US");
        r0.put(Locale.JAPANESE.getLanguage(), "ja-JP");
        r0.put(Locale.CHINA.getLanguage(), "zh-CN");
        r0.put("hi", "hi-IN");
        r0.put("ru", "ru-RU");
        r0.put("ko", "ko-KR");
        r0.put("th", "th-TH");
        r0.put("vi", "vi-VN");
        r0.put("id", "id-ID");
        r0.put("in", "id-ID");
        r0.put("pt", "pt-BR");
        r0.put("fr", "fr-FR");
        r0.put("de", "de-DE");
        r0.put("it", "it-IT");
        r0.put("es", "es-ES");
        r0.put("hk", "zh-HK");
        r0.put("tw", "zh-TW");
        r0.put("cn", "zh-CN");
        r0.put("ms", "ms-MY");
        r1.put("in", "id");
    }

    public static String convertLan(String r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        Log.e(TAG, "convertLan(): lan is Null");
        return BuildConfig.FLAVOR;
    L7:
        if (r4.equals("zh") == false) goto L10;
        if (r3 == null) goto L10;
        r4 = r3.toLowerCase();
    L10:
        Map<String, String> r5 = LANGUAGE_MAP;
        String r0 = r5.get(r4);
        if (TextUtils.isEmpty(r0) == false) goto L13;
        r0 = r5.get(Locale.ENGLISH.getLanguage());
    L13:
        Log.i(TAG, "convertLan(): origin = " + r4 + ",result = " + r0);
        return r0;
    }

    public static CharSequence getLanguage(String r2, String r3) {
        Map<String, String> r0 = LANGUAGE_TRANSFORM;
        if (r0.containsKey(r3) == false) goto L6;
        r3 = r0.get(r3);
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        Log.w(TAG, "provideLanguage is empty.");
        return BuildConfig.FLAVOR;
    L10:
        if (r3.equals("zh") == true) goto L12;
    L14:
        Log.i(TAG, "language is " + r3);
        return r3;
    L12:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r3 = r3 + "-" + r2;
        goto L14
    }
}
