package com.larus.chat.job.impl.page.edit;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001f\u001a\u00020\fH\u0014J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010$\u001a\u00020\fJ\b\u0010%\u001a\u00020\fH\u0002J\b\u0010&\u001a\u00020\u0012H\u0002J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\fH\u0002J\u0018\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0012H\u0002J\u0018\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u0012H\u0002J\u0010\u00102\u001a\u00020+2\u0006\u00100\u001a\u00020\u0012H\u0002J\n\u00103\u001a\u0004\u0018\u000104H\u0002J\u001a\u00105\u001a\u0004\u0018\u00010\u001e2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\"\u00108\u001a\u0004\u0018\u00010\u001e2\u0006\u00109\u001a\u0002042\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/chat/job/impl/page/edit/ChatJobDragDismissLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDragDismiss", "Lkotlin/Function0;", "", "getOnDragDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnDragDismiss", "(Lkotlin/jvm/functions/Function0;)V", "density", "", "touchSlop", "downX", "downY", "dragging", "", "dismissing", "scrimAnimator", "Landroid/animation/ValueAnimator;", "velocityTracker", "Landroid/view/VelocityTracker;", "touchedScrollableEditText", "Landroid/widget/EditText;", "onFinishInflate", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "cancelChildTouch", "resetDrag", "settleDrag", "currentYVelocity", "recycleVelocityTracker", "resetScrim", "fadeOutScrim", "duration", "", "interpolator", "Landroid/view/animation/AccelerateInterpolator;", "dismissThreshold", "dismissDuration", "currentTranslation", "yVelocity", "resetDuration", "activeDragTarget", "Landroid/view/View;", "findScrollableEditText", "rawX", "rawY", "findScrollableEditTextUnder", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatJobDragDismissLayout extends ConstraintLayout {
    public static final /* synthetic */ int k = 0;
    public Function0<Unit> a;
    public final float b;
    public final int c;
    public float d;
    public float e;
    public boolean f;
    public boolean g;
    public ValueAnimator h;
    public VelocityTracker i;
    public EditText j;

    public static final class a {
    }

    static {
    }

    public ChatJobDragDismissLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatJobDragDismissLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static /* synthetic */ void R5(ChatJobDragDismissLayout r0) {
        settleDrag$lambda$2(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float T5() {
        return Math.max(this.c * 4.0f, Math.min(getHeight() * 0.18f, this.b * 160.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5() {
        ValueAnimator r0 = this.h;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.h = null;
        Drawable r1 = getBackground();
        if (r1 == null) goto L9;
        r1.setAlpha(255);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View S5() {
        int r0 = getChildCount();
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L9;
        View r1 = getChildAt(r0);
        if (r1.getVisibility() != 0) goto L3;
        return r1;
    L9:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5() {
        View r0 = S5();
        if (r0 == null) goto L7;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L7;
        r1.cancel();
    L7:
        View r2 = S5();
        if (r2 == null) goto L10;
        r2.setTranslationY(0.0f);
    L10:
        Y5();
        this.f = false;
        this.g = false;
        this.j = null;
        VelocityTracker r3 = this.i;
        if (r3 == null) goto L13;
        r3.recycle();
    L13:
        this.i = null;
        ViewParent r4 = getParent();
        if (r4 == null) goto L17;
        r4.requestDisallowInterceptTouchEvent(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        Drawable r0 = getBackground();
        if (r0 == null) goto L7;
        Drawable r1 = r0.mutate();
        if (r1 == null) goto L7;
        setBackground(r1);
    L7:
        Y5();
    }

    public final Function0<Unit> getOnDragDismiss() {
        return this.a;
    }

    private static final void settleDrag$lambda$2(ChatJobDragDismissLayout r1) {
        r1.g = false;
        Function0<Unit> r2 = r1.a;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        if (this.g == false) goto L5;
        return true;
    L5:
        int r0 = r12.getActionMasked();
        boolean r2 = false;
        if (r0 != 0) goto L8;
        View r1 = S5();
        if (r1 == null) goto L98;
        ViewPropertyAnimator r3 = r1.animate();
        if (r3 == null) goto L98;
        r3.cancel();
    L98:
        Y5();
        this.d = r12.getRawX();
        this.e = r12.getRawY();
        this.f = false;
        this.j = U5(this, (int) r12.getRawX(), (int) r12.getRawY());
        VelocityTracker r4 = this.i;
        if (r4 == null) goto L101;
        r4.recycle();
    L101:
        VelocityTracker r5 = VelocityTracker.obtain();
        this.i = r5;
        if (r5 == null) goto L105;
        r5.addMovement(r12);
    L105:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r12);
    L8:
        if (r0 == 1) goto L50;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L105;
        V5();
        goto L105
    L15:
        if (this.g == false) goto L17;
        return true;
    L17:
        VelocityTracker r6 = this.i;
        if (r6 == null) goto L20;
        r6.addMovement(r12);
    L20:
        float r7 = r12.getRawX() - this.d;
        float r8 = r12.getRawY() - this.e;
        if (this.f == true) goto L35;
        EditText r9 = this.j;
        int r10 = this.c;
        if (r9 == null) goto L31;
        float r11 = r10;
        if (r8 >= (-r11)) goto L29;
        r2 = r9.canScrollVertically(1);
        goto L31
    L29:
        if (r8 <= r11) goto L31;
        r2 = r9.canScrollVertically(-1);
    L31:
        if (r2 == false) goto L35;
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r12);
    L35:
        if (this.f == true) goto L44;
        if (r8 <= this.c) goto L44;
        if (r8 <= Math.abs(r7)) goto L44;
        this.f = true;
        MotionEvent r13 = MotionEvent.obtain(r12);
        r13.setAction(3);
        super/*android.view.ViewGroup*/.dispatchTouchEvent(r13);
        r13.recycle();
        ViewParent r14 = getParent();
        if (r14 == null) goto L44;
        r14.requestDisallowInterceptTouchEvent(true);
    L44:
        if (this.f == false) goto L105;
        View r15 = S5();
        if (r15 == null) goto L48;
        r15.setTranslationY(Math.max(0.0f, r8));
    L48:
        return true;
    L50:
        if (this.f == false) goto L86;
        View r16 = S5();
        if (r16 != null) goto L54;
        V5();
    L85:
        return true;
    L54:
        VelocityTracker r17 = this.i;
        if (r17 != null) goto L57;
        float r18 = 0.0f;
    L58:
        this.f = false;
        VelocityTracker r19 = this.i;
        if (r19 == null) goto L61;
        r19.recycle();
    L61:
        this.i = null;
        ViewParent r20 = getParent();
        if (r20 == null) goto L64;
        r20.requestDisallowInterceptTouchEvent(false);
    L64:
        long r21 = 120;
        if (r16.getTranslationY() < T5()) goto L67;
    L70:
        this.g = true;
        float r22 = r16.getTranslationY();
        if (r18 > 1600.0f) goto L74;
        r21 = (long) (140 + (80 * (1.0f - RangesKt.coerceIn(r22 / RangesKt.coerceAtLeast(getHeight(), 1), 0.0f, 1.0f))));
    L74:
        AccelerateInterpolator r23 = new AccelerateInterpolator();
        if (r16.getId() != 2131377188) goto L84;
        ValueAnimator r24 = this.h;
        if (r24 == null) goto L79;
        r24.cancel();
    L79:
        int[] r25 = new int[2];
        Drawable r26 = getBackground();
        if (r26 == null) goto L82;
        int r27 = r26.getAlpha();
    L83:
        r25[0] = r27;
        r25[1] = 0;
        ValueAnimator r28 = ValueAnimator.ofInt(r25);
        r28.setDuration(r21);
        r28.setInterpolator(r23);
        r28.addUpdateListener(new d(this));
        r28.start();
        this.h = r28;
        goto L84
    L82:
        r27 = 255;
    L84:
        r16.animate().translationY(getHeight()).setDuration(r21).setInterpolator(r23).withEndAction(new c(this)).start();
        goto L85
    L67:
        if (r18 > 1600.0f) goto L70;
        r16.animate().translationY(0.0f).setDuration((long) (120 + (100 * RangesKt.coerceIn(r16.getTranslationY() / T5(), 0.0f, 1.0f)))).setInterpolator(new DecelerateInterpolator()).start();
        goto L85
    L57:
        r17.computeCurrentVelocity(GuidePriority.COMMERCE_CREDIT_PRIORITY);
        r18 = r17.getYVelocity();
        goto L58
    L86:
        VelocityTracker r29 = this.i;
        if (r29 == null) goto L89;
        r29.recycle();
    L89:
        this.i = null;
        ViewParent r30 = getParent();
        if (r30 == null) goto L92;
        r30.requestDisallowInterceptTouchEvent(false);
    L92:
        this.j = null;
        goto L105
    }

    public final void setOnDragDismiss(Function0<Unit> r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatJobDragDismissLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        Resources r5 = getResources();
        this.b = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density;
        this.c = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public static EditText U5(View r5, int r6, int r7) {
        if (r5.getVisibility() != 0) goto L31;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int[] r0 = new int[2];
        r5.getLocationOnScreen(r0);
        boolean r1 = false;
        int r2 = r0[0];
        if (r6 >= r2) goto L7;
    L13:
        if (r1 == true) goto L16;
        return null;
    L16:
        if ((r5 instanceof EditText) == false) goto L24;
        if (r5.canScrollVertically(-1) == true) goto L22;
        if (r5.canScrollVertically(1) == false) goto L24;
    L22:
        return (EditText) r5;
    L24:
        if ((r5 instanceof ViewGroup) == false) goto L35;
        ViewGroup r8 = (ViewGroup) r5;
        int r3 = r8.getChildCount() - 1;
    L26:
        if ((-1) >= r3) goto L37;
        EditText r4 = U5(r8.getChildAt(r3), r6, r7);
        if (r4 != null) goto L29;
        r3 = r3 - 1;
        goto L26
    L29:
        return r4;
    L37:
        return null;
    L35:
        return null;
    L7:
        if (r6 >= (r2 + r5.getWidth())) goto L13;
        int r9 = r0[1];
        if (r7 < r9) goto L13;
        if (r7 >= (r9 + r5.getHeight())) goto L13;
        r1 = true;
        goto L13
    L31:
        return null;
    }

    public /* synthetic */ ChatJobDragDismissLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
