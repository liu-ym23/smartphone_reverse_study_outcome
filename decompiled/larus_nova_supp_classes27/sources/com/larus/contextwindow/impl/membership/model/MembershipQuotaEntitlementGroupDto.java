package com.larus.contextwindow.impl.membership.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementGroupDto;", "", "featureGroup", "", "entitlements", "", "Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementDto;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getFeatureGroup", "()Ljava/lang/String;", "getEntitlements", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MembershipQuotaEntitlementGroupDto {

    @SerializedName("entitlements")
    private final List<MembershipQuotaEntitlementDto> entitlements;

    @SerializedName("feature_group")
    private final String featureGroup;

    /* JADX WARN: Multi-variable type inference failed */
    public MembershipQuotaEntitlementGroupDto() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MembershipQuotaEntitlementGroupDto copy$default(MembershipQuotaEntitlementGroupDto r0, String r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.featureGroup;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.entitlements;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.featureGroup;
    }

    public final List<MembershipQuotaEntitlementDto> component2() {
        return this.entitlements;
    }

    public final MembershipQuotaEntitlementGroupDto copy(String r2, List<MembershipQuotaEntitlementDto> r3) {
        return new MembershipQuotaEntitlementGroupDto(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MembershipQuotaEntitlementGroupDto) == true) goto L8;
        return false;
    L8:
        MembershipQuotaEntitlementGroupDto r6 = (MembershipQuotaEntitlementGroupDto) r5;
        if (Intrinsics.areEqual(this.featureGroup, r6.featureGroup) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entitlements, r6.entitlements) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.featureGroup;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<MembershipQuotaEntitlementDto> r4 = this.entitlements;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MembershipQuotaEntitlementGroupDto(featureGroup=" + this.featureGroup + ", entitlements=" + this.entitlements + ')';
    }

    public final List<MembershipQuotaEntitlementDto> getEntitlements() {
        return this.entitlements;
    }

    public final String getFeatureGroup() {
        return this.featureGroup;
    }

    public MembershipQuotaEntitlementGroupDto(String r1, List<MembershipQuotaEntitlementDto> r2) {
        this.featureGroup = r1;
        this.entitlements = r2;
    }

    public /* synthetic */ MembershipQuotaEntitlementGroupDto(String r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
