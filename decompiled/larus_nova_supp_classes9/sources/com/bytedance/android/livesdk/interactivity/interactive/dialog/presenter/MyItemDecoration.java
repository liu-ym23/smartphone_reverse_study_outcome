package com.bytedance.android.livesdk.interactivity.interactive.dialog.presenter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/presenter/MyItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MyItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public MyItemDecoration(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        if (r6 != 0) goto L6;
        r2.left = this.b;
        return;
    L6:
        if (r6 != (r5.getItemCount() - 1)) goto L8;
        r2.left = this.a;
        r2.right = this.c;
        return;
    L8:
        r2.left = this.a;
    }
}
