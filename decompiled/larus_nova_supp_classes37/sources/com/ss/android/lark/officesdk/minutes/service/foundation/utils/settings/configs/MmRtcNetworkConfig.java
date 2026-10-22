package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "vc_network_tips_config")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001#BA\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006$"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig;", "Ljava/io/Serializable;", "toTcpThreshold", "", "tipsDelayTime", "", "networkQualityStrategy", "Lcom/google/gson/JsonObject;", "abTest", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig$WeakNetworkABTest;", "noRtcNetConfig", "<init>", "(IJLcom/google/gson/JsonObject;Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig$WeakNetworkABTest;Lcom/google/gson/JsonObject;)V", "getToTcpThreshold", "()I", "getTipsDelayTime", "()J", "getNetworkQualityStrategy", "()Lcom/google/gson/JsonObject;", "getAbTest", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig$WeakNetworkABTest;", "getNoRtcNetConfig", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "WeakNetworkABTest", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRtcNetworkConfig implements Serializable {

    @SerializedName("meeting_weak_network_abtest")
    private final WeakNetworkABTest abTest;

    @SerializedName("meeting_network_quality_strategy")
    private final JsonObject networkQualityStrategy;

    @SerializedName("no_rtc_network_config")
    private final JsonObject noRtcNetConfig;

    @SerializedName("local_network_disconnect_tips_delay_time")
    private final long tipsDelayTime;

    @SerializedName("to_tcp_threshold")
    private final int toTcpThreshold;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/MmRtcNetworkConfig$WeakNetworkABTest;", "Ljava/io/Serializable;", "enable", "", "didList", "", "", "userInWhiteList", "userInBlackList", "<init>", "(ZLjava/util/List;ZZ)V", "getEnable", "()Z", "getDidList", "()Ljava/util/List;", "getUserInWhiteList", "getUserInBlackList", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class WeakNetworkABTest implements Serializable {

        @SerializedName("did")
        private final List<String> didList;

        @SerializedName("enable")
        private final boolean enable;

        @SerializedName("user_in_black_list")
        private final boolean userInBlackList;

        @SerializedName("user_in_white_list")
        private final boolean userInWhiteList;

        public WeakNetworkABTest() {
            this(false, null, false, false, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WeakNetworkABTest copy$default(WeakNetworkABTest r0, boolean r1, List r2, boolean r3, boolean r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.enable;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.didList;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.userInWhiteList;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.userInBlackList;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final boolean component1() {
            return this.enable;
        }

        public final List<String> component2() {
            return this.didList;
        }

        public final boolean component3() {
            return this.userInWhiteList;
        }

        public final boolean component4() {
            return this.userInBlackList;
        }

        public final WeakNetworkABTest copy(boolean r2, List<String> r3, boolean r4, boolean r5) {
            return new WeakNetworkABTest(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof WeakNetworkABTest) == true) goto L8;
            return false;
        L8:
            WeakNetworkABTest r6 = (WeakNetworkABTest) r5;
            if (this.enable == r6.enable) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.didList, r6.didList) == true) goto L15;
            return false;
        L15:
            if (this.userInWhiteList == r6.userInWhiteList) goto L18;
            return false;
        L18:
            if (this.userInBlackList == r6.userInBlackList) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r1 = 1231;
            if (this.enable == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            List<String> r3 = this.didList;
            if (r3 != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (r2 + r4) * 31;
            if (this.userInWhiteList == false) goto L13;
            int r6 = 1231;
        L14:
            int r7 = (r5 + r6) * 31;
            if (this.userInBlackList == true) goto L19;
            r1 = 1237;
        L19:
            return r7 + r1;
        L13:
            r6 = 1237;
            goto L14
        L9:
            r4 = r3.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public String toString() {
            return "WeakNetworkABTest(enable=" + this.enable + ", didList=" + this.didList + ", userInWhiteList=" + this.userInWhiteList + ", userInBlackList=" + this.userInBlackList + ')';
        }

        public final List<String> getDidList() {
            return this.didList;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final boolean getUserInBlackList() {
            return this.userInBlackList;
        }

        public final boolean getUserInWhiteList() {
            return this.userInWhiteList;
        }

        public WeakNetworkABTest(boolean r1, List<String> r2, boolean r3, boolean r4) {
            this.enable = r1;
            this.didList = r2;
            this.userInWhiteList = r3;
            this.userInBlackList = r4;
        }

        public /* synthetic */ WeakNetworkABTest(boolean r2, List r3, boolean r4, boolean r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = false;
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = false;
        L14:
            this(r2, r3, r4, r5);
        }
    }

    public MmRtcNetworkConfig() {
        this(0, 0, null, null, null, 31, null);
    }

    public MmRtcNetworkConfig(int r10) {
        this(r10, 0, null, null, null, 30, null);
    }

    public MmRtcNetworkConfig(int r10, long r11) {
        this(r10, r11, null, null, null, 28, null);
    }

    public MmRtcNetworkConfig(int r10, long r11, JsonObject r13) {
        this(r10, r11, r13, null, null, 24, null);
    }

    public MmRtcNetworkConfig(int r10, long r11, JsonObject r13, WeakNetworkABTest r14) {
        this(r10, r11, r13, r14, null, 16, null);
    }

    public static /* synthetic */ MmRtcNetworkConfig copy$default(MmRtcNetworkConfig r4, int r5, long r6, JsonObject r8, WeakNetworkABTest r9, JsonObject r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.toTcpThreshold;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.tipsDelayTime;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.networkQualityStrategy;
    L11:
        JsonObject r13 = r8;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.abTest;
    L14:
        WeakNetworkABTest r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.noRtcNetConfig;
    L17:
        int r7 = r5;
        return r4.copy(r7, r0, r13, r2, r10);
    }

    public final int component1() {
        return this.toTcpThreshold;
    }

    public final long component2() {
        return this.tipsDelayTime;
    }

    public final JsonObject component3() {
        return this.networkQualityStrategy;
    }

    public final WeakNetworkABTest component4() {
        return this.abTest;
    }

    public final JsonObject component5() {
        return this.noRtcNetConfig;
    }

    public final MmRtcNetworkConfig copy(int r9, long r10, JsonObject r12, WeakNetworkABTest r13, JsonObject r14) {
        return new MmRtcNetworkConfig(r9, r10, r12, r13, r14);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MmRtcNetworkConfig) == true) goto L8;
        return false;
    L8:
        MmRtcNetworkConfig r9 = (MmRtcNetworkConfig) r8;
        if (this.toTcpThreshold == r9.toTcpThreshold) goto L12;
        return false;
    L12:
        if (this.tipsDelayTime == r9.tipsDelayTime) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.networkQualityStrategy, r9.networkQualityStrategy) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.abTest, r9.abTest) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.noRtcNetConfig, r9.noRtcNetConfig) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.toTcpThreshold * 31;
        long r1 = this.tipsDelayTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        JsonObject r3 = this.networkQualityStrategy;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        WeakNetworkABTest r7 = this.abTest;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        JsonObject r10 = this.noRtcNetConfig;
        if (r10 == null) goto L15;
        r4 = r10.hashCode();
    L15:
        return r9 + r4;
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public String toString() {
        return "MmRtcNetworkConfig(toTcpThreshold=" + this.toTcpThreshold + ", tipsDelayTime=" + this.tipsDelayTime + ", networkQualityStrategy=" + this.networkQualityStrategy + ", abTest=" + this.abTest + ", noRtcNetConfig=" + this.noRtcNetConfig + ')';
    }

    public final WeakNetworkABTest getAbTest() {
        return this.abTest;
    }

    public final JsonObject getNetworkQualityStrategy() {
        return this.networkQualityStrategy;
    }

    public final JsonObject getNoRtcNetConfig() {
        return this.noRtcNetConfig;
    }

    public final long getTipsDelayTime() {
        return this.tipsDelayTime;
    }

    public final int getToTcpThreshold() {
        return this.toTcpThreshold;
    }

    public MmRtcNetworkConfig(int r1, long r2, JsonObject r4, WeakNetworkABTest r5, JsonObject r6) {
        this.toTcpThreshold = r1;
        this.tipsDelayTime = r2;
        this.networkQualityStrategy = r4;
        this.abTest = r5;
        this.noRtcNetConfig = r6;
    }

    public /* synthetic */ MmRtcNetworkConfig(int r5, long r6, JsonObject r8, WeakNetworkABTest r9, JsonObject r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = 0;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        JsonObject r13 = null;
    L13:
        if ((r11 & 8) == 0) goto L15;
        WeakNetworkABTest r2 = null;
    L17:
        if ((r11 & 16) == 0) goto L19;
        JsonObject r3 = null;
    L20:
        this(r5, r0, r13, r2, r3);
        return;
    L19:
        r3 = r10;
        goto L20
    L15:
        r2 = r9;
        goto L17
    L11:
        r13 = r8;
        goto L13
    }
}
