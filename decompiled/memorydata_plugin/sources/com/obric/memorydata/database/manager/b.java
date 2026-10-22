package com.obric.memorydata.database.manager;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/manager/DefaultMigrationFailureMarkerStore;", "Lcom/obric/memorydata/database/manager/MigrationFailureMarkerStore;", "<init>", "()V", "read", "", "write", "", EventBody.KEY_VALUE, "clear", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9560a = null;

    static {
        f9560a = new b();
    }

    private b() {
    }

    @Override // com.obric.memorydata.database.manager.g
    public String a() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("l2_mig_migration_10_11_failure");
    }

    @Override // com.obric.memorydata.database.manager.g
    public void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("l2_mig_migration_10_11_failure", r5);
    }

    @Override // com.obric.memorydata.database.manager.g
    public void b() {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{"l2_mig_migration_10_11_failure"});
    }
}
