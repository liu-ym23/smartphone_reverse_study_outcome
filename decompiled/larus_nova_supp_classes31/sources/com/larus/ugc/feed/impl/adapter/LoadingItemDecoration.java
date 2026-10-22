package com.larus.ugc.feed.impl.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/ugc/feed/impl/adapter/LoadingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "<init>", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LoadingItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public LoadingItemDecoration(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r4, "outRect");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "state");
        super.getItemOffsets(r4, r5, r6, r7);
        int r8 = r6.getChildAdapterPosition(r5);
        int r9 = this.a;
        int r0 = r8 % r9;
        boolean r1 = true;
        if (r0 != 0) goto L6;
        r4.left = 0;
        r4.right = this.b / 2;
    L9:
        if (r8 == 0) goto L12;
        if (r8 == 1) goto L12;
        r4.top = this.b / 2;
    L13:
        RecyclerView.Adapter r10 = r6.getAdapter();
        if (r10 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        if (r11 == true) goto L29;
        RecyclerView.Adapter r12 = r6.getAdapter();
        if (r12 != null) goto L23;
    L25:
        r1 = false;
    L26:
        if (r1 == true) goto L29;
        r4.bottom = this.b / 2;
        return;
    L23:
        if (r8 != (r12.getItemCount() - 2)) goto L25;
    L29:
        r4.bottom = 0;
        return;
    L16:
        if (r8 != (r10.getItemCount() - 1)) goto L18;
        r11 = true;
    L12:
        r4.top = 0;
        goto L13
    L6:
        if (r0 != (r9 - 1)) goto L8;
        r4.left = this.b / 2;
        r4.right = 0;
        goto L9
    L8:
        int r13 = this.b;
        r4.left = r13 / 2;
        r4.right = r13 / 2;
        goto L9
    }
}
