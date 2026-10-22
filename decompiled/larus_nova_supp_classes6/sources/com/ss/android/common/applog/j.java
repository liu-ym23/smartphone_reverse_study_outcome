package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.StringUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class j {
    public final Context a;
    public final a b;
    public final b c;

    public class a {
        public final long[][] a;
        public final Map<String, C0004a> b;
        public final /* synthetic */ j c;

        /* JADX INFO: renamed from: com.ss.android.common.applog.j$a$a, reason: collision with other inner class name */
        public class C0004a {
            public int a;
            public int b;
            public int c;
            public long d;
            public long e;

            public C0004a() {
            }
        }

        public a(j r4) {
            this.c = r4;
            this.a = new long[][]{new long[]{120000, 0, 12}, new long[]{120000, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
            this.b = new HashMap();
        }
    }

    public class b {
        public int a;
        public int b;
        public long c;
        public int d;

        public b() {
            this.a = 0;
            this.b = 6;
            this.c = 0;
            this.d = 0;
        }
    }

    public j(Context r1) {
        this.a = r1;
        this.b = new a(this);
        this.c = new b();
    }

    public final boolean c(String r12) {
        a r0 = this.b;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (StringUtils.isEmpty(r12) == false) goto L7;
    L17:
        monitor-exit(r0);
        return true;
    L7:
        if (((HashMap) r0.b).containsKey(r12) == false) goto L17;
        a.C0004a r13 = (a.C0004a) ((HashMap) r0.b).get(r12);     // Catch: Throwable -> L19
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L19
        long r5 = r3 - r13.d;     // Catch: Throwable -> L19
        long[] r1 = r0.a[r13.a];     // Catch: Throwable -> L19
        if (r5 < r1[0]) goto L11;
        r13.b = 1;     // Catch: Throwable -> L19
        r13.d = r3;     // Catch: Throwable -> L19
        goto L17
    L11:
        int r4 = r13.b;     // Catch: Throwable -> L19
        if (r4 >= r1[2]) goto L15;
        r13.b = r4 + 1;     // Catch: Throwable -> L19
        goto L17
    L15:
        monitor-exit(r0);
        return false;
    }

    public final void d(JSONObject r9) {
        b r0 = this.c;
        if (r0 == null) goto L26;
        int r1 = r9.optInt("backoff_ratio", 0);
        r0.a = r1;
        if (r1 >= 0) goto L7;
    L8:
        r0.a = 0;
    L10:
        if (r0.a <= 0) goto L12;
        int r2 = 1;
    L13:
        int r10 = r9.optInt("max_request_frequency", r2);
        r0.b = r10;
        if (r10 < 1) goto L16;
        if (r10 > 6) goto L16;
    L17:
        int r11 = r0.a;
        if (r11 > 0) goto L20;
    L22:
        if (r11 != 0) goto L24;
        r0.c = 0;
        r0.d = 0;
    L24:
        ita.j.g("RatioDowngradeStrategy updateRatioDowngradeParams mBackoffRatio: " + r0.a + ", mMaxRequestFrequency: " + r0.b + ", mBackoffWindowStartTime: " + r0.c + ", mBackoffWindowSendCount: " + r0.d, null);
        return;
    L20:
        if (r0.c != 0) goto L22;
        r0.c = System.currentTimeMillis();
        r0.d = 1;
    L16:
        r0.b = r2;
        goto L17
    L12:
        r2 = 6;
        goto L13
    L7:
        if (r1 <= 10000) goto L10;
    }

    public final void b(int r13, String[] r14) {
        a r0 = this.b;
        monitor-enter(r0);
        String r15 = r14[r13];     // Catch: Throwable -> L28
        if (StringUtils.isEmpty(r15) == false) goto L7;
    L26:
        monitor-exit(r0);
        return;
    L7:
        if (((HashMap) r0.b).containsKey(r15) == false) goto L26;
        a.C0004a r1 = (a.C0004a) ((HashMap) r0.b).get(r15);     // Catch: Throwable -> L28
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L28
        int r4 = r1.c;     // Catch: Throwable -> L28
        long r5 = r4;
        long[][] r7 = r0.a;     // Catch: Throwable -> L28
        int r8 = r1.a;     // Catch: Throwable -> L28
        if (r5 < r7[r8][1]) goto L11;
    L14:
        if (r8 <= 0) goto L26;
        r1.a = r8 - 1;     // Catch: Throwable -> L28
        r1.b = 1;     // Catch: Throwable -> L28
        r1.c = 1;     // Catch: Throwable -> L28
        r1.d = r2;     // Catch: Throwable -> L28
        r1.e = r2;     // Catch: Throwable -> L28
        int r6 = 0;
        SharedPreferences.Editor r9 = r0.c.a.getSharedPreferences(kta.b.a, 0).edit();     // Catch: Throwable -> L28
        int r10 = r14.length;     // Catch: Throwable -> L28
    L16:
        if (r6 >= r10) goto L25;
        String r11 = r14[r6];     // Catch: Throwable -> L28
        if (StringUtils.isEmpty(r11) == true) goto L24;
        if (r11.equals(r15) == true) goto L24;
        if (((HashMap) r0.b).containsKey(r11) == false) goto L24;
        a.C0004a r12 = (a.C0004a) ((HashMap) r0.b).get(r11);     // Catch: Throwable -> L28
        r12.getClass();     // Catch: Throwable -> L28
        r12.a = r1.a;     // Catch: Throwable -> L28
        r12.b = r1.b;     // Catch: Throwable -> L28
        r12.c = r1.c;     // Catch: Throwable -> L28
        r12.d = r1.d;     // Catch: Throwable -> L28
        r12.e = r1.e;     // Catch: Throwable -> L28
        r9.putLong(r11 + "_downgrade_time", r2);     // Catch: Throwable -> L28
        r9.putInt(r11 + "_downgrade_index", r12.a);     // Catch: Throwable -> L28
    L24:
        r6 = r6 + 1;     // Catch: Throwable -> L28
        goto L16
    L25:
        r9.putLong(r15 + "_downgrade_time", r2);     // Catch: Throwable -> L28
        r9.putInt(r15 + "_downgrade_index", r1.a);     // Catch: Throwable -> L28
        r9.commit();     // Catch: Throwable -> L28
        goto L26
    L11:
        if ((r2 - r1.e) > 1800000) goto L14;
        r1.c = r4 + 1;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final void a(int r11, String[] r12, Throwable r13) {
        a r0 = this.b;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if ((r13 instanceof CommonHttpException) == false) goto L28;
        int r14 = ((CommonHttpException) r13).getResponseCode();     // Catch: Throwable -> L30
        if (r14 < 500) goto L28;
        if (r14 >= 600) goto L28;
        String r15 = r12[r11];     // Catch: Throwable -> L30
        if (StringUtils.isEmpty(r15) == true) goto L28;
        if (((HashMap) r0.b).containsKey(r15) == false) goto L28;
        a.C0004a r16 = (a.C0004a) ((HashMap) r0.b).get(r15);     // Catch: Throwable -> L30
        int r1 = r16.a;     // Catch: Throwable -> L30
        int r4 = 0;
        if (r1 >= (r0.a.length - 1)) goto L27;
        r16.a = r1 + 1;     // Catch: Throwable -> L30
        r16.b = 1;     // Catch: Throwable -> L30
        r16.c = 0;     // Catch: Throwable -> L30
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L30
        r16.d = r2;     // Catch: Throwable -> L30
        r16.e = r2;     // Catch: Throwable -> L30
        SharedPreferences.Editor r3 = r0.c.a.getSharedPreferences(kta.b.a, 0).edit();     // Catch: Throwable -> L30
        int r5 = r12.length;     // Catch: Throwable -> L30
    L17:
        if (r4 >= r5) goto L26;
        String r6 = r12[r4];     // Catch: Throwable -> L30
        if (StringUtils.isEmpty(r6) == true) goto L25;
        if (r6.equals(r15) == true) goto L25;
        if (((HashMap) r0.b).containsKey(r6) == false) goto L25;
        a.C0004a r7 = (a.C0004a) ((HashMap) r0.b).get(r6);     // Catch: Throwable -> L30
        r7.getClass();     // Catch: Throwable -> L30
        r7.a = r16.a;     // Catch: Throwable -> L30
        r7.b = r16.b;     // Catch: Throwable -> L30
        r7.c = r16.c;     // Catch: Throwable -> L30
        r7.d = r16.d;     // Catch: Throwable -> L30
        r7.e = r16.e;     // Catch: Throwable -> L30
        r3.putLong(r6 + "_downgrade_time", r2);     // Catch: Throwable -> L30
        r3.putInt(r6 + "_downgrade_index", r7.a);     // Catch: Throwable -> L30
    L25:
        r4 = r4 + 1;     // Catch: Throwable -> L30
        goto L17
    L26:
        r3.putLong(r15 + "_downgrade_time", r2);     // Catch: Throwable -> L30
        r3.putInt(r15 + "_downgrade_index", r16.a);     // Catch: Throwable -> L30
        r3.commit();     // Catch: Throwable -> L30
        goto L28
    L27:
        r16.c = 0;     // Catch: Throwable -> L30
    L28:
        monitor-exit(r0);
    }
}
