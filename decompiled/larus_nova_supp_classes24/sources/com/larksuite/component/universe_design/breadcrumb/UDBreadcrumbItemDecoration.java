package com.larksuite.component.universe_design.breadcrumb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumbItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "decorationIconRes", "", "<init>", "(Landroid/content/Context;I)V", "mIconSize", "mRect", "Landroid/graphics/Rect;", "mDecorationIcon", "Landroid/graphics/drawable/Drawable;", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "universe-ui-breadcrumb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDBreadcrumbItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Drawable b;

    public UDBreadcrumbItemDecoration(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = d.d(r4, 2131169363);
        this.a = r0;
        Rect r1 = new Rect(0, 0, r0, r0);
        Drawable r2 = UDIconUtils.getIconDrawable(r4, 2131255563);
        r2.setBounds(r1);
        r2.setTint(UDColorUtils.getColor(r4, 2131102420));
        this.b = r2;
    }

    public final void onDrawOver(Canvas r7, RecyclerView r8, RecyclerView.State r9) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "state");
        int r10 = r8.getChildCount();
        RecyclerView.Adapter r0 = r8.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r10) goto L14;
        View r2 = r8.getChildAt(r1);
        int r3 = r8.getChildAdapterPosition(r2);
        if (r3 == (-1)) goto L13;
        if (r3 <= 0) goto L13;
        if (r3 >= r0.getItemCount()) goto L13;
        int r4 = (int) r2.getTranslationX();
        r7.save();
        float r5 = r2.getLeft();
        int r6 = r2.getHeight();
        float r11 = r5 + r4;
        int r12 = this.a;
        r7.translate(r11 - r12, (r6 - r12) / 2.0f);
        this.b.draw(r7);
        r7.restore();
    L13:
        r1 = r1 + 1;
        goto L6
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        RecyclerView.Adapter r7 = r4.getAdapter();
        if (r7 != null) goto L6;
        return;
    L6:
        if (r6 == (-1)) goto L12;
        if (r6 <= 0) goto L12;
        if (r6 >= r7.getItemCount()) goto L12;
        r2.set(this.a, 0, 0, 0);
        return;
    L12:
        r2.set(0, 0, 0, 0);
    }
}
