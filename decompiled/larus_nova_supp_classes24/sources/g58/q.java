package g58;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q extends com.larus.audio.call.p {
    @Override // com.larus.audio.call.p
    public final void c(long r1) {
    }

    @Override // com.larus.audio.call.p
    public final void b() {
        FLogger.a.i("AiAsrManager", "Ai note time limit reached, end asr");
        com.larus.audio.ainotes.a.a.a("aiNoteTimeLimitTimer finish");
    }

    public q() {
        super(14400000, 14400000);
    }
}
