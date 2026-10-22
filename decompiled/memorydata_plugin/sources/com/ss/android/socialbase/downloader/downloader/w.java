package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15434b;
    private long c;
    private int d;
    private int e;
    private int f;
    private long g;
    private int h;
    private int i;
    private boolean j;
    private List<Long> k;
    private int l;

    public w(DownloadInfo r11) {
        this.f15433a = 0;
        this.f15434b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = new ArrayList();
        this.l = 0;
        a(r11);     // Catch: Throwable -> L8
        if (com.ss.android.socialbase.downloader.e.a.a(r11) == false) goto L13;
        StringBuilder r6 = new StringBuilder();
    L7:
        com.ss.android.socialbase.downloader.e.a.a("NetworkRetryStrategy", r11, "NetworkRetryStrategy", r6.append("Init retryCountLimit:").append(this.e).append(" delayIntervalMs:").append(this.k.toString()).append(" retryPeriodTime:").append(this.g).append(" periodRetryCountLimit:").append(this.f).append(" retryResetCountLimit:").append(this.h).toString());
        return;
    L13:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        com.ss.android.socialbase.downloader.e.a.b("NetworkRetryStrategy", this.l, "NetworkRetryStrategy", "Init Error" + th.toString());     // Catch: Throwable -> L14
        if (com.ss.android.socialbase.downloader.e.a.a(r11) == false) goto L24;
        r6 = new StringBuilder();
        goto L7
    L24:
        return;
    L14:
        th = move-exception;
        if (com.ss.android.socialbase.downloader.e.a.a(r11) == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a("NetworkRetryStrategy", r11, "NetworkRetryStrategy", "Init retryCountLimit:" + this.e + " delayIntervalMs:" + this.k.toString() + " retryPeriodTime:" + this.g + " periodRetryCountLimit:" + this.f + " retryResetCountLimit:" + this.h);
    L18:
        throw th;
    }

    private void a(DownloadInfo r8) {
        if (r8 == null) goto L5;
        int r9 = r8.getId();
        this.l = r9;
        com.ss.android.socialbase.downloader.g.a r10 = com.ss.android.socialbase.downloader.g.a.a(r9);
    L6:
        JSONObject r11 = r10.e("retry_strategy");
        if (r11 != null) goto L9;
        return;
    L9:
        int r0 = r11.optInt("retry_count");
        if (r0 <= 0) goto L12;
        this.e = r0;
    L12:
        JSONArray r1 = r11.optJSONArray("delay_interval_ms");
        if (r1 != null) goto L15;
    L23:
        long r3 = r11.optLong("retry_period_ms");
        if (r3 <= 0) goto L26;
        this.g = r3;
    L26:
        int r2 = r11.optInt("retry_count_limit_period");
        if (r2 <= 0) goto L29;
        this.f = r2;
    L29:
        int r12 = r11.optInt("retry_reset_count_limit");
        if (r12 <= 0) goto L33;
        this.h = r12;
    L33:
        if (this.e > 0) goto L35;
        return;
    L35:
        if (this.h <= 0) goto L42;
        this.j = true;
        return;
    L42:
        return;
    L15:
        if (r1.length() <= 0) goto L23;
        int r4 = 0;
    L18:
        if (r4 >= r1.length()) goto L23;
        long r5 = r1.optLong(r4);
        if (r5 <= 0) goto L22;
        this.k.add(Long.valueOf(r5));
    L22:
        r4 = r4 + 1;
        goto L18
    L5:
        r10 = com.ss.android.socialbase.downloader.g.a.c();
        goto L6
    }

    private void d() {
        if (this.k.isEmpty() == false) goto L19;
        return;
    L19:
    L16:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("NetworkRetryStrategy", this.l, "delay", "Error:" + th.toString());
        th.printStackTrace();
        return;
    L7:
        if (this.f15433a < this.k.size()) goto L10;
        List<Long> r2 = this.k;     // Catch: Throwable -> L16
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L9:
        long r4 = r3.longValue();     // Catch: Throwable -> L16
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L14;
        com.ss.android.socialbase.downloader.e.a.a("NetworkRetryStrategy", this.l, "delay", "Sleep:" + r4);     // Catch: Throwable -> L16
    L14:
        Thread.sleep(r4);     // Catch: Throwable -> L16
        return;
    L10:
        r3 = (Long) ZeusTransformUtils.preCheckCast(this.k.get(this.f15433a), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        goto L9
    }

    private boolean e() {
        if (this.g > 0) goto L5;
    L22:
        return false;
    L5:
        if (this.f <= 0) goto L22;
        long r4 = this.c;
        long r2 = System.currentTimeMillis();
        if (r4 != 0) goto L12;
        this.c = r2;
        return false;
    L12:
        if ((r2 - this.c) < this.g) goto L14;
        this.c = System.currentTimeMillis();
        this.f15434b = 0;
        goto L22
    L14:
        if (this.f15434b > this.f) goto L16;
        return false;
    L16:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L23;
        com.ss.android.socialbase.downloader.e.a.a("NetworkRetryStrategy", this.l, "retryLimit", "CurrentPeriodRetryCount:" + this.f15434b + " periodRetryCountLimit:" + this.f + " currentRetryPeriodTime:" + (r2 - this.c) + " retryPeriodTime:" + this.g);
        return true;
    L23:
        return true;
    }

    private boolean f() {
        int r0 = this.h;
        if (r0 > 0) goto L6;
        return false;
    L6:
        if (this.d >= r0) goto L8;
        return false;
    L8:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L13;
        com.ss.android.socialbase.downloader.e.a.a("NetworkRetryStrategy", this.l, "resetLimit", "CurrentRetryResetCount:" + this.d + " retryResetCountLimit:" + this.h);
        return true;
    L13:
        return true;
    }

    public void a() {
        if (f() == false) goto L7;
        this.j = false;
        return;
    L7:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("NetworkRetryStrategy", this.l, "reset", "Reset currentRetryResetCount");
    L9:
        this.d++;
        this.f15433a = 0;
    }

    public boolean a(BaseException r7) {
        if (r7 == null) goto L22;
        if (this.j == false) goto L22;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a("NetworkRetryStrategy", this.l, "canRetry", "CurrentRetryCount:" + this.f15433a + " retryCountLimit:" + this.e + " error:" + r7.getErrorCode());
    L11:
        if (e() == false) goto L15;
        this.j = false;
        return false;
    L15:
        if (this.f15433a < this.e) goto L17;
    L20:
        return false;
    L17:
        if (com.ss.android.socialbase.downloader.utils.g.b(r7) == false) goto L20;
        return true;
    L22:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L24;
        com.ss.android.socialbase.downloader.e.a.a("NetworkRetryStrategy", this.l, "canRetry", "Enabled: " + this.j);
    L24:
        return false;
    }

    public void b() {
        if (this.j == true) goto L5;
        return;
    L5:
        d();
        this.f15433a++;
        this.f15434b++;
        this.i++;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("NetworkRetryStrategy", this.l, "doRetry", "CurrentRetryCount:" + this.f15433a + " currentPeriodRetryCount:" + this.f15434b + " totalRetryCount:" + this.i);
        return;
    }

    public int c() {
        return this.i;
    }
}
