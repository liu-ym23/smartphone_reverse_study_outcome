package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class o0 {
    public static final String[] a = null;
    public static final byte[] b = null;

    public static final char c(int r1) {
        int r2 = r1 & 15;
        if (r2 >= 10) goto L5;
        int r3 = r2 + 48;
    L7:
        return (char) r3;
    L5:
        r3 = (r2 - 10) + 97;
        goto L7
    }

    static {
        String[] r1 = new String[93];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 32) goto L6;
        r1[r3] = "\\u" + c(r3 >> 12) + c(r3 >> 8) + c(r3 >> 4) + c(r3);
        r3 = r3 + 1;
        goto L4
    L6:
        r1[34] = "\\\"";
        r1[92] = "\\\\";
        r1[9] = "\\t";
        r1[8] = "\\b";
        r1[10] = "\\n";
        r1[13] = "\\r";
        r1[12] = "\\f";
        a = r1;
        byte[] r0 = new byte[93];
    L7:
        if (r2 >= 32) goto L9;
        r0[r2] = 1;
        r2 = r2 + 1;
        goto L7
    L9:
        r0[34] = 34;
        r0[92] = 92;
        r0[9] = 116;
        r0[8] = 98;
        r0[10] = 110;
        r0[13] = 114;
        r0[12] = 102;
        b = r0;
    }

    public static final Boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (StringsKt.equals(r2, "true", true) == false) goto L6;
        return Boolean.TRUE;
    L6:
        if (StringsKt.equals(r2, "false", true) == true) goto L11;
        return null;
    L11:
        return Boolean.FALSE;
    }

    public static final void a(StringBuilder r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "value");
        r7.append('\"');
        int r1 = r8.length();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L10;
        char r4 = r8.charAt(r2);
        String[] r5 = a;
        if (r4 >= r5.length) goto L9;
        if (r5[r4] == null) goto L9;
        r7.append(r8, r3, r2);
        r7.append(r5[r4]);
        r3 = r2 + 1;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r3 == 0) goto L12;
        r7.append(r8, r3, r8.length());
    L13:
        r7.append('\"');
        return;
    L12:
        r7.append(r8);
        goto L13
    }
}
