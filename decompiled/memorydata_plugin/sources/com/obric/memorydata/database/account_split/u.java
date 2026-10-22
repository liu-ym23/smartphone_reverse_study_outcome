package com.obric.memorydata.database.account_split;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.dao.PendingMemoryCalendarDao;
import com.obric.memorydata.database.legacy.dao.ak;
import com.obric.memorydata.database.legacy.entity.PendingMemoryCalendarOld;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010#\u001a\u00020\u0003H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0002H\u0016J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030)H\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/database/account_split/PendingMemoryCalendarSpec;", "Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec;", "Lcom/obric/memorydata/database/legacy/entity/PendingMemoryCalendarOld;", "Lcom/obric/memorydata/database/legacy/backup/entity/BackUpPendingMemoryCalendarOld;", "globalDb", "Lcom/obric/memorydata/database/manager/MemoryFrameDb;", "personalDb", "Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;", "<init>", "(Lcom/obric/memorydata/database/manager/MemoryFrameDb;Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;)V", "sourceDao", "Lcom/obric/memorydata/database/legacy/dao/PendingMemoryCalendarDaoOld;", "getSourceDao", "()Lcom/obric/memorydata/database/legacy/dao/PendingMemoryCalendarDaoOld;", "targetDao", "Lcom/obric/memorydata/database/dao/PendingMemoryCalendarDao;", "getTargetDao", "()Lcom/obric/memorydata/database/dao/PendingMemoryCalendarDao;", "backupDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpPendingMemoryCalendarDaoOld;", "getBackupDao", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpPendingMemoryCalendarDaoOld;", "hasIndex", "", "getHasIndex", "()Z", "episodicMemoryDao", "Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;", "sourceEntityToBackupEntity", AILabCheckPermissionTask.KEY_SOURCE, "userId", "", "backupDbVersion", "", "backupEntityToSourceEntity", "backup", "backupEntityToAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "rawEntityToAppEntity", "raw", "filterBackupsBeforeRestore", "", "backups", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class u extends l<PendingMemoryCalendarOld, com.obric.memorydata.database.legacy.backup.a.o> {
    private final ak c;
    private final PendingMemoryCalendarDao d;
    private final com.obric.memorydata.database.legacy.backup.dao.o e;
    private final boolean f;
    private final EpisodicMemoryDao g;

    public u(MemoryFrameDb r2, PersonalMemoryFrameDb r3) {
        Intrinsics.checkNotNullParameter(r2, "globalDb");
        Intrinsics.checkNotNullParameter(r3, "personalDb");
        this.c = r2.getPendingMemoryCalendarDao$database_obricRelease();
        this.d = r3.getPendingMemoryCalendarDao();
        this.e = r2.getBackUpPendingMemoryCalendarDao$database_obricRelease();
        this.g = r3.getEpisodicMemoryDao();
    }

    @Override // com.obric.memorydata.database.account_split.l
    public /* synthetic */ AppEntity a(com.obric.memorydata.database.backup.a.a r3) {
        return a((com.obric.memorydata.database.legacy.backup.a.o) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.o.class, "com.obric.memorydata.plugin"));
    }

    public AppEntity a(com.obric.memorydata.database.legacy.backup.a.o r1) {
        Intrinsics.checkNotNullParameter(r1, "backup");
        throw new IllegalStateException("hasIndex=false".toString());
    }

    @Override // com.obric.memorydata.database.account_split.l
    public /* synthetic */ com.obric.memorydata.database.backup.a.a a(PendingMemoryCalendarOld r3, String r4, int r5) {
        return (com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(a2((PendingMemoryCalendarOld) ZeusTransformUtils.preCheckCast(r3, PendingMemoryCalendarOld.class, "com.obric.memorydata.plugin"), r4, r5), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.obric.memorydata.database.legacy.backup.a.o a2(PendingMemoryCalendarOld r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r10, "userId");
        return new com.obric.memorydata.database.legacy.backup.a.o(0, r9, r10, r11, 1, null);
    }

    @Override // com.obric.memorydata.database.account_split.l
    public List<com.obric.memorydata.database.legacy.backup.a.o> a(List<com.obric.memorydata.database.legacy.backup.a.o> r6) {
        List<com.obric.memorydata.database.legacy.backup.a.o> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "backups");
        if (r7.isEmpty() == false) goto L5;
        return r7;
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        String r3 = ((com.obric.memorydata.database.legacy.backup.a.o) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.database.legacy.backup.a.o.class, "com.obric.memorydata.plugin")).f().getMemoryUuid();
        if (r3 == null) goto L7;
        r2.add(r3);
        goto L7
    L11:
        List<String> r4 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        if (r4.isEmpty() == false) goto L14;
        return r7;
    L14:
        HashSet r5 = CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast(this.g.queryExistingUuids(r4), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L16:
        if (r10.hasNext() == false) goto L27;
        Object r11 = r10.next();
        String r12 = ((com.obric.memorydata.database.legacy.backup.a.o) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.database.legacy.backup.a.o.class, "com.obric.memorydata.plugin")).f().getMemoryUuid();
        if (r12 != null) goto L20;
    L23:
        boolean r13 = true;
    L24:
        if (r13 == false) goto L16;
        r9.add(r11);
        goto L16
    L20:
        if (r5.contains(r12) == true) goto L23;
        r13 = false;
        goto L24
    L27:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    }

    public ak b() {
        return this.c;
    }

    public PendingMemoryCalendarDao c() {
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

    public com.obric.memorydata.database.legacy.backup.dao.o h() {
        return this.e;
    }
}
