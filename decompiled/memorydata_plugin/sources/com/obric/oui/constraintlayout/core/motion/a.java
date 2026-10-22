package com.obric.oui.constraintlayout.core.motion;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f13557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f13558b;
    private int c;
    private int d;
    private float e;
    private String f;

    public a(a r2) {
        this.d = Integer.MIN_VALUE;
        this.e = Float.NaN;
        this.f = null;
        this.f13557a = r2.f13557a;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        this.f = r2.f;
        this.f13558b = r2.f13558b;
    }

    public static String a(int r2) {
        String r3 = "00000000" + Integer.toHexString(r2);
        return "#" + r3.substring(r3.length() - 8);
    }

    public a a() {
        return new a(this);
    }

    public String b() {
        return this.f13557a;
    }

    public int getType() {
        return this.c;
    }

    public String toString() {
        String r0 = this.f13557a + ':';
        switch(this.c) {
            case 900: goto L14;
            case 901: goto L13;
            case 902: goto L12;
            case 903: goto L10;
            case 904: goto L9;
            case 905: goto L7;
            default: goto L4;
        };
    L4:
        StringBuilder r2 = new StringBuilder().append(r0).append("????");
    L6:
        return r2.toString();
    L7:
        StringBuilder r1 = new StringBuilder();
    L8:
        r2 = r1.append(r0).append(this.e);
        goto L6
    L9:
        r2 = new StringBuilder().append(r0).append(Boolean.valueOf(this.f13558b));
        goto L6
    L10:
        StringBuilder r3 = new StringBuilder().append(r0);
        String r4 = this.f;
    L11:
        r2 = r3.append(r4);
        goto L6
    L12:
        r3 = new StringBuilder().append(r0);
        r4 = a(this.d);
        goto L11
    L13:
        r1 = new StringBuilder();
        goto L8
    L14:
        r2 = new StringBuilder().append(r0).append(this.d);
        goto L6
    }
}
