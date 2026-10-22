package com.bytedance.android.live.emoji.online;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final String a = null;
    public static final int b = 0;
    public static final c c = null;

    public static final class a implements FilenameFilter {
        public final /* synthetic */ String[] a;

        public a(String[] r1) {
            this.a = r1;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r2, String r3) {
            return !ArraysKt.contains(this.a, StringsKt.removeSuffix(r3, ".zip"));
        }
    }

    public c() {
    }

    static {
        c = new c();
        a = ("/data/data/" + jc1.a.b().getApplicationContext().getPackageName() + '/') + "small_emoji_res/";
        b = LiveResUtil.dp2Px(32.0f);
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "md5");
        return a + r2 + File.separator;
    }

    public static void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "path");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r5);
        if (r0.exists() == true) goto L8;
        return;
    L8:
        if (r0.isDirectory() == false) goto L25;
        File[] r6 = r0.listFiles();
        if (r6 != null) goto L12;
        return;
    L12:
        int r1 = r6.length;
        int r2 = 0;
    L13:
        if (r2 >= r1) goto L19;
        File r3 = r6[r2];
        if (r3.isDirectory() == false) goto L17;
        c(r3.getPath());
    L18:
        r2 = r2 + 1;
        goto L13
    L17:
        r3.delete();
        goto L18
    L19:
        r0.delete();
        return;
    }

    public final synchronized void a(String... r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "whiteMd5");     // Catch: Throwable -> L19
        PolarisFileWrapper r0 = new PolarisFileWrapper(a);     // Catch: Throwable -> L19
        if (r0.exists() == true) goto L6;
    L17:
        monitor-exit(this);
        return;
    L6:
        if (r0.isDirectory() == false) goto L17;
        File[] r6 = r0.listFiles(new a(r5));     // Catch: Throwable -> L19
        int r1 = r6.length;     // Catch: Throwable -> L19
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L15;
        File r3 = r6[r2];     // Catch: Throwable -> L19
        if (r3.isDirectory() == false) goto L13;
        c(r3.getAbsolutePath());     // Catch: Throwable -> L19
    L14:
        r2 = r2 + 1;
        goto L9
    L13:
        r3.delete();     // Catch: Throwable -> L19
        goto L14
    L15:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
