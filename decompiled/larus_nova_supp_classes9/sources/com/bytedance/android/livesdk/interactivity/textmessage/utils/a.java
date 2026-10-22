package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.livesdk.utils.q4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.textmessage.utils.a$a, reason: collision with other inner class name */
    public static final class C0221a implements ValueAnimator.AnimatorUpdateListener {
        public static final C0221a a = null;

        static {
            a = new C0221a();
        }

        public C0221a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
        }
    }

    static {
    }

    public static Animator a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        q4.j.getClass();
        ValueAnimator r3 = q4.a.b(r2, "alpha", new float[]{0.0f, 1.0f});
        r3.setDuration(500);
        r3.setInterpolator(PathInterpolatorCompat.create(0.17f, 0.17f, 0.83f, 0.83f));
        r3.addUpdateListener(C0221a.a);
        return r3;
    }

    public static Animator c(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "propertyName");
        q4.j.getClass();
        ValueAnimator r4 = q4.a.b(r2, r3, new float[]{0.8f, 1.0f});
        r4.setDuration(500);
        r4.setInterpolator(PathInterpolatorCompat.create(0.22f, 1.0f, 0.36f, 1.0f));
        return r4;
    }

    public static Animator e(View r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r3, "view");
        q4.j.getClass();
        ValueAnimator r6 = q4.a.b(r3, "translationY", new float[]{r4, r5});
        r6.setDuration(300);
        r6.setInterpolator(PathInterpolatorCompat.create(0.32f, 0.94f, 0.6f, 1.0f));
        r6.addUpdateListener(c.a);
        return r6;
    }

    public static Animator d(View r3, float r4, float r5, long r6, float r8, float r9, float r10) {
        Intrinsics.checkNotNullParameter(r3, "view");
        q4.j.getClass();
        ValueAnimator r7 = q4.a.b(r3, "translationX", new float[]{r4, r5});
        r7.setDuration(r6);
        r7.setInterpolator(PathInterpolatorCompat.create(r8, r9, r10, 1.0f));
        r7.addUpdateListener(b.a);
        return r7;
    }

    public static Animator b(View r3, String r4, float r5, float r6, long r7, float r9, float r10, float r11, float r13) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "propertyName");
        q4.j.getClass();
        ValueAnimator r8 = q4.a.b(r3, r4, new float[]{r5, r6});
        r8.setDuration(r7);
        r8.setInterpolator(PathInterpolatorCompat.create(r9, r10, r11, r13));
        return r8;
    }
}
