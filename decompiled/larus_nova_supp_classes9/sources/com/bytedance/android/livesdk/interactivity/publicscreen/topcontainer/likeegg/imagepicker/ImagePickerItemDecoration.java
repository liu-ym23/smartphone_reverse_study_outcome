package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/ImagePickerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImagePickerItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public ImagePickerItemDecoration(int r1, int r2) {
        this.a = r1;
        this.b = r2;
        this.c = 4;
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        int r7 = r5.getChildAdapterPosition(r4);
        int r8 = this.c;
        int r9 = r7 / r8;
        int r10 = r7 % r8;
        int r0 = this.a;
        r3.left = (r10 * r0) / r8;
        r3.right = r0 - (((r10 + 1) * r0) / r8);
        if (r9 < 1) goto L6;
        r3.top = this.b;
        return;
    }
}
