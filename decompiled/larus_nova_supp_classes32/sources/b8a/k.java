package b8a;

import com.miui.easygo.constant.EasyGoDbTable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k extends l {
    public k(HashMap<String, Object> r10) {
        super(r10);
        Object r1 = r10.get("fsp");
        Double r2 = Double.valueOf(-1.0d);
        if (r1 == null) goto L5;
        HashMap r0 = (HashMap) r10.get("fsp");
    L6:
        m.d(r0, EasyGoDbTable.Server.NAME);
        m.b(r0, "duration", r2).doubleValue();
        m.d(r0, "startTimestampName");
        m.b(r0, "startTimestamp", r2).doubleValue();
        m.d(r0, "endTimestampName");
        m.b(r0, "endTimestamp", r2).doubleValue();
        if (r10.get("lynxFsp") == null) goto L9;
        HashMap r3 = (HashMap) r10.get("lynxFsp");
    L10:
        m.d(r3, EasyGoDbTable.Server.NAME);
        m.b(r3, "duration", r2).doubleValue();
        m.d(r3, "startTimestampName");
        m.b(r3, "startTimestamp", r2).doubleValue();
        m.d(r3, "endTimestampName");
        m.b(r3, "endTimestamp", r2).doubleValue();
        if (r10.get("totalFsp") == null) goto L13;
        HashMap r4 = (HashMap) r10.get("totalFsp");
    L14:
        m.d(r4, EasyGoDbTable.Server.NAME);
        m.b(r4, "duration", r2).doubleValue();
        m.d(r4, "startTimestampName");
        m.b(r4, "startTimestamp", r2).doubleValue();
        m.d(r4, "endTimestampName");
        m.b(r4, "endTimestamp", r2).doubleValue();
        m.d(r10, "fspStatus");
        m.b(r10, "contentFillPercentageX", r2).doubleValue();
        m.b(r10, "contentFillPercentageY", r2).doubleValue();
        m.b(r10, "contentFillPercentageTotalArea", r2).doubleValue();
        m.b(r10, "containerFillPercentageContainerArea", r2).doubleValue();
        return;
    L13:
        r4 = new HashMap();
        goto L14
    L9:
        r3 = new HashMap();
        goto L10
    L5:
        r0 = new HashMap();
        goto L6
    }
}
