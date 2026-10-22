package com.obric.assistant.component;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class y4 implements Function0 {
    public final /* synthetic */ AudioVisualizerOpt a;
    public final /* synthetic */ AudioVisualizerOpt b;
    public final /* synthetic */ OrionChatSpeakerComponent c;

    public /* synthetic */ y4(AudioVisualizerOpt r1, AudioVisualizerOpt r2, OrionChatSpeakerComponent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        AudioVisualizerOpt r0 = this.a;
        AudioVisualizerOpt r1 = this.b;
        OrionChatSpeakerComponent r2 = this.c;
        int r3 = OrionChatSpeakerComponent.x;
        float r5 = 2;
        float r6 = (r0.getWidth() - r1.getVisualizerWidth()) / r5;
        float r4 = (r0.getWidth() + r1.getVisualizerWidth()) / r5;
        boolean r7 = v19.h.a;
        if (v19.h.b(r0.getContext()) == false) goto L5;
        int[] r8 = r2.t;
    L6:
        r0.getPaint().setShader(new LinearGradient(r6, 0.0f, r4, 0.0f, r8, r2.u, Shader.TileMode.CLAMP));
        return Unit.INSTANCE;
    L5:
        r8 = r2.s;
        goto L6
    }
}
