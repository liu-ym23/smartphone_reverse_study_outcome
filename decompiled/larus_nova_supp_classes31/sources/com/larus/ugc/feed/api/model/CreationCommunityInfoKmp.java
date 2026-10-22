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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00060\u0001j\u0002`\u0002:\u000223B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J&\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\nJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\nJ%\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0019\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00064"}, d2 = {"Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "likeInfo", "Lcom/larus/ugc/feed/api/model/CreationLikeInfoKmp;", "commentCount", "", "<init>", "(Lcom/larus/ugc/feed/api/model/CreationLikeInfoKmp;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/ugc/feed/api/model/CreationLikeInfoKmp;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLikeInfo$annotations", "()V", "getLikeInfo", "()Lcom/larus/ugc/feed/api/model/CreationLikeInfoKmp;", "setLikeInfo", "(Lcom/larus/ugc/feed/api/model/CreationLikeInfoKmp;)V", "getCommentCount$annotations", "getCommentCount", "()Ljava/lang/Long;", "setCommentCount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Lcom/larus/ugc/feed/api/model/CreationLikeInfoKmp;Ljava/lang/Long;)Lcom/larus/ugc/feed/api/model/CreationCommunityInfoKmp;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationCommunityInfoKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CreationCommunityInfoKmp> CREATOR = null;
    public static final b Companion = null;
    private Long commentCount;
    private CreationLikeInfoKmp likeInfo;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationCommunityInfoKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(CreationLikeInfoKmp.a.a), kuc.a.d(g1.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.CreationCommunityInfoKmp", r0, 2);
            r1.j("like_info", true);
            r1.j("comment_count", true);
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
            CreationLikeInfoKmp r1 = (CreationLikeInfoKmp) r12.decodeNullableSerializableElement(r0, 0, CreationLikeInfoKmp.a.a, null);
            Long r2 = (Long) r12.decodeNullableSerializableElement(r0, 1, g1.a, null);
            int r3 = 3;
        L17:
            r12.endStructure(r0);
            return new CreationCommunityInfoKmp(r3, r1, r2, null);
        L5:
            r1 = null;
            Long r5 = null;
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
            r1 = (CreationLikeInfoKmp) r12.decodeNullableSerializableElement(r0, 0, CreationLikeInfoKmp.a.a, r1);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r5 = (Long) r12.decodeNullableSerializableElement(r0, 1, g1.a, r5);
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
            CreationCommunityInfoKmp r4 = (CreationCommunityInfoKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            CreationCommunityInfoKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationCommunityInfoKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationCommunityInfoKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationCommunityInfoKmp createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Long r2 = null;
            if (r5.readInt() != 0) goto L5;
            CreationLikeInfoKmp r1 = null;
        L6:
            CreationLikeInfoKmp r3 = r1;
            if (r5.readInt() == 0) goto L11;
            r2 = Long.valueOf(r5.readLong());
        L11:
            return new CreationCommunityInfoKmp(r3, r2);
        L5:
            r1 = CreationLikeInfoKmp.CREATOR.createFromParcel(r5);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CreationCommunityInfoKmp[] newArray(int r1) {
            return new CreationCommunityInfoKmp[r1];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationCommunityInfoKmp() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CreationCommunityInfoKmp copy$default(CreationCommunityInfoKmp r0, CreationLikeInfoKmp r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.likeInfo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.commentCount;
    L9:
        return r0.copy(r1, r2);
    }

    @SerialName("comment_count")
    public static /* synthetic */ void getCommentCount$annotations() {
    }

    @SerialName("like_info")
    public static /* synthetic */ void getLikeInfo$annotations() {
    }

    public final CreationLikeInfoKmp component1() {
        return this.likeInfo;
    }

    public final Long component2() {
        return this.commentCount;
    }

    public final CreationCommunityInfoKmp copy(CreationLikeInfoKmp r2, Long r3) {
        return new CreationCommunityInfoKmp(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationCommunityInfoKmp) == true) goto L8;
        return false;
    L8:
        CreationCommunityInfoKmp r6 = (CreationCommunityInfoKmp) r5;
        if (Intrinsics.areEqual(this.likeInfo, r6.likeInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commentCount, r6.commentCount) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        CreationLikeInfoKmp r0 = this.likeInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.commentCount;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationCommunityInfoKmp(likeInfo=" + this.likeInfo + ", commentCount=" + this.commentCount + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        CreationLikeInfoKmp r0 = this.likeInfo;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        Long r6 = this.commentCount;
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
        $stable = 8;
        CREATOR = new c();
    }

    public final Long getCommentCount() {
        return this.commentCount;
    }

    public final CreationLikeInfoKmp getLikeInfo() {
        return this.likeInfo;
    }

    public final void setCommentCount(Long r1) {
        this.commentCount = r1;
    }

    public final void setLikeInfo(CreationLikeInfoKmp r1) {
        this.likeInfo = r1;
    }

    public CreationCommunityInfoKmp(CreationLikeInfoKmp r1, Long r2) {
        this.likeInfo = r1;
        this.commentCount = r2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CreationCommunityInfoKmp r4, muc.d r5, f r6) {
        boolean r0 = false;
        if (r5.shouldEncodeElementDefault(r6, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r5.encodeNullableSerializableElement(r6, 0, CreationLikeInfoKmp.a.a, r4.likeInfo);
    L12:
        if (r5.shouldEncodeElementDefault(r6, 1) == false) goto L15;
    L13:
        r0 = true;
    L17:
        if (r0 == false) goto L20;
        r5.encodeNullableSerializableElement(r6, 1, g1.a, r4.commentCount);
        return;
    L20:
        return;
    L15:
        if (r4.commentCount == null) goto L17;
    L6:
        if (r4.likeInfo != null) goto L4;
        r1 = false;
        goto L9
    }

    public CreationCommunityInfoKmp(int r2, CreationLikeInfoKmp r3, Long r4, q2 r5) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.likeInfo = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.commentCount = null;
        return;
    L11:
        this.commentCount = r4;
        return;
    L7:
        this.likeInfo = r3;
        goto L9
    }

    public /* synthetic */ CreationCommunityInfoKmp(CreationLikeInfoKmp r2, Long r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
