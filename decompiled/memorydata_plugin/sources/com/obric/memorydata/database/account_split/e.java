package com.obric.memorydata.database.account_split;

import com.obric.memorydata.database.dao.AutoMemoryProSlmPersonalInfoDao;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.legacy.entity.AutoMemoryProSlmPersonalInfoEntityOld;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/account_split/AutoMemoryProSlmPersonalInfoSpec;", "Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec;", "Lcom/obric/memorydata/database/legacy/entity/AutoMemoryProSlmPersonalInfoEntityOld;", "Lcom/obric/memorydata/database/legacy/backup/entity/BackUpAutoMemoryProSlmPersonalInfoEntityOld;", "globalDb", "Lcom/obric/memorydata/database/manager/MemoryFrameDb;", "personalDb", "Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;", "<init>", "(Lcom/obric/memorydata/database/manager/MemoryFrameDb;Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;)V", "sourceDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProSlmPersonalInfoDaoOld;", "getSourceDao", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProSlmPersonalInfoDaoOld;", "targetDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProSlmPersonalInfoDao;", "getTargetDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProSlmPersonalInfoDao;", "backupDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryProSlmPersonalInfoDaoOld;", "getBackupDao", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryProSlmPersonalInfoDaoOld;", "hasIndex", "", "getHasIndex", "()Z", "sourceEntityToBackupEntity", AILabCheckPermissionTask.KEY_SOURCE, "userId", "", "backupDbVersion", "", "backupEntityToSourceEntity", "backup", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class e extends l<AutoMemoryProSlmPersonalInfoEntityOld, com.obric.memorydata.database.legacy.backup.a.e> {
    private final com.obric.memorydata.database.legacy.dao.j c;
    private final AutoMemoryProSlmPersonalInfoDao d;
    private final com.obric.memorydata.database.legacy.backup.dao.e e;
    private final boolean f;

    public e(MemoryFrameDb r2, PersonalMemoryFrameDb r3) {
        Intrinsics.checkNotNullParameter(r2, "globalDb");
        Intrinsics.checkNotNullParameter(r3, "personalDb");
        this.c = r2.getAutoMemoryProSlmPersonalInfoDao$database_obricRelease();
        this.d = r3.getAutoMemoryProSlmPersonalInfoDao();
        this.e = r2.getBackUpAutoMemoryProSlmPersonalInfoDao$database_obricRelease();
    }

    @Override // com.obric.memorydata.database.account_split.l
    public /* synthetic */ com.obric.memorydata.database.backup.a.a a(AutoMemoryProSlmPersonalInfoEntityOld r3, String r4, int r5) {
        return (com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(a2((AutoMemoryProSlmPersonalInfoEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSlmPersonalInfoEntityOld.class, "com.obric.memorydata.plugin"), r4, r5), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.obric.memorydata.database.legacy.backup.a.e a2(AutoMemoryProSlmPersonalInfoEntityOld r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r10, "userId");
        return new com.obric.memorydata.database.legacy.backup.a.e(0, r9, r10, r11, 1, null);
    }

    public com.obric.memorydata.database.legacy.dao.j a() {
        return this.c;
    }

    public AutoMemoryProSlmPersonalInfoDao b() {
        return this.d;
    }

    public com.obric.memorydata.database.legacy.backup.dao.e c() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.account_split.l
    public boolean d() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.account_split.x
    public /* synthetic */ BaseDao e() {
        return (BaseDao) ZeusTransformUtils.preCheckCast(a(), BaseDao.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.account_split.x
    public /* synthetic */ BaseDao f() {
        return (BaseDao) ZeusTransformUtils.preCheckCast(b(), BaseDao.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.account_split.l
    public /* synthetic */ com.obric.memorydata.database.backup.dao.e g() {
        return (com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(c(), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin");
    }
}
