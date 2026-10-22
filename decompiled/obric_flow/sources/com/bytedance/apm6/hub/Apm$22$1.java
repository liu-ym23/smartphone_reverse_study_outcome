package com.bytedance.apm6.hub;

import com.bytedance.services.apm.api.IMonitorLogManager;
import java.util.LinkedList;
import java.util.List;
import oj.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class Apm$22$1 implements IMonitorLogManager {
    final /* synthetic */ a this$0;

    public Apm$22$1(a r5) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String r5, String r10) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long r5, long r10, String r11, e r12) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return (LinkedList) ((al.a) k6.a.j().f18623a).f314b;
    }
}
