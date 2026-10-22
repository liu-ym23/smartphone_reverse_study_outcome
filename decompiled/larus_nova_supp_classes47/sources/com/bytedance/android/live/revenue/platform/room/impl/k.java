package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.scope.o;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements p01.a, o {
    public final List<is2.b> a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // p01.a
    public final List<is2.b> getRoomBackendHandlers() {
        return this.a;
    }

    public k(e33.a r2) {
        Intrinsics.checkNotNullParameter(r2, "roomBackendHandlers");
        this.a = CollectionsKt.toList(r2);
    }
}
