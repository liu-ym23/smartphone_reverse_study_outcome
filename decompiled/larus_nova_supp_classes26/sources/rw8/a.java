package rw8;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, ShareType.TEXT);
        if (r7 > 0) goto L6;
        return "";
    L6:
        int r0 = r6.length();
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= r0) goto L15;
        if (r6.charAt(r2) != '\n') goto L14;
        r3 = r3 + 1;
        if (r3 != r7) goto L14;
        return r6.substring(0, r2);
    L14:
        r2 = r2 + 1;
        goto L7
    L15:
        return r6;
    }

    public static String b(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, ShareType.TEXT);
        if (r5 > 0) goto L6;
        return "";
    L6:
        int r0 = r4.length() - 1;
        int r1 = 0;
    L7:
        if (r0 < 0) goto L15;
        if (r4.charAt(r0) != '\n') goto L14;
        r1 = r1 + 1;
        if (r1 != r5) goto L14;
        return r4.substring(r0 + 1);
    L14:
        r0 = r0 - 1;
        goto L7
    L15:
        return r4;
    }
}
