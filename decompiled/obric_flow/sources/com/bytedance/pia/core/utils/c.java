package com.bytedance.pia.core.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fh.a f7142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f7143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ dh.e f7144c;
    public final /* synthetic */ fh.a d;

    public c(fh.a r5, f r10, dh.e r11, fh.a r12) {
        this.f7142a = r5;
        this.f7143b = r10;
        this.f7144c = r11;
        this.d = r12;
    }

    @Override // fh.a
    public final void accept(Object r5) {
        dh.f r10 = (dh.f) r5;
        if (r10 == null) goto L8;
        j.y("[Resource] Custom resource loader load success.", null);
        fh.a r11 = this.f7142a;
        if (r11 == null) goto L10;
        r11.accept(r10);
        return;
    L10:
        return;
    L8:
        this.f7143b.getClass();
        f.c(this.f7144c, this.d);
    }
}
