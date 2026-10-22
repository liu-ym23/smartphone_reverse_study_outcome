package com.ss.android.lark.flow.feed.component.title;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larksuite.framework.ui.SpareLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J0\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020&J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u0018J\u0006\u0010+\u001a\u00020\u0018J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0014J\f\u0010/\u001a\u00020\u0018*\u000200H\u0002J\u0016\u00101\u001a\u00020\u001a2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\f\u00103\u001a\u00020&*\u000204H\u0002R\u001c\u0010\t\u001a\u00020\n8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/title/FlowTitleView;", "Lcom/larksuite/framework/ui/SpareLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "titleViewComponent", "Lcom/ss/android/lark/flow/feed/component/title/FlowTitleViewComponent;", "getTitleViewComponent", "()Lcom/ss/android/lark/flow/feed/component/title/FlowTitleViewComponent;", "setTitleViewComponent", "(Lcom/ss/android/lark/flow/feed/component/title/FlowTitleViewComponent;)V", "drawableTagComponents", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/feed/cardcomponent/title/feedtag/FeedTagComponent;", "Lkotlin/collections/ArrayList;", "customTagViews", "Landroid/view/View;", "titleFadeMask", "Landroid/graphics/drawable/GradientDrawable;", "isTitleFadeMaskVisible", "", "init", "", "addTitleView", "generateLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "bindTitleView", "titleText", "", "tags", "", "Lcom/ss/android/lark/flow/feed/component/title/FlowFeedTag;", "isBoldDisplay", "titleTextSize", "", "updateTitleFadeMask", "backgroundColor", "setTitleFadeMaskVisible", "isVisible", "isTitleFadeMaskShowing", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "hasOverLengthText", "Landroid/widget/TextView;", "bindTags", "clearAllTags", "dp2px", "", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowTitleView extends SpareLayout {
    public static final int g = 0;
    public b b;
    public final ArrayList<vdb.a> c;
    public final ArrayList<View> d;
    public GradientDrawable e;
    public boolean f;

    public static final class a {
    }

    static {
        g = UIHelper.dp2px(20.0f);
    }

    public final b getTitleViewComponent() {
        return this.b;
    }

    public FlowTitleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        super/*android.widget.FrameLayout*/.dispatchDraw(r8);
        GradientDrawable r0 = this.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f == true) goto L8;
        return;
    L8:
        TextView r1 = (TextView) getTitleViewComponent().c();
        int r2 = r1.getWidth();
        int r3 = g;
        if (r2 > r3) goto L11;
        return;
    L11:
        Layout r4 = r1.getLayout();
        boolean r5 = false;
        if (r4 != null) goto L15;
    L20:
        if (r5 == true) goto L22;
        return;
    L22:
        r0.setBounds(RangesKt.coerceAtLeast(r1.getRight() - r3, r1.getLeft()), r1.getTop(), r1.getRight(), r1.getBottom());
        r0.draw(r8);
        return;
    L15:
        if (r4.getLineCount() <= 0) goto L20;
        if (r4.getLineWidth(0) <= ((r1.getWidth() - r1.getCompoundPaddingLeft()) - r1.getCompoundPaddingRight())) goto L20;
        r5 = true;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTitleFadeMaskVisible(boolean r2) {
        if (this.f != r2) goto L5;
        return;
    L5:
        this.f = r2;
        invalidate();
    }

    public final void setTitleViewComponent(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowTitleView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, 0);
        this.b = new b(getContext());
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.f = true;
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        r4.gravity = 16;
        addView(getTitleViewComponent().c(), 0, r4);
    }
}
