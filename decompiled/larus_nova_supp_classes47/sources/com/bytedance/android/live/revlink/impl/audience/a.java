package com.bytedance.android.live.revlink.impl.audience;

import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.collections.ArrayDeque;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public Disposable a;
    public long b;
    public boolean c;
    public final ArrayDeque<Pair<Long, String>> d;
    public int e;
    public int f;
    public final com.bytedance.android.live.revlink.impl.global.c g;
    public final boolean h;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.audience.a$a, reason: collision with other inner class name */
    public static final class C0118a {
    }

    static {
    }

    public static w41.a b() {
        com.bytedance.android.live.revlink.impl.settings.live.c r0 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r0.getClass();
        return (w41.a) com.bytedance.android.live.revlink.impl.settings.live.c.w.getValue(r0, com.bytedance.android.live.revlink.impl.settings.live.c.a[21]);
    }

    public final void a() {
        if (this.b != 0) goto L5;
        return;
    L5:
        Disposable r0 = this.a;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        this.d.clear();
        this.c = false;
        this.b = 0;
        this.f = 0;
    }

    public a(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r1) {
        this.g = r1;
        this.h = true;
        this.d = new ArrayDeque();
    }
}
