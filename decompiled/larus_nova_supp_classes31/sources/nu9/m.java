package nu9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/settings/provider/dora/DoraNewSafeStopConfig;", "", "enableDoraNewSafeStop", "", "enableDoraSkipWakeUp", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnableDoraNewSafeStop", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableDoraSkipWakeUp", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/settings/provider/dora/DoraNewSafeStopConfig;", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class m {

    @SerializedName("enable_dora_new_safe_stop")
    private final Boolean enableDoraNewSafeStop;

    @SerializedName("enable_dora_skip_wake_up")
    private final Boolean enableDoraSkipWakeUp;

    public m() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.enableDoraNewSafeStop, r6.enableDoraNewSafeStop) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableDoraSkipWakeUp, r6.enableDoraSkipWakeUp) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.enableDoraNewSafeStop;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.enableDoraSkipWakeUp;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraNewSafeStopConfig(enableDoraNewSafeStop=" + this.enableDoraNewSafeStop + ", enableDoraSkipWakeUp=" + this.enableDoraSkipWakeUp + ')';
    }

    public final Boolean a() {
        return this.enableDoraSkipWakeUp;
    }

    public m(int r1) {
        Boolean r2 = Boolean.TRUE;
        this.enableDoraNewSafeStop = r2;
        this.enableDoraSkipWakeUp = r2;
    }
}
