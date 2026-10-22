package com.ss.android.lark.flow.chat.message.block.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements FlowAudioWaveView.b {
    public final /* synthetic */ FlowAudioPlayBar a;

    public c(FlowAudioPlayBar r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView.b
    public final void a(FlowAudioWaveView r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        FlowAudioPlayBar.b r0 = this.a.getAudioPlayBarListener();
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView.b
    public final void c(FlowAudioWaveView r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        FlowAudioPlayBar.b r0 = this.a.getAudioPlayBarListener();
        if (r0 == null) goto L6;
        r0.c(r2, r3);
        return;
    }

    @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView.b
    public final void d(FlowAudioWaveView r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        FlowAudioPlayBar.b r0 = this.a.getAudioPlayBarListener();
        if (r0 == null) goto L6;
        r0.d(r2, r3);
        return;
    }
}
