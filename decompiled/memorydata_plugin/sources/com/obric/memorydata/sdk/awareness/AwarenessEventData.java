package com.obric.memorydata.sdk.awareness;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&B.\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000b\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0016\u001a\u00070\u0005¢\u0006\u0002\b\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J6\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\r\b\u0002\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/AwarenessEventData;", "Landroid/os/Parcelable;", "key", "", EventBody.KEY_VALUE, "", "Lkotlinx/parcelize/RawValue;", "timestamp", "", "extras", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;JLandroid/os/Bundle;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "getTimestamp", "()J", "getExtras", "()Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessEventData implements Parcelable {
    public static final Parcelable.Creator<AwarenessEventData> CREATOR = null;
    private static final a Companion = null;
    private final Bundle extras;
    private final String key;
    private final long timestamp;
    private final Object value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/AwarenessEventData$Companion;", "", "<init>", "()V", "isSupportedValue", "", EventBody.KEY_VALUE, "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean a(Object r1) {
            Intrinsics.checkNotNullParameter(r1, EventBody.KEY_VALUE);
            if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L5;
        L22:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, Byte.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Character.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Short.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Integer.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Long.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Float.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Double.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, String.class) == true) goto L22;
            return false;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<AwarenessEventData> {
        public b() {
        }

        public final AwarenessEventData a(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            return new AwarenessEventData(r7.readString(), r7.readValue(AwarenessEventData.class.getClassLoader()), r7.readLong(), r7.readBundle(AwarenessEventData.class.getClassLoader()));
        }

        public final AwarenessEventData[] a(int r1) {
            return new AwarenessEventData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AwarenessEventData createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AwarenessEventData[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new b(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public AwarenessEventData(String r2, Object r3, long r4, Bundle r6) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r6, "extras");
        this.key = r2;
        this.value = r3;
        this.timestamp = r4;
        this.extras = r6;
        if (Companion.a(r3) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("AwarenessEventData.value 仅支持基础类型和 String".toString());
    }

    public /* synthetic */ AwarenessEventData(String r7, Object r8, long r9, Bundle r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = Bundle.EMPTY;
    L5:
        this(r7, r8, r9, r11);
    }

    public static /* synthetic */ AwarenessEventData copy$default(AwarenessEventData r3, String r4, Object r5, long r6, Bundle r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.key;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.value;
    L8:
        Object r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.timestamp;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.extras;
    L14:
        String r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final String component1() {
        return this.key;
    }

    public final Object component2() {
        return this.value;
    }

    public final long component3() {
        return this.timestamp;
    }

    public final Bundle component4() {
        return this.extras;
    }

    public final AwarenessEventData copy(String r7, Object r8, long r9, Bundle r11) {
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r11, "extras");
        return new AwarenessEventData(r7, r8, r9, r11);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AwarenessEventData.class) == true) goto L8;
        return false;
    L8:
        AwarenessEventData r10 = (AwarenessEventData) ZeusTransformUtils.preCheckCast(r9, AwarenessEventData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.key, r10.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r10.value) == true) goto L15;
        return false;
    L15:
        if (this.timestamp == r10.timestamp) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extras, r10.extras) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final String getKey() {
        return this.key;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((this.key.hashCode() * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "AwarenessEventData(key=" + this.key + ", value=" + this.value + ", timestamp=" + this.timestamp + ", extras=" + this.extras + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.key);
        r3.writeValue(this.value);
        r3.writeLong(this.timestamp);
        r3.writeBundle(this.extras);
    }
}
