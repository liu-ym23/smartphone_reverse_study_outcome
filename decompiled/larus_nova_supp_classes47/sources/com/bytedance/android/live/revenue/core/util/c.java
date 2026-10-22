package com.bytedance.android.live.revenue.core.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final void a(Class r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceCls");
        throw new IllegalArgumentException("Service not found: " + r3 + "\nPlease ensure that revenue-host-impl module contains service implementation.");
    }
}
