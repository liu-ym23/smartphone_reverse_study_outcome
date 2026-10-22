package com.larus.settings.provider.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/larus/settings/provider/creation/DescriptionConfig;", "Landroid/os/Parcelable;", "text", "", "alignment", "", "color", "Lcom/larus/settings/provider/creation/ColorConfig;", "<init>", "(Ljava/lang/String;ILcom/larus/settings/provider/creation/ColorConfig;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getText", "()Ljava/lang/String;", "getAlignment", "()I", "getColor", "()Lcom/larus/settings/provider/creation/ColorConfig;", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DescriptionConfig implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("alignment")
    private final int alignment;

    @SerializedName("color")
    private final ColorConfig color;

    @SerializedName("text")
    private final String text;

    public static final class a implements Parcelable.Creator<DescriptionConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DescriptionConfig createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new DescriptionConfig(r5.readString(), r5.readInt(), (ColorConfig) r5.readParcelable(ColorConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final DescriptionConfig[] newArray(int r1) {
            return new DescriptionConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public DescriptionConfig() {
        this(null, 0, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DescriptionConfig) == true) goto L8;
        return false;
    L8:
        DescriptionConfig r6 = (DescriptionConfig) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (this.alignment == r6.alignment) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.color, r6.color) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.alignment) * 31;
        ColorConfig r4 = this.color;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DescriptionConfig(text=" + this.text + ", alignment=" + this.alignment + ", color=" + this.color + ')';
    }

    public final int a() {
        return this.alignment;
    }

    public final ColorConfig b() {
        return this.color;
    }

    public final String c() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.text);
        r2.writeInt(this.alignment);
        r2.writeParcelable(this.color, r3);
    }

    public DescriptionConfig(String r1, @Alignment int r2, ColorConfig r3) {
        this.text = r1;
        this.alignment = r2;
        this.color = r3;
    }
}
