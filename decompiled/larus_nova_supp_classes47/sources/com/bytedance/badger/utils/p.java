package com.bytedance.badger.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public final int a;
    public final String b;

    public p(int r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final String a() {
        if (this.a != (-7001)) goto L6;
        return "user not login";
    L6:
        String r0 = this.b;
        if (r0 != null) goto L9;
    L14:
        StringBuilder r1 = new StringBuilder("error: ");
        r1.append(this.a);
    L13:
        return r1.toString();
    L9:
        if (r0.isEmpty() == true) goto L14;
        r1 = new StringBuilder("error: ");
        r1.append(this.a);
        r1.append(" (");
        r1.append(this.b);
        r1.append(")");
        goto L13
    }
}
