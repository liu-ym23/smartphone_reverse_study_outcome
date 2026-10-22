package com.larus.common_ui.view.overscrollrecyclerview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u0002:\u000556789B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001aH\u0002J \u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010,\u001a\u00020%2\u0006\u0010)\u001a\u00020!2\u0006\u0010-\u001a\u00020\u001eH\u0002J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020!H\u0002J\u0010\u0010/\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020!H\u0002J \u00100\u001a\u00020%2\u0006\u0010)\u001a\u00020!2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u00101\u001a\u00020%H\u0007J\b\u00102\u001a\u00020%H\u0007J\u0010\u00103\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u00010\fJ\u0006\u0010\r\u001a\u00020%R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u00060\u0014R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "overScrollListener", "Lcom/larus/common_ui/view/overscrollrecyclerview/OverScrollListener;", "forceBackToIdle", "", "defaultState", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$DefaultState;", "overScrollingState", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$OverScrollingState;", "bouncingBackState", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$BounceBackState;", "getBouncingBackState", "()Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$BounceBackState;", "bouncingBackState$delegate", "Lkotlin/Lazy;", "curUIState", "Lcom/larus/common_ui/view/overscrollrecyclerview/HorizontalOverScrollRV$IUIState;", "initParam", "Lcom/larus/common_ui/view/overscrollrecyclerview/OverScrollInitParams;", "speed", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "", "handleSwiftState", "state", "initMotionParams", "view", "params", "Lcom/larus/common_ui/view/overscrollrecyclerview/OffsetParams;", "moveView", "offset", "isInAbsStart", "isInAbsEnd", "moveViewWithEvent", "attach", "detach", "setOverScrollListener", "listener", "IUIState", "BounceBackState", "DefaultState", "OverScrollingState", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HorizontalOverScrollRV extends RecyclerView implements View.OnTouchListener {
    public static final /* synthetic */ int h = 0;
    public boolean a;
    public final c b;
    public final e c;
    public final Lazy d;
    public d e;
    public final y19.d f;
    public float g;

    public final class a implements d, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        public final RecyclerView a;
        public final y19.a b;
        public final Interpolator c;
        public final float d;
        public final float e;
        public final /* synthetic */ HorizontalOverScrollRV f;

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean N0(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            return true;
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean a(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            return true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final void b(d r8) {
            Intrinsics.checkNotNullParameter(r8, "preUIState");
            this.b.c = this.a.getTranslationX();
            this.b.b = this.a.getWidth();
            y19.a r9 = this.b;
            r9.a = ViewGroup.TRANSLATION_X;
            HorizontalOverScrollRV r0 = this.f;
            float r1 = r0.g;
            if (r1 != 0.0f) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == true) goto L16;
            if (r1 >= 0.0f) goto L11;
            if (r0.f.c == true) goto L16;
        L11:
            if (r1 > 0.0f) goto L13;
        L15:
            float r10 = RangesKt.coerceAtLeast(0.0f, (0 - r1) / this.d);
            float r2 = this.f.g;
            float r3 = ((-r2) * r2) / this.e;
            y19.a r4 = this.b;
            float r5 = r3 + r4.c;
            ObjectAnimator r7 = ObjectAnimator.ofFloat(this.a, r4.a, new float[]{r5});
            r7.setInterpolator(this.c);
            r7.setDuration((int) r10);
            r7.addUpdateListener(this);
            Intrinsics.checkNotNull(r7);
            ObjectAnimator r11 = d(r5);
            AnimatorSet r12 = new AnimatorSet();
            r12.playSequentially(new Animator[]{r7, r11});
            Animator r13 = r12;
        L17:
            r13.addListener(this);
            r13.start();
            return;
        L13:
            if (r0.f.c == true) goto L15;
        L16:
            r13 = d(r9.c);
            goto L17
        L5:
            r6 = false;
            goto L6
        }

        public final ObjectAnimator d(float r6) {
            ObjectAnimator r0 = ObjectAnimator.ofFloat(this.a, this.b.a, new float[]{this.f.f.b});
            float r7 = (Math.abs(r6) / this.b.b) * 800;
            r0.setInterpolator(this.c);
            r0.setDuration(RangesKt.coerceAtLeast((int) r7, BaiduNaviStatus.WRONG_AK_PARAM));
            r0.addUpdateListener(this);
            Intrinsics.checkNotNull(r0);
            return r0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            HorizontalOverScrollRV r3 = this.f;
            int r0 = HorizontalOverScrollRV.h;
            r3.getClass();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            HorizontalOverScrollRV r3 = this.f;
            HorizontalOverScrollRV.t(r3, r3.b);
            this.f.getClass();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            HorizontalOverScrollRV r3 = this.f;
            int r0 = HorizontalOverScrollRV.h;
            r3.getClass();
        }

        public a(HorizontalOverScrollRV r2, HorizontalOverScrollRV r3) {
            Intrinsics.checkNotNullParameter(r3, "recyclerView");
            this.f = r2;
            this.a = r3;
            this.b = new y19.a();
            this.c = new DecelerateInterpolator();
            this.d = -1.0f;
            this.e = -2.0f;
        }
    }

    public static final class b {
    }

    public final class c implements d {
        public final y19.c a;
        public final /* synthetic */ HorizontalOverScrollRV b;

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean a(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            return false;
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final void b(d r2) {
            Intrinsics.checkNotNullParameter(r2, "preUIState");
        }

        public c(HorizontalOverScrollRV r1) {
            this.b = r1;
            this.a = new y19.c();
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean N0(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            HorizontalOverScrollRV r0 = this.b;
            if (HorizontalOverScrollRV.u(r0, r0, this.a, r6) == true) goto L5;
            return false;
        L5:
            RecyclerView r1 = this.b;
            r1.getClass();
            if ((!r1.canScrollHorizontally(-1)) == true) goto L8;
        L9:
            RecyclerView r2 = this.b;
            r2.getClass();
            if ((!r2.canScrollHorizontally(1)) == true) goto L12;
        L16:
            return false;
        L12:
            if (this.a.a == true) goto L16;
        L14:
            this.b.f.a = r6.getPointerId(0);
            HorizontalOverScrollRV r3 = this.b;
            y19.d r4 = r3.f;
            y19.c r5 = this.a;
            r4.b = r5.b;
            r4.c = r5.a;
            d r7 = r3.c;
            r3.e = r7;
            r7.b(r7);
            this.b.getClass();
            this.b.c.N0(r6);
            return true;
        L8:
            if (this.a.a == true) goto L14;
            goto L9
        }
    }

    public interface d {
        boolean N0(MotionEvent r1);

        boolean a(MotionEvent r1);

        void b(d r1);
    }

    public final class e implements d {
        public final y19.c a;
        public final /* synthetic */ HorizontalOverScrollRV b;

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final void b(d r2) {
            Intrinsics.checkNotNullParameter(r2, "preUIState");
        }

        public e(HorizontalOverScrollRV r1) {
            this.b = r1;
            this.a = new y19.c();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean N0(MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            ?? r0 = this.b;
            y19.d r1 = r0.f;
            if (r0.a == false) goto L7;
            float r2 = r1.b;
            r0.setTranslationX(r2);
            r10.offsetLocation(r2 - r10.getX(0), 0.0f);
            HorizontalOverScrollRV r11 = this.b;
            d r3 = r11.b;
            r11.e = r3;
            r3.b(r3);
            this.b.a = false;
            return true;
        L7:
            if (r1.a == r10.getPointerId(0)) goto L10;
            HorizontalOverScrollRV r12 = this.b;
            d r4 = HorizontalOverScrollRV.r(r12);
            r12.e = r4;
            r4.b(r4);
            return true;
        L10:
            HorizontalOverScrollRV r5 = this.b;
            if (HorizontalOverScrollRV.u(r5, r5, this.a, r10) == true) goto L13;
            return true;
        L13:
            y19.c r6 = this.a;
            float r7 = r6.c / 2.0f;
            float r8 = r6.b + r7;
            boolean r9 = r1.c;
            if (r9 == true) goto L16;
        L19:
            if (r9 == true) goto L27;
            if (r6.a == false) goto L27;
            if (r8 < r1.b) goto L27;
        L24:
            RecyclerView r13 = this.b;
            float r14 = r1.b;
            r13.getClass();
            r13.setTranslationX(r14);
            r10.offsetLocation(r14 - r10.getX(0), 0.0f);
            HorizontalOverScrollRV r15 = this.b;
            d r16 = r15.b;
            r15.e = r16;
            r16.b(r16);
            return true;
        L27:
            if (this.b.getParent() == null) goto L29;
            this.b.getParent().requestDisallowInterceptTouchEvent(true);
        L29:
            long r17 = r10.getEventTime() - r10.getHistoricalEventTime(0);
            if (r17 <= 0) goto L32;
            this.b.g = r7 / r17;
        L32:
            RecyclerView r18 = this.b;
            r18.getClass();
            r18.setTranslationX(r8);
            return true;
        L16:
            if (r6.a == true) goto L19;
            if (r8 <= r1.b) goto L24;
            goto L19
        }

        @Override // com.larus.common_ui.view.overscrollrecyclerview.HorizontalOverScrollRV.d
        public final boolean a(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            HorizontalOverScrollRV r3 = this.b;
            HorizontalOverScrollRV.t(r3, HorizontalOverScrollRV.r(r3));
            return false;
        }
    }

    static {
    }

    public HorizontalOverScrollRV(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HorizontalOverScrollRV(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setOverScrollListener(y19.e r1) {
    }

    private final a getBouncingBackState() {
        return (a) this.d.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setOnTouchListener(null);
        setOverScrollMode(0);
    }

    public static final /* synthetic */ a r(HorizontalOverScrollRV r0) {
        return r0.getBouncingBackState();
    }

    public static final void t(HorizontalOverScrollRV r0, d r1) {
        r0.e = r1;
        r1.b(r1);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r3, MotionEvent r4) {
        if (r4 == null) goto L4;
        Integer r5 = Integer.valueOf(r4.getActionMasked());
    L5:
        if (r5 != null) goto L8;
    L10:
        if (r5 != null) goto L13;
    L14:
        if (r5 != null) goto L17;
    L19:
        return false;
    L17:
        if (r5.intValue() != 3) goto L19;
    L21:
        return this.e.a(r4);
    L13:
        if (r5.intValue() == 1) goto L21;
    L8:
        if (r5.intValue() != 2) goto L10;
        return this.e.N0(r4);
    L4:
        r5 = null;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalOverScrollRV(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        c r5 = new c(this);
        this.b = r5;
        this.c = new e(this);
        this.d = LazyKt.lazy(new y19.b(this));
        this.e = r5;
        this.f = new y19.d();
        setOnTouchListener(this);
        setOverScrollMode(2);
    }

    public /* synthetic */ HorizontalOverScrollRV(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean u(HorizontalOverScrollRV r3, HorizontalOverScrollRV r4, y19.c r5, MotionEvent r6) {
        r3.getClass();
        boolean r0 = false;
        if (r6.getHistorySize() == 0) goto L13;
        float r7 = r6.getX(0) - r6.getHistoricalX(0, 0);
        if (Math.abs(r6.getY(0) - r6.getHistoricalY(0, 0)) < Math.abs(r7)) goto L9;
        return false;
    L9:
        if (r5.c <= 0.0f) goto L11;
        r0 = true;
    L11:
        r5.a = r0;
        r5.b = r4.getTranslationX();
        r5.c = r7;
        return true;
    L13:
        return false;
    }
}
