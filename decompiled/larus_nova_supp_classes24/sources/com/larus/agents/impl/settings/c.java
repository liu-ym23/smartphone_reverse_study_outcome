package com.larus.agents.impl.settings;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "instruction");
        if (r1.length() > 10000) goto L5;
        return true;
    L5:
        return false;
    }
}
