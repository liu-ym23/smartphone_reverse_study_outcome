package com.bytedance.android.livesdk.feed.preview;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ LiveFeedPreview a;
    public final /* synthetic */ LifecycleOwner b;

    public b(LiveFeedPreview r1, LifecycleOwner r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r3) {
        Pair r4 = (Pair) r3;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.getFirst() != null) goto L8;
        return;
    L8:
        if (r4.getSecond() == null) goto L12;
        LiveFeedPreview r0 = this.a;
        Object r1 = r4.getFirst();
        Intrinsics.checkNotNull(r1);
        int r2 = ((Number) r1).intValue();
        Object r5 = r4.getSecond();
        Intrinsics.checkNotNull(r5);
        LiveFeedPreview.d(r0, r2, ((Number) r5).intValue());
        return;
    }
}
