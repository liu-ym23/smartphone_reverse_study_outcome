package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final void a(boolean r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (r1 == true) goto L6;
        r2.invoke();
        return;
    L6:
        Single.fromCallable(new f(r2)).subscribeOn(Schedulers.computation()).subscribe();
    }
}
