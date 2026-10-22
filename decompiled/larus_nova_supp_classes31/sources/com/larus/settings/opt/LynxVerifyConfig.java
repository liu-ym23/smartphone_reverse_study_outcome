package com.larus.settings.opt;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/opt/LynxVerifyConfig;", "", "enableIntercept", "", "enableReport", "innerDomains", "", "", "<init>", "(ZZLjava/util/List;)V", "getEnableIntercept", "()Z", "getEnableReport", "getInnerDomains", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LynxVerifyConfig {

    @SerializedName("enable_intercept")
    private final boolean enableIntercept;

    @SerializedName("enable_report")
    private final boolean enableReport;

    @SerializedName("inner_domains")
    private final List<String> innerDomains;

    public LynxVerifyConfig() {
        this(false, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxVerifyConfig copy$default(LynxVerifyConfig r0, boolean r1, boolean r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enableIntercept;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.enableReport;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.innerDomains;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enableIntercept;
    }

    public final boolean component2() {
        return this.enableReport;
    }

    public final List<String> component3() {
        return this.innerDomains;
    }

    public final LynxVerifyConfig copy(boolean r2, boolean r3, List<String> r4) {
        return new LynxVerifyConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LynxVerifyConfig) == true) goto L8;
        return false;
    L8:
        LynxVerifyConfig r6 = (LynxVerifyConfig) r5;
        if (this.enableIntercept == r6.enableIntercept) goto L12;
        return false;
    L12:
        if (this.enableReport == r6.enableReport) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.innerDomains, r6.innerDomains) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enableIntercept == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableReport == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        List<String> r4 = this.innerDomains;
        if (r4 != null) goto L13;
        int r5 = 0;
    L15:
        return r3 + r5;
    L13:
        r5 = r4.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "LynxVerifyConfig(enableIntercept=" + this.enableIntercept + ", enableReport=" + this.enableReport + ", innerDomains=" + this.innerDomains + ')';
    }

    public final boolean getEnableIntercept() {
        return this.enableIntercept;
    }

    public final boolean getEnableReport() {
        return this.enableReport;
    }

    public final List<String> getInnerDomains() {
        return this.innerDomains;
    }

    public LynxVerifyConfig(boolean r1, boolean r2, List<String> r3) {
        this.enableIntercept = r1;
        this.enableReport = r2;
        this.innerDomains = r3;
    }

    public /* synthetic */ LynxVerifyConfig(boolean r2, boolean r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
