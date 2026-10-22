package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.MicroAppLabel")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/MicroAppLabel;", "Landroid/os/Parcelable;", "", "name", "Ljava/lang/String;", "", "fontSize", "I", "fontColor", "backgroundBeginColor", "backgroundEndColor", "url", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MicroAppLabel implements Parcelable, h {
    public static final Parcelable.Creator<MicroAppLabel> CREATOR = null;

    @SerializedName("background_begin_color")
    public String backgroundBeginColor;

    @SerializedName("background_end_color")
    public String backgroundEndColor;

    @SerializedName("font_color")
    public String fontColor;

    @SerializedName("font_size")
    public int fontSize;

    @SerializedName("name")
    public String name;

    @SerializedName("url")
    public String url;

    public static class a implements Parcelable.Creator<MicroAppLabel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MicroAppLabel createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "in");
            return new MicroAppLabel(r9.readString(), r9.readInt(), r9.readString(), r9.readString(), r9.readString(), r9.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final MicroAppLabel[] newArray(int r1) {
            return new MicroAppLabel[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public MicroAppLabel(String r1, int r2, String r3, String r4, String r5, String r6) {
        this.name = r1;
        this.fontSize = r2;
        this.fontColor = r3;
        this.backgroundBeginColor = r4;
        this.backgroundEndColor = r5;
        this.url = r6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MicroAppLabel) == false) goto L18;
        MicroAppLabel r4 = (MicroAppLabel) r3;
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L8;
        return false;
    L8:
        if (this.fontSize == r4.fontSize) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fontColor, r4.fontColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.backgroundBeginColor, r4.backgroundBeginColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.backgroundEndColor, r4.backgroundEndColor) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.fontSize) * 31;
        String r4 = this.fontColor;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.backgroundBeginColor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.backgroundEndColor;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.url;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MicroAppLabel(name=" + this.name + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", backgroundBeginColor=" + this.backgroundBeginColor + ", backgroundEndColor=" + this.backgroundEndColor + ", url=" + this.url + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.name);
        r1.writeInt(this.fontSize);
        r1.writeString(this.fontColor);
        r1.writeString(this.backgroundBeginColor);
        r1.writeString(this.backgroundEndColor);
        r1.writeString(this.url);
    }

    public MicroAppLabel() {
        this.name = null;
        this.fontSize = 0;
        this.fontColor = null;
        this.backgroundBeginColor = null;
        this.backgroundEndColor = null;
        this.url = null;
    }

    public MicroAppLabel(am3.g r7) {
        long r0 = r7.c();
        boolean r3 = false;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L13;
        switch(r4) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.url = am3.h.c(r7);
        goto L3
    L8:
        this.backgroundEndColor = am3.h.c(r7);
        goto L3
    L9:
        this.backgroundBeginColor = am3.h.c(r7);
        goto L3
    L10:
        this.fontColor = am3.h.c(r7);
        goto L3
    L11:
        this.fontSize = r7.i();
        r3 = r3 | true;
        goto L3
    L12:
        this.name = am3.h.c(r7);
        goto L3
    L6:
        am3.h.e(r7);
        goto L3
    L13:
        r7.d(r0);
        if (this.name != null) goto L17;
        this.name = null;
    L17:
        if ((r3 & true) == true) goto L20;
        this.fontSize = 0;
    L20:
        if (this.fontColor != null) goto L23;
        this.fontColor = null;
    L23:
        if (this.backgroundBeginColor != null) goto L26;
        this.backgroundBeginColor = null;
    L26:
        if (this.backgroundEndColor != null) goto L29;
        this.backgroundEndColor = null;
    L29:
        if (this.url != null) goto L48;
        this.url = null;
        return;
    }
}
