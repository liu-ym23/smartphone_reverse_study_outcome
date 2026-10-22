package com.bytedance.apm6.fd;

import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.util.ListUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public FdEvent(int r3, List<String> r4, boolean r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.fdCount = r3;
        this.fdNames = r6;
        this.isFront = r5;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject createRootJSONObject() {
        JSONObject r0 = new JSONObject();
        r0.put(KEY_FD_COUNT, this.fdCount);     // Catch: Exception -> L7
        if (ListUtils.isEmpty(this.fdNames) == true) goto L6;
        r0.put(KEY_FD_DETAIL, ListUtils.listToString(this.fdNames, "\n"));     // Catch: Exception -> L7
    L6:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraStatus() {
        JSONObject r0 = super.getExtraStatus();
        if (r0 == null) goto L8;
    L5:
        r0.put("is_front", this.isFront);     // Catch: Exception -> L7
    L6:
        return r0;
    L8:
        r0 = new JSONObject();     // Catch: Exception -> L7
        goto L5
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getExtraValues() {
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public JSONObject getFilters() {
        return PerfFilterManager.getInstance().getPerfFiltersJson();
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    public String getServiceName() {
        return PERF_KEY_FD;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }
}
