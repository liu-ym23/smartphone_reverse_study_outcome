package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends l {
    public b(HashMap<String, Object> r3) {
        super(r3);
        Double r0 = Double.valueOf(-1.0d);
        m.b(r3, "openTime", r0).doubleValue();
        m.b(r3, "containerInitStart", r0).doubleValue();
        m.b(r3, "containerInitEnd", r0).doubleValue();
        m.b(r3, "prepareTemplateStart", r0).doubleValue();
        m.b(r3, "prepareTemplateEnd", r0).doubleValue();
        if (r3.get("extraTiming") == null) goto L5;
        HashMap r4 = (HashMap) r3.get("extraTiming");
        return;
    L5:
        new HashMap();
    }
}
