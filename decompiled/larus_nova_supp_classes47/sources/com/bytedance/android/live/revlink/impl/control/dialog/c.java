package com.bytedance.android.live.revlink.impl.control.dialog;

import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;

    public c(b r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        if (this.a.p == true) goto L23;
        int r9 = b.r;
        if (b51.b.c0.i().R5() == false) goto L14;
        long r0 = System.currentTimeMillis();
        Long r10 = this.a.k.get(IRivalRankRecommendResponse.LoadType.All.ordinal());
        if (r10 == null) goto L10;
        long r2 = r10.longValue();
    L12:
        if ((r0 - r2) >= 10000) goto L14;
        return;
    L10:
        r2 = 0;
    L14:
        Disposable r12 = this.a.d;
        if (r12 == null) goto L17;
        r12.dispose();
    L17:
        b r13 = this.a;
        int r4 = IRivalRankRecommendResponse.LoadType.All.ordinal();
        if (Intrinsics.areEqual(this.b, "ai") == false) goto L20;
        String r3 = "ai";
    L21:
        r13.d = r13.h(0, "", r3, r4, "");
        return;
    L20:
        r3 = "timer";
        goto L21
    }
}
