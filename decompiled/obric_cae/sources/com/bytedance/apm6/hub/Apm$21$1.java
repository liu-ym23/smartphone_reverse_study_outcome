package com.bytedance.apm6.hub;

import com.bytedance.services.apm.api.IMonitorLogManager;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import u8.d;

/* JADX INFO: loaded from: classes.dex */
class Apm$21$1 implements IMonitorLogManager {
    final /* synthetic */ a this$0;

    public Apm$21$1(a r8) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String r8, String r10) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long r8, long r10, String r11, d r12) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return (LinkedList) p2.a.a().f9934a.f52b;
    }
}
