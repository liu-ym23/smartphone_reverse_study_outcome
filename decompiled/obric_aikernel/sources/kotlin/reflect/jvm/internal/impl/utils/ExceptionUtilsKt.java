package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ExceptionUtilsKt {
    public static final boolean isProcessCanceledException(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Class<?> r11 = r10.getClass();
    L4:
        if (Intrinsics.areEqual(r11.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException") == true) goto L5;
        r11 = r11.getSuperclass();
        if (r11 != null) goto L4;
        return false;
    L5:
        return true;
    }

    public static final RuntimeException rethrow(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "e");
        throw r10;
    }
}
