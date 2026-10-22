package eo0;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public long f;

    public a() {
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("{\"path\":\"");
        r0.append(this.a);
        String r2 = "";
        if ("0".equals(this.b) == false) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        if (TextUtils.isEmpty(this.c) == false) goto L9;
        String r3 = "";
    L10:
        r0.append(r3);
        if (this.f == 0) goto L14;
        r2 = "\", \"time\":\"" + this.f;
    L14:
        r0.append(r2);
        r0.append("\", \"latency\":\"");
        r0.append(this.e);
        r0.append("\", \"id\":\"");
        r0.append(this.d);
        r0.append("\"}");
        return r0.toString();
    L9:
        r3 = "\", \"msg\":\"" + this.c;
        goto L10
    L5:
        r1 = "\", \"code\":\"" + this.b;
        goto L6
    }
}
