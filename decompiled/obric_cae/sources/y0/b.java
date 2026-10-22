package y0;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.MatrixCursor;
import androidx.room.r;
import androidx.room.t;
import he.i;
import java.util.Iterator;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final void a(a1.b r8) {
        i.f(r8, "db");
        zd.a r10 = new zd.a();
        Cursor r11 = r8.a0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
    L19:
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        defpackage.c.A(r11, th);
        throw th;
    L4:
        if (r11.moveToNext() == false) goto L6;
        r10.add(r11.getString(0));     // Catch: Throwable -> L14
        goto L19
    L6:
        j r12 = j.f13877a;     // Catch: Throwable -> L14
        defpackage.c.A(r11, null);
        l6.a.q(r10);
        Iterator r13 = r10.iterator();
    L8:
        zd.a.C0207a r14 = (zd.a.C0207a) r13;
        if (r14.hasNext() == false) goto L13;
        String r15 = (String) r14.next();
        i.e(r15, "triggerName");
        if (r15.startsWith("room_fts_content_sync_") == false) goto L8;
        r8.e("DROP TRIGGER IF EXISTS ".concat(r15));
        goto L8
    }

    public static final Cursor b(r r8, t r10, boolean r11) {
        i.f(r8, "db");
        i.f(r10, "sqLiteQuery");
        Cursor r12 = r8.query(r10, null);
        if (r11 == true) goto L5;
    L44:
        return r12;
    L5:
        if ((r12 instanceof AbstractWindowedCursor) == false) goto L44;
        AbstractWindowedCursor r13 = (AbstractWindowedCursor) r12;
        int r14 = r13.getCount();
        if (r13.hasWindow() == false) goto L9;
        int r15 = r13.getWindow().getNumRows();
    L10:
        if (r15 >= r14) goto L44;
        i.f(r12, "c");
        MatrixCursor r16 = new MatrixCursor(r12.getColumnNames(), r12.getCount());     // Catch: Throwable -> L39
    L14:
        if (r12.moveToNext() == false) goto L37;
        Object[] r17 = new Object[r12.getColumnCount()];     // Catch: Throwable -> L39
        int r18 = r12.getColumnCount();     // Catch: Throwable -> L39
        int r19 = 0;
    L16:
        if (r19 >= r18) goto L35;
        int r20 = r12.getType(r19);     // Catch: Throwable -> L39
        if (r20 != 0) goto L20;
        r17[r19] = null;     // Catch: Throwable -> L39
    L34:
        r19 = r19 + 1;     // Catch: Throwable -> L39
        goto L16
    L20:
        if (r20 != 1) goto L22;
        r17[r19] = Long.valueOf(r12.getLong(r19));     // Catch: Throwable -> L39
        goto L34
    L22:
        if (r20 != 2) goto L24;
        r17[r19] = Double.valueOf(r12.getDouble(r19));     // Catch: Throwable -> L39
        goto L34
    L24:
        if (r20 != 3) goto L26;
        r17[r19] = r12.getString(r19);     // Catch: Throwable -> L39
        goto L34
    L26:
        if (r20 != 4) goto L29;
        r17[r19] = r12.getBlob(r19);     // Catch: Throwable -> L39
        goto L34
    L29:
        throw new IllegalStateException();     // Catch: Throwable -> L39
    L35:
        r16.addRow(r17);     // Catch: Throwable -> L39
        goto L14
    L37:
        defpackage.c.A(r12, null);
        return r16;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        defpackage.c.A(r12, th);
        throw th;
    L9:
        r15 = r14;
        goto L10
    }
}
