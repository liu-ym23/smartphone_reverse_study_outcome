package com.larus.dora.impl.onboarding.g.v2;

import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingUiStateBaseFragment;
import com.larus.utils.e1;
import com.larus.utils.j0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraGOnboardingFragmentUiStateV2Kt {
    public static void a(LarusDoraGOnboardingFragmentV2Binding r2) {
        int r0 = j0.a;
        CharSequence r1 = j0.d(2131902818);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        LarusDoraGOnboardingBottomBtnLayoutBinding r3 = r2.d;
        e1.x(r3.c);
        AppCompatTextView r4 = r3.d;
        Intrinsics.checkNotNull(r4);
        e1.q(r4);
        r4.setText(r1);
        e1.x(r3.f);
        j19.c.d(r3.e);
        j19.c.d(r3.b);
    }

    public static final String c(int r1) {
        int r0 = j0.a;
        return j0.d(r1);
    }

    public static final void d(Fragment r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if ((r8 instanceof DoraGOnboardingUiStateBaseFragment) == false) goto L5;
        DoraGOnboardingUiStateBaseFragment r9 = (DoraGOnboardingUiStateBaseFragment) r8;
    L6:
        if (r9 == null) goto L9;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new DoraGOnboardingFragmentUiStateV2Kt$gotoNext$1$1(r9, null), 3, null);
        return;
    L9:
        return;
    L5:
        r9 = null;
        goto L6
    }

    public static final void f(LarusDoraGOnboardingFragmentV2Binding r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        e1.x(r1.n);
        j19.c.d(r1.f);
        j19.c.d(r1.g);
        a(r1);
    }

    public static final void h(LarusDoraGOnboardingFragmentV2Binding r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        j19.c.d(r2.o);
        LinearLayout r0 = r2.e;
        r2.f.y();
        Intrinsics.checkNotNull(r0);
        j19.c.d(r0);
        j19.c.d(r2.q);
        e1.q(r2.d.c);
    }

    public static final Job e(Fragment r7, LarusDoraGOnboardingFragmentV2Binding r8) {
        Intrinsics.checkNotNullParameter(r7, "fg");
        return BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7), null, null, new DoraGOnboardingFragmentUiStateV2Kt$showBottomNextButton$1(r8, null), 3, null);
    }

    public static final void g(LarusDoraGOnboardingFragmentV2Binding r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        d69.a.b(r1.o, r2);
        LinearLayout r0 = r1.e;
        Intrinsics.checkNotNull(r0);
        d69.a.b(r0, r2);
        r1.f.y();
        j19.c.d(r1.w);
        j19.c.d(r1.v);
        j19.c.d(r1.c);
        j19.c.d(r1.k);
        j19.c.d(r1.h);
        j19.c.d(r1.s);
        j19.c.d(r1.u);
        j19.c.d(r1.t);
        j19.c.d(r1.b);
        j19.c.d(r1.j);
        j19.c.d(r1.l);
        j19.c.d(r1.m);
        j19.c.d(r1.q);
        e1.q(r1.d.c);
    }

    public static final String i(int r2, int r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = j0.a;
        r0.append(j0.d(r2));
        r0.append('\n');
        r0.append(j0.d(r3));
        return r0.toString();
    }

    public static final void b(LarusDoraGOnboardingFragmentV2Binding r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        LarusDoraGOnboardingBottomBtnLayoutBinding r5 = r2.d;
        e1.x(r5.c);
        AppCompatTextView r0 = r5.d;
        if (r3 == null) goto L5;
        r0.setText(r3);
    L5:
        r0.setBackgroundResource(com.larus.dora.impl.util.u.a.a("larus_dora_g_onboarding_next_btn_bg"));
        if (r4 == false) goto L8;
        Intrinsics.checkNotNull(r0);
        d69.a.a(r0);
    L9:
        e1.x(r5.f);
        j19.c.d(r5.b);
        return;
    L8:
        Intrinsics.checkNotNull(r0);
        d69.a.b(r0, false);
        goto L9
    }
}
