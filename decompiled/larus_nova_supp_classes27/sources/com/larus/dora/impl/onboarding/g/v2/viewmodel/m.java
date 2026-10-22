package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import com.larus.platform.api.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m implements n0 {
    public final /* synthetic */ l a;

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
        g49.d.d("DoraOnboardingBgMusicPlayerV2", "[realPlayAudio] onCompletion");
        this.a.e = false;
    }

    public final void onRenderStart() {
        g49.d.b("DoraOnboardingBgMusicPlayerV2", "[realPlayAudio] onRenderStart");
    }

    public m(l r1) {
        this.a = r1;
    }

    public final void a(Integer r1, Integer r2) {
        g49.d.b("DoraOnboardingBgMusicPlayerV2", "[realPlayAudio] onError");
        this.a.e = false;
    }
}
