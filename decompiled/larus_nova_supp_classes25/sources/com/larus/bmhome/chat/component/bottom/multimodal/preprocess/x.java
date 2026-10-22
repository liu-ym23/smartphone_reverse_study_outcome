package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x {
    public static final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r2, "image/jpeg") == false) goto L5;
    L16:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, "image/png") == true) goto L16;
        if (Intrinsics.areEqual(r2, "image/jpg") == true) goto L16;
        if (Intrinsics.areEqual(r2, "image/heif") == true) goto L16;
        if (Intrinsics.areEqual(r2, "image/heic") == true) goto L16;
        if (Intrinsics.areEqual(r2, "image/webp") == true) goto L16;
        return false;
    }

    public static final void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        File r2 = new PolarisFileWrapper(r1).getParentFile();
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.exists() == true) goto L9;
        r2.mkdirs();
        return;
    }
}
