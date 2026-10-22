package com.larus.platform.model.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.api.creation.Resource;
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
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0002()B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\nJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nJ%\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/platform/model/creation/ResourceExt;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "resource", "Lcom/larus/platform/api/creation/Resource;", "coverImageUrl", "", "<init>", "(Lcom/larus/platform/api/creation/Resource;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/creation/Resource;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResource", "()Lcom/larus/platform/api/creation/Resource;", "getCoverImageUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class ResourceExt implements Parcelable {
    public static final Parcelable.Creator<ResourceExt> CREATOR = null;
    public static final b Companion = null;
    public final Resource a;
    public final String b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ResourceExt> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(Resource.a.a), kuc.a.d(v2.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.model.creation.ResourceExt", r0, 2);
            r1.j("resource", true);
            r1.j("coverImageUrl", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            String r4 = null;
            if (r11.decodeSequentially() == false) goto L5;
            Resource r1 = (Resource) r11.decodeNullableSerializableElement(r0, 0, Resource.a.a, null);
            String r2 = (String) r11.decodeNullableSerializableElement(r0, 1, v2.a, null);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new ResourceExt(r3, r1, r2);
        L5:
            Resource r5 = null;
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
            r5 = (Resource) r11.decodeNullableSerializableElement(r0, 0, Resource.a.a, r5);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r8 != 1) goto L13;
            r4 = (String) r11.decodeNullableSerializableElement(r0, 1, v2.a, r4);
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
            ResourceExt r8 = (ResourceExt) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = ResourceExt.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, Resource.a.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeNullableSerializableElement(r0, 1, v2.a, r8.b);
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

        public final d<ResourceExt> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<ResourceExt> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceExt createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            if (r3.readInt() != 0) goto L5;
            Resource r1 = null;
        L7:
            return new ResourceExt(r1, r3.readString());
        L5:
            r1 = Resource.CREATOR.createFromParcel(r3);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceExt[] newArray(int r1) {
            return new ResourceExt[r1];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceExt() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceExt) == true) goto L8;
        return false;
    L8:
        ResourceExt r6 = (ResourceExt) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Resource r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceExt(resource=" + this.a + ", coverImageUrl=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        Resource r0 = this.a;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.b);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public ResourceExt(Resource r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public ResourceExt(int r3, Resource r4, String r5) {
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

    public /* synthetic */ ResourceExt(Resource r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        this(r3, r4);
    }
}
