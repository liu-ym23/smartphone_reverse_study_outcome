package jb;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f9908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f9911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<Long> f9912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9913l;

    public w(DownloadInfo r10) {
        this.f9902a = 0;
        this.f9903b = 0;
        this.f9904c = 0;
        this.f9905d = 0;
        this.f9906e = 0;
        this.f9907f = 0;
        this.f9908g = 0;
        this.f9909h = 0;
        this.f9910i = 0;
        this.f9911j = false;
        this.f9912k = new ArrayList();
        this.f9913l = 0;
        e(r10);     // Catch: Throwable -> L8
        if (lb.a.a() == false) goto L13;
        int r11 = this.f9913l;
        StringBuilder r12 = new StringBuilder();
    L7:
        r12.append("Init retryCountLimit:");
        r12.append(this.f9906e);
        r12.append(" delayIntervalMs:");
        r12.append(this.f9912k.toString());
        r12.append(" retryPeriodTime:");
        r12.append(this.f9908g);
        r12.append(" periodRetryCountLimit:");
        r12.append(this.f9907f);
        r12.append(" retryResetCountLimit:");
        r12.append(this.f9909h);
        lb.a.g("NetworkRetryStrategy", r11, "NetworkRetryStrategy", r12.toString());
        return;
    L13:
        return;
    L8:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        lb.a.h("NetworkRetryStrategy", this.f9913l, "NetworkRetryStrategy", "Init Error" + th.toString());     // Catch: Throwable -> L14
        if (lb.a.a() == false) goto L24;
        r11 = this.f9913l;
        r12 = new StringBuilder();
        goto L7
    L24:
        return;
    L14:
        th = move-exception;
        if (lb.a.a() == false) goto L18;
        lb.a.g("NetworkRetryStrategy", this.f9913l, "NetworkRetryStrategy", "Init retryCountLimit:" + this.f9906e + " delayIntervalMs:" + this.f9912k.toString() + " retryPeriodTime:" + this.f9908g + " periodRetryCountLimit:" + this.f9907f + " retryResetCountLimit:" + this.f9909h);
    L18:
        throw th;
    }

    private void b() {
        if (this.f9912k.isEmpty() == false) goto L18;
        return;
    L18:
    L15:
        th = move-exception;
        lb.a.h("NetworkRetryStrategy", this.f9913l, "delay", "Error:" + th.toString());
        th.printStackTrace();
        return;
    L6:
        if (this.f9902a < this.f9912k.size()) goto L9;
        List<Long> r10 = this.f9912k;     // Catch: Throwable -> L15
        Long r11 = r10.get(r10.size() - 1);     // Catch: Throwable -> L15
    L8:
        long r12 = r11.longValue();     // Catch: Throwable -> L15
        if (lb.a.a() == false) goto L13;
        lb.a.g("NetworkRetryStrategy", this.f9913l, "delay", "Sleep:" + r12);     // Catch: Throwable -> L15
    L13:
        Thread.sleep(r12);     // Catch: Throwable -> L15
        return;
    L9:
        r11 = this.f9912k.get(this.f9902a);     // Catch: Throwable -> L15
        goto L8
    }

    private void e(DownloadInfo r10) {
        if (r10 == null) goto L5;
        int r11 = r10.getId();
        this.f9913l = r11;
        rb.a r12 = rb.a.g(r11);
    L6:
        JSONObject r13 = r12.q("retry_strategy");
        if (r13 != null) goto L9;
        return;
    L9:
        int r14 = r13.optInt("retry_count");
        if (r14 <= 0) goto L12;
        this.f9906e = r14;
    L12:
        JSONArray r15 = r13.optJSONArray("delay_interval_ms");
        if (r15 != null) goto L15;
    L23:
        long r16 = r13.optLong("retry_period_ms");
        if (r16 <= 0) goto L26;
        this.f9908g = r16;
    L26:
        int r17 = r13.optInt("retry_count_limit_period");
        if (r17 <= 0) goto L29;
        this.f9907f = r17;
    L29:
        int r18 = r13.optInt("retry_reset_count_limit");
        if (r18 <= 0) goto L33;
        this.f9909h = r18;
    L33:
        if (this.f9906e > 0) goto L35;
        return;
    L35:
        if (this.f9909h <= 0) goto L42;
        this.f9911j = true;
        return;
    L42:
        return;
    L15:
        if (r15.length() <= 0) goto L23;
        int r19 = 0;
    L18:
        if (r19 >= r15.length()) goto L23;
        long r20 = r15.optLong(r19);
        if (r20 <= 0) goto L22;
        this.f9912k.add(Long.valueOf(r20));
    L22:
        r19 = r19 + 1;
        goto L18
    L5:
        r12 = rb.a.j();
        goto L6
    }

    private boolean g() {
        int r10 = this.f9909h;
        if (r10 > 0) goto L6;
        return false;
    L6:
        if (this.f9905d >= r10) goto L8;
        return false;
    L8:
        if (lb.a.a() == false) goto L13;
        lb.a.g("NetworkRetryStrategy", this.f9913l, "resetLimit", "CurrentRetryResetCount:" + this.f9905d + " retryResetCountLimit:" + this.f9909h);
        return true;
    L13:
        return true;
    }

    private boolean h() {
        if (this.f9908g > 0) goto L5;
    L22:
        return false;
    L5:
        if (this.f9907f <= 0) goto L22;
        long r10 = this.f9904c;
        long r11 = System.currentTimeMillis();
        if (r10 != 0) goto L12;
        this.f9904c = r11;
        return false;
    L12:
        if ((r11 - this.f9904c) < this.f9908g) goto L14;
        this.f9904c = System.currentTimeMillis();
        this.f9903b = 0;
        goto L22
    L14:
        if (this.f9903b > this.f9907f) goto L16;
        return false;
    L16:
        if (lb.a.a() == false) goto L23;
        lb.a.g("NetworkRetryStrategy", this.f9913l, "retryLimit", "CurrentPeriodRetryCount:" + this.f9903b + " periodRetryCountLimit:" + this.f9907f + " currentRetryPeriodTime:" + (r11 - this.f9904c) + " retryPeriodTime:" + this.f9908g);
        return true;
    L23:
        return true;
    }

    public boolean a(BaseException r10) {
        if (r10 == null) goto L22;
        if (this.f9911j == false) goto L22;
        if (lb.a.a() == false) goto L11;
        lb.a.g("NetworkRetryStrategy", this.f9913l, "canRetry", "CurrentRetryCount:" + this.f9902a + " retryCountLimit:" + this.f9906e + " error:" + r10.getErrorCode());
    L11:
        if (h() == false) goto L15;
        this.f9911j = false;
        return false;
    L15:
        if (this.f9902a < this.f9906e) goto L17;
    L20:
        return false;
    L17:
        if (com.ss.android.socialbase.downloader.utils.g.R(r10) == false) goto L20;
        return true;
    L22:
        if (lb.a.a() == false) goto L24;
        lb.a.g("NetworkRetryStrategy", this.f9913l, "canRetry", "Enabled: " + this.f9911j);
    L24:
        return false;
    }

    public void c() {
        if (this.f9911j == true) goto L5;
        return;
    L5:
        b();
        this.f9902a++;
        this.f9903b++;
        this.f9910i++;
        if (lb.a.a() == false) goto L9;
        lb.a.g("NetworkRetryStrategy", this.f9913l, "doRetry", "CurrentRetryCount:" + this.f9902a + " currentPeriodRetryCount:" + this.f9903b + " totalRetryCount:" + this.f9910i);
        return;
    }

    public int d() {
        return this.f9910i;
    }

    public void f() {
        if (g() == false) goto L7;
        this.f9911j = false;
        return;
    L7:
        if (lb.a.a() == false) goto L9;
        lb.a.g("NetworkRetryStrategy", this.f9913l, "reset", "Reset currentRetryResetCount");
    L9:
        this.f9905d++;
        this.f9902a = 0;
    }
}
