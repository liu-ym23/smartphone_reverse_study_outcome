package com.lynx.jsbridge.network;

import com.lynx.jsbridge.i;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.service.ILynxHttpService;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public class LynxHttpRunner {
    @CalledByNative
    public static boolean isHttpServiceRegistered() {
        if (((ILynxHttpService) r.g().e(ILynxHttpService.class)) == null) goto L6;
        return true;
    L6:
        return false;
    }

    @CalledByNative
    public static void request(HttpRequest r5, Callback r10) {
        ILynxHttpService r11 = (ILynxHttpService) r.g().e(ILynxHttpService.class);
        if (r11 != null) goto L6;
        HttpResponse r12 = new HttpResponse();
        r12.f9928a = 499;
        r12.f9929b = "Lynx Http Service not registered";
        r10.invoke(new Object[]{r12});
        return;
    L6:
        r11.request(r5, new i(r10));
    }
}
