package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.api.ImageInfo;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import zp9.a0;
import zp9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00060\u0001j\u0002`\u0002:\u000245B;\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004HÆ\u0003JB\u0010\u001f\u001a\u00020\u00002\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\rJ\u0013\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\rHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\rJ%\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R&\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R&\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014¨\u00066"}, d2 = {"Lcom/larus/platform/api/creation/UserCreationRefContent;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "refImages", "", "Lcom/larus/platform/api/ImageInfo;", "disablePuzzle", "", "refResources", "Lcom/larus/platform/api/creation/Resource;", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRefImages$annotations", "()V", "getRefImages", "()Ljava/util/List;", "getDisablePuzzle$annotations", "getDisablePuzzle", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRefResources$annotations", "getRefResources", "getRefImagesV2", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;)Lcom/larus/platform/api/creation/UserCreationRefContent;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationRefContent implements Parcelable {
    public static final Parcelable.Creator<UserCreationRefContent> CREATOR = null;
    public static final b Companion = null;
    public static final Lazy<d<Object>>[] d = null;
    public final List<ImageInfo> a;
    public final Boolean b;
    public final List<Resource> c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationRefContent> {
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
            g2 r1 = new g2("com.larus.platform.api.creation.UserCreationRefContent", r0, 3);
            r1.j("ref_images", true);
            r1.j("disable_puzzle", true);
            r1.j("ref_resources", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            Lazy<d<Object>>[] r0 = UserCreationRefContent.d;
            return new d[]{kuc.a.d((d) r0[0].getValue()), kuc.a.d(i.a), kuc.a.d((d) r0[2].getValue())};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r13) {
            Intrinsics.checkNotNullParameter(r13, "decoder");
            g2 r0 = b;
            muc.c r14 = r13.beginStructure(r0);
            Lazy<d<Object>>[] r1 = UserCreationRefContent.d;
            List r6 = null;
            if (r14.decodeSequentially() == false) goto L5;
            List r2 = (List) r14.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
            Boolean r4 = (Boolean) r14.decodeNullableSerializableElement(r0, 1, i.a, null);
            List r3 = (List) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), null);
            int r5 = 7;
        L19:
            r14.endStructure(r0);
            return new UserCreationRefContent(r5, r2, r4, r3);
        L5:
            Boolean r7 = null;
            List r8 = null;
            int r9 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r14.decodeElementIndex(r0);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r6 = (List) r14.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r6);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (Boolean) r14.decodeNullableSerializableElement(r0, 1, i.a, r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (List) r14.decodeNullableSerializableElement(r0, 2, (juc.c) r1[2].getValue(), r8);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r5 = r9;
            r2 = r6;
            r4 = r7;
            r3 = r8;
            goto L19
        }

        public final void serialize(muc.f r7, Object r8) {
            UserCreationRefContent r9 = (UserCreationRefContent) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            Lazy<d<Object>>[] r1 = UserCreationRefContent.d;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, (n) r1[0].getValue(), r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, i.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r10.encodeNullableSerializableElement(r0, 2, (n) r1[2].getValue(), r9.c);
        L28:
            r10.endStructure(r0);
            return;
        L24:
            if (r9.c == null) goto L26;
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationRefContent> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationRefContent> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationRefContent createFromParcel(Parcel r8) {
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
            Resource r6 = null;
        L29:
            r5.add(r6);
            r1 = r1 + 1;
            goto L24
        L28:
            r6 = Resource.CREATOR.createFromParcel(r8);
            goto L29
        L30:
            r2 = r5;
        L32:
            return new UserCreationRefContent(r3, r0, r2);
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
            ImageInfo r11 = null;
        L11:
            r3.add(r11);
            r10 = r10 + 1;
            goto L6
        L10:
            r11 = ImageInfo.CREATOR.createFromParcel(r8);
            goto L11
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationRefContent[] newArray(int r1) {
            return new UserCreationRefContent[r1];
        }
    }

    public UserCreationRefContent() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationRefContent) == true) goto L8;
        return false;
    L8:
        UserCreationRefContent r6 = (UserCreationRefContent) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<ImageInfo> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<Resource> r7 = this.c;
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

    public final String toString() {
        return "UserCreationRefContent(refImages=" + this.a + ", disablePuzzle=" + this.b + ", refResources=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        List<ImageInfo> r0 = this.a;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L12:
        Boolean r1 = this.b;
        if (r1 != null) goto L15;
        r5.writeInt(0);
    L16:
        List<Resource> r2 = this.c;
        if (r2 != null) goto L19;
        r5.writeInt(0);
        return;
    L19:
        r5.writeInt(1);
        r5.writeInt(r2.size());
        Iterator<Resource> r3 = r2.iterator();
    L21:
        if (r3.hasNext() == false) goto L39;
        Resource r4 = r3.next();
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
        Iterator<ImageInfo> r7 = r0.iterator();
    L7:
        if (r7.hasNext() == false) goto L12;
        ImageInfo r8 = r7.next();
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
        CREATOR = new c();
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.PUBLICATION;
        d = new Lazy[]{LazyKt.lazy(r1, new z()), null, LazyKt.lazy(r1, new a0())};
    }

    public final List<ImageInfo> a() {
        List<Resource> r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L38;
        ArrayList r2 = new ArrayList();
        List<Resource> r3 = this.c;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L23;
        Object r6 = r5.next();
        Resource r7 = (Resource) r6;
        if (r7 == null) goto L20;
        Integer r8 = r7.a;
        if (r8 == null) goto L20;
        if (r8.intValue() != 1) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L11;
        r4.add(r6);
    L20:
        r9 = false;
        goto L21
    L23:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r4.iterator();
    L25:
        if (r11.hasNext() == false) goto L32;
        Resource r12 = (Resource) r11.next();
        if (r12 == null) goto L29;
        ImageInfo r13 = r12.b;
    L30:
        if (r13 == null) goto L25;
        r10.add(r13);
        goto L25
    L29:
        r13 = null;
        goto L30
    L32:
        Iterator r14 = r10.iterator();
    L34:
        if (r14.hasNext() == false) goto L36;
        r2.add((ImageInfo) r14.next());
        goto L34
    L36:
        return r2;
    L38:
        return this.a;
    L5:
        if ((!r0.isEmpty()) != true) goto L7;
        r1 = true;
        goto L8
    }

    public UserCreationRefContent(List<ImageInfo> r1, Boolean r2, List<Resource> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public UserCreationRefContent(int r3, List r4, Boolean r5, List r6) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = null;
        return;
    L15:
        this.c = r6;
        return;
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
