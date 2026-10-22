package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Promise f6733b;

    public /* synthetic */ e(Promise r8, int r10) {
        this.f6732a = r10;
        this.f6733b = r8;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r8) {
        int r10 = this.f6732a;
        Promise r11 = this.f6733b;
        switch(r10) {
            case 0: goto L4;
            default: goto L4;
        };
    L4:
        r11.reject((Exception) r8);
    }
}
