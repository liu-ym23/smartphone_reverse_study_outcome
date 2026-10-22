package com.obric.common.oea.foundation.animation.builder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l8.a<?> f5619a;

    public c() {
    }

    public static final /* synthetic */ l8.a a(c r10) {
        l8.a<?> r11 = r10.f5619a;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("valueAnimationCommand");
    L5:
        return r11;
    }

    public static final /* synthetic */ void b(c r10, l8.a r11) {
        r10.f5619a = r11;
    }
}
