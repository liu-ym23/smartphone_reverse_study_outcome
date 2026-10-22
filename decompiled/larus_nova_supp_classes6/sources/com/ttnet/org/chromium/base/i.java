package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class i implements Callback {
    public final /* synthetic */ Promise a;
    public final /* synthetic */ Function b;

    public /* synthetic */ i(Promise r1, Function r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final /* synthetic */ Runnable bind(Object r1) {
        return Callback.-CC.$default$bind(this, r1);
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r3) {
        Promise.a(this.a, this.b, r3);
    }
}
