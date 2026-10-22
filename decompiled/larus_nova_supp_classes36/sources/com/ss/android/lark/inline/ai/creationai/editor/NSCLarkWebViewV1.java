package com.ss.android.lark.inline.ai.creationai.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0002?@B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0011H\u0002J\u0012\u0010+\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0017J\u0018\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00101\u001a\u00020'2\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00102\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0011H\u0016JB\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u000eH\u0016J:\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020\u0011H\u0016J4\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010\u000e2\b\u00108\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020\u0011H\u0016J\u0018\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006A"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/editor/NSCLarkWebViewV1;", "Lcom/bytedance/ee/larkwebview/base/LarkWebView;", "Landroidx/core/view/NestedScrollingChild3;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "bizType", "Lcom/bytedance/ee/larkwebview/monitor/webview/BizType;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/bytedance/ee/larkwebview/monitor/webview/BizType;)V", "nscCreationAIHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "mScrollConsumed", "", "mScrollOffset", "mLastMotionY", "", "mLastJsScrollY", "mLastSuperY", "", "mLastForcedY", "Ljava/lang/Float;", "mVelocityTracker", "Landroid/view/VelocityTracker;", "mMinimumVelocity", "mMaximumVelocity", "mScroller", "Landroid/widget/OverScroller;", "mLastScrollerY", "isExecuteNestedPreFling", "", "value", "mEnable", "getMEnable", "()Z", "setMEnable", "(Z)V", "initVelocityTrackerIfNotExists", "", "recycleVelocityTracker", "fling", "velocityY", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "startNestedScroll", "axes", "type", "stopNestedScroll", "hasNestedScrollingParent", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "offsetInWindow", "consumed", "dispatchNestedPreScroll", "dx", "dy", "dispatchNestedPreFling", "velocityX", "Companion", "IEnableCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class NSCLarkWebViewV1 extends LarkWebView implements NestedScrollingChild3 {
    public final NestedScrollingChildHelper A;
    public final int[] B;
    public final int[] C;
    public int D;
    public float E;
    public Float F;
    public VelocityTracker G;
    public final int H;
    public final int I;
    public final OverScroller J;
    public boolean K;
    public boolean L;

    public static final class a {
    }

    static {
    }

    public NSCLarkWebViewV1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 6);
    }

    public NSCLarkWebViewV1(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 4);
    }

    public final boolean getMEnable() {
        return this.L;
    }

    public final boolean hasNestedScrollingParent(int r2) {
        return this.A.hasNestedScrollingParent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r25) {
        if (this.L == false) goto L69;
        if (isNestedScrollingEnabled() == false) goto L69;
        if (r25 != null) goto L11;
        return false;
    L11:
        if (this.G != null) goto L13;
        this.G = VelocityTracker.obtain();
    L13:
        MotionEvent r8 = MotionEvent.obtain(r25);
        int r0 = r25.getAction();
        if (r0 != 0) goto L16;
        this.K = true;
        this.D = (int) r25.getRawY();
        this.E = r25.getY();
        this.F = null;
        startNestedScroll(2, 0);
        VelocityTracker r1 = this.G;
        if (r1 == null) goto L63;
        r1.addMovement(r8);
    L63:
        this.J.computeScrollOffset();
        if (this.J.isFinished() == true) goto L67;
        this.J.abortAnimation();
    L67:
        return super.onTouchEvent(r8);
    L16:
        if (r0 == 1) goto L48;
        if (r0 != 2) goto L19;
        int r13 = (int) r25.getRawY();
        int r14 = this.D - r13;
        if (dispatchNestedPreScroll(0, r14, this.B, this.C, 0) == false) goto L27;
        int r2 = this.B[1];
        r14 = r14 - r2;
        r8.offsetLocation(0.0f, r2);
    L27:
        this.D = r13;
        int r3 = getScrollY();
        if (r3 != 0) goto L30;
        int r4 = r14;
    L34:
        Log.d("NSCCIWebViewV1", "y: " + r25.getY() + ", parent consumed = " + this.B[1] + ", deltaY = " + r14 + ", scrollY = " + r3 + ", dyUnconsumed = " + r4 + " mLastJsScrollY = 0");
        VelocityTracker r5 = this.G;
        if (r5 == null) goto L37;
        r5.addMovement(r8);
    L37:
        if (r3 != 0) goto L39;
        if (r14 >= 0) goto L39;
    L40:
        Log.d("NSCCIWebViewV1", "call super, compat before y = " + r8.getY() + ", mLastForcedY = " + this.F + ", mLastSuperY = " + this.E);
        Float r6 = this.F;
        if (r6 == null) goto L43;
        float r7 = r6.floatValue();
    L44:
        r8.setLocation(r8.getX(), r7);
        this.F = Float.valueOf(r7);
        Log.d("NSCCIWebViewV1", "call super, compat after y = " + r8.getY());
        super.onTouchEvent(r8);
        boolean r9 = false;
    L46:
        this.E = r8.getY();
        dispatchNestedScroll(0, r14 - r4, 0, r4, this.C, 0);
        return r9;
    L43:
        r7 = this.E;
    L39:
        if (r14 == 0) goto L40;
        this.F = null;
        Log.d("NSCCIWebViewV1", "call super, y = " + r8.getY());
        r9 = super.onTouchEvent(r8);
        goto L46
    L30:
        int r10 = r3 + r14;
        if (r10 >= 0) goto L33;
        r8.offsetLocation(0.0f, -r10);
        r4 = r10;
        goto L34
    L33:
        r4 = 0;
        goto L34
    L19:
        if (r0 != 3) goto L67;
        stopNestedScroll(0);
        VelocityTracker r11 = this.G;
        if (r11 == null) goto L67;
        r11.recycle();
        this.G = null;
        goto L67
    L48:
        VelocityTracker r12 = this.G;
        if (r12 != null) goto L51;
        return false;
    L51:
        r12.computeCurrentVelocity(AudioViewModel.ASR_SESSION_IDLE, this.I);
        float r15 = r12.getYVelocity();
        if (Math.abs(r15) <= this.H) goto L59;
        int r16 = -((int) r15);
        int r17 = getScrollY();
        Log.d("NSCCIWebViewV1", "mLastJsScrollY: 0, isExecute: " + this.K);
        if (this.K == false) goto L59;
        if (dispatchNestedPreFling(0.0f, r16) == true) goto L59;
        startNestedScroll(2, 1);
        this.J.fling(getScrollX(), r17, 0, r16, 0, 0, Target.SIZE_ORIGINAL, Integer.MAX_VALUE, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
    L59:
        stopNestedScroll(0);
    L69:
        return super.onTouchEvent(r25);
    }

    public final void setMEnable(boolean r2) {
        if (r2 == true) goto L4;
        stopNestedScroll(0);
    L4:
        this.L = r2;
    }

    public void stopNestedScroll(int r2) {
        this.A.stopNestedScroll(r2);
    }

    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return this.A.dispatchNestedPreFling(r2, r3);
    }

    public boolean startNestedScroll(int r2, int r3) {
        return this.A.startNestedScroll(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NSCLarkWebViewV1(Context r2, AttributeSet r3, gt5.d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        NestedScrollingChildHelper r5 = new NestedScrollingChildHelper(this);
        this.A = r5;
        this.B = new int[2];
        this.C = new int[2];
        this.J = new OverScroller(r2);
        this.K = true;
        this.L = true;
        setMEnable(true);
        ViewConfiguration r6 = ViewConfiguration.get(getContext());
        this.H = r6.getScaledMinimumFlingVelocity();
        this.I = r6.getScaledMaximumFlingVelocity();
        setNestedScrollingEnabled(true);
        r5.setNestedScrollingEnabled(true);
    }

    public NSCLarkWebViewV1(Context r3, AttributeSet r4, int r5) {
        gt5.d r1 = null;
        if ((r5 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r1 = gt5.d.e;
    L8:
        this(r3, r4, r1);
    }

    public final boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.A.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    public final boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.A.dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    public final void dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15, int[] r16) {
        Intrinsics.checkNotNullParameter(r16, "consumed");
        this.A.dispatchNestedScroll(r10, r11, r12, r13, r14, r15, r16);
    }
}
