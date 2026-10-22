package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.platform.server.IServerCallback;
import he.i;
import java.util.List;
import rb.q;

/* JADX INFO: loaded from: classes2.dex */
public final class CmdManager$sendCMDByBind$1$onResult$2 extends IServerCallback.Stub {
    @Override // com.obric.matrix.platform.server.IServerCallback
    public final void a0(int r8, byte[] r10) {
        i.f(r10, "bytes");
        i.f("invokeAsyn complete 2 cost " + (System.currentTimeMillis() - 0), "msg");
        q r11 = q.f11690t.decode(r10);     // Catch: Exception -> L5
        i.f("onResult() called with: cmd = " + r8 + ", response = " + r11, "msg");     // Catch: Exception -> L5
        i.e(r11, "response");     // Catch: Exception -> L5
        l6.a.p0(r8, r11);     // Catch: Exception -> L5
        i.f("invokeAsyn complete 3 cost " + (System.currentTimeMillis() - 0), "msg");     // Catch: Exception -> L5
        return;
    L5:
        List<Integer> r12 = a.f6148a;
        q.a r13 = new q.a();
        r13.f11701b = -20004;
        r13.f11702c = "receive result exception";
        l6.a.p0(r8, r13.a());
    }
}
