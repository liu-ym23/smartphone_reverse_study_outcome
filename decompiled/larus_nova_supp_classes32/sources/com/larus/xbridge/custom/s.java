package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s implements tj9.c {
    public final /* synthetic */ IvyBridgeMethod.a a;

    public final void a() {
        IvyBridgeMethod.a r0 = this.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put(LynxResourceModule.CODE_KEY, 0);
        r0.invoke(r1);
    }

    public final void b() {
        IvyBridgeMethod.a r0 = this.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put(LynxResourceModule.CODE_KEY, 1);
        r0.invoke(r1);
    }

    public s(ux7.d.d r1) {
        this.a = r1;
    }
}
