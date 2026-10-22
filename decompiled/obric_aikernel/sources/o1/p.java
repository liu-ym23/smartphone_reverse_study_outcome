package o1;

import android.app.ActivityManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11390a;

    static {
    }

    public static boolean a(String r10) {
        boolean r11 = false;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L18:
        return false;
    L5:
        if ("unknown".equalsIgnoreCase(r10) == true) goto L18;
        if ("Null".equalsIgnoreCase(r10) == true) goto L18;
        int r12 = 0;
    L10:
        if (r12 >= r10.length()) goto L15;
        if (r10.charAt(r12) != '0') goto L17;
        r12 = r12 + 1;
    L17:
        return !r11;
    L15:
        r11 = true;
        goto L17
    }

    public static void b(Closeable r10) {
        if (r10 == null) goto L8;
        r10.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static JSONObject c(JSONObject r10, JSONObject r11) {
        if (r11 != null) goto L11;
    L10:
        return r10;
    L11:
        Iterator<String> r12 = r11.keys();     // Catch: JSONException -> L8
    L5:
        if (r12.hasNext() == false) goto L10;
        String r13 = r12.next();     // Catch: JSONException -> L8
        r10.put(r13, r11.opt(r13));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        f1.n.B().j("copy failed", e, new Object[0]);
        goto L10
    }

    public static JSONObject d(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator<String> r11 = r10.keys();
        if (r11 != null) goto L8;
        return null;
    L8:
        LinkedList r12 = new LinkedList();
    L10:
        if (r11.hasNext() == false) goto L18;
        r12.add(r11.next());
        goto L10
    L18:
        return new JSONObject(r10, (String[]) r12.toArray(new String[0]));
    L15:
        e = move-exception;
        f1.n.B().j("copyJson failed", e, new Object[0]);
        return r10;
    }

    public static void e(SQLiteDatabase r10) {
        if (r10 == null) goto L10;
        r10.endTransaction();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f1.n.B().j("end transaction failed", th, new Object[0]);
        return;
    }

    public static boolean f(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
    L6:
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.equals(r11) == false) goto L10;
    L9:
        return true;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        goto L6
    }

    public static boolean g(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static String h(int r10) {
        if (r10 != 0) goto L4;
        return "GZIP";
    L4:
        if (r10 != 1) goto L6;
        return "ZSTD";
    L6:
        if (r10 == 2) goto L9;
        return "UNKNOWN";
    L9:
        return "ZSTD+DICT";
    }

    public static String i(Context r10) {
        String r11 = f11390a;
        if (TextUtils.isEmpty(r11) == true) goto L16;
        return r11;
    L16:
        int r12 = Process.myPid();     // Catch: Exception -> L12
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L12
    L7:
        if (r13.hasNext() == false) goto L14;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();     // Catch: Exception -> L12
        if (r14.pid != r12) goto L7;
        f11390a = r14.processName;     // Catch: Exception -> L12
    L14:
        f11390a = j();
        f1.n.B().i("getProcessName, " + f11390a, new Object[0]);
        return f11390a;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    private static String j() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L16
        if (r12 <= 0) goto L8;
        r11.append((char) r12);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r13 = r11.toString();     // Catch: Throwable -> L16
        r10.close();     // Catch: Exception -> L15
    L10:
        return r13;
    L12:
        if (r10 != null) goto L22;
    L14:
        return null;
    L22:
        r10.close();     // Catch: Exception -> L17
    L11:
        r10 = null;
        goto L12
    }

    public static synchronized String k() {
        monitor-enter(p.class);
        String r10 = UUID.randomUUID().toString().replace("-", "").toLowerCase();     // Catch: Throwable -> L7
        monitor-exit(p.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean l(String r10) {
        return !m(r10);
    }

    public static boolean m(String r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.length() <= 0) goto L6;
        return true;
    }

    public static boolean n(JSONObject r10, JSONObject r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L7;
        return r10.toString().equals(r11.toString());
    L7:
        return g(r10, r11);
    }

    public static String o(Map<String, String> r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L17;
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, String> r13 = r12.next();     // Catch: Throwable -> L13
        r11.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L13
        goto L7
    L9:
        return r11.toString();
    L18:
        return null;
    L17:
        return null;
    }

    public static long p(JSONObject r10, String r11) {
        if (r10 != null) goto L9;
        return 0;
    L9:
        return Long.parseLong(r10.optString(r11));
    L11:
        return 0;
    }

    public static String q(Object r10) {
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10.toString();
    }
}
