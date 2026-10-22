package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r {
    public static final List<String> a = null;
    public static final List<String> b = null;

    public static final class a {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        r6.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        r6.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        r6.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        r6.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((0 * 31) + 0) * 31) + 0) * 31) + 0;
    }

    public final String toString() {
        return "FlowMfaVerifyCompleteStepInfo(scope=null, mfaToken=null, mfaCode=null, useLocalStorage=null)";
    }

    static {
        a = CollectionsKt.listOf(new String[]{"mfa_token", "mfaToken", AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN});
        b = CollectionsKt.listOf(new String[]{"mfa_code", "mfaCode", "code"});
    }
}
