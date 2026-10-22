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
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00060\u0001j\u0002`\u0002:\u0002IJBg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u0011Bk\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003Ji\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u00106\u001a\u00020\u0013J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0013HÖ\u0001J\t\u0010<\u001a\u00020\bHÖ\u0001J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0013J%\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010 R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010%R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010(R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010%R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010 ¨\u0006K"}, d2 = {"Lcom/larus/ugc/feed/api/model/VideoUserContentKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "videoInfo", "Lcom/larus/ugc/feed/api/model/VideoInfoKmp;", "coverImage", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "displayContent", "", "prompt", "ratio", "Lcom/larus/ugc/feed/api/model/OptionItemKmp;", "unwatermarkedVideoInfo", "Lcom/larus/ugc/feed/api/model/UnwatermarkedVideoInfoKmp;", "model", "internalResources", "<init>", "(Lcom/larus/ugc/feed/api/model/VideoInfoKmp;Lcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lcom/larus/ugc/feed/api/model/UnwatermarkedVideoInfoKmp;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/ugc/feed/api/model/VideoInfoKmp;Lcom/larus/ugc/feed/api/model/ImageInfoKmp;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Lcom/larus/ugc/feed/api/model/UnwatermarkedVideoInfoKmp;Lcom/larus/ugc/feed/api/model/OptionItemKmp;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVideoInfo$annotations", "()V", "getVideoInfo", "()Lcom/larus/ugc/feed/api/model/VideoInfoKmp;", "getCoverImage$annotations", "getCoverImage", "()Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "getDisplayContent$annotations", "getDisplayContent", "()Ljava/lang/String;", "getPrompt$annotations", "getPrompt", "getRatio$annotations", "getRatio", "()Lcom/larus/ugc/feed/api/model/OptionItemKmp;", "getUnwatermarkedVideoInfo$annotations", "getUnwatermarkedVideoInfo", "()Lcom/larus/ugc/feed/api/model/UnwatermarkedVideoInfoKmp;", "getModel$annotations", "getModel", "getInternalResources$annotations", "getInternalResources", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class VideoUserContentKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<VideoUserContentKmp> CREATOR = null;
    public static final b Companion = null;
    private final ImageInfoKmp coverImage;
    private final String displayContent;
    private final String internalResources;
    private final OptionItemKmp model;
    private final String prompt;
    private final OptionItemKmp ratio;
    private final UnwatermarkedVideoInfoKmp unwatermarkedVideoInfo;
    private final VideoInfoKmp videoInfo;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<VideoUserContentKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.VideoUserContentKmp", r0, 8);
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
            OptionItemKmp.a r2 = OptionItemKmp.a.a;
            return new d[]{kuc.a.d(VideoInfoKmp.a.a), kuc.a.d(ImageInfoKmp.a.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(UnwatermarkedVideoInfoKmp.a.a), kuc.a.d(r2), kuc.a.d(r1)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            int r3 = 4;
            ImageInfoKmp r11 = null;
            if (r0.decodeSequentially() == false) goto L5;
            VideoInfoKmp r2 = (VideoInfoKmp) r0.decodeNullableSerializableElement(r1, 0, VideoInfoKmp.a.a, null);
            ImageInfoKmp r7 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 1, ImageInfoKmp.a.a, null);
            v2 r8 = v2.a;
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 2, r8, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 3, r8, null);
            OptionItemKmp.a r12 = OptionItemKmp.a.a;
            OptionItemKmp r5 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 4, r12, null);
            UnwatermarkedVideoInfoKmp r10 = (UnwatermarkedVideoInfoKmp) r0.decodeNullableSerializableElement(r1, 5, UnwatermarkedVideoInfoKmp.a.a, null);
            OptionItemKmp r9 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 6, r12, null);
            OptionItemKmp r13 = r5;
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 7, r8, null);
            ImageInfoKmp r15 = r7;
            OptionItemKmp r16 = r9;
            UnwatermarkedVideoInfoKmp r17 = r10;
            VideoInfoKmp r18 = r2;
            String r19 = r4;
            String r21 = r6;
            int r22 = 255;
        L24:
            r0.endStructure(r1);
            return new VideoUserContentKmp(r22, r18, r15, r21, r19, r13, r17, r16, r14, null);
        L5:
            String r23 = null;
            OptionItemKmp r24 = null;
            OptionItemKmp r25 = null;
            String r110 = null;
            VideoInfoKmp r111 = null;
            String r112 = null;
            UnwatermarkedVideoInfoKmp r113 = null;
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
            r24 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, 6, OptionItemKmp.a.a, r24);
            r26 = r26 | 64;
            goto L21
        L13:
            r113 = (UnwatermarkedVideoInfoKmp) r0.decodeNullableSerializableElement(r1, 5, UnwatermarkedVideoInfoKmp.a.a, r113);
            r26 = r26 | 32;
            goto L21
        L14:
            r25 = (OptionItemKmp) r0.decodeNullableSerializableElement(r1, r3, OptionItemKmp.a.a, r25);
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
            r11 = (ImageInfoKmp) r0.decodeNullableSerializableElement(r1, 1, ImageInfoKmp.a.a, r11);
            r26 = r26 | 2;
            goto L21
        L20:
            r26 = r26 | 1;
            r111 = (VideoInfoKmp) r0.decodeNullableSerializableElement(r1, 0, VideoInfoKmp.a.a, r111);
            goto L21
        L23:
            r19 = r23;
            r21 = r112;
            r22 = r26;
            r14 = r110;
            r17 = r113;
            VideoInfoKmp r115 = r111;
            r16 = r24;
            r18 = r115;
            ImageInfoKmp r116 = r11;
            r13 = r25;
            r15 = r116;
            goto L24
        }

        public final void serialize(muc.f r2, Object r3) {
            VideoUserContentKmp r4 = (VideoUserContentKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            VideoUserContentKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<VideoUserContentKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<VideoUserContentKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoUserContentKmp createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            OptionItemKmp r2 = null;
            if (r11.readInt() != 0) goto L5;
            VideoInfoKmp r1 = null;
        L6:
            VideoInfoKmp r3 = r1;
            if (r11.readInt() != 0) goto L9;
            ImageInfoKmp r4 = null;
        L10:
            ImageInfoKmp r5 = r4;
            String r6 = r11.readString();
            String r7 = r11.readString();
            if (r11.readInt() != 0) goto L13;
            OptionItemKmp r8 = null;
        L14:
            OptionItemKmp r9 = r8;
            if (r11.readInt() != 0) goto L17;
            UnwatermarkedVideoInfoKmp r10 = null;
        L18:
            UnwatermarkedVideoInfoKmp r12 = r10;
            if (r11.readInt() == 0) goto L23;
            r2 = OptionItemKmp.CREATOR.createFromParcel(r11);
        L23:
            return new VideoUserContentKmp(r3, r5, r6, r7, r9, r12, r2, r11.readString());
        L17:
            r10 = UnwatermarkedVideoInfoKmp.CREATOR.createFromParcel(r11);
            goto L18
        L13:
            r8 = OptionItemKmp.CREATOR.createFromParcel(r11);
            goto L14
        L9:
            r4 = ImageInfoKmp.CREATOR.createFromParcel(r11);
            goto L10
        L5:
            r1 = VideoInfoKmp.CREATOR.createFromParcel(r11);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final VideoUserContentKmp[] newArray(int r1) {
            return new VideoUserContentKmp[r1];
        }
    }

    public VideoUserContentKmp() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ VideoUserContentKmp copy$default(VideoUserContentKmp r9, VideoInfoKmp r10, ImageInfoKmp r11, String r12, String r13, OptionItemKmp r14, UnwatermarkedVideoInfoKmp r15, OptionItemKmp r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        VideoInfoKmp r2 = r9.videoInfo;
    L7:
        if ((r18 & 2) == 0) goto L9;
        ImageInfoKmp r3 = r9.coverImage;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.displayContent;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.prompt;
    L19:
        if ((r18 & 16) == 0) goto L21;
        OptionItemKmp r6 = r9.ratio;
    L23:
        if ((r18 & 32) == 0) goto L25;
        UnwatermarkedVideoInfoKmp r7 = r9.unwatermarkedVideoInfo;
    L27:
        if ((r18 & 64) == 0) goto L29;
        OptionItemKmp r8 = r9.model;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.internalResources;
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

    @SerialName("display_content")
    public static /* synthetic */ void getDisplayContent$annotations() {
    }

    @SerialName("internal_resources")
    public static /* synthetic */ void getInternalResources$annotations() {
    }

    @SerialName("model")
    public static /* synthetic */ void getModel$annotations() {
    }

    @SerialName("prompt")
    public static /* synthetic */ void getPrompt$annotations() {
    }

    @SerialName("ratio")
    public static /* synthetic */ void getRatio$annotations() {
    }

    @SerialName("unwatermarked_video_info")
    public static /* synthetic */ void getUnwatermarkedVideoInfo$annotations() {
    }

    @SerialName("video_info")
    public static /* synthetic */ void getVideoInfo$annotations() {
    }

    public final VideoInfoKmp component1() {
        return this.videoInfo;
    }

    public final ImageInfoKmp component2() {
        return this.coverImage;
    }

    public final String component3() {
        return this.displayContent;
    }

    public final String component4() {
        return this.prompt;
    }

    public final OptionItemKmp component5() {
        return this.ratio;
    }

    public final UnwatermarkedVideoInfoKmp component6() {
        return this.unwatermarkedVideoInfo;
    }

    public final OptionItemKmp component7() {
        return this.model;
    }

    public final String component8() {
        return this.internalResources;
    }

    public final VideoUserContentKmp copy(VideoInfoKmp r11, ImageInfoKmp r12, String r13, String r14, OptionItemKmp r15, UnwatermarkedVideoInfoKmp r16, OptionItemKmp r17, String r18) {
        return new VideoUserContentKmp(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoUserContentKmp) == true) goto L8;
        return false;
    L8:
        VideoUserContentKmp r6 = (VideoUserContentKmp) r5;
        if (Intrinsics.areEqual(this.videoInfo, r6.videoInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.coverImage, r6.coverImage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayContent, r6.displayContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prompt, r6.prompt) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ratio, r6.ratio) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.unwatermarkedVideoInfo, r6.unwatermarkedVideoInfo) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.model, r6.model) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.internalResources, r6.internalResources) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        VideoInfoKmp r0 = this.videoInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ImageInfoKmp r4 = this.coverImage;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.displayContent;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.prompt;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        OptionItemKmp r13 = this.ratio;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        UnwatermarkedVideoInfoKmp r16 = this.unwatermarkedVideoInfo;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        OptionItemKmp r19 = this.model;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.internalResources;
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
        return "VideoUserContentKmp(videoInfo=" + this.videoInfo + ", coverImage=" + this.coverImage + ", displayContent=" + this.displayContent + ", prompt=" + this.prompt + ", ratio=" + this.ratio + ", unwatermarkedVideoInfo=" + this.unwatermarkedVideoInfo + ", model=" + this.model + ", internalResources=" + this.internalResources + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        VideoInfoKmp r0 = this.videoInfo;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        ImageInfoKmp r1 = this.coverImage;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        r4.writeString(this.displayContent);
        r4.writeString(this.prompt);
        OptionItemKmp r2 = this.ratio;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        UnwatermarkedVideoInfoKmp r3 = this.unwatermarkedVideoInfo;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        OptionItemKmp r6 = this.model;
        if (r6 != null) goto L21;
        r4.writeInt(0);
    L22:
        r4.writeString(this.internalResources);
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
        $stable = 8;
        CREATOR = new c();
    }

    public final ImageInfoKmp getCoverImage() {
        return this.coverImage;
    }

    public final String getDisplayContent() {
        return this.displayContent;
    }

    public final String getInternalResources() {
        return this.internalResources;
    }

    public final OptionItemKmp getModel() {
        return this.model;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final OptionItemKmp getRatio() {
        return this.ratio;
    }

    public final UnwatermarkedVideoInfoKmp getUnwatermarkedVideoInfo() {
        return this.unwatermarkedVideoInfo;
    }

    public final VideoInfoKmp getVideoInfo() {
        return this.videoInfo;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(VideoUserContentKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, VideoInfoKmp.a.a, r5.videoInfo);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, ImageInfoKmp.a.a, r5.coverImage);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.displayContent);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, v2.a, r5.prompt);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, OptionItemKmp.a.a, r5.ratio);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        boolean r9 = true;
    L54:
        if (r9 == false) goto L57;
        r6.encodeNullableSerializableElement(r7, 5, UnwatermarkedVideoInfoKmp.a.a, r5.unwatermarkedVideoInfo);
    L57:
        if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L60;
    L58:
        boolean r10 = true;
    L63:
        if (r10 == false) goto L66;
        r6.encodeNullableSerializableElement(r7, 6, OptionItemKmp.a.a, r5.model);
    L66:
        if (r6.shouldEncodeElementDefault(r7, 7) == false) goto L69;
    L67:
        r0 = true;
    L71:
        if (r0 == false) goto L74;
        r6.encodeNullableSerializableElement(r7, 7, v2.a, r5.internalResources);
        return;
    L74:
        return;
    L69:
        if (r5.internalResources == null) goto L71;
    L60:
        if (r5.model != null) goto L58;
        r10 = false;
        goto L63
    L51:
        if (r5.unwatermarkedVideoInfo != null) goto L49;
        r9 = false;
        goto L54
    L42:
        if (r5.ratio != null) goto L40;
        r8 = false;
        goto L45
    L33:
        if (r5.prompt != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.displayContent != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.coverImage != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.videoInfo != null) goto L4;
        r1 = false;
        goto L9
    }

    public VideoUserContentKmp(VideoInfoKmp r1, ImageInfoKmp r2, String r3, String r4, OptionItemKmp r5, UnwatermarkedVideoInfoKmp r6, OptionItemKmp r7, String r8) {
        this.videoInfo = r1;
        this.coverImage = r2;
        this.displayContent = r3;
        this.prompt = r4;
        this.ratio = r5;
        this.unwatermarkedVideoInfo = r6;
        this.model = r7;
        this.internalResources = r8;
    }

    public VideoUserContentKmp(int r2, VideoInfoKmp r3, ImageInfoKmp r4, String r5, String r6, OptionItemKmp r7, UnwatermarkedVideoInfoKmp r8, OptionItemKmp r9, String r10, q2 r11) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.videoInfo = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.coverImage = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.displayContent = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.prompt = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.ratio = null;
    L25:
        if ((r2 & 32) != 0) goto L27;
        this.unwatermarkedVideoInfo = null;
    L29:
        if ((r2 & 64) != 0) goto L31;
        this.model = null;
    L33:
        if ((r2 & 128) != 0) goto L35;
        this.internalResources = null;
        return;
    L35:
        this.internalResources = r10;
        return;
    L31:
        this.model = r9;
        goto L33
    L27:
        this.unwatermarkedVideoInfo = r8;
        goto L29
    L23:
        this.ratio = r7;
        goto L25
    L19:
        this.prompt = r6;
        goto L21
    L15:
        this.displayContent = r5;
        goto L17
    L11:
        this.coverImage = r4;
        goto L13
    L7:
        this.videoInfo = r3;
        goto L9
    }

    public /* synthetic */ VideoUserContentKmp(VideoInfoKmp r10, ImageInfoKmp r11, String r12, String r13, OptionItemKmp r14, UnwatermarkedVideoInfoKmp r15, OptionItemKmp r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        VideoInfoKmp r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        ImageInfoKmp r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        OptionItemKmp r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        UnwatermarkedVideoInfoKmp r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        OptionItemKmp r8 = null;
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
