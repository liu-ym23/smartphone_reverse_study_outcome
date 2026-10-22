package com.larus.contextwindow.impl.membership.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JM\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaSummaryDto;", "", "memberInfo", "Lcom/larus/contextwindow/impl/membership/model/MembershipInfoDto;", "windowLimitSection", "Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;", "enterpriseWindowLimitSection", "quotaPackageSection", "enterprisePackageEntitlementGroups", "", "Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaEntitlementGroupDto;", "<init>", "(Lcom/larus/contextwindow/impl/membership/model/MembershipInfoDto;Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;Ljava/util/List;)V", "getMemberInfo", "()Lcom/larus/contextwindow/impl/membership/model/MembershipInfoDto;", "getWindowLimitSection", "()Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;", "getEnterpriseWindowLimitSection", "getQuotaPackageSection", "getEnterprisePackageEntitlementGroups", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MembershipQuotaSummaryDto {

    @SerializedName("enterprise_package_entitlement_groups")
    private final List<MembershipQuotaEntitlementGroupDto> enterprisePackageEntitlementGroups;

    @SerializedName("enterprise_window_limit_section")
    private final WindowLimitSectionDto enterpriseWindowLimitSection;

    @SerializedName("member_info")
    private final MembershipInfoDto memberInfo;

    @SerializedName("quota_package_section")
    private final WindowLimitSectionDto quotaPackageSection;

    @SerializedName("window_limit_section")
    private final WindowLimitSectionDto windowLimitSection;

    public MembershipQuotaSummaryDto() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MembershipQuotaSummaryDto copy$default(MembershipQuotaSummaryDto r3, MembershipInfoDto r4, WindowLimitSectionDto r5, WindowLimitSectionDto r6, WindowLimitSectionDto r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.memberInfo;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.windowLimitSection;
    L8:
        WindowLimitSectionDto r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.enterpriseWindowLimitSection;
    L11:
        WindowLimitSectionDto r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.quotaPackageSection;
    L14:
        WindowLimitSectionDto r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.enterprisePackageEntitlementGroups;
    L17:
        MembershipInfoDto r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final MembershipInfoDto component1() {
        return this.memberInfo;
    }

    public final WindowLimitSectionDto component2() {
        return this.windowLimitSection;
    }

    public final WindowLimitSectionDto component3() {
        return this.enterpriseWindowLimitSection;
    }

    public final WindowLimitSectionDto component4() {
        return this.quotaPackageSection;
    }

    public final List<MembershipQuotaEntitlementGroupDto> component5() {
        return this.enterprisePackageEntitlementGroups;
    }

    public final MembershipQuotaSummaryDto copy(MembershipInfoDto r8, WindowLimitSectionDto r9, WindowLimitSectionDto r10, WindowLimitSectionDto r11, List<MembershipQuotaEntitlementGroupDto> r12) {
        return new MembershipQuotaSummaryDto(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MembershipQuotaSummaryDto) == true) goto L8;
        return false;
    L8:
        MembershipQuotaSummaryDto r6 = (MembershipQuotaSummaryDto) r5;
        if (Intrinsics.areEqual(this.memberInfo, r6.memberInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowLimitSection, r6.windowLimitSection) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enterpriseWindowLimitSection, r6.enterpriseWindowLimitSection) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.quotaPackageSection, r6.quotaPackageSection) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enterprisePackageEntitlementGroups, r6.enterprisePackageEntitlementGroups) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        MembershipInfoDto r0 = this.memberInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        WindowLimitSectionDto r4 = this.windowLimitSection;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        WindowLimitSectionDto r7 = this.enterpriseWindowLimitSection;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        WindowLimitSectionDto r10 = this.quotaPackageSection;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<MembershipQuotaEntitlementGroupDto> r13 = this.enterprisePackageEntitlementGroups;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "MembershipQuotaSummaryDto(memberInfo=" + this.memberInfo + ", windowLimitSection=" + this.windowLimitSection + ", enterpriseWindowLimitSection=" + this.enterpriseWindowLimitSection + ", quotaPackageSection=" + this.quotaPackageSection + ", enterprisePackageEntitlementGroups=" + this.enterprisePackageEntitlementGroups + ')';
    }

    public final List<MembershipQuotaEntitlementGroupDto> getEnterprisePackageEntitlementGroups() {
        return this.enterprisePackageEntitlementGroups;
    }

    public final WindowLimitSectionDto getEnterpriseWindowLimitSection() {
        return this.enterpriseWindowLimitSection;
    }

    public final MembershipInfoDto getMemberInfo() {
        return this.memberInfo;
    }

    public final WindowLimitSectionDto getQuotaPackageSection() {
        return this.quotaPackageSection;
    }

    public final WindowLimitSectionDto getWindowLimitSection() {
        return this.windowLimitSection;
    }

    public MembershipQuotaSummaryDto(MembershipInfoDto r1, WindowLimitSectionDto r2, WindowLimitSectionDto r3, WindowLimitSectionDto r4, List<MembershipQuotaEntitlementGroupDto> r5) {
        this.memberInfo = r1;
        this.windowLimitSection = r2;
        this.enterpriseWindowLimitSection = r3;
        this.quotaPackageSection = r4;
        this.enterprisePackageEntitlementGroups = r5;
    }

    public /* synthetic */ MembershipQuotaSummaryDto(MembershipInfoDto r5, WindowLimitSectionDto r6, WindowLimitSectionDto r7, WindowLimitSectionDto r8, List r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        MembershipInfoDto r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        WindowLimitSectionDto r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        WindowLimitSectionDto r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        WindowLimitSectionDto r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        List r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
