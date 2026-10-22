package com.bytedance.android.ec.core.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class i implements z0, Cloneable {
    public final String a;
    public final String b;

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = 629 + r10;
        String r12 = this.b;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return (r11 * 37) + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        int r0 = this.a.length();
        String r1 = this.b;
        if (r1 == null) goto L5;
        r0 = r0 + (r1.length() + 1);
    L5:
        l r10 = new l(r0);
        r10.a(this.a);
        if (this.b == null) goto L9;
        r10.a("=");
        r10.a(this.b);
    L9:
        return r10.toString();
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.bytedance.android.ec.core.utils.z0
    public final String getName() {
        return this.a;
    }

    @Override // com.bytedance.android.ec.core.utils.z0
    public final String getValue() {
        return this.b;
    }

    public final boolean equals(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (this != r10) goto L9;
        return true;
    L9:
        if ((r10 instanceof z0) == false) goto L21;
        i r11 = (i) r10;
        if (this.a.equals(r11.a) == false) goto L22;
        String r12 = this.b;
        String r13 = r11.b;
        if (r12 != null) goto L17;
        if (r13 != null) goto L16;
        boolean r14 = true;
    L18:
        if (r14 == false) goto L23;
        return true;
    L23:
        return false;
    L16:
        r14 = false;
        goto L18
    L17:
        r14 = r12.equals(r13);
        goto L18
    L22:
        return false;
    L21:
        return false;
    }

    public i(String r1, String r10) {
        if (r1 == null) goto L7;
        this.a = r1;
        this.b = r10;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }
}
