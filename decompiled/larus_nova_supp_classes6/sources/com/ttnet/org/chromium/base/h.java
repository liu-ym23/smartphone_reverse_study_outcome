package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class h implements Callback {
    public /* synthetic */ h() {
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final /* synthetic */ Runnable bind(Object r1) {
        return Callback.-CC.$default$bind(this, r1);
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r1) {
        Promise.c((Exception) r1);
    }
}
