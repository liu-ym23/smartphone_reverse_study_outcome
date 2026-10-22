package b8a;

import com.miui.easygo.constant.EasyGoDbTable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class n extends l {
    public n(HashMap<String, Object> r10) {
        super(r10);
        m.d(r10, "identifier");
        Double r0 = Double.valueOf(-1.0d);
        m.b(r10, "pipelineStart", r0).doubleValue();
        m.b(r10, "pipelineEnd", r0).doubleValue();
        m.b(r10, "mtsRenderStart", r0).doubleValue();
        m.b(r10, "mtsRenderEnd", r0).doubleValue();
        m.b(r10, "resolveStart", r0).doubleValue();
        m.b(r10, "resolveEnd", r0).doubleValue();
        m.b(r10, "layoutStart", r0).doubleValue();
        m.b(r10, "layoutEnd", r0).doubleValue();
        m.b(r10, "paintingUiOperationExecuteStart", r0).doubleValue();
        m.b(r10, "paintingUiOperationExecuteEnd", r0).doubleValue();
        m.b(r10, "layoutUiOperationExecuteStart", r0).doubleValue();
        m.b(r10, "layoutUiOperationExecuteEnd", r0).doubleValue();
        m.b(r10, "paintEnd", r0).doubleValue();
        if (r10.get("frameworkRenderingTiming") == null) goto L5;
        HashMap r3 = (HashMap) r10.get("frameworkRenderingTiming");
    L7:
        if (r10.get("hostPlatformTiming") == null) goto L9;
        HashMap r4 = (HashMap) r10.get("hostPlatformTiming");
    L10:
        m.d(r4, "hostPlatformType");
        m.b(r4, "measureStart", r0).doubleValue();
        m.b(r4, "measureEnd", r0).doubleValue();
        m.b(r4, "layoutStart", r0).doubleValue();
        m.b(r4, "layoutEnd", r0).doubleValue();
        m.b(r4, "drawStart", r0).doubleValue();
        m.b(r4, "drawEnd", r0).doubleValue();
        if (r10.get("actualFmp") == null) goto L14;
        HashMap r1 = (HashMap) r10.get("actualFmp");
        m.d(r1, EasyGoDbTable.Server.NAME);
        m.b(r1, "duration", r0).doubleValue();
        m.d(r1, "startTimestampName");
        m.b(r1, "startTimestamp", r0).doubleValue();
        m.d(r1, "endTimestampName");
        m.b(r1, "endTimestamp", r0).doubleValue();
    L14:
        if (r10.get("lynxActualFmp") == null) goto L17;
        HashMap r2 = (HashMap) r10.get("lynxActualFmp");
        m.d(r2, EasyGoDbTable.Server.NAME);
        m.b(r2, "duration", r0).doubleValue();
        m.d(r2, "startTimestampName");
        m.b(r2, "startTimestamp", r0).doubleValue();
        m.d(r2, "endTimestampName");
        m.b(r2, "endTimestamp", r0).doubleValue();
    L17:
        if (r10.get("totalActualFmp") == null) goto L20;
        HashMap r11 = (HashMap) r10.get("totalActualFmp");
        m.d(r11, EasyGoDbTable.Server.NAME);
        m.b(r11, "duration", r0).doubleValue();
        m.d(r11, "startTimestampName");
        m.b(r11, "startTimestamp", r0).doubleValue();
        m.d(r11, "endTimestampName");
        m.b(r11, "endTimestamp", r0).doubleValue();
        return;
    L20:
        return;
    L9:
        r4 = new HashMap();
        goto L10
    L5:
        new HashMap();
        goto L7
    }
}
