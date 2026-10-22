package com.bytedance.android.live.revlink.impl.behavior;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ ToolbarPkBehavior a;

    public x(ToolbarPkBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        this.a.f3();
    }
}
