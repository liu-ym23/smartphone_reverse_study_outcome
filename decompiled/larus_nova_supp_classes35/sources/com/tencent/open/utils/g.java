package com.tencent.open.utils;

import android.content.Context;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    private static Context a;

    public static final File e() {
        return a(null);
    }

    public static final Context a() {
        Context r0 = a;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    public static final String b() {
        if (a() != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return a().getPackageName();
    }

    public static final File c() {
        if (a() != null) goto L7;
        return null;
    L7:
        return a().getFilesDir();
    }

    public static final File d() {
        Context r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCacheDir();
    }

    public static final File a(String r1) {
        return m.h(a(), r1);
    }

    public static final void a(Context r0) {
        a = r0;
    }
}
