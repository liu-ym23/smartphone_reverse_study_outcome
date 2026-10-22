package com.larus.audio.repo;

import com.larus.audio.bean.AudioUserConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ AudioUserConfig a;

    public /* synthetic */ c(AudioUserConfig r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioUserConfig r0 = this.a;
        AudioConfigRepo r1 = AudioConfigRepo.a;
        AudioConfigRepo.k(r0);
    }
}
