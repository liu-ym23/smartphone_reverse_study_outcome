package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ExceptionUtilsKt {
    public static final boolean isProcessCanceledException(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Class<?> r10 = r5.getClass();
    L4:
        if (Intrinsics.areEqual(r10.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException") == true) goto L5;
        r10 = r10.getSuperclass();
        if (r10 != null) goto L4;
        return false;
    L5:
        return true;
    }

    public static final RuntimeException rethrow(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        throw r5;
    }
}
