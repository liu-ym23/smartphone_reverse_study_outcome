package axb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.di.core.deps.StorageVolume;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.r;
import com.ss.android.lark.officewebview.util.k;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final String b(Context r4) {
        if (r4 != null) goto L6;
        j.b("WebErrorPageUIOptimize", "getErrorPageFilePath,context null");
        return "";
    L6:
        String r5 = a(r4, "lk_error_page");
        if (TextUtils.isEmpty(r5) == false) goto L10;
        j.b("WebErrorPageUIOptimize", "getErrorPageFilePath,errorPageDir null");
        return "";
    L10:
        int r2 = r.a;
        File r6 = r.a.b(r5 + File.separator + "index.html");
        if (r6.exists() == true) goto L13;
        j.b("WebErrorPageUIOptimize", "getErrorPageFilePath,errorPageFile not exists " + r6.getAbsolutePath());
        return "";
    L13:
        return r6.getAbsolutePath();
    }

    @JvmStatic
    public static final boolean c(String r2) {
        if (r2 != null) goto L10;
        return false;
    L10:
        return TextUtils.equals(UriProtector.parse(r2).buildUpon().clearQuery().toString(), "lkweb://local/netdetect");
    L7:
        th = move-exception;
        j.d("WebErrorPageUIOptimize", th);
        return false;
    }

    @JvmStatic
    public static final byte[] d(String r3) {
        if (r3 != null) goto L18;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        j.b("WebErrorPageUIOptimize", "readBytes file is empty");     // Catch: Throwable -> L8
        return null;
    L14:
        int r4 = r.a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r3, "file");     // Catch: Throwable -> L8
        InputStream r5 = r.a.a().k(r3);     // Catch: Throwable -> L8
        byte[] r6 = new byte[r5.available()];     // Catch: Throwable -> L8
        r5.read(r6);     // Catch: Throwable -> L8
        r5.close();     // Catch: Throwable -> L8
        return r6;
    L18:
    L8:
        th = move-exception;
        j.d("WebErrorPageUIOptimize", th);
        return null;
    L5:
        if (r3.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    @JvmStatic
    public static final String a(Context r7, String r8) {
        if (r7 != null) goto L19;
        return "";
    L19:
        int r9 = r.a;     // Catch: Throwable -> L7
        StorageVolume r10 = StorageVolume.INTERNAL_FILES;     // Catch: Throwable -> L7
        int r3 = k.a;     // Catch: Throwable -> L7
        String[] r5 = {r8};     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r10, "volume");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("open_platform", "domain");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);     // Catch: Throwable -> L7
        File r11 = r.a.a().l0(r10, (String[]) Arrays.copyOf(r5, 1));     // Catch: Throwable -> L7
    L9:
        if (r11 != null) goto L13;
        j.e("WebErrorPageUIOptimize", "mkdirs errorPageDir == null");
        return "";
    L13:
        if (r11.isDirectory() == true) goto L18;
        j.e("WebErrorPageUIOptimize", "mkdirs errorPageDir");
        int r12 = r.a;
        String r13 = r11.getAbsolutePath();
        Intrinsics.checkNotNullParameter(r13, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
        PolarisFileWrapper r0 = new PolarisFileWrapper(r13);
        if (r0.exists() == true) goto L18;
        r0.mkdirs();
    L18:
        return r11.getAbsolutePath();
    L7:
        th = move-exception;
        j.c("WebErrorPageUIOptimize", "checkAndGetErrorPageDir error", th);
        r11 = null;
        goto L9
    }
}
