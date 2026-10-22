package com.larus.audio.ttsV2;

import com.larus.audio.IFlowTtsClientService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class j implements Runnable {
    public /* synthetic */ j() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().f("onMediaInterrupted by TtsClientManager OnMediaStateChangeListener");
    }
}
