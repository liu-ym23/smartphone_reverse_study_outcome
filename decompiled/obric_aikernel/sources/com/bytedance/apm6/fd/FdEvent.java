package com.bytedance.apm6.fd;

import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.util.ListUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FdEvent extends PerfBaseEvent {
    private static final String KEY_FD_COUNT = "fd_count";
    private static final String KEY_FD_DETAIL = "fd_detail";
    private static final String PERF_KEY_FD = "fd";
    private int fdCount;
    private List<String> fdNames;
    private boolean isFront;

    public FdEvent(int r10, List<String> r11, boolean r12) {
        this.fdCount = r10;
        this.fdNames = r11;
        this.isFront = r12;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject createRootJSONObject() {
        JSONObject r10 = new JSONObject();
        r10.put(KEY_FD_COUNT, this.fdCount);     // Catch: Exception -> L7
        if (ListUtils.isEmpty(this.fdNames) == true) goto L6;
        r10.put(KEY_FD_DETAIL, ListUtils.listToString(this.fdNames, "\n"));     // Catch: Exception -> L7
    L6:
        return r10;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraStatus() {
        JSONObject r10 = super.getExtraStatus();
        if (r10 == null) goto L8;
    L5:
        r10.put("is_front", this.isFront);     // Catch: Exception -> L7
    L6:
        return r10;
    L8:
        r10 = new JSONObject();     // Catch: Exception -> L7
        goto L5
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        return PerfFilterManager.getInstance().getPerfFiltersJson();
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return PERF_KEY_FD;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }
}
