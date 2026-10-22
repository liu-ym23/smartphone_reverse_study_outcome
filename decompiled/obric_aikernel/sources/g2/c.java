package g2;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.g;
import com.bytedance.crypto.utils.CryptoConst;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8942a;

    static {
    }

    public static String a(byte[] r10) {
        return b(r10, " ");
    }

    public static String b(byte[] r10, String r11) {
        StringBuilder r12 = new StringBuilder("");
        int r13 = 0;
    L4:
        if (r13 >= r10.length) goto L10;
        String r14 = Integer.toHexString(r10[r13] & 255);
        if (r14.length() != 1) goto L8;
        r14 = NetConst.NOT_ENCRYPT_VERISON_CODE + r14;
    L8:
        r12.append(r14);
        r12.append(r11);
        r13 = r13 + 1;
        goto L4
    L10:
        return r12.toString().toUpperCase().trim();
    }

    public static String c(Context r10) {
        String r11 = f8942a;
        if (g.b(r11) == true) goto L5;
        return r11;
    L5:
        String r12 = g();
        f8942a = r12;
        if (g.b(r12) == false) goto L8;
        String r13 = f();
        f8942a = r13;
        if (g.b(r13) == false) goto L12;
        String r14 = e();
        f8942a = r14;
        if (g.b(r14) == false) goto L16;
        String r15 = d(r10);
        f8942a = r15;
        return r15;
    L16:
        return f8942a;
    L12:
        return f8942a;
    L8:
        return f8942a;
    }

    private static String d(Context r10) {
        String r11 = null;
        if (r10 != null) goto L18;
        return null;
    L18:
        int r12 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L6:
        if (r13.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();     // Catch: Exception -> L15
        if (r14.pid != r12) goto L6;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r14.processName);     // Catch: Exception -> L15
    L13:
        r11 = r14.processName;     // Catch: Exception -> L15
    L17:
        return r11;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private static String e() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L19
        if (r12 <= 0) goto L9;
        r11.append((char) r12);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r11.toString());     // Catch: Throwable -> L19
    L11:
        String r13 = r11.toString();     // Catch: Throwable -> L19
        r10.close();     // Catch: Exception -> L18
    L13:
        return r13;
    L15:
        if (r10 != null) goto L25;
    L17:
        return null;
    L25:
        r10.close();     // Catch: Exception -> L20
    L14:
        r10 = null;
        goto L15
    }

    private static String f() {
        Method r10 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r10.setAccessible(true);     // Catch: Throwable -> L7
        Object r11 = r10.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r11 instanceof String) == false) goto L12;
        return (String) r11;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String g() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static String h(long r10) {
        return DateFormat.getDateTimeInstance().format(new Date(r10));
    }

    public static boolean i(Context r10) {
        String r11 = c(r10);
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.equals(r10.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r11.contains(":") == false) goto L7;
        return false;
    }

    public static boolean j(Context r10, String r11) {
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.equals(r10.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r11.contains(":") == false) goto L7;
        return false;
    }

    public static boolean k(String r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.endsWith(TTProcessUtils.MESSAGE_PROCESS_SUFFIX) == false) goto L6;
        return true;
    }

    public static boolean l(Context r10, Class<? extends Service> r11) {
        if (r10 == null) goto L20;
        if (r11 == null) goto L20;
        Iterator<ActivityManager.RunningServiceInfo> r12 = ((ActivityManager) r10.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();     // Catch: Exception -> L18
    L8:
        if (r12.hasNext() == false) goto L20;
        ActivityManager.RunningServiceInfo r13 = r12.next();     // Catch: Exception -> L18
        if (r13 == null) goto L8;
        if (r13.service == null) goto L8;
        if (TextUtils.equals(r11.getName(), r13.service.getClassName()) == false) goto L8;
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();
    L20:
        return false;
    }

    public static Map<String, String> m(JSONObject r10) {
        HashMap r11 = new HashMap();
        if (r10 != null) goto L5;
        return r11;
    L5:
        Iterator<String> r12 = r10.keys();
    L7:
        if (r12.hasNext() == false) goto L16;
        String r13 = r12.next();
        if (TextUtils.isEmpty(r13) == true) goto L7;
        Object r14 = r10.opt(r13);
        if (r14 != null) goto L14;
        String r15 = null;
    L15:
        r11.put(r13, r15);
        goto L7
    L14:
        r15 = r14.toString();
        goto L15
    L16:
        return r11;
    }

    public static JSONObject n(Map<String, String> r10) {
        JSONObject r11 = new JSONObject();
        if (r10 != null) goto L5;
    L17:
        return r11;
    L5:
        if (r10.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L17;
        Map.Entry<String, String> r13 = r12.next();
        if (TextUtils.isEmpty(r13.getKey()) == true) goto L9;
        r11.put(r13.getKey(), r13.getValue());     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static String o(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L16;
        return "";
    L16:
        byte[] r11 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(r10.getBytes());     // Catch: NoSuchAlgorithmException -> L13
        StringBuilder r12 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L13
        int r13 = r11.length;     // Catch: NoSuchAlgorithmException -> L13
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        String r15 = Integer.toHexString(r11[r14] & 255);     // Catch: NoSuchAlgorithmException -> L13
        if (r15.length() != 1) goto L10;
        r15 = NetConst.NOT_ENCRYPT_VERISON_CODE + r15;     // Catch: NoSuchAlgorithmException -> L13
    L10:
        r12.append(r15);     // Catch: NoSuchAlgorithmException -> L13
        r14 = r14 + 1;     // Catch: NoSuchAlgorithmException -> L13
        goto L6
    L11:
        return r12.toString();
    L13:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @Nullable
    public static String p(Throwable r10) {
        String r11 = null;
        if (r10 != null) goto L29;
        return null;
    L29:
        StringWriter r12 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r13 = new PrintWriter(r12);     // Catch: Throwable -> L15
        r10.printStackTrace(r13);     // Catch: Throwable -> L13
        Throwable r14 = r10.getCause();     // Catch: Throwable -> L13
        if (r14 == null) goto L11;
        r14.printStackTrace(r13);     // Catch: Throwable -> L13
        Throwable r15 = r14.getCause();     // Catch: Throwable -> L13
        if (r15 == null) goto L11;
        r15.printStackTrace(r13);     // Catch: Throwable -> L13
    L11:
        r11 = r12.toString();     // Catch: Throwable -> L13
    L12:
        r13.close();
    L20:
        return r11;
    L13:
        th = th;
    L25:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r13 == null) goto L20;
    L21:
        th = move-exception;
        if (r13 == null) goto L24;
        r13.close();
    L24:
        throw th;
    L15:
        th = th;
        r13 = null;
        goto L25
    }
}
