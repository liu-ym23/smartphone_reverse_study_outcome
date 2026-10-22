package com.bytedance.bdinstall;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends a implements a1$c {
    public volatile String a;

    public final String c() {
        return this.a;
    }

    public o(o0 r3) {
        a1.a(r3.getContext()).b(r3.a(), "device_token", this);
    }

    public final void a(String r1, u r2) {
        this.a = r1;
    }

    @Override // com.bytedance.bdinstall.a1$c
    public final void b(String r1, String r2) {
        this.a = r1;
    }
}
