package com.obric.memorydata.database.account_split;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.iz;
import com.obric.memorydata.database.legacy.dao.ap;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/obric/memorydata/database/account_split/UnionSemanticMemorySpec;", "Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec;", "Lcom/obric/memorydata/database/legacy/entity/UnionSemanticMemoryEntityOld;", "Lcom/obric/memorydata/database/legacy/backup/entity/BackUpUnionSemanticMemoryEntityOld;", "globalDb", "Lcom/obric/memorydata/database/manager/MemoryFrameDb;", "personalDb", "Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;", "<init>", "(Lcom/obric/memorydata/database/manager/MemoryFrameDb;Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;)V", "sourceDao", "Lcom/obric/memorydata/database/legacy/dao/SemanticMemoryDaoOld;", "getSourceDao", "()Lcom/obric/memorydata/database/legacy/dao/SemanticMemoryDaoOld;", "targetDao", "Lcom/obric/memorydata/database/dao/SemanticMemoryDao;", "getTargetDao", "()Lcom/obric/memorydata/database/dao/SemanticMemoryDao;", "backupDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpUnionSemanticMemoryDaoOld;", "getBackupDao", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpUnionSemanticMemoryDaoOld;", "hasIndex", "", "getHasIndex", "()Z", "sourceEntityToBackupEntity", AILabCheckPermissionTask.KEY_SOURCE, "userId", "", "backupDbVersion", "", "backupEntityToSourceEntity", "backup", "backupEntityToAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "rawEntityToAppEntity", "raw", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ae extends l<com.obric.memorydata.database.legacy.entity.ac, com.obric.memorydata.database.legacy.backup.a.u> {
    private final ap c;
    private final SemanticMemoryDao d;
    private final com.obric.memorydata.database.legacy.backup.dao.u e;
    private final boolean f;

    public ae(MemoryFrameDb r2, final PersonalMemoryFrameDb r3) {
        Intrinsics.checkNotNullParameter(r2, "globalDb");
        Intrinsics.checkNotNullParameter(r3, "personalDb");
        this.c = r2.getSemanticMemoryDao$database_obricRelease();
        this.d = r3.getSemanticMemoryDao();
        this.e = r2.getBackUpUnionSemanticMemoryDao$database_obricRelease();
        this.f = true;
        a(76, 77, new $$Lambda$ae$JKsJHH_Op1RMDj4EC0cCDkYU(r3));
    }

    private static final List a(PersonalMemoryFrameDb r37, List r38) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "sources");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        com.obric.memorydata.database.legacy.entity.ac r4 = (com.obric.memorydata.database.legacy.entity.ac) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.database.legacy.entity.ac.class, "com.obric.memorydata.plugin");
        r2.add(new iz(0, r4.getEntityId(), r4.getCreateTime(), r4.getModifyTime(), r4.getType(), r4.getTimestamp(), r4.getPackageName(), r4.getHashCodeValue(), r4.getUuid(), r4.a(), r4.b(), r4.c(), r4.d(), r4.e(), r4.f(), r4.g(), r4.h(), r4.i(), false, 0.0f, null, false, 0, 0, 16515073, null));
        goto L4
    L6:
        List<iz> r5 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L10;
        r37.getUpdateUnionSemanticMemoryDao().insertAll(r5);
    L10:
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: lambda$JKs-JHH_Op1RM-Dj4EC0cCDkY-U, reason: not valid java name */
    public static /* synthetic */ List m532lambda$JKsJHH_Op1RMDj4EC0cCDkYU(PersonalMemoryFrameDb r0, List r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.database.account_split.l
    public /* synthetic */ AppEntity a(com.obric.memorydata.database.backup.a.a r3) {
        return a((com.obric.memorydata.database.legacy.backup.a.u) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.u.class, "com.obric.memorydata.plugin"));
    }

    public AppEntity a(com.obric.memorydata.database.legacy.backup.a.u r2) {
        Intrinsics.checkNotNullParameter(r2, "backup");
        AbstractFakeAppEntity r1 = r2.g();
        if (r1 == null) goto L7;
        return (AppEntity) ZeusTransformUtils.preCheckCast(r1, AppEntity.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.obric.memorydata.database.account_split.l
    public /* synthetic */ com.obric.memorydata.database.backup.a.a a(com.obric.memorydata.database.legacy.entity.ac r3, String r4, int r5) {
        return (com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(a2((com.obric.memorydata.database.legacy.entity.ac) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.ac.class, "com.obric.memorydata.plugin"), r4, r5), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.obric.memorydata.database.legacy.backup.a.u a2(com.obric.memorydata.database.legacy.entity.ac r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r10, "userId");
        return new com.obric.memorydata.database.legacy.backup.a.u(0, r9, r10, r11, 1, null);
    }

    public ap b() {
        return this.c;
    }

    public SemanticMemoryDao c() {
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

    public com.obric.memorydata.database.legacy.backup.dao.u h() {
        return this.e;
    }
}
