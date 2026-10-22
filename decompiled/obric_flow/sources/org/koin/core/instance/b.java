package org.koin.core.instance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final um.a f21012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final org.koin.core.scope.a f21013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vu.a f21014c;

    public b(um.a r5, org.koin.core.scope.a r10, vu.a r11) {
        Intrinsics.checkNotNullParameter(r5, "logger");
        Intrinsics.checkNotNullParameter(r10, "scope");
        this.f21012a = r5;
        this.f21013b = r10;
        this.f21014c = r11;
    }
}
