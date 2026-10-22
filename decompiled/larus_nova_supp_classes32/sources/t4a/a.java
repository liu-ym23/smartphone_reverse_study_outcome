package t4a;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends c {
    public final int b() {
        Object r0 = this.a.get(LynxResourceModule.CODE_KEY);
        if ((r0 instanceof Number) == true) goto L7;
        return -1;
    L7:
        return ((Number) r0).intValue();
    }

    public a(Map<String, Object> r1) {
        super(r1);
    }
}
