package org.chromium;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.ttnet.org.chromium.base.Reflect;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9802a;

    public static NetworkExceptionImpl a(int r8, int r10, String r11) {
        switch(r8) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            default: goto L4;
        };
    L6:
        r8 = 11;
    L18:
        return new NetworkExceptionImpl(defpackage.b.c("Exception in CronetUrlRequest: ", r11), r8, r10);
    L7:
        r8 = 10;
        goto L18
    L8:
        r8 = 9;
        goto L18
    L9:
        r8 = 8;
        goto L18
    L10:
        r8 = 7;
        goto L18
    L11:
        r8 = 6;
        goto L18
    L12:
        r8 = 5;
        goto L18
    L13:
        r8 = 4;
        goto L18
    L14:
        r8 = 3;
        goto L18
    L15:
        r8 = 2;
        goto L18
    L16:
        r8 = 1;
        goto L18
    L4:
        if (d.a().loggerDebug() == false) goto L18;
        d.a().loggerD("monitor", "Unknown error code: " + r8);
        goto L18
    }

    public static ArrayList b(Class r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        ArrayList r10 = new ArrayList();
    L6:
        if (r8 == null) goto L21;
        Class<?>[] r11 = r8.getInterfaces();
        int r12 = 0;
    L9:
        if (r12 >= r11.length) goto L20;
        if (r10.contains(r11[r12]) == true) goto L13;
        r10.add(r11[r12]);
    L13:
        Iterator r13 = b(r11[r12]).iterator();
    L15:
        if (r13.hasNext() == false) goto L19;
        Class r14 = (Class) r13.next();
        if (r10.contains(r14) == true) goto L15;
        r10.add(r14);
        goto L15
    L19:
        r12 = r12 + 1;
        goto L9
    L20:
        r8 = r8.getSuperclass();
        goto L6
    L21:
        return r10;
    }

    public static boolean c(Context r10) {
        c r8 = c.c();
        r8.getClass();
        Object r11 = r8.f9796a;     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        int r12 = ((Integer) Reflect.on(r11).call("getProcessFlag").get()).intValue();     // Catch: Throwable -> L8
    L12:
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("Utils", "CronetAppProvider ProcessFlag: " + r12);
    L15:
        if (r12 != 1) goto L17;
        return true;
    L17:
        if (r12 == 2) goto L74;
        String r13 = f9802a;
        if (TextUtils.isEmpty(r13) == true) goto L64;
    L48:
        if (r13 != null) goto L50;
    L52:
        if (r13 != null) goto L54;
        return false;
    L54:
        if (r13.equals(r10.getPackageName()) == true) goto L56;
        return false;
    L56:
        return true;
    L50:
        if (r13.contains(BdimCategoryConstants.SEPARATOR_COLON) == false) goto L52;
        return false;
    L64:
        int r14 = Process.myPid();     // Catch: Exception -> L31
        Iterator<ActivityManager.RunningAppProcessInfo> r15 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L31
    L23:
        if (r15.hasNext() == false) goto L33;
        ActivityManager.RunningAppProcessInfo r16 = r15.next();     // Catch: Exception -> L31
        if (r16.pid != r14) goto L23;
        if (d.a().loggerDebug() == false) goto L29;
        d.a().loggerD("Process", "processName = " + r16.processName);     // Catch: Exception -> L31
    L29:
        r13 = r16.processName;     // Catch: Exception -> L31
        f9802a = r13;     // Catch: Exception -> L31
    L33:
        String r17 = null;
        BufferedReader r18 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L44
        StringBuilder r19 = new StringBuilder();     // Catch: Throwable -> L59
    L36:
        int r20 = r18.read();     // Catch: Throwable -> L59
        if (r20 <= 0) goto L40;
        r19.append((char) r20);     // Catch: Throwable -> L59
        goto L36
    L40:
        if (d.a().loggerDebug() == false) goto L42;
        d.a().loggerD("Process", "get processName = " + r19.toString());     // Catch: Throwable -> L59
    L42:
        r17 = r19.toString();     // Catch: Throwable -> L59
    L66:
        r18.close();     // Catch: Exception -> L58
    L47:
        r13 = r17;
        f9802a = r13;
    L45:
        if (r18 == null) goto L47;
    L44:
        r18 = null;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L74:
        return false;
    L10:
        r12 = 0;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    public static IOException d(NetworkExceptionImpl r8) {
        switch(r8.getErrorCode()) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L8;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L14;
        };
    L5:
        IOException r10 = new NoRouteToHostException(r8.getMessage());
    L13:
        return r10;
    L6:
        r10 = new SocketException("reset by peer " + r8.getMessage());
        goto L13
    L7:
        r10 = new ConnectTimeoutException(r8.getMessage());
        goto L13
    L8:
        r10 = new ConnectException(r8.getMessage());
        goto L13
    L9:
        r10 = new SocketTimeoutException(r8.getMessage());
        goto L13
    L10:
        r10 = new ConnectException(r8.getMessage());
        goto L13
    L11:
        r10 = new UnknownHostException(r8.getMessage());
        goto L13
    L14:
        return r8;
    }
}
