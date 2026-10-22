package com.ss.android.lark.profile.v2.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/CustomPhone;", "Ljava/io/Serializable;", "phoneNumber", "", "extensionNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPhoneNumber", "()Ljava/lang/String;", "getExtensionNumber", "join", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CustomPhone implements Serializable {

    @SerializedName("extension_number")
    private final String extensionNumber;

    @SerializedName("phone_number")
    private final String phoneNumber;

    public CustomPhone() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ CustomPhone copy$default(CustomPhone r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.phoneNumber;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.extensionNumber;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.phoneNumber;
    }

    public final String component2() {
        return this.extensionNumber;
    }

    public final CustomPhone copy(String r2, String r3) {
        return new CustomPhone(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CustomPhone) == true) goto L8;
        return false;
    L8:
        CustomPhone r6 = (CustomPhone) r5;
        if (Intrinsics.areEqual(this.phoneNumber, r6.phoneNumber) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extensionNumber, r6.extensionNumber) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.phoneNumber;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.extensionNumber;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CustomPhone(phoneNumber=" + this.phoneNumber + ", extensionNumber=" + this.extensionNumber + ')';
    }

    public final String join() {
        String r0 = this.phoneNumber;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return "";
    L12:
        String r3 = this.extensionNumber;
        if (r3 != null) goto L15;
    L16:
        r1 = true;
    L17:
        if (r1 == false) goto L21;
        return this.phoneNumber;
    L21:
        return this.phoneNumber + ',' + this.extensionNumber;
    L15:
        if (r3.length() != 0) goto L17;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final String getExtensionNumber() {
        return this.extensionNumber;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public CustomPhone(String r1, String r2) {
        this.phoneNumber = r1;
        this.extensionNumber = r2;
    }

    public /* synthetic */ CustomPhone(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
