package com.bytedance.android.live.liveinteract.feed.datamerge;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements j {
    public k a;

    public a() {
    }

    public final k c() {
        k r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public j.a a(List<ch0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "oldMergeDataList");
        return new j.a(false, r4, null);
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public j.a b(List<ch0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "oldMergeDataList");
        return new j.a(false, r4, null);
    }

    public void d(k r2) {
        Intrinsics.checkNotNullParameter(r2, "proxy");
        this.a = r2;
    }
}
