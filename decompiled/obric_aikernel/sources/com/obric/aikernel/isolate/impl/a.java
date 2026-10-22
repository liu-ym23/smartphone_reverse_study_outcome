package com.obric.aikernel.isolate.impl;

import com.obric.aikernel.middleware.api.store.IStoreManager;
import com.obric.aikernel.middleware.api.store.StoreManager;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4485a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t7.a f4486b = null;

    static {
        f4485a = new a();
        f4486b = IStoreManager.a.a(StoreManager.INSTANCE, "keva_store_debug_settings", 0, 2, null);
    }

    private a() {
    }

    public final t7.a a() {
        return f4486b;
    }
}
