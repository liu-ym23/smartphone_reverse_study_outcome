package com.larus.dora.obric.onboarding;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.view.DoraTextViewWithAnim;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q extends p {
    public final String h;
    public final boolean i;
    public boolean j;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextViewWithAnim] */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.larus.dora.obric.onboarding.ObricDoraGOnboardingWelcomeStateFragment$registerClickStopAsrResultListener$1, m69.e] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View, android.widget.TextView, com.larus.dora.impl.view.DoraTextViewWithAnim] */
    @Override // com.larus.dora.obric.onboarding.p
    public final void b() {
        Fragment r1 = this.a;
        if ((r1 instanceof ObricDoraGOnboardingUiStateBaseFragment) == false) goto L5;
        ObricDoraGOnboardingUiStateBaseFragment r2 = (ObricDoraGOnboardingUiStateBaseFragment) r1;
    L6:
        if (r2 == null) goto L8;
        p r3 = r2.pa0();
    L9:
        StringBuilder r4 = new StringBuilder("display click stop, currentBeforeAssign=");
        if (r3 == null) goto L12;
        String r5 = r3.getClass().getSimpleName();
    L13:
        r4.append(r5);
        r4.append(", queryText=");
        String r6 = this.h;
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r4.append(r6);
        r4.append(", usePresetAnswer=");
        r4.append(this.i);
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", r4.toString());
        ObricDoraGOnboardingViewModelV2 r7 = this.c;
        if (r7 == null) goto L19;
        r7.enterKeyReportMode();
    L19:
        ObricDoraGOnboardingFragmentV2Binding r8 = this.b;
        if (r8 == null) goto L22;
        j19.c.d(r8.e);
        w.a(r8, w.b(2131903725), false);
    L22:
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", "show click stop state");
        Fragment r9 = this.a;
        if ((r9 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L25;
        final ObricDoraGOnboardingWelcomeStateFragment r10 = (ObricDoraGOnboardingWelcomeStateFragment) r9;
    L26:
        if (r10 == null) goto L94;
        String r11 = this.h;
        boolean r12 = this.i;
        ObricDoraGOnboardingFragmentV2Binding r13 = r10.r;
        if (r13 == null) goto L95;
        ConstraintLayout r14 = r13.a;
        if (r14 == null) goto L96;
        FrameLayout r15 = (FrameLayout) r14.findViewById(2131381170);
        if (r15 == null) goto L97;
        r10.jb0(2);
        final FrameLayout r16 = (FrameLayout) r15.findViewById(2131381175);
        r10.T = r15.findViewById(2131381172);
        r10.U = (ImageView) r15.findViewById(2131381173);
        r10.V = (DoraTextViewWithAnim) r15.findViewById(2131381171);
        r10.W = r15.findViewById(2131381167);
        r10.X = r15.findViewById(2131381168);
        r10.Y = (ImageView) r15.findViewById(2131381169);
        MarkdownTextView r17 = r10.W;
        if (r17 == null) goto L37;
        r17.setText("");
    L37:
        r10.Z = false;
        r10.k0 = false;
        r10.p0 = false;
        r10.g1 = true;
        if (r12 == false) goto L56;
        ?? r18 = r10.V;
        if (r18 == 0) goto L46;
        r18.y();
        if (r11 == null) goto L44;
        String r20 = r11;
    L45:
        r18.setText(r20);
        com.larus.utils.e1.x(r18);
        goto L46
    L44:
        r20 = r10.getString(2131912748);
    L46:
        r10.db0();
        r10.Sa0();
        String r21 = (String) ((Map) r10.x1.getValue()).get(r11);
        if (r21 != null) goto L49;
        r21 = r10.getString(2131912745);
    L49:
        View r22 = r10.X;
        if (r22 == null) goto L52;
        com.larus.utils.e1.x(r22);
    L52:
        r10.Qa0();
        r10.eb0();
        MarkdownTextView r23 = r10.W;
        if (r23 == null) goto L55;
        r23.setVisibility(0);
    L55:
        r10.Ua0(r21);
        ObricDoraGOnboardingViewModelV2.playTTSAfterVuiModeReady$default(r10.ga0(), r21, null, 2, null);
    L89:
        if (r10.P0 != null) goto L92;
        ?? r24 = new ObricDoraGOnboardingWelcomeStateFragment$registerClickStopAsrResultListener$1(r10);
        m69.a r25 = m69.a.a;
        m69.a.b(r24);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "registerClickStopAsrResultListener");
        r10.P0 = r24;
    L92:
        final int r26 = r10.M + 1;
        r10.M = r26;
        com.larus.utils.e1.x(r15);
        r16.post(new w0(r26, r10, r16));
        return;
    L56:
        if (r11 == null) goto L58;
        String r27 = StringsKt.trim(r11).toString();
    L59:
        if (r27 != null) goto L61;
    L64:
        boolean r28 = true;
    L65:
        if (r28 == false) goto L81;
        View r30 = r10.T;
        if (r30 == null) goto L69;
        com.larus.utils.e1.x(r30);
    L69:
        r10.Sa0();
        ImageView r31 = r10.U;
        if (r31 == null) goto L77;
        r31.setVisibility(0);
        Object r32 = r31.getDrawable();
        if ((r32 instanceof Animatable) == false) goto L74;
        Animatable r33 = (Animatable) r32;
    L75:
        if (r33 == null) goto L77;
        r33.start();
        goto L77
    L74:
        r33 = null;
    L77:
        ?? r34 = r10.V;
        if (r34 == 0) goto L80;
        r34.y();
        r34.setText("");
        r34.setVisibility(4);
    L80:
        r10.ab0();
    L83:
        if (r10.V0 != null) goto L89;
        if (r10.b1 == true) goto L89;
        r10.b1 = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10.getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingWelcomeStateFragment$registerClickStopMessageObserver$1(r10, null), 3, null);
        goto L89
    L81:
        r10.ib0(r27, "video_query_asr");
        goto L83
    L61:
        if (r27.length() == 0) goto L64;
        r28 = false;
        goto L65
    L58:
        r27 = null;
        goto L59
    L97:
        return;
    L96:
        return;
    L95:
        return;
    L94:
        return;
    L25:
        r10 = null;
        goto L26
    L12:
        r5 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final boolean d() {
        return !this.i;
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p e() {
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", "next from click stop");
        this.j = true;
        Fragment r0 = this.a;
        if ((r0 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L5;
        ObricDoraGOnboardingWelcomeStateFragment r1 = (ObricDoraGOnboardingWelcomeStateFragment) r0;
    L6:
        if (r1 == null) goto L8;
        r1.Ha0();
    L8:
        ObricDoraGOnboardingViewModelV2 r2 = this.c;
        if (r2 == null) goto L12;
        r2.stopAllTTS("exit click stop");
    L12:
        return new t(this.a, this.b, this.c, this.h, this.i);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p f() {
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", "previous from click stop");
        this.j = true;
        Fragment r0 = this.a;
        if ((r0 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L5;
        ObricDoraGOnboardingWelcomeStateFragment r1 = (ObricDoraGOnboardingWelcomeStateFragment) r0;
    L6:
        if (r1 == null) goto L8;
        r1.Ha0();
    L8:
        ObricDoraGOnboardingViewModelV2 r2 = this.c;
        if (r2 == null) goto L12;
        r2.stopTTS("back from click stop");
    L12:
        return new x(this.a, this.b, this.c);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final void c(int r10, int r11) {
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", "click stop key event received, event=" + r10 + ", pos=" + r11 + ", expectedEvent=2, expectedPos=2, usePresetAnswer=" + this.i + ", hasAutoAdvanced=" + this.j);
        if (r10 != 2) goto L47;
        if (r11 != 2) goto L47;
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", "handle click stop key event, stop tts and goto next");
        String r12 = null;
        if (this.j == true) goto L17;
        Fragment r13 = this.a;
        if ((r13 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L11;
        ObricDoraGOnboardingWelcomeStateFragment r14 = (ObricDoraGOnboardingWelcomeStateFragment) r13;
    L12:
        if (r14 == null) goto L17;
        String r0 = r14.V0;
        if (r0 == null) goto L16;
        b2.b(r0);
        goto L17
    L16:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14.getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingWelcomeStateFragment$trackClickStopSingleClickInterrupt$2(null), 3, null);
        goto L17
    L11:
        r14 = null;
    L17:
        ObricDoraGOnboardingViewModelV2 r15 = this.c;
        if (r15 == null) goto L20;
        r15.stopAllTTS("click stop key event");
    L20:
        Fragment r16 = this.a;
        if ((r16 instanceof ObricDoraGOnboardingUiStateBaseFragment) == false) goto L23;
        ObricDoraGOnboardingUiStateBaseFragment r17 = (ObricDoraGOnboardingUiStateBaseFragment) r16;
    L24:
        if (r17 == null) goto L26;
        p r18 = r17.pa0();
    L27:
        StringBuilder r1 = new StringBuilder("gotoNextOnce start, reason=click stop key event, hasAutoAdvanced=");
        r1.append(this.j);
        r1.append(", current=");
        if (r18 == null) goto L30;
        String r110 = r18.getClass().getSimpleName();
    L31:
        r1.append(r110);
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", r1.toString());
        if (this.j == false) goto L34;
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", "ignore goto next in click stop, already advanced, reason=click stop key event");
        return;
    L34:
        this.j = true;
        Fragment r111 = this.a;
        if ((r111 instanceof ObricDoraGOnboardingUiStateBaseFragment) == false) goto L37;
        ObricDoraGOnboardingUiStateBaseFragment r112 = (ObricDoraGOnboardingUiStateBaseFragment) r111;
    L38:
        if (r112 != null) goto L40;
        return;
    L40:
        if ((r112.pa0() instanceof q) == true) goto L42;
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", "ignore goto next in click stop, currentUiState=" + r112.pa0() + ", reason=click stop key event");
        return;
    L42:
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", "goto next from click stop, reason=click stop key event");
        r112.ra0();
        StringBuilder r2 = new StringBuilder("gotoNextOnce end, reason=click stop key event, current=");
        p r113 = r112.pa0();
        if (r113 == null) goto L45;
        r12 = r113.getClass().getSimpleName();
    L45:
        r2.append(r12);
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", r2.toString());
        return;
    L37:
        r112 = null;
        goto L38
    L30:
        r110 = null;
        goto L31
    L26:
        r18 = null;
        goto L27
    L23:
        r17 = null;
    L47:
        g49.d.d("ObricDoraGOnboardingFragmentUiStateClickStop", "ignore click stop key event, event=" + r10 + ", pos=" + r11);
    }

    public q(Fragment r2, ObricDoraGOnboardingFragmentV2Binding r3, ObricDoraGOnboardingViewModelV2 r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
        this.h = r5;
        this.i = r6;
    }
}
