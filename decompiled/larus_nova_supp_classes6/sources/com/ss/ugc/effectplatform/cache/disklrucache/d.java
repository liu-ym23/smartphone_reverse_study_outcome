package com.ss.ugc.effectplatform.cache.disklrucache;

import bytekn.foundation.io.file.e;
import java.io.FileOutputStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d extends e {
    public final e b;
    public final Function0<Unit> c;

    public final void a() {
        this.b.a();     // Catch: Exception -> L4
        return;
    L4:
        this.c.invoke();
    }

    public final void close() {
        this.b.close();     // Catch: Exception -> L4
        return;
    L4:
        this.c.invoke();
    }

    public d(e r1, Function0<Unit> r2) {
        this.b = r1;
        this.c = r2;
        FileOutputStream r3 = r1.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("outputStream");
    L5:
        ((e) this).a = r3;
    }

    public final void b(byte[] r2, int r3) {
        this.b.b(r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        this.c.invoke();
    }
}
