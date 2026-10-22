package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0007J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006("}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/FeatureConfigBean;", "Landroid/os/Parcelable;", "enabled", NameKeys.UnloadStrategy_No_Strategy, "minRomVersion", NameKeys.UnloadStrategy_No_Strategy, "minRomReleaseDate", NameKeys.UnloadStrategy_No_Strategy, "maxRomVersion", "maxRomReleaseDate", "productNameList", "<init>", "(ZLjava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getEnabled", "()Z", "getMinRomVersion", "()Ljava/lang/String;", "getMinRomReleaseDate", "()I", "getMaxRomVersion", "getMaxRomReleaseDate", "getProductNameList", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureConfigBean implements Parcelable {
    public static final Parcelable.Creator<FeatureConfigBean> CREATOR = null;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("max_rom_release_date")
    private final int maxRomReleaseDate;

    @SerializedName("max_rom_version")
    private final String maxRomVersion;

    @SerializedName("min_rom_release_date")
    private final int minRomReleaseDate;

    @SerializedName("min_rom_version")
    private final String minRomVersion;

    @SerializedName("product_name_list")
    private final String productNameList;

    public static final class a implements Parcelable.Creator<FeatureConfigBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfigBean createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            if (r9.readInt() == 0) goto L5;
            boolean r2 = true;
        L7:
            return new FeatureConfigBean(r2, r9.readString(), r9.readInt(), r9.readString(), r9.readInt(), r9.readString());
        L5:
            r2 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfigBean[] newArray(int r1) {
            return new FeatureConfigBean[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeatureConfigBean() {
        this(false, null, 0, null, 0, null, 63, null);
    }

    public static /* synthetic */ FeatureConfigBean copy$default(FeatureConfigBean r4, boolean r5, String r6, int r7, String r8, int r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.enabled;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.minRomVersion;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.minRomReleaseDate;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.maxRomVersion;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.maxRomReleaseDate;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.productNameList;
    L20:
        boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.minRomVersion;
    }

    public final int component3() {
        return this.minRomReleaseDate;
    }

    public final String component4() {
        return this.maxRomVersion;
    }

    public final int component5() {
        return this.maxRomReleaseDate;
    }

    public final String component6() {
        return this.productNameList;
    }

    public final FeatureConfigBean copy(boolean r9, String r10, int r11, String r12, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "minRomVersion");
        Intrinsics.checkNotNullParameter(r12, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r14, "productNameList");
        return new FeatureConfigBean(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeatureConfigBean) == true) goto L8;
        return false;
    L8:
        FeatureConfigBean r6 = (FeatureConfigBean) r5;
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minRomVersion, r6.minRomVersion) == true) goto L15;
        return false;
    L15:
        if (this.minRomReleaseDate == r6.minRomReleaseDate) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxRomVersion, r6.maxRomVersion) == true) goto L21;
        return false;
    L21:
        if (this.maxRomReleaseDate == r6.maxRomReleaseDate) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.productNameList, r6.productNameList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        if (this.enabled == false) goto L5;
        int r0 = 1231;
    L7:
        return (((((((((r0 * 31) + this.minRomVersion.hashCode()) * 31) + this.minRomReleaseDate) * 31) + this.maxRomVersion.hashCode()) * 31) + this.maxRomReleaseDate) * 31) + this.productNameList.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public String toString() {
        return "FeatureConfigBean(enabled=" + this.enabled + ", minRomVersion=" + this.minRomVersion + ", minRomReleaseDate=" + this.minRomReleaseDate + ", maxRomVersion=" + this.maxRomVersion + ", maxRomReleaseDate=" + this.maxRomReleaseDate + ", productNameList=" + this.productNameList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.enabled ? 1 : 0);
        r1.writeString(this.minRomVersion);
        r1.writeInt(this.minRomReleaseDate);
        r1.writeString(this.maxRomVersion);
        r1.writeInt(this.maxRomReleaseDate);
        r1.writeString(this.productNameList);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getMaxRomReleaseDate() {
        return this.maxRomReleaseDate;
    }

    public final String getMaxRomVersion() {
        return this.maxRomVersion;
    }

    public final int getMinRomReleaseDate() {
        return this.minRomReleaseDate;
    }

    public final String getMinRomVersion() {
        return this.minRomVersion;
    }

    public final String getProductNameList() {
        return this.productNameList;
    }

    public FeatureConfigBean(boolean r2, String r3, int r4, String r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "minRomVersion");
        Intrinsics.checkNotNullParameter(r5, "maxRomVersion");
        Intrinsics.checkNotNullParameter(r7, "productNameList");
        this.enabled = r2;
        this.minRomVersion = r3;
        this.minRomReleaseDate = r4;
        this.maxRomVersion = r5;
        this.maxRomReleaseDate = r6;
        this.productNameList = r7;
    }

    public /* synthetic */ FeatureConfigBean(boolean r5, String r6, int r7, String r8, int r9, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = true;
    L5:
        int r13 = r11 & 2;
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        if (r13 == 0) goto L8;
        String r14 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        int r1 = 0;
        if ((r11 & 4) == 0) goto L12;
        int r2 = 0;
    L14:
        if ((r11 & 8) == 0) goto L16;
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        if ((r11 & 16) != 0) goto L22;
        r1 = r9;
    L22:
        if ((r11 & 32) != 0) goto L25;
        r0 = r10;
    L25:
        this(r5, r14, r2, r3, r1, r0);
        return;
    L16:
        r3 = r8;
        goto L18
    L12:
        r2 = r7;
        goto L14
    L8:
        r14 = r6;
        goto L9
    }
}
