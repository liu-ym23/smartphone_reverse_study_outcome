package com.larus.contextwindow.impl.membership.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipInfoDto;", "", "hasActiveSubscription", "", "hasEnterpriseSubscription", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getHasActiveSubscription", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasEnterpriseSubscription", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/contextwindow/impl/membership/model/MembershipInfoDto;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MembershipInfoDto {

    @SerializedName(alternate = {"hasActiveSubscription"}, value = "has_active_subscription")
    private final Boolean hasActiveSubscription;

    @SerializedName(alternate = {"hasEnterpriseSubscription"}, value = "has_enterprise_subscription")
    private final Boolean hasEnterpriseSubscription;

    public MembershipInfoDto() {
        Boolean r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ MembershipInfoDto copy$default(MembershipInfoDto r0, Boolean r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.hasActiveSubscription;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.hasEnterpriseSubscription;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.hasActiveSubscription;
    }

    public final Boolean component2() {
        return this.hasEnterpriseSubscription;
    }

    public final MembershipInfoDto copy(Boolean r2, Boolean r3) {
        return new MembershipInfoDto(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MembershipInfoDto) == true) goto L8;
        return false;
    L8:
        MembershipInfoDto r6 = (MembershipInfoDto) r5;
        if (Intrinsics.areEqual(this.hasActiveSubscription, r6.hasActiveSubscription) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hasEnterpriseSubscription, r6.hasEnterpriseSubscription) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.hasActiveSubscription;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.hasEnterpriseSubscription;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MembershipInfoDto(hasActiveSubscription=" + this.hasActiveSubscription + ", hasEnterpriseSubscription=" + this.hasEnterpriseSubscription + ')';
    }

    public final Boolean getHasActiveSubscription() {
        return this.hasActiveSubscription;
    }

    public final Boolean getHasEnterpriseSubscription() {
        return this.hasEnterpriseSubscription;
    }

    public MembershipInfoDto(Boolean r1, Boolean r2) {
        this.hasActiveSubscription = r1;
        this.hasEnterpriseSubscription = r2;
    }

    public /* synthetic */ MembershipInfoDto(Boolean r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
