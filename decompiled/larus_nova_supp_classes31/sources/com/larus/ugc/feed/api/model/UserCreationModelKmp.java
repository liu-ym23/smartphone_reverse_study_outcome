package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import juc.d;
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
import m0a.n;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00060\u0001j\u0002`\u0002:\u000256B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB=\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J1\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010\"\u001a\u00020\u0004J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0004J%\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R,\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00067"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationModelKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "dataType", "", "creationList", "", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "modelId", "", "<init>", "(ILjava/util/List;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDataType$annotations", "()V", "getDataType", "()I", "getCreationList$annotations", "getCreationList", "()Ljava/util/List;", "setCreationList", "(Ljava/util/List;)V", "getModelId$annotations", "getModelId", "()Ljava/lang/String;", "setModelId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationModelKmp implements Parcelable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationModelKmp> CREATOR = null;
    public static final b Companion = null;
    private List<UserCreationKmp> creationList;
    private final int dataType;
    private String modelId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationModelKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.UserCreationModelKmp", r0, 3);
            r1.j("data_type", true);
            r1.j("creation_list", true);
            r1.j("model_id", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            return new d[]{w0.a, kuc.a.d((d) UserCreationModelKmp.access$get$childSerializers$cp()[1].getValue()), kuc.a.d(v2.a)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r18) {
            Intrinsics.checkNotNullParameter(r18, "decoder");
            g2 r1 = b;
            muc.c r0 = r18.beginStructure(r1);
            Lazy[] r2 = UserCreationModelKmp.access$get$childSerializers$cp();
            if (r0.decodeSequentially() == false) goto L5;
            int r3 = r0.decodeIntElement(r1, 0);
            List r14 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), null);
            int r13 = r3;
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, null);
            int r12 = 7;
        L19:
            r0.endStructure(r1);
            return new UserCreationModelKmp(r12, r13, r14, r15, null);
        L5:
            List r8 = null;
            String r9 = null;
            int r4 = 0;
            int r7 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r0.decodeElementIndex(r1);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r4 = r0.decodeIntElement(r1, 0);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r8 = (List) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), r8);
            r7 = r7 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r9);
            r7 = r7 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r13 = r4;
            r12 = r7;
            r14 = r8;
            r15 = r9;
            goto L19
        }

        public final void serialize(muc.f r2, Object r3) {
            UserCreationModelKmp r4 = (UserCreationModelKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            UserCreationModelKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationModelKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationModelKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationModelKmp createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            int r0 = r6.readInt();
            if (r6.readInt() != 0) goto L5;
            ArrayList r1 = null;
        L10:
            return new UserCreationModelKmp(r0, r1, r6.readString());
        L5:
            int r2 = r6.readInt();
            ArrayList r3 = new ArrayList(r2);
            int r4 = 0;
        L6:
            if (r4 == r2) goto L8;
            r3.add(UserCreationKmp.CREATOR.createFromParcel(r6));
            r4 = r4 + 1;
            goto L6
        L8:
            r1 = r3;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationModelKmp[] newArray(int r1) {
            return new UserCreationModelKmp[r1];
        }
    }

    public UserCreationModelKmp() {
        this(0, null, null, 7, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(UserCreationKmp.a.a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserCreationModelKmp copy$default(UserCreationModelKmp r0, int r1, List r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.dataType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.creationList;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.modelId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @SerialName("creation_list")
    public static /* synthetic */ void getCreationList$annotations() {
    }

    @SerialName("data_type")
    public static /* synthetic */ void getDataType$annotations() {
    }

    @SerialName("model_id")
    public static /* synthetic */ void getModelId$annotations() {
    }

    public final int component1() {
        return this.dataType;
    }

    public final List<UserCreationKmp> component2() {
        return this.creationList;
    }

    public final String component3() {
        return this.modelId;
    }

    public final UserCreationModelKmp copy(int r2, List<UserCreationKmp> r3, String r4) {
        return new UserCreationModelKmp(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationModelKmp) == true) goto L8;
        return false;
    L8:
        UserCreationModelKmp r6 = (UserCreationModelKmp) r5;
        if (this.dataType == r6.dataType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationList, r6.creationList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelId, r6.modelId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.dataType * 31;
        List<UserCreationKmp> r1 = this.creationList;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.modelId;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "UserCreationModelKmp(dataType=" + this.dataType + ", creationList=" + this.creationList + ", modelId=" + this.modelId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.dataType);
        List<UserCreationKmp> r0 = this.creationList;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L9:
        r3.writeString(this.modelId);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.size());
        Iterator<UserCreationKmp> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().writeToParcel(r3, r4);
        goto L7
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
        $childSerializers = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new n()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final List<UserCreationKmp> getCreationList() {
        return this.creationList;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final void setCreationList(List<UserCreationKmp> r1) {
        this.creationList = r1;
    }

    public final void setModelId(String r1) {
        this.modelId = r1;
    }

    public UserCreationModelKmp(int r1, List<UserCreationKmp> r2, String r3) {
        this.dataType = r1;
        this.creationList = r2;
        this.modelId = r3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationModelKmp r5, muc.d r6, f r7) {
        Lazy<d<Object>>[] r0 = $childSerializers;
        boolean r1 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        r6.encodeIntElement(r7, 0, r5.dataType);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, (juc.n) r0[1].getValue(), r5.creationList);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        r1 = true;
    L26:
        if (r1 == false) goto L29;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.modelId);
        return;
    L29:
        return;
    L24:
        if (Intrinsics.areEqual(r5.modelId, "") == true) goto L26;
    L15:
        if (Intrinsics.areEqual(r5.creationList, new ArrayList()) == false) goto L13;
        r3 = false;
        goto L18
    L6:
        if (r5.dataType != 0) goto L4;
        r2 = false;
        goto L9
    }

    public UserCreationModelKmp(int r2, int r3, List r4, String r5, q2 r6) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.dataType = 0;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.creationList = new ArrayList();
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.modelId = "";
        return;
    L15:
        this.modelId = r5;
        return;
    L11:
        this.creationList = r4;
        goto L13
    L7:
        this.dataType = r3;
        goto L9
    }

    public /* synthetic */ UserCreationModelKmp(int r1, List r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = new ArrayList();
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = "";
    L11:
        this(r1, r2, r3);
    }
}
