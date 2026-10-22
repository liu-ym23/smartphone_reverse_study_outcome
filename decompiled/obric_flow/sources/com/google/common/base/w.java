package com.google.common.base;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f8673c;
    public Object d;

    public /* synthetic */ w() {
        this.f8671a = 0;
    }

    public void a(long r5, String r10) {
        c(r10, String.valueOf(r5));
    }

    public void b(Object r5, String r10) {
        w r11 = new w();
        ((w) this.d).f8673c = r11;
        this.d = r11;
        r11.d = r5;
        r11.f8672b = r10;
    }

    public void c(String r5, String r10) {
        v r11 = new v();
        ((w) this.d).f8673c = r11;
        this.d = r11;
        r11.d = r10;
        r11.f8672b = r5;
    }

    public String toString() {
        switch(this.f8671a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder(32);
        r5.append(this.f8672b);
        r5.append('{');
        w r10 = this.f8673c.f8673c;
        String r11 = "";
    L7:
        if (r10 == null) goto L17;
        Object r12 = r10.d;
        boolean r13 = r10 instanceof v;
        r5.append(r11);
        String r14 = r10.f8672b;
        if (r14 == null) goto L11;
        r5.append(r14);
        r5.append('=');
    L11:
        if (r12 != null) goto L13;
    L15:
        r5.append(r12);
    L16:
        r10 = r10.f8673c;
        r11 = ", ";
        goto L7
    L13:
        if (r12.getClass().isArray() == false) goto L15;
        String r15 = Arrays.deepToString(new Object[]{r12});
        r5.append(r15, 1, r15.length() - 1);
        goto L16
    L17:
        r5.append('}');
        return r5.toString();
    L5:
        return super.toString();
    }

    public w(String r5) {
        this.f8671a = 1;
        w r10 = new w();
        this.f8673c = r10;
        this.d = r10;
        this.f8672b = r5;
    }
}
