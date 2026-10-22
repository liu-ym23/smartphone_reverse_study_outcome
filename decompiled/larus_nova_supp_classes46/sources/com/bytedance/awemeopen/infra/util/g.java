package com.bytedance.awemeopen.infra.util;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final void a(Lifecycle r1, j r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "observer");
        r2.a = false;
        r1.addObserver(r2.b);
        r2.a = true;
    }
}
