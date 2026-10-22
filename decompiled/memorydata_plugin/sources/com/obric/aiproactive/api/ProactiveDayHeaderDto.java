package com.obric.aiproactive.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveDayHeaderDto;", "Landroid/os/Parcelable;", "dayKey", "", "dayStartMillis", "", CommonConsts.COUNT_TYPE, "", "<init>", "(Ljava/lang/String;JI)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDayKey", "()Ljava/lang/String;", "getDayStartMillis", "()J", "getCount", "()I", "writeToParcel", "", "dest", "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveDayHeaderDto implements Parcelable {
    public static final a CREATOR = null;
    private final int count;
    private final String dayKey;
    private final long dayStartMillis;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveDayHeaderDto$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/aiproactive/api/ProactiveDayHeaderDto;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/aiproactive/api/ProactiveDayHeaderDto;", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ProactiveDayHeaderDto> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public ProactiveDayHeaderDto a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ProactiveDayHeaderDto(r1);
        }

        public ProactiveDayHeaderDto[] a(int r1) {
            return new ProactiveDayHeaderDto[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveDayHeaderDto createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ProactiveDayHeaderDto[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public ProactiveDayHeaderDto(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        String r0 = r4.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this(r0, r4.readLong(), r4.readInt());
    }

    public ProactiveDayHeaderDto(String r2, long r3, int r5) {
        Intrinsics.checkNotNullParameter(r2, "dayKey");
        this.dayKey = r2;
        this.dayStartMillis = r3;
        this.count = r5;
    }

    public static /* synthetic */ ProactiveDayHeaderDto copy$default(ProactiveDayHeaderDto r0, String r1, long r2, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.dayKey;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.dayStartMillis;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.count;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final String component1() {
        return this.dayKey;
    }

    public final long component2() {
        return this.dayStartMillis;
    }

    public final int component3() {
        return this.count;
    }

    public final ProactiveDayHeaderDto copy(String r1, long r2, int r4) {
        Intrinsics.checkNotNullParameter(r1, "dayKey");
        return new ProactiveDayHeaderDto(r1, r2, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveDayHeaderDto.class) == true) goto L8;
        return false;
    L8:
        ProactiveDayHeaderDto r10 = (ProactiveDayHeaderDto) ZeusTransformUtils.preCheckCast(r9, ProactiveDayHeaderDto.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.dayKey, r10.dayKey) == true) goto L12;
        return false;
    L12:
        if (this.dayStartMillis == r10.dayStartMillis) goto L15;
        return false;
    L15:
        if (this.count == r10.count) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getDayKey() {
        return this.dayKey;
    }

    public final long getDayStartMillis() {
        return this.dayStartMillis;
    }

    public int hashCode() {
        return (((this.dayKey.hashCode() * 31) + Long.hashCode(this.dayStartMillis)) * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        return "ProactiveDayHeaderDto(dayKey=" + this.dayKey + ", dayStartMillis=" + this.dayStartMillis + ", count=" + this.count + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.dayKey);
        r3.writeLong(this.dayStartMillis);
        r3.writeInt(this.count);
    }
}
