package com.larus.audio.ttsV2;

import com.larus.audio.IFlowTtsClientService;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ float a;

    public /* synthetic */ k(float r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float r0 = this.a;
        FLogger r1 = FLogger.a;
        TtsClientManager r2 = TtsClientManager.a;
        r1.i("TtsClientManager", "onMediaVolumeChange, volumeFactor: " + r0);
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().setVolume(r0);
    }
}
