package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0012J\u0016\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\nJ\u0014\u0010\u0017\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bJ\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u0013J\u0006\u0010\u001f\u001a\u00020\u0013J>\u0010 \u001a\u00020\u001326\u0010!\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00130\u0011J\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0013J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u001a\u0010'\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0013H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002JD\u0010-\u001a\u00020\u0013*\u00020.26\u0010/\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00130\u0011H\u0002R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/CardListLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "isExpanded", "()Z", "childrenOnClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "ellipsizeBottomPadding", "", "ellipsizeVerticalPadding", "addCardView", "view", "index", "views", "", "removeFirstCardView", "removeCardViewAt", "expand", "ellipsize", "setChildrenOnClickListener", "listener", "Lkotlin/ParameterName;", "name", "removeChildrenOnClickListener", "onTransitionEnd", "removeCardView", "addCardViewInner", "onViewChanged", "ensureOnClickListener", "ensureChildrenVisibility", "calcAndSetEllipsize", "calcAndSetExpanded", "forEachChildrenIndex", "Landroid/view/ViewGroup;", "block", "child", "Companion", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CardListLayout extends ConstraintLayout {
    public boolean a;
    public Function2<? super Integer, ? super View, Unit> b;
    public final float c;
    public final float d;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        if (this.a == false) goto L5;
        S5(this, CardListLayout$ensureChildrenVisibility$1.INSTANCE);
        return;
    L5:
        S5(this, CardListLayout$ensureChildrenVisibility$2.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5() {
        if (this.a == false) goto L5;
        S5(this, new CardListLayout$calcAndSetExpanded$1(this));
    L10:
        S5(this, new CardListLayout$ensureOnClickListener$1(this));
        R5();
        return;
    L5:
        View r0 = getChildAt(0);
        if (r0 == null) goto L8;
        final int r1 = r0.getId();
    L9:
        S5(this, new CardListLayout$calcAndSetEllipsize$1(r1, this));
        goto L10
    L8:
        r1 = -1;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = new UDDimension.Dp(8).toPixels(getContext());
        this.d = new UDDimension.Dp(12).toPixels(getContext());
        setClipToPadding(false);
    }

    public final void setChildrenOnClickListener(Function2<? super Integer, ? super View, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = new UDDimension.Dp(8).toPixels(getContext());
        this.d = new UDDimension.Dp(12).toPixels(getContext());
        setClipToPadding(false);
    }

    public static void S5(ViewGroup r4, Function2 r5) {
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.invoke(Integer.valueOf(r1), r4.getChildAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new UDDimension.Dp(8).toPixels(getContext());
        this.d = new UDDimension.Dp(12).toPixels(getContext());
        setClipToPadding(false);
    }
}
