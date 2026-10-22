package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/settings/DoraGOnboardingOpenRemark;", "", "aiLiveScene", "", "queryScene", "queryGuide", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAiLiveScene", "()Ljava/lang/String;", "getQueryScene", "getQueryGuide", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingOpenRemark {

    @SerializedName("ailive_scene")
    private final String aiLiveScene;

    @SerializedName("query_guide")
    private final String queryGuide;

    @SerializedName("query_scene")
    private final String queryScene;

    public DoraGOnboardingOpenRemark() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DoraGOnboardingOpenRemark copy$default(DoraGOnboardingOpenRemark r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.aiLiveScene;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.queryScene;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.queryGuide;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.aiLiveScene;
    }

    public final String component2() {
        return this.queryScene;
    }

    public final String component3() {
        return this.queryGuide;
    }

    public final DoraGOnboardingOpenRemark copy(String r2, String r3, String r4) {
        return new DoraGOnboardingOpenRemark(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraGOnboardingOpenRemark) == true) goto L8;
        return false;
    L8:
        DoraGOnboardingOpenRemark r6 = (DoraGOnboardingOpenRemark) r5;
        if (Intrinsics.areEqual(this.aiLiveScene, r6.aiLiveScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queryScene, r6.queryScene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.queryGuide, r6.queryGuide) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.aiLiveScene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.queryScene;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.queryGuide;
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
        return "DoraGOnboardingOpenRemark(aiLiveScene=" + this.aiLiveScene + ", queryScene=" + this.queryScene + ", queryGuide=" + this.queryGuide + ')';
    }

    public final String getAiLiveScene() {
        return this.aiLiveScene;
    }

    public final String getQueryGuide() {
        return this.queryGuide;
    }

    public final String getQueryScene() {
        return this.queryScene;
    }

    public DoraGOnboardingOpenRemark(String r1, String r2, String r3) {
        this.aiLiveScene = r1;
        this.queryScene = r2;
        this.queryGuide = r3;
    }

    public /* synthetic */ DoraGOnboardingOpenRemark(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
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
