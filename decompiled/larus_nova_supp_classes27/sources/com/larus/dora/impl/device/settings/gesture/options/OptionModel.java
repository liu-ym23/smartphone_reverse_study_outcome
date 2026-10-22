package com.larus.dora.impl.device.settings.gesture.options;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.dora.impl.model.GestureSettingsKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/options/OptionModel;", "Landroid/os/Parcelable;", "title", "", "subTitle", "key", "Lcom/larus/dora/impl/model/GestureSettingsKey;", "value", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/dora/impl/model/GestureSettingsKey;B)V", "getTitle", "()Ljava/lang/String;", "getSubTitle", "getKey", "()Lcom/larus/dora/impl/model/GestureSettingsKey;", "getValue", "()B", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionModel implements Parcelable {
    public static final Parcelable.Creator<OptionModel> CREATOR = null;
    public final String a;
    public final String b;
    public final GestureSettingsKey c;
    public final byte d;

    public static final class a implements Parcelable.Creator<OptionModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OptionModel createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new OptionModel(r5.readString(), r5.readString(), GestureSettingsKey.valueOf(r5.readString()), r5.readByte());
        }

        @Override // android.os.Parcelable.Creator
        public final OptionModel[] newArray(int r1) {
            return new OptionModel[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OptionModel) == true) goto L8;
        return false;
    L8:
        OptionModel r6 = (OptionModel) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d;
    }

    public final String toString() {
        return "OptionModel(title=" + this.a + ", subTitle=" + this.b + ", key=" + this.c + ", value=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c.name());
        r1.writeByte(this.d);
    }

    public /* synthetic */ OptionModel(String r2, GestureSettingsKey r3, byte r4) {
        this(r2, "", r3, r4);
    }

    public OptionModel(String r2, String r3, GestureSettingsKey r4, byte r5) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "subTitle");
        Intrinsics.checkNotNullParameter(r4, "key");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
