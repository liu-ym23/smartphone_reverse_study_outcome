package com.larus.bmhome.view.actionbar.gaokao.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006HÆ\u0003J\u001b\u0010#\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00062\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010&\u001a\u00020'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020'HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020'R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R(\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R0\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u00063"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/model/GaokaoType;", "Landroid/os/Parcelable;", "code", "", "name", "selectedMajor", "", "reselectedMajor", "selectedMajorRankTypeMap", "", "defaultRankType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getName", "setName", "getSelectedMajor", "()Ljava/util/List;", "setSelectedMajor", "(Ljava/util/List;)V", "getReselectedMajor", "setReselectedMajor", "getSelectedMajorRankTypeMap", "()Ljava/util/Map;", "setSelectedMajorRankTypeMap", "(Ljava/util/Map;)V", "getDefaultRankType", "setDefaultRankType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoType implements Parcelable {
    public static final Parcelable.Creator<GaokaoType> CREATOR = null;

    @SerializedName("code")
    private String code;

    @SerializedName("default_rank_type")
    private String defaultRankType;

    @SerializedName("name")
    private String name;

    @SerializedName("reselected_major")
    private List<String> reselectedMajor;

    @SerializedName("selected_major")
    private List<String> selectedMajor;

    @SerializedName("selected_major_rank_type_map")
    private Map<String, String> selectedMajorRankTypeMap;

    public static final class a implements Parcelable.Creator<GaokaoType> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GaokaoType createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r2 = r10.readString();
            String r3 = r10.readString();
            ArrayList<String> r4 = r10.createStringArrayList();
            ArrayList<String> r5 = r10.createStringArrayList();
            if (r10.readInt() != 0) goto L5;
            LinkedHashMap r6 = null;
        L10:
            return new GaokaoType(r2, r3, r4, r5, r6, r10.readString());
        L5:
            int r0 = r10.readInt();
            LinkedHashMap r1 = new LinkedHashMap(r0);
            int r7 = 0;
        L6:
            if (r7 == r0) goto L8;
            r1.put(r10.readString(), r10.readString());
            r7 = r7 + 1;
            goto L6
        L8:
            r6 = r1;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final GaokaoType[] newArray(int r1) {
            return new GaokaoType[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public GaokaoType() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GaokaoType copy$default(GaokaoType r4, String r5, String r6, List r7, List r8, Map r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.code;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.name;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.selectedMajor;
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.reselectedMajor;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.selectedMajorRankTypeMap;
    L17:
        Map r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.defaultRankType;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.name;
    }

    public final List<String> component3() {
        return this.selectedMajor;
    }

    public final List<String> component4() {
        return this.reselectedMajor;
    }

    public final Map<String, String> component5() {
        return this.selectedMajorRankTypeMap;
    }

    public final String component6() {
        return this.defaultRankType;
    }

    public final GaokaoType copy(String r9, String r10, List<String> r11, List<String> r12, Map<String, String> r13, String r14) {
        return new GaokaoType(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GaokaoType) == true) goto L8;
        return false;
    L8:
        GaokaoType r6 = (GaokaoType) r5;
        if (Intrinsics.areEqual(this.code, r6.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selectedMajor, r6.selectedMajor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reselectedMajor, r6.reselectedMajor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.selectedMajorRankTypeMap, r6.selectedMajorRankTypeMap) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.defaultRankType, r6.defaultRankType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.code;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.selectedMajor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.reselectedMajor;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.selectedMajorRankTypeMap;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.defaultRankType;
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
        return "GaokaoType(code=" + this.code + ", name=" + this.name + ", selectedMajor=" + this.selectedMajor + ", reselectedMajor=" + this.reselectedMajor + ", selectedMajorRankTypeMap=" + this.selectedMajorRankTypeMap + ", defaultRankType=" + this.defaultRankType + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.code);
        r3.writeString(this.name);
        r3.writeStringList(this.selectedMajor);
        r3.writeStringList(this.reselectedMajor);
        Map<String, String> r5 = this.selectedMajorRankTypeMap;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L9:
        r3.writeString(this.defaultRankType);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.size());
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<String, String> r0 = r6.next();
        r3.writeString(r0.getKey());
        r3.writeString(r0.getValue());
        goto L7
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDefaultRankType() {
        return this.defaultRankType;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getReselectedMajor() {
        return this.reselectedMajor;
    }

    public final List<String> getSelectedMajor() {
        return this.selectedMajor;
    }

    public final Map<String, String> getSelectedMajorRankTypeMap() {
        return this.selectedMajorRankTypeMap;
    }

    public final void setCode(String r1) {
        this.code = r1;
    }

    public final void setDefaultRankType(String r1) {
        this.defaultRankType = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setReselectedMajor(List<String> r1) {
        this.reselectedMajor = r1;
    }

    public final void setSelectedMajor(List<String> r1) {
        this.selectedMajor = r1;
    }

    public final void setSelectedMajorRankTypeMap(Map<String, String> r1) {
        this.selectedMajorRankTypeMap = r1;
    }

    public GaokaoType(String r1, String r2, List<String> r3, List<String> r4, Map<String, String> r5, String r6) {
        this.code = r1;
        this.name = r2;
        this.selectedMajor = r3;
        this.reselectedMajor = r4;
        this.selectedMajorRankTypeMap = r5;
        this.defaultRankType = r6;
    }

    public /* synthetic */ GaokaoType(String r6, String r7, List r8, List r9, Map r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = "";
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r12 & 4) == 0) goto L13;
        r8 = new ArrayList();
    L13:
        List r2 = r8;
        if ((r12 & 8) == 0) goto L16;
        r9 = new ArrayList();
    L16:
        List r3 = r9;
        if ((r12 & 16) == 0) goto L19;
        r10 = MapsKt.emptyMap();
    L19:
        Map r4 = r10;
        if ((r12 & 32) == 0) goto L22;
        String r15 = "";
    L23:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L22:
        r15 = r11;
        goto L23
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
