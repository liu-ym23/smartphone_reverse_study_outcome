package com.obric.aikernel.runtime;

import com.obric.aikernel.core.data.IdlKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final String a(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        return r10 + '#' + r11 + '#' + r12;
    }

    public static final boolean b(String r10, boolean r11, boolean r12, int r13) {
        if (Intrinsics.areEqual(r10, IdlKeys.Method_RunBiz) == false) goto L8;
        if (r11 == false) goto L8;
        if (r12 == false) goto L8;
        if (r13 <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static final boolean c(String r10, boolean r11, boolean r12, boolean r13) {
        if (Intrinsics.areEqual(r10, IdlKeys.Method_RunBiz) == false) goto L8;
        if (r11 == true) goto L6;
        if (r12 == false) goto L8;
    L6:
        if (r13 == false) goto L8;
        return true;
    L8:
        return false;
    }
}
