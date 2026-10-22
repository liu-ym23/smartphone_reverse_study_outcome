package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rJ \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "divider", "Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupDividerDrawable;", "bounds", "Landroid/graphics/Rect;", "setDividerBackgroundColor", "", "dividerBackgroundColor", "", "setLeftPadding", "dividerLeftPadding", "onDraw", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "canvas", "getDrawCount", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "ignition-widget-settinggroup_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SettingGroupDividerItemDecoration extends RecyclerView.ItemDecoration {
    public final SettingGroupDividerDrawable a;
    public final Rect b;

    public SettingGroupDividerItemDecoration(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = new SettingGroupDividerDrawable(r2);
        this.b = new Rect();
    }

    public final void onDraw(Canvas r7, RecyclerView r8, RecyclerView.State r9) {
        Intrinsics.checkNotNullParameter(r7, "c");
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "state");
        if (r8.getLayoutManager() != null) goto L5;
        return;
    L5:
        r7.save();
        SettingGroupDividerDrawable r10 = this.a;
        int r0 = r8.getPaddingLeft();
        int r1 = r8.getWidth() - r8.getPaddingRight();
        r7.clipRect(r0, r8.getPaddingTop(), r1, r8.getHeight() - r8.getPaddingBottom());
        int r2 = r8.getChildCount() - 1;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        View r4 = r8.getChildAt(r3);
        r8.getDecoratedBoundsWithMargins(r4, this.b);
        int r5 = this.b.bottom + MathKt.roundToInt(r4.getTranslationY());
        r10.setBounds(r0, r5 - r10.getIntrinsicHeight(), r1, r5);
        r10.draw(r7);
        r3 = r3 + 1;
        goto L6
    L8:
        r7.restore();
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        r2.set(0, 0, 0, this.a.getIntrinsicHeight());
    }
}
