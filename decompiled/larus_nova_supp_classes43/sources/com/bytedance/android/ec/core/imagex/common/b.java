package com.bytedance.android.ec.core.imagex.common;

import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Executor {
    public final Lazy a;
    public final Lazy b;
    public final String c;
    public final int d;

    public b(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        this.c = r10;
        this.d = 0;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new AsyncHandler$asyncHandler$2(this));
        this.b = LazyKt.lazy(new AsyncHandler$taskMergeManager$2(this));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r10) {
        if (r10 == null) goto L11;
        Intrinsics.checkNotNullParameter(r10, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), ((AsyncHandler$asyncHandler$2.a) this.a.getValue()).getLooper()) == false) goto L7;
        r10.run();
        return;
    L7:
        if (((Boolean) TaskMergeManager.e.getValue()).booleanValue() == false) goto L9;
        ((TaskMergeManager) this.b.getValue()).a(new v.a(Integer.valueOf(this.d), r10));
        return;
    L9:
        ((AsyncHandler$asyncHandler$2.a) this.a.getValue()).post(new v.a(Integer.valueOf(this.d), r10));
        return;
    }
}
