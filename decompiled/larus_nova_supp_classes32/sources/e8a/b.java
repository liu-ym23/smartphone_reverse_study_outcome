package e8a;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.tasm.utils.l;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static byte[] a(Context r3, String r4) {
        byte[] r0 = null;
        r0 = null;
        r0 = null;
        InputStream r1 = null;
        r0 = null;
        r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        Uri r5 = UriProtector.parse(r4);
        if (r3 == null) goto L27;
        if (r5 == null) goto L27;
        if (LynxAccessibilityModule.MSG_CONTENT.equals(r5.getScheme()) == false) goto L27;
        InputStream r6 = ContentResolverWrapper.openInputStream(r3.getContentResolver(), r5);     // Catch: Throwable -> L19 Exception -> L24
    L36:
        r0 = l.a(r6);     // Catch: Throwable -> L16 Exception -> L18
        if (r6 == null) goto L27;
    L32:
        r6.close();     // Catch: IOException -> L29
        goto L27
    L16:
        Throwable th = th;
        r1 = r6;
    L21:
        if (r1 == null) goto L38;
        r1.close();     // Catch: IOException -> L28
        throw th;
    L39:
        throw th;
    L38:
        throw th;
    L25:
        if (r6 == null) goto L27;
    L24:
        r6 = null;
    L19:
        th = move-exception;
        th = th;
    L27:
        return r0;
    }

    public static byte[] b(Context r4, String r5) {
        byte[] r0 = null;
        r0 = null;
        r0 = null;
        InputStream r1 = null;
        if (r4 == null) goto L22;
        if (r5 == null) goto L22;
        if (r5.startsWith("file://") == false) goto L22;
        if (r5.length() <= 7) goto L22;
        String r2 = r5.substring(7);
        if (r2.startsWith("/") == false) goto L13;
        String r6 = UriProtector.parse(r5).getPath();
    L14:
        if (r6 == null) goto L22;
        if (r6.length() == 0) goto L22;
        if (r6.startsWith("/") == false) goto L21;
        PolarisFileWrapper r7 = new PolarisFileWrapper(r6);
    L23:
        if (r7 != null) goto L46;
    L39:
        return r0;
    L46:
        InputStream r8 = new PolarisFileInputStreamWrapper(r7);     // Catch: Throwable -> L32 Exception -> L36
    L48:
        r0 = l.a(r8);     // Catch: Throwable -> L29 Exception -> L31
    L44:
        r8.close();     // Catch: IOException -> L41
        goto L39
    L29:
        th = th;
        r1 = r8;
    L33:
        if (r1 != null) goto L42;
    L35:
        throw th;
    L42:
        r1.close();     // Catch: IOException -> L40
    L37:
        if (r8 == null) goto L39;
    L36:
        r8 = null;
    L32:
        th = th;
        goto L33
    L21:
        r7 = new PolarisFileWrapper(r4.getFilesDir(), r6);
        goto L23
    L13:
        r6 = Uri.decode(r2);
    L22:
        r7 = null;
        goto L23
    }
}
