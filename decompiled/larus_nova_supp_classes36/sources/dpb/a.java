package dpb;

import java.util.Locale;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String a(Locale r6) {
        if (r6 != null) goto L5;
        return "locale is null";
    L5:
        String r0 = r6.getLanguage();
        String r1 = "";
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        String r2 = r6.getCountry();
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        String r7 = r6.getScript();
        if (r7 == null) goto L15;
        r1 = r7;
    L15:
        StringBuilder r8 = new StringBuilder();
        r8.append(r0);
        boolean r3 = true;
        if (r2.length() <= 0) goto L18;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L23;
        r8.append("_".concat(r2));
    L23:
        if (r1.length() > 0) goto L26;
        r3 = false;
    L26:
        if (r3 == false) goto L29;
        r8.append("_".concat(r1));
    L29:
        return r8.toString();
    L18:
        r4 = false;
        goto L20
    }
}
