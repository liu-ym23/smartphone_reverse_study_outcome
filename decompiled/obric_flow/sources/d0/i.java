package d0;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f16551b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f16552a;

    static {
        String r5 = System.getProperty("http.agent");
        if (TextUtils.isEmpty(r5) == true) goto L17;
        int r10 = r5.length();
        StringBuilder r11 = new StringBuilder(r5.length());
        int r12 = 0;
    L6:
        if (r12 >= r10) goto L16;
        char r13 = r5.charAt(r12);
        if (r13 > 31) goto L12;
        if (r13 == '\t') goto L12;
    L14:
        r11.append('?');
    L15:
        r12 = r12 + 1;
    L12:
        if (r13 >= 127) goto L14;
        r11.append(r13);
        goto L15
    L16:
        r5 = r11.toString();
    L17:
        HashMap r14 = new HashMap(2);
        if (TextUtils.isEmpty(r5) == true) goto L20;
        r14.put("User-Agent", Collections.singletonList(new j(r5)));
    L20:
        f16551b = Collections.unmodifiableMap(r14);
    }
}
