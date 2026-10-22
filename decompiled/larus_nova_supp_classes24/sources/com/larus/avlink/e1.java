package com.larus.avlink;

import com.larus.avlink.activeSummary.SoundPlayManager;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e1 implements SoundPlayManager.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onBegin() {
        DoraWakeupResponseManager r0 = DoraWakeupResponseManager.a;
        final String r1 = this.a;
        final long r2 = this.b;
        DoraWakeupResponseManager.g(new d1(r1, r2));
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onEnd() {
        FLogger.a.i("DoraWakeupResponse", "wakeup response mp3 finished, taskId=" + this.a);
    }

    @Override // com.larus.avlink.activeSummary.SoundPlayManager.b
    public final void onError() {
        DoraWakeupResponseManager r0 = DoraWakeupResponseManager.a;
        final String r1 = this.a;
        final long r2 = this.b;
        DoraWakeupResponseManager.g(new c1(r1, r2));
    }

    public e1(String r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
