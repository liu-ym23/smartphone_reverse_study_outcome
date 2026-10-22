package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 >2\u00020\u0001:\u0001>B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0011J\b\u0010#\u001a\u00020\u001eH\u0002J \u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0002J$\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0001H\u0007J0\u0010.\u001a\u00020/2\u0006\u0010+\u001a\u00020,2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0002J \u00104\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u0016H\u0007J\u000e\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0007J\u0006\u00109\u001a\u00020\u001eJ\b\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u001eH\u0014J\b\u0010=\u001a\u00020\u001eH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/common_ui/view/BottomOverlayViewAdapterPad;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialTouchRawX", "", "initialTouchRawY", "initHeight", "downEvent", "Landroid/view/MotionEvent;", "isScrolling", "", "_isSwipeDown", "boundMenu", "boundSheet", "boundCoordinator", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coverSheetTouchArea", "preferSheetTapTarget", "heightOverride", "Ljava/lang/Integer;", "boundLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "initViewInfo", "", "isSwipeDown", "setCoverSheetTouchAreaEnabled", "enabled", "setPreferSheetTapTargetEnabled", "updateCoverBounds", "updateCoverRect", "menuRect", "Landroid/graphics/Rect;", "sheetRect", "coverRect", "initMenuOnlyTouchListener", "menu", "attachParent", "Landroid/view/ViewGroup;", "sourceRoot", "createMenuOnlyLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "width", "height", "left", "top", "initBottomSheetAndMenuTouchListener", "sheet", "coordinator", "updateHeight", "newHeight", "resetHeight", "addBoundLayoutChangeListeners", "clearBoundViews", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomOverlayViewAdapterPad extends View {
    public static final /* synthetic */ int m = 0;
    public float a;
    public float b;
    public MotionEvent c;
    public boolean d;
    public boolean e;
    public View f;
    public View g;
    public CoordinatorLayout h;
    public boolean i;
    public boolean j;
    public Integer k;
    public final c l;

    public static final class a {
    }

    static {
    }

    public BottomOverlayViewAdapterPad(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BottomOverlayViewAdapterPad(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        View r0 = this.f;
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.l);
    L5:
        View r1 = this.g;
        if (r1 == null) goto L8;
        r1.removeOnLayoutChangeListener(this.l);
    L8:
        CoordinatorLayout r2 = this.h;
        if (r2 == null) goto L11;
        r2.removeOnLayoutChangeListener(this.l);
    L11:
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public final void d() {
        View r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.g;
        if (r1 != null) goto L8;
        return;
    L8:
        Rect r2 = new Rect();
        Rect r3 = new Rect();
        Rect r4 = new Rect();
        r0.getGlobalVisibleRect(r2);
        r1.getGlobalVisibleRect(r3);
        e(r2, r3, r4);
        Rect r5 = new Rect();
        Object r6 = getParent();
        if ((r6 instanceof View) == false) goto L11;
        View r7 = (View) r6;
    L13:
        if (r7 == null) goto L17;
        boolean r8 = true;
        if (r7.getGlobalVisibleRect(r5) != true) goto L17;
    L18:
        int r9 = r4.left;
        if (r8 == false) goto L21;
        r9 = r9 - r5.left;
    L21:
        if (r8 == false) goto L23;
        int r10 = r4.top - r5.top;
    L24:
        int r11 = RangesKt.coerceAtLeast(r4.width(), 0);
        int r12 = RangesKt.coerceAtLeast(r4.height(), 0);
        ViewGroup.LayoutParams r13 = getLayoutParams();
        if (r13 != null) goto L27;
        r13 = new ViewGroup.LayoutParams(r11, r12);
    L27:
        r13.width = r11;
        Integer r14 = this.k;
        if (r14 == null) goto L30;
        r12 = r14.intValue();
    L30:
        r13.height = r12;
        setLayoutParams(r13);
        setX(r9);
        setY(r10);
        requestLayout();
        return;
    L23:
        r10 = r4.top;
    L17:
        r8 = false;
        goto L18
    L11:
        r7 = null;
        goto L13
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new d(this));
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnTouchListener(null);
        MotionEvent r1 = this.c;
        if (r1 == null) goto L5;
        r1.recycle();
    L5:
        this.c = null;
        a();
        this.k = null;
    }

    public final void setCoverSheetTouchAreaEnabled(boolean r2) {
        if (this.i != r2) goto L5;
        return;
    L5:
        this.i = r2;
        d();
    }

    public final void setPreferSheetTapTargetEnabled(boolean r1) {
        this.j = r1;
    }

    public static final void b(View r4, MotionEvent r5) {
        Rect r0 = new Rect();
        r4.getGlobalVisibleRect(r0);
        MotionEvent r1 = MotionEvent.obtain(r5);
        r1.setLocation(r5.getRawX() - r0.left, r5.getRawY() - r0.top);
        r4.dispatchTouchEvent(r1);
        r1.recycle();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.common_ui.view.c] */
    public BottomOverlayViewAdapterPad(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = true;
        this.j = z2.a.preferBottomOverlaySheetTapTarget();
        this.l = new c(this);
    }

    public final void e(Rect r3, Rect r4, Rect r5) {
        r5.set(r3);
        if (this.i == false) goto L7;
        r5.union(r4);
        return;
    L7:
        if (Rect.intersects(r5, r4) == true) goto L9;
        return;
    L9:
        int r6 = r4.top;
        int r0 = r5.top;
        if (r6 > r0) goto L12;
        r5.top = RangesKt.coerceAtMost(r4.bottom, r5.bottom);
        return;
    L12:
        int r7 = r4.bottom;
        int r1 = r5.bottom;
        if (r7 < r1) goto L15;
        r5.bottom = RangesKt.coerceAtLeast(r6, r0);
        return;
    L15:
        r5.top = RangesKt.coerceAtMost(r7, r1);
    }

    public /* synthetic */ BottomOverlayViewAdapterPad(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final void c(BottomOverlayViewAdapterPad r0, Rect r1, Rect r2, CoordinatorLayout r3, View r4, Rect r5, View r6, Rect r7, MotionEvent r8) {
        r4.getGlobalVisibleRect(r5);
        r6.getGlobalVisibleRect(r1);
        r3.getGlobalVisibleRect(r2);
        r0.e(r5, r1, r7);
        float r9 = r8.getRawY() - r0.b;
        int r10 = r1.centerX() - r2.left;
        int r11 = r1.centerY() - r2.top;
        MotionEvent r12 = MotionEvent.obtain(r8);
        r12.setLocation(r10, r11 + r9);
        r3.dispatchTouchEvent(r12);
        r12.recycle();
    }
}
