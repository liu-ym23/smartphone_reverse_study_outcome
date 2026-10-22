package com.obric.memorydata.personalcontext.collector;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/EntityTypeRestrictedSyncDataSupplier;", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "supportedType", "", "delegate", "<init>", "(ILcom/obric/capabilitykit/sync/EntitySyncDataSupplier;)V", "provideSampleEntities", "", "Lcom/obric/capabilitykit/sync/EntityIdData;", "getWholeEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "idList", "", "type", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntitySyncDataSupplier f12062b;

    public b(int r3, EntitySyncDataSupplier r4) {
        EntitySyncDataSupplier r5 = (EntitySyncDataSupplier) ZeusTransformUtils.wrapperContextForParams(r4, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.f12061a = r3;
        this.f12062b = r5;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r3, int r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "idList");
        if (r4 == this.f12061a) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return this.f12062b.getWholeEntities(r5, r4);
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        return this.f12062b.provideSampleEntities();
    }
}
