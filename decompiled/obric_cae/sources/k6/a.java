package k6;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import r5.f;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f8959a;

    public static String a(byte[] r8) {
        StringBuilder r10 = new StringBuilder("");
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L10;
        String r12 = Integer.toHexString(r8[r11] & 255);
        if (r12.length() != 1) goto L8;
        r12 = "0".concat(r12);
    L8:
        r10.append(r12);
        r10.append(" ");
        r11 = r11 + 1;
        goto L4
    L10:
        return r10.toString().toUpperCase().trim();
    }

    public static String b(Context r8) {
        String r10 = f8959a;
        if (f.b(r10) == true) goto L36;
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
        f8959a = r14;     // Catch: Exception -> L15
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
        f8959a = r15;
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

    public static boolean c(Context r8) {
        String r10 = b(r8);
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
}
