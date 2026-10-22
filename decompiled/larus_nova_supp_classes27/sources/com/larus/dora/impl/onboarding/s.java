package com.larus.dora.impl.onboarding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements com.larus.platform.api.n0 {
    public final /* synthetic */ r a;

    public final void b(Integer r1, Integer r2) {
    }

    public final void c(int r1) {
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
        g49.d.d("DoraOnboardingBgMusicPlayer", "[realPlayAudio] onCompletion");
        this.a.f = false;
    }

    public final void onRenderStart() {
        g49.d.b("DoraOnboardingBgMusicPlayer", "[realPlayAudio] onRenderStart");
    }

    public s(r r1) {
        this.a = r1;
    }

    public final void a(Integer r1, Integer r2) {
        g49.d.b("DoraOnboardingBgMusicPlayer", "[realPlayAudio] onError");
        this.a.f = false;
    }
}
