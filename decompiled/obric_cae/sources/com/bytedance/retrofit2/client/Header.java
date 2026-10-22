package com.bytedance.retrofit2.client;

/* JADX INFO: loaded from: classes.dex */
public final class Header {
    private final String name;
    private final String value;

    public Header(String r8, String r10) {
        this.name = r8;
        this.value = r10;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L27:
        return false;
    L8:
        if (Header.class != r8.getClass()) goto L27;
        Header r10 = (Header) r8;
        String r11 = this.name;
        if (r11 == null) goto L16;
        if (r11.equals(r10.name) == false) goto L17;
    L18:
        String r12 = this.value;
        if (r12 == null) goto L24;
        if (r12.equals(r10.value) == false) goto L25;
    L26:
        return true;
    L25:
        return false;
    L24:
        if (r10.value == null) goto L26;
    L17:
        return false;
    L16:
        if (r10.name == null) goto L18;
        goto L17
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String r8 = this.name;
        int r10 = 0;
        if (r8 == null) goto L5;
        int r11 = r8.hashCode();
    L6:
        int r12 = r11 * 31;
        String r13 = this.value;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        return r12 + r10;
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder();
        String r10 = this.name;
        String r11 = "";
        if (r10 != null) goto L6;
        r10 = "";
    L6:
        r8.append(r10);
        r8.append(": ");
        String r12 = this.value;
        if (r12 == null) goto L9;
        r11 = r12;
    L9:
        r8.append(r11);
        return r8.toString();
    }
}
