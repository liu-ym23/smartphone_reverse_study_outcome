package com.larus.bmhome.view.actionbar.gaokao.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\nHÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceConfResponse;", "", "provinceList", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceList;", "typeList", "Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoTypeList;", "currentProvinceKey", "", "currentProvinceName", "preferencesAfterGraduation", "", "<init>", "(Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceList;Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoTypeList;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getProvinceList", "()Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoProvinceList;", "getTypeList", "()Lcom/larus/bmhome/view/actionbar/gaokao/network/GaokaoTypeList;", "getCurrentProvinceKey", "()Ljava/lang/String;", "getCurrentProvinceName", "getPreferencesAfterGraduation", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoProvinceConfResponse {

    @SerializedName("current_province_key")
    private final String currentProvinceKey;

    @SerializedName("current_province_name")
    private final String currentProvinceName;

    @SerializedName("preferences_after_graduation")
    private final List<String> preferencesAfterGraduation;

    @SerializedName("province_list")
    private final GaokaoProvinceList provinceList;

    @SerializedName("type_list")
    private final GaokaoTypeList typeList;

    public GaokaoProvinceConfResponse() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GaokaoProvinceConfResponse copy$default(GaokaoProvinceConfResponse r3, GaokaoProvinceList r4, GaokaoTypeList r5, String r6, String r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.provinceList;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.typeList;
    L8:
        GaokaoTypeList r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.currentProvinceKey;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.currentProvinceName;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.preferencesAfterGraduation;
    L17:
        GaokaoProvinceList r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final GaokaoProvinceList component1() {
        return this.provinceList;
    }

    public final GaokaoTypeList component2() {
        return this.typeList;
    }

    public final String component3() {
        return this.currentProvinceKey;
    }

    public final String component4() {
        return this.currentProvinceName;
    }

    public final List<String> component5() {
        return this.preferencesAfterGraduation;
    }

    public final GaokaoProvinceConfResponse copy(GaokaoProvinceList r8, GaokaoTypeList r9, String r10, String r11, List<String> r12) {
        return new GaokaoProvinceConfResponse(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GaokaoProvinceConfResponse) == true) goto L8;
        return false;
    L8:
        GaokaoProvinceConfResponse r6 = (GaokaoProvinceConfResponse) r5;
        if (Intrinsics.areEqual(this.provinceList, r6.provinceList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.typeList, r6.typeList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.currentProvinceKey, r6.currentProvinceKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.currentProvinceName, r6.currentProvinceName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.preferencesAfterGraduation, r6.preferencesAfterGraduation) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        GaokaoProvinceList r0 = this.provinceList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        GaokaoTypeList r4 = this.typeList;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.currentProvinceKey;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.currentProvinceName;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.preferencesAfterGraduation;
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
        return "GaokaoProvinceConfResponse(provinceList=" + this.provinceList + ", typeList=" + this.typeList + ", currentProvinceKey=" + this.currentProvinceKey + ", currentProvinceName=" + this.currentProvinceName + ", preferencesAfterGraduation=" + this.preferencesAfterGraduation + ')';
    }

    public final String getCurrentProvinceKey() {
        return this.currentProvinceKey;
    }

    public final String getCurrentProvinceName() {
        return this.currentProvinceName;
    }

    public final List<String> getPreferencesAfterGraduation() {
        return this.preferencesAfterGraduation;
    }

    public final GaokaoProvinceList getProvinceList() {
        return this.provinceList;
    }

    public final GaokaoTypeList getTypeList() {
        return this.typeList;
    }

    public GaokaoProvinceConfResponse(GaokaoProvinceList r1, GaokaoTypeList r2, String r3, String r4, List<String> r5) {
        this.provinceList = r1;
        this.typeList = r2;
        this.currentProvinceKey = r3;
        this.currentProvinceName = r4;
        this.preferencesAfterGraduation = r5;
    }

    public /* synthetic */ GaokaoProvinceConfResponse(GaokaoProvinceList r5, GaokaoTypeList r6, String r7, String r8, List r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        GaokaoProvinceList r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        GaokaoTypeList r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = null;
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
