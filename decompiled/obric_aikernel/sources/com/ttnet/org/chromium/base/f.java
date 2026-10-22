package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Promise f8410c;

    public /* synthetic */ f(Promise r10) {
        this.f8410c = r10;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r10) {
        this.f8410c.reject((Exception) r10);
    }
}
