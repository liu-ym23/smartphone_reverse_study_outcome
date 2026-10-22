package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class c implements z2b.b {
    public boolean a;
    public final ConcurrentHashMap<String, Boolean> b;
    public final AtomicInteger c;
    public final AtomicInteger d;
    public final AtomicInteger e;
    public final AtomicInteger f;

    public final d c() {
        return new d(this.b.size(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }

    public c() {
        this.a = true;
        this.b = new ConcurrentHashMap(0);
        this.c = new AtomicInteger(0);
        this.d = new AtomicInteger(0);
        this.e = new AtomicInteger(0);
        this.f = new AtomicInteger(0);
    }

    public final void d(AtomicInteger r2) {
        Intrinsics.checkNotNullParameter(r2, "counter");
        if (this.a == true) goto L5;
        return;
    L5:
        r2.getAndIncrement();
    }

    public final void e(String r3) {
        if (this.a == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        return;
    L13:
        this.b.put(r3, Boolean.TRUE);
        return;
    L7:
        if (r3.length() == 0) goto L10;
        r0 = false;
        goto L11
    }
}
