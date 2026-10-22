package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/CenterItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CenterItemDecoration extends RecyclerView.ItemDecoration {
    public final Function0<Integer> a;

    public static final class a {
    }

    static {
    }

    public CenterItemDecoration(Function0<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "viewWidth");
        this.a = r2;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.getItemOffsets(r2, r3, r4, r5);
        int r6 = r5.getItemCount();
        int r7 = r4.getChildAdapterPosition(r3);
        if (r7 != 0) goto L5;
    L7:
        int r8 = (r4.getMeasuredWidth() - ((Number) this.a.invoke()).intValue()) / 2;
        if (r7 != 0) goto L11;
        r2.left = r8;
        return;
    L11:
        if (r7 != (r6 - 1)) goto L15;
        r2.right = r8;
        return;
    L15:
        return;
    L5:
        if (r7 == (r6 - 1)) goto L7;
    }
}
