package com.obric.memorydata.personalcontext.collector;

import android.content.ContentResolver;
import android.content.Context;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/ExternalSmsEntitySyncDataSupplier;", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "supportTypes", "", "", "<init>", "(Ljava/util/Set;)V", "provideSampleEntities", "", "Lcom/obric/capabilitykit/sync/EntityIdData;", "getWholeEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "idList", "", "type", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<Integer> f12065a;

    public d(Set<Integer> r3) {
        Set<Integer> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "supportTypes");
        this.f12065a = r4;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r3, int r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "idList");
        if (this.f12065a.contains(Integer.valueOf(r4)) == false) goto L5;
        ContentResolver r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        if (r4 != 101) goto L9;
        com.obric.memorydata.personalcontext.external.message.b r6 = com.obric.memorydata.personalcontext.external.message.b.f12147a;
        Intrinsics.checkNotNull(r2);
        return r6.a(r2, r5);
    L9:
        if (r4 != 201) goto L11;
        com.obric.memorydata.personalcontext.external.c.a r7 = com.obric.memorydata.personalcontext.external.c.a.f12109a;
        Intrinsics.checkNotNull(r2);
        return r7.a(r2, r5);
    L11:
        if (r4 != 202) goto L17;
        com.obric.memorydata.personalcontext.external.b.a r8 = com.obric.memorydata.personalcontext.external.b.a.f12104a;
        Intrinsics.checkNotNull(r2);
        return r8.a(r2, r5);
    L17:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        ContentResolver r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        List<EntityIdData> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (this.f12065a.contains(201) == false) goto L8;
        if (com.obric.memorydata.personalcontext.external.g.f12138a.e() == false) goto L8;
        com.obric.memorydata.personalcontext.external.c.a r3 = com.obric.memorydata.personalcontext.external.c.a.f12109a;
        Intrinsics.checkNotNull(r0);
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r3.b(r0), Collection.class, "com.obric.memorydata.plugin"));
    L8:
        if (this.f12065a.contains(202) == false) goto L13;
        if (com.obric.memorydata.personalcontext.external.g.f12138a.d() == false) goto L13;
        com.obric.memorydata.personalcontext.external.b.a r4 = com.obric.memorydata.personalcontext.external.b.a.f12104a;
        Intrinsics.checkNotNull(r0);
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r4.b(r0), Collection.class, "com.obric.memorydata.plugin"));
    L13:
        if (this.f12065a.contains(101) == true) goto L15;
    L17:
        return r2;
    L15:
        if (com.obric.memorydata.personalcontext.external.g.f12138a.c() == false) goto L17;
        com.obric.memorydata.personalcontext.external.message.b r5 = com.obric.memorydata.personalcontext.external.message.b.f12147a;
        Intrinsics.checkNotNull(r0);
        r2.addAll((Collection) ZeusTransformUtils.preCheckCast(r5.b(r0), Collection.class, "com.obric.memorydata.plugin"));
        goto L17
    }
}
