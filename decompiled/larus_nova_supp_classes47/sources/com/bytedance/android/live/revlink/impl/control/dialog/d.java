package com.bytedance.android.live.revlink.impl.control.dialog;

import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;

    public d(b r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        b r9 = this.a;
        if (r9.p == true) goto L14;
        Disposable r10 = r9.g;
        if (r10 == null) goto L8;
        r10.dispose();
    L8:
        b r12 = this.a;
        int r4 = IRivalRankRecommendResponse.LoadType.OnlyFollowRivals.ordinal();
        if (Intrinsics.areEqual(this.b, "ai") == false) goto L11;
        String r3 = "ai";
    L12:
        r12.g = r12.h(0, "", r3, r4, "");
        return;
    L11:
        r3 = "timer";
        goto L12
    }
}
