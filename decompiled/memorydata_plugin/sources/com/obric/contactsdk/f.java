package com.obric.contactsdk;

import android.content.Context;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f implements EntitySupplier, EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7855a;

    public f(Context r3) {
        this.f7855a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r7.isEmpty() == false) goto L8;
        com.obric.a.a.f r4 = com.obric.a.a.f.f5867a;
        String r8 = "getWholeEntities: idList is empty";
    L5:
        r4.b("ContactEntitySupplier", r8);
        return Collections.emptyList();
    L8:
        if (r6 == 201) goto L10;
        r4 = com.obric.a.a.f.f5867a;
        r8 = "getWholeEntities: unknown entity type: " + r6;
        goto L5
    L10:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r7.iterator();
    L12:
        if (r10.hasNext() == false) goto L17;
        r9.add(Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"))));     // Catch: NumberFormatException -> L18
        goto L12
    L17:
        return new ArrayList(com.obric.contactsdk.loader.e.a(this.f7855a.getContentResolver(), r9, false, false));
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        List<Long> r0 = com.obric.contactsdk.loader.e.a(this.f7855a);
        List<Long> r1 = com.obric.contactsdk.loader.e.c(this.f7855a);
        ArrayList r2 = new ArrayList(com.obric.contactsdk.loader.e.a(this.f7855a.getContentResolver(), r0, false, false));
        r2.addAll(com.obric.contactsdk.loader.e.a(this.f7855a.getContentResolver(), r1, true, false));
        return r2;
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        return com.obric.contactsdk.loader.e.b(this.f7855a);
    }
}
