package com.bytedance.android.live.revlink.impl.behavior;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m0 implements c {
    public boolean a;
    public final c b;

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void a() {
        c r0 = this.b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void b() {
        if (this.a == false) goto L5;
        return;
    L5:
        c r0 = this.b;
        if (r0 == null) goto L8;
        r0.b();
    L8:
        this.a = true;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void c() {
        c r0 = this.b;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.c
    public final void d() {
        c r0 = this.b;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    public m0(c r1) {
        this.b = r1;
    }
}
