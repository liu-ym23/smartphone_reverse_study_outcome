package com.bytedance.android.live.core.tetris.layer.view;

import j70.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final List<f> a;
    public final List<f> b;
    public boolean c;
    public boolean d;

    public final void c() {
        this.c = true;
        if ((true ^ ((ArrayList) this.b).isEmpty()) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("因为是 first，所以不能有 aboveList");
    }

    public final void d() {
        this.d = true;
        if ((true ^ ((ArrayList) this.a).isEmpty()) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("因为是 last，所以不能有 belowList");
    }

    public b() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        ((ArrayList) this.b).add(r2);
        if (this.c == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("因为是 first，所以不能有 aboveList");
    }

    public final void b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "anchor");
        ((ArrayList) this.a).add(r2);
        if (this.d == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("因为是 last，所以不能有 belowList");
    }
}
