package com.obric.memorydata.middleware.api.store;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0019\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/middleware/api/store/StoreManager;", "Lcom/obric/memorydata/middleware/api/store/IStoreManager;", "<init>", "()V", "getPersonalStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", ActivityLifecycle.NAME, "", "storeMode", "", "hasInit", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StoreManager implements IStoreManager {
    public static final StoreManager INSTANCE = null;
    private final /* synthetic */ IStoreManager $$delegate_0;

    static {
        INSTANCE = new StoreManager();
    }

    private StoreManager() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IStoreManager.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IStoreManager) ZeusTransformUtils.preCheckCast(r0, IStoreManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.store.IStoreManager
    public IStore getPersonalStore() {
        return this.$$delegate_0.getPersonalStore();
    }

    @Override // com.obric.memorydata.middleware.api.store.IStoreManager
    public IStore getStore(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        return this.$$delegate_0.getStore(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.store.IStoreManager
    public boolean hasInit() {
        return this.$$delegate_0.hasInit();
    }

    @Override // com.obric.memorydata.middleware.api.store.IStoreManager
    public void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.$$delegate_0.init(r4);
    }
}
