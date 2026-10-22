package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J;\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\b\u0010'\u001a\u00020\tH\u0016J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001J\u0018\u0010/\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u00063"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "startTime", "", "endTimeLong", CommonConsts.COUNT_TYPE, "", "leftTimeArrayIndex", "rightTimeArrayIndex", "(JJIII)V", "getCount", "()I", "setCount", "(I)V", "getEndTimeLong", "()J", "setEndTimeLong", "(J)V", "leftIndex", "getLeftIndex", "setLeftIndex", "getLeftTimeArrayIndex", "setLeftTimeArrayIndex", "rightIndex", "getRightIndex", "setRightIndex", "getRightTimeArrayIndex", "setRightTimeArrayIndex", "getStartTime", "setStartTime", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityCountTimeSlotData implements Parcelable {
    public static final a CREATOR = null;
    private int count;
    private long endTimeLong;
    private int leftIndex;
    private int leftTimeArrayIndex;
    private int rightIndex;
    private int rightTimeArrayIndex;
    private long startTime;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<EntityCountTimeSlotData> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public EntityCountTimeSlotData a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new EntityCountTimeSlotData(r1);
        }

        public EntityCountTimeSlotData[] a(int r1) {
            return new EntityCountTimeSlotData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityCountTimeSlotData createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityCountTimeSlotData[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public EntityCountTimeSlotData(long r1, long r3, int r5, int r6, int r7) {
        this.startTime = r1;
        this.endTimeLong = r3;
        this.count = r5;
        this.leftTimeArrayIndex = r6;
        this.rightTimeArrayIndex = r7;
        this.leftIndex = -1;
        this.rightIndex = -1;
    }

    public EntityCountTimeSlotData(Parcel r14) {
        Intrinsics.checkNotNullParameter(r14, "parcel");
        Class r0 = Long.TYPE;
        Object r1 = r14.readValue(r0.getClassLoader());
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Long");
        long r6 = ((Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.memorydata.plugin")).longValue();
        Object r2 = r14.readValue(r0.getClassLoader());
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Long");
        this(r6, ((Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin")).longValue(), r14.readInt(), r14.readInt(), r14.readInt());
        Class r3 = Integer.TYPE;
        Object r4 = r14.readValue(r3.getClassLoader());
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
        this.leftIndex = ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin")).intValue();
        Object r15 = r14.readValue(r3.getClassLoader());
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Int");
        this.rightIndex = ((Integer) ZeusTransformUtils.preCheckCast(r15, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    public static /* synthetic */ EntityCountTimeSlotData copy$default(EntityCountTimeSlotData r8, long r9, long r11, int r13, int r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.startTime;
    L7:
        if ((r16 & 2) == 0) goto L9;
        long r3 = r8.endTimeLong;
    L11:
        if ((r16 & 4) == 0) goto L13;
        int r5 = r8.count;
    L15:
        if ((r16 & 8) == 0) goto L17;
        int r6 = r8.leftTimeArrayIndex;
    L19:
        if ((r16 & 16) == 0) goto L21;
        int r7 = r8.rightTimeArrayIndex;
    L23:
        return r8.copy(r1, r3, r5, r6, r7);
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.startTime;
    }

    public final long component2() {
        return this.endTimeLong;
    }

    public final int component3() {
        return this.count;
    }

    public final int component4() {
        return this.leftTimeArrayIndex;
    }

    public final int component5() {
        return this.rightTimeArrayIndex;
    }

    public final EntityCountTimeSlotData copy(long r9, long r11, int r13, int r14, int r15) {
        return new EntityCountTimeSlotData(r9, r11, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, EntityCountTimeSlotData.class) == true) goto L8;
        return false;
    L8:
        EntityCountTimeSlotData r10 = (EntityCountTimeSlotData) ZeusTransformUtils.preCheckCast(r9, EntityCountTimeSlotData.class, "com.obric.memorydata.plugin");
        if (this.startTime == r10.startTime) goto L12;
        return false;
    L12:
        if (this.endTimeLong == r10.endTimeLong) goto L15;
        return false;
    L15:
        if (this.count == r10.count) goto L18;
        return false;
    L18:
        if (this.leftTimeArrayIndex == r10.leftTimeArrayIndex) goto L21;
        return false;
    L21:
        if (this.rightTimeArrayIndex == r10.rightTimeArrayIndex) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final long getEndTimeLong() {
        return this.endTimeLong;
    }

    public final int getLeftIndex() {
        return this.leftIndex;
    }

    public final int getLeftTimeArrayIndex() {
        return this.leftTimeArrayIndex;
    }

    public final int getRightIndex() {
        return this.rightIndex;
    }

    public final int getRightTimeArrayIndex() {
        return this.rightTimeArrayIndex;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.startTime) * 31) + Long.hashCode(this.endTimeLong)) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.leftTimeArrayIndex)) * 31) + Integer.hashCode(this.rightTimeArrayIndex);
    }

    public final void setCount(int r1) {
        this.count = r1;
    }

    public final void setEndTimeLong(long r1) {
        this.endTimeLong = r1;
    }

    public final void setLeftIndex(int r1) {
        this.leftIndex = r1;
    }

    public final void setLeftTimeArrayIndex(int r1) {
        this.leftTimeArrayIndex = r1;
    }

    public final void setRightIndex(int r1) {
        this.rightIndex = r1;
    }

    public final void setRightTimeArrayIndex(int r1) {
        this.rightTimeArrayIndex = r1;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public String toString() {
        return "EntityCountTimeSlotData(startTime=" + this.startTime + ", endTimeLong=" + this.endTimeLong + ", count=" + this.count + ", leftTimeArrayIndex=" + this.leftTimeArrayIndex + ", rightTimeArrayIndex=" + this.rightTimeArrayIndex + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeValue(Long.valueOf(this.startTime));
        r3.writeValue(Long.valueOf(this.endTimeLong));
        r3.writeInt(this.count);
        r3.writeInt(this.leftTimeArrayIndex);
        r3.writeInt(this.rightTimeArrayIndex);
        r3.writeValue(Integer.valueOf(this.leftIndex));
        r3.writeValue(Integer.valueOf(this.rightIndex));
    }
}
