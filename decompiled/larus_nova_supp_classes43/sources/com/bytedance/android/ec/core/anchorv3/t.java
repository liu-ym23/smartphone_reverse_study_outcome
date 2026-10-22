package com.bytedance.android.ec.core.anchorv3;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t implements fj.c {
    public final List<fj.b> a;

    public t() {
        this.a = new ArrayList();
    }

    public final void a(fj.b r10) {
        List<fj.b> r0 = this.a;
        if (r0 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r0).remove(r10);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    public final void b(fj.b r10) {
        if (r10 == null) goto L5;
        ((ArrayList) this.a).add(r10);
        return;
    }
}
