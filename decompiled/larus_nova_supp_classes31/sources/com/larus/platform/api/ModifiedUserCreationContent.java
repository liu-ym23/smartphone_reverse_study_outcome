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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00060\u0001j\u0002`\u0002:\u0002&'B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\bJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bJ%\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006("}, d2 = {"Lcom/larus/platform/api/ModifiedUserCreationContent;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "musicContent", "Lcom/larus/platform/api/ModifiedUserCreationMusic;", "<init>", "(Lcom/larus/platform/api/ModifiedUserCreationMusic;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/ModifiedUserCreationMusic;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMusicContent$annotations", "()V", "getMusicContent", "()Lcom/larus/platform/api/ModifiedUserCreationMusic;", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class ModifiedUserCreationContent implements Parcelable {
    public static final Parcelable.Creator<ModifiedUserCreationContent> CREATOR = null;
    public static final b Companion = null;
    public final ModifiedUserCreationMusic a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<ModifiedUserCreationContent> {
        public static final a a = null;
        public static final nuc.g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(ModifiedUserCreationMusic.a.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            nuc.g2 r1 = new nuc.g2("com.larus.platform.api.ModifiedUserCreationContent", r0, 1);
            r1.j("music_content", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return nuc.i2.a;
        }

        public final Object deserialize(muc.e r8) {
            Intrinsics.checkNotNullParameter(r8, "decoder");
            nuc.g2 r0 = b;
            muc.c r9 = r8.beginStructure(r0);
            int r2 = 1;
            ModifiedUserCreationMusic r4 = null;
            if (r9.decodeSequentially() == false) goto L5;
            ModifiedUserCreationMusic r1 = (ModifiedUserCreationMusic) r9.decodeNullableSerializableElement(r0, 0, ModifiedUserCreationMusic.a.a, null);
        L15:
            r9.endStructure(r0);
            return new ModifiedUserCreationContent(r2, r1);
        L5:
            int r3 = 0;
        L6:
            if (r2 == 0) goto L14;
            int r5 = r9.decodeElementIndex(r0);
            if (r5 != (-1)) goto L9;
            r2 = 0;
            goto L6
        L9:
            if (r5 != 0) goto L12;
            r4 = (ModifiedUserCreationMusic) r9.decodeNullableSerializableElement(r0, 0, ModifiedUserCreationMusic.a.a, r4);
            r3 = r3 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r5);
        L14:
            r2 = r3;
            r1 = r4;
            goto L15
        }

        public final void serialize(muc.f r4, Object r5) {
            ModifiedUserCreationContent r6 = (ModifiedUserCreationContent) r5;
            Intrinsics.checkNotNullParameter(r4, "encoder");
            Intrinsics.checkNotNullParameter(r6, "value");
            nuc.g2 r0 = b;
            muc.d r7 = r4.beginStructure(r0);
            b r1 = ModifiedUserCreationContent.Companion;
            if (r7.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            r7.encodeNullableSerializableElement(r0, 0, ModifiedUserCreationMusic.a.a, r6.a);
        L11:
            r7.endStructure(r0);
            return;
        L6:
            if (r6.a != null) goto L7;
            r2 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<ModifiedUserCreationContent> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<ModifiedUserCreationContent> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModifiedUserCreationContent createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            if (r3.readInt() != 0) goto L5;
            ModifiedUserCreationMusic r4 = null;
        L7:
            return new ModifiedUserCreationContent(r4);
        L5:
            r4 = ModifiedUserCreationMusic.CREATOR.createFromParcel(r3);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ModifiedUserCreationContent[] newArray(int r1) {
            return new ModifiedUserCreationContent[r1];
        }
    }

    public ModifiedUserCreationContent() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ModifiedUserCreationContent) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((ModifiedUserCreationContent) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        ModifiedUserCreationMusic r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "ModifiedUserCreationContent(musicContent=" + this.a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        ModifiedUserCreationMusic r0 = this.a;
        if (r0 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r0.writeToParcel(r3, r4);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public ModifiedUserCreationContent(ModifiedUserCreationMusic r1) {
        this.a = r1;
    }

    public ModifiedUserCreationContent(int r3, ModifiedUserCreationMusic r4) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
        return;
    L7:
        this.a = r4;
    }
}
