package qz8;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/commercecredit/impl/entity/UserActivityInfo;", "", "totalCreditNum", "", "activityTime", "<init>", "(JJ)V", "getTotalCreditNum", "()J", "getActivityTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class q {

    @SerializedName("activity_time")
    private final long activityTime;

    @SerializedName("total_credit_num")
    private final long totalCreditNum;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q) == true) goto L8;
        return false;
    L8:
        q r9 = (q) r8;
        if (this.totalCreditNum == r9.totalCreditNum) goto L12;
        return false;
    L12:
        if (this.activityTime == r9.activityTime) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.totalCreditNum;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.activityTime;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "UserActivityInfo(totalCreditNum=" + this.totalCreditNum + ", activityTime=" + this.activityTime + ')';
    }

    public q() {
        this.totalCreditNum = 0;
        this.activityTime = 0;
    }

    public final long a() {
        return this.activityTime;
    }

    public final long b() {
        return this.totalCreditNum;
    }
}
