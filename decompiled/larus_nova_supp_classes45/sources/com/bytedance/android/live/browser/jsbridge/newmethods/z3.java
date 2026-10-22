package com.bytedance.android.live.browser.jsbridge.newmethods;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z3 implements o60.e {
    public final /* synthetic */ a4 a;

    public z3(a4 r1) {
        this.a = r1;
    }

    @Override // o60.e
    public final void onPermissionDenied(String... r1) {
        this.a.finishWithFailure();
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r1) {
        this.a.k();
    }
}
