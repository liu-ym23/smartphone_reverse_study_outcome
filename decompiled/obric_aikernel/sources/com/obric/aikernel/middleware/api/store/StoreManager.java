package com.obric.aikernel.middleware.api.store;

import android.content.Context;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.IService;
import d4.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class StoreManager implements IStoreManager {
    public static final StoreManager INSTANCE = null;
    private final /* synthetic */ IStoreManager $$delegate_0;

    static {
        INSTANCE = new StoreManager();
    }

    private StoreManager() {
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IStoreManager.class));
        Intrinsics.checkNotNull(r10);
        this.$$delegate_0 = (IStoreManager) r10;
    }

    @Override // com.obric.aikernel.middleware.api.store.IStoreManager
    public t7.a getStore(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return this.$$delegate_0.getStore(r10, r11);
    }

    @Override // com.obric.aikernel.middleware.api.store.IStoreManager
    public boolean hasInit() {
        return this.$$delegate_0.hasInit();
    }

    @Override // com.obric.aikernel.middleware.api.store.IStoreManager
    public void init(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.$$delegate_0.init(r10);
    }
}
