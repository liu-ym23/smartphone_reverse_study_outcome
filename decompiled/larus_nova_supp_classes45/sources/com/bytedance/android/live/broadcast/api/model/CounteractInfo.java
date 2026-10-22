package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.RoomEndingCounteractInfoResponse.CounteractInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/CounteractInfo;", "Ljava/io/Serializable;", "()V", "displayText", "Lcom/bytedance/android/livesdkapi/message/Text;", "getDisplayText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "setDisplayText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "liveDurationMissionInfo", "Lcom/bytedance/android/live/broadcast/api/model/LiveDurationMissionInfoMessage;", "getLiveDurationMissionInfo", "()Lcom/bytedance/android/live/broadcast/api/model/LiveDurationMissionInfoMessage;", "setLiveDurationMissionInfo", "(Lcom/bytedance/android/live/broadcast/api/model/LiveDurationMissionInfoMessage;)V", "popupStrategy", "", "getPopupStrategy", "()Ljava/lang/String;", "setPopupStrategy", "(Ljava/lang/String;)V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CounteractInfo implements Serializable, vh7.h {

    @SerializedName("display_text")
    protected Text displayText;

    @SerializedName("live_duration_mission_info")
    protected LiveDurationMissionInfoMessage liveDurationMissionInfo;

    @SerializedName("popup_strategy")
    protected String popupStrategy;

    public CounteractInfo() {
    }

    public CounteractInfo(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.displayText = _Text_ProtoDecoder.decodeStatic(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.popupStrategy = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.liveDurationMissionInfo = new LiveDurationMissionInfoMessage(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final Text getDisplayText() {
        return this.displayText;
    }

    public final LiveDurationMissionInfoMessage getLiveDurationMissionInfo() {
        return this.liveDurationMissionInfo;
    }

    public final String getPopupStrategy() {
        return this.popupStrategy;
    }

    public final void setDisplayText(Text r1) {
        this.displayText = r1;
    }

    public final void setLiveDurationMissionInfo(LiveDurationMissionInfoMessage r1) {
        this.liveDurationMissionInfo = r1;
    }

    public final void setPopupStrategy(String r1) {
        this.popupStrategy = r1;
    }
}
