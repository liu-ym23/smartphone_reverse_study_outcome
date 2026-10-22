package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/ObricBottomTabConfig;", NameKeys.UnloadStrategy_No_Strategy, "enable", NameKeys.UnloadStrategy_No_Strategy, "personalReplaceDriveEnable", "enterpriseInsertDriveEnable", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPersonalReplaceDriveEnable", "getEnterpriseInsertDriveEnable", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/assistant/ObricBottomTabConfig;", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBottomTabConfig {

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("enterprise_insert_drive_enable")
    private final Boolean enterpriseInsertDriveEnable;

    @SerializedName("personal_replace_drive_enable")
    private final Boolean personalReplaceDriveEnable;

    public ObricBottomTabConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ObricBottomTabConfig copy$default(ObricBottomTabConfig r0, Boolean r1, Boolean r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.personalReplaceDriveEnable;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.enterpriseInsertDriveEnable;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final Boolean component2() {
        return this.personalReplaceDriveEnable;
    }

    public final Boolean component3() {
        return this.enterpriseInsertDriveEnable;
    }

    public final ObricBottomTabConfig copy(Boolean r2, Boolean r3, Boolean r4) {
        return new ObricBottomTabConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricBottomTabConfig) == true) goto L8;
        return false;
    L8:
        ObricBottomTabConfig r6 = (ObricBottomTabConfig) r5;
        if (Intrinsics.areEqual(this.enable, r6.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.personalReplaceDriveEnable, r6.personalReplaceDriveEnable) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enterpriseInsertDriveEnable, r6.enterpriseInsertDriveEnable) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.enable;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.personalReplaceDriveEnable;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.enterpriseInsertDriveEnable;
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
        return "ObricBottomTabConfig(enable=" + this.enable + ", personalReplaceDriveEnable=" + this.personalReplaceDriveEnable + ", enterpriseInsertDriveEnable=" + this.enterpriseInsertDriveEnable + ')';
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final Boolean getEnterpriseInsertDriveEnable() {
        return this.enterpriseInsertDriveEnable;
    }

    public final Boolean getPersonalReplaceDriveEnable() {
        return this.personalReplaceDriveEnable;
    }

    public ObricBottomTabConfig(Boolean r1, Boolean r2, Boolean r3) {
        this.enable = r1;
        this.personalReplaceDriveEnable = r2;
        this.enterpriseInsertDriveEnable = r3;
    }

    public /* synthetic */ ObricBottomTabConfig(Boolean r1, Boolean r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = Boolean.TRUE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = Boolean.TRUE;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = Boolean.TRUE;
    L11:
        this(r1, r2, r3);
    }
}
