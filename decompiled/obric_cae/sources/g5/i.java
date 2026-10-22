package g5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class i implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7653a;

    public class a extends k5.l<Boolean> {
        @Override // k5.l
        public final Boolean a(Object[] r8) {
            boolean r10 = false;
            PackageManager r11 = ((Context) r8[0]).getPackageManager();     // Catch: Exception -> L12
            if (r11 == null) goto L11;
            if (r11.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) goto L8;
            r10 = true;
        L8:
            return Boolean.valueOf(r10);
        L11:
            return Boolean.FALSE;
        }
    }

    public i() {
        this.f7653a = new a();
    }

    @Override // g5.m
    public final m.a a(Context r8) {
        Cursor r10 = r8.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);     // Catch: Throwable -> L20
        if (r10 != null) goto L32;
        if (r10 == null) goto L7;
        r10.close();
    L7:
        return null;
    L32:
        m.a r11 = new m.a();     // Catch: Throwable -> L18
        if (r10.isClosed() == true) goto L14;
        r10.moveToFirst();     // Catch: Throwable -> L18
        int r12 = r10.getColumnIndex("value");     // Catch: Throwable -> L18
        if (r12 < 0) goto L14;
        String r13 = r10.getString(r12);     // Catch: Throwable -> L18
    L15:
        r11.f7667a = r13;     // Catch: Throwable -> L18
        r10.close();
        return r11;
    L14:
        r13 = null;
    L18:
        th = th;
    L30:
        th.printStackTrace();     // Catch: Throwable -> L26
        if (r10 == null) goto L25;
        r10.close();
    L25:
        return null;
    L26:
        th = move-exception;
        if (r10 == null) goto L29;
        r10.close();
    L29:
        throw th;
    L20:
        th = th;
        r10 = null;
        goto L30
    }

    @Override // g5.m
    public final boolean b(Context r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        return this.f7653a.b(new Object[]{r8}).booleanValue();
    }

    @Override // g5.m
    public final String getName() {
        return "Meizu";
    }
}
