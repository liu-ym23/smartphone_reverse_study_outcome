package com.lynx.tasm.event;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a extends LynxEvent {
    public Map<String, Object> a;

    public String c() {
        return LynxResourceModule.PARAMS_KEY;
    }

    public Map<String, Object> b() {
        return this.a;
    }

    public a(int r2, String r3) {
        super(r2, r3, LynxEvent.LynxEventType.kCustom);
        this.a = new HashMap();
    }

    public final void a(String r2, Object r3) {
        if (this.a != null) goto L5;
        this.a = new HashMap();
    L5:
        this.a.put(r2, r3);
    }

    public a(int r2, String r3, Map<String, Object> r4) {
        super(r2, r3, LynxEvent.LynxEventType.kCustom);
        this.a = r4;
    }
}
