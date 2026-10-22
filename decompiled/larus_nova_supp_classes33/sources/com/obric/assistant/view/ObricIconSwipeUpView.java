package com.obric.assistant.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0003+,-B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020#J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(H\u0017J\u000e\u0010)\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020%R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0010\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/assistant/view/ObricIconSwipeUpView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureDetector", "Landroid/view/GestureDetector;", "minimumFlingVelocity", "touchSlop", "distance", "", "isWindowMode", "", "()Z", "isWindowMode$delegate", "Lkotlin/Lazy;", "iconRect", "Landroid/graphics/Rect;", "gestureLottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "kotlin.jvm.PlatformType", "getGestureLottieView", "()Lcom/airbnb/lottie/LottieAnimationView;", "gestureLottieView$delegate", "translationAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "getTranslationAnimation", "()Landroidx/dynamicanimation/animation/SpringAnimation;", "translationAnimation$delegate", "listener", "Lcom/obric/assistant/view/ObricIconSwipeUpView$OnIconSwipeListener;", "setOnIconSwipeListener", "", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "swipeIcon", "resetSwipeIcon", "Companion", "OnIconSwipeListener", "IconGestureListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricIconSwipeUpView extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public final GestureDetector a;
    public final int b;
    public final int c;
    public float d;
    public final Lazy e;
    public final Rect f;
    public final Lazy g;
    public final Lazy h;
    public c i;

    public static final class a {
    }

    public final class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ ObricIconSwipeUpView a;

        public b(ObricIconSwipeUpView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            FLogger.a.i("ObricIconSwipeUpView", "onSingleTapUp e.x is " + r4.getX() + ", e.y is " + r4.getY());
            LottieAnimationView r0 = ObricIconSwipeUpView.b(this.a);
            if (r0 == null) goto L5;
            r0.getHitRect(this.a.f);
        L5:
            ObricIconSwipeUpView r1 = this.a;
            c r2 = r1.i;
            if (r2 == null) goto L10;
            r2.onClick(r1.f.contains((int) r4.getX(), (int) r4.getY()));
            return true;
        L10:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r3, MotionEvent r4, float r5, float r6) {
            Intrinsics.checkNotNullParameter(r4, "e2");
            ObricIconSwipeUpView r0 = this.a;
            float r1 = r4.getRawY();
            if (r3 == null) goto L5;
            float r7 = r3.getRawY();
        L6:
            r0.d = r1 - r7;
            ObricIconSwipeUpView r8 = this.a;
            if (r8.d < (-r8.c)) goto L9;
            return false;
        L9:
            if (Math.abs(r6) > 3000.0f) goto L11;
            return false;
        L11:
            if (r6 < (-this.a.b)) goto L13;
            return false;
        L13:
            if (Math.abs(r6) <= Math.abs(r5)) goto L23;
            c r9 = this.a.i;
            if (r9 == null) goto L17;
            r9.b(r6);
        L17:
            this.a.d = 0.0f;
            return true;
        L23:
            return false;
        L5:
            r7 = r4.getRawY();
            goto L6
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r8, MotionEvent r9, float r10, float r11) {
            Intrinsics.checkNotNullParameter(r9, "e2");
            ObricIconSwipeUpView r0 = this.a;
            float r1 = r9.getRawY();
            if (r8 == null) goto L5;
            float r2 = r8.getRawY();
        L6:
            r0.d = r1 - r2;
            ObricIconSwipeUpView r3 = this.a;
            c r4 = r3.i;
            boolean r5 = true;
            if (r4 == null) goto L13;
            float r6 = r3.d;
            float r7 = -r11;
            if (r6 > 0.0f) goto L11;
            boolean r12 = true;
        L12:
            r4.a(r6, r7, r12);
            goto L13
        L11:
            r12 = false;
        L13:
            FLogger r13 = FLogger.a;
            StringBuilder r14 = new StringBuilder("onScroll distance is ");
            r14.append(this.a.d);
            r14.append(", distanceY is ");
            r14.append(r11);
            r14.append(", swipeUp is ");
            if (this.a.d <= 0.0f) goto L17;
            r5 = false;
        L17:
            r14.append(r5);
            r13.i("ObricIconSwipeUpView", r14.toString());
            return super.onScroll(r8, r9, r10, r11);
        L5:
            r2 = r9.getRawY();
            goto L6
        }
    }

    public interface c {
        void a(float r1, float r2, boolean r3);

        void b(float r1);

        void c();

        void d(float r1, boolean r2);

        void onClick(boolean r1);
    }

    static {
    }

    public ObricIconSwipeUpView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ObricIconSwipeUpView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LottieAnimationView getGestureLottieView() {
        return (LottieAnimationView) this.g.getValue();
    }

    private final SpringAnimation getTranslationAnimation() {
        return (SpringAnimation) this.h.getValue();
    }

    public final void c() {
        getTranslationAnimation().setStartValue(getGestureLottieView().getTranslationY());
        getTranslationAnimation().animateToFinalPosition(0.0f);
        FLogger.a.i("ObricIconSwipeUpView", "resetSwipeIcon");
    }

    public static final /* synthetic */ LottieAnimationView b(ObricIconSwipeUpView r0) {
        return r0.getGestureLottieView();
    }

    public final void d(float r5) {
        float r0 = (-r5) / i5.k0();
        getGestureLottieView().setProgress(r0);
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L5;
        setAlpha(1 - r0);
    L5:
        FLogger.a.i("ObricIconSwipeUpView", "swipeIcon distance is " + r5 + ", progress is " + r0);
        if (getTranslationAnimation().isRunning() == false) goto L8;
        return;
    L8:
        getGestureLottieView().setTranslationY(r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onTouchEvent action is ");
        r1.append(r6.getAction());
        r1.append(", isEnabled: ");
        r1.append(isEnabled());
        r1.append(", isVisible: ");
        boolean r3 = false;
        if (getVisibility() != 0) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0.i("ObricIconSwipeUpView", r1.toString());
        if (isEnabled() == true) goto L9;
    L35:
        return false;
    L9:
        if (getVisibility() != 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L35;
        this.a.onTouchEvent(r6);
        if (r6.getAction() != 0) goto L20;
        this.d = 0.0f;
        c r7 = this.i;
        if (r7 == null) goto L34;
        r7.c();
    L34:
        return true;
    L20:
        if (r6.getAction() != 1) goto L22;
    L23:
        float r8 = this.d;
        if (r8 != 0.0f) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == true) goto L34;
        c r9 = this.i;
        if (r9 == null) goto L34;
        if (r8 >= 0.0f) goto L33;
        r3 = true;
    L33:
        r9.d(r8, r3);
        goto L34
    L26:
        r5 = false;
        goto L27
    L22:
        if (r6.getAction() != 3) goto L34;
    L11:
        r4 = false;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public final void setOnIconSwipeListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.i = r2;
    }

    public static void a(ObricIconSwipeUpView r2, float r3) {
        r2.getGestureLottieView().setTranslationY(r3);
        FLogger.a.i("ObricIconSwipeUpView", "translationAnimation value is " + r3);
    }

    public ObricIconSwipeUpView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new GestureDetector(r2, new b(this));
        this.b = ViewConfiguration.get(r2).getScaledMinimumFlingVelocity();
        this.c = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.e = LazyKt.lazy(new q(r2));
        this.f = new Rect();
        this.g = LazyKt.lazy(new r(this));
        this.h = LazyKt.lazy(new s(this));
        LayoutInflater.from(r2).inflate(2131564029, this, true);
    }

    public /* synthetic */ ObricIconSwipeUpView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
