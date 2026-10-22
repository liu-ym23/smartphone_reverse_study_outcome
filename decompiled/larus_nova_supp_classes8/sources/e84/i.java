package e84;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import f06.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements m {
    public final a a;

    public class a extends i84.r<Boolean> {
        public a() {
        }

        public final Object a(Object[] r3) {
            boolean r0 = false;
            PackageManager r4 = ((Context) r3[0]).getPackageManager();     // Catch: Exception -> L12
            if (r4 == null) goto L11;
            if (r4.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) goto L8;
            r0 = true;
        L8:
            return Boolean.valueOf(r0);
        L11:
            return Boolean.FALSE;
        }
    }

    public final String getName() {
        return "Meizu";
    }

    public i() {
        this.a = new a();
    }

    public final boolean a(Context r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        return ((Boolean) this.a.b(new Object[]{r4})).booleanValue();
    }

    public final m$a getOaid(Context r4) {
        Cursor r5 = b(r4.getContentResolver(), UriProtector.parse("content://com.meizu.flyme.openidsdk/"), new String[]{"oaid"});     // Catch: Throwable -> L20
        if (r5 != null) goto L30;
        if (r5 == null) goto L7;
        r5.close();
    L7:
        return null;
    L30:
        m$a r0 = new m$a();     // Catch: Throwable -> L18
        if (r5.isClosed() == true) goto L14;
        r5.moveToFirst();     // Catch: Throwable -> L18
        int r2 = r5.getColumnIndex("value");     // Catch: Throwable -> L18
        if (r2 < 0) goto L14;
        String r3 = r5.getString(r2);     // Catch: Throwable -> L18
    L15:
        r0.a = r3;     // Catch: Throwable -> L18
        r5.close();
        return r0;
    L14:
        r3 = null;
    L18:
        Throwable th = th;
    L34:
        th.printStackTrace();     // Catch: Throwable -> L26
        if (r5 == null) goto L25;
        r5.close();
    L25:
        return null;
    L26:
        th = move-exception;
        if (r5 == null) goto L29;
        r5.close();
    L29:
        throw th;
    L20:
        th = move-exception;
        th = th;
        r5 = null;
        goto L34
    }

    public static Cursor b(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, null, null, r14, null};
        b r10 = new b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, null, null, r14, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }
}
