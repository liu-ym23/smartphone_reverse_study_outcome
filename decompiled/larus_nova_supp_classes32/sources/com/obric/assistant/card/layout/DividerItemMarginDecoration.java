package com.obric.assistant.card.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/card/layout/DividerItemMarginDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "dividerHeightPx", NameKeys.UnloadStrategy_No_Strategy, "dividerColor", "leftMarginPx", "rightMarginPx", "<init>", "(IIII)V", "paint", "Landroid/graphics/Paint;", "getItemOffsets", NameKeys.UnloadStrategy_No_Strategy, "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DividerItemMarginDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final Paint d;

    public final void onDraw(Canvas r16, RecyclerView r17, RecyclerView.State r18) {
        Intrinsics.checkNotNullParameter(r16, "c");
        Intrinsics.checkNotNullParameter(r17, "parent");
        Intrinsics.checkNotNullParameter(r18, "state");
        super.onDraw(r16, r17, r18);
        int r2 = r17.getChildCount();
        RecyclerView.LayoutManager r10 = r17.getLayoutManager();
        if (r10 != null) goto L5;
        return;
    L5:
        int r12 = 0;
    L6:
        if (r12 >= r2) goto L16;
        View r3 = r17.getChildAt(r12);
        int r4 = r17.getChildAdapterPosition(r3);
        RecyclerView.Adapter r5 = r17.getAdapter();
        if (r5 == null) goto L12;
        boolean r6 = true;
        if (r4 != (r5.getItemCount() - 1)) goto L12;
    L13:
        if (r6 == true) goto L15;
        int r7 = r10.getDecoratedLeft(r3) + this.b;
        int r8 = r10.getDecoratedRight(r3) - this.c;
        int r9 = r10.getDecoratedBottom(r3);
        int r11 = this.a;
        int r13 = r9 - r11;
        r16.drawRect(r7, r13, r8, r11 + r13, this.d);
    L15:
        r12 = r12 + 1;
    L12:
        r6 = false;
        goto L13
    }

    public DividerItemMarginDecoration(int r1, int r2, int r3, int r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        Paint r5 = new Paint();
        r5.setColor(r2);
        r5.setStyle(Paint.Style.FILL);
        this.d = r5;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.getItemOffsets(r2, r3, r4, r5);
        int r6 = r4.getChildAdapterPosition(r3);
        RecyclerView.Adapter r7 = r4.getAdapter();
        boolean r8 = false;
        if (r7 != null) goto L5;
    L7:
        if (r8 == true) goto L10;
        r2.bottom = this.a;
        return;
    L10:
        return;
    L5:
        if (r6 != (r7.getItemCount() - 1)) goto L7;
        r8 = true;
        goto L7
    }
}
