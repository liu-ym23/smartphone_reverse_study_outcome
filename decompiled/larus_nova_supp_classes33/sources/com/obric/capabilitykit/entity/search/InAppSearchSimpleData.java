package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B3\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u000bH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "lastModifiedTime", "type", "", "params", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "(Ljava/lang/String;JJILjava/util/List;)V", "getCreateTime", "()J", "getId", "()Ljava/lang/String;", "getLastModifiedTime", "getParams", "()Ljava/util/List;", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        public InAppSearchSimpleData createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new InAppSearchSimpleData(r2);
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
        String r2 = EntityExtKt.e(r10);
        long r3 = r10.readLong();
        long r5 = r10.readLong();
        int r7 = r10.readInt();
        ArrayList r8 = r10.createTypedArrayList(InAppSearchEntityParam.CREATOR);
        Intrinsics.checkNotNull(r8);
        this(r2, r3, r5, r7, r8);
        int r0 = r10.dataPosition();
        String r1 = r10.readString();
        int r4 = 1;
        int r6 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == false) goto L11;
        r10.setDataPosition(r0);
    L12:
        int r11 = CastIntegerProtector.parseInt(VERSION);
        if (r6 > r11) goto L16;
        r11 = r6;
    L16:
        ClassLoader r12 = InAppSearchSimpleData.class.getClassLoader();
    L17:
        if (r4 > r11) goto L19;
        r4 = r4 + 1;
    L19:
        if (r4 > r6) goto L21;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r12);
        r4 = r4 + 1;
        goto L19
    L21:
        return;
    L11:
        r6 = CastIntegerProtector.parseInt(r1);
        goto L12
    L5:
        if (r1.length() == 0) goto L8;
        r9 = false;
        goto L9
    }

    public InAppSearchSimpleData(String r2, long r3, long r5, int r7, List<InAppSearchEntityParam> r8) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r8, "params");
        this.id = r2;
        this.createTime = r3;
        this.lastModifiedTime = r5;
        this.type = r7;
        this.params = r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InAppSearchSimpleData copy$default(InAppSearchSimpleData r5, String r6, long r7, long r9, int r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.id;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.createTime;
    L8:
        long r0 = r7;
        if ((r13 & 4) == 0) goto L11;
        r9 = r5.lastModifiedTime;
    L11:
        long r2 = r9;
        if ((r13 & 8) == 0) goto L14;
        r11 = r5.type;
    L14:
        int r15 = r11;
        if ((r13 & 16) == 0) goto L17;
        r12 = r5.params;
    L17:
        String r8 = r6;
        return r5.copy(r8, r0, r2, r15, r12);
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

    public final InAppSearchSimpleData copy(String r10, long r11, long r13, int r15, List<InAppSearchEntityParam> r16) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r16, "params");
        return new InAppSearchSimpleData(r10, r11, r13, r15, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof InAppSearchSimpleData) == true) goto L8;
        return false;
    L8:
        InAppSearchSimpleData r9 = (InAppSearchSimpleData) r8;
        if (Intrinsics.areEqual(this.id, r9.id) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r9.createTime) goto L15;
        return false;
    L15:
        if (this.lastModifiedTime == r9.lastModifiedTime) goto L18;
        return false;
    L18:
        if (this.type == r9.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.params, r9.params) == true) goto L23;
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
        int r0 = this.id.hashCode() * 31;
        long r1 = this.createTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.lastModifiedTime;
        return ((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.type) * 31) + this.params.hashCode();
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
        r3.writeString(VERSION);
    }
}
