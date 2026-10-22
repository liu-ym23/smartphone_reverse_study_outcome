package com.obric.flow.cardlistpage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l9.o;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/flow/cardlistpage/VerticalLineSpaceDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class VerticalLineSpaceDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11438c;
    public final Paint d;

    public VerticalLineSpaceDecoration() {
        int r5 = o.k(4);
        int r10 = o.k(20);
        int r11 = Color.parseColor("#14000000");
        int r12 = o.k(1);
        int r13 = o.k(29);
        this.f11436a = r5;
        this.f11437b = r10;
        this.f11438c = r13;
        Paint r14 = new Paint();
        r14.setColor(r11);
        r14.setStrokeWidth(r12);
        this.d = r14;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r5, View r10, RecyclerView r11, RecyclerView.State r12) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "state");
        super.getItemOffsets(r5, r10, r11, r12);
        r5.bottom = this.f11436a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r19, RecyclerView r20, RecyclerView.State r21) {
        VerticalLineSpaceDecoration r5 = this;
        Intrinsics.checkNotNullParameter(r19, "c");
        Intrinsics.checkNotNullParameter(r20, "parent");
        Intrinsics.checkNotNullParameter(r21, "state");
        super.onDraw(r19, r20, r21);
        r19.save();
        RecyclerView.Adapter r10 = r20.getAdapter();
        if (r10 == null) goto L5;
        int r11 = r10.getItemCount();
    L6:
        int r12 = r20.getChildCount();
        float r13 = r5.f11437b;
        int r14 = r5.f11436a;
        float r15 = r14;
        float r16 = (r5.f11438c - r14) / 2.0f;
        int r17 = 0;
    L7:
        if (r17 >= r12) goto L16;
        View r18 = r20.getChildAt(r17);
        int r22 = r20.getChildAdapterPosition(r18);
        Paint r23 = r5.d;
        if (r22 <= 0) goto L11;
        Paint r110 = r23;
        r19.drawLine(r13, r18.getTop() - r15, r13, r18.getTop() + r16, r110);
    L13:
        if (r22 >= (r11 - 1)) goto L15;
        r19.drawLine(r13, r18.getBottom() - r16, r13, r18.getBottom(), r110);
    L15:
        r17 = r17 + 1;
        r5 = this;
        goto L7
    L11:
        r110 = r23;
        goto L13
    L16:
        r19.restore();
        return;
    L5:
        r11 = 0;
        goto L6
    }
}
