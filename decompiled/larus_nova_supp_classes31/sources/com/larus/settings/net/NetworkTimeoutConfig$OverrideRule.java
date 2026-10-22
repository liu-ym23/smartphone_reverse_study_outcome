package com.larus.settings.net;

import com.google.gson.annotations.SerializedName;
import com.larus.network.interceptor.config.TimeoutConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/net/NetworkTimeoutConfig$OverrideRule;", "", "domain", "", "path", "timeout", "Lcom/larus/network/interceptor/config/TimeoutConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/network/interceptor/config/TimeoutConfig;)V", "getDomain", "()Ljava/lang/String;", "getPath", "getTimeout", "()Lcom/larus/network/interceptor/config/TimeoutConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class NetworkTimeoutConfig$OverrideRule {

    @SerializedName("domain")
    private final String domain;

    @SerializedName("path")
    private final String path;

    @SerializedName("timeout")
    private final TimeoutConfig timeout;

    public NetworkTimeoutConfig$OverrideRule() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NetworkTimeoutConfig$OverrideRule copy$default(NetworkTimeoutConfig$OverrideRule r0, String r1, String r2, TimeoutConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.domain;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.path;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.timeout;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.domain;
    }

    public final String component2() {
        return this.path;
    }

    public final TimeoutConfig component3() {
        return this.timeout;
    }

    public final NetworkTimeoutConfig$OverrideRule copy(String r2, String r3, TimeoutConfig r4) {
        return new NetworkTimeoutConfig$OverrideRule(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NetworkTimeoutConfig$OverrideRule) == true) goto L8;
        return false;
    L8:
        NetworkTimeoutConfig$OverrideRule r6 = (NetworkTimeoutConfig$OverrideRule) r5;
        if (Intrinsics.areEqual(this.domain, r6.domain) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.path, r6.path) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timeout, r6.timeout) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.domain;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.path;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        TimeoutConfig r7 = this.timeout;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OverrideRule(domain=" + this.domain + ", path=" + this.path + ", timeout=" + this.timeout + ')';
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getPath() {
        return this.path;
    }

    public final TimeoutConfig getTimeout() {
        return this.timeout;
    }

    public NetworkTimeoutConfig$OverrideRule(String r1, String r2, TimeoutConfig r3) {
        this.domain = r1;
        this.path = r2;
        this.timeout = r3;
    }

    public /* synthetic */ NetworkTimeoutConfig$OverrideRule(String r2, String r3, TimeoutConfig r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
