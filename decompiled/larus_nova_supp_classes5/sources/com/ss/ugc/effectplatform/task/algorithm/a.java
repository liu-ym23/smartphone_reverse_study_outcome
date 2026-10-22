package com.ss.ugc.effectplatform.task.algorithm;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final b a = null;
    public static final z.b<String, b> b = null;
    public static boolean c;
    public static final a d = null;

    public a() {
    }

    static {
        d = new a();
        a = new b();
        b = new z.b(false);
    }

    public final synchronized b a(Effect r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (c == true) goto L8;
        monitor-exit(this);
        return null;
    L8:
        a.a(r2);     // Catch: Throwable -> L11
        b r3 = (b) b.remove(r2.getEffect_id());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r3;
    }

    public final synchronized String b(String r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (c == false) goto L6;
        String r4 = a.c("None", r3);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r4;
    L6:
        monitor-exit(this);
        return "null";
    }

    public final synchronized void c(Effect r5) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (c == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        Logger.INSTANCE.w("JKL", "[EffectBlock][start][" + r5.getName() + "][" + r5.getPanel() + ']');     // Catch: Throwable -> L15
        a.update(r5);     // Catch: Throwable -> L15
        Iterator r0 = b.entrySet().iterator();     // Catch: Throwable -> L15
    L10:
        if (r0.hasNext() == false) goto L12;
        ((b) ((Map.Entry) r0.next()).getValue()).update(r5);     // Catch: Throwable -> L15
        goto L10
    L12:
        b r1 = new b();     // Catch: Throwable -> L15
        r1.a.putAll(a.a);     // Catch: Throwable -> L15
        b.put(r5.getEffect_id(), r1);     // Catch: Throwable -> L15
        monitor-exit(this);
    }
}
