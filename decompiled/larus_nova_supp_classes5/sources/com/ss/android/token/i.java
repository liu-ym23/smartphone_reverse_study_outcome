package com.ss.android.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.account.utils.d;
import com.ss.android.account.k;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i {
    public static volatile j a;
    public static volatile boolean b;
    public static final List<a> c = null;

    public interface a {
        void a(j r1, j r2);
    }

    static {
        c = new ArrayList();
    }

    public static void a(a r2) {
        List<a> r0 = c;
        monitor-enter(r0);
        ((ArrayList) r0).add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static j b(Context r14) {
        if (b == true) goto L11;
        j r2 = null;
        String r15 = r14.getSharedPreferences("bd_account_sec_time", 0).getString("sec_time_struct", null);
        if (r15 == null) goto L9;
        int r0 = j.h;
        JSONObject r1 = new JSONObject(r15);     // Catch: Exception -> L12
        r2 = new j(r1.optString("secTime", ""), r1.optLong("serverTime", 0), r1.optLong("systemTime", 0), r1.optLong("elapsedRealTimeMs", 0), r1.optInt("rebootTimes", 0), null, null);
    L9:
        a = r2;
        b = true;
    L11:
        return a;
    }

    public static void c(String r5, String r6, String r7) {
        Context r0 = k.c();
        if (r0 != null) goto L5;
        j r1 = null;
    L6:
        if (r1 != null) goto L8;
        long r2 = -1;
    L9:
        int r4 = 0;
        Pair[] r3 = {TuplesKt.to("host", r5), TuplesKt.to(DownloadConstants.PATH_KEY, r6), TuplesKt.to("logid", r7), TuplesKt.to("sec_ts_age", Long.valueOf(r2)), TuplesKt.to("is_in_foreground", Integer.valueOf(d.d() ? 1 : 0))};
        JSONObject r8 = new JSONObject();
    L10:
        if (r4 >= 5) goto L12;
        Pair r9 = r3[r4];
        r8.putOpt((String) r9.getFirst(), r9.getSecond());
        r4 = r4 + 1;
        goto L10
    L12:
        com.bytedance.sdk.account.monitor.a.a("bd_ticket_guard_sec_ts_not_found", r8);
        return;
    L8:
        r2 = System.currentTimeMillis() - r1.c;
        goto L9
    L5:
        r1 = b(r0);
        goto L6
    }

    public static boolean d(Context r22, String r23, String r24, long r25, long r27, long r29, String r31) {
        j r9 = a;
        long r16 = 0;
        if (r9 == null) goto L5;
        long r1 = r9.b;
    L7:
        if (r9 != null) goto L9;
    L12:
        int r18 = com.bytedance.sdk.account.time.e.a(r22);
        j r8 = new j(r24, r25, r29, r27, r18, r23, r31);
        a = r8;
        SharedPreferences.Editor r2 = r22.getSharedPreferences("bd_account_sec_time", 0).edit();
        Pair[] r4 = {TuplesKt.to("secTime", r24), TuplesKt.to("serverTime", Long.valueOf(r25)), TuplesKt.to("systemTime", Long.valueOf(r29)), TuplesKt.to("elapsedRealTimeMs", Long.valueOf(r27)), TuplesKt.to("rebootTimes", Integer.valueOf(r18))};
        JSONObject r5 = new JSONObject();
        int r10 = 0;
    L13:
        if (r10 >= 5) goto L15;
        Pair r11 = r4[r10];
        r5.putOpt((String) r11.getFirst(), r11.getSecond());
        r10 = r10 + 1;
        goto L13
    L15:
        r2.putString("sec_time_struct", r5.toString()).apply();
        tb7.a.d("SecTimeManager", "updateSecTime, serverTimeMs: " + r25 + ", elapsedRealTime: " + r27 + ", systemTime: " + r29 + ", secTime: " + r24);
        if (r23 == null) goto L18;
        String r3 = r23;
    L19:
        String r6 = "";
        String r7 = r8.a;
        long r12 = r8.b;
        long r13 = r8.c;
        long r14 = r8.d;
        if (r9 == null) goto L24;
        String r15 = r9.a;
        if (r15 == null) goto L24;
        r6 = r15;
    L24:
        if (r9 == null) goto L26;
        long r17 = r9.b;
    L27:
        if (r9 == null) goto L29;
        long r19 = r9.c;
    L30:
        if (r9 == null) goto L32;
        r16 = r9.d;
    L32:
        Pair[] r110 = {TuplesKt.to("server_sec_ts", r7), TuplesKt.to("server_origin_ts", Long.valueOf(r12)), TuplesKt.to("local_ts", Long.valueOf(r13)), TuplesKt.to("local_system_run_ts", Long.valueOf(r14)), TuplesKt.to("last_server_sec_ts", r6), TuplesKt.to("last_server_origin_ts", Long.valueOf(r17)), TuplesKt.to("last_local_ts", Long.valueOf(r19)), TuplesKt.to("last_local_system_run_ts", Long.valueOf(r16)), TuplesKt.to("scene", "interceptor"), TuplesKt.to("logid", null), TuplesKt.to(DownloadConstants.PATH_KEY, r3)};
        JSONObject r0 = new JSONObject();
        int r20 = 0;
    L33:
        if (r20 >= 11) goto L35;
        Pair r21 = r110[r20];
        r0.put((String) r21.getFirst(), r21.getSecond());
        r20 = r20 + 1;
        goto L33
    L35:
        com.bytedance.sdk.account.monitor.a.a("bd_ticket_guard_sec_ts_update", r0);
        List<a> r26 = c;
        monitor-enter(r26);
        Iterator r28 = ((ArrayList) r26).iterator();     // Catch: Throwable -> L45
    L39:
        if (r28.hasNext() == false) goto L41;
        ((a) r28.next()).a(r8, r9);     // Catch: Throwable -> L45
        goto L39
    L41:
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r26);
        return true;
    L45:
        th = move-exception;
        throw th;
    L29:
        r19 = 0;
        goto L30
    L26:
        r17 = 0;
        goto L27
    L18:
        r3 = "";
        goto L19
    L9:
        if (r25 > r1) goto L12;
        tb7.a.e("SecTimeManager", "updateSecTime aborted because server time recedes, serverTimeMs: " + r25 + ", lastServerTime: " + r1 + ", elapsedRealTime: " + r27 + ", systemTime: " + r29 + ", secTime: " + r24);
        return false;
    L5:
        r1 = 0;
        goto L7
    }
}
