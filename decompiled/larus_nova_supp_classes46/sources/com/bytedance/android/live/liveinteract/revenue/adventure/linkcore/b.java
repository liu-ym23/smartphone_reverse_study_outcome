package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final long d = 0;
    public final CompositeDisposable a;
    public boolean b;
    public final m c;

    public static final class a {
    }

    static {
        d = vm2.d.n().joinTimeoutDuration;
    }

    public b() {
        g r0 = g.l;
        Intrinsics.checkNotNullParameter(r0, "linkService");
        this.c = r0;
        this.a = new CompositeDisposable();
    }
}
