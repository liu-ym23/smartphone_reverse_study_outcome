package com.ctc.wstx.d;

import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    e f3490a;

    public f(e r1) {
        this.f3490a = r1;
    }

    @Override // com.ctc.wstx.d.al
    public al a() {
        return new f(this.f3490a);
    }

    @Override // com.ctc.wstx.d.al
    public String a(com.ctc.wstx.util.h r4) {
        e r5 = this.f3490a.a(r4);
        if (r5 != null) goto L14;
        TreeSet<com.ctc.wstx.util.h> r6 = this.f3490a.c();
        if (r6.size() != 0) goto L9;
        return "Expected $END";
    L9:
        if (this.f3490a.a() == false) goto L13;
        StringBuilder r3 = new StringBuilder().append("Expected <").append(com.ctc.wstx.util.i.a(r6, ">, <", null));
        String r7 = "> or $END";
    L12:
        return r3.append(r7).toString();
    L13:
        r3 = new StringBuilder().append("Expected <").append(com.ctc.wstx.util.i.a(r6, ">, <", "> or <"));
        r7 = ">";
        goto L12
    L14:
        this.f3490a = r5;
        return null;
    }

    @Override // com.ctc.wstx.d.al
    public String b() {
        if (this.f3490a.a() == false) goto L7;
        return null;
    L7:
        return "Expected <" + com.ctc.wstx.util.i.a(this.f3490a.c(), ">, <", "> or <") + ">";
    }
}
