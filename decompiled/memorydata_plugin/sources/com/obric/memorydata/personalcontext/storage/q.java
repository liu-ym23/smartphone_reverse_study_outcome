package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ICSProtocolEntity;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.gi;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.ax;
import com.obric.memorydata.database.index.bc;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.EntityManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J&\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/ICSProtocolEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isEnableLazyIndex", "type", "", "onTimeZoneChange", "", "bulkDelete", "", "entitiesIds", "isSupportBulkDelete", "getRawDbEntityFromEntityIdList", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q extends com.obric.memorydata.personalcontext.storage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12347a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/ICSProtocolEntityStorage$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12347a = new a(null);
    }

    public q() {
    }

    private static final Unit b(List r5, String r6) {
        List<String> r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getScheduleRawDbDao().queryScheduleIdsByIcsIdList((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), r6);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        com.obric.memorydata.personalcontext.storage.a r0 = com.obric.memorydata.personalcontext.q.a(com.obric.memorydata.personalcontext.q.f12255a, 401, false, 2, null);
        if (r0 == null) goto L8;
        r0.a(r7, 401, r6);
    L8:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$VISYyOXCHEzyFkK_k5BCXJwbd34(List r0, String r1) {
        return b(r0, r1);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r21, "appEntity");
        if (ZeusTransformUtils.instanceOf(r21, ICSProtocolEntity.class) == true) goto L7;
        return null;
    L7:
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new gi(0, r21.getId(), r21.getCreateTime(), r21.getLastModifiedTime(), r21.getType(), 0, r21.get_packageName(), r21.getHashCodeValue(), null, ((ICSProtocolEntity) ZeusTransformUtils.preCheckCast(r21, ICSProtocolEntity.class, "com.obric.memorydata.plugin")).getDoubaoUid(), ((ICSProtocolEntity) ZeusTransformUtils.preCheckCast(r21, ICSProtocolEntity.class, "com.obric.memorydata.plugin")).getICal(), 289, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getIcsProtocolRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<String> a(List<String> r4, int r5, final String r6) {
        final List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "entitiesIds");
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        RunLog.INSTANCE.debug("ICSProtocolEntityStorage", "bulkDelete ics entities，packageName:" + r6);
        com.obric.memorydata.sdk.d.a(new $$Lambda$q$VISYyOXCHEzyFkK_k5BCXJwbd34(r7, r6));
        return super.a(r7, r5, r6);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getIcsProtocolRawDbDao().queryByEntityIdListAndPackageName(r1, r3);
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

    public final void b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ICSProtocolEntityStorage", "onTimeZoneChange, delete all schedule entities", false, 4, null);
        List<gi> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getIcsProtocolRawDbDao().queryByPackageName(AppInfo.AppletApp.getPackageName());
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        gi r4 = (gi) ZeusTransformUtils.preCheckCast(r3.next(), gi.class, "com.obric.memorydata.plugin");
        r2.add(new cd(0, r4.getId(), r4.getType(), r4.getTimestamp(), r4.getCreateTime(), 0, 0, "parse_ics_protocol_task", "parse_ics_protocol_task", 0, 0, null, false, 0, 0, 32353, null));
        goto L7
    L9:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        ao.a(ao.f9372a, "PUBLIC", CollectionsKt.listOf(new ax.c(402, "parse_ics_protocol_task")), r6, (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"), null, 16, null);
        EntityManager.INSTANCE.launchIndexTask();
    }
}
