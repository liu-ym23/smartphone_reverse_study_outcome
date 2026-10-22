package com.larus.camera.impl.ui.component.capture.edu;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.larus.camera.impl.ui.component.capture.CaptureTitleComponent;
import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c0 extends CaptureTitleComponent {
    public final com.larus.camera.impl.utils.h n;
    public String o;
    public final List<String> p;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ Function0 a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
            this.a.invoke();
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ Function0 a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r1) {
            this.a.invoke();
        }
    }

    public c0() {
        this.n = new com.larus.camera.impl.utils.h();
        this.o = "CAPTURE_MODE_EDU_GENERAL_PHOTO";
        List<String> r0 = fx8.a.a;
        this.p = fx8.a.e;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent, com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.p;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent
    public final void s(CameraCaptureViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        w(r2, this.o);
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent
    public final void t(String r4) {
        Intrinsics.checkNotNullParameter(r4, "captureMode");
        if (Intrinsics.areEqual(r4, this.o) == false) goto L5;
        return;
    L5:
        String r0 = this.o;
        this.o = r4;
        if (Intrinsics.areEqual("CAPTURE_MODE_EDU_HOMEWORK_PHOTO", r4) == false) goto L8;
    L9:
        CameraCaptureViewModel r1 = (CameraCaptureViewModel) ((com.larus.camera.impl.ui.arch.b.a) this.e.getValue()).a();
        if (r1 != null) goto L12;
        return;
    L12:
        w(r1, r4);
        return;
    L8:
        if (Intrinsics.areEqual("CAPTURE_MODE_EDU_HOMEWORK_PHOTO", r0) == true) goto L9;
    }

    public static final Object u(c0 r3, Continuation r4) {
        r3.getClass();
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = new i0(r0);
        r3.r(new h0(r3, r1));
        Object r5 = r0.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L6:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r5;
    L9:
        return Unit.INSTANCE;
    }

    public final void v(View r3, Function0<Unit> r4) {
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{1.0f, 0.3f, 1.0f});
        r5.setStartDelay(500);
        r5.setDuration(1000);
        r5.setInterpolator(new AccelerateDecelerateInterpolator());
        Intrinsics.checkNotNull(r5);
        r5.addListener(new b(r4));
        r5.addListener(new a(r4));
        com.larus.camera.impl.utils.h r6 = this.n;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "animator");
        r6.a.add(r5);
        r5.start();
    }

    public final void w(final CameraCaptureViewModel r2, String r3) {
        if (Intrinsics.areEqual("CAPTURE_MODE_EDU_HOMEWORK_PHOTO", r3) == false) goto L5;
        super.s(r2);
        return;
    L5:
        q(new com.larus.camera.impl.ui.component.capture.edu.a(r2, this));
        r2.checkupDarkMode(new h(this), new i(this));
    }
}
