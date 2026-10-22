package com.ss.android.lark.filedetail.impl.open;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.filedetail.FileDetailModule;
import com.ss.android.lark.log.Log;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.DecryptException;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileOpenUtils {
    public static final hfb.b.InterfaceC0233b a = null;

    public static class MimeTypeCompat {
        public static final String[][] a = null;
        public static final Map<String, String> b = null;

        static {
            a = new String[][]{new String[]{"application/zip", "application/x-zip-compressed"}};
            b = new AnonymousClass1();
        }
    }

    static {
        com.ss.android.lark.storage.a r0 = FileDetailModule.a;
        a = FileDetailModule.a.a().getAuditDependency();
    }

    public static String a(String r5) {
        byte[] r1 = com.ss.android.lark.filedetail.impl.a.a;
        Intrinsics.checkNotNullParameter(r5, "filePath");
        PolarisFileWrapper r2 = null;
        InputStream r3 = sfb.c.b().k(r5);     // Catch: Exception -> L13
        byte[] r4 = new byte[8];     // Catch: Throwable -> L8
        r3.read(r4);     // Catch: Throwable -> L8
        boolean r6 = Arrays.equals(r4, com.ss.android.lark.filedetail.impl.a.a);     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r3, null);     // Catch: Exception -> L13
    L16:
        if (r6 == true) goto L20;
        Log.i("FileOpenUtils", "[cipher] not cipher file");
        return r5;
    L20:
        if (TextUtils.isEmpty(r5) == false) goto L37;
    L30:
        return BuildConfig.FLAVOR;
    L37:
        r2 = CipherManager.e(sfb.c.b().i(r5), true);     // Catch: DecryptException -> L24
        Log.i("FileOpenUtils", "[cipher] file decrypt success, original path = " + r5 + ", new path = " + r2.getAbsolutePath());     // Catch: DecryptException -> L24
    L26:
        if (r2 == null) goto L30;
        if (r2.exists() == false) goto L30;
        return r2.getAbsolutePath();
    L24:
        e = move-exception;
        Log.e("FileOpenUtils", "[cipher] file decrypt failed, original path = " + r5 + ", code: " + e.getErrorCode());
        goto L26
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("DownloadFileUtils", String.valueOf(e.getMessage()));
        r6 = false;
        goto L16
    }

    public static void b(final Context r9, final File r10, final String r11, final String r12, final String r13) {
        final l r5 = new l(OpenFileActionType.VIEW, UIUtils.getString(r9, 2131892047));
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new k(r10, r12, r13, r9, r5, r11));
    }
}
