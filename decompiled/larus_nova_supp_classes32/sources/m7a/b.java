package m7a;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends com.lynx.tasm.event.a {
    public String b;
    public HashMap<String, Object> c;

    @Override // com.lynx.tasm.event.a
    public final Map<String, Object> b() {
        HashMap<String, Object> r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new HashMap();
    }

    @Override // com.lynx.tasm.event.a
    public final String c() {
        String r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return LynxResourceModule.PARAMS_KEY;
    }

    public b(int r1, String r2) {
        super(r1, r2);
    }
}
