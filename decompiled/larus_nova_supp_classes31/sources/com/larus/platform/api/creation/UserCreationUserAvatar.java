package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.api.ImageInfo;
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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00060\u0001j\u0002`\u0002:\u00029:BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010&\u001a\u00020\u000eJ\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u000eHÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000eJ%\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u001d¨\u0006;"}, d2 = {"Lcom/larus/platform/api/creation/UserCreationUserAvatar;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "displayContent", "", "prompt", "ratio", "Lcom/larus/platform/api/creation/OptionItem;", "model", "<init>", "(Lcom/larus/platform/api/ImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/ImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageInfo$annotations", "()V", "getImageInfo", "()Lcom/larus/platform/api/ImageInfo;", "getDisplayContent$annotations", "getDisplayContent", "()Ljava/lang/String;", "getPrompt$annotations", "getPrompt", "getRatio$annotations", "getRatio", "()Lcom/larus/platform/api/creation/OptionItem;", "getModel$annotations", "getModel", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationUserAvatar implements Parcelable {
    public static final Parcelable.Creator<UserCreationUserAvatar> CREATOR = null;
    public static final b Companion = null;
    public final ImageInfo a;
    public final String b;
    public final String c;
    public final OptionItem d;
    public final OptionItem e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationUserAvatar> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            OptionItem.a r2 = OptionItem.a.a;
            return new d[]{kuc.a.d(ImageInfo.a.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.UserCreationUserAvatar", r0, 5);
            r1.j("image_info", true);
            r1.j("display_content", true);
            r1.j("prompt", true);
            r1.j("ratio", true);
            r1.j("model", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            ImageInfo r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            ImageInfo r2 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 0, ImageInfo.a.a, null);
            v2 r5 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r5, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r5, null);
            OptionItem.a r7 = OptionItem.a.a;
            OptionItem r9 = (OptionItem) r0.decodeNullableSerializableElement(r1, 3, r7, null);
            ImageInfo r16 = r2;
            String r18 = r3;
            OptionItem r20 = (OptionItem) r0.decodeNullableSerializableElement(r1, 4, r7, null);
            String r17 = r6;
            OptionItem r19 = r9;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new UserCreationUserAvatar(r15, r16, r17, r18, r19, r20);
        L5:
            String r10 = null;
            String r11 = null;
            OptionItem r12 = null;
            OptionItem r13 = null;
            int r4 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L22;
            int r110 = r0.decodeElementIndex(r1);
            if (r110 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r110 != 0) goto L10;
            r8 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 0, ImageInfo.a.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r110 != 1) goto L11;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r10);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r110 != 2) goto L12;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r11);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r110 != 3) goto L13;
            r12 = (OptionItem) r0.decodeNullableSerializableElement(r1, 3, OptionItem.a.a, r12);
            r4 = r4 | 8;
            goto L6
        L13:
            if (r110 != 4) goto L16;
            r13 = (OptionItem) r0.decodeNullableSerializableElement(r1, 4, OptionItem.a.a, r13);
            r4 = r4 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r110);
        L22:
            r15 = r4;
            r16 = r8;
            r17 = r10;
            r18 = r11;
            r19 = r12;
            r20 = r13;
            goto L23
        }

        public final void serialize(muc.f r7, Object r8) {
            UserCreationUserAvatar r9 = (UserCreationUserAvatar) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = UserCreationUserAvatar.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, ImageInfo.a.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, v2.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, OptionItem.a.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            r2 = true;
        L44:
            if (r2 == false) goto L46;
            r10.encodeNullableSerializableElement(r0, 4, OptionItem.a.a, r9.e);
        L46:
            r10.endStructure(r0);
            return;
        L42:
            if (r9.e == null) goto L44;
        L33:
            if (r9.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r9.c != null) goto L25;
            r5 = false;
            goto L27
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

        public final d<UserCreationUserAvatar> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationUserAvatar> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationUserAvatar createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            OptionItem r2 = null;
            if (r8.readInt() != 0) goto L5;
            ImageInfo r1 = null;
        L6:
            ImageInfo r3 = r1;
            String r4 = r8.readString();
            String r5 = r8.readString();
            if (r8.readInt() != 0) goto L9;
            OptionItem r6 = null;
        L10:
            OptionItem r7 = r6;
            if (r8.readInt() == 0) goto L15;
            r2 = OptionItem.CREATOR.createFromParcel(r8);
        L15:
            return new UserCreationUserAvatar(r3, r4, r5, r7, r2);
        L9:
            r6 = OptionItem.CREATOR.createFromParcel(r8);
            goto L10
        L5:
            r1 = ImageInfo.CREATOR.createFromParcel(r8);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationUserAvatar[] newArray(int r1) {
            return new UserCreationUserAvatar[r1];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserCreationUserAvatar() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 31);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationUserAvatar) == true) goto L8;
        return false;
    L8:
        UserCreationUserAvatar r6 = (UserCreationUserAvatar) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        ImageInfo r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        OptionItem r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        OptionItem r13 = this.e;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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

    public final String toString() {
        return "UserCreationUserAvatar(imageInfo=" + this.a + ", displayContent=" + this.b + ", prompt=" + this.c + ", ratio=" + this.d + ", model=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        ImageInfo r0 = this.a;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        r4.writeString(this.b);
        r4.writeString(this.c);
        OptionItem r1 = this.d;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        OptionItem r2 = this.e;
        if (r2 != null) goto L13;
        r4.writeInt(0);
        return;
    L13:
        r4.writeInt(1);
        r2.writeToParcel(r4, r5);
        return;
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        goto L10
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public static UserCreationUserAvatar a(UserCreationUserAvatar r6, ImageInfo r7) {
        return new UserCreationUserAvatar(r7, r6.b, r6.c, r6.d, r6.e);
    }

    public /* synthetic */ UserCreationUserAvatar(ImageInfo r9, String r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        ImageInfo r3 = null;
    L7:
        if ((r11 & 4) == 0) goto L9;
        String r5 = null;
    L10:
        this(r3, null, r5, null, null);
        return;
    L9:
        r5 = r10;
        goto L10
    L5:
        r3 = r9;
        goto L7
    }

    public UserCreationUserAvatar(ImageInfo r1, String r2, String r3, OptionItem r4, OptionItem r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public UserCreationUserAvatar(int r3, ImageInfo r4, String r5, String r6, OptionItem r7, OptionItem r8) {
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
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.e = null;
        return;
    L23:
        this.e = r8;
        return;
    L19:
        this.d = r7;
        goto L21
    L15:
        this.c = r6;
        goto L17
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
