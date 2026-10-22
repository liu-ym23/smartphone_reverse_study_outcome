package com.ctc.wstx.d;

/* JADX INFO: loaded from: classes2.dex */
public final class aj extends ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f3475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String[] f3476b;

    public aj(boolean r8, com.ctc.wstx.util.h[] r9) {
        this.f3475a = r8;
        int r0 = r9.length;
        if (r0 == 0) goto L15;
        if (r8 == false) goto L6;
        int r1 = r0 + r0;
    L7:
        this.f3476b = new String[r1];
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r2 >= r0) goto L13;
        com.ctc.wstx.util.h r4 = r9[r2];
        if (r8 == false) goto L12;
        this.f3476b[r3] = r4.a();
        r3 = r3 + 1;
    L12:
        this.f3476b[r3] = r4.b();
        r2 = r2 + 1;
        r3 = r3 + 1;
        goto L8
    L13:
        return;
    L6:
        r1 = r0;
        goto L7
    L15:
        throw new IllegalStateException("Trying to construct empty PrefixedNameSet");
    }

    @Override // com.ctc.wstx.d.ah
    public void a(StringBuilder r4, String r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.f3476b.length) goto L14;
        if (r0 <= 0) goto L8;
        r4.append(r5);
    L8:
        if (this.f3475a == false) goto L13;
        int r2 = r0 + 1;
        String r1 = this.f3476b[r0];
        if (r1 == null) goto L12;
        r4.append(r1);
        r4.append(':');
    L12:
        r0 = r2;
    L13:
        int r3 = r0 + 1;
        r4.append(this.f3476b[r0]);
        r0 = r3;
        goto L4
    }

    @Override // com.ctc.wstx.d.ah
    public boolean a() {
        if (this.f3476b.length > 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.ctc.wstx.d.ah
    public boolean a(com.ctc.wstx.util.h r7) {
        int r0 = this.f3476b.length;
        String r1 = r7.b();
        String[] r2 = this.f3476b;
        if (this.f3475a == false) goto L18;
        String r6 = r7.a();
        if (r2[1] == r1) goto L7;
    L9:
        int r8 = 2;
    L10:
        if (r8 >= r0) goto L26;
        if (r2[r8 + 1] != r1) goto L16;
        if (r2[r8] != r6) goto L16;
        return true;
    L16:
        r8 = r8 + 2;
    L26:
        return false;
    L7:
        if (r2[0] != r6) goto L9;
        return true;
    L18:
        if (r2[0] != r1) goto L20;
        return true;
    L20:
        int r9 = 1;
    L21:
        if (r9 >= r0) goto L26;
        if (r2[r9] == r1) goto L24;
        r9 = r9 + 1;
        goto L21
    L24:
        return true;
    }
}
