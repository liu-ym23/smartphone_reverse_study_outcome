package ci0;

import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public String a;
    public String b;
    public int c;
    public String d;
    public byte[] e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public String k;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("AdventureLinkEngineConfig(rtcExtInfo='");
        r0.append(this.a);
        r0.append("', appId='");
        r0.append(this.b);
        r0.append("', vendor=");
        r0.append(this.c);
        r0.append(", vendorName='");
        r0.append(this.d);
        r0.append("', appSignature=");
        byte[] r1 = this.e;
        if (r1 == null) goto L5;
        String r2 = Arrays.toString(r1);
    L6:
        r0.append(r2);
        r0.append(", channelId='");
        r0.append(this.f);
        r0.append("', token='");
        r0.append(this.g);
        r0.append("', userId='");
        r0.append(this.h);
        r0.append("', interactId='");
        r0.append(this.i);
        r0.append("', interactIdMode=");
        r0.append(this.j);
        r0.append(", businessId='");
        r0.append(this.k);
        r0.append("')");
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public a() {
        this.a = "";
        this.b = "";
        this.d = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.k = "";
    }
}
