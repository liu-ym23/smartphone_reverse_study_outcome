package com.larus.platform.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00060\u0001j\u0002`\u0002:\u000267B3\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB?\b\u0010\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J5\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\bHÆ\u0001J\u0006\u0010#\u001a\u00020\bJ\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bJ%\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001d¨\u00068"}, d2 = {"Lcom/larus/platform/api/ModifiedUserCreationResponse;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "creationId", "", "content", "Lcom/larus/platform/api/ModifiedUserCreationContent;", "privateStatus", "", "status", "<init>", "(Ljava/lang/String;Lcom/larus/platform/api/ModifiedUserCreationContent;II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/platform/api/ModifiedUserCreationContent;IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreationId$annotations", "()V", "getCreationId", "()Ljava/lang/String;", "getContent$annotations", "getContent", "()Lcom/larus/platform/api/ModifiedUserCreationContent;", "getPrivateStatus$annotations", "getPrivateStatus", "()I", "getStatus$annotations", "getStatus", "setStatus", "(I)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class ModifiedUserCreationResponse implements Parcelable {
    public static final Parcelable.Creator<ModifiedUserCreationResponse> CREATOR = null;
    public static final b Companion = null;
    public final String a;
    public final ModifiedUserCreationContent b;
    public final int c;
    public final int d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<ModifiedUserCreationResponse> {
        public static final a a = null;
        public static final nuc.g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            nuc.w0 r1 = nuc.w0.a;
            return new juc.d[]{kuc.a.d(nuc.v2.a), kuc.a.d(ModifiedUserCreationContent.a.a), r1, r1};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            nuc.g2 r1 = new nuc.g2("com.larus.platform.api.ModifiedUserCreationResponse", r0, 4);
            r1.j("creation_id", true);
            r1.j("content", true);
            r1.j("private_status", true);
            r1.j("status", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return nuc.i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            nuc.g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            String r2 = (String) r0.decodeNullableSerializableElement(r1, 0, nuc.v2.a, null);
            ModifiedUserCreationContent r4 = (ModifiedUserCreationContent) r0.decodeNullableSerializableElement(r1, 1, ModifiedUserCreationContent.a.a, null);
            String r14 = r2;
            int r16 = r0.decodeIntElement(r1, 2);
            ModifiedUserCreationContent r15 = r4;
            int r17 = r0.decodeIntElement(r1, 3);
            int r13 = 15;
        L21:
            r0.endStructure(r1);
            return new ModifiedUserCreationResponse(r13, r14, r15, r16, r17);
        L5:
            String r9 = null;
            ModifiedUserCreationContent r10 = null;
            int r3 = 0;
            int r7 = 0;
            int r8 = 0;
            boolean r11 = true;
        L6:
            if (r11 == false) goto L20;
            int r12 = r0.decodeElementIndex(r1);
            if (r12 != (-1)) goto L9;
            r11 = false;
            goto L6
        L9:
            if (r12 != 0) goto L10;
            r9 = (String) r0.decodeNullableSerializableElement(r1, 0, nuc.v2.a, r9);
            r8 = r8 | 1;
            goto L6
        L10:
            if (r12 != 1) goto L11;
            r10 = (ModifiedUserCreationContent) r0.decodeNullableSerializableElement(r1, 1, ModifiedUserCreationContent.a.a, r10);
            r8 = r8 | 2;
            goto L6
        L11:
            if (r12 != 2) goto L12;
            r3 = r0.decodeIntElement(r1, 2);
            r8 = r8 | 4;
            goto L6
        L12:
            if (r12 != 3) goto L15;
            r7 = r0.decodeIntElement(r1, 3);
            r8 = r8 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r12);
        L20:
            r16 = r3;
            r17 = r7;
            r13 = r8;
            r14 = r9;
            r15 = r10;
            goto L21
        }

        public final void serialize(muc.f r6, Object r7) {
            ModifiedUserCreationResponse r8 = (ModifiedUserCreationResponse) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            nuc.g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = ModifiedUserCreationResponse.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeNullableSerializableElement(r0, 0, nuc.v2.a, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r9.encodeNullableSerializableElement(r0, 1, ModifiedUserCreationContent.a.a, r8.b);
        L21:
            if (r9.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r9.encodeIntElement(r0, 2, r8.c);
        L30:
            if (r9.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            r2 = true;
        L35:
            if (r2 == false) goto L37;
            r9.encodeIntElement(r0, 3, r8.d);
        L37:
            r9.endStructure(r0);
            return;
        L33:
            if (r8.d == 0) goto L35;
        L24:
            if (r8.c != 0) goto L25;
            r5 = false;
            goto L27
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

        public final juc.d<ModifiedUserCreationResponse> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<ModifiedUserCreationResponse> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModifiedUserCreationResponse createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            String r1 = r5.readString();
            if (r5.readInt() != 0) goto L5;
            ModifiedUserCreationContent r2 = null;
        L7:
            return new ModifiedUserCreationResponse(r1, r2, r5.readInt(), r5.readInt());
        L5:
            r2 = ModifiedUserCreationContent.CREATOR.createFromParcel(r5);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ModifiedUserCreationResponse[] newArray(int r1) {
            return new ModifiedUserCreationResponse[r1];
        }
    }

    public ModifiedUserCreationResponse() {
        this(null, null, 0, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ModifiedUserCreationResponse) == true) goto L8;
        return false;
    L8:
        ModifiedUserCreationResponse r6 = (ModifiedUserCreationResponse) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ModifiedUserCreationContent r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.c) * 31) + this.d;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ModifiedUserCreationResponse(creationId=" + this.a + ", content=" + this.b + ", privateStatus=" + this.c + ", status=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        ModifiedUserCreationContent r0 = this.b;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeInt(this.c);
        r3.writeInt(this.d);
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

    public ModifiedUserCreationResponse(String r1, ModifiedUserCreationContent r2, @UserCreationPrivateStatus int r3, @UserCreationStatus int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public ModifiedUserCreationResponse(int r4, String r5, ModifiedUserCreationContent r6, int r7, int r8) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = 0;
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = 0;
        return;
    L19:
        this.d = r8;
        return;
    L15:
        this.c = r7;
        goto L17
    L11:
        this.b = r6;
        goto L13
    L7:
        this.a = r5;
        goto L9
    }
}
