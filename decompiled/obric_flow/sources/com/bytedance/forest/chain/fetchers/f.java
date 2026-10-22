package com.bytedance.forest.chain.fetchers;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GeckoFetcher.AnonymousClass4 f4291a;

    public f(GeckoFetcher.AnonymousClass4 r5) {
        this.f4291a = r5;
    }

    @Override // com.bytedance.forest.chain.fetchers.m
    public final void a(final String r10, Long r11) {
        com.bytedance.forest.utils.d.c(this.f4291a.f4259a.getContext$forest_release().g, 3, GeckoFetcher.TAG, null, null, new GeckoFetcher$fetchAsync$4$1$onUpdateSuccess$1(this, r10), 28);
    }

    @Override // com.bytedance.forest.chain.fetchers.m
    public final void a(final String r10, Throwable r11) {
        com.bytedance.forest.utils.d.c(this.f4291a.f4259a.getContext$forest_release().g, 6, GeckoFetcher.TAG, r11, null, new GeckoFetcher$fetchAsync$4$1$onUpdateFailed$1(this, r10), 20);
    }
}
