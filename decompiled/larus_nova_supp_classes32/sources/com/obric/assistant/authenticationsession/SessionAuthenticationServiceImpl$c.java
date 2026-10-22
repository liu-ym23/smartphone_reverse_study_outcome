package com.obric.assistant.authenticationsession;

import com.obric.assistant.n4;
import com.obric.assistant.o4;
import com.obric.assistant.reporter.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SessionAuthenticationServiceImpl$c implements n4 {
    public final AtomicBoolean a;
    public final /* synthetic */ o4 b;
    public final /* synthetic */ n4 c;

    @Override // com.obric.assistant.n4
    public final void onAuthenticationCancelled() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        int r0 = c.a;
        c.a(this.b.c, false);
        this.c.onAuthenticationCancelled();
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationFailed() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        int r0 = c.a;
        c.a(this.b.c, false);
        this.c.onAuthenticationFailed();
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationNotAvailable() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.c.onAuthenticationNotAvailable();
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationPass() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        int r0 = c.a;
        c.a(this.b.c, true);
        this.c.onAuthenticationPass();
    }

    @Override // com.obric.assistant.n4
    public final void onAuthenticationTimeout() {
        if (this.a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        int r0 = c.a;
        c.a(this.b.c, false);
        this.c.onAuthenticationTimeout();
    }

    public SessionAuthenticationServiceImpl$c(o4 r1, n4 r2) {
        this.b = r1;
        this.c = r2;
        this.a = new AtomicBoolean(false);
    }
}
