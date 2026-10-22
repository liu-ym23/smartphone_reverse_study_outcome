package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.util.Log;
import com.obric.matrix.platform.server.IServerCallback;
import he.i;
import java.util.Iterator;
import rb.q;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultServerCallbackImpl extends IServerCallback.Stub {
    public DefaultServerCallbackImpl() {
    }

    @Override // com.obric.matrix.platform.server.IServerCallback
    public final void a0(int r8, byte[] r10) {
        i.f("onResult(cmd: " + r8 + ", bytes: " + r10 + ").", "msg");
        Iterator<b> r11 = c.f6151c.iterator();
    L4:
        if (r11.hasNext() == false) goto L15;
        b r12 = r11.next();
        if (r10 == null) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L12;
        q r14 = q.f11690t.decode(r10);     // Catch: Exception -> L13
        i.e(r14, "ADAPTER.decode(bytes)");     // Catch: Exception -> L13
        q r15 = r14;     // Catch: Exception -> L13
        r12.a();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        i.f("on notification exception " + Log.getStackTraceString(e), "msg");
        goto L4
    L12:
        throw new IllegalStateException("result bytes is null".toString());     // Catch: Exception -> L13
    L8:
        r13 = false;
        goto L9
    }
}
