package com.larus.commercemembership.impl;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J_\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larus/commercemembership/impl/CommerceMembershipService$MembershipInAppPushData;", "", "bannerSource", "", "serverRequired", "triggerReason", "buttonText", "policy", "Lcom/larus/commercemembership/impl/CommerceMembershipService$MembershipInAppPushPolicy;", "localizedTexts", "", "Lcom/larus/commercemembership/impl/CommerceMembershipService$MembershipLocalizedText;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/commercemembership/impl/CommerceMembershipService$MembershipInAppPushPolicy;Ljava/util/Map;)V", "getBannerSource", "()Ljava/lang/String;", "getServerRequired", "getTriggerReason", "getButtonText", "getPolicy", "()Lcom/larus/commercemembership/impl/CommerceMembershipService$MembershipInAppPushPolicy;", "getLocalizedTexts", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommerceMembershipService$MembershipInAppPushData {

    @SerializedName("banner_source")
    private final String bannerSource;

    @SerializedName("button_text")
    private final String buttonText;

    @SerializedName("localized_texts")
    private final Map<String, CommerceMembershipService$MembershipLocalizedText> localizedTexts;

    @SerializedName("policy")
    private final CommerceMembershipService$MembershipInAppPushPolicy policy;

    @SerializedName("server_required")
    private final String serverRequired;

    @SerializedName("trigger_reason")
    private final String triggerReason;

    public CommerceMembershipService$MembershipInAppPushData() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommerceMembershipService$MembershipInAppPushData copy$default(CommerceMembershipService$MembershipInAppPushData r4, String r5, String r6, String r7, String r8, CommerceMembershipService$MembershipInAppPushPolicy r9, Map r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.bannerSource;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.serverRequired;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.triggerReason;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.buttonText;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.policy;
    L17:
        CommerceMembershipService$MembershipInAppPushPolicy r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.localizedTexts;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.bannerSource;
    }

    public final String component2() {
        return this.serverRequired;
    }

    public final String component3() {
        return this.triggerReason;
    }

    public final String component4() {
        return this.buttonText;
    }

    public final CommerceMembershipService$MembershipInAppPushPolicy component5() {
        return this.policy;
    }

    public final Map<String, CommerceMembershipService$MembershipLocalizedText> component6() {
        return this.localizedTexts;
    }

    public final CommerceMembershipService$MembershipInAppPushData copy(String r9, String r10, String r11, String r12, CommerceMembershipService$MembershipInAppPushPolicy r13, Map<String, CommerceMembershipService$MembershipLocalizedText> r14) {
        return new CommerceMembershipService$MembershipInAppPushData(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CommerceMembershipService$MembershipInAppPushData) == true) goto L8;
        return false;
    L8:
        CommerceMembershipService$MembershipInAppPushData r6 = (CommerceMembershipService$MembershipInAppPushData) r5;
        if (Intrinsics.areEqual(this.bannerSource, r6.bannerSource) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.serverRequired, r6.serverRequired) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.triggerReason, r6.triggerReason) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.buttonText, r6.buttonText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.policy, r6.policy) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.localizedTexts, r6.localizedTexts) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.bannerSource;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.serverRequired;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.triggerReason;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.buttonText;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        CommerceMembershipService$MembershipInAppPushPolicy r13 = this.policy;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, CommerceMembershipService$MembershipLocalizedText> r16 = this.localizedTexts;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MembershipInAppPushData(bannerSource=" + this.bannerSource + ", serverRequired=" + this.serverRequired + ", triggerReason=" + this.triggerReason + ", buttonText=" + this.buttonText + ", policy=" + this.policy + ", localizedTexts=" + this.localizedTexts + ')';
    }

    public final String getBannerSource() {
        return this.bannerSource;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final Map<String, CommerceMembershipService$MembershipLocalizedText> getLocalizedTexts() {
        return this.localizedTexts;
    }

    public final CommerceMembershipService$MembershipInAppPushPolicy getPolicy() {
        return this.policy;
    }

    public final String getServerRequired() {
        return this.serverRequired;
    }

    public final String getTriggerReason() {
        return this.triggerReason;
    }

    public CommerceMembershipService$MembershipInAppPushData(String r1, String r2, String r3, String r4, CommerceMembershipService$MembershipInAppPushPolicy r5, Map<String, CommerceMembershipService$MembershipLocalizedText> r6) {
        this.bannerSource = r1;
        this.serverRequired = r2;
        this.triggerReason = r3;
        this.buttonText = r4;
        this.policy = r5;
        this.localizedTexts = r6;
    }

    public /* synthetic */ CommerceMembershipService$MembershipInAppPushData(String r6, String r7, String r8, String r9, CommerceMembershipService$MembershipInAppPushPolicy r10, Map r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        CommerceMembershipService$MembershipInAppPushPolicy r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        Map r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
