package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Comparable<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile int f3698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3699b;
    private String c;

    public h(String r2, String r3) {
        this.f3698a = 0;
        this.c = r3;
        if (r2 != null) goto L5;
    L7:
        this.f3699b = r2;
        return;
    L5:
        if (r2.length() != 0) goto L7;
        r2 = null;
        goto L7
    }

    public int a(h r3) {
        String r0 = r3.f3699b;
        if (r0 != null) goto L5;
    L17:
        String r1 = this.f3699b;
        if (r1 != null) goto L20;
    L24:
        return this.c.compareTo(r3.c);
    L20:
        if (r1.length() <= 0) goto L24;
        return 1;
    L5:
        if (r0.length() == 0) goto L17;
        String r2 = this.f3699b;
        if (r2 != null) goto L10;
        return -1;
    L10:
        if (r2.length() == 0) goto L25;
        int r4 = this.f3699b.compareTo(r0);
        if (r4 == 0) goto L24;
        return r4;
    L25:
        return -1;
    }

    public h a(String r1, String r2) {
        this.c = r2;
        if (r1 != null) goto L5;
    L7:
        this.f3699b = r1;
        this.f3698a = 0;
        return this;
    L5:
        if (r1.length() != 0) goto L7;
        r1 = null;
        goto L7
    }

    public String a() {
        return this.f3699b;
    }

    public boolean a(boolean r4, String r5) {
        if (r4 == false) goto L12;
        if ("xml" == this.f3699b) goto L7;
    L20:
        return false;
    L7:
        if (this.c != r5) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (this.c.length() != (r5.length() + 4)) goto L20;
        if (this.c.startsWith("xml:") == false) goto L19;
        if (this.c.endsWith(r5) == false) goto L19;
        return true;
    L19:
        return false;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        String r0 = this.f3699b;
        if (r0 == null) goto L5;
        if (r0 != "xmlns") goto L12;
        return true;
    L12:
        return false;
    L5:
        if (this.c != "xmlns") goto L8;
        return true;
    L8:
        return false;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(h r3) {
        return a((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (this.c == r6.c) goto L12;
        return false;
    L12:
        if (this.f3699b != r6.f3699b) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        int r0 = this.f3698a;
        if (r0 != 0) goto L8;
        r0 = this.c.hashCode();
        String r1 = this.f3699b;
        if (r1 == null) goto L7;
        r0 = r0 ^ r1.hashCode();
    L7:
        this.f3698a = r0;
    L8:
        return r0;
    }

    public String toString() {
        String r0 = this.f3699b;
        if (r0 == null) goto L10;
        if (r0.length() == 0) goto L10;
        StringBuilder r1 = new StringBuilder((this.f3699b.length() + 1) + this.c.length());
        r1.append(this.f3699b);
        r1.append(':');
        r1.append(this.c);
        return r1.toString();
    L10:
        return this.c;
    }
}
