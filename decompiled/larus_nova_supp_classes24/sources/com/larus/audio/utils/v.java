package com.larus.audio.utils;

import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import p68.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class v implements com.larus.platform.api.n0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ e b;
    public final /* synthetic */ String c;

    public final void b(Integer r1, Integer r2) {
    }

    public final void onCompletion() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] complete");
        e r2 = this.b;
        if (r2 == null) goto L5;
        r2.onEnd();
    L5:
        Lazy r3 = MediaResourceManager.a;
        AudioLoadManager r4 = AudioLoadManager.a;
        MediaResourceManager.a(AudioLoadManager.a());
    }

    public final void onPrepare() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] onPrepare");
    }

    public final void onPrepared() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] onPrepared");
    }

    public final void onRenderStart() {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] onRenderStart");
        l1.b();
    }

    public final void c(int r4) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] onPlaybackStateChanged playbackState:" + r4);
    }

    public final void d(int r4) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.i("AudioLoadManager", "[realPlay] onLoadStateChanged loadState:" + r4);
    }

    public final void onVideoStatusException(int r4) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.e("AudioLoadManager", "[realPlay] onVideoStatusException status:" + r4);
    }

    public final void a(Integer r4, Integer r5) {
        FLogger r0 = FLogger.a;
        AudioLoadManager r1 = AudioLoadManager.a;
        r0.e("AudioLoadManager", "[realPlay] error, styleId:" + this.a + ", code:" + r4 + ", internalCode:" + r5);
        e r6 = this.b;
        if (r6 == null) goto L5;
        r6.onEnd();
    L5:
        AudioLoadManager r7 = AudioLoadManager.a;
        AudioLoadManager.f("playFailed", this.a, this.c, "VideoEngine play error");
        Lazy r8 = MediaResourceManager.a;
        MediaResourceManager.a(AudioLoadManager.a());
    }

    public v(String r1, e r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
