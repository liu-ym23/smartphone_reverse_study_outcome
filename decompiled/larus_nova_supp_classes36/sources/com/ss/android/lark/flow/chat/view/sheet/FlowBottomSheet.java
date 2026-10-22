package com.ss.android.lark.flow.chat.view.sheet;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class FlowBottomSheet {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public b b;

    public static final class a {
    }

    public interface b {
        void onDismiss();
    }

    public static final class c {
        public final View a;
        public final LinearLayout b;
        public final View c;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            this.a = r2;
            this.b = (LinearLayout) r2.findViewById(2131364516);
            this.c = r2.findViewById(2131364522);
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ FlowBottomSheet a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.c().a.setVisibility(8);
            if (this.b == false) goto L8;
            b r3 = this.a.b;
            if (r3 == null) goto L9;
            r3.onDismiss();
            return;
        L9:
            return;
        }

        public d(FlowBottomSheet r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ View a;

        public e(View r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a;     // Catch: Throwable -> L4
            r0.setTranslationY(r0.getMeasuredHeight());     // Catch: Throwable -> L4
            r0.animate().translationY(0.0f).setDuration(300).start();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnKeyListener {
        public final /* synthetic */ FlowBottomSheet a;

        public f(FlowBottomSheet r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r1, int r2, KeyEvent r3) {
            if (r2 == 4) goto L5;
        L7:
            return false;
        L5:
            if (r3.getAction() != 1) goto L7;
            this.a.b(true);
            return true;
        }
    }

    static {
    }

    public abstract View a(ViewGroup r1);

    public final c c() {
        return (c) this.a.getValue();
    }

    public final void d() {
        c().a.setVisibility(0);
        LinearLayout r0 = c().b;
        OneShotPreDrawListener.add(r0, new e(r0));
        c().c.setAlpha(0.0f);
        c().c.animate().alpha(1.0f).setDuration(300).start();
        c().c.setFocusableInTouchMode(true);
        c().c.requestFocus();
        c().c.setOnKeyListener(new f(this));
    }

    public FlowBottomSheet(final Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = LazyKt.lazy(new FlowBottomSheet$viewHolder$2(r2, this));
    }

    public final void b(boolean r10) {
        AnimatorSet r0 = new AnimatorSet().setDuration(300);
        r0.addListener(new d(this, r10));
        r0.playTogether(new Animator[]{ObjectAnimator.ofFloat(c().b, "translationY", new float[]{0.0f, c().b.getHeight()}).setDuration(300), ObjectAnimator.ofFloat(c().c, "alpha", new float[]{1.0f, 0.0f}).setDuration(300)});
        r0.start();
    }
}
