package com.obric.flow.cardlistpage.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.drakeet.multitype.MultiTypeAdapter;
import com.obric.flow.cardlistpage.ui.component.feedlist.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/flow/cardlistpage/ui/CardItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CardItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MultiTypeAdapter f11562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11564c;
    public final int d;
    public final r e;

    public CardItemDecoration(MultiTypeAdapter r5, int r10, int r11, int r12, r r13) {
        Intrinsics.checkNotNullParameter(r5, "adapter");
        Intrinsics.checkNotNullParameter(r13, "suggestDecoratorInterface");
        this.f11562a = r5;
        this.f11563b = r10;
        this.f11564c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        Intrinsics.checkNotNullParameter(r10, "outRect");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r13, "state");
        super.getItemOffsets(r10, r11, r12, r13);
        int r14 = r12.getChildAdapterPosition(r11);
        int r5 = this.d;
        int r15 = this.f11564c;
        int r16 = this.f11563b;
        if (r14 == (-1)) goto L30;
        MultiTypeAdapter r17 = this.f11562a;
        if (r14 >= r17.f7569a.size()) goto L30;
        r r18 = this.e;
        r18.getClass();
        r10.bottom = r5;
        RecyclerView.LayoutManager r19 = r18.f11599a.e.getLayoutManager();
        if ((r19 instanceof GridLayoutManager) == false) goto L10;
        GridLayoutManager r20 = (GridLayoutManager) r19;
    L11:
        if (r20 == null) goto L15;
        GridLayoutManager.SpanSizeLookup r21 = r20.getSpanSizeLookup();
        if (r21 == null) goto L15;
        int r22 = r21.getSpanSize(r14);
    L17:
        if (r22 != 4) goto L19;
        r10.left = r16;
        r10.right = r16;
        return;
    L19:
        int r23 = 0;
        int r24 = 0;
    L20:
        if (r23 >= r14) goto L26;
        int r25 = i.b(r17, r23) + r24;
        if (r25 < 4) goto L24;
        r24 = 0;
    L25:
        r23 = r23 + 1;
        goto L20
    L24:
        r24 = r25;
        goto L25
    L26:
        if (r24 != 0) goto L28;
        r10.left = r16;
        r10.right = r15 / 2;
        return;
    L28:
        r10.left = r15 / 2;
        r10.right = r16;
        return;
    L15:
        r22 = 1;
        goto L17
    L10:
        r20 = null;
    L30:
        ViewGroup.LayoutParams r26 = r11.getLayoutParams();
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        GridLayoutManager.LayoutParams r27 = (GridLayoutManager.LayoutParams) r26;
        int r28 = r27.getSpanIndex();
        int r29 = r27.getSpanSize();
        RecyclerView.LayoutManager r30 = r12.getLayoutManager();
        Intrinsics.checkNotNull(r30, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        int r31 = ((GridLayoutManager) r30).getSpanCount();
        r10.bottom = r5;
        if (r29 != r31) goto L33;
        r10.left = r16;
        r10.right = r16;
        return;
    L33:
        if (r28 != 0) goto L36;
        r10.left = r16;
        r10.right = r15 / 2;
        return;
    L36:
        if ((r28 + r29) != r31) goto L38;
        r10.left = r15 / 2;
        r10.right = r16;
        return;
    L38:
        int r32 = r15 / 2;
        r10.left = r32;
        r10.right = r32;
    }
}
