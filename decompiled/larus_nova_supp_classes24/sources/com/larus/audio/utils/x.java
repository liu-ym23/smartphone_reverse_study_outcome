package com.larus.audio.utils;

import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import p68.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class x implements com.larus.platform.api.n0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ e b;

    public final void b(Integer r1, Integer r2) {
    }

    public final void onCompletion() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlayAudio] complete");
        this.b.onEnd();
        Lazy r2 = MediaResourceManager.a;
        AudioLoadManager r3 = AudioLoadManager.a;
        MediaResourceManager.a(AudioLoadManager.a());
    }

    public final void onPrepare() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlayAudio] onPrepare");
    }

    public final void onPrepared() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlayAudio] onPrepared");
    }

    public final void onRenderStart() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlayAudio] onRenderStart");
        l1.b();
    }

    public final void c(int r4) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlayAudio] onPlaybackStateChanged playbackState:" + r4);
    }

    public final void d(int r4) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlayAudio] onLoadStateChanged loadState:" + r4);
    }

    public final void onVideoStatusException(int r4) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.e("AudioLoadManager", "[realPlayAudio] onVideoStatusException status:" + r4);
    }

    public x(String r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(Integer r4, Integer r5) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.e("AudioLoadManager", "[realPlayAudio] error, wavPath:" + this.a + ", code:" + r4 + ", internalCode:" + r5);
        this.b.onError();
        Lazy r6 = MediaResourceManager.a;
        AudioLoadManager r7 = AudioLoadManager.a;
        MediaResourceManager.a(AudioLoadManager.a());
    }
}
