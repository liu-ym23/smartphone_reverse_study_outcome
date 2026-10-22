package com.tom_roush.pdfbox.b;

import java.io.FilterOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class a extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f16076a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f16077b = null;
    public static final byte[] c = null;
    private long d;
    private boolean e;

    static {
        f16076a = new byte[]{13, 10};
        f16077b = new byte[]{10};
        c = new byte[]{10};
    }

    public void a(boolean r1) {
        this.e = r1;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r5) {
        a(false);
        this.out.write(r5);
        this.d++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r3, int r4, int r5) {
        a(false);
        this.out.write(r3, r4, r5);
        this.d += (long) r5;
    }
}
