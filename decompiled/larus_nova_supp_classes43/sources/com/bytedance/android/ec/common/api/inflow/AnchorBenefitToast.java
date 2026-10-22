package com.bytedance.android.ec.common.api.inflow;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/common/api/inflow/AnchorBenefitToast;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "tip", "Ljava/lang/String;", "getTip", "()Ljava/lang/String;", "resultType", "getResultType", "benefitType", "getBenefitType", "", "trackParams", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "<init>", "()V", "Companion", "a", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class AnchorBenefitToast implements Serializable {
    public static final a Companion = null;
    public static final String TYPE_COUPON = "coupon";
    public static final String TYPE_COUPON_PACKAGE = "coupon_package";

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE)
    private final String benefitType;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("result_type")
    private final String resultType;

    @SerializedName("tip")
    private final String tip;

    @SerializedName("track_param")
    private final Map<String, String> trackParams;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AnchorBenefitToast() {
    }

    public final String getBenefitType() {
        return this.benefitType;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getResultType() {
        return this.resultType;
    }

    public final String getTip() {
        return this.tip;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }
}
