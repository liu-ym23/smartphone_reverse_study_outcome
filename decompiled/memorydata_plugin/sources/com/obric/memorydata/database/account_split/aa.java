package com.obric.memorydata.database.account_split;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.dao.UserProfileRawDbDao;
import com.obric.memorydata.database.legacy.dao.be;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/obric/memorydata/database/account_split/RawUserProfileSpec;", "Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec;", "Lcom/obric/memorydata/database/legacy/entity/RawUserProfileEntityOld;", "Lcom/obric/memorydata/database/legacy/backup/entity/BackUpRawUserProfileEntityOld;", "globalDb", "Lcom/obric/memorydata/database/manager/MemoryFrameDb;", "personalDb", "Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;", "<init>", "(Lcom/obric/memorydata/database/manager/MemoryFrameDb;Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;)V", "sourceDao", "Lcom/obric/memorydata/database/legacy/dao/UserProfileRawDbDaoOld;", "getSourceDao", "()Lcom/obric/memorydata/database/legacy/dao/UserProfileRawDbDaoOld;", "targetDao", "Lcom/obric/memorydata/database/dao/UserProfileRawDbDao;", "getTargetDao", "()Lcom/obric/memorydata/database/dao/UserProfileRawDbDao;", "backupDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpRawUserProfileDaoOld;", "getBackupDao", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpRawUserProfileDaoOld;", "hasIndex", "", "getHasIndex", "()Z", "sourceEntityToBackupEntity", AILabCheckPermissionTask.KEY_SOURCE, "userId", "", "backupDbVersion", "", "backupEntityToSourceEntity", "backup", "backupEntityToAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "rawEntityToAppEntity", "raw", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class aa extends l<com.obric.memorydata.database.legacy.entity.y, com.obric.memorydata.database.legacy.backup.a.r> {
    private final be c;
    private final UserProfileRawDbDao d;
    private final com.obric.memorydata.database.legacy.backup.dao.r e;
    private final boolean f;

    public aa(MemoryFrameDb r2, PersonalMemoryFrameDb r3) {
        Intrinsics.checkNotNullParameter(r2, "globalDb");
        Intrinsics.checkNotNullParameter(r3, "personalDb");
        this.c = r2.getUserProfileRawDbDao$database_obricRelease();
        this.d = r3.getUserProfileRawDbDao();
        this.e = r2.getBackUpRawUserProfileDao$database_obricRelease();
        this.f = true;
    }

    @Override // com.obric.memorydata.database.account_split.l
    public /* synthetic */ AppEntity a(com.obric.memorydata.database.backup.a.a r3) {
        return a((com.obric.memorydata.database.legacy.backup.a.r) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.r.class, "com.obric.memorydata.plugin"));
    }

    public AppEntity a(com.obric.memorydata.database.legacy.backup.a.r r2) {
        Intrinsics.checkNotNullParameter(r2, "backup");
        AbstractFakeAppEntity r1 = r2.g();
        if (r1 == null) goto L7;
        return (AppEntity) ZeusTransformUtils.preCheckCast(r1, AppEntity.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.obric.memorydata.database.account_split.l
    public /* synthetic */ com.obric.memorydata.database.backup.a.a a(com.obric.memorydata.database.legacy.entity.y r3, String r4, int r5) {
        return (com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(a2((com.obric.memorydata.database.legacy.entity.y) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.y.class, "com.obric.memorydata.plugin"), r4, r5), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.obric.memorydata.database.legacy.backup.a.r a2(com.obric.memorydata.database.legacy.entity.y r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r10, "userId");
        return new com.obric.memorydata.database.legacy.backup.a.r(0, r9, r10, r11, 1, null);
    }

    public be b() {
        return this.c;
    }

    public UserProfileRawDbDao c() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.account_split.l
    public boolean d() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.account_split.x
    public /* synthetic */ BaseDao e() {
        return (BaseDao) ZeusTransformUtils.preCheckCast(b(), BaseDao.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.account_split.x
    public /* synthetic */ BaseDao f() {
        return (BaseDao) ZeusTransformUtils.preCheckCast(c(), BaseDao.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.account_split.l
    public /* synthetic */ com.obric.memorydata.database.backup.dao.e g() {
        return (com.obric.memorydata.database.backup.dao.e) ZeusTransformUtils.preCheckCast(h(), com.obric.memorydata.database.backup.dao.e.class, "com.obric.memorydata.plugin");
    }

    public com.obric.memorydata.database.legacy.backup.dao.r h() {
        return this.e;
    }
}
