package com.obric.aee.utils;

import androidx.annotation.Keep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class ClassUtils {
    public static final ClassUtils INSTANCE = null;

    static {
        INSTANCE = new ClassUtils();
    }

    private ClassUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Keep
    public final <T> T cast(Object r10, Class<T> r11) {
        Intrinsics.checkNotNullParameter(r11, "clz");
        if (r10 == 0) goto L11;
        if (r11.isInstance(r10) == false) goto L7;
        Object r12 = r10;
    L8:
        if (r12 == null) goto L11;
        return r10;
    L7:
        r12 = null;
    L11:
        return null;
    }
}
