package com.larus.ugc.feed.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0002=>BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBK\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010!JH\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u0004J\u0013\u0010+\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004J%\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u001fR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b \u0010\u0014\u001a\u0004\b\u000b\u0010!¨\u0006?"}, d2 = {"Lcom/larus/ugc/feed/api/model/ResourceKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "resourceType", "", "imageInfo", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "videoInfo", "Lcom/larus/ugc/feed/api/model/VideoResourceKmp;", "audioInfo", "Lcom/larus/ugc/feed/api/model/AudioResourceKmp;", "isAvatar", "", "<init>", "(ILcom/larus/ugc/feed/api/model/ImageInfoKmp;Lcom/larus/ugc/feed/api/model/VideoResourceKmp;Lcom/larus/ugc/feed/api/model/AudioResourceKmp;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILcom/larus/ugc/feed/api/model/ImageInfoKmp;Lcom/larus/ugc/feed/api/model/VideoResourceKmp;Lcom/larus/ugc/feed/api/model/AudioResourceKmp;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResourceType$annotations", "()V", "getResourceType", "()I", "getImageInfo$annotations", "getImageInfo", "()Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "getVideoInfo$annotations", "getVideoInfo", "()Lcom/larus/ugc/feed/api/model/VideoResourceKmp;", "getAudioInfo$annotations", "getAudioInfo", "()Lcom/larus/ugc/feed/api/model/AudioResourceKmp;", "isAvatar$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(ILcom/larus/ugc/feed/api/model/ImageInfoKmp;Lcom/larus/ugc/feed/api/model/VideoResourceKmp;Lcom/larus/ugc/feed/api/model/AudioResourceKmp;Ljava/lang/Boolean;)Lcom/larus/ugc/feed/api/model/ResourceKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class ResourceKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<ResourceKmp> CREATOR = null;
    public static final b Companion = null;
    private final AudioResourceKmp audioInfo;
    private final ImageInfoKmp imageInfo;
    private final Boolean isAvatar;
    private final int resourceType;
    private final VideoResourceKmp videoInfo;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ResourceKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            return new d[]{w0.a, kuc.a.d(ImageInfoKmp.a.a), kuc.a.d(VideoResourceKmp.a.a), kuc.a.d(AudioResourceKmp.a.a), kuc.a.d(i.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.ResourceKmp", r0, 5);
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

        public final Object deserialize(e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            int r2 = r0.decodeIntElement(r1, 0);
            ImageInfoKmp r5 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 1, ImageInfoKmp.a.a, null);
            VideoResourceKmp r3 = (VideoResourceKmp) r0.decodeNullableSerializableElement(r1, 2, VideoResourceKmp.a.a, null);
            AudioResourceKmp r6 = (AudioResourceKmp) r0.decodeNullableSerializableElement(r1, 3, AudioResourceKmp.a.a, null);
            int r16 = r2;
            VideoResourceKmp r18 = r3;
            Boolean r20 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, i.a, null);
            ImageInfoKmp r17 = r5;
            AudioResourceKmp r19 = r6;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new ResourceKmp(r15, r16, r17, r18, r19, r20, null);
        L5:
            ImageInfoKmp r9 = null;
            VideoResourceKmp r10 = null;
            AudioResourceKmp r11 = null;
            Boolean r12 = null;
            int r4 = 0;
            int r8 = 0;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L22;
            int r14 = r0.decodeElementIndex(r1);
            if (r14 != (-1)) goto L9;
            r13 = false;
            goto L6
        L9:
            if (r14 != 0) goto L10;
            r4 = r0.decodeIntElement(r1, 0);
            r8 = r8 | 1;
            goto L6
        L10:
            if (r14 != 1) goto L11;
            r9 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 1, ImageInfoKmp.a.a, r9);
            r8 = r8 | 2;
            goto L6
        L11:
            if (r14 != 2) goto L12;
            r10 = (VideoResourceKmp) r0.decodeNullableSerializableElement(r1, 2, VideoResourceKmp.a.a, r10);
            r8 = r8 | 4;
            goto L6
        L12:
            if (r14 != 3) goto L13;
            r11 = (AudioResourceKmp) r0.decodeNullableSerializableElement(r1, 3, AudioResourceKmp.a.a, r11);
            r8 = r8 | 8;
            goto L6
        L13:
            if (r14 != 4) goto L16;
            r12 = (Boolean) r0.decodeNullableSerializableElement(r1, 4, i.a, r12);
            r8 = r8 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r14);
        L22:
            r16 = r4;
            r15 = r8;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            goto L23
        }

        public final void serialize(muc.f r2, Object r3) {
            ResourceKmp r4 = (ResourceKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            ResourceKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ResourceKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<ResourceKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceKmp createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            int r2 = r8.readInt();
            if (r8.readInt() != 0) goto L5;
            ImageInfoKmp r1 = null;
        L6:
            ImageInfoKmp r4 = r1;
            if (r8.readInt() != 0) goto L9;
            VideoResourceKmp r3 = null;
        L10:
            VideoResourceKmp r5 = r3;
            if (r8.readInt() != 0) goto L13;
            AudioResourceKmp r6 = null;
        L14:
            AudioResourceKmp r7 = r6;
            if (r8.readInt() != 0) goto L18;
            Boolean r9 = null;
        L23:
            return new ResourceKmp(r2, r4, r5, r7, r9);
        L18:
            if (r8.readInt() == 0) goto L20;
            boolean r10 = true;
        L21:
            r9 = Boolean.valueOf(r10);
            goto L23
        L20:
            r10 = false;
            goto L21
        L13:
            r6 = AudioResourceKmp.CREATOR.createFromParcel(r8);
            goto L14
        L9:
            r3 = VideoResourceKmp.CREATOR.createFromParcel(r8);
            goto L10
        L5:
            r1 = ImageInfoKmp.CREATOR.createFromParcel(r8);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceKmp[] newArray(int r1) {
            return new ResourceKmp[r1];
        }
    }

    public ResourceKmp() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ResourceKmp copy$default(ResourceKmp r3, int r4, ImageInfoKmp r5, VideoResourceKmp r6, AudioResourceKmp r7, Boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.resourceType;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.imageInfo;
    L8:
        ImageInfoKmp r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.videoInfo;
    L11:
        VideoResourceKmp r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.audioInfo;
    L14:
        AudioResourceKmp r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isAvatar;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    @SerialName("audio")
    public static /* synthetic */ void getAudioInfo$annotations() {
    }

    @SerialName("image")
    public static /* synthetic */ void getImageInfo$annotations() {
    }

    @SerialName("resource_type")
    public static /* synthetic */ void getResourceType$annotations() {
    }

    @SerialName("video")
    public static /* synthetic */ void getVideoInfo$annotations() {
    }

    @SerialName("is_avatar")
    public static /* synthetic */ void isAvatar$annotations() {
    }

    public final int component1() {
        return this.resourceType;
    }

    public final ImageInfoKmp component2() {
        return this.imageInfo;
    }

    public final VideoResourceKmp component3() {
        return this.videoInfo;
    }

    public final AudioResourceKmp component4() {
        return this.audioInfo;
    }

    public final Boolean component5() {
        return this.isAvatar;
    }

    public final ResourceKmp copy(int r8, ImageInfoKmp r9, VideoResourceKmp r10, AudioResourceKmp r11, Boolean r12) {
        return new ResourceKmp(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceKmp) == true) goto L8;
        return false;
    L8:
        ResourceKmp r6 = (ResourceKmp) r5;
        if (this.resourceType == r6.resourceType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageInfo, r6.imageInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.videoInfo, r6.videoInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.audioInfo, r6.audioInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isAvatar, r6.isAvatar) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.resourceType * 31;
        ImageInfoKmp r1 = this.imageInfo;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        VideoResourceKmp r5 = this.videoInfo;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        AudioResourceKmp r8 = this.audioInfo;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.isAvatar;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ResourceKmp(resourceType=" + this.resourceType + ", imageInfo=" + this.imageInfo + ", videoInfo=" + this.videoInfo + ", audioInfo=" + this.audioInfo + ", isAvatar=" + this.isAvatar + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeInt(this.resourceType);
        ImageInfoKmp r0 = this.imageInfo;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        VideoResourceKmp r1 = this.videoInfo;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        AudioResourceKmp r2 = this.audioInfo;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        Boolean r6 = this.isAvatar;
        if (r6 != null) goto L17;
        r4.writeInt(0);
        return;
    L17:
        r4.writeInt(1);
        r4.writeInt(r6.booleanValue() ? 1 : 0);
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
        $stable = 8;
        CREATOR = new c();
    }

    public final AudioResourceKmp getAudioInfo() {
        return this.audioInfo;
    }

    public final ImageInfoKmp getImageInfo() {
        return this.imageInfo;
    }

    public final int getResourceType() {
        return this.resourceType;
    }

    public final VideoResourceKmp getVideoInfo() {
        return this.videoInfo;
    }

    public final Boolean isAvatar() {
        return this.isAvatar;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(ResourceKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeIntElement(r7, 0, r5.resourceType);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, ImageInfoKmp.a.a, r5.imageInfo);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, VideoResourceKmp.a.a, r5.videoInfo);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, AudioResourceKmp.a.a, r5.audioInfo);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        r0 = true;
    L44:
        if (r0 == false) goto L47;
        r6.encodeNullableSerializableElement(r7, 4, i.a, r5.isAvatar);
        return;
    L47:
        return;
    L42:
        if (r5.isAvatar == null) goto L44;
    L33:
        if (r5.audioInfo != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.videoInfo != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.imageInfo != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.resourceType != 0) goto L4;
        r1 = false;
        goto L9
    }

    public ResourceKmp(int r1, ImageInfoKmp r2, VideoResourceKmp r3, AudioResourceKmp r4, Boolean r5) {
        this.resourceType = r1;
        this.imageInfo = r2;
        this.videoInfo = r3;
        this.audioInfo = r4;
        this.isAvatar = r5;
    }

    public ResourceKmp(int r3, int r4, ImageInfoKmp r5, VideoResourceKmp r6, AudioResourceKmp r7, Boolean r8, q2 r9) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.resourceType = 0;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.imageInfo = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.videoInfo = null;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.audioInfo = null;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.isAvatar = null;
        return;
    L23:
        this.isAvatar = r8;
        return;
    L19:
        this.audioInfo = r7;
        goto L21
    L15:
        this.videoInfo = r6;
        goto L17
    L11:
        this.imageInfo = r5;
        goto L13
    L7:
        this.resourceType = r4;
        goto L9
    }

    public /* synthetic */ ResourceKmp(int r4, ImageInfoKmp r5, VideoResourceKmp r6, AudioResourceKmp r7, Boolean r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = 0;
    L5:
        Boolean r0 = null;
        if ((r9 & 2) == 0) goto L8;
        ImageInfoKmp r11 = null;
    L10:
        if ((r9 & 4) == 0) goto L12;
        VideoResourceKmp r1 = null;
    L14:
        if ((r9 & 8) == 0) goto L16;
        AudioResourceKmp r2 = null;
    L18:
        if ((r9 & 16) != 0) goto L21;
        r0 = r8;
    L21:
        this(r4, r11, r1, r2, r0);
        return;
    L16:
        r2 = r7;
        goto L18
    L12:
        r1 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L10
    }
}
