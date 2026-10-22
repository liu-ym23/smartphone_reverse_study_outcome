package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f19417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f19418b = null;

    static {
        f19417a = new char[117];
        f19418b = new byte[126];
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r10 >= 32) goto L6;
        r10 = r10 + 1;
        goto L4
    L6:
        a('b', 8);
        a('t', 9);
        a('n', 10);
        a('f', 12);
        a('r', 13);
        a('/', 47);
        a(Typography.quote, 34);
        a('\\', 92);
    L7:
        byte[] r11 = f19418b;
        if (r5 >= 33) goto L10;
        r11[r5] = ByteCompanionObject.MAX_VALUE;
        r5 = r5 + 1;
        goto L7
    L10:
        r11[9] = 3;
        r11[10] = 3;
        r11[13] = 3;
        r11[32] = 3;
        r11[44] = 4;
        r11[58] = 5;
        r11[123(0x7b, float:1.72E-43)] = 6;
        r11[125(0x7d, float:1.75E-43)] = 7;
        r11[91] = 8;
        r11[93] = 9;
        r11[34] = 1;
        r11[92] = 2;
    }

    public static void a(char r5, int r10) {
        if (r5 == 'u') goto L6;
        f19417a[r5] = (char) r10;
        return;
    }
}
