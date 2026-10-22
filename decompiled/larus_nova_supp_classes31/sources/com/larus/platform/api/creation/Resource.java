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
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00060\u0001j\u0002`\u0002:\u0002>?BC\u0012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBM\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\"JJ\u0010)\u001a\u00020\u00002\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020\u0004J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0004HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0004J%\u00107\u001a\u0002032\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010 R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\u000b\u0010\"¨\u0006@"}, d2 = {"Lcom/larus/platform/api/creation/Resource;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "resourceType", "", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "videoInfo", "Lcom/larus/platform/api/creation/VideoResource;", "audioInfo", "Lcom/larus/platform/api/creation/AudioResource;", "isAvatar", "", "<init>", "(Ljava/lang/Integer;Lcom/larus/platform/api/ImageInfo;Lcom/larus/platform/api/creation/VideoResource;Lcom/larus/platform/api/creation/AudioResource;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Lcom/larus/platform/api/ImageInfo;Lcom/larus/platform/api/creation/VideoResource;Lcom/larus/platform/api/creation/AudioResource;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResourceType$annotations", "()V", "getResourceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageInfo$annotations", "getImageInfo", "()Lcom/larus/platform/api/ImageInfo;", "getVideoInfo$annotations", "getVideoInfo", "()Lcom/larus/platform/api/creation/VideoResource;", "getAudioInfo$annotations", "getAudioInfo", "()Lcom/larus/platform/api/creation/AudioResource;", "isAvatar$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Lcom/larus/platform/api/ImageInfo;Lcom/larus/platform/api/creation/VideoResource;Lcom/larus/platform/api/creation/AudioResource;Ljava/lang/Boolean;)Lcom/larus/platform/api/creation/Resource;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class Resource implements Parcelable {
    public static final Parcelable.Creator<Resource> CREATOR = null;
    public static final b Companion = null;
    public final Integer a;
    public final ImageInfo b;
    public final VideoResource c;
    public final AudioResource d;
    public final Boolean e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<Resource> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(w0.a), kuc.a.d(ImageInfo.a.a), kuc.a.d(VideoResource.a.a), kuc.a.d(AudioResource.a.a), kuc.a.d(i.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.Resource", r0, 5);
            r1.j("resource_type", true);
            r1.j("image", true);
            r1.j("video", true);
            r1.j("audio", true);
            r1.j("is_avatar", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            Integer r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            Integer r2 = (Integer) r0.decodeNullableSerializableElement(r1, 0, w0.a, null);
            ImageInfo r5 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 1, ImageInfo.a.a, null);
            VideoResource r3 = (VideoResource) r0.decodeNullableSerializableElement(r1, 2, VideoResource.a.a, null);
            AudioResource r6 = (AudioResource) r0.decodeNullableSerializableElement(r1, 3, AudioResource.a.a, null);
            Integer r16 = r2;
            VideoResource r18 = r3;
            Boolean r20 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, i.a, null);
            ImageInfo r17 = r5;
            AudioResource r19 = r6;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new Resource(r15, r16, r17, r18, r19, r20);
        L5:
            ImageInfo r9 = null;
            VideoResource r10 = null;
            AudioResource r11 = null;
            Boolean r12 = null;
            int r4 = 0;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L22;
            int r14 = r0.decodeElementIndex(r1);
            if (r14 != (-1)) goto L9;
            r13 = false;
            goto L6
        L9:
            if (r14 != 0) goto L10;
            r8 = (Integer) r0.decodeNullableSerializableElement(r1, 0, w0.a, r8);
            r4 = r4 | 1;
            goto L6
        L10:
            if (r14 != 1) goto L11;
            r9 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 1, ImageInfo.a.a, r9);
            r4 = r4 | 2;
            goto L6
        L11:
            if (r14 != 2) goto L12;
            r10 = (VideoResource) r0.decodeNullableSerializableElement(r1, 2, VideoResource.a.a, r10);
            r4 = r4 | 4;
            goto L6
        L12:
            if (r14 != 3) goto L13;
            r11 = (AudioResource) r0.decodeNullableSerializableElement(r1, 3, AudioResource.a.a, r11);
            r4 = r4 | 8;
            goto L6
        L13:
            if (r14 != 4) goto L16;
            r12 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, i.a, r12);
            r4 = r4 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r14);
        L22:
            r15 = r4;
            r16 = r8;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            goto L23
        }

        public final void serialize(muc.f r7, Object r8) {
            Resource r9 = (Resource) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = Resource.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == true) goto L10;
            Integer r3 = r9.a;
            if (r3 == null) goto L10;
            if (r3.intValue() != 0) goto L10;
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            r10.encodeNullableSerializableElement(r0, 0, w0.a, r9.a);
        L15:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L18;
        L19:
            boolean r5 = true;
        L21:
            if (r5 == false) goto L24;
            r10.encodeNullableSerializableElement(r0, 1, ImageInfo.a.a, r9.b);
        L24:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L27;
        L28:
            boolean r6 = true;
        L30:
            if (r6 == false) goto L33;
            r10.encodeNullableSerializableElement(r0, 2, VideoResource.a.a, r9.c);
        L33:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L36;
        L37:
            boolean r11 = true;
        L39:
            if (r11 == false) goto L42;
            r10.encodeNullableSerializableElement(r0, 3, AudioResource.a.a, r9.d);
        L42:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L45;
        L46:
            r2 = true;
        L47:
            if (r2 == false) goto L49;
            r10.encodeNullableSerializableElement(r0, 4, i.a, r9.e);
        L49:
            r10.endStructure(r0);
            return;
        L45:
            if (r9.e == null) goto L47;
        L36:
            if (r9.d != null) goto L37;
            r11 = false;
            goto L39
        L27:
            if (r9.c != null) goto L28;
            r6 = false;
            goto L30
        L18:
            if (r9.b != null) goto L19;
            r5 = false;
        L10:
            r4 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final d<Resource> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<Resource> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final Resource createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            if (r8.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            if (r8.readInt() != 0) goto L9;
            ImageInfo r1 = null;
        L10:
            ImageInfo r4 = r1;
            if (r8.readInt() != 0) goto L13;
            VideoResource r2 = null;
        L14:
            VideoResource r5 = r2;
            if (r8.readInt() != 0) goto L17;
            AudioResource r6 = null;
        L18:
            AudioResource r7 = r6;
            if (r8.readInt() != 0) goto L22;
            Boolean r9 = null;
        L27:
            return new Resource(r3, r4, r5, r7, r9);
        L22:
            if (r8.readInt() == 0) goto L24;
            boolean r10 = true;
        L25:
            r9 = Boolean.valueOf(r10);
            goto L27
        L24:
            r10 = false;
            goto L25
        L17:
            r6 = AudioResource.CREATOR.createFromParcel(r8);
            goto L18
        L13:
            r2 = VideoResource.CREATOR.createFromParcel(r8);
            goto L14
        L9:
            r1 = ImageInfo.CREATOR.createFromParcel(r8);
            goto L10
        L5:
            r3 = Integer.valueOf(r8.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Resource[] newArray(int r1) {
            return new Resource[r1];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Resource() {
        Object[] r0 = 0 == true ? 1 : 0;
        Object[] r1 = 0 == true ? 1 : 0;
        this(null, r0, r1, 31);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Resource) == true) goto L8;
        return false;
    L8:
        Resource r6 = (Resource) r5;
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
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ImageInfo r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        VideoResource r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        AudioResource r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.e;
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
        return "Resource(resourceType=" + this.a + ", imageInfo=" + this.b + ", videoInfo=" + this.c + ", audioInfo=" + this.d + ", isAvatar=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        Integer r0 = this.a;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        ImageInfo r1 = this.b;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        VideoResource r2 = this.c;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        AudioResource r3 = this.d;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        Boolean r6 = this.e;
        if (r6 != null) goto L21;
        r4.writeInt(0);
        return;
    L21:
        r4.writeInt(1);
        r4.writeInt(r6.booleanValue() ? 1 : 0);
        return;
    L17:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        goto L18
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
        r4.writeInt(r0.intValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public /* synthetic */ Resource(Integer r7, ImageInfo r8, AudioResource r9, int r10) {
        if ((r10 & 1) == 0) goto L5;
        r7 = 0;
    L5:
        Integer r1 = r7;
        if ((r10 & 2) == 0) goto L8;
        ImageInfo r2 = null;
    L10:
        if ((r10 & 8) == 0) goto L12;
        AudioResource r4 = null;
    L13:
        this(r1, r2, null, r4, null);
        return;
    L12:
        r4 = r9;
        goto L13
    L8:
        r2 = r8;
        goto L10
    }

    public Resource(@CreationResourceType Integer r1, ImageInfo r2, VideoResource r3, AudioResource r4, Boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public Resource(int r4, Integer r5, ImageInfo r6, VideoResource r7, AudioResource r8, Boolean r9) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        r5 = 0;
    L7:
        this.a = r5;
        if ((r4 & 2) != 0) goto L10;
        this.b = null;
    L12:
        if ((r4 & 4) != 0) goto L14;
        this.c = null;
    L16:
        if ((r4 & 8) != 0) goto L18;
        this.d = null;
    L20:
        if ((r4 & 16) != 0) goto L22;
        this.e = null;
        return;
    L22:
        this.e = r9;
        return;
    L18:
        this.d = r8;
        goto L20
    L14:
        this.c = r7;
        goto L16
    L10:
        this.b = r6;
        goto L12
    }
}
