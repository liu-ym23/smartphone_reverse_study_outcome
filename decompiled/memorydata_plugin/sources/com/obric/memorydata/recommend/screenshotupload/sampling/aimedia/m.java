package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/VideoSamplingIntervalPolicy;", "", "<init>", "()V", "SECOND_MS", "", "MINUTE_US", "TEN_MINUTES_US", "THIRTY_MINUTES_US", "MID_VIDEO_INTERVAL_MS", "LONG_VIDEO_INTERVAL_MS", "intervalMs", "sourceDurationUs", "shortVideoIntervalMs", "(Ljava/lang/Long;J)J", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f12583a = null;

    static {
        f12583a = new m();
    }

    private m() {
    }

    public final long a(Long r3, long r4) {
        if (r3 == null) goto L14;
        long r2 = r3.longValue();
        if (r2 > 0) goto L7;
        return r4;
    L7:
        if (r2 > 600000000) goto L10;
        return r4;
    L10:
        if (r2 > 1800000000) goto L12;
        return SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
    L12:
        return 20000;
    L14:
        return r4;
    }
}
