package com.larus.av_call.view;

import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class e1 implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ e1(com.larus.voicecall.impl.component.window.l r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function1 r0 = this.a;
        AppCompatImageView r4 = (AppCompatImageView) r3;
        int r1 = VoiceCallTopLayout.o;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.invoke(r4);
        return Unit.INSTANCE;
    }
}
