package com.xiphias.browser.scanner.bach;

import com.google.zxing.BarcodeFormat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/xiphias/browser/scanner/bach/BachBarcodeFormatMapper;", "", "<init>", "()V", "toZxingFormat", "Lcom/google/zxing/BarcodeFormat;", "enigmaType", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16328a = null;

    static {
        f16328a = new a();
    }

    private a() {
    }

    public final BarcodeFormat a(long r3) {
        if (r3 == 1) goto L39;
        if (r3 == 2) goto L39;
        if (r3 != 4) goto L11;
        return BarcodeFormat.UPC_A;
    L11:
        if (r3 != 8) goto L14;
        return BarcodeFormat.UPC_E;
    L14:
        if (r3 != 16) goto L17;
        return BarcodeFormat.EAN_8;
    L17:
        if (r3 != 32) goto L20;
        return BarcodeFormat.EAN_13;
    L20:
        if (r3 != 64) goto L23;
        return BarcodeFormat.CODE_39;
    L23:
        if (r3 != 128) goto L26;
        return BarcodeFormat.CODE_128;
    L26:
        if (r3 != 256) goto L29;
        return BarcodeFormat.DATA_MATRIX;
    L29:
        if (r3 != 512) goto L32;
        return BarcodeFormat.PDF_417;
    L32:
        if (r3 != 1024) goto L35;
        return BarcodeFormat.CODE_93;
    L35:
        if (r3 == 2048) goto L49;
        return null;
    L49:
        return BarcodeFormat.ITF;
    L39:
        return BarcodeFormat.QR_CODE;
    }
}
