package com.ss.android.token;

import com.bytedance.sdk.account.utils.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class e0 {
    public final String a;
    public final String b;
    public final String c;
    public final j<TicketTrackData> d;
    public String e;
    public String f;
    public final String g;
    public int h;

    public e0() {
        this("", "", "", null, "", -1);
    }

    public final String a() {
        return "TokenObject{token='" + TokenFactory.l(this.a) + "', tsSign='" + TokenFactory.v(this.b) + "', attestTsSign='" + TokenFactory.l(this.c) + "', tokenHash='" + TokenFactory.l(this.e) + "', tokenEncrypted='" + TokenFactory.l(this.f) + "', tokenTlbTag='" + TokenFactory.l(this.g) + "', isLogin=" + this.h + ", trackData=" + this.d + '}';
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("TokenObject{token='");
        r0.append(this.a);
        r0.append("', tsSign='");
        r0.append(this.b);
        r0.append("', attestTsSign='");
        r0.append(this.c);
        r0.append("', hasTrackData=");
        j<TicketTrackData> r1 = this.d;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        r0.append(r2);
        r0.append(", tokenHash='");
        r0.append(this.e);
        r0.append("', tokenEncrypted='");
        r0.append(this.f);
        r0.append("', tokenTlbTag='");
        r0.append(this.g);
        r0.append("', isLogin=");
        r0.append(this.h);
        r0.append('}');
        return r0.toString();
    L5:
        if (r1.isValid() == false) goto L7;
        r2 = true;
        goto L8
    }

    public e0(String r1, String r2, String r3, j<TicketTrackData> r4, String r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.g = r5;
        this.h = r6;
    }
}
