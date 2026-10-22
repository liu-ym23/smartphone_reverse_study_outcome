package com.ss.android.lark.chat.message.menu.v2;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 G2\u00020\u0001:\u0001GB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0010\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fJ\u0012\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00103\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0002J\u0017\u00104\u001a\u0004\u0018\u00010\u00122\u0006\u00100\u001a\u000201H\u0002¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\u00122\u0006\u00100\u001a\u000201H\u0002J \u00107\u001a\u00020\u00122\u0006\u00108\u001a\u0002092\u0006\u00100\u001a\u0002012\u0006\u0010:\u001a\u00020\u000fH\u0002J\u0010\u0010;\u001a\u00020\u00122\u0006\u00108\u001a\u000209H\u0002J\b\u0010<\u001a\u00020\u0012H\u0002J&\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f0>2\u0006\u0010?\u001a\u00020@2\u0006\u00100\u001a\u000201H\u0002J\u0010\u0010A\u001a\u00020\u00122\u0006\u0010-\u001a\u000201H\u0016J\u0012\u0010B\u001a\u00020%2\b\b\u0002\u0010C\u001a\u00020\u0012H\u0002J\u0018\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010-\u001a\u000201H\u0002J \u0010F\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u000f2\u0006\u00100\u001a\u0002012\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010#¨\u0006H"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/MessageActionPanelContainerLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startY", BuildConfig.FLAVOR, "dependency", "Lcom/ss/android/lark/chat/message/menu/v2/PanelDependency;", "parentOtherChild", "Landroid/view/View;", "touchSlop", "resetCancelNextUpFlagFixDisabled", BuildConfig.FLAVOR, "getResetCancelNextUpFlagFixDisabled", "()Z", "resetCancelNextUpFlagFixDisabled$delegate", "Lkotlin/Lazy;", "childOnlyConsumeDownAction", "consumeTouchDownChildView", "parentConsumeDownAction", "ignoreNextTouchUpClose", "childLocation", BuildConfig.FLAVOR, "parentLocation", "touchBoundsTargetMap", BuildConfig.FLAVOR, "allowPassThroughTouch", "getAllowPassThroughTouch", "setAllowPassThroughTouch", "(Z)V", "setPanelDependency", BuildConfig.FLAVOR, "closePanelImmediately", "setParentOtherChildView", "view", "setTouchBoundsTarget", "containerView", "actualTouchView", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchCancelEventToParentOtherChildCompat", "dispatchCancelEventToParentOtherChild", "safeDispatchTouchEventToParentOtherChild", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "safeSuperDispatchTouchEvent", "handleResetCancelNextUpFlagException", "t", BuildConfig.FLAVOR, "target", "isResetCancelNextUpFlagException", "isResetCancelNextUpFlagFixDisabled", "isTouchChildArea", "Lkotlin/Pair;", "viewGroup", "Landroid/view/ViewGroup;", "onTouchEvent", "resetTouchState", "resetIgnoreNextTouchUpClose", "dispatchTouchEventToChild", "childView", "isLocationInView", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageActionPanelContainerLayout extends ConstraintLayout {
    public float a;
    public k0 b;
    public View c;
    public final int d;
    public final Lazy e;
    public boolean f;
    public View g;
    public boolean h;
    public boolean i;
    public final int[] j;
    public final int[] k;
    public final Map<View, View> l;
    public boolean m;

    public static final class a {
    }

    static {
    }

    public MessageActionPanelContainerLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MessageActionPanelContainerLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final boolean getResetCancelNextUpFlagFixDisabled() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public final boolean getAllowPassThroughTouch() {
        return this.m;
    }

    public final void T5(boolean r3) {
        this.f = false;
        this.g = null;
        this.h = false;
        if (r3 == false) goto L6;
        this.i = false;
        return;
    }

    public final Boolean U5(MotionEvent r3) {
        View r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        if (getResetCancelNextUpFlagFixDisabled() == true) goto L9;
        return Boolean.valueOf(R5(r0, r3));
    L12:
        th = move-exception;
        S5(th, r3, r0);
        return Boolean.FALSE;
    L9:
        return Boolean.valueOf(R5(r0, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean V5(MotionEvent r2) {
        if (getResetCancelNextUpFlagFixDisabled() == true) goto L5;
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r2);
    L8:
        th = move-exception;
        S5(th, r2, this);
        return false;
    L5:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchKeyEvent(KeyEvent r5) {
        boolean r1 = false;
        if (r5 != null) goto L5;
    L7:
        if (r1 == false) goto L13;
        k0 r6 = this.b;
        if (r6 == null) goto L11;
        r6.a();
    L11:
        return true;
    L13:
        return super/*android.view.ViewGroup*/.dispatchKeyEvent(r5);
    L5:
        if (r5.getKeyCode() != 4) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r15) {
        Intrinsics.checkNotNullParameter(r15, "ev");
        if (this.i == false) goto L8;
        if (r15.getActionMasked() != 0) goto L8;
        this.i = false;
    L8:
        if (this.i == true) goto L10;
    L20:
        getLocationInWindow(this.k);
        int r0 = getChildCount();
        int r4 = 0;
    L21:
        if (r4 >= r0) goto L32;
        View r5 = getChildAt(r4);
        if (r5 == null) goto L31;
        View r6 = (View) ((LinkedHashMap) this.l).get(r5);
        if (r6 != null) goto L28;
        r6 = r5;
    L28:
        int[] r7 = this.k;
        r6.getLocationInWindow(this.j);
        float r8 = r15.getX() + r7[0];
        float r9 = r15.getY() + r7[1];
        int[] r10 = this.j;
        int r11 = r10[0];
        if (new RectF(r11, r10[1], r11 + r6.getWidth(), this.j[1] + r6.getHeight()).contains(r8, r9) == false) goto L31;
        Pair r1 = TuplesKt.to(Boolean.TRUE, r5);
    L33:
        Log.d("MessageActionPanelContainerLayout", "dispatchTouchEvent, ev = " + r15.getActionMasked() + ", parentConsumeDownAction = " + this.h + " isTouchChildArea = " + ((Boolean) r1.getFirst()).booleanValue());
        if (this.h == true) goto L47;
        if (((Boolean) r1.getFirst()).booleanValue() == false) goto L47;
        int r12 = r15.getActionMasked();
        if (r12 == 0) goto L43;
        if (r12 == 1) goto L42;
        if (r12 == 3) goto L42;
    L45:
        return V5(r15);
    L42:
        T5(false);
        goto L45
    L43:
        this.f = true;
        this.g = (View) r1.getSecond();
    L47:
        if (((Boolean) r1.getFirst()).booleanValue() == true) goto L60;
        if (this.f == false) goto L60;
        if (r15.getActionMasked() == 0) goto L60;
        if (r15.getActionMasked() != 1) goto L55;
    L56:
        T5(false);
    L58:
        return V5(r15);
    L55:
        if (r15.getActionMasked() != 3) goto L58;
    L60:
        if (this.m == false) goto L62;
        int r2 = r15.getActionMasked();
        if (r2 == 0) goto L86;
        if (r2 == 1) goto L70;
        if (r2 != 3) goto L87;
        T5(false);
    L87:
        Boolean r3 = U5(r15);
        if (r3 == null) goto L91;
        return r3.booleanValue();
    L91:
        return V5(r15);
    L70:
        if (Math.abs(r15.getRawY() - this.a) < this.d) goto L72;
        T5(false);
        goto L87
    L72:
        if (getResetCancelNextUpFlagFixDisabled() == false) goto L77;
        r15.setAction(3);
        View r13 = this.c;
        if (r13 == null) goto L76;
        R5(r13, r15);
    L76:
        r15.setAction(1);
    L80:
        T5(false);
        return V5(r15);
    L77:
        MotionEvent r14 = MotionEvent.obtain(r15);
        r14.setAction(3);
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L82
        U5(r14);     // Catch: Throwable -> L82
        r14.recycle();
    L82:
        th = move-exception;
        r14.recycle();
        throw th;
    L86:
        this.a = r15.getRawY();
        this.h = true;
        goto L87
    L62:
        return V5(r15);
    L31:
        r4 = r4 + 1;
        goto L21
    L32:
        r1 = TuplesKt.to(Boolean.FALSE, null);
        goto L33
    L10:
        if (r15.getActionMasked() != 1) goto L12;
    L13:
        View r16 = this.g;
        if (r16 != null) goto L16;
        r16 = this.c;
    L16:
        if (r16 == null) goto L18;
        R5(r16, r15);
    L18:
        T5(true);
        return true;
    L12:
        if (r15.getActionMasked() != 3) goto L20;
        goto L13
    }

    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        StringBuilder r0 = new StringBuilder("onTouchEvent, action = ");
        r0.append(r5.getActionMasked());
        r0.append(", childConsumeTouchDown = ");
        r0.append(this.f);
        r0.append(", childView is null = ");
        if (this.g != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        Log.d("MessageActionPanelContainerLayout", r0.toString());
        if (this.i == false) goto L15;
        if (r5.getActionMasked() != 1) goto L11;
    L12:
        T5(true);
        return true;
    L11:
        if (r5.getActionMasked() == 3) goto L12;
    L15:
        if (this.f == false) goto L25;
        View r2 = this.g;
        if (r2 == null) goto L20;
        R5(r2, r5);
    L20:
        if (r5.getActionMasked() != 3) goto L22;
    L23:
        T5(false);
    L24:
        return true;
    L22:
        if (r5.getActionMasked() != 1) goto L24;
    L25:
        k0 r6 = this.b;
        if (r6 == null) goto L28;
        r6.a();
    L28:
        return true;
    L5:
        r1 = false;
        goto L6
    }

    public final void setAllowPassThroughTouch(boolean r1) {
        this.m = r1;
    }

    public final void setPanelDependency(k0 r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.b = r2;
    }

    public final void setParentOtherChildView(View r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean R5(View r5, MotionEvent r6) {
        getLocationInWindow(this.k);
        r5.getLocationInWindow(this.j);
        int[] r0 = this.k;
        int r2 = r0[0];
        int[] r3 = this.j;
        float r1 = r2 - r3[0];
        float r4 = r0[1] - r3[1];
        r6.offsetLocation(r1, r4);
        boolean r7 = r5.dispatchTouchEvent(r6);     // Catch: Throwable -> L6
        r6.offsetLocation(-r1, -r4);
        return r7;
    L6:
        th = move-exception;
        r6.offsetLocation(-r1, -r4);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageActionPanelContainerLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.e = LazyKt.lazy(MessageActionPanelContainerLayout$resetCancelNextUpFlagFixDisabled$2.INSTANCE);
        this.j = new int[2];
        this.k = new int[2];
        this.l = new LinkedHashMap();
        this.m = true;
        setFocusableInTouchMode(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Throwable r9, MotionEvent r10, View r11) {
        boolean r1 = false;
        if ((r9 instanceof NullPointerException) == false) goto L18;
        StackTraceElement[] r0 = ((NullPointerException) r9).getStackTrace();
        int r3 = r0.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L15;
        StackTraceElement r5 = r0[r4];
        if (Intrinsics.areEqual(r5.getClassName(), "android.view.ViewGroup") == true) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == true) goto L13;
        r4 = r4 + 1;
        goto L5
    L13:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L25;
        StringBuilder r8 = new StringBuilder("ignore resetCancelNextUpFlag npe, action=");
        r8.append(r10.getActionMasked());
        r8.append(", target=");
        r8.append(r11.getClass().getSimpleName());
        r8.append(", targetAttached=");
        r8.append(r11.isAttachedToWindow());
        r8.append(", panelAttached=");
        r8.append(isAttachedToWindow());
        r8.append(", childCount=");
        r8.append(getChildCount());
        r8.append(", parentOtherChildNull=");
        if (this.c != null) goto L23;
        r1 = true;
    L23:
        r8.append(r1);
        Log.e("MessageActionPanelContainerLayout", r8.toString(), r9, true);
        return;
    L25:
        throw r9;
    L9:
        if (Intrinsics.areEqual(r5.getMethodName(), "resetCancelNextUpFlag") == false) goto L11;
        r6 = true;
        goto L12
    L15:
        r2 = false;
    L18:
        r7 = false;
        goto L19
    }

    public /* synthetic */ MessageActionPanelContainerLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
