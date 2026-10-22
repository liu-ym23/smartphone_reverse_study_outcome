package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import android.view.View;
import com.bytedance.android.live.revenue.common.j;
import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.android.scope.m;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class c extends j implements zy0.c {
    public RevenueJsDriver b;

    public abstract View getHybridView();

    @Override // com.bytedance.android.live.revenue.common.j
    public void d() {
        RevenueJsDriver r0 = this.b;
        if (r0 == null) goto L6;
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r2 = m.b(r1).a(Reflection.getOrCreateKotlinClass(ny0.a.class));
        Intrinsics.checkNotNull(r2);
        ((ny0.a) ((f80.a) r2)).g(r0);
        return;
    }

    public c() {
    }
}
