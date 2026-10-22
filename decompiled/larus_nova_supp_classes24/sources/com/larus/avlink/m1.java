package com.larus.avlink;

import com.larus.avlink.activeSummary.SoundPlayManager;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class m1 implements SoundPlayManager.b {
    public m1() {
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onBegin() {
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onError() {
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onEnd() {
        Lazy r0 = DoraWakeupSoundController.a;
        DoraWakeupSoundController.g = false;
    }
}
