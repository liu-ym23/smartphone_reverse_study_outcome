package com.obric.assistant.component;

import com.obric.assistant.view.glowui.OverlayerAudioView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a2 implements Function0 {
    public final /* synthetic */ ObricIntercomComponent a;

    public /* synthetic */ a2(ObricIntercomComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricIntercomComponent r0 = this.a;
        int r1 = ObricIntercomComponent.h1;
        OverlayerAudioView r2 = r0.X3();
        float[] r3 = OverlayerAudioView.B;
        r2.h(true);
        return Unit.INSTANCE;
    }
}
