package com.bytedance.android.livesdk.debugtools;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FileUtils {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilePatchStatus {
    }

    public static void a() {
        File r0 = s1.getContext().getExternalFilesDir("/live/performance/enterRoom/");
        if (r0 == null) goto L5;
        String r1 = r0.getAbsolutePath();
    L6:
        PolarisFileWrapper r2 = new PolarisFileWrapper(r1);
        if (r2.exists() == true) goto L9;
        return;
    L9:
        if (r2.isDirectory() == false) goto L13;
        b(r2);
        return;
    L13:
        return;
    L5:
        r1 = "";
        goto L6
    }

    public static void b(File r2) {
        File[] r3 = r2.listFiles();
        if (r3 == null) goto L14;
        int r0 = 0;
    L6:
        if (r0 >= r3.length) goto L19;
        if (r3[r0].isFile() == false) goto L11;
        r3[r0].delete();
    L13:
        r3[r0].delete();
        r0 = r0 + 1;
        goto L6
    L11:
        if (r3[r0].isDirectory() == false) goto L13;
        b(r3[r0]);
        goto L13
    L19:
        return;
    }
}
