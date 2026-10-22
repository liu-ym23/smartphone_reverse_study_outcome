package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B3\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\bH\u0016J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\bH\u0016R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/FloatingIntentParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "position", "Lcom/obric/capabilitykit/common/Position;", "height", "", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "", "(Lcom/obric/capabilitykit/common/Position;Ljava/lang/Integer;Ljava/util/concurrent/ConcurrentHashMap;)V", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPosition", "()Lcom/obric/capabilitykit/common/Position;", "component1", "component2", "component3", "copy", "(Lcom/obric/capabilitykit/common/Position;Ljava/lang/Integer;Ljava/util/concurrent/ConcurrentHashMap;)Lcom/obric/capabilitykit/common/FloatingIntentParams;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FloatingIntentParams implements Parcelable {
    public static final a CREATOR = null;
    private ConcurrentHashMap<String, String> ext;
    private final Integer height;
    private final Position position;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/common/FloatingIntentParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/common/FloatingIntentParams;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<FloatingIntentParams> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public FloatingIntentParams a(Parcel r5) {
            int r4 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            r5.readInt();
            FloatingIntentParams r0 = new FloatingIntentParams(r5);
            int r1 = Math.min(r4, 0);
            ClassLoader r2 = a.class.getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r1) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r4) goto L7;
            com.obric.b.a.a(r5, r2);
            r3 = r3 + 1;
            goto L5
        L7:
            return r0;
        }

        public FloatingIntentParams[] a(int r1) {
            return new FloatingIntentParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ FloatingIntentParams createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ FloatingIntentParams[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public FloatingIntentParams() {
        this(null, null, null, 7, null);
    }

    public FloatingIntentParams(Parcel r6) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        Object r0 = r6.readValue(Position.class.getClassLoader());
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.common.Position");
        Position r1 = (Position) ZeusTransformUtils.preCheckCast(r0, Position.class, "com.obric.memorydata.plugin");
        Object r2 = r6.readValue(Integer.TYPE.getClassLoader());
        ConcurrentHashMap r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L5;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin");
    L6:
        Serializable r7 = r6.readSerializable();
        if (ZeusTransformUtils.instanceOf(r7, ConcurrentHashMap.class) == false) goto L9;
        r4 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r7, ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    L9:
        this(r1, r3, r4);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public FloatingIntentParams(Position r2, Integer r3, ConcurrentHashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "position");
        this.position = r2;
        this.height = r3;
        this.ext = r4;
    }

    public /* synthetic */ FloatingIntentParams(Position r2, Integer r3, ConcurrentHashMap r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = Position.BOTTOM;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FloatingIntentParams copy$default(FloatingIntentParams r0, Position r1, Integer r2, ConcurrentHashMap r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.position;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.height;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.ext;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Position component1() {
        return this.position;
    }

    public final Integer component2() {
        return this.height;
    }

    public final ConcurrentHashMap<String, String> component3() {
        return this.ext;
    }

    public final FloatingIntentParams copy(Position r1, Integer r2, ConcurrentHashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r1, "position");
        return new FloatingIntentParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FloatingIntentParams.class) == true) goto L8;
        return false;
    L8:
        FloatingIntentParams r6 = (FloatingIntentParams) ZeusTransformUtils.preCheckCast(r5, FloatingIntentParams.class, "com.obric.memorydata.plugin");
        if (this.position == r6.position) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Position getPosition() {
        return this.position;
    }

    public int hashCode() {
        int r0 = this.position.hashCode() * 31;
        Integer r1 = this.height;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ConcurrentHashMap<String, String> r5 = this.ext;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setExt(ConcurrentHashMap<String, String> r1) {
        this.ext = r1;
    }

    public String toString() {
        return "FloatingIntentParams(position=" + this.position + ", height=" + this.height + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(0);
        r2.writeValue(this.position);
        r2.writeValue(this.height);
        r2.writeSerializable(this.ext);
    }
}
