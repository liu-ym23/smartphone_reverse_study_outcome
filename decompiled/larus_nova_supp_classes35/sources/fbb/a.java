package fbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static boolean a(File r5) {
        if (r5.isDirectory() == false) goto L18;
        String[] r0 = r5.list();
        if (r0 != null) goto L8;
        return true;
    L8:
        int r2 = 0;
    L10:
        if (r2 >= r0.length) goto L16;
        if (a(new PolarisFileWrapper(r5, r0[r2])) == false) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return false;
    L16:
        return r5.delete();
    L18:
        return r5.delete();
    }
}
