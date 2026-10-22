package l7;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f9171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f9172b;

    static {
        f9171a = new AtomicInteger(0);
        f9172b = null;
    }

    public static String a(Context r8) {
        String r10 = f9172b;
        if (r5.f.b(r10) == true) goto L36;
        return r10;
    L36:
        int r11 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = ((ActivityManager) r8.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L7:
        if (r12.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();     // Catch: Exception -> L15
        if (r13.pid != r11) goto L7;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r13.processName);     // Catch: Exception -> L15
    L13:
        String r14 = r13.processName;     // Catch: Exception -> L15
        f9172b = r14;     // Catch: Exception -> L15
        return r14;
    L17:
        String r15 = null;
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L29
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L35
    L20:
        int r18 = r16.read();     // Catch: Throwable -> L35
        if (r18 <= 0) goto L24;
        r17.append((char) r18);     // Catch: Throwable -> L35
        goto L20
    L24:
        if (Logger.debug() == false) goto L26;
        Logger.d("Process", "get processName = " + r17.toString());     // Catch: Throwable -> L35
    L26:
        r15 = r17.toString();     // Catch: Throwable -> L35
    L42:
        r16.close();     // Catch: Exception -> L34
    L32:
        f9172b = r15;
        return r15;
    L30:
        if (r16 == null) goto L32;
    L29:
        r16 = null;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static boolean b(Context r8) {
        String r10 = a(r8);
        if (r10 != null) goto L5;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r10.equals(r8.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r10.contains(BdimCategoryConstants.SEPARATOR_COLON) == false) goto L7;
        return false;
    }

    public static boolean c(Context r8) {
        boolean r10 = Logger.debug();
        AtomicInteger r11 = f9171a;
        if (r10 == false) goto L5;
        Logger.d("ProcessUtils", "TTNet ProcessFlag: " + r11);
    L5:
        int r12 = r11.get();
        if (r12 != 1) goto L8;
        return true;
    L8:
        if (r12 != 2) goto L10;
        return false;
    L10:
        return b(r8);
    }
}
