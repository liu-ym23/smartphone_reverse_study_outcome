package com.obric.memorydata.personalcontext.api;

import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0016J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/DefaultEntitySyncDataSupplier;", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "entitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "<init>", "(Lcom/obric/capabilitykit/EntitySupplier;)V", "getEntitySupplier", "()Lcom/obric/capabilitykit/EntitySupplier;", "appEntityMap", "", "Lcom/obric/capabilitykit/sync/EntityIdData;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "appEntityList", "", "provideSampleEntities", "getWholeEntities", "idList", "", "type", "", "buildAppEntityMap", "", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EntitySupplier f12036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<EntityIdData, ? extends AppEntity> f12037b;
    private List<? extends AppEntity> c;

    public b(EntitySupplier r3) {
        this.f12036a = (EntitySupplier) ZeusTransformUtils.wrapperContextForParams(r3, EntitySupplier.class, "com.obric.memorydata.plugin");
    }

    private final void a() {
        List<? extends AppEntity> r0 = this.c;
        if (r0 == null) goto L8;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Map<EntityIdData, ? extends AppEntity> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        Object r4 = r3.next();
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.memorydata.plugin");
        r2.put(new EntityIdData(r5.getId(), r5.getType(), r5.getLastModifiedTime()), r4);
    L9:
        this.f12037b = r2;
        this.c = null;
        return;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "idList");
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (this.c == null) goto L6;
        a();
    L6:
        if (this.f12037b != null) goto L8;
        return r0;
    L8:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r11.hasNext() == false) goto L17;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        Map<EntityIdData, ? extends AppEntity> r3 = this.f12037b;
        if (r3 == null) goto L10;
        AppEntity r4 = (AppEntity) ZeusTransformUtils.preCheckCast(r3.get(new EntityIdData(r2, r9, 0)), AppEntity.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        r0.add(r4);
        goto L10
    L17:
        return r0;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        EntitySupplier r0 = this.f12036a;
        if (r0 == null) goto L5;
        List<AppEntity> r1 = r0.provideAllEntities();
    L6:
        this.c = r1;
        if (r1 == null) goto L14;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L16;
        AppEntity r3 = (AppEntity) ZeusTransformUtils.preCheckCast(r9.next(), AppEntity.class, "com.obric.memorydata.plugin");
        r2.add(new EntityIdData(r3.getId(), r3.getType(), r3.getLastModifiedTime()));
        goto L10
    L16:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L14:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }
}
