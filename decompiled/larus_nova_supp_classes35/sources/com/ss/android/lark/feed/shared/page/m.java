package com.ss.android.lark.feed.shared.page;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements zeb.b {
    public final /* synthetic */ k a;

    @Override // zeb.b
    public final void a() {
        this.a.c.I2();
        this.a.e.a();
        k r0 = this.a;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L5;
        r1.addOnItemTouchListener(r0.f);
    L5:
        this.a.e.c();
    }

    @Override // zeb.b
    public final void b() {
        k r0 = this.a;
        RecyclerView r1 = r0.b;
        if (r1 == null) goto L5;
        r1.removeOnItemTouchListener(r0.f);
    L5:
        this.a.e.b();
    }

    public m(k r1) {
        this.a = r1;
    }
}
