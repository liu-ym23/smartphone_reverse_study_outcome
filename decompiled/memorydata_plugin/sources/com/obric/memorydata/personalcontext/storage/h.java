package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/AutoMemoryProEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getRawDbEntityFromEntityIdList", "", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entitiesIds", "isEnableLazyIndex", "type", "", "isSupportBulkDelete", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h extends com.obric.memorydata.personalcontext.storage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12345a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/AutoMemoryProEntityStorage$Companion;", "", "<init>", "()V", "TAG", "", "indexedAutoMemoryProEntity", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a() {
            List<AutoMemoryProEntity> r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryByPackageName("");
            long r1 = System.currentTimeMillis();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProEntityStorage", "indexedAutoMemoryProEntity, entityList size: " + r0.size(), false, 4, null);
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r5 = r3.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            r4.add(AutoMemoryProEntity.copy$default((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r5.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin"), 0, null, 0, 0, 0, null, 0, null, 0, 0, null, null, null, null, null, 0, null, null, null, null, null, 2097151, null));
            goto L4
        L6:
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            AutoMemoryProEntity r7 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r6.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
            r7.setEntityId(String.valueOf(r7.getId()));
            r7.setCreateTime(r7.getTimestamp());
            r7.setModifyTime(r7.getTimestamp());
            r7.setType(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED);
            r7.setPackageName(BuildConfig.LIBRARY_PACKAGE_NAME);
            r7.setId(0);
            com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
            goto L8
        L10:
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r9 = r2.iterator();
        L12:
            if (r9.hasNext() == false) goto L14;
            r8.add(Long.valueOf(((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r9.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin")).getId()));
            goto L12
        L14:
            MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().deleteByRawDbIds((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryProEntityStorage", "indexedAutoMemoryProEntity, cost: " + (System.currentTimeMillis() - r1), false, 4, null);
        }
    }

    static {
        f12345a = new a(null);
    }

    public h() {
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
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryByEntityIdListAndPackageName(r1, r3);
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
