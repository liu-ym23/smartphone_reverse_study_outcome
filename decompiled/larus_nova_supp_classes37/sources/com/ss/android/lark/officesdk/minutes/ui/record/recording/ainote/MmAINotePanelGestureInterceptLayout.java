package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0012H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelGestureInterceptLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureListener", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelGestureInterceptLayout$GestureListener;", "getGestureListener", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelGestureInterceptLayout$GestureListener;", "setGestureListener", "(Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelGestureInterceptLayout$GestureListener;)V", "touchSlop", "downX", "", "downY", "activeTouchTarget", "Landroid/view/View;", "handlingVerticalSwipe", "", "gestureTriggered", "requestDisallowInterceptTouchEvent", "", "disallowIntercept", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "canActiveTouchTargetScrollVertically", "direction", "findTouchTarget", "x", "y", "GestureListener", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmAINotePanelGestureInterceptLayout extends FrameLayout {
    public a a;
    public final int b;
    public float c;
    public float d;
    public View e;
    public boolean f;
    public boolean g;

    public interface a {
        boolean a();

        void b(float r1);

        void c(float r1);

        void d();

        boolean onDragStart();
    }

    public MmAINotePanelGestureInterceptLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmAINotePanelGestureInterceptLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
    }

    public final a getGestureListener() {
        return this.a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        int r0 = r8.getActionMasked();
        if (r0 != 0) goto L5;
        this.c = r8.getRawX();
        this.d = r8.getRawY();
        this.e = a(r8.getX(), r8.getY());
        this.f = false;
        this.g = false;
    L50:
        return super.onInterceptTouchEvent(r8);
    L5:
        if (r0 != 1) goto L7;
    L47:
        this.e = null;
        this.f = false;
        this.g = false;
        goto L50
    L7:
        if (r0 != 2) goto L9;
        float r1 = r8.getRawX() - this.c;
        float r5 = r8.getRawY() - this.d;
        if (Math.abs(r5) <= Math.abs(r1)) goto L50;
        if (Math.abs(r5) <= (this.b * 2)) goto L50;
        if (r5 >= 0.0f) goto L26;
        a r2 = this.a;
        if (r2 != null) goto L20;
    L22:
        boolean r3 = false;
    L23:
        if (r3 == false) goto L26;
        this.f = true;
        return true;
    L20:
        if (r2.a() != true) goto L22;
        r3 = true;
    L26:
        if (r5 >= 0.0f) goto L28;
        int r9 = 1;
    L29:
        View r4 = this.e;
    L30:
        if (r4 == null) goto L41;
        if (r4 == this) goto L41;
        if (r4.getVisibility() == 0) goto L35;
    L37:
        Object r6 = r4.getParent();
        if ((r6 instanceof View) == true) goto L39;
        r4 = null;
        goto L30
    L39:
        r4 = (View) r6;
        goto L30
    L35:
        if (r4.canScrollVertically(r9) == false) goto L37;
        boolean r10 = true;
    L42:
        if (r10 == false) goto L45;
        this.f = false;
        return false;
    L45:
        this.f = true;
        return true;
    L41:
        r10 = false;
        goto L42
    L28:
        r9 = -1;
        goto L29
    L9:
        if (r0 == 3) goto L47;
        goto L47
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.f == false) goto L5;
    L8:
        int r0 = r6.getActionMasked();
        boolean r1 = false;
        if (r0 != 0) goto L11;
        this.c = r6.getRawX();
        this.d = r6.getRawY();
        this.e = a(r6.getX(), r6.getY());
        this.g = false;
        return true;
    L11:
        if (r0 != 1) goto L13;
        float r7 = r6.getRawY() - this.d;
        if (this.g == false) goto L49;
        a r2 = this.a;
        if (r2 == null) goto L49;
        r2.c(r7);
    L49:
        this.e = null;
        this.f = false;
        this.g = false;
        return true;
    L13:
        if (r0 != 2) goto L15;
        float r3 = r6.getRawX() - this.c;
        float r4 = r6.getRawY() - this.d;
        if (Math.abs(r4) > Math.abs(r3)) goto L27;
    L43:
        return true;
    L27:
        if (Math.abs(r4) <= this.b) goto L43;
        if (this.g == true) goto L39;
        a r5 = this.a;
        if (r5 != null) goto L33;
    L35:
        this.g = r1;
        if (r1 == false) goto L39;
        this.c = r6.getRawX();
        this.d = r6.getRawY();
        goto L39
    L33:
        if (r5.onDragStart() != true) goto L35;
        r1 = true;
    L39:
        if (this.g == false) goto L43;
        a r8 = this.a;
        if (r8 == null) goto L43;
        r8.b(r6.getRawY() - this.d);
        goto L43
    L15:
        if (r0 != 3) goto L43;
        if (this.g == false) goto L22;
        a r9 = this.a;
        if (r9 == null) goto L22;
        r9.d();
    L22:
        this.e = null;
        this.f = false;
        this.g = false;
        return true;
    L5:
        if (r6.getActionMasked() == 0) goto L8;
        return super.onTouchEvent(r6);
    }

    public final void setGestureListener(a r1) {
        this.a = r1;
    }

    public final View a(float r5, float r6) {
        int r0 = getChildCount();
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L9;
        View r1 = getChildAt(r0);
        float r2 = r5 - r1.getLeft();
        float r3 = r6 - r1.getTop();
        Intrinsics.checkNotNull(r1);
        View r4 = b(r1, r2, r3);
        if (r4 == null) goto L3;
        return r4;
    L9:
        return null;
    }

    public MmAINotePanelGestureInterceptLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public static final View b(View r6, float r7, float r8) {
        if (r6.getVisibility() == 0) goto L6;
        return null;
    L6:
        if (r7 >= 0.0f) goto L8;
    L24:
        return null;
    L8:
        if (r8 < 0.0f) goto L24;
        if (r7 >= r6.getWidth()) goto L24;
        if (r8 >= r6.getHeight()) goto L24;
        if ((r6 instanceof ViewGroup) == true) goto L17;
        return r6;
    L17:
        ViewGroup r0 = (ViewGroup) r6;
        int r1 = r0.getChildCount() - 1;
    L18:
        if ((-1) >= r1) goto L23;
        View r3 = r0.getChildAt(r1);
        float r4 = r7 - r3.getLeft();
        float r5 = r8 - r3.getTop();
        Intrinsics.checkNotNull(r3);
        View r9 = b(r3, r4, r5);
        if (r9 != null) goto L21;
        r1 = r1 - 1;
        goto L18
    L21:
        return r9;
    L23:
        return r6;
    }

    public /* synthetic */ MmAINotePanelGestureInterceptLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
