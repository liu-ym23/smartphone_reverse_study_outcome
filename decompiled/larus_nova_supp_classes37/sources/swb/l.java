package swb;

import android.text.TextUtils;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l {
    public static final Map<String, String> a = null;
    public static final Map<String, String> b = null;

    static {
        HashMap r0 = new HashMap();
        a = r0;
        HashMap r1 = new HashMap();
        b = r1;
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
        r0.put(EnvConst$GEO.CN, "zh-CN");
        r0.put("ms", "ms-MY");
        r1.put("in", "id");
    }

    public static String a(String r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        com.ss.android.lark.officesdk.utils.di.j.b("LanguageUtil", "convertLan(): lan is Null");
        return "";
    L7:
        if (r4.equals("zh") == false) goto L10;
        if (r3 == null) goto L10;
        r4 = r3.toLowerCase();
    L10:
        Map<String, String> r5 = a;
        String r0 = (String) ((HashMap) r5).get(r4);
        if (TextUtils.isEmpty(r0) == false) goto L13;
        r0 = (String) ((HashMap) r5).get(Locale.ENGLISH.getLanguage());
    L13:
        com.ss.android.lark.officesdk.utils.di.j.e("LanguageUtil", "convertLan(): origin = " + r4 + ",result = " + r0);
        return r0;
    }
}
