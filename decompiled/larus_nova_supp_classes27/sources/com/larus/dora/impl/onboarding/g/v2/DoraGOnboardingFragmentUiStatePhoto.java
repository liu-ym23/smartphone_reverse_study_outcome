package com.larus.dora.impl.onboarding.g.v2;

import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import com.larus.dora.impl.view.DoraMovieView;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraGOnboardingFragmentUiStatePhoto extends f {
    /* JADX WARN: Type inference failed for: r1v3, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextViewWithAnim] */
    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void b() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.enterTakePhotoMode();
        DoraGOnboardingViewModelV2.fetchConfigLiveAI$default(r0, 0, 1, null);
    L5:
        LarusDoraGOnboardingFragmentV2Binding r1 = this.b;
        if (r1 == null) goto L9;
        DoraGOnboardingFragmentUiStateV2Kt.g(r1, false);
        final DoraMovieView r2 = r1.o;
        r2.post(new n(r2, this));
        j19.c.d(r1.n);
        ?? r3 = r1.f;
        r3.x();
        r3.setText(DoraGOnboardingFragmentUiStateV2Kt.c(2131902816));
        j19.c.d(r1.g);
        DoraGOnboardingFragmentUiStateV2Kt.a(r1);
        this.e = DoraGOnboardingFragmentUiStateV2Kt.e(this.a, this.b);
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f g() {
        Job r0 = this.e;
        boolean r1 = true;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        DoraGOnboardingViewModelV2 r2 = this.c;
        if (r2 != null) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L14;
        return new r(this.a, this.b, this.c);
    L14:
        return new m(this.a, this.b, this.c);
    L8:
        if (r2.isLiveAI() != true) goto L10;
        goto L10
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
        if (r8 == 2) goto L12;
        return;
    L12:
        if (r9 != 3) goto L32;
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
        if (this.h == false) goto L23;
        return;
    L23:
        this.h = true;
        LarusDoraGOnboardingFragmentV2Binding r11 = this.b;
        if (r11 == null) goto L33;
        DoraGOnboardingFragmentUiStateV2Kt.f(r11);
        this.c.playSuccessMusic();
        Job r12 = this.e;
        if (r12 == null) goto L28;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L28:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new DoraGOnboardingFragmentUiStatePhoto$key$1$1(this, null), 3, null);
        return;
    L33:
        return;
    L32:
        return;
    L5:
        if (r0.isWearState() != true) goto L7;
        r2 = true;
        goto L8
    }

    public DoraGOnboardingFragmentUiStatePhoto(Fragment r2, LarusDoraGOnboardingFragmentV2Binding r3, DoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
