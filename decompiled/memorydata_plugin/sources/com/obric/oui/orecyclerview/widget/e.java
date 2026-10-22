package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final r f14153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f14154b;
    int c;
    int d;
    Object e;

    public e(r r3) {
        r r4 = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin");
        this.f14154b = 0;
        this.c = -1;
        this.d = -1;
        this.e = null;
        this.f14153a = r4;
    }

    public void a() {
        int r0 = this.f14154b;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r0 != 1) goto L8;
        this.f14153a.a(this.c, this.d);
    L15:
        this.e = null;
        this.f14154b = 0;
        return;
    L8:
        if (r0 != 2) goto L10;
        this.f14153a.b(this.c, this.d);
        goto L15
    L10:
        if (r0 != 3) goto L15;
        this.f14153a.a(this.c, this.d, this.e);
        goto L15
    }

    @Override // com.obric.oui.orecyclerview.widget.r
    public void a(int r5, int r6) {
        if (this.f14154b != 1) goto L10;
        int r0 = this.c;
        if (r5 < r0) goto L10;
        int r2 = this.d;
        if (r5 > (r0 + r2)) goto L10;
        this.d = r2 + r6;
        this.c = Math.min(r5, r0);
        return;
    L10:
        a();
        this.c = r5;
        this.d = r6;
        this.f14154b = 1;
    }

    @Override // com.obric.oui.orecyclerview.widget.r
    public void a(int r6, int r7, Object r8) {
        if (this.f14154b != 3) goto L12;
        int r0 = this.c;
        int r2 = this.d;
        if (r6 > (r0 + r2)) goto L12;
        int r3 = r6 + r7;
        if (r3 < r0) goto L12;
        if (this.e != r8) goto L12;
        this.c = Math.min(r6, r0);
        this.d = Math.max(r2 + r0, r3) - this.c;
        return;
    L12:
        a();
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f14154b = 3;
    }

    @Override // com.obric.oui.orecyclerview.widget.r
    public void b(int r4, int r5) {
        if (this.f14154b != 2) goto L10;
        int r0 = this.c;
        if (r0 < r4) goto L10;
        if (r0 > (r4 + r5)) goto L10;
        this.d += r5;
        this.c = r4;
        return;
    L10:
        a();
        this.c = r4;
        this.d = r5;
        this.f14154b = 2;
    }

    @Override // com.obric.oui.orecyclerview.widget.r
    public void c(int r1, int r2) {
        a();
        this.f14153a.c(r1, r2);
    }
}
