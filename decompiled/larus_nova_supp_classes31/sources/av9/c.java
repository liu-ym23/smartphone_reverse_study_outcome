package av9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/login/FlowSwitchBindConfig;", "", "shouldCheckEmail", "", "shouldCheckMobile", "shouldCheckThirdParty", "<init>", "(ZZZ)V", "getShouldCheckEmail", "()Z", "getShouldCheckMobile", "getShouldCheckThirdParty", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class c {

    @SerializedName("should_check_email")
    private final boolean shouldCheckEmail;

    @SerializedName("should_check_mobile")
    private final boolean shouldCheckMobile;

    @SerializedName("should_check_third_party")
    private final boolean shouldCheckThirdParty;

    public c() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.shouldCheckEmail == r6.shouldCheckEmail) goto L12;
        return false;
    L12:
        if (this.shouldCheckMobile == r6.shouldCheckMobile) goto L15;
        return false;
    L15:
        if (this.shouldCheckThirdParty == r6.shouldCheckThirdParty) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.shouldCheckEmail == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.shouldCheckMobile == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.shouldCheckThirdParty == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowSwitchBindConfig(shouldCheckEmail=" + this.shouldCheckEmail + ", shouldCheckMobile=" + this.shouldCheckMobile + ", shouldCheckThirdParty=" + this.shouldCheckThirdParty + ')';
    }

    public final boolean a() {
        return this.shouldCheckEmail;
    }

    public final boolean b() {
        return this.shouldCheckMobile;
    }

    public final boolean c() {
        return this.shouldCheckThirdParty;
    }

    public c(int r1) {
        this.shouldCheckEmail = false;
        this.shouldCheckMobile = true;
        this.shouldCheckThirdParty = true;
    }
}
