package com.larus.call_plugins_doubao_common.manager;

import com.larus.audio.AudioServiceDelegate;
import com.larus.platform.api.IVideoController;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l implements com.larus.platform.api.n0 {
    public final /* synthetic */ AudioSoundAppeaseManager a;

    public final void b(Integer r1, Integer r2) {
    }

    public final void d(int r1) {
    }

    public final void onPrepare() {
    }

    public final void onPrepared() {
    }

    public final void onVideoStatusException(int r1) {
    }

    public final void onCompletion() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[realPlayAudio] complete isWakeUp:");
        AudioServiceDelegate r2 = AudioServiceDelegate.a;
        r1.append(r2.e0());
        r0.e("AudioSoundSoothingManager", r1.toString());
        if (Intrinsics.areEqual(this.a.a, com.larus.call_plugins_doubao_common.b.b) == false) goto L10;
        if (r2.e0() == true) goto L10;
        r0.e("AudioSoundSoothingManager", "[realPlayAudio] onCompletion check is not connect try to stop");
        IVideoController r3 = this.a.d();
        if (r3 == null) goto L10;
        r3.stop();
    L10:
        if (this.a.g == false) goto L14;
        r0.i("AudioSoundSoothingManager", "[realPlayAudio] playMusic cancelled due to shouldCancelPlay");
        IVideoController r4 = this.a.d();
        if (r4 == null) goto L14;
        r4.stop();
    L14:
        AudioSoundAppeaseManager r5 = this.a;
        r5.f = r5.a.c;
    }

    public final void onRenderStart() {
        this.a.f = true;
        FLogger.a.e("AudioSoundSoothingManager", "[realPlayAudio] onRenderStart");
    }

    public l(AudioSoundAppeaseManager r1) {
        this.a = r1;
    }

    public final void c(int r3) {
        if (r3 != 0) goto L5;
        this.a.f = false;
        FLogger.a.e("AudioSoundSoothingManager", "[realPlayAudio] PLAYBACK_STATE_STOPPED");
        return;
    }

    public final void a(Integer r2, Integer r3) {
        FLogger.a.e("AudioSoundSoothingManager", "[realPlayAudio] onError");
        this.a.f = false;
    }
}
