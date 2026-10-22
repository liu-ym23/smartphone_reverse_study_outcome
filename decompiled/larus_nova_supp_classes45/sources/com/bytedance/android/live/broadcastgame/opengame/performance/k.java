package com.bytedance.android.live.broadcastgame.opengame.performance;

import com.bytedance.android.live.broadcastgame.opengame.message.j0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ OpenPlatformPerfRuntime a;

    public k(OpenPlatformPerfRuntime r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        j0 r4 = (j0) r3;
        if (Intrinsics.areEqual(this.a.f, r4.a) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.a.e, r4.b) == false) goto L9;
        this.a.c(1);
        return;
    }
}
