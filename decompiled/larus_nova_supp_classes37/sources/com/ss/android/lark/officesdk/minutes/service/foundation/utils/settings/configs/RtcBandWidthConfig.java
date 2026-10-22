package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/RtcBandWidthConfig;", "Ljava/io/Serializable;", "<init>", "()V", "bwThreshold", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/RtcBandWidthConfig$BwThreshold;", "getBwThreshold", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/RtcBandWidthConfig$BwThreshold;", "setBwThreshold", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/RtcBandWidthConfig$BwThreshold;)V", "BwThreshold", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class RtcBandWidthConfig implements Serializable {

    @SerializedName("bw_threshold")
    private BwThreshold bwThreshold;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/utils/settings/configs/RtcBandWidthConfig$BwThreshold;", "Ljava/io/Serializable;", "<init>", "()V", "extremeLow", "", "getExtremeLow", "()Ljava/lang/Integer;", "setExtremeLow", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "low", "getLow", "setLow", "multiStreamAddtion", "getMultiStreamAddtion", "setMultiStreamAddtion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class BwThreshold implements Serializable {

        @SerializedName("extreme_low")
        private Integer extremeLow;

        @SerializedName("low")
        private Integer low;

        @SerializedName("multistream_addtion")
        private Integer multiStreamAddtion;

        public BwThreshold() {
        }

        public final Integer getExtremeLow() {
            return this.extremeLow;
        }

        public final Integer getLow() {
            return this.low;
        }

        public final Integer getMultiStreamAddtion() {
            return this.multiStreamAddtion;
        }

        public final void setExtremeLow(Integer r1) {
            this.extremeLow = r1;
        }

        public final void setLow(Integer r1) {
            this.low = r1;
        }

        public final void setMultiStreamAddtion(Integer r1) {
            this.multiStreamAddtion = r1;
        }
    }

    public RtcBandWidthConfig() {
    }

    public final BwThreshold getBwThreshold() {
        return this.bwThreshold;
    }

    public final void setBwThreshold(BwThreshold r1) {
        this.bwThreshold = r1;
    }
}
