package com.tom_roush.pdfbox.a;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class o extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f16069a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f16070b;
    private boolean c;

    static {
        f16069a = Boolean.getBoolean("com.tom_roush.pdfbox.forceParsing");
    }

    public o(String r7) {
        char[] r0 = r7.toCharArray();
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L9;
        if (p.a(r0[r3]) == false) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L12;
        this.f16070b = p.a(r7);
        return;
    L12:
        byte[] r8 = r7.getBytes(com.tom_roush.pdfbox.util.a.f16298b);
        byte[] r4 = new byte[r8.length + 2];
        this.f16070b = r4;
        r4[0] = -2;
        r4[1] = -1;
        System.arraycopy(r8, 0, r4, 2, r8.length);
        return;
    L9:
        r2 = true;
        goto L10
    }

    public o(byte[] r1) {
        a(r1);
    }

    public static o a(String r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        StringBuilder r1 = new StringBuilder(r6.trim());
        if ((r1.length() % 2) == 0) goto L5;
        r1.append('0');
    L5:
        int r2 = r1.length();
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L18;
        int r4 = r3 + 2;
        r0.write(Integer.parseInt(r1.substring(r3, r4), 16));     // Catch: NumberFormatException -> L10
    L14:
        r3 = r4;
    L10:
        e = move-exception;
        if (f16069a == false) goto L16;
        Log.w("PdfBox-Android", "Encountered a malformed hex string");
        r0.write(63);
        goto L14
    L16:
        throw new IOException("Invalid hex string: " + r6, e);
    L18:
        return new o(r0.toByteArray());
    }

    public String a() {
        byte[] r0 = this.f16070b;
        if (r0.length < 2) goto L17;
        if ((r0[0] & 255) != 254) goto L11;
        if ((r0[1] & 255) != 255) goto L11;
        byte[] r7 = this.f16070b;
        return new String(r7, 2, r7.length - 2, com.tom_roush.pdfbox.util.a.f16298b);
    L11:
        if ((r0[0] & 255) != 255) goto L17;
        if ((r0[1] & 255) != 254) goto L17;
        byte[] r8 = this.f16070b;
        return new String(r8, 2, r8.length - 2, com.tom_roush.pdfbox.util.a.c);
    L17:
        return p.a(r0);
    }

    public void a(byte[] r3) {
        this.f16070b = (byte[]) ZeusTransformUtils.preCheckCast(r3.clone(), byte[].class, "com.obric.memorydata.plugin");
    }

    public byte[] b() {
        return this.f16070b;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, o.class) == false) goto L10;
        o r5 = (o) ZeusTransformUtils.preCheckCast(r4, o.class, "com.obric.memorydata.plugin");
        if (a().equals(r5.a()) == true) goto L7;
        return false;
    L7:
        if (this.c != r5.c) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        int r0 = Arrays.hashCode(this.f16070b);
        if (this.c == false) goto L5;
        int r1 = 17;
    L7:
        return r0 + r1;
    L5:
        r1 = 0;
        goto L7
    }

    public String toString() {
        return "COSString{" + a() + "}";
    }
}
