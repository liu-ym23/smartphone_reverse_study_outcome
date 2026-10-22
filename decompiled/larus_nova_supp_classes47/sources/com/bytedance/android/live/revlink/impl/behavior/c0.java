package com.bytedance.android.live.revlink.impl.behavior;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 implements c {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void a() {
        this.a.c(0.0f);
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void b() {
        this.c.invoke();
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void c() {
        this.a.b.h();
        this.a.c(1.0f);
        this.d.invoke();
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void d() {
        this.b.invoke();
    }

    public c0(d0 r1, Function0 r2, Function0 r3, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
