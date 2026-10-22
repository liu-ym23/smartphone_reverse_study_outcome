package com.ss.android.common.a;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.compat.Level;
import com.bytedance.bdinstall.compat.intf.IAppTraitCallback;
import com.bytedance.common.utility.Logger;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.MonitorKey;
import com.ss.android.common.applog.MonitorState;
import com.ss.android.common.applog.y;
import com.ss.android.common.applog.z;
import com.ss.android.deviceregister.a.u;
import com.ss.android.deviceregister.d.c;
import com.ss.android.deviceregister.f;
import com.ss.android.deviceregister.h;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f15021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f15022b;

    /* JADX INFO: renamed from: com.ss.android.common.a.a$a, reason: collision with other inner class name */
    public static class C0805a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f15024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f15025b;
        private final boolean c;
        private Context d;
        private String[] e;
        private long f;

        public C0805a(Context r3, String[] r4, boolean r5, boolean r6, b r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
            this.d = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
            this.e = r4;
            this.f15024a = r5;
            this.f = System.currentTimeMillis();
            this.f15025b = r9;
            this.c = r6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (a.b() > 0) goto L5;
            a.a(this.f);
        L5:
            boolean r0 = a.b(this.d, this.e, this.f15024a, this.c);
            b r1 = this.f15025b;
            if (r1 == null) goto L8;
            r1.a(r0);
        L8:
            if (r0 == false) goto L14;
            long r2 = System.currentTimeMillis();
            if (a.b() <= 0) goto L12;
            com.ss.android.common.applog.b.a(MonitorKey.active, MonitorState.total_success, r2 - a.b());
            a.a(0);
        L12:
            com.ss.android.common.applog.b.a(MonitorKey.active, MonitorState.success, r2 - this.f);
            return;
        }
    }

    public interface b {
        void a(boolean r1);
    }

    static /* synthetic */ long a(long r0) {
        f15021a = r0;
        return r0;
    }

    private static String a(String r1, String r2, String r3) {
    L7:
        th = move-exception;
        th.printStackTrace();
        return r1;
    L3:
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r1;
    L5:
        return Uri.parse(r1).buildUpon().appendQueryParameter(r2, r3).build().toString();
    }

    public static void a(Context r6, String[] r7, boolean r8, boolean r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r9 == true) goto L5;
    L7:
        new C0805a(r1, r7, r8, !f15022b, new AnonymousClass2()).start();
        return;
    L5:
        if (f15022b == false) goto L7;
    }

    private static void a(StringBuilder r2, String r3, String r4, boolean r5) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        return;
    L9:
        if (r2.toString().indexOf(63) >= 0) goto L11;
        String r0 = "?";
    L12:
        r2.append(r0);
        StringBuilder r6 = r2.append(r3).append("=");
        if (r5 == false) goto L15;
        r4 = Uri.encode(r4);
    L15:
        r6.append(r4);
        return;
    L11:
        r0 = "&";
        goto L12
    }

    static /* synthetic */ boolean a() {
        return f15022b;
    }

    static /* synthetic */ boolean a(boolean r0) {
        f15022b = r0;
        return r0;
    }

    static /* synthetic */ long b() {
        return f15021a;
    }

    static /* synthetic */ boolean b(Context r2, String[] r3, boolean r4, boolean r5) {
        return c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    private static long c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private static boolean c(Context r9, String[] r10, boolean r11, final boolean r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        boolean r3 = f.f();     // Catch: Exception -> L56
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L56
        if (r11 == true) goto L20;
        if (r3 == true) goto L20;
        Pair<String, Boolean> r14 = h.a(r13);     // Catch: Exception -> L37
        if (r14 == null) goto L20;
        if (r14.second != null) goto L12;
    L14:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
        String r6 = "1";
    L19:
        a(r4, "gaid_limited", r6, true);     // Catch: Exception -> L37
        a(r4, "google_aid", (String) ZeusTransformUtils.preCheckCast(r14.first, String.class, "com.obric.memorydata.plugin"), true);     // Catch: Exception -> L37
        goto L20
    L18:
        r6 = "0";
        goto L19
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14.second, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L14;
        r5 = true;
    L37:
        e = move-exception;
        Logger.w("ActiveUser", "prepare app_alert param exception: " + e);     // Catch: Exception -> L56
    L39:
        LinkedHashMap r15 = new LinkedHashMap();     // Catch: Exception -> L56
        y.a(r15, true, Level.L0);     // Catch: Exception -> L56
        int r16 = r10.length;     // Catch: Exception -> L56
        int r2 = 0;
    L40:
        if (r2 >= r16) goto L54;
        StringBuilder r7 = new StringBuilder(r10[r2]);     // Catch: Exception -> L56
        r7.append(r4.toString());     // Catch: Exception -> L56
        y.a(r7, r15);     // Catch: Exception -> L56
        String r8 = a(r7.toString(), "req_id", f.l());     // Catch: Exception -> L56
        com.ss.android.common.b.b.c("request : " + r8);     // Catch: Exception -> L56
        HashMap r17 = new HashMap();     // Catch: Exception -> L56
        Pair<String, String> r18 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new AnonymousClass1(r12));     // Catch: Throwable -> L46
        if (r18 == null) goto L62;
        r17.put(r18.first, r18.second);     // Catch: Throwable -> L46
    L62:
        String r19 = com.bytedance.common.utility.f.a().a(z.a(r8), r17, null);     // Catch: Throwable -> L59
        com.ss.android.common.b.b.b("NetworkClient.getDefault().get response:" + r19);     // Catch: Throwable -> L59
        if (com.bytedance.common.utility.h.a(r19) == true) goto L53;
        if ("success".equals(new JSONObject(r19).optString("message")) == false) goto L53;
        return true;
    L53:
        r2 = r2 + 1;
    L46:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L56
        goto L62
    L54:
        com.ss.android.common.applog.b.a(MonitorKey.active, MonitorState.f_resp_error);     // Catch: Exception -> L56
    L58:
        return false;
    L20:
        float r110 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;     // Catch: Exception -> L37
        if (r110 >= (-12.0f)) goto L24;
        r110 = -12.0f;
    L24:
        if (r110 <= 12.0f) goto L26;
        r110 = 12.0f;
    L26:
        a(r4, Api.KEY_TIMEZONE, r110 + "", false);     // Catch: Exception -> L37
        IAppTraitCallback r111 = f.g();     // Catch: Exception -> L37
        if (r111 == null) goto L29;
        a(r4, "app_trait", r111.get(r13), true);     // Catch: Exception -> L37
    L29:
        String r112 = u.a();     // Catch: Exception -> L37
        if (TextUtils.isEmpty(r112) == true) goto L32;
        a(r4, "package", r112, true);     // Catch: Exception -> L37
        a(r4, Api.KEY_REAL_PACKAGE_NAME, r13.getPackageName(), true);     // Catch: Exception -> L37
    L32:
        a(r4, Api.KEY_CARRIER, c.e(r13), true);     // Catch: Exception -> L37
        a(r4, Api.KEY_MCC_MNC, c.d(r13), true);     // Catch: Exception -> L37
        a(r4, Api.KEY_SIM_REGION, c.f(r13), true);     // Catch: Exception -> L37
        a(r4, "custom_bt", String.valueOf(c()), true);     // Catch: Exception -> L37
        if (u.f() == false) goto L35;
        com.ss.android.deviceregister.a.f.a(r13, r4);     // Catch: Exception -> L37
    L35:
        a(r4, Api.KEY_APP_VERSION_MINOR, AppLog.A(), true);     // Catch: Exception -> L37
    L56:
        e = move-exception;
        com.ss.android.common.applog.b.a(MonitorKey.active, MonitorState.f_exception);
        Logger.e("ActiveUser", "NetworkClient.getDefault().get exception:" + e);
        goto L58
    }
}
