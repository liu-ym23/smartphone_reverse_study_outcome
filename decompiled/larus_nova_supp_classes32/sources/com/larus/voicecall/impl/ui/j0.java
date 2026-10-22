package com.larus.voicecall.impl.ui;

import com.larus.voicecall.impl.util.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class j0 implements Runnable {
    public final /* synthetic */ t0.b a;
    public final /* synthetic */ VoiceCallVideoView b;

    public /* synthetic */ j0(t0.b r1, VoiceCallVideoView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VoiceCallVideoView.a(this.a, this.b);
    }
}
