package com.obric.memorydata.personalcontext.external;

import android.content.ContentResolver;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u0007\u001a\u00020\bJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H&J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/ExternalEntityDataRequester;", "", "<init>", "()V", "queryEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "contentResolver", "Landroid/content/ContentResolver;", "entityIds", "", "getAllEntities", "getAllEntityIdData", "Lcom/obric/capabilitykit/sync/EntityIdData;", "onQueryEntities", "onGetAllEntities", "onGetAllEntityIdData", "getDonateEntityTypeList", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class h {
    public h() {
    }

    public abstract List<Integer> a();

    public final List<AppEntity> a(ContentResolver r3) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        if (PersonalContextAPI.INSTANCE.allowDonateByLocalSearch(a()) == false) goto L5;
        List<AppEntity> r2 = c(r3);
        g.f12138a.a(r2);
        return r2;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<AppEntity> a(ContentResolver r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        Intrinsics.checkNotNullParameter(r5, "entityIds");
        if (PersonalContextAPI.INSTANCE.allowDonateByLocalSearch(a()) == false) goto L5;
        List<AppEntity> r2 = b(r3, r5);
        g.f12138a.a(r2);
        return r2;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<EntityIdData> b(ContentResolver r3) {
        Intrinsics.checkNotNullParameter(r3, "contentResolver");
        if (PersonalContextAPI.INSTANCE.allowDonateByLocalSearch(a()) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return d(r3);
    }

    public abstract List<AppEntity> b(ContentResolver r1, List<String> r2);

    public abstract List<AppEntity> c(ContentResolver r1);

    public List<EntityIdData> d(ContentResolver r1) {
        Intrinsics.checkNotNullParameter(r1, "contentResolver");
        return CollectionsKt.emptyList();
    }
}
