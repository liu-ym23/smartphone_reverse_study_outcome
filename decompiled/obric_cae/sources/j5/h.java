package j5;

import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class h implements e.c<String[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f8663a;

    public h(e r8) {
        this.f8663a = r8;
    }

    @Override // j5.e.c
    public final boolean a(String[] r10, String[] r11) {
        String[] r12 = r10;
        String[] r13 = r11;
        if (r12 != r13) goto L6;
        return true;
    L6:
        if (r12 == null) goto L27;
        if (r13 == null) goto L27;
        if (r12.length != r13.length) goto L27;
        int r8 = r12.length;
        int r14 = 0;
    L13:
        if (r14 >= r8) goto L34;
        String r15 = r12[r14];
        int r16 = r13.length;
        int r17 = 0;
        boolean r18 = false;
    L15:
        if (r17 >= r16) goto L23;
        if (x0.e(r13[r17], r15) == true) goto L21;
        if (r18 == true) goto L21;
        r18 = false;
    L22:
        r17 = r17 + 1;
    L21:
        r18 = true;
        goto L22
    L23:
        if (r18 == false) goto L27;
        r14 = r14 + 1;
        goto L13
    L34:
        return true;
    L27:
        return false;
    }

    @Override // j5.e.c
    public final String[] b(String[] r8, String[] r10, e r11) {
        return (String[]) r11.g(r8, r10, new h(r11));
    }

    @Override // j5.e.c
    public final boolean c(String[] r8) {
        String[] r10 = r8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.length <= 0) goto L7;
        return true;
    }

    @Override // j5.e.c
    public final void d(String[] r8) {
        e r10 = this.f8663a;
        r10.d(r8);
    }

    @Override // j5.e.c
    public final String[] e() {
        return this.f8663a.f();
    }
}
