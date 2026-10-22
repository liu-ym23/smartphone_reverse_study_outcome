package com.lark.kmp.rustclient.internal;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements ThreadFactory {
    public final /* synthetic */ String a;

    public e() {
        this.a = "rust-client-push";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r3) {
        return new PthreadThreadV2(r3, this.a);
    }
}
