package com.bytedance.android.live.initialize.model;

import com.bytedance.android.live.initialize.IWTOTask;
import com.bytedance.android.live.initialize.state.WTOTaskStatus;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class WTOTaskProxy {
    public volatile WTOTaskStatus a;
    public final ReentrantLock b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public long h;
    public final Lazy i;
    public long j;
    public final IWTOTask k;

    public WTOTaskProxy(IWTOTask r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        this.k = r2;
        this.a = WTOTaskStatus.IDLE;
        this.b = new ReentrantLock();
        this.c = LazyKt.lazy(new WTOTaskProxy$blockPeriod$2(this));
        this.d = LazyKt.lazy(new WTOTaskProxy$threadType$2(this));
        this.e = LazyKt.lazy(new WTOTaskProxy$taskName$2(this));
        this.f = LazyKt.lazy(new WTOTaskProxy$taskBusinessInfo$2(this));
        this.g = LazyKt.lazy(new WTOTaskProxy$baseInfo$2(this));
        this.i = LazyKt.lazy(WTOTaskProxy$enableJatoOpt$2.INSTANCE);
    }
}
