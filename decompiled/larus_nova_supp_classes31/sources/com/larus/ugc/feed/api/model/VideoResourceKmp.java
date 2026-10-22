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
import nuc.b0;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00060\u0001j\u0002`\u0002:\u0002IJBg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bk\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jn\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00106J\u0006\u00107\u001a\u00020\u0012J\u0013\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0012HÖ\u0001J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0012J%\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010)\u0012\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010(R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010,¨\u0006K"}, d2 = {"Lcom/larus/ugc/feed/api/model/VideoResourceKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "vid", "", "downloadUrl", "downloadFilehash", "duration", "", "videoType", "videoModel", "withAudio", "", "coverImage", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/ugc/feed/api/model/ImageInfoKmp;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/ugc/feed/api/model/ImageInfoKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVid$annotations", "()V", "getVid", "()Ljava/lang/String;", "getDownloadUrl$annotations", "getDownloadUrl", "getDownloadFilehash$annotations", "getDownloadFilehash", "getDuration$annotations", "getDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVideoType$annotations", "getVideoType", "getVideoModel$annotations", "getVideoModel", "getWithAudio$annotations", "getWithAudio", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCoverImage$annotations", "getCoverImage", "()Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/ugc/feed/api/model/ImageInfoKmp;)Lcom/larus/ugc/feed/api/model/VideoResourceKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class VideoResourceKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<VideoResourceKmp> CREATOR = null;
    public static final b Companion = null;
    private final ImageInfoKmp coverImage;
    private final String downloadFilehash;
    private final String downloadUrl;
    private final Double duration;
    private final String vid;
    private final String videoModel;
    private final String videoType;
    private final Boolean withAudio;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<VideoResourceKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.VideoResourceKmp", r0, 8);
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
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(b0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(i.a), kuc.a.d(ImageInfoKmp.a.a)};
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
            ImageInfoKmp r15 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 7, ImageInfoKmp.a.a, null);
            Boolean r16 = r10;
            String r17 = r6;
            int r18 = 255;
        L24:
            r0.endStructure(r1);
            return new VideoResourceKmp(r18, r7, r8, r17, r14, r13, r12, r16, r15, null);
        L5:
            Double r19 = null;
            Boolean r21 = null;
            String r22 = null;
            ImageInfoKmp r110 = null;
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
            r110 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 7, ImageInfoKmp.a.a, r110);
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

        public final void serialize(muc.f r2, Object r3) {
            VideoResourceKmp r4 = (VideoResourceKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            VideoResourceKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<VideoResourceKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<VideoResourceKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoResourceKmp createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r2 = r11.readString();
            String r3 = r11.readString();
            String r4 = r11.readString();
            ImageInfoKmp r5 = null;
            if (r11.readInt() != 0) goto L5;
            Double r6 = null;
        L6:
            String r7 = r11.readString();
            String r8 = r11.readString();
            if (r11.readInt() != 0) goto L10;
            Boolean r9 = null;
        L15:
            if (r11.readInt() == 0) goto L19;
            r5 = ImageInfoKmp.CREATOR.createFromParcel(r11);
        L19:
            return new VideoResourceKmp(r2, r3, r4, r6, r7, r8, r9, r5);
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
        public final VideoResourceKmp[] newArray(int r1) {
            return new VideoResourceKmp[r1];
        }
    }

    public VideoResourceKmp() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ VideoResourceKmp copy$default(VideoResourceKmp r9, String r10, String r11, String r12, Double r13, String r14, String r15, Boolean r16, ImageInfoKmp r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.vid;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.downloadUrl;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.downloadFilehash;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Double r5 = r9.duration;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.videoType;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.videoModel;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Boolean r8 = r9.withAudio;
    L31:
        if ((r18 & 128) == 0) goto L33;
        ImageInfoKmp r1 = r9.coverImage;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    @SerialName("cover_image")
    public static /* synthetic */ void getCoverImage$annotations() {
    }

    @SerialName("download_filehash")
    public static /* synthetic */ void getDownloadFilehash$annotations() {
    }

    @SerialName("download_url")
    public static /* synthetic */ void getDownloadUrl$annotations() {
    }

    @SerialName("duration")
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("vid")
    public static /* synthetic */ void getVid$annotations() {
    }

    @SerialName("video_model")
    public static /* synthetic */ void getVideoModel$annotations() {
    }

    @SerialName("video_type")
    public static /* synthetic */ void getVideoType$annotations() {
    }

    @SerialName("with_audio")
    public static /* synthetic */ void getWithAudio$annotations() {
    }

    public final String component1() {
        return this.vid;
    }

    public final String component2() {
        return this.downloadUrl;
    }

    public final String component3() {
        return this.downloadFilehash;
    }

    public final Double component4() {
        return this.duration;
    }

    public final String component5() {
        return this.videoType;
    }

    public final String component6() {
        return this.videoModel;
    }

    public final Boolean component7() {
        return this.withAudio;
    }

    public final ImageInfoKmp component8() {
        return this.coverImage;
    }

    public final VideoResourceKmp copy(String r11, String r12, String r13, Double r14, String r15, String r16, Boolean r17, ImageInfoKmp r18) {
        return new VideoResourceKmp(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoResourceKmp) == true) goto L8;
        return false;
    L8:
        VideoResourceKmp r6 = (VideoResourceKmp) r5;
        if (Intrinsics.areEqual(this.vid, r6.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downloadUrl, r6.downloadUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.downloadFilehash, r6.downloadFilehash) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.videoType, r6.videoType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoModel, r6.videoModel) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.withAudio, r6.withAudio) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.coverImage, r6.coverImage) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.vid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.downloadUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.downloadFilehash;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.duration;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.videoType;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.videoModel;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.withAudio;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        ImageInfoKmp r22 = this.coverImage;
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

    public String toString() {
        return "VideoResourceKmp(vid=" + this.vid + ", downloadUrl=" + this.downloadUrl + ", downloadFilehash=" + this.downloadFilehash + ", duration=" + this.duration + ", videoType=" + this.videoType + ", videoModel=" + this.videoModel + ", withAudio=" + this.withAudio + ", coverImage=" + this.coverImage + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.vid);
        r6.writeString(this.downloadUrl);
        r6.writeString(this.downloadFilehash);
        Double r0 = this.duration;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        r6.writeString(this.videoType);
        r6.writeString(this.videoModel);
        Boolean r1 = this.withAudio;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        ImageInfoKmp r2 = this.coverImage;
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
        $stable = 8;
        CREATOR = new c();
    }

    public final ImageInfoKmp getCoverImage() {
        return this.coverImage;
    }

    public final String getDownloadFilehash() {
        return this.downloadFilehash;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final Double getDuration() {
        return this.duration;
    }

    public final String getVid() {
        return this.vid;
    }

    public final String getVideoModel() {
        return this.videoModel;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public final Boolean getWithAudio() {
        return this.withAudio;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(VideoResourceKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, v2.a, r5.vid);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.downloadUrl);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.downloadFilehash);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, b0.a, r5.duration);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, v2.a, r5.videoType);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        boolean r9 = true;
    L54:
        if (r9 == false) goto L57;
        r6.encodeNullableSerializableElement(r7, 5, v2.a, r5.videoModel);
    L57:
        if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L60;
    L58:
        boolean r10 = true;
    L63:
        if (r10 == false) goto L66;
        r6.encodeNullableSerializableElement(r7, 6, i.a, r5.withAudio);
    L66:
        if (r6.shouldEncodeElementDefault(r7, 7) == false) goto L69;
    L67:
        r0 = true;
    L71:
        if (r0 == false) goto L74;
        r6.encodeNullableSerializableElement(r7, 7, ImageInfoKmp.a.a, r5.coverImage);
        return;
    L74:
        return;
    L69:
        if (r5.coverImage == null) goto L71;
    L60:
        if (r5.withAudio != null) goto L58;
        r10 = false;
        goto L63
    L51:
        if (r5.videoModel != null) goto L49;
        r9 = false;
        goto L54
    L42:
        if (r5.videoType != null) goto L40;
        r8 = false;
        goto L45
    L33:
        if (r5.duration != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.downloadFilehash != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.downloadUrl != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.vid != null) goto L4;
        r1 = false;
        goto L9
    }

    public VideoResourceKmp(String r1, String r2, String r3, Double r4, String r5, String r6, Boolean r7, ImageInfoKmp r8) {
        this.vid = r1;
        this.downloadUrl = r2;
        this.downloadFilehash = r3;
        this.duration = r4;
        this.videoType = r5;
        this.videoModel = r6;
        this.withAudio = r7;
        this.coverImage = r8;
    }

    public VideoResourceKmp(int r2, String r3, String r4, String r5, Double r6, String r7, String r8, Boolean r9, ImageInfoKmp r10, q2 r11) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.vid = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.downloadUrl = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.downloadFilehash = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.duration = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.videoType = null;
    L25:
        if ((r2 & 32) != 0) goto L27;
        this.videoModel = null;
    L29:
        if ((r2 & 64) != 0) goto L31;
        this.withAudio = null;
    L33:
        if ((r2 & 128) != 0) goto L35;
        this.coverImage = null;
        return;
    L35:
        this.coverImage = r10;
        return;
    L31:
        this.withAudio = r9;
        goto L33
    L27:
        this.videoModel = r8;
        goto L29
    L23:
        this.videoType = r7;
        goto L25
    L19:
        this.duration = r6;
        goto L21
    L15:
        this.downloadFilehash = r5;
        goto L17
    L11:
        this.downloadUrl = r4;
        goto L13
    L7:
        this.vid = r3;
        goto L9
    }

    public /* synthetic */ VideoResourceKmp(String r10, String r11, String r12, Double r13, String r14, String r15, Boolean r16, ImageInfoKmp r17, int r18, DefaultConstructorMarker r19) {
        ImageInfoKmp r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Double r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Boolean r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
