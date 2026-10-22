package com.ss.android.lark.officesdk.utils.di;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.vfs.VFSFile;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static ntb.v a() {
            DependencyContainer r0 = DependencyContainer.a;
            ntb.v r1 = (ntb.v) DependencyContainer.a(ntb.v.class, null);
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException("IStorageDependency must be initialized before using StorageUtil");
        }

        @JvmStatic
        public static File b(String r1) {
            Intrinsics.checkNotNullParameter(r1, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
            VFSFile r0 = a().i(r1);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new PolarisFileWrapper(r1);
        }

        public static void c(ZipInputStream r7, String r8) throws Exception {
            Intrinsics.checkNotNullParameter(r7, "inZip");
        L3:
            ZipEntry r0 = r7.getNextEntry();
            if (r0 == null) goto L34;
            Intrinsics.checkNotNull(r0);
            String r1 = r0.getName();
            BufferedOutputStream r5 = null;
            if (StringsKt.contains$default(r1, "../", false, 2, null) == true) goto L3;
            if (r0.isDirectory() == true) goto L10;
            PolarisFileWrapper r2 = new PolarisFileWrapper(r8 + File.separator + r1);
            if (r2.exists() == true) goto L35;
            r2.getParentFile().mkdirs();
            r2.createNewFile();
        L35:
            BufferedOutputStream r3 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r2));     // Catch: Throwable -> L26 IOException -> L28
            byte[] r4 = new byte[1024];     // Catch: Throwable -> L22 IOException -> L24
        L17:
            int r6 = r7.read(r4);     // Catch: Throwable -> L22 IOException -> L24
            if (r6 == (-1)) goto L20;
            r3.write(r4, 0, r6);     // Catch: Throwable -> L22 IOException -> L24
            r3.flush();     // Catch: Throwable -> L22 IOException -> L24
            goto L17
        L20:
            r3.close();     // Catch: Throwable -> L22 IOException -> L24
            swb.d.a(new Closeable[]{r3});
        L24:
            e = e;
            r5 = r3;
        L29:
            e.printStackTrace();     // Catch: Throwable -> L26
            swb.d.a(new Closeable[]{r5});
        L22:
            th = th;
        L32:
            swb.d.a(new Closeable[]{r3});
            throw th;
        L26:
            th = th;
            r3 = r5;
        L28:
            e = e;
            goto L29
        L10:
            new PolarisFileWrapper(r8 + File.separator + StringsKt.dropLast(r1, 1)).mkdirs();
            goto L3
        }
    }

    static {
    }
}
