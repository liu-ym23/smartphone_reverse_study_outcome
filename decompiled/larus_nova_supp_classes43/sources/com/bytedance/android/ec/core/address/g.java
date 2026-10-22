package com.bytedance.android.ec.core.address;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ String a;

    public g(String r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        int r0 = s.a;
        s.b(false, null, this.a, null);
        AddressSDK.g("fetch address list error", (Throwable) r10, 4);
        AddressSDK.h = Boolean.TRUE;
    }
}
