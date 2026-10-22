package b8a;

import com.miui.easygo.constant.EasyGoDbTable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o extends n {
    public o(HashMap<String, Object> r10) {
        super(r10);
        Double r0 = Double.valueOf(-1.0d);
        m.b(r10, "reloadBundleStart", r0).doubleValue();
        m.b(r10, "reloadBundleEnd", r0).doubleValue();
        m.b(r10, "reloadBackgroundStart", r0).doubleValue();
        m.b(r10, "reloadBackgroundEnd", r0).doubleValue();
        m.b(r10, "ffiStart", r0).doubleValue();
        m.b(r10, "ffiEnd", r0).doubleValue();
        m.b(r10, "createLynxStart", r0).doubleValue();
        m.b(r10, "createLynxEnd", r0).doubleValue();
        m.b(r10, "loadCoreStart", r0).doubleValue();
        m.b(r10, "loadCoreEnd", r0).doubleValue();
        m.b(r10, "openTime", r0).doubleValue();
        m.b(r10, "containerInitStart", r0).doubleValue();
        m.b(r10, "containerInitEnd", r0).doubleValue();
        m.b(r10, "prepareTemplateStart", r0).doubleValue();
        m.b(r10, "prepareTemplateEnd", r0).doubleValue();
        if (r10.get("fcp") == null) goto L6;
        HashMap r1 = (HashMap) r10.get("fcp");
        m.d(r1, EasyGoDbTable.Server.NAME);
        m.b(r1, "duration", r0).doubleValue();
        m.d(r1, "startTimestampName");
        m.b(r1, "startTimestamp", r0).doubleValue();
        m.d(r1, "endTimestampName");
        m.b(r1, "endTimestamp", r0).doubleValue();
    L6:
        if (r10.get("lynxFcp") == null) goto L8;
        HashMap r2 = (HashMap) r10.get("lynxFcp");
    L9:
        m.d(r2, EasyGoDbTable.Server.NAME);
        m.b(r2, "duration", r0).doubleValue();
        m.d(r2, "startTimestampName");
        m.b(r2, "startTimestamp", r0).doubleValue();
        m.d(r2, "endTimestampName");
        m.b(r2, "endTimestamp", r0).doubleValue();
        if (r10.get("totalFcp") == null) goto L13;
        HashMap r11 = (HashMap) r10.get("totalFcp");
        m.d(r11, EasyGoDbTable.Server.NAME);
        m.b(r11, "duration", r0).doubleValue();
        m.d(r11, "startTimestampName");
        m.b(r11, "startTimestamp", r0).doubleValue();
        m.d(r11, "endTimestampName");
        m.b(r11, "endTimestamp", r0).doubleValue();
        return;
    L13:
        return;
    L8:
        r2 = new HashMap();
        goto L9
    }
}
