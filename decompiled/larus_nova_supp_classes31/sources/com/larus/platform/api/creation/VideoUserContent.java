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
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00060\u0001j\u0002`\u0002:\u0002IJBg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u0011Bk\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003Ji\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u00106\u001a\u00020\u0013J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0013HÖ\u0001J\t\u0010<\u001a\u00020\bHÖ\u0001J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0013J%\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010 R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010%R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010(R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010%R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010 ¨\u0006K"}, d2 = {"Lcom/larus/platform/api/creation/VideoUserContent;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "videoInfo", "Lcom/larus/platform/api/creation/VideoInfo;", "coverImage", "Lcom/larus/platform/api/ImageInfo;", "displayContent", "", "prompt", "ratio", "Lcom/larus/platform/api/creation/OptionItem;", "unwatermarkedVideoInfo", "Lcom/larus/platform/api/creation/UnwatermarkedVideoInfo;", "model", "internalResources", "<init>", "(Lcom/larus/platform/api/creation/VideoInfo;Lcom/larus/platform/api/ImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/UnwatermarkedVideoInfo;Lcom/larus/platform/api/creation/OptionItem;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/creation/VideoInfo;Lcom/larus/platform/api/ImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/UnwatermarkedVideoInfo;Lcom/larus/platform/api/creation/OptionItem;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVideoInfo$annotations", "()V", "getVideoInfo", "()Lcom/larus/platform/api/creation/VideoInfo;", "getCoverImage$annotations", "getCoverImage", "()Lcom/larus/platform/api/ImageInfo;", "getDisplayContent$annotations", "getDisplayContent", "()Ljava/lang/String;", "getPrompt$annotations", "getPrompt", "getRatio$annotations", "getRatio", "()Lcom/larus/platform/api/creation/OptionItem;", "getUnwatermarkedVideoInfo$annotations", "getUnwatermarkedVideoInfo", "()Lcom/larus/platform/api/creation/UnwatermarkedVideoInfo;", "getModel$annotations", "getModel", "getInternalResources$annotations", "getInternalResources", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class VideoUserContent implements Parcelable {
    public static final Parcelable.Creator<VideoUserContent> CREATOR = null;
    public static final b Companion = null;
    public final VideoInfo a;
    public final ImageInfo b;
    public final String c;
    public final String d;
    public final OptionItem e;
    public final UnwatermarkedVideoInfo f;
    public final OptionItem g;
    public final String h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<VideoUserContent> {
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
            g2 r1 = new g2("com.larus.platform.api.creation.VideoUserContent", r0, 8);
            r1.j("video_info", true);
            r1.j("cover_image", true);
            r1.j("display_content", true);
            r1.j("prompt", true);
            r1.j("ratio", true);
            r1.j("unwatermarked_video_info", true);
            r1.j("model", true);
            r1.j("internal_resources", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            OptionItem.a r2 = OptionItem.a.a;
            return new d[]{kuc.a.d(VideoInfo.a.a), kuc.a.d(ImageInfo.a.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(UnwatermarkedVideoInfo.a.a), kuc.a.d(r2), kuc.a.d(r1)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            int r3 = 4;
            ImageInfo r11 = null;
            if (r0.decodeSequentially() == false) goto L5;
            VideoInfo r2 = (VideoInfo) r0.decodeNullableSerializableElement(r1, 0, VideoInfo.a.a, null);
            ImageInfo r7 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 1, ImageInfo.a.a, null);
            v2 r8 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 2, r8, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 3, r8, null);
            OptionItem.a r12 = OptionItem.a.a;
            OptionItem r5 = (OptionItem) r0.decodeNullableSerializableElement(r1, 4, r12, null);
            UnwatermarkedVideoInfo r10 = (UnwatermarkedVideoInfo) r0.decodeNullableSerializableElement(r1, 5, UnwatermarkedVideoInfo.a.a, null);
            OptionItem r9 = (OptionItem) r0.decodeNullableSerializableElement(r1, 6, r12, null);
            OptionItem r13 = r5;
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 7, r8, null);
            ImageInfo r15 = r7;
            OptionItem r16 = r9;
            UnwatermarkedVideoInfo r17 = r10;
            VideoInfo r18 = r2;
            String r19 = r4;
            String r21 = r6;
            int r22 = 255;
        L24:
            r0.endStructure(r1);
            return new VideoUserContent(r22, r18, r15, r21, r19, r13, r17, r16, r14);
        L5:
            String r23 = null;
            OptionItem r24 = null;
            OptionItem r25 = null;
            String r110 = null;
            VideoInfo r111 = null;
            String r112 = null;
            UnwatermarkedVideoInfo r113 = null;
            int r26 = 0;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L23;
            int r27 = r0.decodeElementIndex(r1);
            switch(r27) {
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
            throw new UnknownFieldException(r27);
        L22:
            r3 = 4;
            r114 = false;
            goto L6
        L11:
            r110 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r110);
            r26 = r26 | 128;
        L21:
            r3 = 4;
            goto L6
        L12:
            r24 = (OptionItem) r0.decodeNullableSerializableElement(r1, 6, OptionItem.a.a, r24);
            r26 = r26 | 64;
            goto L21
        L13:
            r113 = (UnwatermarkedVideoInfo) r0.decodeNullableSerializableElement(r1, 5, UnwatermarkedVideoInfo.a.a, r113);
            r26 = r26 | 32;
            goto L21
        L14:
            r25 = (OptionItem) r0.decodeNullableSerializableElement(r1, r3, OptionItem.a.a, r25);
            r26 = r26 | 16;
            goto L21
        L15:
            r23 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r23);
            r26 = r26 | 8;
            goto L21
        L16:
            r112 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r112);
            r26 = r26 | 4;
            goto L21
        L18:
            r11 = (ImageInfo) r0.decodeNullableSerializableElement(r1, 1, ImageInfo.a.a, r11);
            r26 = r26 | 2;
            goto L21
        L20:
            r26 = r26 | 1;
            r111 = (VideoInfo) r0.decodeNullableSerializableElement(r1, 0, VideoInfo.a.a, r111);
            goto L21
        L23:
            r19 = r23;
            r21 = r112;
            r22 = r26;
            r14 = r110;
            r17 = r113;
            VideoInfo r115 = r111;
            r16 = r24;
            r18 = r115;
            ImageInfo r116 = r11;
            r13 = r25;
            r15 = r116;
            goto L24
        }

        public final void serialize(muc.f r7, Object r8) {
            VideoUserContent r9 = (VideoUserContent) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = VideoUserContent.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, VideoInfo.a.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, ImageInfo.a.a, r9.b);
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
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
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
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, UnwatermarkedVideoInfo.a.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, OptionItem.a.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            r2 = true;
        L71:
            if (r2 == false) goto L73;
            r10.encodeNullableSerializableElement(r0, 7, v2.a, r9.h);
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

        public final d<VideoUserContent> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<VideoUserContent> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoUserContent createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            OptionItem r2 = null;
            if (r11.readInt() != 0) goto L5;
            VideoInfo r1 = null;
        L6:
            VideoInfo r3 = r1;
            if (r11.readInt() != 0) goto L9;
            ImageInfo r4 = null;
        L10:
            ImageInfo r5 = r4;
            String r6 = r11.readString();
            String r7 = r11.readString();
            if (r11.readInt() != 0) goto L13;
            OptionItem r8 = null;
        L14:
            OptionItem r9 = r8;
            if (r11.readInt() != 0) goto L17;
            UnwatermarkedVideoInfo r10 = null;
        L18:
            UnwatermarkedVideoInfo r12 = r10;
            if (r11.readInt() == 0) goto L23;
            r2 = OptionItem.CREATOR.createFromParcel(r11);
        L23:
            return new VideoUserContent(r3, r5, r6, r7, r9, r12, r2, r11.readString());
        L17:
            r10 = UnwatermarkedVideoInfo.CREATOR.createFromParcel(r11);
            goto L18
        L13:
            r8 = OptionItem.CREATOR.createFromParcel(r11);
            goto L14
        L9:
            r4 = ImageInfo.CREATOR.createFromParcel(r11);
            goto L10
        L5:
            r1 = VideoInfo.CREATOR.createFromParcel(r11);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final VideoUserContent[] newArray(int r1) {
            return new VideoUserContent[r1];
        }
    }

    public VideoUserContent() {
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
        if ((r5 instanceof VideoUserContent) == true) goto L8;
        return false;
    L8:
        VideoUserContent r6 = (VideoUserContent) r5;
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
        VideoInfo r0 = this.a;
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
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        OptionItem r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        UnwatermarkedVideoInfo r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        OptionItem r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
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
        return "VideoUserContent(videoInfo=" + this.a + ", coverImage=" + this.b + ", displayContent=" + this.c + ", prompt=" + this.d + ", ratio=" + this.e + ", unwatermarkedVideoInfo=" + this.f + ", model=" + this.g + ", internalResources=" + this.h + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        VideoInfo r0 = this.a;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        ImageInfo r1 = this.b;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        r4.writeString(this.c);
        r4.writeString(this.d);
        OptionItem r2 = this.e;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        UnwatermarkedVideoInfo r3 = this.f;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        OptionItem r6 = this.g;
        if (r6 != null) goto L21;
        r4.writeInt(0);
    L22:
        r4.writeString(this.h);
        return;
    L21:
        r4.writeInt(1);
        r6.writeToParcel(r4, r5);
        goto L22
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
        r0.writeToParcel(r4, r5);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public VideoUserContent(VideoInfo r1, ImageInfo r2, String r3, String r4, OptionItem r5, UnwatermarkedVideoInfo r6, OptionItem r7, String r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public VideoUserContent(int r3, VideoInfo r4, ImageInfo r5, String r6, String r7, OptionItem r8, UnwatermarkedVideoInfo r9, OptionItem r10, String r11) {
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
