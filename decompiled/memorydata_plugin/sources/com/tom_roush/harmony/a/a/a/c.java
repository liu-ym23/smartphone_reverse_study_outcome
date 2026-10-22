package com.tom_roush.harmony.a.a.a;

import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class c extends b {
    private InputStream e;
    private d f;

    public c(InputStream r2) {
        this.f = new d();
        if (r2 == null) goto L7;
        this.e = r2;
        return;
    L7:
        throw new IllegalArgumentException("stream == null!");
    }

    @Override // com.tom_roush.harmony.a.a.a.b
    public int a(byte[] r10, int r11, int r12) {
        this.d = 0;
        if (this.f16038b < this.f.a()) goto L5;
        this.f.a(this.e, (int) ((this.f16038b - this.f.a()) + ((long) r12)));
    L5:
        int r13 = this.f.a(r10, r11, r12, this.f16038b);
        if (r13 <= 0) goto L8;
        this.f16038b += (long) r13;
    L8:
        return r13;
    }

    @Override // com.tom_roush.harmony.a.a.a.b
    public int c() {
        this.d = 0;
        if (this.f16038b < this.f.a()) goto L8;
        int r0 = (int) ((this.f16038b - this.f.a()) + 1);
        if (this.f.a(this.e, r0) >= r0) goto L8;
        return -1;
    L8:
        int r1 = this.f.a(this.f16038b);
        if (r1 < 0) goto L11;
        this.f16038b++;
    L11:
        return r1;
    }

    @Override // com.tom_roush.harmony.a.a.a.b
    public void g() {
        super.g();
        this.f.b();
    }
}
