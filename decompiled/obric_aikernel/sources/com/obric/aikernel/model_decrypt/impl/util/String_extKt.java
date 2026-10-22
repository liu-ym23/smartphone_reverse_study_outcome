package com.obric.aikernel.model_decrypt.impl.util;

import com.obric.aikernel.middleware.api.appcontext.AppContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class String_extKt {
    private static final String APP_FILE_DIR = null;

    static {
        APP_FILE_DIR = AppContext.INSTANCE.getContext().getFilesDir().getAbsolutePath();
    }

    public static final String shortFilePath(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = APP_FILE_DIR;
        Intrinsics.checkNotNullExpressionValue(r11, "APP_FILE_DIR");
        if (StringsKt.startsWith$default(r10, r11, false, 2, null) == false) goto L6;
        String r12 = r10.substring(r11.length());
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).substring(startIndex)");
        return r12;
    L6:
        return r10;
    }
}
