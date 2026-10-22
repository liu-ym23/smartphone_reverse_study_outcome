package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f19440a = null;

    static {
        String[] r5 = new String[93];
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= 32) goto L6;
        r5[r11] = "\\u" + b(r11 >> 12) + b(r11 >> 8) + b(r11 >> 4) + b(r11);
        r11 = r11 + 1;
        goto L4
    L6:
        r5[34] = "\\\"";
        r5[92] = "\\\\";
        r5[9] = "\\t";
        r5[8] = "\\b";
        r5[10] = "\\n";
        r5[13] = "\\r";
        r5[12] = "\\f";
        f19440a = r5;
        byte[] r12 = new byte[93];
    L7:
        if (r10 >= 32) goto L9;
        r12[r10] = 1;
        r10 = r10 + 1;
        goto L7
    L9:
        r12[34] = 34;
        r12[92] = 92;
        r12[9] = 116;
        r12[8] = 98;
        r12[10] = 110;
        r12[13] = 114;
        r12[12] = 102;
    }

    public static final void a(StringBuilder r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "value");
        r10.append(Typography.quote);
        int r5 = r11.length();
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r5) goto L10;
        char r14 = r11.charAt(r12);
        String[] r15 = f19440a;
        if (r14 >= r15.length) goto L9;
        if (r15[r14] == null) goto L9;
        r10.append(r11, r13, r12);
        r10.append(r15[r14]);
        r13 = r12 + 1;
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        if (r13 == 0) goto L12;
        r10.append(r11, r13, r11.length());
    L13:
        r10.append(Typography.quote);
        return;
    L12:
        r10.append(r11);
        goto L13
    }

    public static final char b(int r5) {
        int r10 = r5 & 15;
        if (r10 >= 10) goto L6;
        int r11 = r10 + 48;
    L7:
        return (char) r11;
    L6:
        r11 = r10 + 87;
        goto L7
    }
}
