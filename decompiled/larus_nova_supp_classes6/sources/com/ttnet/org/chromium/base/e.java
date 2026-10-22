package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class e implements Callback {
    public final /* synthetic */ Promise.AsyncFunction a;
    public final /* synthetic */ Promise b;

    public /* synthetic */ e(Promise.AsyncFunction r1, Promise r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final /* synthetic */ Runnable bind(Object r1) {
        return Callback.-CC.$default$bind(this, r1);
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r3) {
        Promise.b(this.a, this.b, r3);
    }
}
