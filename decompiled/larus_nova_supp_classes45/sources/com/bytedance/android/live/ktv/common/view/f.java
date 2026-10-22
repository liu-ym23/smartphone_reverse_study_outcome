package com.bytedance.android.live.ktv.common.view;

import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements com.bytedance.android.livesdk.ktvapi.model.mv.i<Object> {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final boolean G70(int r2, Object r3) {
        com.bytedance.android.livesdk.ktvapi.model.mv.i<T> r0 = this.a.g;
        if (r0 != 0) goto L7;
        return false;
    L7:
        return r0.G70(r2, r3);
    }

    public final void G80(int r2, Object r3, IMvPreviewViewHolder<Object> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "vh");
        Intrinsics.checkNotNullParameter(r5, "unSelectedCb");
        com.bytedance.android.livesdk.ktvapi.model.mv.i<T> r0 = this.a.g;
        if (r0 == 0) goto L6;
        r0.G80(r2, r3, r4, r5);
        return;
    }
}
