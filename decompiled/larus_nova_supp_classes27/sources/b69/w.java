package b69;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.dora.impl.databinding.LarusDoraOnboardingMusicPanelBinding;
import com.larus.dora.impl.onboarding.ext.AnimViewType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.CubicBezierInterpolator;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w {
    public static final CubicBezierInterpolator a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;
    public static final Lazy r = null;
    public static final Lazy s = null;
    public static final Lazy t = null;
    public static final Lazy u = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AnimViewType.values().length];
            r0[AnimViewType.AVATAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AnimViewType.BUBBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AnimViewType.BUBBLE_BACKGROUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new CubicBezierInterpolator(0.34f, 0.69f, 0.1f);
        b = LazyKt.lazy(new b69.a());
        c = LazyKt.lazy(new c());
        d = LazyKt.lazy(new d());
        e = LazyKt.lazy(new e());
        f = LazyKt.lazy(new f());
        g = LazyKt.lazy(new g());
        h = LazyKt.lazy(new h());
        i = LazyKt.lazy(new i());
        j = LazyKt.lazy(new j());
        k = LazyKt.lazy(new k());
        l = LazyKt.lazy(new l());
        m = LazyKt.lazy(new o());
        n = LazyKt.lazy(new p());
        o = LazyKt.lazy(new q());
        p = LazyKt.lazy(new r());
        q = LazyKt.lazy(new s());
        r = LazyKt.lazy(new t());
        s = LazyKt.lazy(new u());
        t = LazyKt.lazy(new v());
        u = LazyKt.lazy(new b());
    }

    public static final float c() {
        return ((Number) c.getValue()).floatValue();
    }

    public static final float d() {
        return ((Number) b.getValue()).floatValue();
    }

    public static final float e() {
        return ((Number) j.getValue()).floatValue();
    }

    public static final float f() {
        return ((Number) i.getValue()).floatValue();
    }

    public static final float g() {
        return ((Number) f.getValue()).floatValue();
    }

    public static final float h() {
        return ((Number) e.getValue()).floatValue();
    }

    public static final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r2.setAlpha(0.0f);
        e1.x(r2);
        r2.animate().alpha(1.0f).setDuration(600).setInterpolator(a).start();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void b(LarusDoraOnboardingMusicPanelBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        final ConstraintLayout r4 = r3.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r4.animate().alpha(0.0f).setInterpolator(a).setDuration(600).withEndAction(new n(r4)).start();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void i(LarusDoraOnboardingMusicPanelBinding r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        e1.o(r1.a);
    }

    public static final void m(LarusDoraOnboardingMusicPanelBinding r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        final ConstraintLayout r4 = r3.a;
        Intrinsics.checkNotNull(r4);
        if (r4.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r4.animate().scaleX(0.5f).scaleY(0.5f).alpha(0.0f).setInterpolator(a).setDuration(600).withEndAction(new m(r4)).start();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void o(View r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        r6.setAlpha(0.1f);
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r6, View.SCALE_X, new float[]{0.9f, 1.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r6, View.SCALE_Y, new float[]{0.9f, 1.0f});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r6, View.ALPHA, new float[]{0.1f, 1.0f});
        CubicBezierInterpolator r4 = a;
        r0.setInterpolator(r4);
        r2.setInterpolator(r4);
        r3.setInterpolator(new DecelerateInterpolator());
        e1.x(r6);
        AnimatorSet r7 = new AnimatorSet();
        r7.setDuration(800);
        r7.playTogether(new Animator[]{r0, r2, r3});
        r7.start();
    }

    public static void k(View r3, AnimViewType r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "animViewType");
        int r5 = a.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        j(r3, ((Number) m.getValue()).floatValue(), ((Number) n.getValue()).floatValue(), ((Number) o.getValue()).floatValue(), true);
        return;
    L5:
        if (r5 != 2) goto L7;
        j(r3, ((Number) p.getValue()).floatValue(), ((Number) q.getValue()).floatValue(), ((Number) r.getValue()).floatValue(), true);
        return;
    L7:
        if (r5 != 3) goto L10;
        j(r3, ((Number) s.getValue()).floatValue(), ((Number) t.getValue()).floatValue(), ((Number) u.getValue()).floatValue(), true);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final void n(LarusDoraOnboardingMusicPanelBinding r4, z98.f r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "data");
        ImageLoaderKt.u(r4.c, r5.a, "tag_dora_onboarding_music_cover_image");
        r4.d.setText(r5.b);
        r4.b.setText(r5.c);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ConstraintLayout r6 = r4.a;
        Intrinsics.checkNotNull(r6);
        if (r6.getVisibility() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == true) goto L9;
        r6.setScaleX(0.5f);
        r6.setScaleY(0.5f);
        r6.setAlpha(0.0f);
        e1.x(r6);
        r6.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(a).setDuration(1000).start();
        return;
    L9:
        return;
    L5:
        r7 = false;
        goto L6
    }

    public static void l(View r6, boolean r7, int r8) {
        boolean r1 = true;
        if ((r8 & 1) == 0) goto L6;
        r7 = true;
    L6:
        if ((r8 & 2) == 0) goto L8;
        long r2 = 600;
    L9:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r6.getScaleX() != 1.0f) goto L12;
        boolean r9 = true;
    L14:
        if (r9 == true) goto L16;
    L31:
        if (r7 == false) goto L33;
        r6.animate().setDuration(r2).scaleX(1.0f).scaleY(1.0f).translationY(0.0f).translationX(0.0f).setInterpolator(a).start();
        return;
    L33:
        r6.setScaleX(1.0f);
        r6.setScaleY(1.0f);
        r6.setTranslationY(0.0f);
        r6.setTranslationX(0.0f);
        return;
    L16:
        if (r6.getScaleY() != 1.0f) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L31;
        if (r6.getTranslationY() != 0.0f) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == false) goto L31;
        if (r6.getTranslationX() == 0.0f) goto L29;
        r1 = false;
    L29:
        if (r1 == false) goto L31;
        return;
    L23:
        r11 = false;
        goto L24
    L18:
        r10 = false;
        goto L19
    L12:
        r9 = false;
        goto L14
    L8:
        r2 = 0;
        goto L9
    }

    public static void j(View r3, float r4, float r5, float r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        boolean r1 = false;
        if (r3.getScaleX() != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L22:
        if (r7 == false) goto L24;
        r3.animate().setDuration(600).scaleX(r4).scaleY(r4).translationX(r5).translationY(r6).setInterpolator(a).start();
        return;
    L24:
        r3.setScaleX(r4);
        r3.setScaleY(r4);
        r3.setTranslationX(r5);
        r3.setTranslationY(r6);
        return;
    L8:
        if (r3.getScaleY() != r4) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L22;
        if (r3.getTranslationY() != r6) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L22;
        if (r3.getTranslationX() != r5) goto L20;
        r1 = true;
    L20:
        if (r1 == false) goto L22;
        return;
    L15:
        r8 = false;
        goto L16
    L10:
        r2 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }
}
