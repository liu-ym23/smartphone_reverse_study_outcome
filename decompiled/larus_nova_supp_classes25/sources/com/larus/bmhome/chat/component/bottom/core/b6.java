package com.larus.bmhome.chat.component.bottom.core;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EditText;
import com.larus.bmhome.chat.component.bottom.voice.a;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b6 implements Function1 {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ CoreInputComponent c;
    public final /* synthetic */ Ref.IntRef d;
    public final /* synthetic */ EditText e;
    public final /* synthetic */ Ref.ObjectRef f;
    public final /* synthetic */ a g;
    public final /* synthetic */ com.larus.bmhome.chat.component.bottom.voice.d0 h;

    public /* synthetic */ b6(Ref.BooleanRef r1, Ref.BooleanRef r2, CoreInputComponent r3, Ref.IntRef r4, EditText r5, Ref.ObjectRef r6, a r7, com.larus.bmhome.chat.component.bottom.voice.d0 r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final Object invoke(Object r13) {
        Ref.BooleanRef r0 = this.a;
        Ref.BooleanRef r1 = this.b;
        CoreInputComponent r2 = this.c;
        Ref.IntRef r3 = this.d;
        EditText r4 = this.e;
        Ref.ObjectRef r5 = this.f;
        a r6 = this.g;
        com.larus.bmhome.chat.component.bottom.voice.d0 r7 = this.h;
        int r8 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((View) r13, "it");
        int r14 = com.larus.bmhome.chat.component.bottom.voice.d0.d;
        com.larus.bmhome.chat.component.bottom.voice.d0.a.a("[onLongPress ActionVoiceInput] use stream voice mix input");
        r0.element = false;
        r1.element = true;
        r2.G2 = true;
        final LarusWidgetInputBinding r9 = r2.W;
        if (r9 == null) goto L8;
        EditText r10 = r2.V4();
        if (r10 == null) goto L8;
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r11.setDuration(240);
        r11.setInterpolator((Interpolator) r2.F2.getValue());
        r11.addUpdateListener(new z2(r9));
        r11.addListener(new q7(r2, r10, r9));
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(new Animator[]{r11});
        r12.start();
        r9.z.a();
    L8:
        int r15 = r4.length();
        r3.element = r15;
        r5.element = "long_press_button";
        r2.D6(r6, r7, r15, "long_press_button");
        return Unit.INSTANCE;
    }
}
