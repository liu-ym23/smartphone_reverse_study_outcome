package com.bytedance.applog.util;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.applog.EventType;
import com.bytedance.applog.log.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f1892b = ":push";

    static {
    }

    public static long a(JSONObject r2, String r3) {
        if (r2 != null) goto L9;
        return 0;
    L9:
        return Long.parseLong(r2.optString(r3));
    L11:
        return 0;
    }

    public static EventType a(com.bytedance.applog.n.a r1) {
        if (r1 != null) goto L6;
        return EventType.UNKNOWN;
    L6:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.f.class) == false) goto L10;
        return EventType.FORWARD_V3;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.e.class) == false) goto L14;
        return EventType.V3;
    L14:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.c.class) == false) goto L18;
        return EventType.V1;
    L18:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.d.class) == false) goto L22;
        return EventType.LogData;
    L22:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.g.class) == false) goto L26;
        return EventType.Launch;
    L26:
        if (ZeusTransformUtils.instanceOf(r1, com.bytedance.applog.n.j.class) == false) goto L30;
        return EventType.Terminate;
    L30:
        return EventType.UNKNOWN;
    }

    private static String a() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r0 = r2.toString();     // Catch: Throwable -> L16
        r1.close();     // Catch: Exception -> L15
    L10:
        return r0;
    L12:
        if (r1 != null) goto L18;
    L14:
        return null;
    L18:
        r1.close();     // Catch: Exception -> L17
    L11:
        r1 = null;
        goto L12
    }

    public static String a(int r1) {
        if (r1 != 0) goto L4;
        return "GZIP";
    L4:
        if (r1 != 1) goto L6;
        return "ZSTD";
    L6:
        if (r1 == 2) goto L9;
        return "UNKNOWN";
    L9:
        return "ZSTD+DICT";
    }

    public static String a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r0 = f1891a;
        if (TextUtils.isEmpty(r0) == true) goto L16;
        return r0;
    L16:
        int r1 = Process.myPid();     // Catch: Exception -> L12
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L12
    L7:
        if (r6.hasNext() == false) goto L14;
        ActivityManager.RunningAppProcessInfo r2 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r6.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        if (r2.pid != r1) goto L7;
        f1891a = r2.processName;     // Catch: Exception -> L12
    L14:
        f1891a = a();
        q.a().c("getProcessName: {}", new Object[]{f1891a});
        return f1891a;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static String a(Object r0) {
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.toString();
    }

    public static String a(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.isEmpty() == true) goto L18;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L14
        Iterator r7 = r6.entrySet().iterator();     // Catch: Throwable -> L14
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r2.getValue());     // Catch: Throwable -> L14
        goto L8
    L10:
        return r0.toString();
    L19:
        return null;
    L18:
        return null;
    }

    public static JSONObject a(JSONObject r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r5.keys();
        if (r1 != null) goto L8;
        return null;
    L8:
        LinkedList r0 = new LinkedList();
    L10:
        if (r1.hasNext() == false) goto L18;
        r0.add(r1.next());
        goto L10
    L18:
        return new JSONObject(r5, (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"));
    L15:
        e = move-exception;
        q.a().a("copyJson failed", e, new Object[0]);
        return r5;
    }

    public static void a(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void a(SQLiteDatabase r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isOpen() == false) goto L15;
    L9:
        th = move-exception;
        q.a().a("end transaction failed", th, new Object[0]);
        return;
    L6:
        if (r3.inTransaction() == false) goto L16;
        r3.endTransaction();     // Catch: Throwable -> L9
        return;
    L16:
        return;
    }

    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static boolean a(Object r0, Object r1) {
        return Objects.equals(r0, r1);
    }

    public static boolean a(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static boolean a(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.equals(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        goto L6
    }

    public static boolean a(Map<String, Object> r6, JSONObject r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L6;
        return false;
    L6:
        if (r7 != null) goto L8;
        return true;
    L8:
        Iterator r9 = r8.entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (b((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin")) == true) goto L10;
        if (b(r7.opt((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin")), r3.getValue()) == false) goto L10;
        return true;
    L17:
        return false;
    }

    public static boolean a(JSONObject r0, JSONObject r1) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        return r0.toString().equals(r1.toString());
    L7:
        return a(r0, r1);
    }

    public static JSONObject b(JSONObject r4, JSONObject r5) {
        if (r5 != null) goto L11;
    L10:
        return r4;
    L11:
        Iterator<String> r0 = r5.keys();     // Catch: JSONException -> L8
    L5:
        if (r0.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L8
        r4.put(r1, r5.opt(r1));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        q.a().a("copy failed", e, new Object[0]);
        goto L10
    }

    public static boolean b(Object r0, Object r1) {
        return !a(r0, r1);
    }

    public static boolean b(String r0) {
        return !a(r0);
    }

    public static boolean c(String r5) {
        boolean r1 = false;
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L18:
        return false;
    L5:
        if ("unknown".equalsIgnoreCase(r5) == true) goto L18;
        if ("Null".equalsIgnoreCase(r5) == true) goto L18;
        int r0 = 0;
    L10:
        if (r0 >= r5.length()) goto L15;
        if (r5.charAt(r0) != '0') goto L17;
        r0 = r0 + 1;
    L17:
        return !r1;
    L15:
        r1 = true;
        goto L17
    }
}
