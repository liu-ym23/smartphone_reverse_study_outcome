package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/settings/DoraGOnboardingConfig;", "", "queryTopic", "Lcom/larus/dora/impl/settings/DoraGOnboardingQueryTopics;", "openRemark", "Lcom/larus/dora/impl/settings/DoraGOnboardingOpenRemark;", "<init>", "(Lcom/larus/dora/impl/settings/DoraGOnboardingQueryTopics;Lcom/larus/dora/impl/settings/DoraGOnboardingOpenRemark;)V", "getQueryTopic", "()Lcom/larus/dora/impl/settings/DoraGOnboardingQueryTopics;", "getOpenRemark", "()Lcom/larus/dora/impl/settings/DoraGOnboardingOpenRemark;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingConfig {

    @SerializedName("dora_g_opening_remarks")
    private final DoraGOnboardingOpenRemark openRemark;

    @SerializedName("dora_g_query_topics")
    private final DoraGOnboardingQueryTopics queryTopic;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraGOnboardingConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DoraGOnboardingConfig copy$default(DoraGOnboardingConfig r0, DoraGOnboardingQueryTopics r1, DoraGOnboardingOpenRemark r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.queryTopic;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.openRemark;
    L9:
        return r0.copy(r1, r2);
    }

    public final DoraGOnboardingQueryTopics component1() {
        return this.queryTopic;
    }

    public final DoraGOnboardingOpenRemark component2() {
        return this.openRemark;
    }

    public final DoraGOnboardingConfig copy(DoraGOnboardingQueryTopics r2, DoraGOnboardingOpenRemark r3) {
        return new DoraGOnboardingConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraGOnboardingConfig) == true) goto L8;
        return false;
    L8:
        DoraGOnboardingConfig r6 = (DoraGOnboardingConfig) r5;
        if (Intrinsics.areEqual(this.queryTopic, r6.queryTopic) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.openRemark, r6.openRemark) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        DoraGOnboardingQueryTopics r0 = this.queryTopic;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        DoraGOnboardingOpenRemark r4 = this.openRemark;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DoraGOnboardingConfig(queryTopic=" + this.queryTopic + ", openRemark=" + this.openRemark + ')';
    }

    public final DoraGOnboardingOpenRemark getOpenRemark() {
        return this.openRemark;
    }

    public final DoraGOnboardingQueryTopics getQueryTopic() {
        return this.queryTopic;
    }

    public DoraGOnboardingConfig(DoraGOnboardingQueryTopics r1, DoraGOnboardingOpenRemark r2) {
        this.queryTopic = r1;
        this.openRemark = r2;
    }

    public /* synthetic */ DoraGOnboardingConfig(DoraGOnboardingQueryTopics r2, DoraGOnboardingOpenRemark r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
