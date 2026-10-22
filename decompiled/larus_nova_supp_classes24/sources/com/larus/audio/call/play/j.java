package com.larus.audio.call.play;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j extends e {
    public long a;
    public long b;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.audio.call.play.e, u68.a.b
    public final void c() {
        if (this.b == 0) goto L5;
        this.a = System.currentTimeMillis() - this.b;
        return;
    L5:
        com.larus.audio.call.util.e.a.e("TTSPrepareTimeRecorder", "firstTTSArriveTime invalid");
    }

    public j() {
    }
}
