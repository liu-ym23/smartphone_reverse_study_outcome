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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00060\u0001j\u0002`\u0002:\u000223B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J&\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\nJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\nJ%\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0019\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00064"}, d2 = {"Lcom/larus/platform/api/creation/CreationCommunityInfo;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "likeInfo", "Lcom/larus/platform/api/creation/CreationLikeInfo;", "commentCount", "", "<init>", "(Lcom/larus/platform/api/creation/CreationLikeInfo;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/creation/CreationLikeInfo;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLikeInfo$annotations", "()V", "getLikeInfo", "()Lcom/larus/platform/api/creation/CreationLikeInfo;", "setLikeInfo", "(Lcom/larus/platform/api/creation/CreationLikeInfo;)V", "getCommentCount$annotations", "getCommentCount", "()Ljava/lang/Long;", "setCommentCount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Lcom/larus/platform/api/creation/CreationLikeInfo;Ljava/lang/Long;)Lcom/larus/platform/api/creation/CreationCommunityInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationCommunityInfo implements Parcelable {
    public static final Parcelable.Creator<CreationCommunityInfo> CREATOR = null;
    public static final b Companion = null;
    public final CreationLikeInfo a;
    public final Long b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationCommunityInfo> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(CreationLikeInfo.a.a), kuc.a.d(g1.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.CreationCommunityInfo", r0, 2);
            r1.j("like_info", true);
            r1.j("comment_count", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            Long r4 = null;
            if (r11.decodeSequentially() == false) goto L5;
            CreationLikeInfo r1 = (CreationLikeInfo) r11.decodeNullableSerializableElement(r0, 0, CreationLikeInfo.a.a, null);
            Long r2 = (Long) r11.decodeNullableSerializableElement(r0, 1, g1.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new CreationCommunityInfo(r3, r1, r2);
        L5:
            CreationLikeInfo r5 = null;
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
            r5 = (CreationLikeInfo) r11.decodeNullableSerializableElement(r0, 0, CreationLikeInfo.a.a, r5);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r4 = (Long) r11.decodeNullableSerializableElement(r0, 1, g1.a, r4);
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

        public final void serialize(muc.f r6, Object r7) {
            CreationCommunityInfo r8 = (CreationCommunityInfo) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = CreationCommunityInfo.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, CreationLikeInfo.a.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeNullableSerializableElement(r0, 1, g1.a, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (r8.b == null) goto L17;
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationCommunityInfo> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationCommunityInfo> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationCommunityInfo createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Long r2 = null;
            if (r5.readInt() != 0) goto L5;
            CreationLikeInfo r1 = null;
        L6:
            CreationLikeInfo r3 = r1;
            if (r5.readInt() == 0) goto L11;
            r2 = Long.valueOf(r5.readLong());
        L11:
            return new CreationCommunityInfo(r3, r2);
        L5:
            r1 = CreationLikeInfo.CREATOR.createFromParcel(r5);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CreationCommunityInfo[] newArray(int r1) {
            return new CreationCommunityInfo[r1];
        }
    }

    public CreationCommunityInfo() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationCommunityInfo) == true) goto L8;
        return false;
    L8:
        CreationCommunityInfo r6 = (CreationCommunityInfo) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        CreationLikeInfo r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationCommunityInfo(likeInfo=" + this.a + ", commentCount=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        CreationLikeInfo r0 = this.a;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        Long r6 = this.b;
        if (r6 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r4.writeLong(r6.longValue());
        return;
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public CreationCommunityInfo(CreationLikeInfo r1, Long r2) {
        this.a = r1;
        this.b = r2;
    }

    public CreationCommunityInfo(int r3, CreationLikeInfo r4, Long r5) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
