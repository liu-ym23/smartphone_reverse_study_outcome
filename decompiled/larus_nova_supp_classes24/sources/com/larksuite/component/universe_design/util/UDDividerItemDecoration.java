package com.larksuite.component.universe_design.util;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fJ \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larksuite/component/universe_design/util/UDDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "orientation", "", "<init>", "(I)V", "mDivider", "Landroid/graphics/drawable/Drawable;", "mOrientation", "mBounds", "Landroid/graphics/Rect;", "mDrawLastOne", "", "setOrientation", "", "setDrawable", "drawable", "setDrawLastOne", "drawLastOne", "onDraw", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "canvas", "drawHorizontal", "getDrawCount", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "Companion", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDDividerItemDecoration extends RecyclerView.ItemDecoration {
    public Drawable a;
    public final int b;
    public final Rect c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public UDDividerItemDecoration() {
        this.b = 1;
        this.c = new Rect();
    }

    public final void onDraw(Canvas r8, RecyclerView r9, RecyclerView.State r10) {
        Intrinsics.checkNotNullParameter(r8, "c");
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r10, "state");
        if (r9.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.a == null) goto L49;
        int r0 = 0;
        if (this.b != 1) goto L23;
        r8.save();
        Drawable r11 = this.a;
        if (r11 != null) goto L13;
        return;
    L13:
        if (r9.getClipToPadding() == false) goto L15;
        int r1 = r9.getPaddingLeft();
        int r2 = r9.getWidth() - r9.getPaddingRight();
        r8.clipRect(r1, r9.getPaddingTop(), r2, r9.getHeight() - r9.getPaddingBottom());
    L17:
        if (this.d == false) goto L19;
        int r3 = r9.getChildCount();
    L20:
        if (r0 >= r3) goto L22;
        View r4 = r9.getChildAt(r0);
        r9.getDecoratedBoundsWithMargins(r4, this.c);
        int r5 = this.c.bottom + MathKt.roundToInt(r4.getTranslationY());
        r11.setBounds(r1, r5 - r11.getIntrinsicHeight(), r2, r5);
        r11.draw(r8);
        r0 = r0 + 1;
        goto L20
    L22:
        r8.restore();
        return;
    L19:
        r3 = r9.getChildCount() - 1;
        goto L20
    L15:
        r2 = r9.getWidth();
        r1 = 0;
        goto L17
    L23:
        r8.save();
        Drawable r12 = this.a;
        if (r12 != null) goto L27;
        return;
    L27:
        if (r9.getClipToPadding() == false) goto L29;
        int r6 = r9.getPaddingTop();
        int r7 = r9.getHeight() - r9.getPaddingBottom();
        r8.clipRect(r9.getPaddingLeft(), r6, r9.getWidth() - r9.getPaddingRight(), r7);
    L31:
        if (this.d == false) goto L33;
        int r13 = r9.getChildCount();
    L34:
        if (r0 >= r13) goto L39;
        View r14 = r9.getChildAt(r0);
        RecyclerView.LayoutManager r15 = r9.getLayoutManager();
        if (r15 == null) goto L38;
        r15.getDecoratedBoundsWithMargins(r14, this.c);
    L38:
        int r16 = this.c.right + MathKt.roundToInt(r14.getTranslationX());
        r12.setBounds(r16 - r12.getIntrinsicWidth(), r6, r16, r7);
        r12.draw(r8);
        r0 = r0 + 1;
        goto L34
    L39:
        r8.restore();
        return;
    L33:
        r13 = r9.getChildCount() - 1;
        goto L34
    L29:
        r7 = r9.getHeight();
        r6 = 0;
        goto L31
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        Drawable r6 = this.a;
        if (r6 != null) goto L7;
        r2.set(0, 0, 0, 0);
        return;
    L7:
        if (this.b != 1) goto L9;
        Intrinsics.checkNotNull(r6);
        r2.set(0, 0, 0, r6.getIntrinsicHeight());
        return;
    L9:
        Intrinsics.checkNotNull(r6);
        r2.set(0, 0, r6.getIntrinsicWidth(), 0);
    }
}
