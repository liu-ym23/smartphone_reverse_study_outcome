package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import okb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImSdkStorageProxy implements okb.g {
    public static final com.ss.android.lark.storage.a c = null;
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
        c = new com.ss.android.lark.storage.a("IM");
    }

    public final i a() {
        return (i) this.b.getValue();
    }

    public ImSdkStorageProxy() {
        this.a = LazyKt.lazy(new ImSdkStorageProxy$kvStoreOfUser$2(this));
        this.b = LazyKt.lazy(new ImSdkStorageProxy$kvStoreOfDevice$2(this));
    }
}
