package com.ss.android.lark.inline.ai.ui.richtext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.webkit.ValueCallback;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0002CDB)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020+H\u0002J\u0010\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0011H\u0002J\u0012\u0010/\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u000101H\u0017J\u0018\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u0011H\u0016J\u0010\u00105\u001a\u00020+2\u0006\u00104\u001a\u00020\u0011H\u0016J\u0010\u00106\u001a\u00020!2\u0006\u00104\u001a\u00020\u0011H\u0016JB\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010\u000e2\u0006\u00104\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u000eH\u0016J:\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010\u000e2\u0006\u00104\u001a\u00020\u0011H\u0016J4\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u00112\b\u0010=\u001a\u0004\u0018\u00010\u000e2\b\u0010<\u001a\u0004\u0018\u00010\u000e2\u0006\u00104\u001a\u00020\u0011H\u0016J\u0018\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020!2\u0006\u0010&\u001a\u00020!@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%¨\u0006E"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/richtext/NSCLarkWebView;", "Lcom/bytedance/ee/larkwebview/base/LarkWebView;", "Landroidx/core/view/NestedScrollingChild3;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "bizType", "Lcom/bytedance/ee/larkwebview/monitor/webview/BizType;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/bytedance/ee/larkwebview/monitor/webview/BizType;)V", "nscHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "mScrollConsumed", "", "mScrollOffset", "mLastMotionY", "", "mLastJsScrollY", "mJsClientHeight", "mJsScrollHeight", "mLastSuperY", "", "mLastForcedY", "Ljava/lang/Float;", "mVelocityTracker", "Landroid/view/VelocityTracker;", "mMinimumVelocity", "mMaximumVelocity", "mScroller", "Landroid/widget/OverScroller;", "mLastScrollerY", "isExecuteNestedPreFling", "", "isAnimate", "()Z", "setAnimate", "(Z)V", "value", "mEnable", "getMEnable", "setMEnable", "initVelocityTrackerIfNotExists", "", "recycleVelocityTracker", "fling", "velocityY", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "startNestedScroll", "axes", "type", "stopNestedScroll", "hasNestedScrollingParent", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "offsetInWindow", "consumed", "dispatchNestedPreScroll", "dx", "dy", "dispatchNestedPreFling", "velocityX", "Companion", "IEnableCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class NSCLarkWebView extends LarkWebView implements NestedScrollingChild3 {
    public final NestedScrollingChildHelper A;
    public final int[] B;
    public final int[] C;
    public int D;
    public int E;
    public int F;
    public int G;
    public float H;
    public Float I;
    public VelocityTracker J;
    public final int K;
    public final int L;
    public final OverScroller M;
    public boolean N;
    public boolean O;
    public boolean P;

    public static final class a {
    }

    public interface b {
        void setEnable(boolean r1);
    }

    public static final class c<T> implements ValueCallback {
        public final /* synthetic */ NSCLarkWebView a;

        public c(NSCLarkWebView r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r4) {
            String r5 = (String) r4;
            if (qyb.a.a(r5) == true) goto L5;
        L7:
            Log.d("NSCLarkWebView", "mLastJsScrollY: " + this.a.E + ", clientHeight: " + this.a.F + ", scrollHeight: " + this.a.G + "， result: " + r5);
            return;
        L5:
            if (Intrinsics.areEqual(r5, "null") == true) goto L7;
            JSONObject r0 = new JSONObject(r5);
            this.a.E = JSONObjectProtectorUtils.getInt(r0, "scrollTop");
            this.a.F = JSONObjectProtectorUtils.getInt(r0, "clientHeight");
            this.a.G = JSONObjectProtectorUtils.getInt(r0, "scrollHeight");
            goto L7
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ NSCLarkWebView a;

        public static final class a implements Runnable {
            public final /* synthetic */ NSCLarkWebView a;

            public a(NSCLarkWebView r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.setAnimate(true);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public d(NSCLarkWebView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.animate().translationYBy(10.0f).setDuration(100).withEndAction(new a(this.a)).start();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public NSCLarkWebView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 6);
    }

    public NSCLarkWebView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 4);
    }

    public final boolean getMEnable() {
        return this.P;
    }

    public final boolean hasNestedScrollingParent(int r2) {
        return this.A.hasNestedScrollingParent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r25) {
        if (this.P == false) goto L84;
        if (isNestedScrollingEnabled() == false) goto L84;
        if (r25 != null) goto L11;
        return false;
    L11:
        if (this.J != null) goto L13;
        this.J = VelocityTracker.obtain();
    L13:
        MotionEvent r8 = MotionEvent.obtain(r25);
        int r0 = r25.getAction();
        if (r0 != 0) goto L16;
        this.N = true;
        this.D = (int) r25.getRawY();
        this.H = r25.getY();
        this.I = null;
        startNestedScroll(2, 0);
        VelocityTracker r1 = this.J;
        if (r1 == null) goto L78;
        r1.addMovement(r8);
    L78:
        this.M.computeScrollOffset();
        if (this.M.isFinished() == true) goto L82;
        this.M.abortAnimation();
    L82:
        return super.onTouchEvent(r8);
    L16:
        if (r0 == 1) goto L57;
        if (r0 != 2) goto L19;
        int r13 = (int) r25.getRawY();
        int r14 = this.D - r13;
        if (dispatchNestedPreScroll(0, r14, this.B, this.C, 0) == false) goto L27;
        int r2 = this.B[1];
        r14 = r14 - r2;
        r8.offsetLocation(0.0f, r2);
    L27:
        this.D = r13;
        evaluateJavascript("(function() { var div = document.querySelector('.preview-wrapper'); return { scrollTop: div.scrollTop, clientHeight: div.clientHeight, scrollHeight: div.scrollHeight }; })();", new c(this));
        if (this.O == false) goto L33;
        int r3 = this.E + this.F;
        int r4 = this.G;
        if (r3 < (r4 - 1)) goto L33;
        if (r4 <= 0) goto L33;
        this.O = false;
        animate().translationYBy(-10.0f).setDuration(100).withEndAction(new d(this)).start();
    L33:
        int r5 = this.E;
        if (r5 == 0) goto L36;
        this.N = false;
    L37:
        if (r5 != 0) goto L39;
        int r6 = r14;
    L43:
        Log.d("NSCLarkWebView", "y: " + r25.getY() + ", parent consumed = " + this.B[1] + ", deltaY = " + r14 + ", scrollY = " + r5 + ", dyUnconsumed = " + r6 + " mLastJsScrollY = " + this.E);
        VelocityTracker r7 = this.J;
        if (r7 == null) goto L46;
        r7.addMovement(r8);
    L46:
        if (r5 != 0) goto L48;
        if (r14 >= 0) goto L48;
    L49:
        Log.d("NSCLarkWebView", "call super, compat before y = " + r8.getY() + ", mLastForcedY = " + this.I + ", mLastSuperY = " + this.H);
        Float r9 = this.I;
        if (r9 == null) goto L52;
        float r10 = r9.floatValue();
    L53:
        r8.setLocation(r8.getX(), r10);
        this.I = Float.valueOf(r10);
        Log.d("NSCLarkWebView", "call super, compat after y = " + r8.getY());
        super.onTouchEvent(r8);
        boolean r11 = false;
    L55:
        this.H = r8.getY();
        dispatchNestedScroll(0, r14 - r6, 0, r6, this.C, 0);
        return r11;
    L52:
        r10 = this.H;
    L48:
        if (r14 == 0) goto L49;
        this.I = null;
        Log.d("NSCLarkWebView", "call super, y = " + r8.getY());
        r11 = super.onTouchEvent(r8);
        goto L55
    L39:
        int r12 = r5 + r14;
        if (r12 >= 0) goto L42;
        r8.offsetLocation(0.0f, -r12);
        r6 = r12;
        goto L43
    L42:
        r6 = 0;
        goto L43
    L36:
        r5 = getScrollY();
        goto L37
    L19:
        if (r0 != 3) goto L82;
        stopNestedScroll(0);
        VelocityTracker r15 = this.J;
        if (r15 == null) goto L82;
        r15.recycle();
        this.J = null;
        goto L82
    L57:
        VelocityTracker r16 = this.J;
        if (r16 != null) goto L60;
        return false;
    L60:
        r16.computeCurrentVelocity(AudioViewModel.ASR_SESSION_IDLE, this.L);
        float r17 = r16.getYVelocity();
        if (Math.abs(r17) <= this.K) goto L74;
        int r18 = -((int) r17);
        int r19 = this.E;
        if (r19 != 0) goto L66;
        r19 = getScrollY();
    L66:
        int r110 = r19;
        Log.d("NSCLarkWebView", "mLastJsScrollY: " + this.E + ", isExecute: " + this.N);
        if (this.E != 0) goto L74;
        if (this.N == false) goto L74;
        if (dispatchNestedPreFling(0.0f, r18) == true) goto L74;
        startNestedScroll(2, 1);
        this.M.fling(getScrollX(), r110, 0, r18, 0, 0, Target.SIZE_ORIGINAL, Integer.MAX_VALUE, 0, 0);
        ViewCompat.postInvalidateOnAnimation(this);
    L74:
        stopNestedScroll(0);
    L84:
        return super.onTouchEvent(r25);
    }

    public final void setAnimate(boolean r1) {
        this.O = r1;
    }

    public final void setMEnable(boolean r2) {
        if (r2 == true) goto L4;
        stopNestedScroll(0);
    L4:
        this.P = r2;
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
    public NSCLarkWebView(Context r2, AttributeSet r3, gt5.d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        NestedScrollingChildHelper r5 = new NestedScrollingChildHelper(this);
        this.A = r5;
        this.B = new int[2];
        this.C = new int[2];
        this.M = new OverScroller(r2);
        this.N = true;
        this.O = true;
        this.P = true;
        setMEnable(true);
        ViewConfiguration r6 = ViewConfiguration.get(getContext());
        this.K = r6.getScaledMinimumFlingVelocity();
        this.L = r6.getScaledMaximumFlingVelocity();
        setNestedScrollingEnabled(true);
        r5.setNestedScrollingEnabled(true);
    }

    public NSCLarkWebView(Context r3, AttributeSet r4, int r5) {
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
