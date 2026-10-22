package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0003J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/larus/platform/api/creation/CustomInputInitData;", "Landroid/os/Parcelable;", "startPosition", "", "endPosition", "initText", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getStartPosition", "()Ljava/lang/Integer;", "setStartPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEndPosition", "setEndPosition", "getInitText", "()Ljava/lang/String;", "setInitText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/platform/api/creation/CustomInputInitData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CustomInputInitData implements Parcelable {
    public static final Parcelable.Creator<CustomInputInitData> CREATOR = null;

    @SerializedName("replace_end_position")
    private Integer endPosition;

    @SerializedName("replace_init_text")
    private String initText;

    @SerializedName("replace_start_position")
    private Integer startPosition;

    public static final class a implements Parcelable.Creator<CustomInputInitData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CustomInputInitData createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Integer r2 = null;
            if (r5.readInt() != 0) goto L5;
            Integer r1 = null;
        L7:
            if (r5.readInt() == 0) goto L11;
            r2 = Integer.valueOf(r5.readInt());
        L11:
            return new CustomInputInitData(r1, r2, r5.readString());
        L5:
            r1 = Integer.valueOf(r5.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CustomInputInitData[] newArray(int r1) {
            return new CustomInputInitData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CustomInputInitData() {
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
        if ((r5 instanceof CustomInputInitData) == true) goto L8;
        return false;
    L8:
        CustomInputInitData r6 = (CustomInputInitData) r5;
        if (Intrinsics.areEqual(this.startPosition, r6.startPosition) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endPosition, r6.endPosition) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.initText, r6.initText) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.startPosition;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.endPosition;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.initText;
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
        return "CustomInputInitData(startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + ", initText=" + this.initText + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        Integer r5 = this.startPosition;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.endPosition;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.initText);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    public final Integer a() {
        return this.endPosition;
    }

    public final String b() {
        return this.initText;
    }

    public final Integer c() {
        return this.startPosition;
    }

    public CustomInputInitData(Integer r1, Integer r2, String r3) {
        this.startPosition = r1;
        this.endPosition = r2;
        this.initText = r3;
    }
}
