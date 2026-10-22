package k89;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r1) {
        if (r1 == null) goto L11;
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L11;
        if (r2.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return r2;
    L8:
        r0 = false;
    L11:
        return null;
    }
}
