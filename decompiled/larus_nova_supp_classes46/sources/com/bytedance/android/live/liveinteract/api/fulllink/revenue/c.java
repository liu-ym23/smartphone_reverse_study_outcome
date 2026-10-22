package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ Function0 b;

    public c(e r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r1) {
        Boolean r2 = (Boolean) r1;
        this.b.invoke();
        this.a.u.clear();
    }
}
