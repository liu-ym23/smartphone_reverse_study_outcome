package com.ss.android.lark.movable.island;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.movable.MovableView;
import com.ss.android.lark.movable.utils.e;
import jsb.a;
import jsb.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&J\u0006\u0010'\u001a\u00020\u001aR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/movable/island/ScrollIsland;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "islandID", "getIslandID", "()I", "setIslandID", "(I)V", "innerMovableView", "Lcom/ss/android/lark/movable/MovableView;", "getInnerMovableView", "()Lcom/ss/android/lark/movable/MovableView;", "rootMovableView", "radius", "", "borderWidth", "borderDrawable", "Landroid/graphics/drawable/GradientDrawable;", "makeRoundCorner", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "setParentInfo", "updateSize", "info", "Lcom/ss/android/lark/movable/island/IslandInfo;", "triggerIslandRender", "renderData", "", "documentInfo", "Lcom/bytedance/lark/lark_markdown_render_android/MovableDocumentInfo;", "cleanup", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ScrollIsland extends HorizontalScrollView {
    public int a;
    public final MovableView b;
    public final float c;
    public final GradientDrawable d;

    public ScrollIsland(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ScrollIsland(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final MovableView getInnerMovableView() {
        return this.b;
    }

    public final int getIslandID() {
        return this.a;
    }

    public final void a(a r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L11;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.width = (int) r4.d;
        r1.height = (int) r4.e;
        r1.leftMargin = (int) r4.b;
        r1.topMargin = (int) r4.c;
        setLayoutParams(r1);
        MovableView r2 = this.b;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L9;
        r3.width = (int) r4.f;
        r3.height = (int) r4.g;
        r2.setLayoutParams(r3);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.dispatchDraw(r6);
        float r0 = getScrollX();
        float r1 = getScrollY();
        int r2 = r6.save();
        r6.translate(r0, r1);
        this.d.setBounds(0, 0, r6.getWidth(), r6.getHeight());     // Catch: Throwable -> L6
        this.d.draw(r6);     // Catch: Throwable -> L6
        r6.restoreToCount(r2);
        return;
    L6:
        th = move-exception;
        r6.restoreToCount(r2);
        throw th;
    }

    public final void setIslandID(int r1) {
        this.a = r1;
    }

    public final void setParentInfo(MovableView r2) {
        MovableView r0 = this.b;
        r0.r = this;
        r0.s = r2;
    }

    public ScrollIsland(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        MovableView r6 = new MovableView(r3, null);
        this.b = r6;
        addView(r6);
        setClipChildren(false);
        setOutlineProvider(new c(this));
        setClipToOutline(true);
        setOverScrollMode(2);
        float r0 = e.a(8);
        this.c = r0;
        int r7 = e.a(1);
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setCornerRadius(r0);
        r1.setStroke(r7, UDColorUtils.getColor(r3, 2131103351));
        r1.setColor(UDColorUtils.getColor(r3, R.color.transparent));
        this.d = r1;
    }

    public /* synthetic */ ScrollIsland(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        int r5 = R.attr.horizontalScrollViewStyle;
    L9:
        this(r1, r2, r5);
        return;
    L8:
        r5 = 0;
        goto L9
    }
}
