package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "", "toString", "rtcExtInfo", "Ljava/lang/String;", "getRtcExtInfo", "()Ljava/lang/String;", "linkMicIdStr", "getLinkMicIdStr", "liveCoreExtInfo", "getLiveCoreExtInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "bizTag", "getBizTag", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicMediaInfo extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.j1> implements com.bytedance.android.livesdk.link.model.bridge.j1, vh7.h {

    @SerializedName("biz_tag")
    protected String bizTag;

    @SerializedName("linkmic_id_str")
    protected String linkMicIdStr;

    @SerializedName("live_core_ext_info")
    protected String liveCoreExtInfo;

    @SerializedName("multi_live_core_info")
    protected u1 multiLiveCoreInfo;

    @SerializedName("multi_rtc_info")
    protected v1 multiRtcInfo;

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    public LinkmicMediaInfo() {
        super(com.bytedance.android.livesdk.link.model.bridge.j1.class);
        this.rtcExtInfo = "";
        this.linkMicIdStr = "";
        this.liveCoreExtInfo = "";
        this.bizTag = "";
    }

    public String toString() {
        return "rtc_ext_info " + getRtcExtInfo() + " live_core_ext_info " + getLiveCoreExtInfo();
    }

    public String getBizTag() {
        return this.bizTag;
    }

    public String getLinkMicIdStr() {
        return this.linkMicIdStr;
    }

    public String getLiveCoreExtInfo() {
        return this.liveCoreExtInfo;
    }

    public u1 getMultiLiveCoreInfo() {
        return this.multiLiveCoreInfo;
    }

    public v1 getMultiRtcInfo() {
        return this.multiRtcInfo;
    }

    public String getRtcExtInfo() {
        return this.rtcExtInfo;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.livesdk.link.model.bridge.v1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.livesdk.link.model.bridge.u1, java.lang.Object] */
    public LinkmicMediaInfo(am3.g r5) {
        super(com.bytedance.android.livesdk.link.model.bridge.j1.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.bizTag = am3.h.c(r5);
        goto L3
    L9:
        this.multiLiveCoreInfo = vh7.f.a(r5, u1.class);
        goto L3
    L10:
        this.multiRtcInfo = vh7.f.a(r5, v1.class);
        goto L3
    L11:
        this.liveCoreExtInfo = am3.h.c(r5);
        goto L3
    L12:
        this.linkMicIdStr = am3.h.c(r5);
        goto L3
    L13:
        this.rtcExtInfo = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
        if (this.rtcExtInfo != null) goto L18;
        this.rtcExtInfo = "";
    L18:
        if (this.linkMicIdStr != null) goto L21;
        this.linkMicIdStr = "";
    L21:
        if (this.liveCoreExtInfo != null) goto L24;
        this.liveCoreExtInfo = "";
    L24:
        if (this.bizTag != null) goto L43;
        this.bizTag = "";
        return;
    }
}
