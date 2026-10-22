package l12;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ll12/c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftId", "Ljava/lang/Long;", "getGiftId", "()Ljava/lang/Long;", BuildConfig.FLAVOR, "index", "Ljava/lang/Integer;", "getIndex", "()Ljava/lang/Integer;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("gift_id")
    private final Long giftId;

    @SerializedName("index")
    private final Integer index;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.giftId, r4.giftId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.index, r4.index) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.giftId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.index;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftPredictElement(giftId=" + this.giftId + ", index=" + this.index + ")";
    }

    public c() {
        this.giftId = null;
        this.index = null;
    }
}
