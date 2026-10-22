package com.ss.android.lark.conditional.access.auth.v2;

import android.util.LruCache;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Function1<LruCache<String, d>, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public p(int r1, Function1<? super LruCache<String, d>, Unit> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        LruCache r0 = new LruCache(this.a);
        int r1 = (y.d + y.e) - this.a;
        int r2 = 0;
    L4:
        if (r2 >= this.a) goto L12;
        r1 = (r1 + 1) % y.e;
        Pair r3 = y.a(r1);
        if (r3 == null) goto L8;
        d r4 = (d) r3.getSecond();
    L9:
        if (r4 == null) goto L11;
        r0.put(r3.getFirst(), r3.getSecond());
    L11:
        r2 = r2 + 1;
        goto L4
    L8:
        r4 = null;
        goto L9
    L12:
        this.b.invoke(r0);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
