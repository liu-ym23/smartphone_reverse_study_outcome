package com.larksuite.tool.image;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class JPEGTool {
    public JPEGTool() {
    }

    public static native int getJpegQuality(byte[] r0);

    public static native int getJpegQualityByPath(String r0);

    private static native int getJpegQualityByPathSafely(String r0);

    public static native boolean isJPEG(byte[] r0);

    static {
        Intrinsics.checkNotNullParameter("JPEG-LIB", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> JPEG-LIB");
        a.c("JPEG-LIB");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> JPEG-LIB");
    }

    public static int a(String r0, boolean r1) {
        if (r1 == false) goto L5;
        return getJpegQualityByPathSafely(r0);
    L5:
        return getJpegQualityByPath(r0);
    }
}
