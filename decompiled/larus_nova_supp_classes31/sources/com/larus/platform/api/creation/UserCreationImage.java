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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0002=>BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003JQ\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010*\u001a\u00020\u000fJ\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u000fHÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000fJ%\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u001e¨\u0006?"}, d2 = {"Lcom/larus/platform/api/creation/UserCreationImage;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "displayContent", "", "prompt", "ratio", "Lcom/larus/platform/api/creation/OptionItem;", "styles", "model", "<init>", "(Lcom/larus/platform/api/ImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/ImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageInfo$annotations", "()V", "getImageInfo", "()Lcom/larus/platform/api/ImageInfo;", "getDisplayContent$annotations", "getDisplayContent", "()Ljava/lang/String;", "getPrompt$annotations", "getPrompt", "getRatio$annotations", "getRatio", "()Lcom/larus/platform/api/creation/OptionItem;", "getStyles$annotations", "getStyles", "getModel$annotations", "getModel", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class UserCreationImage implements Parcelable {
    public static final Parcelable.Creator<UserCreationImage> CREATOR = null;
    public static final b Companion = null;
    public final ImageInfo a;
    public final String b;
    public final String c;
    public final OptionItem d;
    public final OptionItem e;
    public final OptionItem f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationImage> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            OptionItem.a r2 = OptionItem.a.a;
            return new d[]{kuc.a.d(ImageInfo.a.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.UserCreationImage", r0, 6);
            r1.j("image_info", true);
            r1.j("display_content", true);
            r1.j("prompt", true);
            r1.j("ratio", true);
            r1.j(TplTagType.STYLE, true);
            r1.j("model", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r18) {
            Intrinsics.checkNotNullParameter(r18, "decoder");
            g2 r1 = b;
            muc.c r0 = r18.beginStructure(r1);
            int r3 = 2;
            OptionItem r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            ImageInfo r2 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 0, ImageInfo.a.a, null);
            v2 r7 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r7, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 2, r7, null);
            OptionItem.a r8 = OptionItem.a.a;
            OptionItem r10 = (OptionItem) r0.decodeNullableSerializableElement(r1, 3, r8, null);
            ImageInfo r11 = r2;
            String r12 = r4;
            OptionItem r14 = (OptionItem) r0.decodeNullableSerializableElement(r1, 4, r8, null);
            OptionItem r15 = (OptionItem) r0.decodeNullableSerializableElement(r1, 5, r8, null);
            String r13 = r6;
            OptionItem r16 = r10;
            int r17 = 63;
        L21:
            r0.endStructure(r1);
            return new UserCreationImage(r17, r11, r13, r12, r16, r14, r15);
        L5:
            r11 = null;
            OptionItem r19 = null;
            r12 = null;
            String r110 = null;
            r14 = null;
            int r5 = 0;
            boolean r111 = true;
        L6:
            if (r111 == false) goto L20;
            int r20 = r0.decodeElementIndex(r1);
            switch(r20) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r20);
        L19:
            r3 = 2;
            r111 = false;
            goto L6
        L11:
            r9 = (OptionItem) r0.decodeNullableSerializableElement(r1, 5, OptionItem.a.a, r9);
            r5 = r5 | 32;
        L18:
            r3 = 2;
            goto L6
        L12:
            r14 = (OptionItem) r0.decodeNullableSerializableElement(r1, 4, OptionItem.a.a, r14);
            r5 = r5 | 16;
            goto L18
        L13:
            r19 = (OptionItem) r0.decodeNullableSerializableElement(r1, 3, OptionItem.a.a, r19);
            r5 = r5 | 8;
            goto L18
        L14:
            r12 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r12);
            r5 = r5 | 4;
            goto L18
        L15:
            r110 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r110);
            r5 = r5 | 2;
            goto L18
        L17:
            r5 = r5 | 1;
            r11 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 0, ImageInfo.a.a, r11);
            goto L18
        L20:
            r15 = r9;
            r17 = r5;
            String r112 = r110;
            r16 = r19;
            r13 = r112;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            UserCreationImage r9 = (UserCreationImage) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = UserCreationImage.Companion;
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
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, OptionItem.a.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            r2 = true;
        L53:
            if (r2 == false) goto L55;
            r10.encodeNullableSerializableElement(r0, 5, OptionItem.a.a, r9.f);
        L55:
            r10.endStructure(r0);
            return;
        L51:
            if (r9.f == null) goto L53;
        L42:
            if (r9.e != null) goto L43;
            r11 = false;
            goto L45
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

        public final d<UserCreationImage> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationImage> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationImage createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            OptionItem r2 = null;
            if (r9.readInt() != 0) goto L5;
            ImageInfo r1 = null;
        L6:
            ImageInfo r3 = r1;
            String r4 = r9.readString();
            String r5 = r9.readString();
            if (r9.readInt() != 0) goto L9;
            OptionItem r6 = null;
        L10:
            OptionItem r7 = r6;
            if (r9.readInt() != 0) goto L13;
            OptionItem r8 = null;
        L14:
            OptionItem r10 = r8;
            if (r9.readInt() == 0) goto L19;
            r2 = OptionItem.CREATOR.createFromParcel(r9);
        L19:
            return new UserCreationImage(r3, r4, r5, r7, r10, r2);
        L13:
            r8 = OptionItem.CREATOR.createFromParcel(r9);
            goto L14
        L9:
            r6 = OptionItem.CREATOR.createFromParcel(r9);
            goto L10
        L5:
            r1 = ImageInfo.CREATOR.createFromParcel(r9);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationImage[] newArray(int r1) {
            return new UserCreationImage[r1];
        }
    }

    public UserCreationImage() {
        this(null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserCreationImage) == true) goto L8;
        return false;
    L8:
        UserCreationImage r6 = (UserCreationImage) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
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
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        OptionItem r16 = this.f;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
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
        return "UserCreationImage(imageInfo=" + this.a + ", displayContent=" + this.b + ", prompt=" + this.c + ", ratio=" + this.d + ", styles=" + this.e + ", model=" + this.f + ')';
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
    L14:
        OptionItem r3 = this.f;
        if (r3 != null) goto L17;
        r4.writeInt(0);
        return;
    L17:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        return;
    L13:
        r4.writeInt(1);
        r2.writeToParcel(r4, r5);
        goto L14
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

    public static UserCreationImage a(UserCreationImage r7, ImageInfo r8) {
        return new UserCreationImage(r8, r7.b, r7.c, r7.d, r7.e, r7.f);
    }

    public UserCreationImage(ImageInfo r1, String r2, String r3, OptionItem r4, OptionItem r5, OptionItem r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public UserCreationImage(int r3, ImageInfo r4, String r5, String r6, OptionItem r7, OptionItem r8, OptionItem r9) {
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
    L25:
        if ((r3 & 32) != 0) goto L27;
        this.f = null;
        return;
    L27:
        this.f = r9;
        return;
    L23:
        this.e = r8;
        goto L25
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
