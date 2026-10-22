package on;

import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxEvent$LynxEventType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c {
    public Map g;

    public b(int r5, String r10) {
        super(r5, r10, LynxEvent$LynxEventType.f10840b);
        this.g = new HashMap();
    }

    public final void a(String r5, Object r10) {
        if (this.g != null) goto L5;
        this.g = new HashMap();
    L5:
        this.g.put(r5, r10);
    }

    public Map b() {
        return this.g;
    }

    public String c() {
        return LynxResourceModule.PARAMS_KEY;
    }

    public b(int r5, String r10, Map r11) {
        super(r5, r10, LynxEvent$LynxEventType.f10840b);
        this.g = r11;
    }
}
