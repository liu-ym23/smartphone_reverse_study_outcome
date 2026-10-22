package com.obric.assistant.block.base;

import com.larus.utils.logger.FLogger;
import jc8.a;
import jc8.d;
import jc8.e;
import kc8.y;
import kc8.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class c<T extends jc8.a> extends jc8.b<T> {
    public z d;

    public static final class a {
    }

    static {
    }

    public final String c() {
        return "ObricBaseBlockHolder";
    }

    public final void j() {
        z r0 = this.d;
        if (r0 == null) goto L5;
        z.a.a(r0, null, null, 7);
        return;
    L5:
        FLogger.a.w("ObricBaseBlockHolder", "performLongClick: blockLongClickHandler is null");
    }

    public c() {
    }

    public final d f(T r2) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        return e.d(r2);
    }

    public void g(T r2) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        kc8.b r3 = jc8.c.a(this, kc8.b.class);
        z r0 = null;
        if (r3 == null) goto L5;
        y r4 = r3.a;
    L6:
        if (r4 == null) goto L8;
        r0 = r4.A;
    L8:
        this.d = r0;
        return;
    L5:
        r4 = null;
        goto L6
    }
}
