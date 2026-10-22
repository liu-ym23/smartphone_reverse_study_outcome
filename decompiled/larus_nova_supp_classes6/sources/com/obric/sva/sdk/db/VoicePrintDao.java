package com.obric.sva.sdk.db;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\b\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/obric/sva/sdk/db/VoicePrintDao;", "", "getVoicePrintInfo", "", "Lcom/obric/sva/sdk/db/SvaVoicePrintControl;", "uuid", "", "getVoicePrintInfos", "clear", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public interface VoicePrintDao {
    void clear();

    List<SvaVoicePrintControl> getVoicePrintInfo(String r1);

    List<SvaVoicePrintControl> getVoicePrintInfos();
}
