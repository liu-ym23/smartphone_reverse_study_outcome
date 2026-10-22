package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f15076b;
    private b c;

    /* JADX INFO: renamed from: com.ss.android.common.applog.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[][] f15078b;
        private Map<String, C0807a> c;

        /* JADX INFO: renamed from: com.ss.android.common.applog.e$a$a, reason: collision with other inner class name */
        class C0807a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f15079a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f15080b;
            int c;
            long d;
            long e;
            final /* synthetic */ a f;

            C0807a(a r1) {
                this.f = r1;
            }

            void a(C0807a r3) {
                this.f15079a = r3.f15079a;
                this.f15080b = r3.f15080b;
                this.c = r3.c;
                this.d = r3.d;
                this.e = r3.e;
            }
        }

        private a(e r4) {
            this.f15077a = r4;
            this.f15078b = new long[][]{new long[]{120000, 0, 12}, new long[]{120000, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
            this.c = new HashMap();
        }

        /* synthetic */ a(e r1, AnonymousClass1 r2) {
            this(r1);
        }

        public synchronized void a(int r11, String[] r12) {
            monitor-enter(this);
            String r13 = r12[r11];     // Catch: Throwable -> L28
            if (com.bytedance.common.utility.h.a(r13) == false) goto L6;
        L26:
            monitor-exit(this);
            return;
        L6:
            if (this.c.containsKey(r13) == false) goto L26;
            C0807a r0 = (C0807a) ZeusTransformUtils.preCheckCast(this.c.get(r13), C0807a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            long r1 = System.currentTimeMillis();     // Catch: Throwable -> L28
            if (r0.c >= this.f15078b[r0.f15079a][1]) goto L14;
            if ((r1 - r0.e) > 1800000) goto L14;
            r0.c++;     // Catch: Throwable -> L28
        L14:
            if (r0.f15079a <= 0) goto L26;
            r0.f15079a--;     // Catch: Throwable -> L28
            r0.f15080b = 1;     // Catch: Throwable -> L28
            r0.c = 1;     // Catch: Throwable -> L28
            r0.d = r1;     // Catch: Throwable -> L28
            r0.e = r1;     // Catch: Throwable -> L28
            int r5 = 0;
            SharedPreferences.Editor r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.a(this.f15077a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit();     // Catch: Throwable -> L28
            int r4 = r12.length;     // Catch: Throwable -> L28
        L16:
            if (r5 >= r4) goto L25;
            String r6 = r12[r5];     // Catch: Throwable -> L28
            if (com.bytedance.common.utility.h.a(r6) == true) goto L24;
            if (r6.equals(r13) == true) goto L24;
            if (this.c.containsKey(r6) == false) goto L24;
            C0807a r7 = (C0807a) ZeusTransformUtils.preCheckCast(this.c.get(r6), C0807a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            r7.a(r0);     // Catch: Throwable -> L28
            r3.putLong(r6 + "_downgrade_time", r1);     // Catch: Throwable -> L28
            r3.putInt(r6 + "_downgrade_index", r7.f15079a);     // Catch: Throwable -> L28
        L24:
            r5 = r5 + 1;     // Catch: Throwable -> L28
            goto L16
        L25:
            r3.putLong(r13 + "_downgrade_time", r1);     // Catch: Throwable -> L28
            r3.putInt(r13 + "_downgrade_index", r0.f15079a);     // Catch: Throwable -> L28
            r3.commit();     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        }

        public synchronized void a(int r10, String[] r11, Throwable r12) {
            monitor-enter(this);
        L29:
            th = move-exception;
            throw th;
        L4:
            if (ZeusTransformUtils.instanceOf(r12, CommonHttpException.class) == false) goto L27;
            int r13 = ((CommonHttpException) ZeusTransformUtils.preCheckCast(r12, CommonHttpException.class, "com.obric.memorydata.plugin")).getResponseCode();     // Catch: Throwable -> L29
            if (r13 < 500) goto L27;
            if (r13 >= 600) goto L27;
            String r14 = r11[r10];     // Catch: Throwable -> L29
            if (com.bytedance.common.utility.h.a(r14) == true) goto L27;
            if (this.c.containsKey(r14) == false) goto L27;
            C0807a r15 = (C0807a) ZeusTransformUtils.preCheckCast(this.c.get(r14), C0807a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
            int r3 = 0;
            if (r15.f15079a >= (this.f15078b.length - 1)) goto L26;
            r15.f15079a++;     // Catch: Throwable -> L29
            r15.f15080b = 1;     // Catch: Throwable -> L29
            r15.c = 0;     // Catch: Throwable -> L29
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L29
            r15.d = r0;     // Catch: Throwable -> L29
            r15.e = r0;     // Catch: Throwable -> L29
            SharedPreferences.Editor r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.a(this.f15077a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0).edit();     // Catch: Throwable -> L29
            int r4 = r11.length;     // Catch: Throwable -> L29
        L16:
            if (r3 >= r4) goto L25;
            String r5 = r11[r3];     // Catch: Throwable -> L29
            if (com.bytedance.common.utility.h.a(r5) == true) goto L24;
            if (r5.equals(r14) == true) goto L24;
            if (this.c.containsKey(r5) == false) goto L24;
            C0807a r6 = (C0807a) ZeusTransformUtils.preCheckCast(this.c.get(r5), C0807a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
            r6.a(r15);     // Catch: Throwable -> L29
            r2.putLong(r5 + "_downgrade_time", r0);     // Catch: Throwable -> L29
            r2.putInt(r5 + "_downgrade_index", r6.f15079a);     // Catch: Throwable -> L29
        L24:
            r3 = r3 + 1;     // Catch: Throwable -> L29
            goto L16
        L25:
            r2.putLong(r14 + "_downgrade_time", r0);     // Catch: Throwable -> L29
            r2.putInt(r14 + "_downgrade_index", r15.f15079a);     // Catch: Throwable -> L29
            r2.commit();     // Catch: Throwable -> L29
            goto L27
        L26:
            r15.c = 0;     // Catch: Throwable -> L29
        L27:
            monitor-exit(this);
        }

        public synchronized void a(String r9) {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (com.bytedance.common.utility.h.a(r9) == false) goto L6;
        L12:
            monitor-exit(this);
            return;
        L6:
            if (this.c.containsKey(r9) == true) goto L12;
            C0807a r0 = new C0807a(this);     // Catch: Throwable -> L14
            SharedPreferences r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.a(this.f15077a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(com.ss.android.deviceregister.a.b.a(), 0);     // Catch: Throwable -> L14
            if ((System.currentTimeMillis() - r1.getLong(r9 + "_downgrade_time", 0)) >= 10800000) goto L10;
            r0.f15079a = r1.getInt(r9 + "_downgrade_index", 0);     // Catch: Throwable -> L14
        L11:
            this.c.put(r9, r0);     // Catch: Throwable -> L14
            goto L12
        L10:
            r1.edit().remove(r9 + "_downgrade_time").remove(r9 + "_downgrade_index").commit();     // Catch: Throwable -> L14
            goto L11
        }

        public synchronized boolean b(String r10) {
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L4:
            if (com.bytedance.common.utility.h.a(r10) == false) goto L6;
        L16:
            monitor-exit(this);
            return true;
        L6:
            if (this.c.containsKey(r10) == false) goto L16;
            C0807a r11 = (C0807a) ZeusTransformUtils.preCheckCast(this.c.get(r10), C0807a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
            long r2 = System.currentTimeMillis();     // Catch: Throwable -> L18
            if ((r2 - r11.d) < this.f15078b[r11.f15079a][0]) goto L11;
            r11.f15080b = 1;     // Catch: Throwable -> L18
            r11.d = r2;     // Catch: Throwable -> L18
            goto L16
        L11:
            if (r11.f15080b >= this.f15078b[r11.f15079a][2]) goto L14;
            r11.f15080b++;     // Catch: Throwable -> L18
            goto L16
        L14:
            monitor-exit(this);
            return false;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15082b;
        private int c;
        private long d;
        private int e;

        public b(e r3) {
            this.f15081a = r3;
            this.f15082b = 0;
            this.c = 6;
            this.d = 0;
            this.e = 0;
        }

        private int a(long r9) {
            if (this.f15082b > 0) goto L5;
        L14:
            int r10 = this.f15082b;
            if (r10 < 10000) goto L17;
            return -1;
        L17:
            if (r10 <= 0) goto L22;
            if (r10 < 10000) goto L20;
            return 0;
        L20:
            if (new Random().nextInt(10000) >= this.f15082b) goto L25;
            return -1;
        L25:
            return 0;
        L22:
            return 0;
        L5:
            if (AppLog.c(r9) == true) goto L7;
            r9 = 60000;
        L7:
            long r2 = System.currentTimeMillis();
            long r4 = this.d;
            if (r2 >= (r4 + r9)) goto L13;
            int r11 = this.e;
            if (r11 < this.c) goto L12;
            return -1;
        L12:
            this.e = r11 + 1;
            goto L14
        L13:
            this.d = r4 + (((r2 - r4) / r9) * r9);
            this.e = 1;
            goto L14
        }

        static /* synthetic */ int a(b r0, long r1) {
            return r0.a(r1);
        }

        static /* synthetic */ void a(b r0, JSONObject r1) {
            r0.a(r1);
        }

        private void a(JSONObject r9) {
            if (r9 != null) goto L4;
            return;
        L4:
            int r0 = r9.optInt("backoff_ratio", 0);
            this.f15082b = r0;
            if (r0 >= 0) goto L7;
        L8:
            this.f15082b = 0;
        L10:
            if (this.f15082b <= 0) goto L12;
            int r1 = 1;
        L13:
            int r10 = r9.optInt("max_request_frequency", r1);
            this.c = r10;
            if (r10 < 1) goto L16;
            if (r10 > 6) goto L16;
        L17:
            int r11 = this.f15082b;
            if (r11 > 0) goto L20;
        L22:
            if (r11 != 0) goto L24;
            this.d = 0;
            this.e = 0;
        L24:
            Logger.d("RatioDowngradeStrategy", "updateRatioDowngradeParams mBackoffRatio: " + this.f15082b + ", mMaxRequestFrequency: " + this.c + ", mBackoffWindowStartTime: " + this.d + ", mBackoffWindowSendCount: " + this.e);
            return;
        L20:
            if (this.d != 0) goto L22;
            this.d = System.currentTimeMillis();
            this.e = 1;
        L16:
            this.c = r1;
            goto L17
        L12:
            r1 = 6;
            goto L13
        L7:
            if (r0 <= 10000) goto L10;
            goto L8
        }
    }

    public e(Context r3) {
        this.f15075a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f15076b = new a(this, null);
        this.c = new b(this);
    }

    static /* synthetic */ Context a(e r0) {
        return r0.f15075a;
    }

    int a(long r1) {
        b r0 = this.c;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return b.a(r0, r1);
    }

    public void a(int r1, String[] r2) {
        this.f15076b.a(r1, r2);
    }

    public void a(int r1, String[] r2, Throwable r3) {
        this.f15076b.a(r1, r2, r3);
    }

    public void a(String r1) {
        this.f15076b.a(r1);
    }

    void a(JSONObject r1) {
        b r0 = this.c;
        if (r0 == null) goto L6;
        b.a(r0, r1);
        return;
    }

    public boolean b(String r1) {
        return this.f15076b.b(r1);
    }
}
