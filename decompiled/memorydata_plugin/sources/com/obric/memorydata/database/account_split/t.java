package com.obric.memorydata.database.account_split;

import com.obric.memorydata.database.dao.BaseDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/account_split/MigrationOnlyTableSpec;", "Lcom/obric/memorydata/database/account_split/PersonalDbSplitTableSpec;", "sourceDao", "Lcom/obric/memorydata/database/dao/BaseDao;", "targetDao", "migrationMarkColumn", "", "<init>", "(Lcom/obric/memorydata/database/dao/BaseDao;Lcom/obric/memorydata/database/dao/BaseDao;Ljava/lang/String;)V", "getSourceDao", "()Lcom/obric/memorydata/database/dao/BaseDao;", "getTargetDao", "getMigrationMarkColumn", "()Ljava/lang/String;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class t extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaseDao<?> f8831a;
    private final BaseDao<?> c;
    private final String d;

    public t(BaseDao<?> r3, BaseDao<?> r4, String r5) {
        BaseDao<?> r6 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r3, BaseDao.class, "com.obric.memorydata.plugin");
        BaseDao<?> r7 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r4, BaseDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "sourceDao");
        Intrinsics.checkNotNullParameter(r7, "targetDao");
        Intrinsics.checkNotNullParameter(r5, "migrationMarkColumn");
        this.f8831a = r6;
        this.c = r7;
        this.d = r5;
    }

    public /* synthetic */ t(BaseDao r2, BaseDao r3, String r4, int r5, DefaultConstructorMarker r6) {
        BaseDao r7 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r2, BaseDao.class, "com.obric.memorydata.plugin");
        BaseDao r8 = (BaseDao) ZeusTransformUtils.wrapperContextForParams(r3, BaseDao.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = "personalDbSplitMigrated";
    L5:
        this(r7, r8, r4);
    }

    @Override // com.obric.memorydata.database.account_split.x
    public BaseDao<?> e() {
        return this.f8831a;
    }

    @Override // com.obric.memorydata.database.account_split.x
    public BaseDao<?> f() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.account_split.x
    public String h_() {
        return this.d;
    }
}
