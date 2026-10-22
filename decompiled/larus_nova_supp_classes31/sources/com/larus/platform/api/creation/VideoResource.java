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
import nuc.b0;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00060\u0001j\u0002`\u0002:\u0002IJBg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bk\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jn\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00106J\u0006\u00107\u001a\u00020\u0012J\u0013\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0012HÖ\u0001J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0012J%\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010)\u0012\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010(R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010,¨\u0006K"}, d2 = {"Lcom/larus/platform/api/creation/VideoResource;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "vid", "", "downloadUrl", "downloadFilehash", "duration", "", "videoType", "videoModel", "withAudio", "", "coverImage", "Lcom/larus/platform/api/ImageInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/platform/api/ImageInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/platform/api/ImageInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVid$annotations", "()V", "getVid", "()Ljava/lang/String;", "getDownloadUrl$annotations", "getDownloadUrl", "getDownloadFilehash$annotations", "getDownloadFilehash", "getDuration$annotations", "getDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVideoType$annotations", "getVideoType", "getVideoModel$annotations", "getVideoModel", "getWithAudio$annotations", "getWithAudio", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCoverImage$annotations", "getCoverImage", "()Lcom/larus/platform/api/ImageInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/platform/api/ImageInfo;)Lcom/larus/platform/api/creation/VideoResource;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class VideoResource implements Parcelable {
    public static final Parcelable.Creator<VideoResource> CREATOR = null;
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final String c;
    public final Double d;
    public final String e;
    public final String f;
    public final Boolean g;
    public final ImageInfo h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<VideoResource> {
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
            g2 r1 = new g2("com.larus.platform.api.creation.VideoResource", r0, 8);
            r1.j("vid", true);
            r1.j("download_url", true);
            r1.j("download_filehash", true);
            r1.j("duration", true);
            r1.j("video_type", true);
            r1.j("video_model", true);
            r1.j("with_audio", true);
            r1.j("cover_image", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(b0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(i.a), kuc.a.d(ImageInfo.a.a)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            int r3 = 4;
            String r11 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            Double r4 = (Double) r0.decodeNullableSerializableElement(r1, 3, b0.a, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            Boolean r10 = (Boolean) r0.decodeNullableSerializableElement(r1, 6, i.a, null);
            String r12 = r9;
            String r13 = r5;
            Double r14 = r4;
            ImageInfo r15 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 7, ImageInfo.a.a, null);
            Boolean r16 = r10;
            String r17 = r6;
            int r18 = 255;
        L24:
            r0.endStructure(r1);
            return new VideoResource(r18, r7, r8, r17, r14, r13, r12, r16, r15);
        L5:
            Double r19 = null;
            Boolean r21 = null;
            String r22 = null;
            ImageInfo r110 = null;
            String r111 = null;
            String r112 = null;
            String r113 = null;
            int r23 = 0;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L23;
            int r24 = r0.decodeElementIndex(r1);
            switch(r24) {
                case -1: goto L22;
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r24);
        L22:
            r3 = 4;
            r114 = false;
            goto L6
        L11:
            r110 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 7, ImageInfo.a.a, r110);
            r23 = r23 | 128;
        L21:
            r3 = 4;
            goto L6
        L12:
            r21 = (Boolean) r0.decodeNullableSerializableElement(r1, 6, i.a, r21);
            r23 = r23 | 64;
            goto L21
        L13:
            r113 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r113);
            r23 = r23 | 32;
            goto L21
        L14:
            r22 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r22);
            r23 = r23 | 16;
            goto L21
        L15:
            r19 = (Double) r0.decodeNullableSerializableElement(r1, 3, b0.a, r19);
            r23 = r23 | 8;
            goto L21
        L16:
            r112 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r112);
            r23 = r23 | 4;
            goto L21
        L18:
            r11 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r11);
            r23 = r23 | 2;
            goto L21
        L20:
            r23 = r23 | 1;
            r111 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r111);
            goto L21
        L23:
            r14 = r19;
            r17 = r112;
            r18 = r23;
            r15 = r110;
            r12 = r113;
            String r115 = r111;
            r16 = r21;
            r7 = r115;
            String r116 = r11;
            r13 = r22;
            r8 = r116;
            goto L24
        }

        public final void serialize(muc.f r7, Object r8) {
            VideoResource r9 = (VideoResource) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = VideoResource.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
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
            r10.encodeNullableSerializableElement(r0, 3, b0.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, v2.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, i.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            r2 = true;
        L71:
            if (r2 == false) goto L73;
            r10.encodeNullableSerializableElement(r0, 7, ImageInfo.a.a, r9.h);
        L73:
            r10.endStructure(r0);
            return;
        L69:
            if (r9.h == null) goto L71;
        L60:
            if (r9.g != null) goto L61;
            r13 = false;
            goto L63
        L51:
            if (r9.f != null) goto L52;
            r12 = false;
            goto L54
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

        public final d<VideoResource> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<VideoResource> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoResource createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r2 = r11.readString();
            String r3 = r11.readString();
            String r4 = r11.readString();
            ImageInfo r5 = null;
            if (r11.readInt() != 0) goto L5;
            Double r6 = null;
        L6:
            String r7 = r11.readString();
            String r8 = r11.readString();
            if (r11.readInt() != 0) goto L10;
            Boolean r9 = null;
        L15:
            if (r11.readInt() == 0) goto L19;
            r5 = ImageInfo.CREATOR.createFromParcel(r11);
        L19:
            return new VideoResource(r2, r3, r4, r6, r7, r8, r9, r5);
        L10:
            if (r11.readInt() == 0) goto L12;
            boolean r1 = true;
        L13:
            r9 = Boolean.valueOf(r1);
            goto L15
        L12:
            r1 = false;
            goto L13
        L5:
            r6 = Double.valueOf(r11.readDouble());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final VideoResource[] newArray(int r1) {
            return new VideoResource[r1];
        }
    }

    public VideoResource() {
        this(null, null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoResource) == true) goto L8;
        return false;
    L8:
        VideoResource r6 = (VideoResource) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
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
        Double r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        ImageInfo r22 = this.h;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
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
        return "VideoResource(vid=" + this.a + ", downloadUrl=" + this.b + ", downloadFilehash=" + this.c + ", duration=" + this.d + ", videoType=" + this.e + ", videoModel=" + this.f + ", withAudio=" + this.g + ", coverImage=" + this.h + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.a);
        r6.writeString(this.b);
        r6.writeString(this.c);
        Double r0 = this.d;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        r6.writeString(this.e);
        r6.writeString(this.f);
        Boolean r1 = this.g;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        ImageInfo r2 = this.h;
        if (r2 != null) goto L13;
        r6.writeInt(0);
        return;
    L13:
        r6.writeInt(1);
        r2.writeToParcel(r6, r7);
        return;
    L9:
        r6.writeInt(1);
        r6.writeInt(r1.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeDouble(r0.doubleValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public VideoResource(String r1, String r2, String r3, Double r4, String r5, String r6, Boolean r7, ImageInfo r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public VideoResource(int r3, String r4, String r5, String r6, Double r7, String r8, String r9, Boolean r10, ImageInfo r11) {
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
    L29:
        if ((r3 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r3 & 128) != 0) goto L35;
        this.h = null;
        return;
    L35:
        this.h = r11;
        return;
    L31:
        this.g = r10;
        goto L33
    L27:
        this.f = r9;
        goto L29
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
