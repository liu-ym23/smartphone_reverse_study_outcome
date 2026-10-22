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
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00060\u0001j\u0002`\u0002:\u000278B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ>\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\rJ\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\rHÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\rJ%\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001a¨\u00069"}, d2 = {"Lcom/larus/ugc/feed/api/model/CreationFeedCacheEntityKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "creationRecommendType", "", "listData", "Lcom/larus/ugc/feed/api/model/CommonCreationFeedDataKmp;", "randomSeed", "", "timeStamp", "<init>", "(Ljava/lang/String;Lcom/larus/ugc/feed/api/model/CommonCreationFeedDataKmp;Ljava/lang/Long;Ljava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/ugc/feed/api/model/CommonCreationFeedDataKmp;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreationRecommendType$annotations", "()V", "getCreationRecommendType", "()Ljava/lang/String;", "getListData$annotations", "getListData", "()Lcom/larus/ugc/feed/api/model/CommonCreationFeedDataKmp;", "getRandomSeed$annotations", "getRandomSeed", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimeStamp$annotations", "getTimeStamp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/larus/ugc/feed/api/model/CommonCreationFeedDataKmp;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/ugc/feed/api/model/CreationFeedCacheEntityKmp;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationFeedCacheEntityKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CreationFeedCacheEntityKmp> CREATOR = null;
    public static final b Companion = null;
    private final String creationRecommendType;
    private final CommonCreationFeedDataKmp listData;
    private final Long randomSeed;
    private final Long timeStamp;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationFeedCacheEntityKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            g1 r1 = g1.a;
            return new d[]{kuc.a.d(v2.a), kuc.a.d(CommonCreationFeedDataKmp.a.a), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.CreationFeedCacheEntityKmp", r0, 4);
            r1.j("creation_recommend_type", true);
            r1.j("list_data", true);
            r1.j("random_seed", true);
            r1.j("time_stamp", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            String r7 = null;
            if (r0.decodeSequentially() == false) goto L5;
            String r2 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, null);
            CommonCreationFeedDataKmp r4 = (CommonCreationFeedDataKmp) r0.decodeNullableSerializableElement(r1, 1, CommonCreationFeedDataKmp.a.a, null);
            g1 r5 = g1.a;
            String r14 = r2;
            Long r16 = (Long) r0.decodeNullableSerializableElement(r1, 2, r5, null);
            CommonCreationFeedDataKmp r15 = r4;
            Long r17 = (Long) r0.decodeNullableSerializableElement(r1, 3, r5, null);
            int r13 = 15;
        L21:
            r0.endStructure(r1);
            return new CreationFeedCacheEntityKmp(r13, r14, r15, r16, r17, null);
        L5:
            CommonCreationFeedDataKmp r8 = null;
            Long r9 = null;
            Long r10 = null;
            int r3 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L20;
            int r12 = r0.decodeElementIndex(r1);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r7 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r7);
            r3 = r3 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r8 = (CommonCreationFeedDataKmp) r0.decodeNullableSerializableElement(r1, 1, CommonCreationFeedDataKmp.a.a, r8);
            r3 = r3 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L12;
            r9 = (Long) r0.decodeNullableSerializableElement(r1, 2, g1.a, r9);
            r3 = r3 | 4;
            goto L6
        L12:
            if (r12 != 3) goto L15;
            r10 = (Long) r0.decodeNullableSerializableElement(r1, 3, g1.a, r10);
            r3 = r3 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r12);
        L20:
            r13 = r3;
            r14 = r7;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            goto L21
        }

        public final void serialize(muc.f r2, Object r3) {
            CreationFeedCacheEntityKmp r4 = (CreationFeedCacheEntityKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            CreationFeedCacheEntityKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationFeedCacheEntityKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationFeedCacheEntityKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedCacheEntityKmp createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r1 = r8.readString();
            Long r3 = null;
            if (r8.readInt() != 0) goto L5;
            CommonCreationFeedDataKmp r2 = null;
        L6:
            CommonCreationFeedDataKmp r4 = r2;
            if (r8.readInt() != 0) goto L9;
            Long r5 = null;
        L11:
            if (r8.readInt() == 0) goto L15;
            r3 = Long.valueOf(r8.readLong());
        L15:
            return new CreationFeedCacheEntityKmp(r1, r4, r5, r3);
        L9:
            r5 = Long.valueOf(r8.readLong());
            goto L11
        L5:
            r2 = CommonCreationFeedDataKmp.CREATOR.createFromParcel(r8);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CreationFeedCacheEntityKmp[] newArray(int r1) {
            return new CreationFeedCacheEntityKmp[r1];
        }
    }

    public CreationFeedCacheEntityKmp() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CreationFeedCacheEntityKmp copy$default(CreationFeedCacheEntityKmp r0, String r1, CommonCreationFeedDataKmp r2, Long r3, Long r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.creationRecommendType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.listData;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.randomSeed;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.timeStamp;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    @SerialName("creation_recommend_type")
    public static /* synthetic */ void getCreationRecommendType$annotations() {
    }

    @SerialName("list_data")
    public static /* synthetic */ void getListData$annotations() {
    }

    @SerialName("random_seed")
    public static /* synthetic */ void getRandomSeed$annotations() {
    }

    @SerialName("time_stamp")
    public static /* synthetic */ void getTimeStamp$annotations() {
    }

    public final String component1() {
        return this.creationRecommendType;
    }

    public final CommonCreationFeedDataKmp component2() {
        return this.listData;
    }

    public final Long component3() {
        return this.randomSeed;
    }

    public final Long component4() {
        return this.timeStamp;
    }

    public final CreationFeedCacheEntityKmp copy(String r2, CommonCreationFeedDataKmp r3, Long r4, Long r5) {
        return new CreationFeedCacheEntityKmp(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationFeedCacheEntityKmp) == true) goto L8;
        return false;
    L8:
        CreationFeedCacheEntityKmp r6 = (CreationFeedCacheEntityKmp) r5;
        if (Intrinsics.areEqual(this.creationRecommendType, r6.creationRecommendType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.listData, r6.listData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.randomSeed, r6.randomSeed) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.timeStamp, r6.timeStamp) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.creationRecommendType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        CommonCreationFeedDataKmp r4 = this.listData;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.randomSeed;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.timeStamp;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationFeedCacheEntityKmp(creationRecommendType=" + this.creationRecommendType + ", listData=" + this.listData + ", randomSeed=" + this.randomSeed + ", timeStamp=" + this.timeStamp + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.creationRecommendType);
        CommonCreationFeedDataKmp r0 = this.listData;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        Long r8 = this.randomSeed;
        if (r8 != null) goto L9;
        r6.writeInt(0);
    L10:
        Long r9 = this.timeStamp;
        if (r9 != null) goto L13;
        r6.writeInt(0);
        return;
    L13:
        r6.writeInt(1);
        r6.writeLong(r9.longValue());
        return;
    L9:
        r6.writeInt(1);
        r6.writeLong(r8.longValue());
        goto L10
    L5:
        r6.writeInt(1);
        r0.writeToParcel(r6, r7);
        goto L6
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
    }

    public final String getCreationRecommendType() {
        return this.creationRecommendType;
    }

    public final CommonCreationFeedDataKmp getListData() {
        return this.listData;
    }

    public final Long getRandomSeed() {
        return this.randomSeed;
    }

    public final Long getTimeStamp() {
        return this.timeStamp;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CreationFeedCacheEntityKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, v2.a, r5.creationRecommendType);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, CommonCreationFeedDataKmp.a.a, r5.listData);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, g1.a, r5.randomSeed);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        r0 = true;
    L35:
        if (r0 == false) goto L38;
        r6.encodeNullableSerializableElement(r7, 3, g1.a, r5.timeStamp);
        return;
    L38:
        return;
    L33:
        if (r5.timeStamp == null) goto L35;
    L24:
        if (r5.randomSeed != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.listData != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.creationRecommendType != null) goto L4;
        r1 = false;
        goto L9
    }

    public CreationFeedCacheEntityKmp(String r1, CommonCreationFeedDataKmp r2, Long r3, Long r4) {
        this.creationRecommendType = r1;
        this.listData = r2;
        this.randomSeed = r3;
        this.timeStamp = r4;
    }

    public CreationFeedCacheEntityKmp(int r2, String r3, CommonCreationFeedDataKmp r4, Long r5, Long r6, q2 r7) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.creationRecommendType = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.listData = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.randomSeed = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.timeStamp = null;
        return;
    L19:
        this.timeStamp = r6;
        return;
    L15:
        this.randomSeed = r5;
        goto L17
    L11:
        this.listData = r4;
        goto L13
    L7:
        this.creationRecommendType = r3;
        goto L9
    }

    public /* synthetic */ CreationFeedCacheEntityKmp(String r2, CommonCreationFeedDataKmp r3, Long r4, Long r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
