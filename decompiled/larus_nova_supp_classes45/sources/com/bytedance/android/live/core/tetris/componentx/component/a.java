package com.bytedance.android.live.core.tetris.componentx.component;

import androidx.lifecycle.LifecycleObserver;
import g70.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements h.a {
    public final /* synthetic */ ComponentCenter a;

    public a(ComponentCenter r1) {
        this.a = r1;
    }

    @Override // g70.h.a
    public final void a(LifecycleObserver r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        ComponentCenter r0 = this.a;
        r0.getClass();
        final d70.a r4 = ComponentCenter.l(r3);
        if (r4 == null) goto L7;
        r0.g(new ComponentCenter$onComponentUnLoadStart$1(r4));
        return;
    }

    @Override // g70.h.a
    public final void b(LifecycleObserver r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        ComponentCenter r0 = this.a;
        r0.getClass();
        final d70.a r4 = ComponentCenter.l(r3);
        if (r4 == null) goto L7;
        r0.g(new ComponentCenter$onComponentUnLoadEnd$1(r4));
        return;
    }

    @Override // g70.h.a
    public final void c(LifecycleObserver r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        ComponentCenter r0 = this.a;
        r0.getClass();
        final d70.a r4 = ComponentCenter.l(r3);
        if (r4 == null) goto L7;
        r0.g(new ComponentCenter$onComponentLoadEnd$1(r4));
        return;
    }

    @Override // g70.h.a
    public final void d(LifecycleObserver r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        ComponentCenter r0 = this.a;
        r0.getClass();
        final d70.a r4 = ComponentCenter.l(r3);
        if (r4 == null) goto L7;
        r0.g(new ComponentCenter$onComponentLoadStart$1(r4));
        return;
    }
}
