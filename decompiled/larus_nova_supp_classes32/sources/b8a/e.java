package b8a;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends l {
    public e(HashMap<String, Object> r4) {
        super(r4);
        m.d(r4, "componentUrl");
        m.d(r4, "mode");
        Double r0 = Double.valueOf(-1.0d);
        m.b(r4, "size", r0).doubleValue();
        Boolean r1 = Boolean.FALSE;
        m.a(r4, "sync", r1).booleanValue();
        m.a(r4, "loadSuccess", r1).booleanValue();
        m.b(r4, "requireStart", r0).doubleValue();
        m.b(r4, "requireEnd", r0).doubleValue();
        m.b(r4, "decodeStart", r0).doubleValue();
        m.b(r4, "decodeEnd", r0).doubleValue();
    }
}
