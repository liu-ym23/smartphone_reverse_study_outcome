package com.larus.audio.call.play;

import android.media.AudioTrack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements AudioTrack.OnPlaybackPositionUpdateListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onPeriodicNotification(AudioTrack r2) {
        Intrinsics.checkNotNullParameter(r2, "track");
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onMarkerReached(AudioTrack r7) {
        Intrinsics.checkNotNullParameter(r7, "track");
        com.larus.audio.call.util.e r8 = com.larus.audio.call.util.e.a;
        r8.i(this.a.t(), "[" + this.b + "]:onMarkerReached");
        if (this.a.u == true) goto L6;
        r8.i(this.a.t(), "[" + this.b + "]onMarkerReached first frame:" + (System.currentTimeMillis() - this.c) + "ms");
        this.a.u = true;
        this.a.e.c();
        return;
    }

    public d(c r1, long r2) {
        this.a = r1;
        this.b = "tts_start";
        this.c = r2;
    }
}
