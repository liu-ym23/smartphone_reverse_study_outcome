package com.obric.memorydata.database.manager;

import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.index.y;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0005J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/manager/IndexPendingDbRouter;", "", "<init>", "()V", "DB_TYPE_PUBLIC", "", "DB_TYPE_USER", "userEntityTypes", "", "", "dbTypeOf", "entityType", "pendingDaoOf", "Lcom/obric/memorydata/database/dao/IndexPendingDao;", "pendingDaoByDbType", "dbType", "isInOwnerTransaction", "", "allDbTypes", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9561a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<Integer> f9562b = null;

    static {
        f9561a = new c();
        f9562b = y.f9449a.a();
    }

    private c() {
    }

    public final IndexPendingDao a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "dbType");
        if (Intrinsics.areEqual(r3, "USER") == false) goto L6;
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getIndexPendingDao();
    L6:
        if (Intrinsics.areEqual(r3, "PUBLIC") == false) goto L10;
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getIndexPendingDao();
    L10:
        throw new IllegalArgumentException("unknown index pending dbType: " + r3);
    }

    public final String a(int r1) {
        int r0 = cu.f8996a.a(r1);
        if (f9562b.contains(Integer.valueOf(r0)) == false) goto L5;
        return "USER";
    L5:
        return "PUBLIC";
    }

    public final List<String> a() {
        return CollectionsKt.listOf(new String[]{"PUBLIC", "USER"});
    }

    public final IndexPendingDao b(int r1) {
        return a(a(r1));
    }
}
