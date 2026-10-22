package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import m0a.p;
import m0a.q;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00060\u0001j\u0002`\u0002:\u000234B;\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004HÆ\u0003JB\u0010\u001e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\rJ\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\rJ%\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R&\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R&\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014¨\u00065"}, d2 = {"Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "refImages", "", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "disablePuzzle", "", "refResources", "Lcom/larus/ugc/feed/api/model/ResourceKmp;", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRefImages$annotations", "()V", "getRefImages", "()Ljava/util/List;", "getDisablePuzzle$annotations", "getDisablePuzzle", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRefResources$annotations", "getRefResources", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)Lcom/larus/ugc/feed/api/model/UserCreationRefContentKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationRefContentKmp implements Parcelable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final int $stable = 0;
    public static final Parcelable.Creator<UserCreationRefContentKmp> CREATOR = null;
    public static final b Companion = null;
    private final Boolean disablePuzzle;
    private final List<ImageInfoKmp> refImages;
    private final List<ResourceKmp> refResources;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationRefContentKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.UserCreationRefContentKmp", r0, 3);
            r1.j("ref_images", true);
            r1.j("disable_puzzle", true);
            r1.j("ref_resources", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            Lazy[] r0 = UserCreationRefContentKmp.access$get$childSerializers$cp();
            return new d[]{kuc.a.d((d) r0[0].getValue()), kuc.a.d(i.a), kuc.a.d((d) r0[2].getValue())};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r18) {
            Intrinsics.checkNotNullParameter(r18, "decoder");
            g2 r1 = b;
            muc.c r0 = r18.beginStructure(r1);
            Lazy[] r2 = UserCreationRefContentKmp.access$get$childSerializers$cp();
            List r7 = null;
            if (r0.decodeSequentially() == false) goto L5;
            List r3 = (List) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), null);
            Boolean r5 = (Boolean) r0.decodeNullableSerializableElement(r1, 1, i.a, null);
            List r15 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), null);
            List r13 = r3;
            Boolean r14 = r5;
            int r12 = 7;
        L19:
            r0.endStructure(r1);
            return new UserCreationRefContentKmp(r12, r13, r14, r15, null);
        L5:
            Boolean r8 = null;
            List r9 = null;
            int r4 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r0.decodeElementIndex(r1);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r7 = (List) r0.decodeNullableSerializableElement(r1, 0, (juc.c) r2[0].getValue(), r7);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r8 = (Boolean) r0.decodeNullableSerializableElement(r1, 1, i.a, r8);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r9 = (List) r0.decodeNullableSerializableElement(r1, 2, (juc.c) r2[2].getValue(), r9);
            r4 = r4 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r12 = r4;
            r13 = r7;
            r14 = r8;
            r15 = r9;
            goto L19
        }

        public final void serialize(muc.f r2, Object r3) {
            UserCreationRefContentKmp r4 = (UserCreationRefContentKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            UserCreationRefContentKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationRefContentKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationRefContentKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationRefContentKmp createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            int r1 = 0;
            ArrayList r2 = null;
            if (r8.readInt() != 0) goto L5;
            ArrayList r3 = null;
        L13:
            if (r8.readInt() != 0) goto L16;
            Boolean r0 = null;
        L21:
            if (r8.readInt() == 0) goto L32;
            int r4 = r8.readInt();
            ArrayList r5 = new ArrayList(r4);
        L24:
            if (r1 == r4) goto L30;
            if (r8.readInt() != 0) goto L28;
            ResourceKmp r6 = null;
        L29:
            r5.add(r6);
            r1 = r1 + 1;
            goto L24
        L28:
            r6 = ResourceKmp.CREATOR.createFromParcel(r8);
            goto L29
        L30:
            r2 = r5;
        L32:
            return new UserCreationRefContentKmp(r3, r0, r2);
        L16:
            if (r8.readInt() == 0) goto L18;
            boolean r7 = true;
        L19:
            r0 = Boolean.valueOf(r7);
            goto L21
        L18:
            r7 = false;
            goto L19
        L5:
            int r9 = r8.readInt();
            r3 = new ArrayList(r9);
            int r10 = 0;
        L6:
            if (r10 == r9) goto L13;
            if (r8.readInt() != 0) goto L10;
            ImageInfoKmp r11 = null;
        L11:
            r3.add(r11);
            r10 = r10 + 1;
            goto L6
        L10:
            r11 = ImageInfoKmp.CREATOR.createFromParcel(r8);
            goto L11
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationRefContentKmp[] newArray(int r1) {
            return new UserCreationRefContentKmp[r1];
        }
    }

    public UserCreationRefContentKmp() {
        this(null, null, null, 7, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(kuc.a.d(ImageInfoKmp.a.a));
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_$0() {
        return new nuc.f(kuc.a.d(ResourceKmp.a.a));
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ d b() {
        return _childSerializers$_anonymous_$0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserCreationRefContentKmp copy$default(UserCreationRefContentKmp r0, List r1, Boolean r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.refImages;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.disablePuzzle;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.refResources;
    L12:
        return r0.copy(r1, r2, r3);
    }

    @SerialName("disable_puzzle")
    public static /* synthetic */ void getDisablePuzzle$annotations() {
    }

    @SerialName("ref_images")
    public static /* synthetic */ void getRefImages$annotations() {
    }

    @SerialName("ref_resources")
    public static /* synthetic */ void getRefResources$annotations() {
    }

    public final List<ImageInfoKmp> component1() {
        return this.refImages;
    }

    public final Boolean component2() {
        return this.disablePuzzle;
    }

    public final List<ResourceKmp> component3() {
        return this.refResources;
    }

    public final UserCreationRefContentKmp copy(List<ImageInfoKmp> r2, Boolean r3, List<ResourceKmp> r4) {
        return new UserCreationRefContentKmp(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationRefContentKmp) == true) goto L8;
        return false;
    L8:
        UserCreationRefContentKmp r6 = (UserCreationRefContentKmp) r5;
        if (Intrinsics.areEqual(this.refImages, r6.refImages) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.disablePuzzle, r6.disablePuzzle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refResources, r6.refResources) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<ImageInfoKmp> r0 = this.refImages;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.disablePuzzle;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<ResourceKmp> r7 = this.refResources;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "UserCreationRefContentKmp(refImages=" + this.refImages + ", disablePuzzle=" + this.disablePuzzle + ", refResources=" + this.refResources + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        List<ImageInfoKmp> r0 = this.refImages;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L12:
        Boolean r1 = this.disablePuzzle;
        if (r1 != null) goto L15;
        r5.writeInt(0);
    L16:
        List<ResourceKmp> r2 = this.refResources;
        if (r2 != null) goto L19;
        r5.writeInt(0);
        return;
    L19:
        r5.writeInt(1);
        r5.writeInt(r2.size());
        Iterator<ResourceKmp> r3 = r2.iterator();
    L21:
        if (r3.hasNext() == false) goto L39;
        ResourceKmp r4 = r3.next();
        if (r4 == null) goto L24;
        r5.writeInt(1);
        r4.writeToParcel(r5, r6);
        goto L21
    L24:
        r5.writeInt(0);
        goto L21
    L39:
        return;
    L15:
        r5.writeInt(1);
        r5.writeInt(r1.booleanValue() ? 1 : 0);
        goto L16
    L5:
        r5.writeInt(1);
        r5.writeInt(r0.size());
        Iterator<ImageInfoKmp> r7 = r0.iterator();
    L7:
        if (r7.hasNext() == false) goto L12;
        ImageInfoKmp r8 = r7.next();
        if (r8 == null) goto L10;
        r5.writeInt(1);
        r8.writeToParcel(r5, r6);
        goto L7
    L10:
        r5.writeInt(0);
        goto L7
    }

    static {
        Companion = new b();
        $stable = 8;
        CREATOR = new c();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{LazyKt.lazy(r1, new p()), null, LazyKt.lazy(r1, new q())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final Boolean getDisablePuzzle() {
        return this.disablePuzzle;
    }

    public final List<ImageInfoKmp> getRefImages() {
        return this.refImages;
    }

    public final List<ResourceKmp> getRefResources() {
        return this.refResources;
    }

    public UserCreationRefContentKmp(List<ImageInfoKmp> r1, Boolean r2, List<ResourceKmp> r3) {
        this.refImages = r1;
        this.disablePuzzle = r2;
        this.refResources = r3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(UserCreationRefContentKmp r5, muc.d r6, f r7) {
        Lazy<d<Object>>[] r0 = $childSerializers;
        boolean r1 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, (n) r0[0].getValue(), r5.refImages);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, i.a, r5.disablePuzzle);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        r1 = true;
    L26:
        if (r1 == false) goto L29;
        r6.encodeNullableSerializableElement(r7, 2, (n) r0[2].getValue(), r5.refResources);
        return;
    L29:
        return;
    L24:
        if (r5.refResources == null) goto L26;
    L15:
        if (r5.disablePuzzle != null) goto L13;
        r3 = false;
        goto L18
    L6:
        if (r5.refImages != null) goto L4;
        r2 = false;
        goto L9
    }

    public UserCreationRefContentKmp(int r2, List r3, Boolean r4, List r5, q2 r6) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.refImages = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.disablePuzzle = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.refResources = null;
        return;
    L15:
        this.refResources = r5;
        return;
    L11:
        this.disablePuzzle = r4;
        goto L13
    L7:
        this.refImages = r3;
        goto L9
    }

    public /* synthetic */ UserCreationRefContentKmp(List r2, Boolean r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
