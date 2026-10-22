package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityHashData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "hashCodeValue", "", "(Ljava/lang/String;I)V", "getHashCodeValue", "()I", "getId", "()Ljava/lang/String;", "describeContents", "writeToParcel", "", "flags", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityHashData implements Parcelable {
    public static final a CREATOR = null;
    private final int hashCodeValue;
    private final String id;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityHashData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/sync/EntityHashData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/sync/EntityHashData;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<EntityHashData> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public EntityHashData a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new EntityHashData(r1);
        }

        public EntityHashData[] a(int r1) {
            return new EntityHashData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityHashData createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ EntityHashData[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public EntityHashData(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        String r0 = r2.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this(r0, r2.readInt());
    }

    public EntityHashData(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        this.id = r2;
        this.hashCodeValue = r3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.id);
        r1.writeInt(this.hashCodeValue);
    }
}
