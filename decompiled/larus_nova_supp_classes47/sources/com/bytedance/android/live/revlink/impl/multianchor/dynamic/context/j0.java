package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j0 extends i11.c.a {
    public final /* synthetic */ k0 a;

    public j0(k0 r1) {
        this.a = r1;
    }

    @Override // i11.c.a, i11.c.b
    public final void d(int r1, List<? extends com.bytedance.android.livesdk.link.model.p> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r2, "list");
        this.a.j.setValue(r2);
    }
}
