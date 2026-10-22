package com.bytedance.android.ec.common.impl.sku.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/ExtraAttribute;", "Ljava/io/Serializable;", "userDeviceName", "", "matchSpecId", "(Ljava/lang/String;Ljava/lang/String;)V", "getMatchSpecId", "()Ljava/lang/String;", "getUserDeviceName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExtraAttribute implements Serializable {

    @SerializedName("match_spec_id")
    private final String matchSpecId;

    @SerializedName("user_device_name")
    private final String userDeviceName;

    public ExtraAttribute() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ ExtraAttribute copy$default(ExtraAttribute r0, String r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.userDeviceName;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.matchSpecId;
    L9:
        return r0.copy(r1, r10);
    }

    public final String component1() {
        return this.userDeviceName;
    }

    public final String component2() {
        return this.matchSpecId;
    }

    public final ExtraAttribute copy(String r10, String r11) {
        return new ExtraAttribute(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ExtraAttribute) == false) goto L10;
        ExtraAttribute r11 = (ExtraAttribute) r10;
        if (Intrinsics.areEqual(this.userDeviceName, r11.userDeviceName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.matchSpecId, r11.matchSpecId) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.userDeviceName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.matchSpecId;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "ExtraAttribute(userDeviceName=" + this.userDeviceName + ", matchSpecId=" + this.matchSpecId + ")";
    }

    public final String getMatchSpecId() {
        return this.matchSpecId;
    }

    public final String getUserDeviceName() {
        return this.userDeviceName;
    }

    public ExtraAttribute(String r1, String r10) {
        this.userDeviceName = r1;
        this.matchSpecId = r10;
    }

    public /* synthetic */ ExtraAttribute(String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
