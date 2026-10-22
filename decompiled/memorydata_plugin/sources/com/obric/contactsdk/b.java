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
public class b implements EntitySupplier, EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7850a;

    public b(Context r3) {
        this.f7850a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r7, int r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == false) goto L8;
        com.obric.a.a.f r6 = com.obric.a.a.f.f5867a;
        String r10 = "getWholeEntities: idList is empty";
    L5:
        r6.b("CallHistoryEntitySupplier", r10);
        return Collections.emptyList();
    L8:
        if (r8 == 202) goto L10;
        r6 = com.obric.a.a.f.f5867a;
        r10 = "getWholeEntities: unknown entity type: " + r8;
        goto L5
    L10:
        ArrayList r11 = new ArrayList();
        int r0 = 0;
        Iterator r3 = r9.iterator();
    L12:
        if (r3.hasNext() == false) goto L17;
        r11.add(Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"))));     // Catch: NumberFormatException -> L16
    L16:
        r0 = r0 + 1;
        goto L12
    L17:
        com.obric.a.a.f.f5867a.b("CallHistoryEntitySupplier", "getWholeEntities: idListSize=" + r9.size() + ", longIdsSize=" + r11.size() + ", invalidIdSize=" + r0);
        return new ArrayList(com.obric.contactsdk.loader.d.a(this.f7850a.getContentResolver(), r11, this.f7850a));
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        List<Long> r0 = com.obric.contactsdk.loader.d.a(this.f7850a);
        return new ArrayList(com.obric.contactsdk.loader.d.a(this.f7850a.getContentResolver(), r0, this.f7850a));
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        return com.obric.contactsdk.loader.d.b(this.f7850a);
    }
}
