package com.obric.audio.continuous_talk.session.impl;

import android.media.AudioManager;
import android.media.AudioTrack;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q {
    public final String a;
    public AudioTrack b;
    public final int c;
    public final int d;
    public final int e;

    public final void a() {
        int r9 = AudioTrack.getMinBufferSize(this.c, this.d, this.e);     // Catch: Exception -> L21
        if (r9 >= 0) goto L24;
        com.larus.audio.call.util.e.a.e(this.a, "getMinBufferSize failed: " + r9);     // Catch: Exception -> L21
        return;
    L24:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(Integer.valueOf(AudioManager.class.getField("STREAM_ASSISTANT").getInt(null)));     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r1) == null) goto L15;
        r1 = 3;     // Catch: Exception -> L21
    L15:
        AudioTrack r2 = new AudioTrack(((Number) r1).intValue(), this.c, this.d, this.e, r9, 1);     // Catch: Exception -> L21
        this.b = r2;     // Catch: Exception -> L21
        if (fna.g.d() == true) goto L18;
        r2.play();     // Catch: Exception -> L21
    L19:
        com.larus.audio.call.util.e.a.i(this.a, "SilentAudioTrackPlayer started");     // Catch: Exception -> L21
        return;
    L18:
        r2.play();     // Catch: Exception -> L21
        gna.a.c(r2.hashCode());     // Catch: Exception -> L21
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;     // Catch: Exception -> L21
        r1 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(this.a, "start failed: " + e);
        b();
    }

    public final void b() {
        AudioTrack r3 = this.b;     // Catch: Throwable -> L13 Exception -> L15
        if (r3 != null) goto L6;
    L12:
        this.b = null;
        com.larus.audio.call.util.e.a.i(this.a, "SilentAudioTrackPlayer stopped");
        return;
    L6:
        if (r3.getState() != 1) goto L12;
        if (fna.g.d() == true) goto L10;
        r3.stop();     // Catch: Throwable -> L13 Exception -> L15
    L11:
        r3.release();     // Catch: Throwable -> L13 Exception -> L15
    L10:
        r3.stop();     // Catch: Throwable -> L13 Exception -> L15
        gna.a.a(r3.hashCode());     // Catch: Throwable -> L13 Exception -> L15
    L13:
        th = move-exception;
        this.b = null;
        com.larus.audio.call.util.e.a.i(this.a, "SilentAudioTrackPlayer stopped");
        throw th;
    L15:
        e = move-exception;
        com.larus.audio.call.util.e r4 = com.larus.audio.call.util.e.a;     // Catch: Throwable -> L13
        r4.e(this.a, "stop failed: " + e);     // Catch: Throwable -> L13
        this.b = null;
        r4.i(this.a, "SilentAudioTrackPlayer stopped");
    }

    public q() {
        this.a = "SilentAudioTrackPlayer";
        this.c = 24000;
        this.d = 4;
        this.e = 2;
    }
}
