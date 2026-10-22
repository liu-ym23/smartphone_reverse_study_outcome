package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkRetryStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15595c;
    public int d;
    public int e;
    public int f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f15598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f15599k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f15600l;

    public NetworkRetryStrategy(DownloadInfo r11) {
        this.f15593a = 0;
        this.f15594b = 0;
        this.f15595c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.f15596h = 0;
        this.f15597i = 0;
        this.f15598j = false;
        ArrayList r10 = new ArrayList();
        this.f15599k = r10;
        this.f15600l = 0;
        a(r11);     // Catch: Throwable -> L8
        if (Logger.a(r11) == false) goto L23;
        Logger.a("NetworkRetryStrategy", r11, "NetworkRetryStrategy", "Init retryCountLimit:" + this.e + " delayIntervalMs:" + r10.toString() + " retryPeriodTime:" + this.g + " periodRetryCountLimit:" + this.f + " retryResetCountLimit:" + this.f15596h);
        return;
    L23:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.a("NetworkRetryStrategy", this.f15600l, "NetworkRetryStrategy", "Init Error" + th.toString());     // Catch: Throwable -> L14
        if (Logger.a(r11) == false) goto L24;
        Logger.a("NetworkRetryStrategy", r11, "NetworkRetryStrategy", "Init retryCountLimit:" + this.e + " delayIntervalMs:" + this.f15599k.toString() + " retryPeriodTime:" + this.g + " periodRetryCountLimit:" + this.f + " retryResetCountLimit:" + this.f15596h);
        return;
    L24:
        return;
    L14:
        th = move-exception;
        if (Logger.a(r11) == false) goto L18;
        Logger.a("NetworkRetryStrategy", r11, "NetworkRetryStrategy", "Init retryCountLimit:" + this.e + " delayIntervalMs:" + this.f15599k.toString() + " retryPeriodTime:" + this.g + " periodRetryCountLimit:" + this.f + " retryResetCountLimit:" + this.f15596h);
    L18:
        throw th;
    }

    public final void a(DownloadInfo r10) {
        if (r10 == null) goto L5;
        int r11 = r10.l();
        this.f15600l = r11;
        JSONObject r12 = DownloadSetting.a(r11, null).d("retry_strategy");
    L6:
        if (r12 == null) goto L42;
        int r5 = r12.optInt("retry_count");
        if (r5 <= 0) goto L11;
        this.e = r5;
    L11:
        JSONArray r13 = r12.optJSONArray("delay_interval_ms");
        if (r13 != null) goto L14;
    L22:
        long r14 = r12.optLong("retry_period_ms");
        if (r14 <= 0) goto L25;
        this.g = r14;
    L25:
        int r15 = r12.optInt("retry_count_limit_period");
        if (r15 <= 0) goto L28;
        this.f = r15;
    L28:
        int r16 = r12.optInt("retry_reset_count_limit");
        if (r16 <= 0) goto L32;
        this.f15596h = r16;
    L32:
        if (this.e > 0) goto L34;
        return;
    L34:
        if (this.f15596h <= 0) goto L41;
        this.f15598j = true;
        return;
    L41:
        return;
    L14:
        if (r13.length() <= 0) goto L22;
        int r17 = 0;
    L17:
        if (r17 >= r13.length()) goto L22;
        long r18 = r13.optLong(r17);
        if (r18 <= 0) goto L21;
        this.f15599k.add(Long.valueOf(r18));
    L21:
        r17 = r17 + 1;
        goto L17
    L42:
        return;
    L5:
        r12 = DownloadSetting.f.d("retry_strategy");
        goto L6
    }

    public final void b() {
        int r5 = this.f15596h;
        if (r5 <= 0) goto L13;
        if (this.d < r5) goto L13;
        if (Logger.b() == false) goto L10;
        Logger.a("NetworkRetryStrategy", this.f15600l, null, "resetLimit", "CurrentRetryResetCount:" + this.d + " retryResetCountLimit:" + this.f15596h, false);
    L10:
        this.f15598j = false;
        return;
    L13:
        if (Logger.b() == false) goto L15;
        Logger.a("NetworkRetryStrategy", this.f15600l, null, "reset", "Reset currentRetryResetCount", false);
    L15:
        this.d++;
        this.f15593a = 0;
    }

    public final boolean a(BaseException r11) {
        if (this.f15598j == true) goto L9;
        if (Logger.b() == false) goto L7;
        Logger.a("NetworkRetryStrategy", this.f15600l, null, "canRetry", "Enabled: " + this.f15598j, false);
    L7:
        return false;
    L9:
        if (Logger.b() == false) goto L12;
        Logger.a("NetworkRetryStrategy", this.f15600l, null, "canRetry", "CurrentRetryCount:" + this.f15593a + " retryCountLimit:" + this.e + " error:" + r11.f15601a, false);
    L12:
        if (this.g <= 0) goto L30;
        if (this.f <= 0) goto L30;
        if (this.f15595c != 0) goto L19;
        this.f15595c = System.currentTimeMillis();
        goto L30
    L19:
        long r5 = System.currentTimeMillis();
        if ((r5 - this.f15595c) < this.g) goto L22;
        this.f15595c = System.currentTimeMillis();
        this.f15594b = 0;
        goto L30
    L22:
        if (this.f15594b <= this.f) goto L30;
        if (Logger.b() == false) goto L26;
        Logger.a("NetworkRetryStrategy", this.f15600l, null, "retryLimit", "CurrentPeriodRetryCount:" + this.f15594b + " periodRetryCountLimit:" + this.f + " currentRetryPeriodTime:" + (r5 - this.f15595c) + " retryPeriodTime:" + this.g, false);
    L26:
        this.f15598j = false;
        return false;
    L30:
        if (this.f15593a < this.e) goto L32;
    L35:
        return false;
    L32:
        if (DownloadUtils.c(r11) == false) goto L35;
        return true;
    }

    public final void a() {
        if (this.f15598j == true) goto L6;
        return;
    L6:
        if (this.f15599k.isEmpty() == false) goto L24;
    L20:
        this.f15593a++;
        this.f15594b++;
        this.f15597i++;
        if (Logger.b() == false) goto L26;
        Logger.a("NetworkRetryStrategy", this.f15600l, null, "doRetry", "CurrentRetryCount:" + this.f15593a + " currentPeriodRetryCount:" + this.f15594b + " totalRetryCount:" + this.f15597i, false);
        return;
    L26:
        return;
    L24:
    L11:
        th = move-exception;
        Logger.a("NetworkRetryStrategy", this.f15600l, "delay", "Error:" + th.toString());
        th.printStackTrace();
        goto L20
    L9:
        if (this.f15593a < this.f15599k.size()) goto L13;
        ArrayList r5 = this.f15599k;     // Catch: Throwable -> L11
        long r10 = ((Long) r5.get(r5.size() - 1)).longValue();     // Catch: Throwable -> L11
    L15:
        if (Logger.b() == false) goto L17;
        Logger.a("NetworkRetryStrategy", this.f15600l, null, "delay", "Sleep:" + r10, false);     // Catch: Throwable -> L11
    L17:
        Thread.sleep(r10);     // Catch: Throwable -> L11
        goto L20
    L13:
        r10 = ((Long) this.f15599k.get(this.f15593a)).longValue();     // Catch: Throwable -> L11
        goto L15
    }
}
