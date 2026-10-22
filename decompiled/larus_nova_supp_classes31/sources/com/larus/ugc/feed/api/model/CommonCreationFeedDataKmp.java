package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import juc.d;
import juc.n;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00060\u0001j\u0002`\u0002:\u0002;<Ba\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eBk\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u0019\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jc\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010)\u001a\u00020\u0010J\u0013\u0010*\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0010HÖ\u0001J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0010J%\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R,\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR$\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR*\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u001dR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\"¨\u0006="}, d2 = {"Lcom/larus/ugc/feed/api/model/CommonCreationFeedDataKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "hasMore", "", "traceMap", "", "", "creationList", "", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "creationGroupList", "nextCursor", "<init>", "(ZLjava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHasMore$annotations", "()V", "getHasMore", "()Z", "getTraceMap$annotations", "getTraceMap", "()Ljava/util/Map;", "getCreationList$annotations", "getCreationList", "()Ljava/util/List;", "getCreationGroupList$annotations", "getCreationGroupList", "getNextCursor$annotations", "getNextCursor", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CommonCreationFeedDataKmp implements Parcelable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final int $stable = 0;
    public static final Parcelable.Creator<CommonCreationFeedDataKmp> CREATOR = null;
    public static final b Companion = null;
    private final List<List<UserCreationKmp>> creationGroupList;
    private final List<UserCreationKmp> creationList;
    private final boolean hasMore;
    private final String nextCursor;
    private final Map<String, String> traceMap;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CommonCreationFeedDataKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp", r0, 5);
            r1.j("has_more", true);
            r1.j("trace_map", true);
            r1.j("creation_list", true);
            r1.j("creation_group_list", true);
            r1.j("next_cursor", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            Lazy[] r0 = CommonCreationFeedDataKmp.access$get$childSerializers$cp();
            return new d[]{i.a, kuc.a.d((d) r0[1].getValue()), kuc.a.d((d) r0[2].getValue()), kuc.a.d((d) r0[3].getValue()), kuc.a.d(v2.a)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            Lazy[] r2 = CommonCreationFeedDataKmp.access$get$childSerializers$cp();
            if (r0.decodeSequentially() == false) goto L5;
            boolean r3 = r0.decodeBooleanElement(r1, 0);
            Map r6 = (Map) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), null);
            List r4 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            List r20 = (List) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), null);
            boolean r17 = r3;
            List r19 = r4;
            String r21 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, null);
            Map r18 = r6;
            int r16 = 31;
        L24:
            r0.endStructure(r1);
            return new CommonCreationFeedDataKmp(r16, r17, r18, r19, r20, r21, null);
        L5:
            Map r10 = null;
            List r11 = null;
            List r12 = null;
            String r13 = null;
            boolean r5 = false;
            int r9 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L23;
            int r15 = r0.decodeElementIndex(r1);
            if (r15 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r15 != 0) goto L10;
            r5 = r0.decodeBooleanElement(r1, 0);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r15 == 1) goto L19;
            if (r15 == 2) goto L18;
            if (r15 == 3) goto L17;
            if (r15 != 4) goto L16;
            r9 = r9 | 16;
            r13 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r13);
            goto L6
        L16:
            throw new UnknownFieldException(r15);
        L17:
            r9 = r9 | 8;
            r12 = (List) r0.decodeNullableSerializableElement(r1, 3, (juc.c) r2[3].getValue(), r12);
            goto L6
        L18:
            r9 = r9 | 4;
            r11 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), r11);
            goto L6
        L19:
            r9 = r9 | 2;
            r10 = (Map) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), r10);
            goto L6
        L23:
            r17 = r5;
            r16 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            r21 = r13;
            goto L24
        }

        public final void serialize(muc.f r2, Object r3) {
            CommonCreationFeedDataKmp r4 = (CommonCreationFeedDataKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            CommonCreationFeedDataKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CommonCreationFeedDataKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CommonCreationFeedDataKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonCreationFeedDataKmp createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            if (r12.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            ArrayList r2 = null;
            if (r12.readInt() != 0) goto L9;
            LinkedHashMap r4 = null;
        L13:
            if (r12.readInt() != 0) goto L15;
            ArrayList r5 = null;
        L19:
            if (r12.readInt() == 0) goto L28;
            int r0 = r12.readInt();
            r2 = new ArrayList(r0);
            int r6 = 0;
        L22:
            if (r6 == r0) goto L28;
            int r7 = r12.readInt();
            ArrayList r8 = new ArrayList(r7);
            int r9 = 0;
        L24:
            if (r9 == r7) goto L26;
            r8.add(UserCreationKmp.CREATOR.createFromParcel(r12));
            r9 = r9 + 1;
            goto L24
        L26:
            r2.add(r8);
            r6 = r6 + 1;
        L28:
            return new CommonCreationFeedDataKmp(r3, r4, r5, r2, r12.readString());
        L15:
            int r1 = r12.readInt();
            r5 = new ArrayList(r1);
            int r10 = 0;
        L16:
            if (r10 == r1) goto L19;
            r5.add(UserCreationKmp.CREATOR.createFromParcel(r12));
            r10 = r10 + 1;
            goto L16
        L9:
            int r11 = r12.readInt();
            r4 = new LinkedHashMap(r11);
            int r13 = 0;
        L10:
            if (r13 == r11) goto L13;
            r4.put(r12.readString(), r12.readString());
            r13 = r13 + 1;
            goto L10
        L5:
            r3 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CommonCreationFeedDataKmp[] newArray(int r1) {
            return new CommonCreationFeedDataKmp[r1];
        }
    }

    public CommonCreationFeedDataKmp() {
        this(false, null, null, null, null, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r1 = v2.a;
        return new a1(r1, kuc.a.d(r1));
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new nuc.f(UserCreationKmp.a.a);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$1() {
        return new nuc.f(new nuc.f(UserCreationKmp.a.a));
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_$1();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d c() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonCreationFeedDataKmp copy$default(CommonCreationFeedDataKmp r3, boolean r4, Map r5, List r6, List r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.hasMore;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.traceMap;
    L8:
        Map r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.creationList;
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.creationGroupList;
    L14:
        List r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.nextCursor;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    @SerialName("creation_group_list")
    public static /* synthetic */ void getCreationGroupList$annotations() {
    }

    @SerialName("creation_list")
    public static /* synthetic */ void getCreationList$annotations() {
    }

    @SerialName("has_more")
    public static /* synthetic */ void getHasMore$annotations() {
    }

    @SerialName("next_cursor")
    public static /* synthetic */ void getNextCursor$annotations() {
    }

    @SerialName("trace_map")
    public static /* synthetic */ void getTraceMap$annotations() {
    }

    public final boolean component1() {
        return this.hasMore;
    }

    public final Map<String, String> component2() {
        return this.traceMap;
    }

    public final List<UserCreationKmp> component3() {
        return this.creationList;
    }

    public final List<List<UserCreationKmp>> component4() {
        return this.creationGroupList;
    }

    public final String component5() {
        return this.nextCursor;
    }

    public final CommonCreationFeedDataKmp copy(boolean r8, Map<String, String> r9, List<UserCreationKmp> r10, List<? extends List<UserCreationKmp>> r11, String r12) {
        return new CommonCreationFeedDataKmp(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CommonCreationFeedDataKmp) == true) goto L8;
        return false;
    L8:
        CommonCreationFeedDataKmp r6 = (CommonCreationFeedDataKmp) r5;
        if (this.hasMore == r6.hasMore) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.traceMap, r6.traceMap) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.creationList, r6.creationList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creationGroupList, r6.creationGroupList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.nextCursor, r6.nextCursor) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.hasMore == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        Map<String, String> r2 = this.traceMap;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        List<UserCreationKmp> r6 = this.creationList;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        List<List<UserCreationKmp>> r9 = this.creationGroupList;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.nextCursor;
        if (r12 == null) goto L23;
        r3 = r12.hashCode();
    L23:
        return r11 + r3;
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "CommonCreationFeedDataKmp(hasMore=" + this.hasMore + ", traceMap=" + this.traceMap + ", creationList=" + this.creationList + ", creationGroupList=" + this.creationGroupList + ", nextCursor=" + this.nextCursor + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeInt(this.hasMore ? 1 : 0);
        Map<String, String> r0 = this.traceMap;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L9:
        List<UserCreationKmp> r1 = this.creationList;
        if (r1 != null) goto L12;
        r6.writeInt(0);
    L16:
        List<List<UserCreationKmp>> r2 = this.creationGroupList;
        if (r2 != null) goto L19;
        r6.writeInt(0);
    L26:
        r6.writeString(this.nextCursor);
        return;
    L19:
        r6.writeInt(1);
        r6.writeInt(r2.size());
        Iterator<List<UserCreationKmp>> r3 = r2.iterator();
    L21:
        if (r3.hasNext() == false) goto L26;
        List<UserCreationKmp> r4 = r3.next();
        r6.writeInt(r4.size());
        Iterator<UserCreationKmp> r5 = r4.iterator();
    L24:
        if (r5.hasNext() == false) goto L21;
        r5.next().writeToParcel(r6, r7);
        goto L24
    L12:
        r6.writeInt(1);
        r6.writeInt(r1.size());
        Iterator<UserCreationKmp> r8 = r1.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r8.next().writeToParcel(r6, r7);
        goto L14
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.size());
        Iterator<Map.Entry<String, String>> r9 = r0.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L9;
        Map.Entry<String, String> r10 = r9.next();
        r6.writeString(r10.getKey());
        r6.writeString(r10.getValue());
        goto L7
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, LazyKt.lazy(r1, new m0a.a()), LazyKt.lazy(r1, new m0a.b()), LazyKt.lazy(r1, new m0a.c()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final List<List<UserCreationKmp>> getCreationGroupList() {
        return this.creationGroupList;
    }

    public final List<UserCreationKmp> getCreationList() {
        return this.creationList;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextCursor() {
        return this.nextCursor;
    }

    public final Map<String, String> getTraceMap() {
        return this.traceMap;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CommonCreationFeedDataKmp r6, muc.d r7, f r8) {
        Lazy<d<Object>>[] r0 = $childSerializers;
        boolean r1 = false;
        if (r7.shouldEncodeElementDefault(r8, 0) == false) goto L6;
    L4:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        r7.encodeBooleanElement(r8, 0, r6.hasMore);
    L12:
        if (r7.shouldEncodeElementDefault(r8, 1) == false) goto L15;
    L13:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L21;
        r7.encodeNullableSerializableElement(r8, 1, (n) r0[1].getValue(), r6.traceMap);
    L21:
        if (r7.shouldEncodeElementDefault(r8, 2) == false) goto L24;
    L22:
        boolean r4 = true;
    L27:
        if (r4 == false) goto L30;
        r7.encodeNullableSerializableElement(r8, 2, (n) r0[2].getValue(), r6.creationList);
    L30:
        if (r7.shouldEncodeElementDefault(r8, 3) == false) goto L33;
    L31:
        boolean r5 = true;
    L36:
        if (r5 == false) goto L39;
        r7.encodeNullableSerializableElement(r8, 3, (n) r0[3].getValue(), r6.creationGroupList);
    L39:
        if (r7.shouldEncodeElementDefault(r8, 4) == false) goto L42;
    L40:
        r1 = true;
    L44:
        if (r1 == false) goto L47;
        r7.encodeNullableSerializableElement(r8, 4, v2.a, r6.nextCursor);
        return;
    L47:
        return;
    L42:
        if (r6.nextCursor == null) goto L44;
    L33:
        if (r6.creationGroupList != null) goto L31;
        r5 = false;
        goto L36
    L24:
        if (r6.creationList != null) goto L22;
        r4 = false;
        goto L27
    L15:
        if (r6.traceMap != null) goto L13;
        r3 = false;
        goto L18
    L6:
        if (r6.hasMore == true) goto L4;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonCreationFeedDataKmp(boolean r1, Map<String, String> r2, List<UserCreationKmp> r3, List<? extends List<UserCreationKmp>> r4, String r5) {
        this.hasMore = r1;
        this.traceMap = r2;
        this.creationList = r3;
        this.creationGroupList = r4;
        this.nextCursor = r5;
    }

    public CommonCreationFeedDataKmp(int r3, boolean r4, Map r5, List r6, List r7, String r8, q2 r9) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.hasMore = false;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.traceMap = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.creationList = null;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.creationGroupList = null;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.nextCursor = null;
        return;
    L23:
        this.nextCursor = r8;
        return;
    L19:
        this.creationGroupList = r7;
        goto L21
    L15:
        this.creationList = r6;
        goto L17
    L11:
        this.traceMap = r5;
        goto L13
    L7:
        this.hasMore = r4;
        goto L9
    }

    public /* synthetic */ CommonCreationFeedDataKmp(boolean r4, Map r5, List r6, List r7, String r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = false;
    L5:
        String r0 = null;
        if ((r9 & 2) == 0) goto L8;
        Map r11 = null;
    L10:
        if ((r9 & 4) == 0) goto L12;
        List r1 = null;
    L14:
        if ((r9 & 8) == 0) goto L16;
        List r2 = null;
    L18:
        if ((r9 & 16) != 0) goto L21;
        r0 = r8;
    L21:
        this(r4, r11, r1, r2, r0);
        return;
    L16:
        r2 = r7;
        goto L18
    L12:
        r1 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L10
    }
}
