package com.ss.android.lark.integrator.im.impl;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class i implements jza.d {
    public final jza.c a;

    @Inject
    public i(jza.c r2) {
        Intrinsics.checkNotNullParameter(r2, "internalFileSecurityService");
        this.a = r2;
    }
}
