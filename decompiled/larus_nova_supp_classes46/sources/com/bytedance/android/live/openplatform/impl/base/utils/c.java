package com.bytedance.android.live.openplatform.impl.base.utils;

import android.content.Context;
import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final File a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter("miniapp_cover", "dirName");
        String r0 = Environment.getExternalStorageState();     // Catch: NullPointerException -> L5
    L7:
        if (Intrinsics.areEqual("mounted", r0) == false) goto L16;
        File r1 = r4.getExternalCacheDir();
        Intrinsics.checkNotNull(r1);
        if (r1.exists() == false) goto L11;
    L17:
        if (r1 != null) goto L19;
        r1 = r4.getCacheDir();
    L19:
        Intrinsics.checkNotNull(r1);
        PolarisFileWrapper r5 = new PolarisFileWrapper(r1, "miniapp_cover");
        if (r5.exists() == true) goto L25;
        if (r5.mkdir() == true) goto L25;
        return r1;
    L25:
        return r5;
    L11:
        if (r1.mkdirs() == false) goto L16;
        new PolarisFileWrapper(r1, ".nomedia").createNewFile();     // Catch: IOException -> L15
    L16:
        r1 = null;
    L5:
        r0 = "";
        goto L7
    }
}
