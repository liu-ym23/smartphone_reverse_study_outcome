package com.ss.android.lark.passportc.convention;

import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final boolean a(UserSession r2, UserSession r3) {
        if (r2 != null) goto L6;
        if (r3 == null) goto L6;
        return true;
    L6:
        if (r2 == null) goto L10;
        if (r3 != null) goto L10;
        return true;
    L10:
        if (r2 == null) goto L15;
        if (r3 == null) goto L15;
        if (Intrinsics.areEqual(r2.a, r3.a) == true) goto L15;
        return true;
    L15:
        return false;
    }
}
