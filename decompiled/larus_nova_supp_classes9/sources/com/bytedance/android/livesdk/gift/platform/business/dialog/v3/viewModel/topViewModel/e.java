package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.AnimMoveType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public final Map<View, AnimatorSet> a;

    public static final class a {
    }

    public static final class b extends o12.b {
        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public b() {
        }
    }

    static {
    }

    public final void a() {
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((AnimatorSet) ((Map.Entry) r0.next()).getValue()).cancel();
        goto L4
    L6:
        ((LinkedHashMap) this.a).clear();
    }

    public e() {
        this.a = new LinkedHashMap();
    }

    public final void b(View r3) {
        AnimatorSet r0 = (AnimatorSet) ((LinkedHashMap) this.a).get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() != true) goto L11;
        AnimatorSet r4 = (AnimatorSet) ((LinkedHashMap) this.a).get(r3);
        if (r4 == null) goto L12;
        r4.cancel();
        return;
    L12:
        return;
    }

    public final void e(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        b(r6);
        r6.setAlpha(1.0f);
        AnimatorSet r1 = new AnimatorSet();
        this.a.put(r6, r1);
        r1.playTogether(new Animator[]{ObjectAnimator.ofFloat(r6, "scaleX", new float[]{1.0f, 1.1f, 1.0f}), ObjectAnimator.ofFloat(r6, "scaleY", new float[]{1.0f, 1.1f, 1.0f})});
        r1.setDuration(100);
        r1.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r1.addListener(new b());
        r1.start();
    }

    public final void c(View r8, AnimMoveType r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "animMoveType");
        b(r8);
        AnimatorSet r0 = new AnimatorSet();
        this.a.put(r8, r0);
        int r10 = f.b[r9.ordinal()];
        if (r10 == 1) goto L7;
        if (r10 != 2) goto L8;
        r8.setAlpha(1.0f);
        r0.playSequentially(new Animator[]{ObjectAnimator.ofFloat(r8, "translationX", new float[]{i.a(5.0f), 0.0f})});
    L8:
        r0.setDuration(150);
        r0.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r0.start();
        return;
    L7:
        r8.setAlpha(1.0f);
        r0.playSequentially(new Animator[]{ObjectAnimator.ofFloat(r8, "translationX", new float[]{i.a(-5.0f), 0.0f})});
        goto L8
    }

    public final void d(View r9, AnimMoveType r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "animMoveType");
        b(r9);
        AnimatorSet r0 = new AnimatorSet();
        this.a.put(r9, r0);
        int r11 = f.a[r10.ordinal()];
        if (r11 == 1) goto L7;
        if (r11 != 2) goto L8;
        r9.setAlpha(0.4f);
        r0.playSequentially(new Animator[]{ObjectAnimator.ofFloat(r9, "translationX", new float[]{0.0f, i.a(10.0f)}), ObjectAnimator.ofFloat(r9, "translationX", new float[]{i.a(10.0f), i.a(5.0f)})});
    L8:
        r0.setDuration(150);
        r0.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r0.start();
        return;
    L7:
        r9.setAlpha(0.4f);
        r0.playSequentially(new Animator[]{ObjectAnimator.ofFloat(r9, "translationX", new float[]{0.0f, i.a(-10.0f)}), ObjectAnimator.ofFloat(r9, "translationX", new float[]{i.a(-10.0f), i.a(-5.0f)})});
        goto L8
    }
}
