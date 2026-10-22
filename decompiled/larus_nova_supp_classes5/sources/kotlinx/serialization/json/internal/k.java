package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k {
    public static final char[] a = null;
    public static final byte[] b = null;

    public k() {
    }

    static {
        a = new char[117];
        b = new byte[126];
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= 32) goto L6;
        a(r2, 'u');
        r2 = r2 + 1;
        goto L4
    L6:
        a(8, 'b');
        a(9, 't');
        a(10, 'n');
        a(12, 'f');
        a(13, 'r');
        a(47, '/');
        a(34, '\"');
        a(92, '\\');
    L8:
        if (r1 >= 33) goto L10;
        b[r1] = ByteCompanionObject.MAX_VALUE;
        r1 = r1 + 1;
        goto L8
    L10:
        byte[] r3 = b;
        r3[9] = 3;
        r3[10] = 3;
        r3[13] = 3;
        r3[32] = 3;
        r3[44] = 4;
        r3[58] = 5;
        r3[123(0x7b, float:1.72E-43)] = 6;
        r3[125(0x7d, float:1.75E-43)] = 7;
        r3[91] = 8;
        r3[93] = 9;
        r3[34] = 1;
        r3[92] = 2;
    }

    public static void a(int r1, char r2) {
        if (r2 == 'u') goto L6;
        a[r2] = (char) r1;
        return;
    }
}
