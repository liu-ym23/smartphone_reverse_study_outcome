package bf;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r10, String r11) {
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        String r12 = r10.concat(r11);
        boolean r0 = false;
        if (StringsKt.endsWith$default(r12, "/", false, 2, null) == false) goto L13;
        if (r12.length() <= 1) goto L13;
        r12 = r12.substring(0, r12.length() - 1);
    L13:
        if (r12.length() <= 0) goto L15;
        r0 = true;
    L15:
        if (r0 == true) goto L17;
        return null;
    L17:
        return r12;
    }
}
