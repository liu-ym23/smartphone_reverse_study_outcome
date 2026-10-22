package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00060\u0001j\u0002`\u0002:\u0002./B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J&\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0006J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006J%\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014¨\u00060"}, d2 = {"Lcom/larus/platform/api/creation/CreationLikeInfo;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "likeCount", "", "likeStatus", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLikeCount$annotations", "()V", "getLikeCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLikeStatus$annotations", "getLikeStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/platform/api/creation/CreationLikeInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationLikeInfo implements Parcelable {
    public static final Parcelable.Creator<CreationLikeInfo> CREATOR = null;
    public static final b Companion = null;
    public final Long a;
    public final Integer b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationLikeInfo> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(g1.a), kuc.a.d(w0.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.CreationLikeInfo", r0, 2);
            r1.j("like_count", true);
            r1.j("like_status", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            Integer r4 = null;
            if (r11.decodeSequentially() == false) goto L5;
            Long r1 = (Long) r11.decodeNullableSerializableElement(r0, 0, g1.a, null);
            Integer r2 = (Integer) r11.decodeNullableSerializableElement(r0, 1, w0.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new CreationLikeInfo(r3, r1, r2);
        L5:
            Long r5 = null;
            int r6 = 0;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L16;
            int r8 = r11.decodeElementIndex(r0);
            if (r8 != (-1)) goto L9;
            r7 = false;
            goto L6
        L9:
            if (r8 != 0) goto L10;
            r5 = (Long) r11.decodeNullableSerializableElement(r0, 0, g1.a, r5);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r4 = (Integer) r11.decodeNullableSerializableElement(r0, 1, w0.a, r4);
            r6 = r6 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r8);
        L16:
            r3 = r6;
            r2 = r4;
            r1 = r5;
            goto L17
        }

        public final void serialize(muc.f r9, Object r10) {
            CreationLikeInfo r11 = (CreationLikeInfo) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            b r1 = CreationLikeInfo.Companion;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Long r3 = r11.a;
            if (r3 == null) goto L10;
            if (r3.longValue() != 0) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r12.encodeNullableSerializableElement(r0, 0, g1.a, r11.a);
        L15:
            if (r12.shouldEncodeElementDefault(r0, 1) == true) goto L22;
            Integer r5 = r11.b;
            if (r5 == null) goto L22;
            if (r5.intValue() != 0) goto L22;
        L23:
            if (r2 == false) goto L25;
            r12.encodeNullableSerializableElement(r0, 1, w0.a, r11.b);
        L25:
            r12.endStructure(r0);
            return;
        L22:
            r2 = true;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationLikeInfo> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationLikeInfo> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationLikeInfo createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            Integer r2 = null;
            if (r6.readInt() != 0) goto L5;
            Long r1 = null;
        L7:
            if (r6.readInt() == 0) goto L11;
            r2 = Integer.valueOf(r6.readInt());
        L11:
            return new CreationLikeInfo(r1, r2);
        L5:
            r1 = Long.valueOf(r6.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CreationLikeInfo[] newArray(int r1) {
            return new CreationLikeInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationLikeInfo) == true) goto L8;
        return false;
    L8:
        CreationLikeInfo r6 = (CreationLikeInfo) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationLikeInfo(likeCount=" + this.a + ", likeStatus=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        Long r7 = this.a;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Integer r8 = this.b;
        if (r8 != null) goto L9;
        r5.writeInt(0);
        return;
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.intValue());
        return;
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public CreationLikeInfo() {
        this(0L, 0);
    }

    public CreationLikeInfo(Long r1, Integer r2) {
        this.a = r1;
        this.b = r2;
    }

    public CreationLikeInfo(int r5, Long r6, Integer r7) {
        if ((r5 & 0) == 0) goto L5;
        b2.b(r5, 0, a.b);
        throw null;
    L5:
        if ((r5 & 1) != 0) goto L7;
        r6 = 0L;
    L7:
        this.a = r6;
        if ((r5 & 2) != 0) goto L10;
        this.b = 0;
        return;
    L10:
        this.b = r7;
    }
}
