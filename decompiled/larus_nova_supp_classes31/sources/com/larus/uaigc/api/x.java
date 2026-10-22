package com.larus.uaigc.api;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/larus/uaigc/api/VideoLoadingInfo;", "", "loadingText", "", "waitTimeSec", "", "refreshTimeSec", "responseTimeStamp", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;J)V", "Ljava/lang/Long;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class x {
    public final transient long a;

    @SerializedName("loading_text")
    public final String loadingText;

    @SerializedName("refresh_time_sec")
    public final Long refreshTimeSec;

    @SerializedName("wait_time_sec")
    public final Long waitTimeSec;

    public x() {
        this(null, null, null, System.currentTimeMillis());
    }

    public x(String r1, Long r2, Long r3, long r4) {
        this.loadingText = r1;
        this.waitTimeSec = r2;
        this.refreshTimeSec = r3;
        this.a = r4;
    }
}
