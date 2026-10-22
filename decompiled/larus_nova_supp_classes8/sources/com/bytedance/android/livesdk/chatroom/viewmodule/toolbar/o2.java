package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2.a;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class o2<BEHAVIOR, DATA extends b, EXTRA extends a> {
    public final Map<String, BEHAVIOR> a;
    public final Function2<DATA, EXTRA, BEHAVIOR> b;

    public static class a {
        public a() {
        }
    }

    public interface b {
        String c();
    }

    public abstract BEHAVIOR b(DATA r1, EXTRA r2, BEHAVIOR r3);

    /* JADX WARN: Multi-variable type inference failed */
    public o2(Function2<? super DATA, ? super EXTRA, ? extends BEHAVIOR> r2) {
        Intrinsics.checkNotNullParameter(r2, "behaviorFactory");
        this.b = r2;
        this.a = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized BEHAVIOR a(DATA r3, EXTRA r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "data");     // Catch: Throwable -> L13
        if (this.a.containsKey(r3.c()) == false) goto L6;
        Object r0 = ((LinkedHashMap) this.a).get(r3.c());     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L13
        BEHAVIOR r5 = (BEHAVIOR) b(r3, r4, r0);
    L11:
        monitor-exit(this);
        return r5;
    L6:
        Object r6 = this.b.invoke(r3, r4);     // Catch: Throwable -> L13
        if (r6 == null) goto L10;
        this.a.put(r3.c(), (BEHAVIOR) r6);     // Catch: Throwable -> L13
        r5 = (BEHAVIOR) r6;
        goto L11
    L10:
        r5 = null;
    L13:
        th = move-exception;
        throw th;
    }
}
