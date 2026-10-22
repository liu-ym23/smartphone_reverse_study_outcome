package com.obric.aikernel.runtime.utils;

import android.os.DeadSystemException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final boolean a(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof DeadSystemException) == false) goto L6;
        return true;
    L6:
        if ((r10.getCause() instanceof DeadSystemException) == false) goto L9;
        return true;
    L9:
        return Intrinsics.areEqual(r10.getClass().getName(), "android.os.DeadSystemRuntimeException");
    }
}
