package com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/adapter/CustomSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomSmoothScroller extends LinearSmoothScroller {
    public long a;

    public CustomSmoothScroller(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = 300;
    }

    public final int calculateTimeForScrolling(int r3) {
        float r4 = r3;
        RecyclerView.LayoutManager r0 = getLayoutManager();
        if (r0 == null) goto L5;
        float r1 = r0.getWidth();
    L7:
        return (int) (this.a * (r4 / r1));
    L5:
        r1 = 1.0f;
        goto L7
    }
}
