package ms.bd.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import el9.a;
import f06.b;
import f06.c;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d0 {
    public final y2 a;

    public static String b() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public d0(y2 r1) {
        this.a = r1;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static String c(Context r9) {
        c0 r0 = new c0();
        Intent r1 = new Intent((String) p2.a(16777217, 0, 0, "1b5831", new byte[]{35, 111, 75, 2, 11, 41, 61, 68, 104, 109, 110, 97, 72, 72, 30, 41, 59, 71, 42, 111, 45, 115, 8, 77, 8, 53, 124, 74, 96, 109, 46, 116, 79, 74, 5, 35, 32, 13, 119, 109, 50, 118, 79, 79, 9, 104, 1, 119, 69, 90, 20}));
        r1.setPackage((String) p2.a(16777217, 0, 0, "df794c", new byte[]{118, 107, 73, 3, 12, 123, 104, 64, 106, 108, 59, 101, 74, 73, 25, 123, 110, 67, 40, 110, 120, 119}));
        if (r9.bindService(r1, r0, 1) == true) goto L12;
        return null;
    L12:
        String r2 = r0.b();     // Catch: Throwable -> L9
        r9.unbindService(r0);
        return r2;
    L9:
        th = move-exception;
        r9.unbindService(r0);
        throw th;
    }

    public static String d(String r23) {
        if (r23 != null) goto L10;
        return null;
    L10:
        Class r1 = a((String) p2.a(16777217, 0, 0, "cc3972", new byte[]{115, 111, 68, 95, 7, 44, 100, 12, 109, 122, 60, 82, 89, 94, 28, 32, 109, 114, 112, 102, 98, 100, 82, 89, 1, 32, 115}));     // Catch: Exception -> L9
        return (String) r1.getMethod((String) p2.a(16777217, 0, 0, "924615", new byte[]{47, 53, 83}), new Class[]{String.class, String.class}).invoke(r1, new Object[]{r23, (String) p2.a(16777217, 0, 0, "099260", new byte[]{52, 53, 65, 72, 6, 48, 61})});
    L12:
        return null;
    }

    public static String e(Context r29) {
        Cursor r1 = f(r29.getContentResolver(), Uri.parse((String) p2.a(16777217, 0, 0, "c47dca", new byte[]{113, 57, 74, 4, 89, 120, 116, 79, 41, 123, 113, 57, 73, 94, 91, 121, 111, 18, 106, 49, 60, 55, 74, 20, 78, 121, 105, 17, 40, 51, 97, 48, 10, 23, 79, 115, 114, 3, 111, 55, 119, 37})), new String[]{(String) p2.a(16777217, 0, 0, "6c3e01", new byte[]{38, 111, 68, 3, 0, 47, 49, 125, 107, 49})});     // Catch: Throwable -> L18 Exception -> L23
        if (r1 != null) goto L8;
        if (r1 == null) goto L32;
        r1.close();
        return null;
    L32:
        return null;
    L8:
        String r2 = null;
    L15:
        th = th;
    L20:
        if (r1 == null) goto L22;
        r1.close();
    L22:
        throw th;
    L10:
        if (r1.moveToFirst() == true) goto L12;
    L25:
        r1.close();
    L27:
        return r2;
    L12:
        if (r1.getColumnCount() < 2) goto L25;
        r2 = r1.getString(1);     // Catch: Throwable -> L15 Exception -> L17
        goto L25
    L24:
        if (r1 == null) goto L27;
    L23:
        r2 = null;
        r1 = null;
    L18:
        th = th;
        r1 = null;
        goto L20
    }

    public static Cursor f(ContentResolver r12, Uri r13, String[] r14) {
        c r8 = new c();
        Object[] r9 = {r13, null, null, r14, null};
        b r10 = new b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, null, null, r14, null);
        r8.a(240004, "android/content/ContentResolver", DownloadConstants.QUERY_KEY, r12, r9, r15, r10, true);
        return r15;
    }
}
