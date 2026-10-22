package q3;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
        new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
    }

    public static String a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "quoted");
        int r0 = r10.length();
        if (r0 >= 2) goto L5;
        return r10;
    L5:
        if (r10.charAt(0) != '\"') goto L23;
        int r1 = r0 - 1;
        if (r10.charAt(r1) != '\"') goto L24;
        StringBuffer r11 = new StringBuffer(r0);
        int r12 = 1;
    L9:
        if (r12 >= r1) goto L17;
        char r13 = r10.charAt(r12);
        if (r13 != '\\') goto L15;
        if (r12 == (r0 - 2)) goto L15;
        r12 = r12 + 1;
        r13 = r10.charAt(r12);
    L15:
        r11.append(r13);
        r12 = r12 + 1;
        goto L9
    L17:
        return r11.toString();
    L24:
        return r10;
    L23:
        return r10;
    }
}
