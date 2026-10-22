package ag;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {

    /* JADX INFO: renamed from: ag.a$a, reason: collision with other inner class name */
    public static final class C0002a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ WindowManager a;
        public final /* synthetic */ View b;
        public final /* synthetic */ WindowManager.LayoutParams c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Boolean e;
        public final /* synthetic */ Context f;

        public C0002a(WindowManager r1, View r10, WindowManager.LayoutParams r11, int r12, Boolean r13, Context r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Object r11 = r10.getAnimatedValue();
            if ((r11 instanceof PointF) == true) goto L5;
            r11 = null;
        L5:
            PointF r12 = (PointF) r11;
            if (r12 != null) goto L18;
            r12 = new PointF();
        L18:
            WindowManager r0 = this.a;     // Catch: IllegalArgumentException -> L17
            if (r0 == null) goto L20;
            View r1 = this.b;     // Catch: IllegalArgumentException -> L17
            WindowManager.LayoutParams r13 = this.c;     // Catch: IllegalArgumentException -> L17
            r13.x = ((int) r12.x) - this.d;     // Catch: IllegalArgumentException -> L17
            if (Intrinsics.areEqual(this.e, Boolean.TRUE) == false) goto L14;
            int r14 = ((int) r12.y) - eh.b.b(this.f);     // Catch: IllegalArgumentException -> L17
            int r15 = this.d;     // Catch: IllegalArgumentException -> L17
        L15:
            r13.y = r14 - r15;     // Catch: IllegalArgumentException -> L17
            Unit r16 = Unit.INSTANCE;     // Catch: IllegalArgumentException -> L17
            r0.updateViewLayout(r1, r13);     // Catch: IllegalArgumentException -> L17
            return;
        L14:
            r14 = (int) r12.y;     // Catch: IllegalArgumentException -> L17
            r15 = this.d;     // Catch: IllegalArgumentException -> L17
            goto L15
        L20:
            return;
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ WindowManager c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            Function0 r11 = this.b;
            if (r11 == null) goto L14;
            Unit r12 = (Unit) r11.invoke();
        L14:
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L11
            WindowManager r14 = this.c;     // Catch: Throwable -> L11
            if (r14 == null) goto L8;
            r14.removeView(this.a);     // Catch: Throwable -> L11
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L9:
            Result.constructor-impl(r15);     // Catch: Throwable -> L11
            return;
        L8:
            r15 = null;
        L11:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            this.a.setVisibility(8);
            Function0 r11 = this.b;
            if (r11 == null) goto L14;
            Unit r12 = (Unit) r11.invoke();
        L14:
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L11
            WindowManager r14 = this.c;     // Catch: Throwable -> L11
            if (r14 == null) goto L8;
            r14.removeView(this.a);     // Catch: Throwable -> L11
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L11
        L9:
            Result.constructor-impl(r15);     // Catch: Throwable -> L11
            return;
        L8:
            r15 = null;
        L11:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        public b(View r1, Function0 r10, WindowManager r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public static void b(View r22, View r23, long r24, View r26, Float r27, Float r28, Integer r29, AnimatorSet r30, Boolean r31, Function0 r32) {
        Intrinsics.checkNotNullParameter(r22, "sourceView");
        Intrinsics.checkNotNullParameter(r23, "destinationView");
        int[] r10 = new int[2];
        r22.getLocationOnScreen(r10);
        float r11 = r10[0] + (r22.getWidth() / 2);
        float r12 = r10[1] + (r22.getHeight() / 2);
        int[] r13 = new int[2];
        r23.getLocationOnScreen(r13);
        float r14 = r13[0] + (r23.getWidth() / 2);
        float r15 = r13[1] + (r23.getHeight() / 2);
        if (r27 == null) goto L6;
        if (r28 == null) goto L6;
        float r16 = r28.floatValue();
        r14 = r14 - r27.floatValue();
        r15 = r15 - r16;
    L6:
        Context r17 = r22.getContext();
        Context r18 = r23.getContext();
        c(r17, r18, r11, r12, r14, r15, r24, r26, r27, r28, r29, r30, r31, r32);
    }

    public static void a(Context r18, float[] r19, float[] r20, long r21, View r23, Float r24, Float r25, Integer r26, AnimatorSet r27, Boolean r28, Function0 r29) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "sourceLocation");
        Intrinsics.checkNotNullParameter(r20, "destinationLocation");
        if (r19.length == 2) goto L5;
    L13:
        dm.a.a("AddCartMotion").b("length of location array is not correct!", null);
        return;
    L5:
        if (r20.length != 2) goto L13;
        float r10 = r20[0];
        float r1 = r20[1];
        if (r24 == null) goto L11;
        if (r25 == null) goto L11;
        float r11 = r25.floatValue();
        r10 = r10 - r24.floatValue();
        r1 = r1 - r11;
    L11:
        float r12 = r1;
        float r13 = r19[0];
        float r14 = r19[1];
        c(r18, r18, r13, r14, r10, r12, r21, r23, r24, r25, r26, r27, r28, r29);
    }

    public static void c(Context r17, Context r18, float r19, float r20, float r21, float r22, long r23, View r25, Float r26, Float r27, Integer r28, AnimatorSet r29, Boolean r30, Function0 r31) {
        Object r10 = r18.getSystemService("window");
        if ((r10 instanceof WindowManager) == true) goto L5;
        r10 = null;
    L5:
        WindowManager r11 = (WindowManager) r10;
        int r12 = vf4.a.a(r17, 5.0f);
        WindowManager.LayoutParams r13 = new WindowManager.LayoutParams();
        float r14 = 10.0f;
        if (r26 == null) goto L8;
        float r15 = r26.floatValue();
    L9:
        r13.width = vf4.a.a(r17, r15);
        if (r27 == null) goto L12;
        r14 = r27.floatValue();
    L12:
        r13.height = vf4.a.a(r17, r14);
        r13.x = ((int) r19) - r12;
        if (r28 != null) goto L15;
        int r16 = ((int) r20) - eh.b.b(r17);
    L16:
        r13.y = r16 - r12;
        r13.flags = 664;
        r13.format = -3;
        r13.gravity = 8388659;
        if (r28 == null) goto L19;
        int r110 = r28.intValue();
    L20:
        r13.type = r110;
        if (r25 != null) goto L23;
        View r24 = th.a.d(r18, 2131564851, null, 4);
    L24:
        if (r11 == null) goto L27;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r24, r13);
        r11.addView(r24, r13);
    L27:
        if (r22 >= r20) goto L29;
        TypeEvaluator r0 = new c(new PointF((r19 + r21) / 2, (float) (((double) r22) - (((double) (r20 - r22)) * 0.3d))));
    L30:
        ValueAnimator r111 = ValueAnimator.ofObject(r0, new Object[]{new PointF(r19, r20), new PointF(r21, r22)});
        r111.addUpdateListener(new C0002a(r11, r24, r13, r12, r30, r17));
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r24, "scaleX", new float[]{1.0f, 0.3f});
        ObjectAnimator r32 = ObjectAnimator.ofFloat(r24, "scaleY", new float[]{1.0f, 0.3f});
        AnimatorSet r33 = new AnimatorSet();
        r33.setDuration(600);
        r33.setInterpolator(new DecelerateInterpolator());
        r33.setStartDelay(r23);
        r33.addListener(new b(r24, r31, r11));
        if (r29 == null) goto L33;
        r33.playTogether(new Animator[]{r29});
    L33:
        r33.playTogether(new Animator[]{r111, r1, r32});
        r33.start();
        return;
    L29:
        r0 = new ag.b();
        goto L30
    L23:
        r24 = r25;
        goto L24
    L19:
        r110 = 99;
        goto L20
    L15:
        r16 = (int) r20;
        goto L16
    L8:
        r15 = 10.0f;
        goto L9
    }
}
