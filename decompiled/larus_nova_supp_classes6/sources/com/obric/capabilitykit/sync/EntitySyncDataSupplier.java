package com.obric.capabilitykit.sync;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "", "getWholeEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "idList", "", "type", "", "provideSampleEntities", "Lcom/obric/capabilitykit/sync/EntityIdData;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public interface EntitySyncDataSupplier {
    List<AppEntity> getWholeEntities(List<String> r1, int r2);

    List<EntityIdData> provideSampleEntities();
}
