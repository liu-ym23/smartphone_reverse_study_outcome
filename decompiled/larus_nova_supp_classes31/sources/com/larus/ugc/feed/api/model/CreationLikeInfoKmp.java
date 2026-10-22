package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00060\u0001j\u0002`\u0002:\u0002./B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J&\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0006J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006J%\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014¨\u00060"}, d2 = {"Lcom/larus/ugc/feed/api/model/CreationLikeInfoKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "likeCount", "", "likeStatus", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLikeCount$annotations", "()V", "getLikeCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLikeStatus$annotations", "getLikeStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/ugc/feed/api/model/CreationLikeInfoKmp;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationLikeInfoKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CreationLikeInfoKmp> CREATOR = null;
    public static final b Companion = null;
    private final Long likeCount;
    private final Integer likeStatus;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationLikeInfoKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.CreationLikeInfoKmp", r0, 2);
            r1.j("like_count", true);
            r1.j("like_status", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r11) {
            Intrinsics.checkNotNullParameter(r11, "decoder");
            g2 r0 = b;
            muc.c r12 = r11.beginStructure(r0);
            if (r12.decodeSequentially() == false) goto L5;
            Long r1 = (Long) r12.decodeNullableSerializableElement(r0, 0, g1.a, null);
            Integer r2 = (Integer) r12.decodeNullableSerializableElement(r0, 1, w0.a, null);
            int r3 = 3;
        L17:
            r12.endStructure(r0);
            return new CreationLikeInfoKmp(r3, r1, r2, null);
        L5:
            r1 = null;
            Integer r5 = null;
            int r6 = 0;
            boolean r7 = true;
        L6:
            if (r7 == false) goto L16;
            int r8 = r12.decodeElementIndex(r0);
            if (r8 != (-1)) goto L9;
            r7 = false;
            goto L6
        L9:
            if (r8 != 0) goto L10;
            r1 = (Long) r12.decodeNullableSerializableElement(r0, 0, g1.a, r1);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r5 = (Integer) r12.decodeNullableSerializableElement(r0, 1, w0.a, r5);
            r6 = r6 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r8);
        L16:
            r2 = r5;
            r3 = r6;
            goto L17
        }

        public final void serialize(muc.f r2, Object r3) {
            CreationLikeInfoKmp r4 = (CreationLikeInfoKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            CreationLikeInfoKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationLikeInfoKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationLikeInfoKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationLikeInfoKmp createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            Integer r2 = null;
            if (r6.readInt() != 0) goto L5;
            Long r1 = null;
        L7:
            if (r6.readInt() == 0) goto L11;
            r2 = Integer.valueOf(r6.readInt());
        L11:
            return new CreationLikeInfoKmp(r1, r2);
        L5:
            r1 = Long.valueOf(r6.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CreationLikeInfoKmp[] newArray(int r1) {
            return new CreationLikeInfoKmp[r1];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationLikeInfoKmp() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CreationLikeInfoKmp copy$default(CreationLikeInfoKmp r0, Long r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.likeCount;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.likeStatus;
    L9:
        return r0.copy(r1, r2);
    }

    @SerialName("like_count")
    public static /* synthetic */ void getLikeCount$annotations() {
    }

    @SerialName("like_status")
    public static /* synthetic */ void getLikeStatus$annotations() {
    }

    public final Long component1() {
        return this.likeCount;
    }

    public final Integer component2() {
        return this.likeStatus;
    }

    public final CreationLikeInfoKmp copy(Long r2, Integer r3) {
        return new CreationLikeInfoKmp(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationLikeInfoKmp) == true) goto L8;
        return false;
    L8:
        CreationLikeInfoKmp r6 = (CreationLikeInfoKmp) r5;
        if (Intrinsics.areEqual(this.likeCount, r6.likeCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.likeStatus, r6.likeStatus) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r0 = this.likeCount;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.likeStatus;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationLikeInfoKmp(likeCount=" + this.likeCount + ", likeStatus=" + this.likeStatus + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        Long r7 = this.likeCount;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Integer r8 = this.likeStatus;
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

    public final Long getLikeCount() {
        return this.likeCount;
    }

    public final Integer getLikeStatus() {
        return this.likeStatus;
    }

    public CreationLikeInfoKmp(Long r1, Integer r2) {
        this.likeCount = r1;
        this.likeStatus = r2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CreationLikeInfoKmp r7, muc.d r8, f r9) {
        boolean r0 = false;
        if (r8.shouldEncodeElementDefault(r9, 0) == false) goto L5;
    L4:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        r8.encodeNullableSerializableElement(r9, 0, g1.a, r7.likeCount);
    L15:
        if (r8.shouldEncodeElementDefault(r9, 1) == false) goto L17;
    L16:
        r0 = true;
    L23:
        if (r0 == false) goto L26;
        r8.encodeNullableSerializableElement(r9, 1, w0.a, r7.likeStatus);
        return;
    L26:
        return;
    L17:
        Integer r2 = r7.likeStatus;
        if (r2 == null) goto L16;
        if (r2.intValue() == 0) goto L23;
    L5:
        Long r3 = r7.likeCount;
        if (r3 == null) goto L4;
        if (r3.longValue() != 0) goto L4;
        r1 = false;
        goto L12
    }

    public CreationLikeInfoKmp(int r4, Long r5, Integer r6, q2 r7) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        r5 = 0L;
    L7:
        this.likeCount = r5;
        if ((r4 & 2) != 0) goto L10;
        this.likeStatus = 0;
        return;
    L10:
        this.likeStatus = r6;
    }

    public /* synthetic */ CreationLikeInfoKmp(Long r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = 0L;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = 0;
    L8:
        this(r3, r4);
    }
}
