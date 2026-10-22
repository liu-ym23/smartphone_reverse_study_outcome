package jq;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Interpolator f18419b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f18420a;

    static {
        f18419b = PathInterpolatorCompat.create(0.22f, 0.61f, 0.36f, 1.0f);
    }

    public b(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.f18420a = r5;
    }

    public static AnimatorSet a(b r5, float r10, float r11, long r12) {
        r5.getClass();
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{r10, r11});
        r13.setDuration(r12);
        r13.setInterpolator(f18419b);
        r13.addUpdateListener(new com.google.android.material.appbar.b(4, new LinkedHashSet(), r5));
        Intrinsics.checkNotNull(r13);
        r13.addListener(new a(r5, r10, 1));
        r13.addListener(new a(r5, r11, 0));
        AnimatorSet r14 = new AnimatorSet();
        r14.play(r13);
        return r14;
    }
}
