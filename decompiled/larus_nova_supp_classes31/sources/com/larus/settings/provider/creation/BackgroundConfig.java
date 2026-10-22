package com.larus.settings.provider.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/creation/BackgroundConfig;", "Landroid/os/Parcelable;", "color", "Lcom/larus/settings/provider/creation/ColorConfig;", "<init>", "(Lcom/larus/settings/provider/creation/ColorConfig;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getColor", "()Lcom/larus/settings/provider/creation/ColorConfig;", "writeToParcel", "", "flags", "", "describeContents", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BackgroundConfig implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("color")
    private final ColorConfig color;

    public static final class a implements Parcelable.Creator<BackgroundConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BackgroundConfig createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new BackgroundConfig((ColorConfig) r3.readParcelable(ColorConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final BackgroundConfig[] newArray(int r1) {
            return new BackgroundConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BackgroundConfig() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof BackgroundConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.color, ((BackgroundConfig) r4).color) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        ColorConfig r0 = this.color;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "BackgroundConfig(color=" + this.color + ')';
    }

    public final ColorConfig a() {
        return this.color;
    }

    public BackgroundConfig(ColorConfig r1) {
        this.color = r1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeParcelable(this.color, r3);
    }
}
