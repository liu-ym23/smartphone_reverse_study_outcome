package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.chat.component.bottom.voice.a;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f6 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ com.larus.bmhome.chat.component.bottom.voice.d0 b;
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ a d;

    public /* synthetic */ f6(CoreInputComponent r1, com.larus.bmhome.chat.component.bottom.voice.d0 r2, Ref.BooleanRef r3, a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r12) {
        CoreInputComponent r0 = this.a;
        com.larus.bmhome.chat.component.bottom.voice.d0 r1 = this.b;
        Ref.BooleanRef r2 = this.c;
        a r3 = this.d;
        com.larus.bmhome.chat.component.bottom.voice.service.g r13 = (com.larus.bmhome.chat.component.bottom.voice.service.g) r12;
        int r4 = CoreInputComponent.d3;
        if (r13 == null) goto L69;
        int r5 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        com.larus.bmhome.chat.component.bottom.voice.d0.a.a("observeVoiceMixInputStatus: isLongPress(" + r0.G2 + ") status(" + r13 + ')');
        if (r0.G2 == false) goto L20;
        LarusWidgetInputBinding r6 = r0.W;
        if (r6 == null) goto L68;
        va8.m r7 = r0.vU();
        if (r7 == null) goto L16;
        va8.l r8 = r7.iX();
        if (r8 == null) goto L16;
        View r9 = r8.c();
        if (r9 == null) goto L16;
        com.larus.utils.e1.o(r9);
    L16:
        com.larus.utils.e1.y(r6.y, !r13.a);
        if (r13.a == false) goto L19;
        r0.W5(false);
        r0.k4().Dr(false);
        r1.c("long_press_button", "end");
        goto L68
    L19:
        r0.k4().rE();
        r0.W5(true);
        r0.k4().Rk();
    L68:
        return Unit.INSTANCE;
    L20:
        boolean r10 = r2.element;
        if (r13.b != 2) goto L23;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L49;
        LarusWidgetInputBinding r14 = r0.W;
        if (r14 == null) goto L68;
        va8.m r15 = r0.vU();
        if (r15 == null) goto L35;
        va8.l r16 = r15.iX();
        if (r16 == null) goto L35;
        View r17 = r16.c();
        if (r17 == null) goto L35;
        com.larus.utils.e1.y(r17, r13.a);
    L35:
        com.larus.utils.e1.x(r14.y);
        if (r13.a == false) goto L43;
        LarusWidgetInputBinding r18 = r0.W;
        if (r18 == null) goto L42;
        LottieAnimationView r19 = r18.y;
        if (r19 == null) goto L42;
        r19.setRepeatCount(-1);
        r19.setRepeatMode(1);
        r19.setAnimation("lottie/voice_input_recording.json");
        r19.playAnimation();
    L42:
        r0.W5(false);
        r1.c("click_button", "end");
        goto L68
    L43:
        LarusWidgetInputBinding r110 = r0.W;
        if (r110 == null) goto L48;
        LottieAnimationView r111 = r110.y;
        if (r111 == null) goto L48;
        r111.cancelAnimation();
        r111.setImageResource(v19.c.b(2130971892, r111.getContext(), 2131242301));
    L48:
        r0.W5(true);
        r0.k4().Rk();
        goto L68
    L49:
        LarusWidgetInputBinding r20 = r0.W;
        if (r20 == null) goto L68;
        va8.m r21 = r0.vU();
        if (r21 == null) goto L58;
        va8.l r22 = r21.iX();
        if (r22 == null) goto L58;
        View r23 = r22.c();
        if (r23 == null) goto L58;
        com.larus.utils.e1.y(r23, r13.a);
    L58:
        com.larus.utils.e1.y(r20.y, !r13.a);
        if (r13.a == false) goto L61;
        ICoreInputAbility.b.b(r0.k4());
        r0.W5(false);
        r1.c("click_button", "end");
        goto L68
    L61:
        if (r10 == true) goto L63;
    L65:
        r3.lP();
        r0.ra();
    L66:
        r0.W5(true);
        r0.k4().Rk();
        goto L68
    L63:
        if (((BaseComponentFeatureInternal) r0).a.getCurrentState() != Lifecycle.State.RESUMED) goto L65;
        ICoreInputAbility.b.e(r0.k4(), "voice_mix_input_hide_keyboard", null, false, 6);
        goto L66
    L23:
        r11 = false;
        goto L25
    L69:
        return Unit.INSTANCE;
    }
}
