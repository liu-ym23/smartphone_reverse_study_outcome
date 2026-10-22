package com.obric.memorydata.sdk.awareness;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&B.\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000b\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0016\u001a\u00070\u0005¢\u0006\u0002\b\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J6\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\r\b\u0002\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00070\u0005¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/AwarenessEventData;", "Landroid/os/Parcelable;", "key", "", "value", "", "Lkotlinx/parcelize/RawValue;", "timestamp", "", "extras", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;Ljava/lang/Object;JLandroid/os/Bundle;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "getTimestamp", "()J", "getExtras", "()Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessEventData implements Parcelable {
    public static final Parcelable.Creator<AwarenessEventData> CREATOR = null;
    private static final a Companion = null;
    private final Bundle extras;
    private final String key;
    private final long timestamp;
    private final Object value;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Parcelable.Creator<AwarenessEventData> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final AwarenessEventData createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            return new AwarenessEventData(r8.readString(), r8.readValue(AwarenessEventData.class.getClassLoader()), r8.readLong(), r8.readBundle(AwarenessEventData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final AwarenessEventData[] newArray(int r1) {
            return new AwarenessEventData[r1];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
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

    public final AwarenessEventData copy(String r8, Object r9, long r10, Bundle r12) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        Intrinsics.checkNotNullParameter(r12, "extras");
        return new AwarenessEventData(r8, r9, r10, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AwarenessEventData) == true) goto L8;
        return false;
    L8:
        AwarenessEventData r9 = (AwarenessEventData) r8;
        if (Intrinsics.areEqual(this.key, r9.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r9.value) == true) goto L15;
        return false;
    L15:
        if (this.timestamp == r9.timestamp) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extras, r9.extras) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.key.hashCode() * 31) + this.value.hashCode()) * 31;
        long r1 = this.timestamp;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.extras.hashCode();
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

    public AwarenessEventData(String r3, Object r4, long r5, Bundle r7) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        Intrinsics.checkNotNullParameter(r7, "extras");
        this.key = r3;
        this.value = r4;
        this.timestamp = r5;
        this.extras = r7;
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r4, "value");
        if ((r4 instanceof Boolean) == false) goto L5;
    L22:
        boolean r6 = true;
    L23:
        if (r6 == false) goto L26;
        return;
    L26:
        throw new IllegalArgumentException("AwarenessEventData.value 仅支持基础类型和 String".toString());
    L5:
        if ((r4 instanceof Byte) == true) goto L22;
        if ((r4 instanceof Character) == true) goto L22;
        if ((r4 instanceof Short) == true) goto L22;
        if ((r4 instanceof Integer) == true) goto L22;
        if ((r4 instanceof Long) == true) goto L22;
        if ((r4 instanceof Float) == true) goto L22;
        if ((r4 instanceof Double) == true) goto L22;
        if ((r4 instanceof String) == true) goto L22;
        r6 = false;
        goto L23
    }

    public /* synthetic */ AwarenessEventData(String r7, Object r8, long r9, Bundle r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = Bundle.EMPTY;
    L5:
        this(r7, r8, r9, r11);
    }
}
