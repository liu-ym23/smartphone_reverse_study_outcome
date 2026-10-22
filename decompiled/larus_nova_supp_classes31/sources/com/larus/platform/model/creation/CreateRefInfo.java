package com.larus.platform.model.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
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
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00060\u0001j\u0002`\u0002:\u0002&'B%\u0012\u001c\b\u0002\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bB+\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\u001c\b\u0002\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nJ%\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R%\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006("}, d2 = {"Lcom/larus/platform/model/creation/CreateRefInfo;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "refResourceList", "Ljava/util/ArrayList;", "Lcom/larus/platform/model/creation/ResourceExt;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/ArrayList;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRefResourceList", "()Ljava/util/ArrayList;", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreateRefInfo implements Parcelable {
    public static final Parcelable.Creator<CreateRefInfo> CREATOR = null;
    public static final b Companion = null;
    public static final Lazy<d<Object>>[] b = null;
    public final ArrayList<ResourceExt> a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreateRefInfo> {
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
            g2 r1 = new g2("com.larus.platform.model.creation.CreateRefInfo", r0, 1);
            r1.j("refResourceList", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d((d) CreateRefInfo.b[0].getValue())};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r9) {
            Intrinsics.checkNotNullParameter(r9, "decoder");
            g2 r0 = b;
            muc.c r10 = r9.beginStructure(r0);
            Lazy<d<Object>>[] r1 = CreateRefInfo.b;
            int r3 = 1;
            ArrayList r5 = null;
            if (r10.decodeSequentially() == false) goto L5;
            ArrayList r2 = (ArrayList) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
        L15:
            r10.endStructure(r0);
            return new CreateRefInfo(r3, r2);
        L5:
            int r4 = 0;
        L6:
            if (r3 == 0) goto L14;
            int r6 = r10.decodeElementIndex(r0);
            if (r6 != (-1)) goto L9;
            r3 = 0;
            goto L6
        L9:
            if (r6 != 0) goto L12;
            r5 = (ArrayList) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r5);
            r4 = r4 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r6);
        L14:
            r3 = r4;
            r2 = r5;
            goto L15
        }

        public final void serialize(muc.f r6, Object r7) {
            CreateRefInfo r8 = (CreateRefInfo) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            Lazy<d<Object>>[] r1 = CreateRefInfo.b;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L11;
            r9.encodeNullableSerializableElement(r0, 0, (n) r1[0].getValue(), r8.a);
        L11:
            r9.endStructure(r0);
            return;
        L6:
            if (Intrinsics.areEqual(r8.a, new ArrayList()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreateRefInfo> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreateRefInfo> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreateRefInfo createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            if (r5.readInt() != 0) goto L5;
            ArrayList r6 = null;
        L10:
            return new CreateRefInfo(r6);
        L5:
            int r0 = r5.readInt();
            ArrayList r1 = new ArrayList(r0);
            int r2 = 0;
        L6:
            if (r2 == r0) goto L8;
            r1.add(ResourceExt.CREATOR.createFromParcel(r5));
            r2 = r2 + 1;
            goto L6
        L8:
            r6 = r1;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final CreateRefInfo[] newArray(int r1) {
            return new CreateRefInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CreateRefInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((CreateRefInfo) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        ArrayList<ResourceExt> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "CreateRefInfo(refResourceList=" + this.a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        ArrayList<ResourceExt> r0 = this.a;
        if (r0 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.size());
        Iterator<ResourceExt> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        r1.next().writeToParcel(r3, r4);
        goto L7
    }

    static {
        Companion = new b();
        CREATOR = new c();
        b = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new sq9.b())};
    }

    public CreateRefInfo() {
        this(new ArrayList());
    }

    public CreateRefInfo(ArrayList<ResourceExt> r1) {
        this.a = r1;
    }

    public CreateRefInfo(int r2, ArrayList r3) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.a = new ArrayList();
        return;
    L7:
        this.a = r3;
    }
}
