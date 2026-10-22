package com.ss.android.ugc.effectmanager.knadapt;

import com.ss.android.ugc.effectmanager.common.listener.IMonitorService;
import java.util.Iterator;
import java.util.Map;
import klc.a;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNMonitorService;", "Lklc/a;", "", "serviceName", "", "status", "", "", "logExtraMap", "", "monitorStatusRate", "Lcom/ss/android/ugc/effectmanager/common/listener/IMonitorService;", "iMonitorService", "Lcom/ss/android/ugc/effectmanager/common/listener/IMonitorService;", "<init>", "(Lcom/ss/android/ugc/effectmanager/common/listener/IMonitorService;)V", "effectmanager_release"}, k = 1, mv = {1, 4, 0})
public final class KNMonitorService implements a {
    private final IMonitorService iMonitorService;

    public KNMonitorService(IMonitorService r1) {
        this.iMonitorService = r1;
    }

    @Override // klc.a
    public void monitorStatusRate(String r4, int r5, Map<String, ? extends Object> r6) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, ? extends Object>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r1 = r7.next();
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L6:
        this.iMonitorService.monitorStatusRate(r4, r5, r0);
    }
}
