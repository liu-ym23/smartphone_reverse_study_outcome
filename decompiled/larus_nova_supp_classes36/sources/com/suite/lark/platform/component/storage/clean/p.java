package com.suite.lark.platform.component.storage.clean;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p {
    public static final String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "path");
        if (new PolarisFileWrapper(r4).isDirectory() == false) goto L9;
        String r0 = File.separator;
        if (StringsKt.endsWith$default(r4, r0, false, 2, null) == false) goto L8;
        return r4;
    L8:
        return r4 + r0;
    L9:
        return r4;
    }
}
