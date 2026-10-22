package com.larus.bmhome.view.actionbar.gaokao.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006+"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/model/GaokaoProvince;", "Landroid/os/Parcelable;", "code", "", "key", "province", "max", "disableRank", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getKey", "setKey", "getProvince", "setProvince", "getMax", "setMax", "getDisableRank", "setDisableRank", "getTypeCode", "getMaxScore", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoProvince implements Parcelable {
    public static final Parcelable.Creator<GaokaoProvince> CREATOR = null;

    @SerializedName("code")
    private String code;

    @SerializedName("disable_rank")
    private String disableRank;

    @SerializedName("key")
    private String key;

    @SerializedName("max")
    private String max;

    @SerializedName("province")
    private String province;

    public static final class a implements Parcelable.Creator<GaokaoProvince> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GaokaoProvince createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            return new GaokaoProvince(r8.readString(), r8.readString(), r8.readString(), r8.readString(), r8.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final GaokaoProvince[] newArray(int r1) {
            return new GaokaoProvince[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public GaokaoProvince() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GaokaoProvince copy$default(GaokaoProvince r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.code;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.key;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.province;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.max;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.disableRank;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.key;
    }

    public final String component3() {
        return this.province;
    }

    public final String component4() {
        return this.max;
    }

    public final String component5() {
        return this.disableRank;
    }

    public final GaokaoProvince copy(String r8, String r9, String r10, String r11, String r12) {
        return new GaokaoProvince(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GaokaoProvince) == true) goto L8;
        return false;
    L8:
        GaokaoProvince r6 = (GaokaoProvince) r5;
        if (Intrinsics.areEqual(this.code, r6.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.province, r6.province) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.max, r6.max) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.disableRank, r6.disableRank) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.code;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.key;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.province;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.max;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.disableRank;
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
        return "GaokaoProvince(code=" + this.code + ", key=" + this.key + ", province=" + this.province + ", max=" + this.max + ", disableRank=" + this.disableRank + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.code);
        r1.writeString(this.key);
        r1.writeString(this.province);
        r1.writeString(this.max);
        r1.writeString(this.disableRank);
    }

    public final String getMaxScore() {
        String r0 = this.max;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getTypeCode() {
        String r0 = this.code;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDisableRank() {
        return this.disableRank;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMax() {
        return this.max;
    }

    public final String getProvince() {
        return this.province;
    }

    public final void setCode(String r1) {
        this.code = r1;
    }

    public final void setDisableRank(String r1) {
        this.disableRank = r1;
    }

    public final void setKey(String r1) {
        this.key = r1;
    }

    public final void setMax(String r1) {
        this.max = r1;
    }

    public final void setProvince(String r1) {
        this.province = r1;
    }

    public GaokaoProvince(String r1, String r2, String r3, String r4, String r5) {
        this.code = r1;
        this.key = r2;
        this.province = r3;
        this.max = r4;
        this.disableRank = r5;
    }

    public /* synthetic */ GaokaoProvince(String r4, String r5, String r6, String r7, String r8, int r9, DefaultConstructorMarker r10) {
        String r0 = "";
        if ((r9 & 1) == 0) goto L5;
        String r11 = "";
    L7:
        if ((r9 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r9 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r9 & 8) != 0) goto L19;
        r0 = r7;
    L19:
        if ((r9 & 16) == 0) goto L21;
        r8 = TriggerSendLoading.NO_LOADING;
    L21:
        String r12 = r8;
        this(r11, r1, r2, r0, r12);
        return;
    L13:
        r2 = r6;
        goto L15
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
