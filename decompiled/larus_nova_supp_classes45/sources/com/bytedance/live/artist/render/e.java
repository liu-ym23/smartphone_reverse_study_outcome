package com.bytedance.live.artist.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class e {
    public RenderEntity a;
    public final f b;

    public void d() {
    }

    public abstract void e();

    public abstract void f();

    public final RenderEntity c() {
        RenderEntity r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L5:
        return r0;
    }

    public e() {
        this.b = new f();
    }
}
