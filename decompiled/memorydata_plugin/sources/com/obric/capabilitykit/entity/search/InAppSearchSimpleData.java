package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B3\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u000bH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "lastModifiedTime", "type", "", TrackerImpl.PARAMS, "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "(Ljava/lang/String;JJILjava/util/List;)V", "getCreateTime", "()J", "getId", "()Ljava/lang/String;", "getLastModifiedTime", "getParams", "()Ljava/util/List;", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchSimpleData implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "0";
    private final long createTime;
    private final String id;
    private final long lastModifiedTime;
    private final List<InAppSearchEntityParam> params;
    private final int type;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchSimpleData> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchSimpleData createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InAppSearchSimpleData(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchSimpleData createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchSimpleData[] newArray(int r1) {
            return new InAppSearchSimpleData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchSimpleData[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchSimpleData(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r2 = EntityExtKt.readStringOrEmpty(r10);
        long r3 = r10.readLong();
        long r5 = r10.readLong();
        int r7 = r10.readInt();
        ArrayList r8 = r10.createTypedArrayList(InAppSearchEntityParam.CREATOR);
        Intrinsics.checkNotNull(r8);
        this(r2, r3, r5, r7, r8);
        int r9 = r10.dataPosition();
        String r0 = r10.readString();
        int r1 = 0;
        int r4 = 1;
        if (r0 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        r10.setDataPosition(r9);
    L12:
        int r11 = Integer.parseInt("0");
        if (r1 > r11) goto L16;
        r11 = r1;
    L16:
        ClassLoader r12 = InAppSearchSimpleData.class.getClassLoader();
    L17:
        if (r4 > r11) goto L19;
        r4 = r4 + 1;
    L19:
        if (r4 > r1) goto L21;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r12);
        r4 = r4 + 1;
        goto L19
    L21:
        return;
    L11:
        r1 = Integer.parseInt(r0);
        goto L12
    L5:
        if (r0.length() == 0) goto L8;
        r6 = false;
        goto L9
    }

    public InAppSearchSimpleData(String r3, long r4, long r6, int r8, List<InAppSearchEntityParam> r9) {
        List<InAppSearchEntityParam> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r10, TrackerImpl.PARAMS);
        this.id = r3;
        this.createTime = r4;
        this.lastModifiedTime = r6;
        this.type = r8;
        this.params = r10;
    }

    public static /* synthetic */ InAppSearchSimpleData copy$default(InAppSearchSimpleData r9, String r10, long r11, long r13, int r15, List r16, int r17, Object r18) {
        List<InAppSearchEntityParam> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        if ((r17 & 1) == 0) goto L5;
        String r2 = r9.id;
    L7:
        if ((r17 & 2) == 0) goto L9;
        long r3 = r9.createTime;
    L11:
        if ((r17 & 4) == 0) goto L13;
        long r5 = r9.lastModifiedTime;
    L15:
        if ((r17 & 8) == 0) goto L17;
        int r7 = r9.type;
    L19:
        if ((r17 & 16) == 0) goto L22;
        r1 = r9.params;
    L22:
        return r9.copy(r2, r3, r5, r7, r1);
    L17:
        r7 = r15;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final long component2() {
        return this.createTime;
    }

    public final long component3() {
        return this.lastModifiedTime;
    }

    public final int component4() {
        return this.type;
    }

    public final List<InAppSearchEntityParam> component5() {
        return this.params;
    }

    public final InAppSearchSimpleData copy(String r9, long r10, long r12, int r14, List<InAppSearchEntityParam> r15) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r7, TrackerImpl.PARAMS);
        return new InAppSearchSimpleData(r9, r10, r12, r14, r7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, InAppSearchSimpleData.class) == true) goto L8;
        return false;
    L8:
        InAppSearchSimpleData r10 = (InAppSearchSimpleData) ZeusTransformUtils.preCheckCast(r9, InAppSearchSimpleData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.id, r10.id) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r10.createTime) goto L15;
        return false;
    L15:
        if (this.lastModifiedTime == r10.lastModifiedTime) goto L18;
        return false;
    L18:
        if (this.type == r10.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.params, r10.params) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final List<InAppSearchEntityParam> getParams() {
        return this.params;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.lastModifiedTime)) * 31) + Integer.hashCode(this.type)) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "InAppSearchSimpleData(id=" + this.id + ", createTime=" + this.createTime + ", lastModifiedTime=" + this.lastModifiedTime + ", type=" + this.type + ", params=" + this.params + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.id);
        r3.writeLong(this.createTime);
        r3.writeLong(this.lastModifiedTime);
        r3.writeInt(this.type);
        r3.writeTypedList(this.params);
        r3.writeString("0");
    }
}
