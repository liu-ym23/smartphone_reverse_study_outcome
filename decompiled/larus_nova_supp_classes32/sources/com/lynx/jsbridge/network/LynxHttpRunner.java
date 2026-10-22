package com.lynx.jsbridge.network;

import com.lynx.react.bridge.Callback;
import com.lynx.tasm.service.ILynxHttpService;
import i8a.i;
import i8a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxHttpRunner {

    public static class a extends i {
        public final /* synthetic */ Callback a;

        public a(Callback r1) {
            this.a = r1;
        }

        @Override // i8a.i
        public final void a(HttpResponse r4) {
            this.a.invoke(new Object[]{r4});
        }
    }

    public LynxHttpRunner() {
    }

    public static boolean isHttpServiceRegistered() {
        if (((ILynxHttpService) n.c().a(ILynxHttpService.class)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void request(HttpRequest r2, Callback r3) {
        ILynxHttpService r0 = (ILynxHttpService) n.c().a(ILynxHttpService.class);
        if (r0 != null) goto L6;
        HttpResponse r4 = new HttpResponse();
        r4.a = 499;
        r4.b = "Lynx Http Service not registered";
        r3.invoke(new Object[]{r4});
        return;
    L6:
        r0.request(r2, new a(r3));
    }
}
