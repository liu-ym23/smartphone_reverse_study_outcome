package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCheckHashCodeSlotData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "startTime", "", "endTime", "hashCodeData", "", "Lcom/obric/capabilitykit/sync/EntityHashData;", "(JJLjava/util/List;)V", "getEndTime", "()J", "getHashCodeData", "()Ljava/util/List;", "getStartTime", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityCheckHashCodeSlotData implements Parcelable {
    public static final a CREATOR = null;
    private final long endTime;
    private final List<EntityHashData> hashCodeData;
    private final long startTime;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityCheckHashCodeSlotData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/sync/EntityCheckHashCodeSlotData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/sync/EntityCheckHashCodeSlotData;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<EntityCheckHashCodeSlotData> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public EntityCheckHashCodeSlotData a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new EntityCheckHashCodeSlotData(r1);
        }

        public EntityCheckHashCodeSlotData[] a(int r1) {
            return new EntityCheckHashCodeSlotData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityCheckHashCodeSlotData createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityCheckHashCodeSlotData[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public EntityCheckHashCodeSlotData(long r3, long r5, List<EntityHashData> r7) {
        List<EntityHashData> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "hashCodeData");
        this.startTime = r3;
        this.endTime = r5;
        this.hashCodeData = r8;
    }

    public EntityCheckHashCodeSlotData(Parcel r8) {
        Intrinsics.checkNotNullParameter(r8, "parcel");
        long r2 = r8.readLong();
        long r4 = r8.readLong();
        List r9 = r8.createTypedArrayList(EntityHashData.CREATOR);
        if (r9 != null) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        this(r2, r4, r9);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final List<EntityHashData> getHashCodeData() {
        return this.hashCodeData;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeLong(this.startTime);
        r3.writeLong(this.endTime);
        r3.writeTypedList(this.hashCodeData);
    }
}
