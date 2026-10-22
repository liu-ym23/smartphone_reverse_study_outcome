package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.impl.databinding.LarusDoraHSimplifiedWakeupBinding;
import com.larus.dora.impl.settings.SimplifiedTopic;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0<T> implements FlowCollector {
    public final /* synthetic */ DoraHStreamlinedWakeupFragment a;

    public h0(DoraHStreamlinedWakeupFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r18, Continuation r110) {
        Unit r0 = (Unit) r18;
        final DoraHStreamlinedWakeupFragment r9 = this.a;
        if (r9.r.size() <= 1) goto L62;
        if (r9.w == true) goto L62;
        if (r9.x == true) goto L62;
        if (r9.y == true) goto L62;
        SimplifiedTopic r1 = r9.na0(r9.u);
        if (r1 == null) goto L62;
        SimplifiedTopic r3 = r9.na0(r9.u + 1);
        if (r3 == null) goto L62;
        final String r6 = DoraHStreamlinedWakeupFragment.oa0(r1);
        final String r7 = DoraHStreamlinedWakeupFragment.oa0(r3);
        LarusDoraHSimplifiedWakeupBinding r2 = r9.q;
        if (r2 == null) goto L62;
        final RecyclerView r10 = r2.e;
        View r4 = r10.getChildAt(0);
        if (r4 != null) goto L23;
        r9.la0(r9.u + 1, true);
        goto L62
    L23:
        final float r11 = DoraHStreamlinedWakeupFragment.ia0(r4);
        if (r11 <= 0.0f) goto L62;
        final DoraHStreamlinedWakeupFragment.c r8 = r9.ga0(r6, r7);
        if (r8 == null) goto L62;
        r9.w = true;
        int r5 = r8.c;
        int r12 = r8.d;
        LarusDoraHSimplifiedWakeupBinding r13 = r9.q;
        if (r13 == null) goto L42;
        final LinearLayout r14 = r13.g;
        if (r14 == null) goto L42;
        if (r5 <= 0) goto L42;
        if (r12 <= 0) goto L42;
        if (r5 == r12) goto L42;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        r15.width = r5;
        r14.setLayoutParams(r15);
        ValueAnimator r16 = r9.B;
        if (r16 == null) goto L41;
        r16.cancel();
    L41:
        ValueAnimator r17 = ValueAnimator.ofInt(new int[]{r5, r12});
        r17.setDuration(450);
        r17.setInterpolator(new FastOutSlowInInterpolator());
        r17.addUpdateListener(new d0(r14));
        r17.addListener(new l0(r9));
        r17.start();
        r9.B = r17;
    L42:
        float r20 = r8.e;
        float r21 = r8.f;
        LarusDoraHSimplifiedWakeupBinding r22 = r9.q;
        if (r22 == null) goto L57;
        final ImageView r23 = r22.f;
        if (r23 == null) goto L57;
        if (r20 != r21) goto L50;
        boolean r111 = true;
    L51:
        if (r111 == false) goto L53;
        r23.setTranslationX(r21 - r23.getLeft());
        r9.C = null;
        goto L57
    L53:
        r23.setTranslationX(r20 - r23.getLeft());
        ValueAnimator r112 = r9.C;
        if (r112 == null) goto L56;
        r112.cancel();
    L56:
        ValueAnimator r24 = ValueAnimator.ofFloat(new float[]{r20, r21});
        r24.setDuration(450);
        r24.setInterpolator(new FastOutSlowInInterpolator());
        r24.addUpdateListener(new e0(r23));
        r24.addListener(new k0(r23, r21, r9));
        r24.start();
        r9.C = r24;
        goto L57
    L50:
        r111 = false;
    L57:
        ValueAnimator r25 = r9.A;
        if (r25 == null) goto L60;
        r25.cancel();
    L60:
        final Ref.FloatRef r113 = new Ref.FloatRef();
        Ref.BooleanRef r114 = new Ref.BooleanRef();
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{0.0f, r11});
        r115.setDuration(450);
        r115.setInterpolator(new FastOutSlowInInterpolator());
        r115.addUpdateListener(new c0(r113, r10, r11, r9, r6, r7, r8));
        r115.addListener(new m0(r9, r114, r11, r113, r10));
        r9.A = r115;
        r115.start();
    L62:
        return Unit.INSTANCE;
    }
}
