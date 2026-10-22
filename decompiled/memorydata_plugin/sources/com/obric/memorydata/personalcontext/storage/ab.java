package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\r\u001a\u00020\fH\u0016J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/ShortMemoryEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isSupportBulkDelete", "isEnableLazyIndex", "type", "", "getRawDbEntityFromEntityIdList", "", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entitiesIds", "bulkDelete", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ab extends com.obric.memorydata.personalcontext.storage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12341a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/ShortMemoryEntityStorage$Companion;", "", "<init>", "()V", "TAG", "", "BULK_DELETE_LOG_SAMPLE_SIZE", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12341a = new a(null);
    }

    public ab() {
    }

    private static final CharSequence a(com.obric.memorydata.database.entity.d r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return (CharSequence) ZeusTransformUtils.preCheckCast("entityId=" + r2.getEntityId() + ", type=" + r2.getType() + ", packageName=" + r2.getPackageName(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: lambda$a3NQlir68RC99RutqJ96rvH-RCE, reason: not valid java name */
    public static /* synthetic */ CharSequence m1098lambda$a3NQlir68RC99RutqJ96rvHRCE(com.obric.memorydata.database.entity.d r0) {
        return a(r0);
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
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<String> a(List<String> r23, int r24, String r25) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "entitiesIds");
        Intrinsics.checkNotNullParameter(r25, ObricMemoryConstants.KEY_PACKAGE_NAME);
        List<com.obric.memorydata.database.entity.d> r4 = a(r2, r25);
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder().append("bulkDelete, type: ").append(r24).append(", packageName: ").append(r25).append(", entitiesIdsSize: ").append(r2.size()).append(", entitiesSize: ");
        if (r4 == null) goto L5;
        int r7 = r4.size();
    L6:
        StringBuilder r8 = r5.append(r7).append(", sampleEntityIds: ").append(CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), 5)).append(", sampleEntities: ");
        if (r4 == null) goto L11;
        List r9 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), 5);
        if (r9 == null) goto L11;
        String r10 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$ab$a3NQlir68RC99RutqJ96rvHRCE.INSTANCE, 31, null);
    L12:
        IRunLog.a.a(r6, "ShortMemoryEntityStorage", r8.append(r10).toString(), false, 4, null);
        List<es> r11 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().queryByEpisodicIds(r2);
        if (r4 == null) goto L25;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L25;
        Iterator<es> r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L23;
        FileEntity r13 = com.obric.memorydata.personalcontext.util.f.c(((es) ZeusTransformUtils.preCheckCast(r12.next(), es.class, "com.obric.memorydata.plugin")).g());
        if (r13 == null) goto L18;
        MemoryService.INSTANCE.deleteMemoryImage(r13);
        goto L18
    L23:
        return super.a(r2, ((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r4.get(0), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getType(), r25);
    L25:
        return CollectionsKt.emptyList();
    L11:
        r10 = null;
        goto L12
    L5:
        r7 = 0;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityIdListAndPackageName(r1, r3);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a() {
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return false;
    }
}
