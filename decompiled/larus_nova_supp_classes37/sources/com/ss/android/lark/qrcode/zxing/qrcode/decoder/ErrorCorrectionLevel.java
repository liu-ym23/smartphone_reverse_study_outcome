package com.ss.android.lark.qrcode.zxing.qrcode.decoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ErrorCorrectionLevel extends Enum<ErrorCorrectionLevel> {
    public static final ErrorCorrectionLevel H = null;
    public static final ErrorCorrectionLevel L = null;
    public static final ErrorCorrectionLevel M = null;
    public static final ErrorCorrectionLevel Q = null;
    public static final ErrorCorrectionLevel[] a = null;
    public static final /* synthetic */ ErrorCorrectionLevel[] b = null;
    private final int bits;

    static {
        ErrorCorrectionLevel r0 = new ErrorCorrectionLevel("L", 0, 1);
        L = r0;
        ErrorCorrectionLevel r1 = new ErrorCorrectionLevel("M", 1, 0);
        M = r1;
        ErrorCorrectionLevel r4 = new ErrorCorrectionLevel("Q", 2, 3);
        Q = r4;
        ErrorCorrectionLevel r5 = new ErrorCorrectionLevel("H", 3, 2);
        H = r5;
        b = new ErrorCorrectionLevel[]{r0, r1, r4, r5};
        a = new ErrorCorrectionLevel[]{r1, r0, r5, r4};
    }

    public static ErrorCorrectionLevel[] values() {
        return (ErrorCorrectionLevel[]) b.clone();
    }

    public int getBits() {
        return this.bits;
    }

    public static ErrorCorrectionLevel forBits(int r1) {
        if (r1 < 0) goto L8;
        if (r1 >= 4) goto L8;
        return a[r1];
    L8:
        throw new IllegalArgumentException();
    }

    public static ErrorCorrectionLevel valueOf(String r1) {
        return (ErrorCorrectionLevel) r27.a.a(ErrorCorrectionLevel.class, r1);
    }

    public ErrorCorrectionLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.bits = r3;
    }
}
