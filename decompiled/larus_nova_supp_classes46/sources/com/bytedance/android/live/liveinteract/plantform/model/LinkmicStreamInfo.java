package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R$\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R$\u0010\t\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/LinkmicStreamInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/r;", "", "component1", "component2", "component3", "liveCoreExtInfo", "rtcExtInfo", "bizTag", "copy", "toString", "", "hashCode", "", PbRequest.SwitchType.OTHER, "", "equals", "Ljava/lang/String;", "getLiveCoreExtInfo", "()Ljava/lang/String;", "setLiveCoreExtInfo", "(Ljava/lang/String;)V", "getRtcExtInfo", "setRtcExtInfo", "getBizTag", "setBizTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicStreamInfo extends FlexModelBase<r> implements r, vh7.h {

    @SerializedName("biz_tag")
    protected String bizTag;

    @SerializedName("live_core_ext_info")
    protected String liveCoreExtInfo;

    @SerializedName("rtc_ext_info")
    protected String rtcExtInfo;

    public LinkmicStreamInfo(String r2, String r3, String r4) {
        super(r.class);
        this.liveCoreExtInfo = r2;
        this.rtcExtInfo = r3;
        this.bizTag = r4;
    }

    public static /* synthetic */ LinkmicStreamInfo copy$default(LinkmicStreamInfo r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getLiveCoreExtInfo();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getRtcExtInfo();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.getBizTag();
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return getLiveCoreExtInfo();
    }

    public final String component2() {
        return getRtcExtInfo();
    }

    public final String component3() {
        return getBizTag();
    }

    public final LinkmicStreamInfo copy(String r2, String r3, String r4) {
        return new LinkmicStreamInfo(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LinkmicStreamInfo) == false) goto L12;
        LinkmicStreamInfo r4 = (LinkmicStreamInfo) r3;
        if (Intrinsics.areEqual(getLiveCoreExtInfo(), r4.getLiveCoreExtInfo()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getRtcExtInfo(), r4.getRtcExtInfo()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getBizTag(), r4.getBizTag()) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = getLiveCoreExtInfo();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = getRtcExtInfo();
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = getBizTag();
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LinkmicStreamInfo(liveCoreExtInfo=" + getLiveCoreExtInfo() + ", rtcExtInfo=" + getRtcExtInfo() + ", bizTag=" + getBizTag() + ")";
    }

    public LinkmicStreamInfo() {
        super(r.class);
        this.liveCoreExtInfo = "";
        this.rtcExtInfo = "";
        this.bizTag = "";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public String getBizTag() {
        return this.bizTag;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public String getLiveCoreExtInfo() {
        return this.liveCoreExtInfo;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public String getRtcExtInfo() {
        return this.rtcExtInfo;
    }

    public LinkmicStreamInfo(am3.g r6) {
        super(r.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.liveCoreExtInfo = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.rtcExtInfo = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.bizTag = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this.liveCoreExtInfo != null) goto L19;
        this.liveCoreExtInfo = "";
    L19:
        if (this.rtcExtInfo != null) goto L22;
        this.rtcExtInfo = "";
    L22:
        if (this.bizTag != null) goto L37;
        this.bizTag = "";
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public void setBizTag(String r1) {
        this.bizTag = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public void setLiveCoreExtInfo(String r1) {
        this.liveCoreExtInfo = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.r
    public void setRtcExtInfo(String r1) {
        this.rtcExtInfo = r1;
    }

    public /* synthetic */ LinkmicStreamInfo(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }
}
