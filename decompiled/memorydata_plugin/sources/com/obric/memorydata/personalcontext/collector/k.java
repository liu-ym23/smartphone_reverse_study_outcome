package com.obric.memorydata.personalcontext.collector;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0016J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/MultiEntitySyncDataSupplier;", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "subSyncDataSuppliers", "", "<init>", "(Ljava/util/List;)V", "getSubSyncDataSuppliers", "()Ljava/util/List;", "provideSampleEntities", "Lcom/obric/capabilitykit/sync/EntityIdData;", "getWholeEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "idList", "", "type", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k implements EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<EntitySyncDataSupplier> f12075a;

    public k(List<? extends EntitySyncDataSupplier> r3) {
        List<EntitySyncDataSupplier> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "subSyncDataSuppliers");
        this.f12075a = r4;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r5, int r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "idList");
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12075a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(((EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(r4.next(), EntitySyncDataSupplier.class, "com.obric.memorydata.plugin")).getWholeEntities(r7, r6), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        List<EntityIdData> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12075a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(((EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(r4.next(), EntitySyncDataSupplier.class, "com.obric.memorydata.plugin")).provideSampleEntities(), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }
}
