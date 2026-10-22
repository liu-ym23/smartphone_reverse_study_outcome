package com.bytedance.android.live.broadcast.api.model.multicamera;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/multicamera/b;", "", "", "viewId", "Ljava/lang/Long;", "Lcom/bytedance/android/live/broadcast/api/model/multicamera/a;", "guestInfo", "Lcom/bytedance/android/live/broadcast/api/model/multicamera/a;", "getGuestInfo", "()Lcom/bytedance/android/live/broadcast/api/model/multicamera/a;", "setGuestInfo", "(Lcom/bytedance/android/live/broadcast/api/model/multicamera/a;)V", "Lcom/bytedance/android/live/broadcast/api/model/multicamera/RTCInfo;", "rtcInfo", "Lcom/bytedance/android/live/broadcast/api/model/multicamera/RTCInfo;", "getRtcInfo", "()Lcom/bytedance/android/live/broadcast/api/model/multicamera/RTCInfo;", "setRtcInfo", "(Lcom/bytedance/android/live/broadcast/api/model/multicamera/RTCInfo;)V", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("guest_info")
    private a guestInfo;

    @SerializedName("rtc_info")
    private RTCInfo rtcInfo;

    @SerializedName("view_id")
    private Long viewId;

    public b() {
    }
}
