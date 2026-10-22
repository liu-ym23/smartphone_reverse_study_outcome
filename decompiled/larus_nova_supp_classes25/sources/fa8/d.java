package fa8;

import com.larus.avlink.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends com.larus.audio.call.play.e {
    public final /* synthetic */ c a;

    public final void onPlayComplete() {
        c r0 = this.a;
        if (r0.x.compareAndSet(false, true) == false) goto L13;
        n1.d("DoraGSiAudioPlayManager", "stop DoraG SI player after play complete");     // Catch: Throwable -> L8
        r0.d(false, false, "dora_g_si_play_complete");     // Catch: Throwable -> L8
        r0.x.set(false);
        return;
    L8:
        th = move-exception;
        r0.x.set(false);
        throw th;
    }

    public d(c r1) {
        this.a = r1;
    }
}
