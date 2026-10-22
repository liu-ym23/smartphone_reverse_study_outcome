package com.obric.capabilitykit;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class EntityProvider$a implements EntitySupplier {
    public final EntitySyncDataSupplier a;

    public EntityProvider$a(EntitySyncDataSupplier r2) {
        Intrinsics.checkNotNullParameter(r2, "entitySyncDataSupplier");
        this.a = r2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.capabilitykit.EntitySupplier
    public final List<AppEntity> provideAllEntities() {
        List<EntityIdData> r1 = this.a.provideSampleEntities();     // Catch: Throwable -> L28
        if (r1.isEmpty() == true) goto L7;
        ArrayList r2 = new ArrayList();
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<T> r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        Object r5 = r4.next();
        Integer r6 = Integer.valueOf(((EntityIdData) r5).getType());
        Object r7 = r3.get(r6);
        if (r7 != null) goto L14;
        r7 = new ArrayList();
        r3.put(r6, r7);
    L14:
        ((List) r7).add(r5);
        goto L10
    L15:
        Iterator r8 = r3.values().iterator();
    L17:
        if (r8.hasNext() == false) goto L27;
        List r9 = (List) r8.next();
        EntitySyncDataSupplier r10 = this.a;     // Catch: Throwable -> L25
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));     // Catch: Throwable -> L25
        Iterator r12 = r9.iterator();     // Catch: Throwable -> L25
    L21:
        if (r12.hasNext() == false) goto L23;
        r11.add(((EntityIdData) r12.next()).getId());     // Catch: Throwable -> L25
        goto L21
    L23:
        r2.addAll(r10.getWholeEntities(r11, ((EntityIdData) CollectionsKt.first(r9)).getType()));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Logger.INSTANCE.e("EntityProvider", "getWholeEntities failed, type=" + ((EntityIdData) CollectionsKt.first(r9)).getType() + ", requestedSize=" + r9.size() + ", return partial result", th);
        goto L17
    L27:
        return r2;
    L7:
        return CollectionsKt.emptyList();
    L28:
        th = move-exception;
        Logger.INSTANCE.e("EntityProvider", "provideSampleEntities failed, return partial result", th);
        return CollectionsKt.emptyList();
    }
}
