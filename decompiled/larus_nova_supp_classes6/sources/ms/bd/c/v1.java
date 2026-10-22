package ms.bd.c;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class v1 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;

    static {
        String r0 = (String) p2.a(16777217, 0, 0, "4e6456", new byte[]{1, 104, 80, 121, 3, 47, 27, 77, 113, 97});
    }

    public final String toString() {
        return String.format(Locale.US, (String) p2.a(16777217, 0, 0, "5570fb", new byte[]{33, 37, 86, 30, 28, 102, 42, 17, 104, 97, 38, 59, 65, 64, 3, 48, 37, 8, 35, 100, 104, 114, 64, 8, 28, 113}), new Object[]{Boolean.valueOf(this.e), Boolean.valueOf(this.f), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public v1() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = false;
        this.f = false;
        String r1 = (String) p2.a(16777224, 0, 0, null, null);
        String r3 = (String) p2.a(16777217, 0, 0, "a94b2f", new byte[]{95, 41, 78, 17, 4, 127, 99, 20, 37, 49, 127, 53, 65, 31, 10, 43, 34, 93, 118});
        if (TextUtils.isEmpty(r1) == false) goto L6;
        this.e = true;
        Object r0 = p2.a(16777217, 0, 0, "f8fdd7", new byte[]{71, 59, 7, 3, 94, 96, 102, 22, 57, 50, 126, 61, 85, 22, 90, 41, 105, 28, 51, 116, 120, 40, 85, 4, 83, 37, 37, 26, 56, 58, 113, 51, 18, 80, 76, 33, 118, 89, 57, 59, 99, 122, 6, 21, 79, 110});
    L5:
        String r2 = (String) r0;
    L21:
        String r4 = (String) p2.a(16777217, 0, 0, "41c5e4", new byte[]{1, 60, 5, 120, 83, 45, 27, 25, 36, 96});
        String r5 = (String) p2.a(16777217, 0, 0, "7b7a27", new byte[]{21, 101, 80, 1, 4, 46, 51, 80, 38, 34, 50, 97, 80, 0, 30, 122, 116, 6, 117});
        if (this.f == false) goto L25;
        this.d = this.a - this.b;
        return;
    L25:
        return;
    L6:
        String[] r6 = r1.split((String) p2.a(16777217, 0, 0, "7acdf4", new byte[]{26, 127}));
        if (r6.length == 3) goto L9;
        this.e = true;
        r0 = p2.a(16777217, 0, 0, "dd709b", new byte[]{86, 105, 74, 66, 15, 114, 39, 82, 103, 115, 53, 111, 74, 4, 18, 125, 98, 5, 113, 114, 122, 104, 67, 4, 0, 122, 117, 72, 103, 116, 59});
        goto L5
    L9:
        int r7 = CastIntegerProtector.parseInt(r6[0]);
        this.a = r7;
        int r8 = CastIntegerProtector.parseInt(r6[1]);
        this.b = r8;
        int r9 = CastIntegerProtector.parseInt(r6[2]);
        this.c = r9;
        if (r7 < 0) goto L19;
        if (r8 < 0) goto L19;
        if (r7 < r8) goto L19;
        if (r9 == 0) goto L19;
        if (r8 != 0) goto L18;
        if (r7 != 0) goto L18;
        Object r10 = p2.a(16777217, 0, 0, "620ed8", new byte[]{4, 63, 77, 23, 82, 40, 117, 4, 96, 38, 103, 35, 70, 5, 27, 43, 60, 0, 96, 55, 43, 53, 71, 95});
    L20:
        String r11 = (String) r10;
    L18:
        this.f = true;
    L19:
        this.e = true;
        r10 = p2.a(16777217, 0, 0, "b78485", new byte[]{80, 58, 69, 70, 14, 37, 33, 1, 104, 119, 51, 38, 78, 84, 71, 43, 111, 86, 125, 108, 118, 117, 92, 82, 8, 44, 102, 86, 126, 101, 106, 123});
        goto L20
    }
}
