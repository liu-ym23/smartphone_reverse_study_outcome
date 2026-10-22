package okio;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final Buffer.a a = null;

    public static final long d(long r8) {
        long r0 = ((((((((-72057594037927936L) & r8) >>> 56) | ((71776119061217280L & r8) >>> 40)) | ((280375465082880L & r8) >>> 24)) | ((1095216660480L & r8) >>> 8)) | ((4278190080L & r8) << 8)) | ((16711680 & r8) << 24)) | ((65280 & r8) << 40);
        return ((r8 & 255) << 56) | r0;
    }

    static {
        a = new Buffer.a();
    }

    public static final String e(byte r4) {
        char[] r1 = okio.internal.b.a;
        return StringsKt.concatToString(new char[]{r1[(r4 >> 4) & 15], r1[r4 & 15]});
    }

    public static final String f(int r6) {
        if (r6 != 0) goto L5;
        return "0";
    L5:
        char[] r2 = okio.internal.b.a;
        int r4 = 0;
        char[] r1 = {r2[(r6 >> 28) & 15], r2[(r6 >> 24) & 15], r2[(r6 >> 20) & 15], r2[(r6 >> 16) & 15], r2[(r6 >> 12) & 15], r2[(r6 >> 8) & 15], r2[(r6 >> 4) & 15], r2[r6 & 15]};
    L6:
        if (r4 >= 8) goto L11;
        if (r1[r4] != '0') goto L11;
        r4 = r4 + 1;
    L11:
        return StringsKt.concatToString(r1, r4, 8);
    }

    public static final int c(ByteString r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == (-1234567890)) goto L5;
        return r2;
    L5:
        return r1.size();
    }

    public static final void b(long r5, long r7, long r9) {
        if ((r7 | r9) < 0) goto L10;
        if (r7 > r5) goto L10;
        if ((r5 - r7) < r9) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException("size=" + r5 + " offset=" + r7 + " byteCount=" + r9);
    }

    public static final boolean a(byte[] r4, int r5, byte[] r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r4, "a");
        Intrinsics.checkNotNullParameter(r6, "b");
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        if (r4[r1 + r5] != r6[r1 + r7]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }
}
