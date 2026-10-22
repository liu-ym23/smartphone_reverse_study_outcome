package com.obric.memorydata.personalcontext.collector;

import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/MultiEntitySupplier;", "Lcom/obric/capabilitykit/EntitySupplier;", "subEntitySupplier", "", "<init>", "(Ljava/util/List;)V", "getSubEntitySupplier", "()Ljava/util/List;", "provideAllEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j implements EntitySupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<EntitySupplier> f12074a;

    public j(List<? extends EntitySupplier> r3) {
        List<EntitySupplier> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "subEntitySupplier");
        this.f12074a = r4;
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12074a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(((EntitySupplier) ZeusTransformUtils.preCheckCast(r4.next(), EntitySupplier.class, "com.obric.memorydata.plugin")).provideAllEntities(), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }
}
