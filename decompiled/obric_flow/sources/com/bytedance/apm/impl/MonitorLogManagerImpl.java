package com.bytedance.apm.impl;

import al.a;
import com.bytedance.services.apm.api.IMonitorLogManager;
import java.util.LinkedList;
import java.util.List;
import oj.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorLogManagerImpl implements IMonitorLogManager {
    public MonitorLogManagerImpl() {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void deleteLegacyLogByIds(String r5, String r10) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public void getLegacyLog(long r5, long r10, String r11, e r12) {
    }

    @Override // com.bytedance.services.apm.api.IMonitorLogManager
    public List<JSONObject> getRecentUiActionRecords() {
        return (LinkedList) ((a) k6.a.j().f18623a).f314b;
    }
}
