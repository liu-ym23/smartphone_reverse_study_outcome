package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum BarcodeFormat extends Enum<BarcodeFormat> {
    public static final BarcodeFormat CODABAR = null;
    public static final BarcodeFormat CODE_128 = null;
    public static final BarcodeFormat CODE_39 = null;
    public static final BarcodeFormat CODE_93 = null;
    public static final BarcodeFormat EAN_13 = null;
    public static final BarcodeFormat EAN_8 = null;
    public static final BarcodeFormat QR_CODE = null;
    public static final BarcodeFormat UPC_EAN_EXTENSION = null;
    public static final /* synthetic */ BarcodeFormat[] a = null;

    static {
        BarcodeFormat r0 = new BarcodeFormat("CODABAR", 0);
        CODABAR = r0;
        BarcodeFormat r1 = new BarcodeFormat("CODE_39", 1);
        CODE_39 = r1;
        BarcodeFormat r3 = new BarcodeFormat("CODE_93", 2);
        CODE_93 = r3;
        BarcodeFormat r5 = new BarcodeFormat("CODE_128", 3);
        CODE_128 = r5;
        BarcodeFormat r7 = new BarcodeFormat("EAN_8", 4);
        EAN_8 = r7;
        BarcodeFormat r9 = new BarcodeFormat("EAN_13", 5);
        EAN_13 = r9;
        BarcodeFormat r11 = new BarcodeFormat("QR_CODE", 6);
        QR_CODE = r11;
        BarcodeFormat r13 = new BarcodeFormat("UPC_EAN_EXTENSION", 7);
        UPC_EAN_EXTENSION = r13;
        a = new BarcodeFormat[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public static BarcodeFormat[] values() {
        return (BarcodeFormat[]) a.clone();
    }

    public static BarcodeFormat valueOf(String r1) {
        return (BarcodeFormat) r27.a.a(BarcodeFormat.class, r1);
    }

    public BarcodeFormat(String r1, int r2) {
        super(r1, r2);
    }
}
