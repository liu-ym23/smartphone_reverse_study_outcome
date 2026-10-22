package com.bytedance.android.live.search.impl.search.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchResultDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchResultDecoration extends RecyclerView.ItemDecoration {

    public static final class a {
    }

    static {
    }

    public LiveSearchResultDecoration() {
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (r4.getVisibility() != 0) goto L5;
        int r7 = s1.f(3.0f);
    L6:
        StaggeredGridLayoutManager.LayoutParams r8 = r4.getLayoutParams();
        if (r8 == null) goto L17;
        StaggeredGridLayoutManager.LayoutParams r9 = (RecyclerView.LayoutParams) r8;
        if ((r9 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L11;
        boolean r10 = r9.isFullSpan();
    L12:
        if (r10 == false) goto L14;
        r7 = s1.f(3.0f);
    L14:
        int r12 = s1.f(1.5f);
        r3.set(r12, r7, r12, 0);
        return;
    L11:
        r10 = false;
        goto L12
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L5:
        r7 = 0;
        goto L6
    }
}
