package rn0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements nn0.b.a {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    @Override // nn0.b.a
    public final void onError(Throwable r4) {
        this.a.g.e.a("LayoutConfigResManager", "tryPreloadGeckoRes: load failed, throwable: " + r4, true);
    }

    @Override // nn0.b.a
    public final void onSuccess(String r4) {
        this.a.g.e.a("LayoutConfigResManager", "tryPreloadGeckoRes: load success, filePath: " + r4, true);
    }
}
