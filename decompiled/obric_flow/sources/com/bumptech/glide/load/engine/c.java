package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements f, com.bumptech.glide.load.data.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f1473c;
    public int d;
    public z.c e;
    public List f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile d0.q f1474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f1475i;

    public c(List r5, g r10, e r11) {
        this.d = -1;
        this.f1471a = r5;
        this.f1472b = r10;
        this.f1473c = r11;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void a(Exception r5) {
        this.f1473c.a(this.e, r5, this.f1474h.f16567c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public final boolean b() {
    L2:
        List r5 = this.f;
        boolean r10 = false;
        if (r5 != null) goto L5;
    L16:
        int r11 = this.d + 1;
        this.d = r11;
        if (r11 >= this.f1471a.size()) goto L18;
        z.c r12 = (z.c) this.f1471a.get(this.d);
        g r13 = this.f1472b;
        File r14 = r13.f1495h.a().h(new d(r12, r13.f1501n));
        this.f1475i = r14;
        if (r14 == null) goto L2;
        this.e = r12;
        this.f = this.f1472b.f1494c.f1388b.f(r14);
        this.g = 0;
        goto L2
    L18:
        return false;
    L5:
        if (this.g >= r5.size()) goto L16;
        this.f1474h = null;
    L7:
        if (r10 == true) goto L15;
        if (this.g >= this.f.size()) goto L15;
        List r15 = this.f;
        int r16 = this.g;
        this.g = r16 + 1;
        d0.r r17 = (d0.r) r15.get(r16);
        File r18 = this.f1475i;
        g r19 = this.f1472b;
        this.f1474h = r17.b(r18, r19.e, r19.f, r19.f1496i);
        if (this.f1474h == null) goto L7;
        if (this.f1472b.c(this.f1474h.f16567c.c()) == null) goto L7;
        this.f1474h.f16567c.e(this.f1472b.f1502o, this);
        r10 = true;
    L15:
        return r10;
    }

    @Override // com.bumptech.glide.load.engine.f
    public final void cancel() {
        d0.q r5 = this.f1474h;
        if (r5 == null) goto L6;
        r5.f16567c.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(Object r10) {
        this.f1473c.c(this.e, r10, this.f1474h.f16567c, DataSource.DATA_DISK_CACHE, this.e);
    }
}
