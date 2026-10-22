package com.larus.dora.obric.onboarding;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import com.obric.oui.button.OButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v extends p {
    public final String h;
    public final boolean i;

    @Override // com.larus.dora.obric.onboarding.p
    public final void b() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        final ObricDoraGOnboardingWelcomeStateFragment r3 = null;
        if (r0 == null) goto L5;
        r0.enterTakePhotoMode();
        ObricDoraGOnboardingViewModelV2.fetchConfigLiveAI$default(r0, 0, 1, null);
        ObricDoraGOnboardingViewModelV2.playTTSAfterVuiModeReady$default(r0, w.b(2131903734), null, 2, null);
    L5:
        ObricDoraGOnboardingFragmentV2Binding r1 = this.b;
        if (r1 == null) goto L8;
        j19.c.d(r1.e);
        w.a(r1, w.b(2131903688), false);
    L8:
        Fragment r2 = this.a;
        if ((r2 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L11;
        r3 = (ObricDoraGOnboardingWelcomeStateFragment) r2;
    L11:
        if (r3 == null) goto L21;
        ObricDoraGOnboardingFragmentV2Binding r4 = r3.r;
        if (r4 == null) goto L22;
        ConstraintLayout r5 = r4.a;
        if (r5 == null) goto L23;
        FrameLayout r6 = (FrameLayout) r5.findViewById(2131381233);
        if (r6 == null) goto L24;
        r3.jb0(5);
        final FrameLayout r7 = (FrameLayout) r6.findViewById(2131381234);
        final int r8 = r3.P + 1;
        r3.P = r8;
        com.larus.utils.e1.x(r6);
        r7.post(new t0(r8, r3, r7));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p e() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.stopTTS("exit photo");
    L5:
        Fragment r1 = this.a;
        if ((r1 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L8;
        ObricDoraGOnboardingWelcomeStateFragment r2 = (ObricDoraGOnboardingWelcomeStateFragment) r1;
    L9:
        if (r2 == null) goto L12;
        r2.La0();
    L12:
        return new r(this.a, this.b, this.c);
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p f() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.stopTTS("back from photo");
    L5:
        Fragment r1 = this.a;
        if ((r1 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L8;
        ObricDoraGOnboardingWelcomeStateFragment r2 = (ObricDoraGOnboardingWelcomeStateFragment) r1;
    L9:
        if (r2 == null) goto L12;
        r2.La0();
    L12:
        return new u(this.a, this.b, this.c, this.h, this.i);
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final void c(int r8, int r9) {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        if (r8 == 2) goto L12;
        return;
    L12:
        if (r9 != 3) goto L31;
        long r10 = SystemClock.elapsedRealtime();
        if ((r10 - this.e) >= this.f) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L19;
        this.e = r10;
    L19:
        if (r2 == false) goto L22;
        return;
    L22:
        if (this.g == false) goto L25;
        this.c.playSuccessMusic();
        return;
    L25:
        this.g = true;
        ObricDoraGOnboardingFragmentV2Binding r11 = this.b;
        if (r11 == null) goto L32;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        com.larus.utils.e1.x(r11.n);
        j19.c.d(r11.f);
        j19.c.d(r11.g);
        int r3 = com.larus.utils.j0.a;
        String r4 = com.larus.utils.j0.d(2131902818);
        Intrinsics.checkNotNullParameter(r11, "<this>");
        ObricDoraGOnboardingBottomBtnLayoutBinding r12 = r11.d;
        com.larus.utils.e1.x(r12.c);
        OButton r5 = r12.d;
        Intrinsics.checkNotNull(r5);
        com.larus.utils.e1.q(r5);
        r5.setText(r4);
        com.larus.utils.e1.x(r12.f);
        j19.c.d(r12.e);
        j19.c.d(r12.b);
        this.c.playSuccessMusic();
        w.a(r11, w.b(2131903688), false);
        return;
    L32:
        return;
    L16:
        r2 = false;
        goto L17
    L31:
        return;
    L5:
        if (r0.isWearState() != true) goto L7;
        r1 = true;
        goto L8
    }

    public v(Fragment r2, ObricDoraGOnboardingFragmentV2Binding r3, ObricDoraGOnboardingViewModelV2 r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
        this.h = r5;
        this.i = r6;
    }
}
