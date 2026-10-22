package com.larus.voicecall.impl.plugins;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.AbsAudioPlayManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x extends com.larus.audio.call.play.c {
    public final String x;

    public final boolean q() {
        if (((com.larus.audio.call.play.c) this).p == AbsAudioPlayManager.Wait.COMPLETE) goto L5;
        return true;
    L5:
        return false;
    }

    public final String t() {
        return this.x;
    }

    public x(RealtimeCallParam r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "realtimeCallParam");
        super(r2, r3, r3);
        this.x = "QuicAudioPlayManager" + hashCode();
    }
}
