package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "Landroid/os/Parcelable;", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final class EntityCountTimeSlotData implements Parcelable {
    public static final a CREATOR = null;
    public final long a;
    public final long b;
    public final int c;
    public final int d;
    public final int e;
    public int f;
    public int g;

    public static final class a implements Parcelable.Creator<EntityCountTimeSlotData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityCountTimeSlotData createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            Intrinsics.checkNotNullParameter(r11, "parcel");
            Class r0 = Long.TYPE;
            Object r1 = r11.readValue(r0.getClassLoader());
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Long");
            long r3 = ((Long) r1).longValue();
            Object r2 = r11.readValue(r0.getClassLoader());
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Long");
            EntityCountTimeSlotData r9 = new EntityCountTimeSlotData(r3, ((Long) r2).longValue(), r11.readInt(), r11.readInt(), r11.readInt());
            Class r4 = Integer.TYPE;
            Object r5 = r11.readValue(r4.getClassLoader());
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
            r9.f = ((Integer) r5).intValue();
            Object r12 = r11.readValue(r4.getClassLoader());
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Int");
            r9.g = ((Integer) r12).intValue();
            return r9;
        }

        @Override // android.os.Parcelable.Creator
        public final EntityCountTimeSlotData[] newArray(int r1) {
            return new EntityCountTimeSlotData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public EntityCountTimeSlotData(long r1, long r3, int r5, int r6, int r7) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = -1;
        this.g = -1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof EntityCountTimeSlotData) == true) goto L8;
        return false;
    L8:
        EntityCountTimeSlotData r9 = (EntityCountTimeSlotData) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        return ((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        return "EntityCountTimeSlotData(startTime=" + this.a + ", endTimeLong=" + this.b + ", count=" + this.c + ", leftTimeArrayIndex=" + this.d + ", rightTimeArrayIndex=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeValue(Long.valueOf(this.a));
        r3.writeValue(Long.valueOf(this.b));
        r3.writeInt(this.c);
        r3.writeInt(this.d);
        r3.writeInt(this.e);
        r3.writeValue(Integer.valueOf(this.f));
        r3.writeValue(Integer.valueOf(this.g));
    }
}
