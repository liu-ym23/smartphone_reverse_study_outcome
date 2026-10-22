package gt1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static d a(int r0, Object r1, boolean r2, boolean r3, boolean r4, boolean r5, int r6, boolean r7, boolean r8, qr2.b r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r10 & 128) == 0) goto L9;
        r6 = 0;
    L9:
        if ((r10 & 256) == 0) goto L12;
        r7 = false;
    L12:
        if ((r10 & 512) == 0) goto L15;
        r8 = false;
    L15:
        if ((r10 & 1024) == 0) goto L17;
        r9 = null;
    L17:
        d r11 = new d(r0);
        r11.a = r1;
        r11.b = r9;
        r11.c = r6;
        r11.d = r7;
        r11.e = r8;
        return r11;
    }
}
