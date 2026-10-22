package com.bytedance.android.ec.core.anchorv3;

import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavException;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/core/anchorv3/p;", "", "", "enableMonitor", "Z", "b", "()Z", "", "alarmSize", "I", "a", "()I", "minReportSize", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("alarm_size")
    private final int alarmSize;

    @SerializedName("enable_monitor")
    private final boolean enableMonitor;

    @SerializedName("min_report_size")
    private final int minReportSize;

    public p() {
        this(0);
    }

    public final int a() {
        return this.alarmSize;
    }

    public final boolean b() {
        return this.enableMonitor;
    }

    public final int c() {
        return this.minReportSize;
    }

    public p(int r1) {
        Lazy r10 = ECAppInfoService.a;
        this.enableMonitor = ECAppInfoService.h();
        this.alarmSize = 61440;
        this.minReportSize = CalDavException.MAX_EXCERPT_SIZE;
    }
}
