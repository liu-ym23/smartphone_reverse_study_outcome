package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicMediaInfoForEnterRoom;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/k;", "", "linkMicIdStr", "Ljava/lang/String;", "getLinkMicIdStr", "()Ljava/lang/String;", "setLinkMicIdStr", "(Ljava/lang/String;)V", "rtcExtInfo", "getRtcExtInfo", "setRtcExtInfo", "liveCoreExtInfo", "getLiveCoreExtInfo", "setLiveCoreExtInfo", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicMediaInfoForEnterRoom extends FlexModelBase<k> implements k, vh7.h {

    @SerializedName("linkmic_id_str")
    protected String linkMicIdStr;

    @SerializedName("live_core_ext_info")
    protected String liveCoreExtInfo;

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    public LinkmicMediaInfoForEnterRoom() {
        super(k.class);
        this.linkMicIdStr = "";
        this.rtcExtInfo = "";
        this.liveCoreExtInfo = "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.k
    public String getLinkMicIdStr() {
        return this.linkMicIdStr;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.k
    public String getLiveCoreExtInfo() {
        return this.liveCoreExtInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.k
    public String getRtcExtInfo() {
        return this.rtcExtInfo;
    }

    public LinkmicMediaInfoForEnterRoom(am3.g r6) {
        super(k.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.linkMicIdStr = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.rtcExtInfo = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.liveCoreExtInfo = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this.linkMicIdStr != null) goto L19;
        this.linkMicIdStr = "";
    L19:
        if (this.rtcExtInfo != null) goto L22;
        this.rtcExtInfo = "";
    L22:
        if (this.liveCoreExtInfo != null) goto L37;
        this.liveCoreExtInfo = "";
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.k
    public void setLinkMicIdStr(String r1) {
        this.linkMicIdStr = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.k
    public void setLiveCoreExtInfo(String r1) {
        this.liveCoreExtInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.k
    public void setRtcExtInfo(String r1) {
        this.rtcExtInfo = r1;
    }
}
