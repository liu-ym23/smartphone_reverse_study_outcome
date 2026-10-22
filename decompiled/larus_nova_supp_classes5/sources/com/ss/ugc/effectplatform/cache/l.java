package com.ss.ugc.effectplatform.cache;

import android.content.Context;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l {
    public static final Object a = null;
    public static l b;
    public static final a c = null;

    public static final class a {
        public a() {
        }

        public static l a(Object r1) {
            if (l.b != null) goto L19;
            if (r1 == null) goto L19;
            if ((r1 instanceof Context) == false) goto L19;
            Object r2 = l.a;
            monitor-enter(r2);
        L15:
            th = move-exception;
            throw th;
        L10:
            if (l.b != null) goto L12;
            l.b = new l();     // Catch: Throwable -> L15
        L12:
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(r2);
        L19:
            return l.b;
        }
    }

    public static Pair a() {
        return TuplesKt.to(0, 0L);
    }

    static {
        c = new a();
        a = new Object();
    }

    public l() {
    }
}
