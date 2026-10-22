package y0;

import android.database.Cursor;
import android.util.Log;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int a(Cursor r8, String r10) {
        i.f(r8, "c");
        int r11 = r8.getColumnIndex(r10);
        if (r11 < 0) goto L5;
        return r11;
    L5:
        int r12 = r8.getColumnIndex("`" + r10 + '`');
        if (r12 >= 0) goto L10;
        return -1;
    L10:
        return r12;
    }

    public static final int b(Cursor r8, String r10) {
        i.f(r8, "c");
        int r11 = a(r8, r10);
        if (r11 < 0) goto L11;
        return r11;
    L11:
        String[] r12 = r8.getColumnNames();     // Catch: Exception -> L7
        i.e(r12, "c.columnNames");     // Catch: Exception -> L7
        String r13 = yd.e.u0(r12);     // Catch: Exception -> L7
    L10:
        throw new IllegalArgumentException(defpackage.b.e("column '", r10, "' does not exist. Available columns: ", r13));
    L7:
        e = move-exception;
        Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
        r13 = "unknown";
        goto L10
    }
}
