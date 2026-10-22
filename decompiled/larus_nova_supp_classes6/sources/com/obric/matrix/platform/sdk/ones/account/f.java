package com.obric.matrix.platform.sdk.ones.account;

import cka.a;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;

    public /* synthetic */ f(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        int r1 = this.b;
        int r2 = r0.hashCode();
        if (r2 == (-1768921665)) goto L40;
        if (r2 == (-819300301)) goto L25;
        if (r2 != 912769140) goto L63;
        if (r0.equals("obric.intent.action.account.STATIC_LOGIN") == false) goto L63;
        Set r3 = g.i;
        monitor-enter(r3);
        Iterator r4 = ((CopyOnWriteArraySet) r3).iterator();     // Catch: Throwable -> L21
    L16:
        if (r4.hasNext() == false) goto L18;
        ((a) r4.next()).a();     // Catch: Throwable -> L21
        goto L16
    L18:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r3);
        return;
    L21:
        th = move-exception;
        throw th;
    L63:
        return;
    L25:
        if (r0.equals("obric.intent.action.account.STATIC_ACCOUNT_INFO_UPDATE") == false) goto L63;
        Set r6 = g.i;
        monitor-enter(r6);
        Iterator r7 = ((CopyOnWriteArraySet) r6).iterator();     // Catch: Throwable -> L36
    L31:
        if (r7.hasNext() == false) goto L33;
        ((a) r7.next()).b();     // Catch: Throwable -> L36
        goto L31
    L33:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r6);
        return;
    L36:
        th = move-exception;
        throw th;
    L40:
        if (r0.equals("obric.intent.action.account.STATIC_LOGOUT") == false) goto L63;
        Set r9 = g.i;
        monitor-enter(r9);
        Iterator r10 = ((CopyOnWriteArraySet) r9).iterator();     // Catch: Throwable -> L51
    L46:
        if (r10.hasNext() == false) goto L48;
        ((a) r10.next()).c(r1);     // Catch: Throwable -> L51
        goto L46
    L48:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L51
        monitor-exit(r9);
        return;
    L51:
        th = move-exception;
        throw th;
    }
}
