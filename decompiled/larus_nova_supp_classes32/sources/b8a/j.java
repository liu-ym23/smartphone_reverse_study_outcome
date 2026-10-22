package b8a;

import com.miui.easygo.constant.EasyGoDbTable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j extends l {
    public j(HashMap<String, Object> r10) {
        super(r10);
        Object r1 = r10.get("fcp");
        Double r2 = Double.valueOf(-1.0d);
        if (r1 == null) goto L5;
        HashMap r0 = (HashMap) r10.get("fcp");
    L6:
        m.d(r0, EasyGoDbTable.Server.NAME);
        m.b(r0, "duration", r2).doubleValue();
        m.d(r0, "startTimestampName");
        m.b(r0, "startTimestamp", r2).doubleValue();
        m.d(r0, "endTimestampName");
        m.b(r0, "endTimestamp", r2).doubleValue();
        if (r10.get("lynxFcp") == null) goto L9;
        HashMap r3 = (HashMap) r10.get("lynxFcp");
    L10:
        m.d(r3, EasyGoDbTable.Server.NAME);
        m.b(r3, "duration", r2).doubleValue();
        m.d(r3, "startTimestampName");
        m.b(r3, "startTimestamp", r2).doubleValue();
        m.d(r3, "endTimestampName");
        m.b(r3, "endTimestamp", r2).doubleValue();
        if (r10.get("totalFcp") == null) goto L13;
        HashMap r11 = (HashMap) r10.get("totalFcp");
    L14:
        m.d(r11, EasyGoDbTable.Server.NAME);
        m.b(r11, "duration", r2).doubleValue();
        m.d(r11, "startTimestampName");
        m.b(r11, "startTimestamp", r2).doubleValue();
        m.d(r11, "endTimestampName");
        m.b(r11, "endTimestamp", r2).doubleValue();
        return;
    L13:
        r11 = new HashMap();
        goto L14
    L9:
        r3 = new HashMap();
        goto L10
    L5:
        r0 = new HashMap();
        goto L6
    }
}
