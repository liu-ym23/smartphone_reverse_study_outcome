package org.chromium;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.ttnet.org.chromium.net.CronetEngine$Builder$LibraryLoader;
import yx5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetClient$3 extends CronetEngine$Builder$LibraryLoader {
    final /* synthetic */ CronetClient this$0;

    public CronetClient$3(CronetClient r1) {
        this.this$0 = r1;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine$Builder$LibraryLoader
    public void loadLibrary(String r7) {
        c r0 = c.h();
        r0.getClass();
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r1 = r0.b;     // Catch: Throwable -> L14
        if (r1 == null) goto L17;
        r1.doLoadLibrary(r7);     // Catch: Throwable -> L14
    L17:
        return;
    L9:
        Object r2 = r0.a;     // Catch: Throwable -> L14
        if (r2 == null) goto L17;
        a.b(r2).call("doLoadLibrary", new Class[]{String.class}, new Object[]{r7});     // Catch: Throwable -> L14
        goto L17
    }
}
