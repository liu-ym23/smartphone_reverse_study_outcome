package sn0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements b.InterfaceC0274b {
    public final /* synthetic */ b a;
    public final /* synthetic */ pn0.d b;
    public final /* synthetic */ pn0.g c;
    public final /* synthetic */ f d;

    @Override // sn0.b.InterfaceC0274b
    public final void onFailed() {
        this.a.d(this.b.e(), "GeckoOfflineResProducer loadReviewList Failed");
        a r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.c(this.b, this.c);
    }

    @Override // sn0.b.InterfaceC0274b
    public final void onSuccess() {
        this.a.d(this.b.e(), "GeckoOfflineResProducer loadReviewList success");
        this.a.e(this.b, this.c, this.d);
    }

    public e(b r1, pn0.d r2, pn0.g r3, f r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
