package com.bytedance.ai.applet.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J!\u0010\u001b\u001a\u00020\f*\u00020\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u001dH\u0082\bJ8\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010H\u0016R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ai/applet/app/view/AppletDragHandleBottomSheetBehavior;", "Lcom/bytedance/ai/view/popup/anim/BottomSheetBehavior;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dragRegionViewRef", "Ljava/lang/ref/WeakReference;", "touchStartedInDragRegion", "", "touchEventOffsetY", "", "gestureStartSheetTop", "", "setDragRegionView", "", "view", "onInterceptTouchEvent", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "offsetForBottomSheet", "block", "Lkotlin/Function1;", "onStartNestedScroll", "coordinatorLayout", "directTargetChild", "target", "axes", "type", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDragHandleBottomSheetBehavior extends BottomSheetBehavior<View> {
    public WeakReference<View> W;
    public boolean X;
    public float Y;
    public int Z;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior
    public final boolean onStartNestedScroll(CoordinatorLayout r1, View r10, View r11, View r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r1, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r10, "child");
        Intrinsics.checkNotNullParameter(r11, "directTargetChild");
        Intrinsics.checkNotNullParameter(r12, "target");
        return false;
    }

    public AppletDragHandleBottomSheetBehavior(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
    }

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r10, View r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "event");
        if (r12.getActionMasked() != 0) goto L19;
        WeakReference<View> r0 = this.W;
        if (r0 == null) goto L7;
        View r1 = r0.get();
    L8:
        if (r1 != null) goto L10;
    L12:
        boolean r13 = false;
    L13:
        this.X = r13;
        if (r13 == false) goto L16;
        this.Z = r11.getTop();
        float r14 = (r11.getTop() - r12.getY()) + 1.0f;
    L17:
        this.Y = r14;
        goto L19
    L16:
        r14 = 0.0f;
        goto L17
    L10:
        if (r10.isPointInChildBounds(r1, (int) r12.getX(), (int) r12.getY()) == false) goto L12;
        r13 = true;
        goto L13
    L7:
        r1 = null;
    L19:
        if (this.X == true) goto L21;
        return false;
    L21:
        MotionEvent r15 = MotionEvent.obtain(r12);
        r15.offsetLocation(0.0f, this.Y);
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L29
        boolean r16 = super.onInterceptTouchEvent(r10, r11, r15);     // Catch: Throwable -> L29
        r15.recycle();
        if (r12.getActionMasked() != 1) goto L26;
    L27:
        this.X = false;
        this.Y = 0.0f;
    L28:
        return r16;
    L26:
        if (r12.getActionMasked() != 3) goto L28;
    L29:
        th = move-exception;
        r15.recycle();
        throw th;
    }

    @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior
    public final boolean onTouchEvent(CoordinatorLayout r10, View r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "event");
        if (this.X == true) goto L5;
        return false;
    L5:
        int r0 = r12.getActionMasked();
        int r13 = 3;
        if (r0 == 1) goto L10;
        if (r0 == 3) goto L9;
        Integer r1 = null;
    L18:
        MotionEvent r14 = MotionEvent.obtain(r12);
        r14.offsetLocation(0.0f, this.Y);
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L24
        boolean r15 = super.onTouchEvent(r10, r11, r14);     // Catch: Throwable -> L24
        r14.recycle();
        if (r1 == null) goto L23;
        b(r1.intValue(), true);
        this.X = false;
        this.Y = 0.0f;
    L23:
        return r15;
    L24:
        th = move-exception;
        r14.recycle();
        throw th;
    L9:
        r1 = 3;
        goto L18
    L10:
        int r16 = r11.getTop() - this.Z;
        if (r16 < this.A) goto L13;
        boolean r17 = true;
    L14:
        com.bytedance.ai.utils.g.a.i("AppletDragBehavior", "gesture released: dragDistance=" + r16 + ", closeThreshold=" + this.A + ", dismiss=" + r17);
        if (r17 == false) goto L17;
        r13 = 5;
    L17:
        r1 = Integer.valueOf(r13);
        goto L18
    L13:
        r17 = false;
        goto L14
    }
}
