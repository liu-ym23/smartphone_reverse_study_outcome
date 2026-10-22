package org.codehaus.stax2.validation;

/* JADX INFO: loaded from: classes7.dex */
public class d extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f17989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected g f17990b;

    public d(g r1, g r2) {
        this.f17989a = r1;
        this.f17990b = r2;
    }

    @Override // org.codehaus.stax2.validation.g
    public String a(String r2, String r3, String r4, String r5) {
        String r0 = this.f17989a.a(r2, r3, r4, r5);
        if (r0 == null) goto L6;
        r5 = r0;
    L6:
        return this.f17990b.a(r2, r3, r4, r5);
    }

    @Override // org.codehaus.stax2.validation.g
    public String a(String r8, String r9, String r10, char[] r11, int r12, int r13) {
        String r0 = this.f17989a.a(r8, r9, r10, r11, r12, r13);
        if (r0 == null) goto L7;
        return this.f17990b.a(r8, r9, r10, r0);
    L7:
        return this.f17990b.a(r8, r9, r10, r11, r12, r13);
    }

    @Override // org.codehaus.stax2.validation.g
    public void a(String r2, String r3, String r4) {
        this.f17989a.a(r2, r3, r4);
        this.f17990b.a(r2, r3, r4);
    }

    @Override // org.codehaus.stax2.validation.g
    public void a(String r2, boolean r3) {
        this.f17989a.a(r2, r3);
        this.f17990b.a(r2, r3);
    }

    @Override // org.codehaus.stax2.validation.g
    public void a(char[] r2, int r3, int r4, boolean r5) {
        this.f17989a.a(r2, r3, r4, r5);
        this.f17990b.a(r2, r3, r4, r5);
    }

    @Override // org.codehaus.stax2.validation.g
    public int b() {
        int r0 = this.f17989a.b();
        int r1 = this.f17990b.b();
        if (r0 >= r1) goto L6;
        return r0;
    L6:
        return r1;
    }

    @Override // org.codehaus.stax2.validation.g
    public int b(String r2, String r3, String r4) {
        int r0 = this.f17989a.b(r2, r3, r4);
        int r1 = this.f17990b.b(r2, r3, r4);
        if (r0 >= r1) goto L6;
        return r0;
    L6:
        return r1;
    }

    @Override // org.codehaus.stax2.validation.g
    public void b(boolean r2) {
        this.f17989a.b(r2);
        this.f17990b.b(r2);
    }
}
