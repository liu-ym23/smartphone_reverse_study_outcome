package com.larus.audioplayer.impl.stream;

import android.media.AudioTrack;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class s implements Runnable {
    public s() {
    }

    public final void a() {
        AudioTrack r0 = AudioStreamPlayer.v;
        if (r0 != null) goto L12;
        PthreadHandlerThreadV2 r1 = AudioStreamPlayer.m;
        if (r1 == null) goto L7;
        r1.interrupt();
    L7:
        Handler r2 = AudioStreamPlayer.n;
        if (r2 == null) goto L10;
        r2.removeCallbacksAndMessages(null);
    L10:
        FLogger.a.i("AudioStreamPlayer", "current player is empty. reset directly!");
        return;
    L12:
        boolean r3 = ThreadMethodProxy.currentThread().isInterrupted();
        boolean r4 = ThreadMethodProxy.isAlive(ThreadMethodProxy.currentThread());
        if (r3 == true) goto L36;
        if (r4 == false) goto L36;
        if (AudioStreamPlayer.h == com.larus.audioplayer.api.stream.StreamPlayerStatus.PLAYING) goto L19;
    L32:
        Handler r5 = AudioStreamPlayer.n;
        if (r5 == null) goto L38;
        r5.postDelayed(this, 500);
        return;
    L38:
        return;
    L19:
        if (r0.getPlaybackHeadPosition() < AudioStreamPlayer.o) goto L32;
        if (AudioStreamPlayer.p == true) goto L32;
        if (((ConcurrentLinkedQueue) AudioStreamPlayer.r).isEmpty() == false) goto L32;
        if (AudioStreamPlayer.q == true) goto L32;
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("watch thread, play finished， total play duration=");
        AudioStreamPlayer r8 = AudioStreamPlayer.a;
        r7.append(AudioStreamPlayer.i(AudioStreamPlayer.j()));
        r6.i("AudioStreamPlayer", r7.toString());
        AudioStreamPlayer.v(com.larus.audioplayer.api.stream.StreamPlayerStatus.FINISH);
        PthreadHandlerThreadV2 r9 = AudioStreamPlayer.m;
        if (r9 == null) goto L29;
        r9.interrupt();
    L29:
        Handler r10 = AudioStreamPlayer.n;
        if (r10 == null) goto L32;
        r10.removeCallbacksAndMessages(null);
    L36:
        FLogger.a.i("AudioStreamPlayer", "stop current watch thread isThreadInterrupt=" + r3 + " isThreadAlive=" + r4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
