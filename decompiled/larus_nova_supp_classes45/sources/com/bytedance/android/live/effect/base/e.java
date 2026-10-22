package com.bytedance.android.live.effect.base;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public boolean a;
    public Sticker b;
    public String c;
    public RenderTriggerType d;
    public boolean e;
    public long f;
    public long g;
    public long h;
    public long i;
    public final long j;
    public long k;

    public e() {
        this.a = true;
        this.c = "";
    }

    public final boolean a() {
        return this.a;
    }

    public e(e r3) {
        this();
        if (r3 != null) goto L5;
        return;
    L5:
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
        this.j = r3.j;
        this.k = r3.k;
    }
}
