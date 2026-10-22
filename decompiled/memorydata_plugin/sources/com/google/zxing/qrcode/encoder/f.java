package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Mode f5117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ErrorCorrectionLevel f5118b;
    private com.google.zxing.qrcode.decoder.a c;
    private int d;
    private b e;

    public f() {
        this.d = -1;
    }

    public static boolean b(int r1) {
        if (r1 >= 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 >= 8) goto L6;
        return true;
    }

    public b a() {
        return this.e;
    }

    public void a(int r1) {
        this.d = r1;
    }

    public void a(ErrorCorrectionLevel r1) {
        this.f5118b = r1;
    }

    public void a(Mode r1) {
        this.f5117a = r1;
    }

    public void a(com.google.zxing.qrcode.decoder.a r1) {
        this.c = r1;
    }

    public void a(b r1) {
        this.e = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(200);
        r0.append("<<\n");
        r0.append(" mode: ");
        r0.append(this.f5117a);
        r0.append("\n ecLevel: ");
        r0.append(this.f5118b);
        r0.append("\n version: ");
        r0.append(this.c);
        r0.append("\n maskPattern: ");
        r0.append(this.d);
        if (this.e != null) goto L5;
        r0.append("\n matrix: null\n");
    L6:
        r0.append(">>\n");
        return r0.toString();
    L5:
        r0.append("\n matrix:\n");
        r0.append(this.e);
        goto L6
    }
}
