package ry7;

import android.text.TextUtils;
import com.larksuite.component.blockit.d;
import com.larksuite.framework.http.request.HttpHeaders;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static com.larksuite.component.blockit.a a;

    public static HttpHeaders a() {
        HttpHeaders r0 = new HttpHeaders();
        StringBuilder r1 = new StringBuilder("session=");
        String r2 = ((d) ApiUtils.getApi(d.class)).getSession();
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r2 = "XN0YXJ0-a8da7d90-9b05-4ad0-9f16-b22ac409410g-WVuZA";
    L6:
        r1.append(r2);
        r0.put(HttpHeaders.HEAD_KEY_COOKIE, r1.toString());
        r0.put(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, b());
        return r0;
    }

    public static String b() {
        Locale r0 = ((d) ApiUtils.getApi(d.class)).getLocale();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLanguage().toLowerCase() + "-" + r0.getCountry().toUpperCase();
    }
}
