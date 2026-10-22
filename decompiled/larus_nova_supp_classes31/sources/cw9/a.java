package cw9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/provider/shortvideo/ShortVideoAuthorizationConfig;", "", "earlierStage", "", "laterStage", "<init>", "(JJ)V", "getEarlierStage", "()J", "getLaterStage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a {

    @SerializedName("earlier_stage")
    private final long earlierStage;

    @SerializedName("later_stage")
    private final long laterStage;

    public a() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.earlierStage == r9.earlierStage) goto L12;
        return false;
    L12:
        if (this.laterStage == r9.laterStage) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = this.earlierStage;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.laterStage;
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "ShortVideoAuthorizationConfig(earlierStage=" + this.earlierStage + ", laterStage=" + this.laterStage + ')';
    }

    public final long a() {
        return this.earlierStage;
    }

    public final long b() {
        return this.laterStage;
    }

    public a(int r3) {
        this.earlierStage = 86400;
        this.laterStage = 259200;
    }
}
