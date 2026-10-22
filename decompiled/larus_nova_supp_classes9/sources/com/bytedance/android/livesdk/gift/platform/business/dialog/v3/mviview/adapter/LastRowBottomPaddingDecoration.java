package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/LastRowBottomPaddingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LastRowBottomPaddingDecoration extends RecyclerView.ItemDecoration {
    public final Function0<Boolean> a;

    public LastRowBottomPaddingDecoration(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "canShowDecoration");
        this.a = r2;
    }

    public final void getItemOffsets(Rect r5, View r6, RecyclerView r7, RecyclerView.State r8) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "state");
        super.getItemOffsets(r5, r6, r7, r8);
        RecyclerView.LayoutManager r9 = r7.getLayoutManager();
        if ((r9 instanceof GridLayoutManager) == true) goto L5;
        r9 = null;
    L5:
        GridLayoutManager r10 = (GridLayoutManager) r9;
        if (r10 != null) goto L8;
        return;
    L8:
        int r11 = r7.getChildAdapterPosition(r6);
        if (r10.getSpanSizeLookup().getSpanSize(0) != r10.getSpanCount()) goto L11;
        boolean r0 = true;
    L12:
        int r13 = r10.getSpanSizeLookup().getSpanGroupIndex(r11, r10.getSpanCount());
        RecyclerView.Adapter r14 = r7.getAdapter();
        if (r14 == null) goto L25;
        int r15 = r14.getItemCount();
        if (r0 == true) goto L17;
        int r16 = (r15 - 1) / 4;
    L18:
        if (r13 != r16) goto L23;
        if (r16 <= 1) goto L23;
        if (((Boolean) this.a.invoke()).booleanValue() == false) goto L23;
        r5.bottom = com.bytedance.android.live.revenue.common.i.b(58);
        return;
    L23:
        r5.bottom = 0;
        return;
    L17:
        r16 = ((r15 - 2) / 4) + 1;
        goto L18
    L25:
        return;
    L11:
        r0 = false;
        goto L12
    }
}
