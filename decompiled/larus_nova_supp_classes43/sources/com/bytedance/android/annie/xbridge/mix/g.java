package com.bytedance.android.annie.xbridge.mix;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements l {
    public final /* synthetic */ IStatefulToXBridge a;

    public g(IStatefulToXBridge r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.annie.xbridge.mix.l
    public final void a(com.bytedance.ies.web.jsbridge2.f<Object, Object> r10) {
        this.a.c.remove(r10);
    }
}
