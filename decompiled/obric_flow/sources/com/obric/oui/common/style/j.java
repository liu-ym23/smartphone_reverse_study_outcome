package com.obric.oui.common.style;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f12507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f12508b = null;

    static {
        f12507a = new ConcurrentHashMap();
        f12508b = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a() {
        ps.a.a("OUISoundEffectHelper", "release");     // Catch: Exception -> L5
        f12507a.clear();     // Catch: Exception -> L5
        f12508b.clear();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ps.a.g("OUISoundEffectHelper", Intrinsics.stringPlus("release Exception: ", e));
    }
}
