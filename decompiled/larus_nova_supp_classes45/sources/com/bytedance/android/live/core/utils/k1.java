package com.bytedance.android.live.core.utils;

import android.os.Handler;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k1<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ Runnable b;

    public k1(r72.i r2) {
        this.a = "checkAndPreloadDrawableRunnable";
        this.b = r2;
    }

    public final void accept(Object r3) {
        String r4 = this.a;
        Runnable r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "runnable");
        if (r4 != null) goto L6;
        r4 = "UnKnown";
    L6:
        if (v.a() == false) goto L8;
        r0 = new l1(r0, r4);
    L8:
        ((Handler) MainPostOptUtils.a.getValue()).post(r0);
    }
}
