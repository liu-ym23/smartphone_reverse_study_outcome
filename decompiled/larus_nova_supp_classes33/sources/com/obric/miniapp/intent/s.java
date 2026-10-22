package com.obric.miniapp.intent;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s {
    public static final s d = null;
    public final int a;
    public final LinkedHashMap<String, String> b;
    public final Map<String, String> c;

    public static final class a {
    }

    static {
        d = new s();
    }

    public s() {
        this.a = 128;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public final synchronized String a(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "localMessageId");     // Catch: Throwable -> L6
        String r3 = (String) ((LinkedHashMap) this.c).get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String b(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "cardId");     // Catch: Throwable -> L6
        String r3 = this.b.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }
}
