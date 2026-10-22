package swb;

import android.text.TextUtils;
import com.bytedance.ee.bear.libarchive.Archive;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m {
    public static final String a = null;

    public m() {
    }

    static {
        a = m.class.getSimpleName();
    }

    public static int a(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L14:
        return -1;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L14;
    L12:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b(a, "extractAll fails : " + e + "  message:" + e.getMessage());
        goto L14
    L8:
        if (r4.endsWith("/") == true) goto L10;
        r4 = r4 + File.separator;     // Catch: IOException -> L12
    L10:
        return Archive.extractAll(r3, r4, null, 0);
    }
}
