package com.bytedance.apm6.hub;

import com.bytedance.services.apm.api.IMonitorLogManager;
import ff7.f;
import java.util.List;
import ks3.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class Apm$23$1 implements IMonitorLogManager {
    final /* synthetic */ o this$0;

    public void deleteLegacyLogByIds(String r1, String r2) {
    }

    public void getLegacyLog(long r1, long r3, String r5, f r6) {
    }

    public List<JSONObject> getRecentUiActionRecords() {
        return a.a().a.a;
    }

    public Apm$23$1(o r1) {
        this.this$0 = r1;
    }
}
