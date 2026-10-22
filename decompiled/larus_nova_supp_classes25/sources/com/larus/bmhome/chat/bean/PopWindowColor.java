package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowColor;", "Landroid/os/Parcelable;", "colorLight", "", "colorDark", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getColorLight", "()Ljava/lang/String;", "getColorDark", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PopWindowColor implements Parcelable {
    public static final Parcelable.Creator<PopWindowColor> CREATOR = null;

    @SerializedName("color_dark")
    private final String colorDark;

    @SerializedName("color_light")
    private final String colorLight;

    public static final class a implements Parcelable.Creator<PopWindowColor> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowColor createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new PopWindowColor(r3.readString(), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowColor[] newArray(int r1) {
            return new PopWindowColor[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowColor() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ PopWindowColor copy$default(PopWindowColor r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.colorLight;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.colorDark;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.colorLight;
    }

    public final String component2() {
        return this.colorDark;
    }

    public final PopWindowColor copy(String r2, String r3) {
        return new PopWindowColor(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PopWindowColor) == true) goto L8;
        return false;
    L8:
        PopWindowColor r6 = (PopWindowColor) r5;
        if (Intrinsics.areEqual(this.colorLight, r6.colorLight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.colorDark, r6.colorDark) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.colorLight;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.colorDark;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PopWindowColor(colorLight=" + this.colorLight + ", colorDark=" + this.colorDark + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.colorLight);
        r1.writeString(this.colorDark);
    }

    public final String getColorDark() {
        return this.colorDark;
    }

    public final String getColorLight() {
        return this.colorLight;
    }

    public PopWindowColor(String r1, String r2) {
        this.colorLight = r1;
        this.colorDark = r2;
    }

    public /* synthetic */ PopWindowColor(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
