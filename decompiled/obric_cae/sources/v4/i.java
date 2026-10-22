package v4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import c4.m;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f12730a;

    public static boolean a(String r8) {
        boolean r10 = false;
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L18:
        return false;
    L5:
        if ("unknown".equalsIgnoreCase(r8) == true) goto L18;
        if ("Null".equalsIgnoreCase(r8) == true) goto L18;
        int r11 = 0;
    L10:
        if (r11 >= r8.length()) goto L15;
        if (r8.charAt(r11) != '0') goto L17;
        r11 = r11 + 1;
    L17:
        return !r10;
    L15:
        r10 = true;
        goto L17
    }

    public static void b(Cursor r8) {
        if (r8 == null) goto L8;
        r8.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void c(Closeable r8) {
        if (r8 == null) goto L8;
        r8.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void d(JSONObject r8, JSONObject r10) {
        if (r10 == null) goto L15;
        Iterator<String> r11 = r10.keys();     // Catch: JSONException -> L8
    L5:
        if (r11.hasNext() == false) goto L16;
        String r12 = r11.next();     // Catch: JSONException -> L8
        r8.put(r12, r10.opt(r12));     // Catch: JSONException -> L8
        goto L5
    L16:
        return;
    L8:
        e = move-exception;
        m.u().o(e, "copy failed", new Object[0]);
        return;
    }

    public static JSONObject e(JSONObject r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        Iterator<String> r10 = r8.keys();
        if (r10 != null) goto L8;
        return null;
    L8:
        LinkedList r11 = new LinkedList();
    L10:
        if (r10.hasNext() == false) goto L18;
        r11.add(r10.next());
        goto L10
    L18:
        return new JSONObject(r8, (String[]) r11.toArray(new String[0]));
    L15:
        e = move-exception;
        m.u().o(e, "copyJson failed", new Object[0]);
        return r8;
    }

    public static void f(SQLiteDatabase r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isOpen() == false) goto L15;
    L9:
        th = move-exception;
        m.u().o(th, "end transaction failed", new Object[0]);
        return;
    L6:
        if (r8.inTransaction() == false) goto L16;
        r8.endTransaction();     // Catch: Throwable -> L9
        return;
    L16:
        return;
    }

    public static boolean g(String r8) {
        return !h(r8);
    }

    public static boolean h(String r8) {
        if (r8 != null) goto L4;
    L6:
        return false;
    L4:
        if (r8.length() <= 0) goto L6;
        return true;
    }
}
