package com.larus.dora.obric.onboarding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x extends p {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.dora.obric.onboarding.p
    public final void b() {
        Fragment r0 = this.a;
        if ((r0 instanceof ObricDoraGOnboardingUiStateBaseFragment) == false) goto L5;
        ObricDoraGOnboardingUiStateBaseFragment r1 = (ObricDoraGOnboardingUiStateBaseFragment) r0;
    L7:
        if (r1 == null) goto L9;
        r1.t = false;
    L9:
        ObricDoraGOnboardingViewModelV2 r2 = this.c;
        if (r2 == null) goto L12;
        r2.enterVoiceOnlyMode(false, false);
        ObricDoraGOnboardingViewModelV2.playTTSAfterVuiModeReady$default(r2, w.b(2131903737), null, 2, null);
    L12:
        ObricDoraGOnboardingFragmentV2Binding r3 = this.b;
        if (r3 == null) goto L15;
        j19.c.d(r3.e);
        w.a(r3, w.b(2131903728), false);
    L15:
        Fragment r4 = this.a;
        if ((r4 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L18;
        final ObricDoraGOnboardingWelcomeStateFragment r5 = (ObricDoraGOnboardingWelcomeStateFragment) r4;
    L19:
        if (r5 == null) goto L52;
        final ObricDoraGOnboardingWelcomeStateFragment.b r6 = r5.R;
        if (r6 != null) goto L44;
        ObricDoraGOnboardingFragmentV2Binding r7 = r5.r;
        if (r7 == null) goto L41;
        ConstraintLayout r8 = r7.a;
        if (r8 == null) goto L41;
        View r9 = r8.findViewById(2131381276);
        if (r9 == null) goto L41;
        ObricDoraGOnboardingWelcomeStateFragment.b r10 = new ObricDoraGOnboardingWelcomeStateFragment.b(r9, CollectionsKt.listOf(new BottomFadeImageView[]{r9.findViewById(2131376574), r9.findViewById(2131376575)}), (FrameLayout) r9.findViewById(2131392324), (ObricDoraGOnboardingTopicView) r9.findViewById(2131381238));
        r5.R = r10;
        Iterator<T> r11 = r10.b.iterator();
    L31:
        if (r11.hasNext() == false) goto L34;
        ((BottomFadeImageView) r11.next()).setBottomFadeEnabled(false);
        goto L31
    L34:
        if ((!((List) r5.v1.getValue()).isEmpty()) == false) goto L40;
        ObricDoraGOnboardingTopicView r12 = r10.d;
        List r13 = (List) r5.v1.getValue();
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L37:
        if (r15.hasNext() == false) goto L39;
        r14.add(((z1) r15.next()).a);
        goto L37
    L39:
        r12.setTopicList(r14);
    L40:
        r10.d.setOnTopicChangedListener(new ObricDoraGOnboardingWelcomeStateFragment$bindVideoQueryViews$1$3(r5));
        r10.d.setOnPrimaryQueryClickListener(new d1(r5));
        r6 = r10;
    L42:
        if (r6 != null) goto L44;
        return;
    L41:
        r6 = null;
    L44:
        r5.jb0(1);
        r5.H0 = null;
        if (r5.L0 != null) goto L48;
        r1 r16 = new r1(r5);
        m69.a r17 = m69.a.a;
        m69.a.b(r16);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "registerVideoQueryAsrResultListener");
        r5.L0 = r16;
    L48:
        com.larus.utils.e1.x(r6.a);
        final int r18 = r5.L + 1;
        r5.L = r18;
        r6.a.post(new z0(r18, r5, r6));
        return;
    L52:
        return;
    L18:
        r5 = null;
        goto L19
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p e() {
        Fragment r0 = this.a;
        ObricDoraGOnboardingWelcomeStateFragment r2 = null;
        if ((r0 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L5;
        ObricDoraGOnboardingWelcomeStateFragment r1 = (ObricDoraGOnboardingWelcomeStateFragment) r0;
    L6:
        if (r1 == null) goto L16;
        String r3 = r1.H0;
        if (r3 != null) goto L15;
        ObricDoraGOnboardingWelcomeStateFragment.b r4 = r1.R;
        if (r4 == null) goto L14;
        ObricDoraGOnboardingTopicView r5 = r4.d;
        if (r5 == null) goto L14;
        r3 = r5.getCurrentQueryText();
    L14:
        r3 = null;
    L15:
        String r7 = r3;
    L17:
        Fragment r6 = this.a;
        if ((r6 instanceof ObricDoraGOnboardingUiStateBaseFragment) == false) goto L20;
        ObricDoraGOnboardingUiStateBaseFragment r8 = (ObricDoraGOnboardingUiStateBaseFragment) r6;
    L21:
        boolean r9 = false;
        if (r8 != null) goto L24;
    L26:
        boolean r10 = !r9;
        ObricDoraGOnboardingViewModelV2 r11 = this.c;
        if (r11 == null) goto L29;
        r11.stopTTS("exit video query");
    L29:
        Fragment r12 = this.a;
        if ((r12 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L32;
        r2 = (ObricDoraGOnboardingWelcomeStateFragment) r12;
    L32:
        if (r2 == null) goto L35;
        r2.Na0();
    L35:
        return new q(this.a, this.b, this.c, r7, r10);
    L24:
        if (r8.t != true) goto L26;
        r9 = true;
        goto L26
    L20:
        r8 = null;
        goto L21
    L16:
        r7 = null;
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    public x(Fragment r2, ObricDoraGOnboardingFragmentV2Binding r3, ObricDoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
