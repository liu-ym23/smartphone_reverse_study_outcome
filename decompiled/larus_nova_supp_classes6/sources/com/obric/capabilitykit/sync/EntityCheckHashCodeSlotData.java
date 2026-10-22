package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCheckHashCodeSlotData;", "Landroid/os/Parcelable;", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final class EntityCheckHashCodeSlotData implements Parcelable {
    public static final a CREATOR = null;
    public final long a;
    public final long b;
    public final List<EntityHashData> c;

    public static final class a implements Parcelable.Creator<EntityCheckHashCodeSlotData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityCheckHashCodeSlotData createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            Intrinsics.checkNotNullParameter(r9, "parcel");
            long r2 = r9.readLong();
            long r4 = r9.readLong();
            List r10 = r9.createTypedArrayList(EntityHashData.CREATOR);
            if (r10 != null) goto L6;
            r10 = CollectionsKt.emptyList();
        L6:
            return new EntityCheckHashCodeSlotData(r2, r4, r10);
        }

        @Override // android.os.Parcelable.Creator
        public final EntityCheckHashCodeSlotData[] newArray(int r1) {
            return new EntityCheckHashCodeSlotData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public EntityCheckHashCodeSlotData(long r2, long r4, List<EntityHashData> r6) {
        Intrinsics.checkNotNullParameter(r6, "hashCodeData");
        this.a = r2;
        this.b = r4;
        this.c = r6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeLong(this.a);
        r3.writeLong(this.b);
        r3.writeTypedList(this.c);
    }
}
