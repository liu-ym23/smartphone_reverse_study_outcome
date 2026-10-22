package com.lynx.component.svg.parser;

import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Serializable f9866c;
    public Object d;

    public r0(String r5) {
        this.f9864a = 0;
        this.f9865b = 0;
        this.d = new b();
        String r10 = r5.trim();
        this.f9866c = r10;
        this.f9865b = r10.length();
    }

    public static boolean h(int r5) {
        if (r5 != 32) goto L5;
        return true;
    L5:
        if (r5 != 10) goto L7;
        return true;
    L7:
        if (r5 != 13) goto L9;
        return true;
    L9:
        if (r5 == 9) goto L17;
        return false;
    L17:
        return true;
    }

    public float a(float r5) {
        if (Float.isNaN(r5) == false) goto L6;
        return Float.NaN;
    L6:
        n();
        return j();
    }

    public int b() {
        int r5 = this.f9864a;
        int r10 = this.f9865b;
        if (r5 != r10) goto L5;
        return -1;
    L5:
        int r11 = r5 + 1;
        this.f9864a = r11;
        if (r11 < r10) goto L8;
        return -1;
    L8:
        return ((String) this.f9866c).charAt(r11);
    }

    public Boolean c(Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        n();
        int r10 = this.f9864a;
        if (r10 != this.f9865b) goto L8;
        return null;
    L8:
        char r11 = ((String) this.f9866c).charAt(r10);
        if (r11 == '0') goto L13;
        if (r11 == '1') goto L13;
        return null;
    L13:
        boolean r12 = true;
        this.f9864a++;
        if (r11 == '1') goto L18;
        r12 = false;
    L18:
        return Boolean.valueOf(r12);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [byte[], java.io.Serializable, java.lang.Object] */
    public void d(byte r5) {
        int r10 = this.f9864a;
        byte[] r11 = (byte[]) this.f9866c;
        if (r10 != r11.length) goto L5;
        ?? r12 = new byte[r11.length * 2];
        System.arraycopy(r11, 0, r12, 0, r11.length);
        this.f9866c = r12;
    L5:
        byte[] r13 = (byte[]) this.f9866c;
        int r14 = this.f9864a;
        this.f9864a = r14 + 1;
        r13[r14] = r5;
    }

    public void e(float r5, float r10, float r11, float r12, float r13, float r14) {
        d((byte) 2);
        f(6);
        float[] r15 = (float[]) this.d;
        int r16 = this.f9865b;
        int r17 = r16 + 1;
        this.f9865b = r17;
        r15[r16] = r5;
        int r18 = r16 + 2;
        this.f9865b = r18;
        r15[r17] = r10;
        int r19 = r16 + 3;
        this.f9865b = r19;
        r15[r18] = r11;
        int r20 = r16 + 4;
        this.f9865b = r20;
        r15[r19] = r12;
        int r21 = r16 + 5;
        this.f9865b = r21;
        r15[r20] = r13;
        this.f9865b = r16 + 6;
        r15[r21] = r14;
    }

    public void f(int r5) {
        float[] r10 = (float[]) this.d;
        if (r10.length >= (this.f9865b + r5)) goto L6;
        float[] r11 = new float[r10.length * 2];
        System.arraycopy(r10, 0, r11, 0, r10.length);
        this.d = r11;
        return;
    }

    public boolean g(char r5) {
        int r10 = this.f9864a;
        if (r10 < this.f9865b) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L10;
        this.f9864a++;
    L10:
        return r11;
    L5:
        if (((String) this.f9866c).charAt(r10) != r5) goto L7;
        r11 = true;
        goto L8
    }

    public boolean i() {
        if (this.f9864a != this.f9865b) goto L6;
        return true;
    L6:
        return false;
    }

    public float j() {
        int r5 = this.f9864a;
        int r10 = this.f9865b;
        b r11 = (b) this.d;
        float r12 = r11.a(r5, r10, (String) this.f9866c);
        if (Float.isNaN(r12) == true) goto L5;
        this.f9864a = r11.f9768a;
    L5:
        return r12;
    }

    public q k() {
        float r5 = j();
        SVG$Unit r10 = null;
        if (Float.isNaN(r5) == false) goto L6;
        return null;
    L6:
        if (i() == true) goto L26;
        int r11 = this.f9864a;
        String r12 = (String) this.f9866c;
        if (r12.charAt(r11) != '%') goto L11;
        this.f9864a++;
        r10 = SVG$Unit.d;
        goto L26
    L11:
        int r13 = this.f9864a;
        int r14 = this.f9865b;
        if (r13 > (r14 - 2)) goto L26;
        if (r13 <= (r14 - 3)) goto L32;
    L24:
        int r15 = this.f9864a;     // Catch: IllegalArgumentException -> L31
        SVG$Unit r16 = SVG$Unit.valueOf(r12.substring(r15, r15 + 2).toLowerCase(Locale.US));     // Catch: IllegalArgumentException -> L31
        this.f9864a += 2;     // Catch: IllegalArgumentException -> L31
        r10 = r16;
        goto L26
    L32:
        String r17 = r12.substring(r13, r13 + 3);     // Catch: IllegalArgumentException -> L31
        if ("rem".equals(r17) == false) goto L22;
        this.f9864a += 3;     // Catch: IllegalArgumentException -> L31
        SVG$Unit r18 = SVG$Unit.f;     // Catch: IllegalArgumentException -> L31
    L20:
        r10 = r18;
        goto L26
    L22:
        if ("rpx".equals(r17) == false) goto L24;
        this.f9864a += 3;     // Catch: IllegalArgumentException -> L31
        r18 = SVG$Unit.e;     // Catch: IllegalArgumentException -> L31
    L26:
        if (r10 != null) goto L30;
        return new q(r5, SVG$Unit.f9757a);
    L30:
        return new q(r5, r10);
    }

    public String l() {
        if (i() == false) goto L5;
        return null;
    L5:
        int r5 = this.f9864a;
        String r10 = (String) this.f9866c;
        char r11 = r10.charAt(r5);
        if (h(r11) == false) goto L8;
    L21:
        return null;
    L8:
        if (r11 == ' ') goto L21;
        int r12 = this.f9864a;
        int r13 = b();
    L12:
        if (r13 == (-1)) goto L20;
        if (r13 == 32) goto L20;
        if (h(r13) == true) goto L20;
        r13 = b();
    L20:
        return r10.substring(r12, this.f9864a);
    }

    public float m() {
        n();
        int r5 = this.f9864a;
        b r10 = (b) this.d;
        String r11 = (String) this.f9866c;
        float r12 = r10.a(r5, this.f9865b, r11);
        if (Float.isNaN(r12) == true) goto L5;
        this.f9864a = r10.f9768a;
    L5:
        return r12;
    }

    public void n() {
        o();
        int r5 = this.f9864a;
        if (r5 != this.f9865b) goto L6;
        return;
    L6:
        if (((String) this.f9866c).charAt(r5) == ',') goto L8;
        return;
    L8:
        this.f9864a++;
        o();
    }

    public void o() {
    L2:
        int r5 = this.f9864a;
        if (r5 >= this.f9865b) goto L8;
        if (h(((String) this.f9866c).charAt(r5)) == false) goto L11;
        this.f9864a++;
        goto L2
    L11:
        return;
    }
}
