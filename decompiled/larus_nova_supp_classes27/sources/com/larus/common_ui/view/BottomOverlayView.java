package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0011J$\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0007J0\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J \u0010!\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020\u0014J\b\u0010(\u001a\u00020\u0014H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/common_ui/view/BottomOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialTouchX", "", "initialTouchY", "initHeight", "downEvent", "Landroid/view/MotionEvent;", "isScrolling", "", "_isSwipeDown", "initViewInfo", "", "isSwipeDown", "initMenuOnlyTouchListener", "menu", "attachParent", "Landroid/view/ViewGroup;", "sourceRoot", "createMenuOnlyLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "width", "height", "left", "top", "initBottomSheetAndMenuTouchListener", "sheet", "coordinator", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "updateHeight", "newHeight", "resetHeight", "onDetachedFromWindow", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomOverlayView extends View {
    public static final /* synthetic */ int g = 0;
    public float a;
    public float b;
    public int c;
    public MotionEvent d;
    public boolean e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public BottomOverlayView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BottomOverlayView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnTouchListener(null);
        MotionEvent r1 = this.d;
        if (r1 == null) goto L5;
        r1.recycle();
    L5:
        this.d = null;
    }

    public BottomOverlayView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public static final void b(Rect r3, View r4, MotionEvent r5) {
        Rect r0 = new Rect();
        r4.getGlobalVisibleRect(r0);
        int r1 = r3.left - r0.left;
        int r6 = r3.top - r0.top;
        MotionEvent r7 = MotionEvent.obtain(r5);
        r7.offsetLocation(r1, r6);
        r4.dispatchTouchEvent(r7);
        r7.recycle();
    }

    public final void a(final View r18, View r110, final CoordinatorLayout r20) {
        Intrinsics.checkNotNullParameter(r18, "menu");
        Intrinsics.checkNotNullParameter(r110, "sheet");
        Intrinsics.checkNotNullParameter(r20, "coordinator");
        this.a = 0.0f;
        this.b = 0.0f;
        this.d = null;
        this.e = false;
        this.f = false;
        final Rect r5 = new Rect();
        r18.getGlobalVisibleRect(r5);
        final Rect r3 = new Rect();
        r110.getGlobalVisibleRect(r3);
        final Rect r2 = new Rect(r5);
        r2.union(r3);
        final float r7 = r110.getX() + (r110.getWidth() / 2.0f);
        final float r8 = r110.getY() + (r110.getHeight() / 2.0f);
        int r0 = r5.width();
        int r10 = r2.width();
        int r11 = Math.abs(r5.left - r3.left);
        FLogger r12 = FLogger.a;
        r12.i("BottomOverlayView", "initCover menuRect:" + r5 + " sheetRect:" + r3 + " coverRect:" + r2 + " menuW:" + r0 + " coverW:" + r10 + " gap:" + r11);
        if (r0 > 0) goto L5;
    L7:
        setLayoutParams(new ViewGroup.LayoutParams(r2.width(), r2.height()));
        this.c = r2.height();
        setX(r2.left);
        setY(r2.top);
        setBackgroundColor(0);
        setOnTouchListener(new b(this, r2, r3, r20, r5, r18, r7, r8));
        return;
    L5:
        if (r10 <= (r0 * 1.5f)) goto L7;
        r12.e("BottomOverlayView", "cover_width_abnormal menuRect:" + r5 + " sheetRect:" + r3 + " coverRect:" + r2 + " menuW:" + r0 + " coverW:" + r10);
        goto L7
    }

    public /* synthetic */ BottomOverlayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final void c(BottomOverlayView r1, CoordinatorLayout r2, float r3, float r4, MotionEvent r5) {
        float r0 = r5.getY() - r1.b;
        MotionEvent r6 = MotionEvent.obtain(r5);
        r6.setLocation(r3, r4 + r0);
        r2.dispatchTouchEvent(r6);
        r6.recycle();
    }
}
