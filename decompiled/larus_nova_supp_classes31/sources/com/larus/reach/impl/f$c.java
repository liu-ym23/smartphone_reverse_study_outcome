package com.larus.reach.impl;

import com.larus.platform.api.ExternalRouteLaunchMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public /* synthetic */ class f$c {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ExternalRouteLaunchMode.values().length];
        r0[ExternalRouteLaunchMode.COLD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r0[ExternalRouteLaunchMode.HOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r0[ExternalRouteLaunchMode.WARM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r0[ExternalRouteLaunchMode.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        a = r0;
    }
}
