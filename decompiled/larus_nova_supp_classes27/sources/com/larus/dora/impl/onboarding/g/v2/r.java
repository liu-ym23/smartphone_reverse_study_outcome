package com.larus.dora.impl.onboarding.g.v2;

import android.os.SystemClock;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingUiStateBaseFragment;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r extends f {
    /* JADX WARN: Type inference failed for: r1v3, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextViewWithAnim] */
    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void b() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.enterVideoCallMode();
    L5:
        LarusDoraGOnboardingFragmentV2Binding r1 = this.b;
        if (r1 == null) goto L9;
        DoraGOnboardingFragmentUiStateV2Kt.g(r1, false);
        final DoraMovieView r2 = r1.o;
        r2.post(new p(r2, this));
        j19.c.d(r1.n);
        ?? r3 = r1.f;
        r3.x();
        r3.setText(DoraGOnboardingFragmentUiStateV2Kt.i(2131902799, 2131902812));
        AppCompatTextView r4 = r1.g;
        Intrinsics.checkNotNull(r4);
        e1.x(r4);
        r4.setText(DoraGOnboardingFragmentUiStateV2Kt.c(2131902787));
        DoraGOnboardingFragmentUiStateV2Kt.a(r1);
        this.e = DoraGOnboardingFragmentUiStateV2Kt.e(this.a, this.b);
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f c() {
        Job r0 = this.e;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        DoraGOnboardingViewModelV2 r1 = this.c;
        if (r1 == null) goto L9;
        r1.forceWakeupState();
    L9:
        return new s(this.a, this.b, this.c);
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f g() {
        Job r0 = this.e;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        DoraGOnboardingViewModelV2 r1 = this.c;
        if (r1 == null) goto L9;
        r1.exitVideoCall();
    L9:
        return new m(this.a, this.b, this.c);
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void e(int r8, int r9) {
        DoraGOnboardingViewModelV2 r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        if (r8 == 5) goto L12;
        return;
    L12:
        if (r9 != 3) goto L41;
        long r10 = SystemClock.elapsedRealtime();
        if ((r10 - this.f) >= this.g) goto L16;
        r1 = true;
    L16:
        if (r1 == true) goto L18;
        this.f = r10;
    L18:
        if (r1 == false) goto L21;
        return;
    L21:
        if (this.h == false) goto L24;
        return;
    L24:
        if (this.c.canContinue() == true) goto L26;
        return;
    L26:
        this.h = true;
        this.c.enterVideoCallMode();
        this.c.playSuccessMusic();
        Job r11 = this.e;
        if (r11 == null) goto L29;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L29:
        LarusDoraGOnboardingFragmentV2Binding r12 = this.b;
        if (r12 == null) goto L32;
        DoraGOnboardingFragmentUiStateV2Kt.f(r12);
    L32:
        LifecycleOwner r13 = this.a;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        if ((r13 instanceof DoraGOnboardingUiStateBaseFragment) == false) goto L35;
        DoraGOnboardingUiStateBaseFragment r14 = (DoraGOnboardingUiStateBaseFragment) r13;
    L36:
        if (r14 == null) goto L42;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new DoraGOnboardingFragmentUiStateV2Kt$gotoDone$1$1(r14, null), 3, null);
        return;
    L42:
        return;
    L35:
        r14 = null;
        goto L36
    L41:
        return;
    L5:
        if (r0.isWearState() != true) goto L7;
        r2 = true;
        goto L8
    }

    public r(Fragment r2, LarusDoraGOnboardingFragmentV2Binding r3, DoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
