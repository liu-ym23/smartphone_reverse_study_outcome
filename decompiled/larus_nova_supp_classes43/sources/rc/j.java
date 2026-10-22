package rc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lrc/j;", "", "", "ruleKey", "Ljava/lang/String;", "getRuleKey", "()Ljava/lang/String;", "setRuleKey", "(Ljava/lang/String;)V", "Lrc/l;", "events", "Lrc/l;", "getEvents", "()Lrc/l;", "", "exposureRepeatedly", "Z", "getExposureRepeatedly", "()Z", "setExposureRepeatedly", "(Z)V", "", "exposureScale", "F", "getExposureScale", "()F", "setExposureScale", "(F)V", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class j {

    @SerializedName("events")
    private final l events;

    @SerializedName("exposure_repeatedly")
    private boolean exposureRepeatedly;

    @SerializedName("exposure_scale")
    private float exposureScale;

    @SerializedName("rule_key")
    private String ruleKey;

    public final int hashCode() {
        int r0 = ((this.ruleKey.hashCode() * 31) + this.events.hashCode()) * 31;
        if (this.exposureRepeatedly == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + Float.floatToIntBits(this.exposureScale);
    L5:
        r1 = 1237;
        goto L7
    }

    public j() {
        this.ruleKey = "shopping";
        this.events = new l();
        this.exposureScale = 0.25f;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if ((!Intrinsics.areEqual(j.class, r11)) == false) goto L12;
        return false;
    L12:
        if (r10 == null) goto L27;
        j r12 = (j) r10;
        if ((!Intrinsics.areEqual(this.ruleKey, r12.ruleKey)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.events, r12.events)) == false) goto L20;
        return false;
    L20:
        if (this.exposureRepeatedly == r12.exposureRepeatedly) goto L23;
        return false;
    L23:
        if (this.exposureScale == r12.exposureScale) goto L25;
        return false;
    L25:
        return true;
    L27:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.bst.api.config.BstModelConfigV2");
    L8:
        r11 = null;
        goto L10
    }
}
