package com.obric.pap.base;

import android.content.Context;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.File;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class PythonRes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PythonRes f7779a = null;

    static {
        f7779a = new PythonRes();
    }

    private PythonRes() {
    }

    public final void a(Context r11, File r12, String r13, a r14) {
        Intrinsics.checkNotNullParameter(r11, "ctx");
        Intrinsics.checkNotNullParameter(r12, "home");
        Intrinsics.checkNotNullParameter(r13, "additionalAssetHash");
        int[] r10 = PythonHost.f7778a.getVersion();
        File r15 = new File(r12, "python/version");
        File r16 = new File(r12, "python/lib");
        StringBuilder r17 = new StringBuilder();
        r17.append("python");
        int r18 = 0;
        r17.append(r10[0]);
        r17.append('.');
        r17.append(r10[1]);
        r17.append("/site-packages");
        File r19 = new File(r16, r17.toString());
        String r110 = "4cdd853c-2b05-41a0-bfb7-c33cecd8a3a2\n" + r13 + '\n';
        ja.a r111 = ja.a.f9791a;
        if (r111.a(r15, r16, r110) == true) goto L7;
        if (r14 == null) goto L44;
        r14.logD("PythonRes", "builtin packages already up to date");
        return;
    L44:
        return;
    L7:
        if (r14 == null) goto L9;
        r14.logI("PythonRes", "refresh builtin packages under " + r16.getAbsolutePath());
    L9:
        r15.delete();
        r111.b(r16);
        if (r14 != null) goto L39;
    L14:
        r111.e(r11, "pap/packages/python3.13.zip", r12, PythonRes$checkBuiltinPackages$1.INSTANCE);     // Catch: Exception -> L12
        String[] r112 = r11.getAssets().list("pap/packages");     // Catch: Exception -> L12
        if (r112 == null) goto L25;
        int r113 = r112.length;     // Catch: Exception -> L12
    L17:
        if (r18 >= r113) goto L25;
        String r20 = r112[r18];     // Catch: Exception -> L12
        Intrinsics.checkNotNullExpressionValue(r20, ActivityLifecycle.NAME);     // Catch: Exception -> L12
        if (StringsKt.endsWith(r20, "whl", true) == false) goto L24;
        if (r14 == null) goto L23;
        r14.logD("PythonRes", "unpack builtin wheel " + r20);     // Catch: Exception -> L12
    L23:
        ja.a.f9791a.e(r11, "pap/packages/" + r20, r19, PythonRes$checkBuiltinPackages$2$1.INSTANCE);     // Catch: Exception -> L12
    L24:
        r18 = r18 + 1;     // Catch: Exception -> L12
    L25:
        File r114 = r15.getParentFile();     // Catch: Exception -> L12
        if (r114 == null) goto L28;
        r114.mkdirs();     // Catch: Exception -> L12
    L28:
        FilesKt.writeText$default(r15, r110, null, 2, null);     // Catch: Exception -> L12
        if (r14 == null) goto L45;
        r14.logI("PythonRes", "builtin packages ready");     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ja.a.f9791a.b(r16);
        if (r14 == null) goto L38;
        StringBuilder r115 = new StringBuilder();
        r115.append("refresh builtin packages failed: ");
        String r116 = e.getMessage();
        if (r116 != null) goto L37;
        r116 = e.getClass().getSimpleName();
    L37:
        r115.append(r116);
        r14.logE("PythonRes", r115.toString());
    L38:
        throw e;
    L45:
        return;
    L39:
        r14.logD("PythonRes", "unpack builtin python archive python3.13.zip");     // Catch: Exception -> L12
        goto L14
    }

    public final void b(File r10, a r11) {
        Intrinsics.checkNotNullParameter(r10, "home");
        File r12 = new File(r10, "python/version");
        if (r12.exists() == true) goto L8;
        if (r11 == null) goto L14;
        r11.logD("PythonRes", "builtin packages flag already cleared");
        return;
    L14:
        return;
    L8:
        if (r12.delete() == false) goto L11;
        if (r11 == null) goto L15;
        r11.logI("PythonRes", "builtin packages flag cleared");
        return;
    L15:
        return;
    L11:
        if (r11 == null) goto L17;
        r11.logW("PythonRes", "failed to clear builtin packages flag at " + r12.getAbsolutePath());
        return;
    }
}
