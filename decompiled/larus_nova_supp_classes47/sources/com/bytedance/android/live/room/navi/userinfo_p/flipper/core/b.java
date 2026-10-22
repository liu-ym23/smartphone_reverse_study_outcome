package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import w91.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b<D, VH extends w91.f> implements w91.b<D, VH> {
    public final c a;
    public j91.b<D> b;

    @Override // w91.b
    public final void notifyDataSetChange() {
        j91.b<D> r0 = this.b;
        if (r0 == null) goto L5;
        r0.onChange();
    L5:
        this.a.a(null);
    }

    public b() {
        this.a = new c();
    }

    @Override // w91.b
    public final void c(j91.b<D> r1) {
        this.b = r1;
    }
}
