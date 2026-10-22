package com.bytedance.frameworks.baselib.network.http.cookie;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.keva.Keva;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WebviewCookieRawSyncUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Keva f2381a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JSONObject f2382b = null;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.cookie.WebviewCookieRawSyncUtil$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final enum SyncResult extends Enum<SyncResult> {
        private static final /* synthetic */ SyncResult[] $VALUES = null;
        public static final SyncResult EMPTY_COOKIE_DB = null;
        public static final SyncResult INVALID = null;
        public static final SyncResult QUERY_DB_FAILED = null;
        public static final SyncResult SUCCESS = null;
        public static final SyncResult TEMP_DB_NOT_EXIST = null;
        public static final SyncResult WEBVIEW_DB_COPY_FAILED = null;
        public static final SyncResult WEBVIEW_DB_NOT_EXIST = null;

        static {
            SyncResult r0 = new SyncResult("INVALID", 0);
            INVALID = r0;
            SyncResult r1 = new SyncResult("EMPTY_COOKIE_DB", 1);
            EMPTY_COOKIE_DB = r1;
            SyncResult r3 = new SyncResult("WEBVIEW_DB_NOT_EXIST", 2);
            WEBVIEW_DB_NOT_EXIST = r3;
            SyncResult r5 = new SyncResult("WEBVIEW_DB_COPY_FAILED", 3);
            WEBVIEW_DB_COPY_FAILED = r5;
            SyncResult r7 = new SyncResult("TEMP_DB_NOT_EXIST", 4);
            TEMP_DB_NOT_EXIST = r7;
            SyncResult r9 = new SyncResult("QUERY_DB_FAILED", 5);
            QUERY_DB_FAILED = r9;
            SyncResult r11 = new SyncResult("SUCCESS", 6);
            SUCCESS = r11;
            $VALUES = new SyncResult[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private SyncResult(String r1, int r2) {
            super(r1, r2);
        }

        public static SyncResult valueOf(String r2) {
            return (SyncResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(SyncResult.class, r2), SyncResult.class, "com.obric.memorydata.plugin");
        }

        public static SyncResult[] values() {
            return (SyncResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SyncResult[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SyncResult f2383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2384b;
        String c;
        List<e> d;

        private a() {
            this.f2383a = SyncResult.INVALID;
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        f2382b = new JSONObject();
        f2381a = Keva.getRepo("ttnetCookieConfig", 1);
    }

    private static long a(long r4) {
        if (r4 > 0) goto L6;
        return -1;
    L6:
        long r5 = (r4 / 1000) - 11644473600000L;
        if (r5 > 0) goto L9;
        return 0;
    L9:
        return r5;
    }

    private static File a(Context r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        File r0 = r11.getCacheDir();
        String r12 = g.d(r11);
        String r2 = "ttnet_cookie_raw_temp_";
        if (TextUtils.isEmpty(r12) == true) goto L5;
        r2 = "ttnet_cookie_raw_temp_" + r12;
    L5:
        File r13 = new File(r0, r2);
        if (r13.exists() == false) goto L8;
        r13.delete();
    L8:
        FileChannel r1 = null;
        FileInputStream r3 = new FileInputStream(r10);     // Catch: Throwable -> L26
        FileOutputStream r14 = new FileOutputStream(r13);     // Catch: Throwable -> L24
        FileChannel r8 = r3.getChannel();     // Catch: Throwable -> L22
        r1 = r14.getChannel();     // Catch: Throwable -> L20
        r1.transferFrom(r8, 0, r8.size());     // Catch: Throwable -> L20
        if (r1 != null) goto L70;
    L15:
        if (r8 != null) goto L62;
    L58:
        r14.close();     // Catch: IOException -> L44
    L54:
        r3.close();     // Catch: IOException -> L45
    L19:
        return r13;
    L62:
        r8.close();     // Catch: IOException -> L43
        goto L58
    L70:
        r1.close();     // Catch: IOException -> L42
    L20:
        th = th;
    L50:
    L32:
        th = move-exception;
        if (r1 != null) goto L60;
    L35:
        if (r8 != null) goto L72;
    L37:
        if (r14 != null) goto L66;
    L39:
        if (r3 == null) goto L76;
        r3.close();     // Catch: IOException -> L49
        throw th;
    L77:
        throw th;
    L76:
        throw th;
    L66:
        r14.close();     // Catch: IOException -> L48
        goto L39
    L72:
        r8.close();     // Catch: IOException -> L47
        goto L37
    L60:
        r1.close();     // Catch: IOException -> L46
        goto L35
    L29:
        if (r13.exists() == false) goto L31;
        r13.delete();     // Catch: Throwable -> L32
    L31:
        throw th;     // Catch: Throwable -> L32
    L22:
        th = th;
        r8 = null;
    L24:
        th = th;
        r14 = null;
        r8 = null;
    L26:
        th = th;
        r14 = null;
        r3 = null;
        r8 = null;
        goto L50
    }

    public static String a() {
        JSONObject r0 = f2382b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.length() <= 0) goto L7;
        String r1 = r0.toString();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = null;
        goto L8
    }

    private static String a(Context r6, a r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        ArrayList r1 = new ArrayList();
    L12:
        th = move-exception;
        th.printStackTrace();
    L14:
        Iterator r9 = r1.iterator();
    L16:
        if (r9.hasNext() == false) goto L21;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (new File(r0).exists() == false) goto L16;
        r7.f2384b = r1.indexOf(r0);
        return r0;
    L21:
        return null;
    L4:
        if (Build.VERSION.SDK_INT < 24) goto L6;
        String r3 = r8.getDataDir().getAbsolutePath();     // Catch: Throwable -> L12
    L7:
        String r10 = g.d(r8);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r10) == true) goto L10;
        r1.add(r3 + "/app_webviewbytedance_" + r10 + "/Cookies");     // Catch: Throwable -> L12
        r1.add(r3 + "/app_ttwebview_bytedance_" + r10 + "/cookie/Cookies");     // Catch: Throwable -> L12
        r1.add(r3 + "/app_webview_" + r10 + "/Default/Cookies");     // Catch: Throwable -> L12
        r1.add(r3 + "/hws_app_webview_" + r10 + "/Default/Cookies");     // Catch: Throwable -> L12
    L10:
        r1.add(r3 + "/app_webview/Default/Cookies");     // Catch: Throwable -> L12
        r1.add(r3 + "/hws_app_webview/Default/Cookies");     // Catch: Throwable -> L12
        goto L14
    L6:
        r3 = r8.getApplicationInfo().dataDir;     // Catch: Throwable -> L12
        goto L7
    }

    private static String a(Cursor r2, String r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        int r5 = r4.getColumnIndex(r3);
        if (r5 != (-1)) goto L5;
        return null;
    L5:
        if (r4.isNull(r5) == false) goto L8;
        return null;
    L8:
        return r4.getString(r5);
    }

    public static void a(Context r17, final SSCookieHandler.WebViewCookieMgrUsage r18) {
        final Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (com.bytedance.frameworks.baselib.network.a.b.f() == false) goto L7;
        return;
    L7:
        if (com.bytedance.frameworks.baselib.network.a.b.l() == false) goto L10;
        return;
    L10:
        if (g.b(r0) == true) goto L12;
        return;
    L12:
        Keva r1 = f2381a;
        int r5 = r1.getInt("cookie_sync_result", -1);
        long r8 = r1.getLong("cookie_last_sync_time", -1);
        boolean r4 = true;
        if (r5 == SyncResult.SUCCESS.ordinal()) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L24;
        long r11 = com.bytedance.frameworks.baselib.network.a.b.h();
        if (r8 >= 0) goto L20;
    L23:
        r2 = r4;
        goto L24
    L20:
        if ((System.currentTimeMillis() - r8) >= (r11 * 1000)) goto L23;
        r4 = false;
    L24:
        if (r2 == true) goto L27;
        String r12 = r1.getString("cookie_synced_error", null);
        a(true, r5, r1.getInt("cookie_db_path_index", -1), r8, r1.getLong("cookie_sync_cost_ms", -1), r12, r1.getLong("cookie_sync_count", -1));
        return;
    L27:
        com.bytedance.common.utility.a.a.b().schedule(new $$Lambda$WebviewCookieRawSyncUtil$cxhEmqQRA3RtuGwQg9wjHE8okQY(r0, r18), com.bytedance.frameworks.baselib.network.a.b.g(), TimeUnit.MILLISECONDS);
        return;
    L15:
        r2 = false;
        goto L16
    }

    private static void a(boolean r3, int r4, int r5, long r6, long r8, String r10, long r11) {
        JSONObject r0 = f2382b;
        monitor-enter(r0);
        r0.put("skip", r3);     // Catch: Throwable -> L23
        r0.put("result", r4);     // Catch: Throwable -> L23
        r0.put("p", r5);     // Catch: Throwable -> L23
        if (r3 == false) goto L10;
        if (r6 <= 0) goto L10;
        r0.put("after_s", (System.currentTimeMillis() - r6) / 1000);     // Catch: Throwable -> L23
    L10:
        if (r8 < 0) goto L13;
        r0.put("cost_ms", r8);     // Catch: Throwable -> L23
    L13:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        r0.put("error", r10);     // Catch: Throwable -> L23
    L16:
        if (r11 < 0) goto L26;
        r0.put(CommonConsts.COUNT_TYPE, r11);     // Catch: Throwable -> L23
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private static void b(Context r18, SSCookieHandler.WebViewCookieMgrUsage r19) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        a r4 = c(r0, r19);
        if (com.bytedance.common.utility.collection.a.a(r4.d) == true) goto L13;
        Iterator<e> r5 = r4.d.iterator();
    L6:
        if (r5.hasNext() == false) goto L13;
        e r1 = (e) ZeusTransformUtils.preCheckCast(r5.next(), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        com.bytedance.frameworks.baselib.network.http.impl.b.a().a(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Logger.e("WebviewCookieSyncUtil", "setHttpCookie failed", th);
    L13:
        long r11 = System.currentTimeMillis();
        long r13 = r11 - r2;
        int r9 = r4.f2383a.ordinal();
        Keva r3 = f2381a;
        r3.storeInt("cookie_sync_result", r9);
        r3.storeLong("cookie_last_sync_time", r11);
        r3.storeInt("cookie_db_path_index", r4.f2384b);
        r3.storeLong("cookie_sync_cost_ms", r13);
        if (com.bytedance.common.utility.collection.a.a(r4.d) == false) goto L16;
        long r6 = 0;
    L18:
        if (r6 <= 0) goto L21;
        r3.storeLong("cookie_sync_count", r6);
    L21:
        if (TextUtils.isEmpty(r4.c) == true) goto L23;
        r3.storeString("cookie_synced_error", r4.c);
    L24:
        a(false, r9, r4.f2384b, r11, r13, r4.c, r6);
        return;
    L23:
        r3.erase("cookie_synced_error");
        goto L24
    L16:
        r6 = r4.d.size();
        goto L18
    }

    public static boolean b() {
        if (f2381a.getInt("cookie_sync_result", -1) != SyncResult.SUCCESS.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.frameworks.baselib.network.http.cookie.WebviewCookieRawSyncUtil$1] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    private static a c(Context r12, SSCookieHandler.WebViewCookieMgrUsage r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        ?? r1 = 0;
        r1 = 0;
        a r0 = new a(r1);
        if (r13 != SSCookieHandler.WebViewCookieMgrUsage.DISABLED) goto L92;
    L10:
        String r15 = a(r14, r0);
        if (TextUtils.isEmpty(r15) == false) goto L104;
        r0.f2383a = SyncResult.WEBVIEW_DB_NOT_EXIST;
        return r0;
    L104:
        File r16 = a(r14, r15);     // Catch: Throwable -> L86
        if (r16 != null) goto L17;
    L84:
        r0.f2383a = SyncResult.TEMP_DB_NOT_EXIST;
        return r0;
    L17:
        if (r16.exists() == false) goto L84;
        SQLiteDatabase r17 = SQLiteDatabase.openDatabase(r16.getAbsolutePath(), null, 17);     // Catch: Throwable -> L68
        r1 = r17.query("cookies", null, null, null, null, null, null);     // Catch: Throwable -> L66
        if (r1 == 0) goto L55;
        if (r1.moveToFirst() == false) goto L55;
    L24:
        long r2 = a(r1.getLong(r1.getColumnIndexOrThrow("expires_utc")));     // Catch: Throwable -> L66
        if (r2 > 0) goto L27;
    L29:
        String r4 = a(r1, ActivityLifecycle.NAME);     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r4) == true) goto L53;
        String r5 = a(r1, EventBody.KEY_VALUE);     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r5) == false) goto L35;
        r5 = "";
    L35:
        String r6 = a(r1, "host_key");     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r6) == true) goto L53;
        String r7 = a(r1, "path");     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r7) == false) goto L41;
        r7 = "/";
    L41:
        boolean r9 = false;
        if (r1.getInt(r1.getColumnIndexOrThrow("is_secure")) != 1) goto L44;
        boolean r8 = true;
    L45:
        e r11 = new e();     // Catch: Throwable -> L66
        r11.b(r4);     // Catch: Throwable -> L66
        r11.c(r5);     // Catch: Throwable -> L66
        if (r6.startsWith(".") == true) goto L48;
        r9 = true;
    L48:
        r11.a(r6, r9);     // Catch: Throwable -> L66
        r11.a(r7);     // Catch: Throwable -> L66
        r11.a(r8);     // Catch: Throwable -> L66
        r11.b(String.valueOf(System.currentTimeMillis()), true);     // Catch: Throwable -> L66
        r11.a(r2);     // Catch: Throwable -> L66
        if (r0.d != null) goto L51;
        r0.d = new ArrayList();     // Catch: Throwable -> L66
    L51:
        r0.d.add(r11);     // Catch: Throwable -> L66
        goto L53
    L44:
        r8 = false;
    L53:
        if (r1.moveToNext() == true) goto L24;
    L27:
        if (r2 >= System.currentTimeMillis()) goto L29;
    L55:
        if (com.bytedance.common.utility.collection.a.a(r0.d) == false) goto L58;
        SyncResult r3 = SyncResult.EMPTY_COOKIE_DB;     // Catch: Throwable -> L66
    L57:
        r0.f2383a = r3;     // Catch: Throwable -> L66
        if (r1 != 0) goto L100;
    L62:
        if (r17 == null) goto L64;
        r17.close();     // Catch: Throwable -> L89
    L64:
        r16.delete();     // Catch: Throwable -> L89
    L65:
        return r0;
    L100:
        r1.close();     // Catch: Throwable -> L89
        goto L62
    L58:
        r3 = SyncResult.SUCCESS;     // Catch: Throwable -> L66
    L66:
        th = th;
    L98:
        r0.f2383a = SyncResult.QUERY_DB_FAILED;     // Catch: Throwable -> L77
        r0.c = th.getMessage();     // Catch: Throwable -> L77
        if (r1 != 0) goto L96;
    L73:
        if (r17 == null) goto L75;
        r17.close();     // Catch: Throwable -> L90
    L75:
        r16.delete();     // Catch: Throwable -> L90
    L76:
        return r0;
    L96:
        r1.close();     // Catch: Throwable -> L90
    L77:
        th = move-exception;
        if (r1 != 0) goto L94;
    L80:
        if (r17 == null) goto L82;
        r17.close();     // Catch: Throwable -> L91
    L82:
        r16.delete();     // Catch: Throwable -> L91
    L83:
        throw th;
    L94:
        r1.close();     // Catch: Throwable -> L91
    L68:
        th = th;
        r17 = null;
    L86:
        th = move-exception;
        r0.f2383a = SyncResult.WEBVIEW_DB_COPY_FAILED;
        r0.c = th.getMessage();
        return r0;
    L92:
    L8:
        th = move-exception;
        Logger.e("WebviewCookieSyncUtil", "CookieInitV2 CookieManager flush failed", th);
        goto L10
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L10;
        CookieManager.getInstance().flush();     // Catch: Throwable -> L8
        goto L10
    }

    private static /* synthetic */ void d(Context r2, SSCookieHandler.WebViewCookieMgrUsage r3) {
        b((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    public static /* synthetic */ void lambda$cxhEmqQRA3RtuGwQg9wjHE8okQY(Context r0, SSCookieHandler.WebViewCookieMgrUsage r1) {
        d(r0, r1);
    }
}
