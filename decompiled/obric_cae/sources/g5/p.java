package g5;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;

/* JADX INFO: loaded from: classes.dex */
public final class p implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7677a = null;

    public static class a extends k5.l<Boolean> {
        @Override // k5.l
        public final Boolean a(Object[] r8) {
            String r10 = "0";
            r10 = SystemProperties.get("persist.sys.identifierid.supported", "0");     // Catch: Throwable -> L6
        L5:
            return Boolean.valueOf("1".equals(r10));
        }
    }

    static {
        f7677a = new a();
    }

    public p() {
    }

    @Override // g5.m
    public final m.a a(Context r8) {
        m.a r10 = new m.a();
        Uri r11 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        String r12 = null;
        r12 = null;
        r12 = null;
        r12 = null;
        r12 = null;
        Cursor r13 = null;
        if (r11 != null) goto L42;
    L33:
        r10.f7667a = r12;
        return r10;
    L42:
        Cursor r14 = r8.getContentResolver().query(r11, null, null, null, null);     // Catch: Throwable -> L17 Exception -> L19
        if (r14 != null) goto L35;
    L12:
        if (r14 == null) goto L33;
    L40:
        r14.close();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        int r15 = x4.r.f13543a;
        goto L33
    L35:
    L10:
        Exception e10 = e;
    L21:
        e10.printStackTrace();     // Catch: Throwable -> L25
        e10.toString();     // Catch: Throwable -> L25
        int r16 = x4.r.f13543a;     // Catch: Throwable -> L25
        if (r14 == null) goto L33;
    L25:
        th = th;
        r13 = r14;
    L27:
        if (r13 != null) goto L37;
    L32:
        throw th;
    L37:
        r13.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        int r17 = x4.r.f13543a;
        goto L32
    L7:
        if (r14.moveToNext() == false) goto L12;
        r12 = r14.getString(r14.getColumnIndex("value"));     // Catch: Exception -> L10 Throwable -> L25
        goto L12
    L19:
        e = move-exception;
        e10 = e;
        r14 = null;
    L17:
        th = th;
        goto L27
    }

    @Override // g5.m
    public final boolean b(Context r8) {
        a r10 = f7677a;
        return r10.b(new Object[0]).booleanValue();
    }

    @Override // g5.m
    public final String getName() {
        return "Vivo";
    }
}
