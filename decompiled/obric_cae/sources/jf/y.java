package jf;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f8885a = null;

    static {
        f8885a = Charset.forName("UTF-8");
    }

    public static void a(long r8, long r10, long r11) {
        if ((r10 | r11) < 0) goto L10;
        if (r10 > r8) goto L10;
        if ((r8 - r10) < r11) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(r8), Long.valueOf(r10), Long.valueOf(r11)}));
    }

    public static long b(long r8) {
        long r10 = ((((((((-72057594037927936L) & r8) >>> 56) | ((71776119061217280L & r8) >>> 40)) | ((280375465082880L & r8) >>> 24)) | ((1095216660480L & r8) >>> 8)) | ((4278190080L & r8) << 8)) | ((16711680 & r8) << 24)) | ((65280 & r8) << 40);
        return ((r8 & 255) << 56) | r10;
    }
}
