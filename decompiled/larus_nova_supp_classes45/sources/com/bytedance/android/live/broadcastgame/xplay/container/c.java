package com.bytedance.android.live.broadcastgame.xplay.container;

import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ m a;

    public c(m r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        if ((!Intrinsics.areEqual((Boolean) this.a.getValue(), r3)) == false) goto L6;
        this.a.setValue(r3);
        return;
    }
}
