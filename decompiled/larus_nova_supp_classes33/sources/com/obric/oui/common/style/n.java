package com.obric.oui.common.style;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n {
    public static final ConcurrentHashMap<Integer, Integer> a = null;
    public static final Set<Integer> b = null;

    static {
        a = new ConcurrentHashMap();
        b = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a() {
        wma.b.a("OUISoundEffectHelper", "release");     // Catch: Exception -> L5
        a.clear();     // Catch: Exception -> L5
        b.clear();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        wma.b.h("OUISoundEffectHelper", Intrinsics.stringPlus("release Exception: ", e));
    }
}
