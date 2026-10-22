package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MutableLiveData;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 extends i11.c.a {
    public final /* synthetic */ e0 a;

    public d0(e0 r1) {
        this.a = r1;
    }

    @Override // i11.c.a, i11.c.b
    public final void d(int r1, List<? extends com.bytedance.android.livesdk.link.model.p> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r2, "list");
        this.a.q.setValue(r2);
    }

    @Override // i11.c.a, i11.c.b
    public final void h(int r1, List<? extends com.bytedance.android.livesdk.link.model.p> r2) {
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> r3 = this.a.q;
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        r3.setValue(r2);
    }
}
