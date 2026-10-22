package com.obric.memorydata.middleware.database;

import com.obric.memorydata.middleware.api.IDatabaseKeyMigration;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/database/DatabaseKeyMigration;", "Lcom/obric/memorydata/middleware/api/IDatabaseKeyMigration;", "<init>", "()V", "getInst", "writeDatabasePhrase", "", "databaseName", "", "phrase", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DatabaseKeyMigration implements IDatabaseKeyMigration {
    public static final DatabaseKeyMigration INSTANCE = null;

    static {
        INSTANCE = new DatabaseKeyMigration();
    }

    private DatabaseKeyMigration() {
    }

    @JvmStatic
    public static final DatabaseKeyMigration getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.IDatabaseKeyMigration
    public void writeDatabasePhrase(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "databaseName");
        Intrinsics.checkNotNullParameter(r2, "phrase");
        d.f11652a.a(r1, r2);
    }
}
