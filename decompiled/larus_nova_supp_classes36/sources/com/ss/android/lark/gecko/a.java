package com.ss.android.lark.gecko;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Map<String, String> a;

    /* JADX INFO: renamed from: com.ss.android.lark.gecko.a$a, reason: collision with other inner class name */
    public static final class C0081a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = new HashMap();
    }

    public static boolean a(PolarisFileWrapper r2) {
        if (r2.exists() == true) goto L5;
        return true;
    L5:
        if (r2.isDirectory() == true) goto L7;
        return true;
    L7:
        if (r2.listFiles().length == 1) goto L9;
        return true;
    L9:
        if (TextUtils.isDigitsOnly(r2.getParentFile().getName()) == false) goto L16;
        return false;
    L16:
        return true;
    }
}
