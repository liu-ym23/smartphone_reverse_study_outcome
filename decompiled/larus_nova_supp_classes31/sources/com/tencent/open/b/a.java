package com.tencent.open.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.tencent.open.log.SLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class a {
    protected static final Uri a = null;

    public static String b(Context r0) {
        return "";
    }

    static {
        a = UriProtector.parse("content://telephony/carriers/preferapn");
    }

    public static String a(Context r2) {
        int r0 = d(r2);
        if (r0 != 2) goto L7;
        return "wifi";
    L7:
        if (r0 != 1) goto L11;
        return "cmwap";
    L11:
        if (r0 != 4) goto L15;
        return "cmnet";
    L15:
        if (r0 != 16) goto L19;
        return "uniwap";
    L19:
        if (r0 != 8) goto L23;
        return "uninet";
    L23:
        if (r0 != 64) goto L27;
        return "wap";
    L27:
        if (r0 != 32) goto L31;
        return "net";
    L31:
        if (r0 != 512) goto L35;
        return "ctwap";
    L35:
        if (r0 != 256) goto L39;
        return "ctnet";
    L39:
        if (r0 != 2048) goto L43;
        return "3gnet";
    L43:
        if (r0 != 1024) goto L46;
        return "3gwap";
    L46:
        String r3 = b(r2);
        if (r3 != null) goto L49;
        return "none";
    L49:
        if (r3.length() == 0) goto L54;
        return r3;
    L54:
        return "none";
    }

    public static String c(Context r6) {
        Cursor r7 = com_tencent_open_b_a_android_content_ContentResolver_query(r6.getContentResolver(), a, null, null, null, null);     // Catch: SecurityException -> L11
        if (r7 != null) goto L5;
        return null;
    L5:
        r7.moveToFirst();     // Catch: SecurityException -> L11
        if (r7.isAfterLast() == false) goto L9;
        r7.close();     // Catch: SecurityException -> L11
        return null;
    L9:
        String r0 = r7.getString(r7.getColumnIndex("proxy"));     // Catch: SecurityException -> L11
        r7.close();     // Catch: SecurityException -> L11
        return r0;
    L11:
        e = move-exception;
        SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e.getMessage());
        return "";
    }

    private static String com_tencent_open_b_a_android_net_NetworkInfo_getExtraInfo(NetworkInfo r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102026);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.getExtraInfo();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static int d(Context r5) {
        NetworkInfo r1 = e(r5);     // Catch: Exception -> L59
        if (r1 != null) goto L7;
        return 128;
    L7:
        if (r1.getTypeName().toUpperCase().equals("WIFI") == false) goto L10;
        return 2;
    L10:
        String r2 = com_tencent_open_b_a_android_net_NetworkInfo_getExtraInfo(r1).toLowerCase();     // Catch: Exception -> L59
        if (r2.startsWith("cmwap") == false) goto L15;
        return 1;
    L15:
        if (r2.startsWith("cmnet") == false) goto L17;
        return 4;
    L17:
        if (r2.startsWith("epc.tmobile.com") == false) goto L20;
        return 4;
    L20:
        if (r2.startsWith("uniwap") == false) goto L24;
        return 16;
    L24:
        if (r2.startsWith("uninet") == false) goto L28;
        return 8;
    L28:
        if (r2.startsWith("wap") == false) goto L32;
        return 64;
    L32:
        if (r2.startsWith("net") == false) goto L36;
        return 32;
    L36:
        if (r2.startsWith("ctwap") == false) goto L39;
        return 512;
    L39:
        if (r2.startsWith("ctnet") == false) goto L42;
        return 256;
    L42:
        if (r2.startsWith("3gwap") == false) goto L46;
        return 1024;
    L46:
        if (r2.startsWith("3gnet") == false) goto L50;
        return 2048;
    L50:
        if (r2.startsWith("#777") == false) goto L61;
        String r6 = c(r5);     // Catch: Exception -> L59
        if (r6 == null) goto L56;
        if (r6.length() <= 0) goto L56;
        return 512;
    L56:
        return 256;
    L61:
        return 128;
    L59:
        e = move-exception;
        SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e.getMessage());
        goto L61
    }

    public static NetworkInfo e(Context r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();
    L7:
        return null;
    }

    private static Cursor com_tencent_open_b_a_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
