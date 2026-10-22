package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.ProactiveSemanticRelevantDataDao;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.fb;
import com.obric.memorydata.database.entity.ij;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u00192\u0006\u0010\u0013\u001a\u00020\u0012H\u0016JF\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\u0006\u0010\"\u001a\u00020\tH\u0016¨\u0006$"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/InfoCommonEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "infoCommonMemoryEntityToRawDbEntity", "Lcom/obric/memorydata/database/entity/RawMemoryEntity;", "index", "getRawDbEntityByAppEntityAndHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "historyEntity", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isSupportBulkDelete", "isEnableLazyIndex", "type", "", "getRawDbEntityFromEntityIdList", "", "entitiesIds", "bulkPreIndex", "", "entityTableDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "appEntitiesById", "", "entities", "isUpdate", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r extends com.obric.memorydata.personalcontext.storage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12348a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/InfoCommonEntityStorage$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12348a = new a(null);
    }

    public r() {
    }

    private final RawMemoryEntity b(AppEntity r4) {
        if (ZeusTransformUtils.instanceOf(r4, InfoCommonMemoryEntity.class) == false) goto L5;
        InfoCommonMemoryEntity r3 = (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r4, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        com.obric.memorydata.database.entity.memoryindex.g r5 = com.obric.memorydata.database.entity.memoryindex.m.a();
        if (r5.isMemoryValid((MemoryEntity) ZeusTransformUtils.preCheckCast(r3, MemoryEntity.class, "com.obric.memorydata.plugin")) == true) goto L12;
        return null;
    L12:
        return r5.toRawMemoryEntity((MemoryEntity) ZeusTransformUtils.preCheckCast(r3, MemoryEntity.class, "com.obric.memorydata.plugin"));
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "appEntity");
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.entity.d a(AppEntity r5, com.obric.memorydata.database.a r6) {
        com.obric.memorydata.database.a r7 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "appEntity");
        if (ZeusTransformUtils.instanceOf(r5, InfoCommonMemoryEntity.class) == false) goto L5;
        InfoCommonMemoryEntity r0 = (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r5, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        ip r1 = iq.a((MemoryEntity) ZeusTransformUtils.preCheckCast(r0, MemoryEntity.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L11;
        return null;
    L11:
        com.obric.memorydata.database.a r4 = a(r5, (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), r7);
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.database.entity.d.class) == true) goto L14;
        return null;
    L14:
        return (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<Long> a(IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r9, Map<String, ? extends AppEntity> r10, List<? extends com.obric.memorydata.database.entity.d> r11, boolean r12) {
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r13 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Map<String, ? extends AppEntity> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        List<? extends com.obric.memorydata.database.entity.d> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "entityTableDao");
        Intrinsics.checkNotNullParameter(r14, "appEntitiesById");
        Intrinsics.checkNotNullParameter(r15, "entities");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if (ZeusTransformUtils.instanceOf(r3, ip.class) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        List r4 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
        long r5 = ij.a();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        ((ip) ZeusTransformUtils.preCheckCast(r6.next(), ip.class, "com.obric.memorydata.plugin")).b(r5);
    L14:
        List<Long> r8 = super.a(r13, r14, r15, r12);
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L16:
        if (r18.hasNext() == false) goto L20;
        Object r7 = r18.next();
        if (ZeusTransformUtils.instanceOf(r7, RawMemoryEntity.class) == false) goto L16;
        r17.add(r7);
        goto L16
    L20:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r19.iterator();
    L22:
        if (r20.hasNext() == false) goto L26;
        fa r21 = fb.a((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r20.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin"));
        if (r21 == null) goto L22;
        r110.add(r21);
        goto L22
    L26:
        List r22 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InfoCommonEntityStorage", "bulkPreIndex isUpdate=" + r12 + " entitiesSize=" + r15.size() + " relevantDataListSize=" + r22.size(), false, 4, null);
        if (r22.isEmpty() == true) goto L37;
        ProactiveSemanticRelevantDataDao r111 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao();
        if (r12 == false) goto L32;
        r111.updateAll(r22);
    L33:
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r23.hasNext() == false) goto L37;
        com.obric.memorydata.database.c.f.f8859a.a((fa) ZeusTransformUtils.preCheckCast(r23.next(), fa.class, "com.obric.memorydata.plugin"));
        goto L35
    L32:
        r111.insertAll(r22);
    L37:
        return r8;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIdListAndPackageName(r1, r3);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a() {
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(AppEntity r12) {
        Intrinsics.checkNotNullParameter(r12, "appEntity");
        RawMemoryEntity r0 = b(r12);
        if (r0 != null) goto L5;
        return false;
    L5:
        ip r2 = iq.a(r0, 0, 1, null);
        if (r2 == null) goto L8;
        com.obric.memorydata.database.a r11 = com.obric.memorydata.personalcontext.storage.a.a((com.obric.memorydata.personalcontext.storage.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.personalcontext.storage.a.class, "com.obric.memorydata.plugin"), r12, (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), null, 4, null);
    L10:
        if (ZeusTransformUtils.instanceOf(r11, ip.class) == false) goto L12;
        ip r13 = (ip) ZeusTransformUtils.preCheckCast(r11, ip.class, "com.obric.memorydata.plugin");
    L13:
        if (r13 != null) goto L15;
        return false;
    L15:
        boolean r14 = ij.a(r13, null, false, 3, null);
        fa r15 = fb.a(r0);
        if (r15 == null) goto L18;
        r15.j();
        com.obric.memorydata.database.c.f.f8859a.a(r15);
    L18:
        return r14;
    L12:
        r13 = null;
        goto L13
    L8:
        r11 = null;
        goto L10
    }
}
