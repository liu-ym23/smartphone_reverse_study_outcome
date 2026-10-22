package com.bytedance.android.livesdk.feed.squarefeed;

import com.bytedance.android.livesdk.feed.squarefeed.vm.OpenRankViewModel;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ OpenRankFragment a;

    public j(OpenRankFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        OpenRankViewModel r3 = this.a.r;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("feedRankViewModel");
    L5:
        if (r3 == null) goto L8;
        r3.refresh("enter_auto");
        return;
    }
}
