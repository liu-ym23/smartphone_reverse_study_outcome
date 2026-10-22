package com.obric.memorydata.middleware.api;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/api/DatabaseKeyMigration;", "Lcom/obric/memorydata/middleware/api/IDatabaseKeyMigration;", "<init>", "()V", "writeDatabasePhrase", "", "databaseName", "", "phrase", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatabaseKeyMigration implements IDatabaseKeyMigration {
    public static final DatabaseKeyMigration INSTANCE = null;
    private final /* synthetic */ IDatabaseKeyMigration $$delegate_0;

    static {
        INSTANCE = new DatabaseKeyMigration();
    }

    private DatabaseKeyMigration() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IDatabaseKeyMigration.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IDatabaseKeyMigration) ZeusTransformUtils.preCheckCast(r0, IDatabaseKeyMigration.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.IDatabaseKeyMigration
    public void writeDatabasePhrase(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "databaseName");
        Intrinsics.checkNotNullParameter(r3, "phrase");
        this.$$delegate_0.writeDatabasePhrase(r2, r3);
    }
}
