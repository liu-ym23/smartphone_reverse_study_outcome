package com.tencent.open.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class h {
    private static boolean a(String r4) {
        if (r4 != null) goto L5;
    L18:
        return false;
    L5:
        if (r4.isEmpty() == true) goto L18;
        String[] r5 = r4.split("\\.");
        if (r5.length >= 3) goto L10;
        return false;
    L10:
        int r1 = r5.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L16;
        CastIntegerProtector.parseInt(r5[r2]);     // Catch: NumberFormatException -> L15
        r2 = r2 + 1;
    L15:
        return false;
    L16:
        return true;
    }

    public static String a(Context r3, String r4, String r5) {
        if (r3 == null) goto L15;
        if (r5 == null) goto L15;
        if (r4 == null) goto L15;
        if ("com.tencent.mobileqq".equals(r5) == false) goto L12;
        return b(r3, r4, "com.tencent.mobileqq");
    L12:
        if ("com.tencent.tim".equals(r5) == false) goto L15;
        return b(r3, r4, "com.tencent.tim");
    L15:
        return null;
    }

    private static String b(Context r3, String r4, String r5) {
        Cursor r6 = c(r3, r4, r5);     // Catch: Exception -> L16
        if (r6 != null) goto L8;
        SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion null");     // Catch: Exception -> L16
        return null;
    L8:
        if (r6.getCount() > 0) goto L11;
        SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion empty");     // Catch: Exception -> L16
        return null;
    L11:
        r6.moveToFirst();     // Catch: Exception -> L16
        String r7 = r6.getString(0);     // Catch: Exception -> L16
        r6.close();     // Catch: Exception -> L16
        SLog.i("openSDK_LOG.OpenApiProviderUtils", "AppVersion: " + r7);     // Catch: Exception -> L16
        if (a(r7) == false) goto L14;
        return r7;
    L14:
        return "UNKNOWN";
    L16:
        e = move-exception;
        SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion exception: ", e);
        return null;
    }

    private static Cursor c(Context r10, String r11, String r12) {
        if (r10 != null) goto L10;
        return null;
    L10:
        return com_tencent_open_utils_h_android_content_ContentResolver_query(r10.getContentResolver(), UriProtector.parse("content://" + r12 + ".openapi.provider/query_app_version?appid=" + r11 + "&pkgName=" + r10.getPackageName()), new String[0], null, null, null);
    L7:
        e = move-exception;
        SLog.e("openSDK_LOG.OpenApiProviderUtils", "query exception: ", e);
        return null;
    }

    private static Cursor com_tencent_open_utils_h_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
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
