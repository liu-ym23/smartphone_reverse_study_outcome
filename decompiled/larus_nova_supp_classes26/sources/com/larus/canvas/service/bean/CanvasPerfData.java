package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/canvas/service/bean/CanvasPerfData;", "Ljava/io/Serializable;", "imageDisplayDuration", "", "receiveImageDuration", "receiveReviewResultDuration", "logId", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "Ljava/lang/Long;", "startTime", "getStartTime", "()J", "setStartTime", "(J)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CanvasPerfData implements Serializable {
    public transient long a;

    @SerializedName("image_display_duration")
    public Long imageDisplayDuration;

    @SerializedName("log_id")
    public String logId;

    @SerializedName("receive_image_duration")
    public Long receiveImageDuration;

    @SerializedName("receive_review_result_duration")
    public Long receiveReviewResultDuration;

    public CanvasPerfData() {
        this(null, null, null, null, 15, null);
    }

    public final long getStartTime() {
        return this.a;
    }

    public final void setStartTime(long r1) {
        this.a = r1;
    }

    public CanvasPerfData(Long r1, Long r2, Long r3, String r4) {
        this.imageDisplayDuration = r1;
        this.receiveImageDuration = r2;
        this.receiveReviewResultDuration = r3;
        this.logId = r4;
    }

    public /* synthetic */ CanvasPerfData(Long r2, Long r3, Long r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
