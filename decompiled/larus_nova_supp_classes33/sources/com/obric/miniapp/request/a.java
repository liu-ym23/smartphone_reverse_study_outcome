package com.obric.miniapp.request;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final boolean a(AIBridgeMethod.Error r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getCode() != (-2)) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2.getMessage(), "Function not found") == true) goto L8;
        return false;
    }
}
