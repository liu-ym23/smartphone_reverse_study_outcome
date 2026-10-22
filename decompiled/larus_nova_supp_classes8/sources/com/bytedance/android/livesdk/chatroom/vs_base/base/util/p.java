package com.bytedance.android.livesdk.chatroom.vs_base.base.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p {
    public final List<eua.c> a;
    public final String b;
    public final String c;

    public final String c() {
        if (((ArrayList) this.a).isEmpty() == true) goto L5;
        List<eua.c> r0 = this.a;
        String r1 = this.c;
        StringBuilder r2 = new StringBuilder();
        Iterator r3 = ((ArrayList) r0).iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        cua.c r4 = (cua.c) r3.next();
        String r5 = dua.a.a(r4.getName(), r1);
        String r6 = r4.getValue();
        if (r6 == null) goto L12;
        String r7 = dua.a.a(r6, r1);
    L14:
        if (r2.length() <= 0) goto L16;
        r2.append("&");
    L16:
        r2.append(r5);
        r2.append("=");
        r2.append(r7);
        goto L8
    L12:
        r7 = "";
        goto L14
    L17:
        String r8 = r2.toString();
        String r9 = this.b;
        if (r9 != null) goto L20;
        return r8;
    L20:
        if (r9.length() == 0) goto L36;
        int r10 = this.b.indexOf(63);
        if (r10 < 0) goto L31;
        if (this.b.indexOf(61, r10) <= 0) goto L29;
        int r11 = r10 + 1;
        return this.b.substring(0, r11) + r8 + "&" + this.b.substring(r11);
    L29:
        return this.b + "&" + r8;
    L31:
        return this.b + "?" + r8;
    L36:
        return r8;
    L5:
        return this.b;
    }

    public final String toString() {
        return c();
    }

    public p(String r2) {
        this.a = new ArrayList();
        this.c = "UTF-8";
        this.b = r2;
    }

    public final void a(String r3, int r4) {
        List<eua.c> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new eua.c(r3, String.valueOf(r4)));
    }

    public final void b(String r3, String r4) {
        List<eua.c> r0 = this.a;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new eua.c(r3, r4));
    }
}
