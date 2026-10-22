package com.obric.aikernel.multiproc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final boolean a(boolean r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "currentProcessName");
        Intrinsics.checkNotNullParameter(r12, "llmProcessName");
        if (r10 == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r11, r12) == false) goto L7;
        return true;
    }
}
