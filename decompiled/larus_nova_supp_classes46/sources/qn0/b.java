package qn0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements a.b {
    public final /* synthetic */ a a;
    public final /* synthetic */ pn0.d b;
    public final /* synthetic */ pn0.g c;
    public final /* synthetic */ c d;

    @Override // qn0.a.b
    public final void onFailed() {
        this.a.d(this.b.e(), "GeckoOfflineResProducer loadReviewList Failed");
        sn0.a r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("consumer");
    L5:
        r0.c(this.b, this.c);
    }

    @Override // qn0.a.b
    public final void onSuccess() {
        this.a.d(this.b.e(), "GeckoOfflineResProducer loadReviewList success");
        this.a.f(this.b, this.c, this.d);
    }

    public b(a r1, pn0.d r2, pn0.g r3, c r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
