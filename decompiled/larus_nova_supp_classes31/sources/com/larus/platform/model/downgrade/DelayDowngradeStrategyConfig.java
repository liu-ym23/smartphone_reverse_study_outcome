package com.larus.platform.model.downgrade;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\u0083\u0001\u0010\u0019\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR.\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lcom/larus/platform/model/downgrade/DelayDowngradeStrategyConfig;", "", "extraMatchers", "", "", "", "bodyMatchers", "queryMatchers", "baseDelayMs", "", "jitterMs", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JJ)V", "getExtraMatchers", "()Ljava/util/Map;", "getBodyMatchers", "getQueryMatchers", "getBaseDelayMs", "()J", "getJitterMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DelayDowngradeStrategyConfig {

    @SerializedName("base_delay_ms")
    private final long baseDelayMs;

    @SerializedName("body_matchers")
    private final Map<String, List<String>> bodyMatchers;

    @SerializedName("extra_matchers")
    private final Map<String, List<String>> extraMatchers;

    @SerializedName("jitter_ms")
    private final long jitterMs;

    @SerializedName("query_matchers")
    private final Map<String, List<String>> queryMatchers;

    public DelayDowngradeStrategyConfig() {
        this(null, null, null, 0, 0, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DelayDowngradeStrategyConfig copy$default(DelayDowngradeStrategyConfig r5, Map r6, Map r7, Map r8, long r9, long r11, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.extraMatchers;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.bodyMatchers;
    L8:
        Map r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.queryMatchers;
    L11:
        Map r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.baseDelayMs;
    L14:
        long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.jitterMs;
    L17:
        Map r10 = r6;
        return r5.copy(r10, r15, r0, r1, r11);
    }

    public final Map<String, List<String>> component1() {
        return this.extraMatchers;
    }

    public final Map<String, List<String>> component2() {
        return this.bodyMatchers;
    }

    public final Map<String, List<String>> component3() {
        return this.queryMatchers;
    }

    public final long component4() {
        return this.baseDelayMs;
    }

    public final long component5() {
        return this.jitterMs;
    }

    public final DelayDowngradeStrategyConfig copy(Map<String, ? extends List<String>> r10, Map<String, ? extends List<String>> r11, Map<String, ? extends List<String>> r12, long r13, long r15) {
        return new DelayDowngradeStrategyConfig(r10, r11, r12, r13, r15);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DelayDowngradeStrategyConfig) == true) goto L8;
        return false;
    L8:
        DelayDowngradeStrategyConfig r9 = (DelayDowngradeStrategyConfig) r8;
        if (Intrinsics.areEqual(this.extraMatchers, r9.extraMatchers) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bodyMatchers, r9.bodyMatchers) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queryMatchers, r9.queryMatchers) == true) goto L18;
        return false;
    L18:
        if (this.baseDelayMs == r9.baseDelayMs) goto L21;
        return false;
    L21:
        if (this.jitterMs == r9.jitterMs) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Map<String, List<String>> r0 = this.extraMatchers;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, List<String>> r4 = this.bodyMatchers;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, List<String>> r7 = this.queryMatchers;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        int r8 = (r6 + r1) * 31;
        long r9 = this.baseDelayMs;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        long r11 = this.jitterMs;
        return r10 + ((int) (r11 ^ (r11 >>> 32)));
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DelayDowngradeStrategyConfig(extraMatchers=" + this.extraMatchers + ", bodyMatchers=" + this.bodyMatchers + ", queryMatchers=" + this.queryMatchers + ", baseDelayMs=" + this.baseDelayMs + ", jitterMs=" + this.jitterMs + ')';
    }

    public final long getBaseDelayMs() {
        return this.baseDelayMs;
    }

    public final Map<String, List<String>> getBodyMatchers() {
        return this.bodyMatchers;
    }

    public final Map<String, List<String>> getExtraMatchers() {
        return this.extraMatchers;
    }

    public final long getJitterMs() {
        return this.jitterMs;
    }

    public final Map<String, List<String>> getQueryMatchers() {
        return this.queryMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelayDowngradeStrategyConfig(Map<String, ? extends List<String>> r1, Map<String, ? extends List<String>> r2, Map<String, ? extends List<String>> r3, long r4, long r6) {
        this.extraMatchers = r1;
        this.bodyMatchers = r2;
        this.queryMatchers = r3;
        this.baseDelayMs = r4;
        this.jitterMs = r6;
    }

    public /* synthetic */ DelayDowngradeStrategyConfig(Map r6, Map r7, Map r8, long r9, long r11, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = MapsKt.emptyMap();
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = MapsKt.emptyMap();
    L8:
        Map r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = MapsKt.emptyMap();
    L11:
        Map r0 = r8;
        long r1 = 0;
        if ((r13 & 8) == 0) goto L14;
        long r3 = 0;
    L16:
        if ((r13 & 16) != 0) goto L19;
        r1 = r11;
    L19:
        this(r6, r15, r0, r3, r1);
        return;
    L14:
        r3 = r9;
        goto L16
    }
}
