package com.bytedance.android.live.search.impl.search.callback;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qa1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/callback/OnRecyclerViewFlingListener;", "Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnRecyclerViewFlingListener extends RecyclerView.OnFlingListener {
    public final boolean a;
    public int[] b;
    public int[] c;
    public int d;
    public int e;
    public final RecyclerView f;
    public final f g;

    public OnRecyclerViewFlingListener(RecyclerView r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "onHasMoreListener");
        this.f = r2;
        this.g = r3;
        this.a = true;
        this.d = -1;
    }

    public final boolean onFling(int r7, int r8) {
        if (this.a == true) goto L5;
        return false;
    L5:
        GridLayoutManager r9 = this.f.getLayoutManager();
        if ((r9 instanceof GridLayoutManager) == false) goto L11;
        GridLayoutManager r1 = r9;
        int r3 = r1.findFirstVisibleItemPosition();
        int r4 = r1.findLastVisibleItemPosition();
        if (this.d != (-1)) goto L25;
        this.d = r1.getSpanCount();
    L25:
        int r2 = r9.getChildCount();
        int r5 = r9.getItemCount();
        if (r2 <= 0) goto L51;
        View r10 = r9.findViewByPosition(r3);
        if (r10 == null) goto L30;
        int r12 = r10.getHeight();
    L31:
        if (r12 != 0) goto L33;
        return false;
    L33:
        int r6 = this.d;
        if (r6 != (-1)) goto L46;
        int r13 = this.e;
        if (r13 <= 0) goto L38;
        if (r13 > r5) goto L38;
    L40:
        if (((r8 / r12) + r4) < (r5 - this.e)) goto L51;
        if (this.g.hasMore() == false) goto L44;
        this.g.preload();
        goto L51
    L44:
        this.g.x1();
    L38:
        this.e = 2;
        goto L40
    L46:
        if ((((r8 / r12) + (r4 / r6)) + 3) < (r5 / r6)) goto L51;
        if (this.g.hasMore() == false) goto L50;
        this.g.preload();
        goto L51
    L50:
        this.g.x1();
        goto L51
    L30:
        r12 = 0;
    L51:
        return false;
    L11:
        if ((r9 instanceof LinearLayoutManager) == false) goto L14;
        LinearLayoutManager r14 = (LinearLayoutManager) r9;
        r3 = r14.findFirstVisibleItemPosition();
        r4 = r14.findLastVisibleItemPosition();
        goto L25
    L14:
        if ((r9 instanceof StaggeredGridLayoutManager) == false) goto L53;
        StaggeredGridLayoutManager r15 = (StaggeredGridLayoutManager) r9;
        if (this.d != (-1)) goto L19;
        this.d = r15.getSpanCount();
    L19:
        if (this.b != null) goto L22;
        this.b = new int[r15.getSpanCount()];
    L22:
        if (this.c != null) goto L24;
        this.c = new int[r15.getSpanCount()];
    L24:
        r15.findFirstVisibleItemPositions(this.b);
        r15.findLastVisibleItemPositions(this.c);
        int[] r16 = this.b;
        Intrinsics.checkNotNull(r16);
        r3 = r16[0];
        int[] r17 = this.c;
        Intrinsics.checkNotNull(r17);
        int[] r18 = this.c;
        Intrinsics.checkNotNull(r18);
        r4 = r17[r18.length - 1];
        goto L25
    L53:
        throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
    }
}
