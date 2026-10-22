package com.bytedance.bpea.entry.common;

import com.bytedance.bpea.basics.BPEAException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BaseAuthEntry {
    public static final Companion a = null;

    public static final class Companion {
        public Companion() {
        }

        public final <T> T a(qc4.c r2, Function0<? extends T> r3) throws BPEAException {
            d.b(r2);
            return (T) call(r2, null, r3);
        }

        public final <T> T call(qc4.c r1, qc4.d r2, Function0<? extends T> r3) throws BPEAException {
            T r4 = (T) r3.invoke();
            CopyOnWriteArraySet<b> r5 = c.a;
            c.a(r1, BaseAuthEntry$Companion$call$1.INSTANCE);
            return r4;
        L5:
            th = move-exception;
            CopyOnWriteArraySet<b> r6 = c.a;
            c.a(r1, BaseAuthEntry$Companion$call$1.INSTANCE);
            throw th;
        }
    }

    static {
        a = new Companion();
    }
}
