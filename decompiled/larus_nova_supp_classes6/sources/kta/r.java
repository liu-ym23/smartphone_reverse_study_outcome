package kta;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.mt.protector.impl.UriProtector;
import f06.d;
import pta.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class r implements o {
    public static final a a = null;

    public static class a extends e<Boolean> {
        public a() {
        }

        @Override // pta.e
        public final Boolean a(Object[] r2) {
            return Boolean.valueOf("1".equals(r.c()));
        }
    }

    static {
        a = new a();
    }

    public static String c() {
        return SystemProperties.get("persist.sys.identifierid.supported", "0");
    L8:
        return "0";
    }

    public r() {
    }

    @Override // kta.o
    public final boolean a(Context r2) {
        return a.b(new Object[0]).booleanValue();
    }

    @Override // kta.o
    public final o.a getOaid(Context r4) {
        o.a r0 = new o.a();
        r0.a = query(r4, 0, null);
        return r0;
    }

    public static Cursor b(ContentResolver r12, Uri r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, null, null, null, null};
        f06.b r10 = new f06.b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r14 = r12.query(r13, null, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r14, r10, true);
        return r14;
    }

    private static String query(Context r2, int r3, String r4) {
        String r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        Cursor r1 = null;
        if (r3 != 0) goto L5;
        Uri r5 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    L12:
        if (r5 != null) goto L50;
    L42:
        return r0;
    L50:
        Cursor r6 = b(r2.getContentResolver(), r5);     // Catch: Throwable -> L26 Exception -> L28
        if (r6 != null) goto L47;
    L21:
        if (r6 == null) goto L42;
    L43:
        r6.close();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L47:
    L19:
        Exception e = e;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L34
        if (r6 == null) goto L42;
    L34:
        th = move-exception;
        r1 = r6;
        th = th;
    L36:
        if (r1 != null) goto L45;
    L41:
        throw th;
    L45:
        r1.close();     // Catch: Exception -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
        goto L41
    L16:
        if (r6.moveToNext() == false) goto L21;
        r0 = r6.getString(r6.getColumnIndex("value"));     // Catch: Exception -> L19 Throwable -> L34
        goto L21
    L28:
        e = move-exception;
        e = e;
        r6 = null;
    L26:
        th = th;
        goto L36
    L5:
        if (r3 != 1) goto L7;
        r5 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r4);
        goto L12
    L7:
        if (r3 == 2) goto L9;
        r5 = null;
        goto L12
    L9:
        r5 = UriProtector.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r4);
        goto L12
    }
}
