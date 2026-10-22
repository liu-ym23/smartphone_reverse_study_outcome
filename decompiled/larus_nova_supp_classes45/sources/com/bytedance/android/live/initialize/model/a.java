package com.bytedance.android.live.initialize.model;

import com.bytedance.android.live.initialize.scheduler.WTOSchedulerNotify;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements wa0.a {
    public final WeakReference<T> a;
    public final Function1<T, Unit> b;

    public a(WTOSchedulerNotify r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "onDispose");
        this.b = r3;
        this.a = new WeakReference(r2);
    }
}
