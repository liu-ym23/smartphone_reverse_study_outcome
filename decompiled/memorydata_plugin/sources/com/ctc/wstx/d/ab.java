package com.ctc.wstx.d;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ab f3462a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final ab f3463b = null;
    final String c;

    static {
        f3462a = new ab("No elements allowed in pure #PCDATA content model");
        f3463b = new ab("No elements allowed in EMPTY content model");
    }

    private ab(String r1) {
        this.c = r1;
    }

    public static ab c() {
        return f3462a;
    }

    @Override // com.ctc.wstx.d.al
    public al a() {
        return this;
    }

    @Override // com.ctc.wstx.d.al
    public String a(com.ctc.wstx.util.h r1) {
        return this.c;
    }

    @Override // com.ctc.wstx.d.al
    public String b() {
        return null;
    }
}
