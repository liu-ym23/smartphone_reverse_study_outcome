package com.larus.account.saas.core.ttaccount;

import b48.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends ua7.a<ua7.b> {
    public final /* synthetic */ String a;
    public final /* synthetic */ x38.b b;

    public final void onResponse(ua7.b r5) {
        if (r5 == null) goto L6;
        boolean r1 = true;
        if (r5.c != true) goto L6;
    L7:
        String r0 = null;
        if (r1 == false) goto L14;
        CopyOnWriteArraySet r6 = com.larus.account.saas.core.internal.b.a;
        String r7 = this.a;
        Intrinsics.checkNotNullParameter(r7, "platform");
        Iterator r2 = com.larus.account.saas.core.internal.b.a.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        ((x38.f) r2.next()).b(r7);
        goto L11
    L13:
        this.b.b(new g(null));
        return;
    L14:
        x38.b r3 = this.b;
        if (r5 == null) goto L17;
        int r4 = r5.g;
    L18:
        if (r5 == null) goto L20;
        r0 = r5.i;
    L20:
        r3.a(new b48.c(r4, r0));
        return;
    L17:
        r4 = -1;
    L6:
        r1 = false;
        goto L7
    }

    public a(String r1, com.larus.account.saas.jsb.core.g r2) {
        this.a = r1;
        this.b = r2;
    }
}
