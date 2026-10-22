package com.obric.aikernel.middleware.impl.obric;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f4576a;

    public f(b r10) {
        Intrinsics.checkNotNullParameter(r10, "sdk");
        this.f4576a = r10;
    }

    public /* synthetic */ f(b r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = DefaultProcessKeepAliveClientSdk.f4571a;
    L5:
        this(r10);
    }

    @Override // com.obric.aikernel.middleware.impl.obric.a
    public void a(String r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r12, "processName");
        this.f4576a.a(r10, r11, r12);
    }

    @Override // com.obric.aikernel.middleware.impl.obric.a
    public boolean b(String r10, int r11, String r12, long r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r12, "processName");
        Intrinsics.checkNotNullParameter(r14, "reason");
        return this.f4576a.b(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.aikernel.middleware.impl.obric.a
    public boolean c(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        return this.f4576a.c(r10, r11);
    }
}
