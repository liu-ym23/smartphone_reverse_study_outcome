package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityHashData;", "Landroid/os/Parcelable;", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final class EntityHashData implements Parcelable {
    public static final a CREATOR = null;
    public final String a;
    public final int b;

    public static final class a implements Parcelable.Creator<EntityHashData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityHashData createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            Intrinsics.checkNotNullParameter(r3, "parcel");
            String r0 = r3.readString();
            if (r0 != null) goto L6;
            r0 = "";
        L6:
            return new EntityHashData(r0, r3.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final EntityHashData[] newArray(int r1) {
            return new EntityHashData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public EntityHashData(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a = r2;
        this.b = r3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.a);
        r1.writeInt(this.b);
    }
}
