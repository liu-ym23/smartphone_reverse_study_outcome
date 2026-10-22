package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.PreviewStreamInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/c1;", "", "", "preScheduleKey", "Ljava/lang/String;", "", "expireTime", "I", "sdkParams", "speedTestUrl", "speedTestKey", "", "byPushSelect", "Z", "scheduleSpeedTestUrl", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c1 implements vh7.h {

    @SerializedName("by_push_select")
    public boolean byPushSelect;

    @SerializedName("expire_time")
    public int expireTime;

    @SerializedName("preschedule_key")
    public String preScheduleKey;

    @SerializedName("schedule_speed_test_url")
    public String scheduleSpeedTestUrl;

    @SerializedName("sdk_params")
    public String sdkParams;

    @SerializedName("speed_test_key")
    public String speedTestKey;

    @SerializedName("speed_test_url")
    public String speedTestUrl;

    public c1() {
        this.preScheduleKey = "";
        this.sdkParams = "";
        this.speedTestUrl = "";
        this.speedTestKey = "";
        this.scheduleSpeedTestUrl = "";
    }

    public c1(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.scheduleSpeedTestUrl = am3.h.c(r5);
        goto L3
    L8:
        this.byPushSelect = am3.h.a(r5);
        goto L3
    L9:
        this.speedTestKey = am3.h.c(r5);
        goto L3
    L10:
        this.speedTestUrl = am3.h.c(r5);
        goto L3
    L11:
        this.sdkParams = am3.h.c(r5);
        goto L3
    L12:
        this.expireTime = (int) r5.j();
        goto L3
    L13:
        this.preScheduleKey = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L14:
        r5.d(r0);
        if (this.preScheduleKey != null) goto L18;
        this.preScheduleKey = "";
    L18:
        if (this.sdkParams != null) goto L21;
        this.sdkParams = "";
    L21:
        if (this.speedTestUrl != null) goto L24;
        this.speedTestUrl = "";
    L24:
        if (this.speedTestKey != null) goto L27;
        this.speedTestKey = "";
    L27:
        if (this.scheduleSpeedTestUrl != null) goto L48;
        this.scheduleSpeedTestUrl = "";
        return;
    }
}
