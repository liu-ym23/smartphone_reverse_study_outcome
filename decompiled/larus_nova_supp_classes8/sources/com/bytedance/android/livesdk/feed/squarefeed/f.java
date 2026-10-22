package com.bytedance.android.livesdk.feed.squarefeed;

import com.bytedance.android.livesdk.feed.squarefeed.vm.OpenFeedViewModel;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ OpenFeedFragment a;

    public f(OpenFeedFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        OpenFeedViewModel r3 = this.a.r;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
    L5:
        if (r3 == null) goto L8;
        r3.refresh("enter_auto");
        return;
    }
}
