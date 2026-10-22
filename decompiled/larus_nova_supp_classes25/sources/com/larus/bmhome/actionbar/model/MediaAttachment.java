package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 d2\u00060\u0001j\u0002`\u0002:\u0002cdB\u0097\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014BW\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0013\u0010\u0019J\u000b\u0010H\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010DJ\u009e\u0001\u0010T\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020\u00122\b\u0010W\u001a\u0004\u0018\u00010XHÖ\u0003J\t\u0010Y\u001a\u00020\u0016HÖ\u0001J\t\u0010Z\u001a\u00020\u0004HÖ\u0001J%\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0001¢\u0006\u0002\bbR&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR&\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR&\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u001b\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR&\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u001b\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR&\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u001b\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR&\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u001b\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001fR&\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u001b\u001a\u0004\b@\u0010\u001d\"\u0004\bA\u0010\u001fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010G\u0012\u0004\bB\u0010\u001b\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006e"}, d2 = {"Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "url", "", "uri", "imageUploadInfo", "Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "videoUploadInfo", "Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;", "localFilePath", "identifier", "resourceId", "localMessageId", "originUrl", "previewUrl", "maskUri", "aiCreationImage", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getUri$annotations", "getUri", "setUri", "getImageUploadInfo$annotations", "getImageUploadInfo", "()Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;", "setImageUploadInfo", "(Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;)V", "getVideoUploadInfo$annotations", "getVideoUploadInfo", "()Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;", "setVideoUploadInfo", "(Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;)V", "getLocalFilePath$annotations", "getLocalFilePath", "setLocalFilePath", "getIdentifier$annotations", "getIdentifier", "setIdentifier", "getResourceId$annotations", "getResourceId", "setResourceId", "getLocalMessageId$annotations", "getLocalMessageId", "setLocalMessageId", "getOriginUrl$annotations", "getOriginUrl", "setOriginUrl", "getPreviewUrl$annotations", "getPreviewUrl", "setPreviewUrl", "getMaskUri$annotations", "getMaskUri", "setMaskUri", "getAiCreationImage$annotations", "getAiCreationImage", "()Ljava/lang/Boolean;", "setAiCreationImage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/ImageUploadInfo;Lcom/larus/bmhome/actionbar/model/VideoUploadInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$instruction_core_api_release", "$serializer", "Companion", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@Serializable
public final class MediaAttachment implements java.io.Serializable {
    public static final b Companion = null;
    private Boolean aiCreationImage;
    private String identifier;
    private ImageUploadInfo imageUploadInfo;
    private String localFilePath;
    private String localMessageId;
    private String maskUri;
    private String originUrl;
    private String previewUrl;
    private String resourceId;
    private String uri;
    private String url;
    private VideoUploadInfo videoUploadInfo;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<MediaAttachment> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(ImageUploadInfo.a.a), kuc.a.d(VideoUploadInfo.a.a), kuc.a.d(r1), kuc.a.d(nuc.i.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.MediaAttachment", r0, 6);
            r1.j("url", true);
            r1.j("uri", true);
            r1.j("image_upload_info", true);
            r1.j("video_upload_info", true);
            r1.j("mask_uri", true);
            r1.j("ai_creation_image", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            int r3 = 2;
            Boolean r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            ImageUploadInfo r4 = (ImageUploadInfo) r0.decodeNullableSerializableElement(r1, 2, ImageUploadInfo.a.a, null);
            VideoUploadInfo r8 = (VideoUploadInfo) r0.decodeNullableSerializableElement(r1, 3, VideoUploadInfo.a.a, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            ImageUploadInfo r12 = r4;
            Boolean r15 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, nuc.i.a, null);
            String r11 = r6;
            String r10 = r7;
            VideoUploadInfo r13 = r8;
            int r16 = 63;
        L21:
            r0.endStructure(r1);
            return new MediaAttachment(r16, r10, r11, r12, r13, r14, r15, null);
        L5:
            r10 = null;
            VideoUploadInfo r17 = null;
            r12 = null;
            String r18 = null;
            r14 = null;
            int r5 = 0;
            boolean r110 = true;
        L6:
            if (r110 == false) goto L20;
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
            r110 = false;
            goto L6
        L11:
            r9 = (Boolean) r0.decodeNullableSerializableElement(r1, 5, nuc.i.a, r9);
            r5 = r5 | 32;
        L18:
            r3 = 2;
            goto L6
        L12:
            r14 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r14);
            r5 = r5 | 16;
            goto L18
        L13:
            r17 = (VideoUploadInfo) r0.decodeNullableSerializableElement(r1, 3, VideoUploadInfo.a.a, r17);
            r5 = r5 | 8;
            goto L18
        L14:
            r12 = (ImageUploadInfo) r0.decodeNullableSerializableElement(r1, r3, ImageUploadInfo.a.a, r12);
            r5 = r5 | 4;
            goto L18
        L15:
            r18 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r18);
            r5 = r5 | 2;
            goto L18
        L17:
            r5 = r5 | 1;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r10);
            goto L18
        L20:
            r15 = r9;
            r16 = r5;
            String r111 = r18;
            r13 = r17;
            r11 = r111;
            goto L21
        }

        public final void serialize(muc.f r2, Object r3) {
            MediaAttachment r4 = (MediaAttachment) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            MediaAttachment.write$Self$instruction_core_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<MediaAttachment> serializer() {
            return a.a;
        }
    }

    public MediaAttachment() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ MediaAttachment copy$default(MediaAttachment r13, String r14, String r15, ImageUploadInfo r16, VideoUploadInfo r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, Boolean r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r2 = r13.url;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = r13.uri;
    L11:
        if ((r26 & 4) == 0) goto L13;
        ImageUploadInfo r4 = r13.imageUploadInfo;
    L15:
        if ((r26 & 8) == 0) goto L17;
        VideoUploadInfo r5 = r13.videoUploadInfo;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = r13.localFilePath;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.identifier;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = r13.resourceId;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = r13.localMessageId;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r10 = r13.originUrl;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r11 = r13.previewUrl;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = r13.maskUri;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        Boolean r1 = r13.aiCreationImage;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    @SerialName("ai_creation_image")
    public static /* synthetic */ void getAiCreationImage$annotations() {
    }

    @Transient
    public static /* synthetic */ void getIdentifier$annotations() {
    }

    @SerialName("image_upload_info")
    public static /* synthetic */ void getImageUploadInfo$annotations() {
    }

    @Transient
    public static /* synthetic */ void getLocalFilePath$annotations() {
    }

    @Transient
    public static /* synthetic */ void getLocalMessageId$annotations() {
    }

    @SerialName("mask_uri")
    public static /* synthetic */ void getMaskUri$annotations() {
    }

    @Transient
    public static /* synthetic */ void getOriginUrl$annotations() {
    }

    @Transient
    public static /* synthetic */ void getPreviewUrl$annotations() {
    }

    @Transient
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName("uri")
    public static /* synthetic */ void getUri$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    @SerialName("video_upload_info")
    public static /* synthetic */ void getVideoUploadInfo$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final String component10() {
        return this.previewUrl;
    }

    public final String component11() {
        return this.maskUri;
    }

    public final Boolean component12() {
        return this.aiCreationImage;
    }

    public final String component2() {
        return this.uri;
    }

    public final ImageUploadInfo component3() {
        return this.imageUploadInfo;
    }

    public final VideoUploadInfo component4() {
        return this.videoUploadInfo;
    }

    public final String component5() {
        return this.localFilePath;
    }

    public final String component6() {
        return this.identifier;
    }

    public final String component7() {
        return this.resourceId;
    }

    public final String component8() {
        return this.localMessageId;
    }

    public final String component9() {
        return this.originUrl;
    }

    public final MediaAttachment copy(String r15, String r16, ImageUploadInfo r17, VideoUploadInfo r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, Boolean r26) {
        return new MediaAttachment(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MediaAttachment) == true) goto L8;
        return false;
    L8:
        MediaAttachment r6 = (MediaAttachment) r5;
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageUploadInfo, r6.imageUploadInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoUploadInfo, r6.videoUploadInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.localFilePath, r6.localFilePath) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.identifier, r6.identifier) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.resourceId, r6.resourceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.localMessageId, r6.localMessageId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.originUrl, r6.originUrl) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.previewUrl, r6.previewUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.maskUri, r6.maskUri) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.aiCreationImage, r6.aiCreationImage) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.uri;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ImageUploadInfo r7 = this.imageUploadInfo;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        VideoUploadInfo r10 = this.videoUploadInfo;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.localFilePath;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.identifier;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.resourceId;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.localMessageId;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.originUrl;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.previewUrl;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.maskUri;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Boolean r34 = this.aiCreationImage;
        if (r34 == null) goto L51;
        r1 = r34.hashCode();
    L51:
        return r33 + r1;
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
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
        return "MediaAttachment(url=" + this.url + ", uri=" + this.uri + ", imageUploadInfo=" + this.imageUploadInfo + ", videoUploadInfo=" + this.videoUploadInfo + ", localFilePath=" + this.localFilePath + ", identifier=" + this.identifier + ", resourceId=" + this.resourceId + ", localMessageId=" + this.localMessageId + ", originUrl=" + this.originUrl + ", previewUrl=" + this.previewUrl + ", maskUri=" + this.maskUri + ", aiCreationImage=" + this.aiCreationImage + ')';
    }

    static {
        Companion = new b();
    }

    public final Boolean getAiCreationImage() {
        return this.aiCreationImage;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final ImageUploadInfo getImageUploadInfo() {
        return this.imageUploadInfo;
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getMaskUri() {
        return this.maskUri;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public final VideoUploadInfo getVideoUploadInfo() {
        return this.videoUploadInfo;
    }

    public final void setAiCreationImage(Boolean r1) {
        this.aiCreationImage = r1;
    }

    public final void setIdentifier(String r1) {
        this.identifier = r1;
    }

    public final void setImageUploadInfo(ImageUploadInfo r1) {
        this.imageUploadInfo = r1;
    }

    public final void setLocalFilePath(String r1) {
        this.localFilePath = r1;
    }

    public final void setLocalMessageId(String r1) {
        this.localMessageId = r1;
    }

    public final void setMaskUri(String r1) {
        this.maskUri = r1;
    }

    public final void setOriginUrl(String r1) {
        this.originUrl = r1;
    }

    public final void setPreviewUrl(String r1) {
        this.previewUrl = r1;
    }

    public final void setResourceId(String r1) {
        this.resourceId = r1;
    }

    public final void setUri(String r1) {
        this.uri = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setVideoUploadInfo(VideoUploadInfo r1) {
        this.videoUploadInfo = r1;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$instruction_core_api_release(MediaAttachment r5, muc.d r6, luc.f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, v2.a, r5.url);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.uri);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, ImageUploadInfo.a.a, r5.imageUploadInfo);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, VideoUploadInfo.a.a, r5.videoUploadInfo);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, v2.a, r5.maskUri);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        r0 = true;
    L53:
        if (r0 == false) goto L56;
        r6.encodeNullableSerializableElement(r7, 5, nuc.i.a, r5.aiCreationImage);
        return;
    L56:
        return;
    L51:
        if (r5.aiCreationImage == null) goto L53;
    L42:
        if (r5.maskUri != null) goto L40;
        r8 = false;
        goto L45
    L33:
        if (r5.videoUploadInfo != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.imageUploadInfo != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.uri != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.url != null) goto L4;
        r1 = false;
        goto L9
    }

    public MediaAttachment(int r2, String r3, String r4, ImageUploadInfo r5, VideoUploadInfo r6, String r7, Boolean r8, q2 r9) {
        if ((r2 & 0) == 0) goto L5;
        nuc.b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.url = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.uri = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.imageUploadInfo = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.videoUploadInfo = null;
    L20:
        this.localFilePath = null;
        this.identifier = null;
        this.resourceId = null;
        this.localMessageId = null;
        this.originUrl = null;
        this.previewUrl = null;
        if ((r2 & 16) != 0) goto L23;
        this.maskUri = null;
    L25:
        if ((r2 & 32) != 0) goto L27;
        this.aiCreationImage = null;
        return;
    L27:
        this.aiCreationImage = r8;
        return;
    L23:
        this.maskUri = r7;
        goto L25
    L19:
        this.videoUploadInfo = r6;
        goto L20
    L15:
        this.imageUploadInfo = r5;
        goto L17
    L11:
        this.uri = r4;
        goto L13
    L7:
        this.url = r3;
        goto L9
    }

    public MediaAttachment(String r1, String r2, ImageUploadInfo r3, VideoUploadInfo r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, Boolean r12) {
        this.url = r1;
        this.uri = r2;
        this.imageUploadInfo = r3;
        this.videoUploadInfo = r4;
        this.localFilePath = r5;
        this.identifier = r6;
        this.resourceId = r7;
        this.localMessageId = r8;
        this.originUrl = r9;
        this.previewUrl = r10;
        this.maskUri = r11;
        this.aiCreationImage = r12;
    }

    public /* synthetic */ MediaAttachment(String r14, String r15, ImageUploadInfo r16, VideoUploadInfo r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, Boolean r25, int r26, DefaultConstructorMarker r27) {
        Boolean r2 = null;
        if ((r26 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r26 & 4) == 0) goto L13;
        ImageUploadInfo r4 = null;
    L15:
        if ((r26 & 8) == 0) goto L17;
        VideoUploadInfo r5 = null;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r26 & 2048) != 0) goto L50;
        r2 = r25;
    L50:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r2);
        return;
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r1 = r14;
        goto L7
    }
}
