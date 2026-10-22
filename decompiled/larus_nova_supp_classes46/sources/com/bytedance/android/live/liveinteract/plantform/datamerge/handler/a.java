package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements h {
    public com.bytedance.android.live.liveinteract.plantform.datamerge.d a;

    public a() {
    }

    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d a() {
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        return r0;
    }

    public final void c() {
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        BehaviorSubject<List<ch0.e>> r1 = r0.f();
        if (r1 == null) goto L9;
        List<ch0.e> r2 = (List) r1.getValue();
        if (r2 == null) goto L9;
    L10:
        h.a r3 = b(r2);
        if (r3.a == false) goto L17;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r4 = this.a;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L15:
        r4.v0(r3);
        return;
    L17:
        return;
    L9:
        r2 = new ArrayList();
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public h.a b(List<ch0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "oldMergeDataList");
        return new h.a(false, r4, null);
    }
}
