package com.larus.asr.view;

import com.larus.asr.api.databinding.LarusWidgetSpeakerHandsfreeBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class e1 implements Function1 {
    public final /* synthetic */ h1 a;
    public final /* synthetic */ LarusWidgetSpeakerHandsfreeBinding b;

    public /* synthetic */ e1(h1 r1, LarusWidgetSpeakerHandsfreeBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        h1 r0 = this.a;
        LarusWidgetSpeakerHandsfreeBinding r1 = this.b;
        boolean r4 = ((Boolean) r3).booleanValue();
        r0.getClass();
        h1.f(r1, r4);
        return Unit.INSTANCE;
    }
}
