package com.larus.settings.provider.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006!"}, d2 = {"Lcom/larus/settings/provider/creation/ButtonConfig;", "Landroid/os/Parcelable;", "text", "", "backgroundColor", "Lcom/larus/settings/provider/creation/ColorConfig;", "textColor", "<init>", "(Ljava/lang/String;Lcom/larus/settings/provider/creation/ColorConfig;Lcom/larus/settings/provider/creation/ColorConfig;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getText", "()Ljava/lang/String;", "getBackgroundColor", "()Lcom/larus/settings/provider/creation/ColorConfig;", "getTextColor", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ButtonConfig implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("background_color")
    private final ColorConfig backgroundColor;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final ColorConfig textColor;

    public static final class a implements Parcelable.Creator<ButtonConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ButtonConfig createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new ButtonConfig(r5.readString(), (ColorConfig) r5.readParcelable(ColorConfig.class.getClassLoader()), (ColorConfig) r5.readParcelable(ColorConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final ButtonConfig[] newArray(int r1) {
            return new ButtonConfig[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ButtonConfig() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ButtonConfig) == true) goto L8;
        return false;
    L8:
        ButtonConfig r6 = (ButtonConfig) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L17;
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
        int r3 = r2 * 31;
        ColorConfig r4 = this.backgroundColor;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ColorConfig r7 = this.textColor;
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

    public final String toString() {
        return "ButtonConfig(text=" + this.text + ", backgroundColor=" + this.backgroundColor + ", textColor=" + this.textColor + ')';
    }

    public final ColorConfig a() {
        return this.backgroundColor;
    }

    public final String b() {
        return this.text;
    }

    public final ColorConfig c() {
        return this.textColor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.text);
        r2.writeParcelable(this.backgroundColor, r3);
        r2.writeParcelable(this.textColor, r3);
    }

    public ButtonConfig(String r1, ColorConfig r2, ColorConfig r3) {
        this.text = r1;
        this.backgroundColor = r2;
        this.textColor = r3;
    }
}
