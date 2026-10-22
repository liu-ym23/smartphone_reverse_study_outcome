package com.miui.easygo.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.miui.easygo.constant.EasyGoDbTable;
import com.miui.easygo.sdk.module.EasyGoServer;
import f06.b;
import f06.c;
import f06.d;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
class DatabaseUtil extends BaseUtil {
    private static final Uri EASYGO_SERVER_URI = null;
    private static final String TAG = "DatabaseUtil";

    static {
        EASYGO_SERVER_URI = UriProtector.parse("content://com.miui.easygo.easygoprovider/t_server");
    }

    public DatabaseUtil() {
    }

    private static EasyGoServer assembleServer(Cursor r8) {
        EasyGoServer r0 = new EasyGoServer();
        if (r8 != null) goto L5;
        return r0;
    L5:
        r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.NAME));
        r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.PROVIDE_FUNCTION));
        r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.IS_SYSTEM_SERVICE));
        r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.DATA_SCHEMA));
        r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.SERVICE_NAME));
        r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.SERVICE_VERSION));
        r0.setName(r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.NAME)));
        r0.setProvideFunction(r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.PROVIDE_FUNCTION)));
        r0.setIsSysService(r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.IS_SYSTEM_SERVICE)));
        r0.setDataSchema(r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.DATA_SCHEMA)));
        r0.setServiceName(r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.SERVICE_NAME)));
        r0.setServiceVersion(r8.getString(r8.getColumnIndex(EasyGoDbTable.Server.SERVICE_VERSION)));
        return r0;
    }

    public static boolean isDbSupport(Context r6) {
        Cursor r7 = com_miui_easygo_util_DatabaseUtil_android_content_ContentResolver_query(r6.getContentResolver(), EASYGO_SERVER_URI, null, "provide_function = \"\"", null, null);
        if (r7 != null) goto L5;
        boolean r0 = false;
    L6:
        if (r7 == null) goto L8;
        r7.close();
    L8:
        return r0;
    L5:
        r0 = true;
        goto L6
    }

    public static EasyGoServer queryServerInfo(Context r8, String r9) {
        Cursor r1 = null;
        EasyGoServer r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        String r10 = r9.trim().toLowerCase(Locale.ENGLISH);     // Catch: Throwable -> L24 IllegalArgumentException -> L26
        Cursor r11 = com_miui_easygo_util_DatabaseUtil_android_content_ContentResolver_query(r8.getContentResolver(), EASYGO_SERVER_URI, null, "provide_function = \"" + r10 + "\"", null, null);     // Catch: Throwable -> L24 IllegalArgumentException -> L26
        if (r11 == null) goto L20;
    L17:
        e = e;
    L28:
        e.getMessage();     // Catch: Throwable -> L32
        if (r11 == null) goto L31;
        r11.close();
    L31:
        return r2;
    L32:
        th = th;
        r1 = r11;
    L34:
        if (r1 == null) goto L36;
        r1.close();
    L36:
        throw th;
    L6:
        if (r11.getCount() == 0) goto L20;
        r11.moveToFirst();     // Catch: IllegalArgumentException -> L17 Throwable -> L32
    L8:
        EasyGoServer r12 = assembleServer(r11);     // Catch: IllegalArgumentException -> L17 Throwable -> L32
        if (r2 != null) goto L12;
    L13:
        r2 = r12;
    L15:
        if (r11.moveToNext() == true) goto L8;
    L12:
        if ("1".equals(r12.getIsSysService()) == false) goto L15;
    L20:
        r2.getServiceVersion();     // Catch: IllegalArgumentException -> L17 Throwable -> L32
        if (r11 == null) goto L23;
        r11.close();
    L23:
        return r2;
    L26:
        e = e;
        r11 = null;
    L24:
        th = th;
        goto L34
    }

    private static Cursor com_miui_easygo_util_DatabaseUtil_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        c r8 = new c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        b r10 = new b();
        d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r12 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r12, r10, true);
        return r12;
    }
}
