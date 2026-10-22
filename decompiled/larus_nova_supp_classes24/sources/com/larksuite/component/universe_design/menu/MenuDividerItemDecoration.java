package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lcom/larksuite/component/universe_design/menu/MenuDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "dividerPositions", "", "", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "dividerSize", "", "dividerPadding", "borderSize", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "universe-ui-menu_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MenuDividerItemDecoration extends RecyclerView.ItemDecoration {
    public final List<Integer> a;
    public final float b;
    public final float c;
    public final float d;
    public final Lazy e;

    public MenuDividerItemDecoration(final Context r2, List<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dividerPositions");
        this.a = r3;
        this.b = new UDDimension.Dp(0.5f).toPixels(r2);
        this.c = new UDDimension.Dp(2).toPixels(r2);
        this.d = new UDDimension.Dp(1).toPixels(r2);
        this.e = LazyKt.lazy(new MenuDividerItemDecoration$paint$2(r2));
    }

    public final void onDrawOver(Canvas r13, RecyclerView r14, RecyclerView.State r15) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        Intrinsics.checkNotNullParameter(r14, "parent");
        Intrinsics.checkNotNullParameter(r15, "state");
        int r16 = r14.getChildCount();
        RecyclerView.Adapter r0 = r14.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r16) goto L19;
        View r3 = r14.getChildAt(r2);
        int r4 = r14.getChildAdapterPosition(r3);
        if (this.a.contains(Integer.valueOf(r4)) == false) goto L18;
        if (r4 == (-1)) goto L18;
        if (r4 < 0) goto L15;
        boolean r6 = true;
        if (r4 >= (r0.getItemCount() - 1)) goto L15;
    L16:
        if (r6 == false) goto L18;
        float r7 = (r3.getLeft() - r14.getPaddingLeft()) + this.d;
        float r8 = r3.getBottom() + this.c;
        r13.drawRect(r7, r8, (r3.getRight() + r14.getPaddingRight()) - this.d, r8 + this.b, (Paint) this.e.getValue());
    L15:
        r6 = false;
    L18:
        r2 = r2 + 1;
        goto L6
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        RecyclerView.Adapter r7 = r4.getAdapter();
        if (r7 != null) goto L5;
        return;
    L5:
        r2.setEmpty();
        if (this.a.contains(Integer.valueOf(r6)) == true) goto L8;
        return;
    L8:
        if (r6 < 0) goto L12;
        boolean r0 = true;
        if (r6 >= (r7.getItemCount() - 1)) goto L12;
    L13:
        if (r0 == false) goto L17;
        r2.set(0, 0, 0, (int) ((this.c * 2) + this.b));
        return;
    L17:
        return;
    L12:
        r0 = false;
        goto L13
    }
}
