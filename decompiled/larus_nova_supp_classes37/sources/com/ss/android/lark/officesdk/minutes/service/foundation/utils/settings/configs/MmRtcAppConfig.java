package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "vc_rtc_app_config")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcAppConfig;", "Ljava/io/Serializable;", "appId", "", "rtcJsonParam", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getRtcJsonParam", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRtcAppConfig implements Serializable {

    @SerializedName("rtc_appid")
    private final String appId;

    @SerializedName("rtc_json_param")
    private final String rtcJsonParam;

    public MmRtcAppConfig() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public MmRtcAppConfig(String r3) {
        String r0 = null;
        this(r3, r0, 2, r0);
    }

    public static /* synthetic */ MmRtcAppConfig copy$default(MmRtcAppConfig r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.appId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.rtcJsonParam;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.rtcJsonParam;
    }

    public final MmRtcAppConfig copy(String r2, String r3) {
        return new MmRtcAppConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmRtcAppConfig) == true) goto L8;
        return false;
    L8:
        MmRtcAppConfig r6 = (MmRtcAppConfig) r5;
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rtcJsonParam, r6.rtcJsonParam) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.appId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.rtcJsonParam;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MmRtcAppConfig(appId=" + this.appId + ", rtcJsonParam=" + this.rtcJsonParam + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getRtcJsonParam() {
        return this.rtcJsonParam;
    }

    public MmRtcAppConfig(String r1, String r2) {
        this.appId = r1;
        this.rtcJsonParam = r2;
    }

    public /* synthetic */ MmRtcAppConfig(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
