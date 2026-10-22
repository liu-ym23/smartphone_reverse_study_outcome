package com.obric.livecard.api.impl;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.livecard.api.entity.IslandSession;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/livecard/api/impl/OnTopCardChangedListener;", "Lcom/obric/livecard/api/impl/OnLiveCardServiceDiedListener;", "onTopSessionChanged", "", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public interface OnTopCardChangedListener extends OnLiveCardServiceDiedListener {
    void onTopSessionChanged(IslandSession r1);
}
