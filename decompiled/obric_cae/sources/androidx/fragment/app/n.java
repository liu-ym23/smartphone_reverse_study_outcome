package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f2033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f2034b;

        public a(Animator r8) {
            this.f2033a = null;
            this.f2034b = r8;
        }

        public a(Animation r8) {
            this.f2033a = r8;
            this.f2034b = null;
        }
    }

    public static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f2035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f2036b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f2037m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f2038n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f2039o;

        public b(Animation r8, ViewGroup r10, View r11) {
            super(false);
            this.f2039o = true;
            this.f2035a = r10;
            this.f2036b = r11;
            addAnimation(r8);
            r10.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public final boolean getTransformation(long r8, Transformation r10) {
            this.f2039o = true;
            if (this.f2037m == false) goto L7;
            return !this.f2038n;
        L7:
            if (super.getTransformation(r8, r10) == true) goto L9;
            this.f2037m = true;
            j0.r.a(this.f2035a, this);
        L9:
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r8 = this.f2037m;
            ViewGroup r10 = this.f2035a;
            if (r8 == false) goto L5;
        L7:
            r10.endViewTransition(this.f2036b);
            this.f2038n = true;
            return;
        L5:
            if (this.f2039o == false) goto L7;
            this.f2039o = false;
            r10.post(this);
        }

        @Override // android.view.animation.Animation
        public final boolean getTransformation(long r8, Transformation r10, float r11) {
            this.f2039o = true;
            if (this.f2037m == false) goto L7;
            return !this.f2038n;
        L7:
            if (super.getTransformation(r8, r10, r11) == true) goto L9;
            this.f2037m = true;
            j0.r.a(this.f2035a, this);
        L9:
            return true;
        }
    }

    public static a a(Context r8, Fragment r10, boolean r11, boolean r12) {
        int r13 = r10.getNextTransition();
        if (r12 == false) goto L7;
        if (r11 == false) goto L6;
        int r14 = r10.getPopEnterAnim();
    L10:
        boolean r15 = false;
        r10.setAnimations(0, 0, 0, 0);
        ViewGroup r16 = r10.mContainer;
        if (r16 != null) goto L13;
    L15:
        ViewGroup r17 = r10.mContainer;
        if (r17 != null) goto L18;
    L20:
        Animation r18 = r10.onCreateAnimation(r13, r11, r14);
        if (r18 != null) goto L23;
        Animator r19 = r10.onCreateAnimator(r13, r11, r14);
        if (r19 != null) goto L27;
        if (r14 != 0) goto L47;
        if (r13 == 0) goto L47;
        if (r13 != 4097) goto L33;
        if (r11 == false) goto L45;
        int r20 = R.animator.fragment_open_enter;
    L46:
        r14 = r20;
        goto L47
    L45:
        r20 = R.animator.fragment_open_exit;
        goto L46
    L33:
        if (r13 != 4099) goto L35;
        if (r11 == false) goto L42;
        r20 = R.animator.fragment_fade_enter;
        goto L46
    L42:
        r20 = R.animator.fragment_fade_exit;
        goto L46
    L35:
        if (r13 == 8194) goto L37;
        r20 = -1;
        goto L46
    L37:
        if (r11 == false) goto L39;
        r20 = R.animator.fragment_close_enter;
        goto L46
    L39:
        r20 = R.animator.fragment_close_exit;
    L47:
        if (r14 == 0) goto L69;
        boolean r21 = "anim".equals(r8.getResources().getResourceTypeName(r14));
        if (r21 == true) goto L73;
    L57:
        if (r15 == true) goto L69;
        Animator r22 = AnimatorInflater.loadAnimator(r8, r14);     // Catch: RuntimeException -> L62
        if (r22 == null) goto L69;
        return new a(r22);
    L62:
        e = move-exception;
        if (r21 == true) goto L68;
        Animation r23 = AnimationUtils.loadAnimation(r8, r14);
        if (r23 == null) goto L69;
        return new a(r23);
    L68:
        throw e;
    L73:
        Animation r24 = AnimationUtils.loadAnimation(r8, r14);     // Catch: Resources.NotFoundException -> L55 RuntimeException -> L70
        if (r24 == null) goto L54;
        return new a(r24);
        goto L57
    L54:
        r15 = true;
    L55:
        e = move-exception;
        throw e;
    L69:
        return null;
    L27:
        return new a(r19);
    L23:
        return new a(r18);
    L18:
        if (r17.getLayoutTransition() == null) goto L20;
        return null;
    L13:
        if (r16.getTag(R.id.visible_removing_fragment_view_tag) == null) goto L15;
        r10.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        goto L15
    L6:
        r14 = r10.getPopExitAnim();
        goto L10
    L7:
        if (r11 == false) goto L9;
        r14 = r10.getEnterAnim();
        goto L10
    L9:
        r14 = r10.getExitAnim();
        goto L10
    }
}
