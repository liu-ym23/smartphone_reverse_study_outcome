package org.koin.core.registry;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import wu.b;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final b e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.koin.core.a f21020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f21021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f21022c;
    public final org.koin.core.scope.a d;

    static {
        Intrinsics.checkNotNullParameter("_root_", "name");
        Intrinsics.checkNotNullParameter("_root_", "value");
        e = new b();
    }

    public a(org.koin.core.a r10) {
        Intrinsics.checkNotNullParameter(r10, "_koin");
        this.f21020a = r10;
        HashSet r5 = new HashSet();
        this.f21021b = r5;
        ConcurrentHashMap r11 = new ConcurrentHashMap();
        this.f21022c = r11;
        b r12 = e;
        org.koin.core.scope.a r13 = new org.koin.core.scope.a(r12, "_root_", true, r10);
        this.d = r13;
        r5.add(r12);
        r11.put("_root_", r13);
    }
}
