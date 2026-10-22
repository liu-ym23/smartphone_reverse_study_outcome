package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.livesdk.dslservice.TriangleServiceWidget;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k {
    public boolean a;
    public int b;
    public final Lazy c;
    public final Runnable d;
    public final int e;

    public k(TriangleServiceWidget.b r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        this.d = r2;
        this.e = 1;
        this.c = LazyKt.lazy(new IdleTaskHandler$mIdleHandler$2(this));
    }
}
