package wia;

import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a0 implements EntitySyncDataSupplier {
    public final EntitySupplier a;
    public Map<EntityIdData, ? extends AppEntity> b;
    public List<? extends AppEntity> c;

    public a0(EntitySupplier r1) {
        this.a = r1;
    }

    public final List<EntityIdData> provideSampleEntities() {
        EntitySupplier r0 = this.a;
        if (r0 == null) goto L5;
        List<? extends AppEntity> r1 = r0.provideAllEntities();
    L6:
        this.c = r1;
        if (r1 == null) goto L13;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L15;
        AppEntity r4 = (AppEntity) r3.next();
        r2.add(new EntityIdData(r4.getId(), r4.getType(), r4.getLastModifiedTime()));
        goto L10
    L15:
        return r2;
    L13:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }

    public final List<AppEntity> getWholeEntities(List<String> r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "idList");
        ArrayList r0 = new ArrayList();
        List<? extends AppEntity> r1 = this.c;
        if (r1 == null) goto L13;
        if (r1 == null) goto L10;
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        AppEntity r5 = (AppEntity) r3;
        r4.put(new EntityIdData(r5.getId(), r5.getType(), r5.getLastModifiedTime()), r3);
    L11:
        this.b = r4;
        this.c = null;
        goto L13
    L10:
        r4 = null;
    L13:
        if (this.b != null) goto L15;
        return r0;
    L15:
        Iterator<T> r14 = r12.iterator();
    L17:
        if (r14.hasNext() == false) goto L24;
        String r6 = (String) r14.next();
        Map<EntityIdData, ? extends AppEntity> r7 = this.b;
        if (r7 == null) goto L17;
        AppEntity r8 = r7.get(new EntityIdData(r6, r13, 0));
        if (r8 == null) goto L17;
        r0.add(r8);
        goto L17
    L24:
        return r0;
    }
}
