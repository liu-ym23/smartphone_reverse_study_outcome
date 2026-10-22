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
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u0002/0B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0013\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000bJ%\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017¨\u00061"}, d2 = {"Lcom/larus/platform/api/creation/CreationPublishExtra;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "isNewPublish", "", "publicRefImage", "caption", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "isNewPublish$annotations", "()V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPublicRefImage$annotations", "getPublicRefImage", "getCaption$annotations", "getCaption", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/platform/api/creation/CreationPublishExtra;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationPublishExtra implements Parcelable {
    public static final Parcelable.Creator<CreationPublishExtra> CREATOR = null;
    public static final b Companion = null;
    public final Boolean a;
    public final Boolean b;
    public final String c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationPublishExtra> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            i r1 = i.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(v2.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.CreationPublishExtra", r0, 3);
            r1.j("is_new_publish", true);
            r1.j("public_ref_image", true);
            r1.j("caption", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r12) {
            Intrinsics.checkNotNullParameter(r12, "decoder");
            g2 r0 = b;
            muc.c r13 = r12.beginStructure(r0);
            Boolean r5 = null;
            if (r13.decodeSequentially() == false) goto L5;
            i r1 = i.a;
            Boolean r3 = (Boolean) r13.decodeNullableSerializableElement(r0, 0, r1, null);
            Boolean r2 = (Boolean) r13.decodeNullableSerializableElement(r0, 1, r1, null);
            String r4 = (String) r13.decodeNullableSerializableElement(r0, 2, v2.a, null);
            int r6 = 7;
        L19:
            r13.endStructure(r0);
            return new CreationPublishExtra(r6, r3, r2, r4);
        L5:
            Boolean r7 = null;
            String r8 = null;
            int r9 = 0;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L18;
            int r11 = r13.decodeElementIndex(r0);
            if (r11 != (-1)) goto L9;
            r10 = false;
            goto L6
        L9:
            if (r11 != 0) goto L10;
            r5 = (Boolean) r13.decodeNullableSerializableElement(r0, 0, i.a, r5);
            r9 = r9 | 1;
            goto L6
        L10:
            if (r11 != 1) goto L11;
            r7 = (Boolean) r13.decodeNullableSerializableElement(r0, 1, i.a, r7);
            r9 = r9 | 2;
            goto L6
        L11:
            if (r11 != 2) goto L14;
            r8 = (String) r13.decodeNullableSerializableElement(r0, 2, v2.a, r8);
            r9 = r9 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r11);
        L18:
            r6 = r9;
            r3 = r5;
            r2 = r7;
            r4 = r8;
            goto L19
        }

        public final void serialize(muc.f r6, Object r7) {
            CreationPublishExtra r8 = (CreationPublishExtra) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = CreationPublishExtra.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, i.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r9.encodeNullableSerializableElement(r0, 1, i.a, r8.b);
        L21:
            if (r9.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            r2 = true;
        L26:
            if (r2 == false) goto L28;
            r9.encodeNullableSerializableElement(r0, 2, v2.a, r8.c);
        L28:
            r9.endStructure(r0);
            return;
        L24:
            if (r8.c == null) goto L26;
        L15:
            if (r8.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r8.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationPublishExtra> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationPublishExtra> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationPublishExtra createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            boolean r2 = false;
            Boolean r4 = null;
            if (r7.readInt() != 0) goto L6;
            Boolean r1 = null;
        L11:
            if (r7.readInt() == 0) goto L18;
            if (r7.readInt() == 0) goto L16;
            r2 = true;
        L16:
            r4 = Boolean.valueOf(r2);
        L18:
            return new CreationPublishExtra(r1, r4, r7.readString());
        L6:
            if (r7.readInt() == 0) goto L8;
            boolean r3 = true;
        L9:
            r1 = Boolean.valueOf(r3);
            goto L11
        L8:
            r3 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final CreationPublishExtra[] newArray(int r1) {
            return new CreationPublishExtra[r1];
        }
    }

    public CreationPublishExtra() {
        this(null, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationPublishExtra) == true) goto L8;
        return false;
    L8:
        CreationPublishExtra r6 = (CreationPublishExtra) r5;
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
        Boolean r0 = this.a;
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
        String r7 = this.c;
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
        return "CreationPublishExtra(isNewPublish=" + this.a + ", publicRefImage=" + this.b + ", caption=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        Boolean r5 = this.a;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Boolean r6 = this.b;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.c);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.booleanValue() ? 1 : 0);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public /* synthetic */ CreationPublishExtra(Boolean r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(null, r2, null);
    }

    public CreationPublishExtra(Boolean r1, Boolean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public CreationPublishExtra(int r3, Boolean r4, Boolean r5, String r6) {
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
