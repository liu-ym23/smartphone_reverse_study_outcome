package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J1\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/dora/impl/settings/DoraGOnboardingQueryTopics;", "", "aiLiveScene", "", "", "queryTopic", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getAiLiveScene", "()Ljava/util/List;", "getQueryTopic", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingQueryTopics {

    @SerializedName("ailive_scene")
    private final List<String> aiLiveScene;

    @SerializedName("query_scene")
    private final List<String> queryTopic;

    public DoraGOnboardingQueryTopics() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DoraGOnboardingQueryTopics copy$default(DoraGOnboardingQueryTopics r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.aiLiveScene;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.queryTopic;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<String> component1() {
        return this.aiLiveScene;
    }

    public final List<String> component2() {
        return this.queryTopic;
    }

    public final DoraGOnboardingQueryTopics copy(List<String> r2, List<String> r3) {
        return new DoraGOnboardingQueryTopics(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraGOnboardingQueryTopics) == true) goto L8;
        return false;
    L8:
        DoraGOnboardingQueryTopics r6 = (DoraGOnboardingQueryTopics) r5;
        if (Intrinsics.areEqual(this.aiLiveScene, r6.aiLiveScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queryTopic, r6.queryTopic) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.aiLiveScene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.queryTopic;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DoraGOnboardingQueryTopics(aiLiveScene=" + this.aiLiveScene + ", queryTopic=" + this.queryTopic + ')';
    }

    public final List<String> getAiLiveScene() {
        return this.aiLiveScene;
    }

    public final List<String> getQueryTopic() {
        return this.queryTopic;
    }

    public DoraGOnboardingQueryTopics(List<String> r1, List<String> r2) {
        this.aiLiveScene = r1;
        this.queryTopic = r2;
    }

    public /* synthetic */ DoraGOnboardingQueryTopics(List r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
