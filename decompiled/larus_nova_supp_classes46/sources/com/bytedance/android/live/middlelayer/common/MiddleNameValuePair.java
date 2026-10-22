package com.bytedance.android.live.middlelayer.common;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class MiddleNameValuePair implements Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = 629 + r2;
        String r4 = this.value;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return (r3 * 37) + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        if (this.value == null) goto L5;
        StringBuilder r1 = new StringBuilder((this.name.length() + 1) + this.value.length());
        r1.append(this.name);
        r1.append("=");
        r1.append(this.value);
        return r1.toString();
    L5:
        return this.name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MiddleNameValuePair) == false) goto L19;
        MiddleNameValuePair r6 = (MiddleNameValuePair) r5;
        if (this.name.equals(r6.name) == false) goto L17;
        String r1 = this.value;
        String r7 = r6.value;
        if (r1 != null) goto L14;
        if (r7 != null) goto L13;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
        return true;
    L13:
        r8 = false;
        goto L15
    L14:
        r8 = r1.equals(r7);
    L17:
        return false;
    L19:
        return false;
    }

    public MiddleNameValuePair(String r1, String r2) {
        if (r1 == null) goto L7;
        this.name = r1;
        this.value = r2;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }
}
