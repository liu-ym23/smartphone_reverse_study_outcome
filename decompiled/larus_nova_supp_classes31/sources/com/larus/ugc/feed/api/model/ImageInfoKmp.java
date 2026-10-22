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
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00060\u0001j\u0002`\u0002:\u0002KLB\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010B\u007f\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0081\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u00108\u001a\u00020\u0012J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0012HÖ\u0001J\t\u0010>\u001a\u00020\tHÖ\u0001J\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0012J%\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\"R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\"R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019¨\u0006M"}, d2 = {"Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "imageOrigin", "Lcom/larus/ugc/feed/api/model/ImageKmp;", "imageThumb", "imagePre", "imageRef", "key", "", "requestId", "imageTips", "privateImage", "rawImage", "rawThumbImage", "<init>", "(Lcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;Lcom/larus/ugc/feed/api/model/ImageKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageOrigin$annotations", "()V", "getImageOrigin", "()Lcom/larus/ugc/feed/api/model/ImageKmp;", "getImageThumb$annotations", "getImageThumb", "getImagePre$annotations", "getImagePre", "getImageRef$annotations", "getImageRef", "getKey$annotations", "getKey", "()Ljava/lang/String;", "getRequestId$annotations", "getRequestId", "getImageTips$annotations", "getImageTips", "getPrivateImage$annotations", "getPrivateImage", "getRawImage$annotations", "getRawImage", "getRawThumbImage$annotations", "getRawThumbImage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class ImageInfoKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<ImageInfoKmp> CREATOR = null;
    public static final b Companion = null;
    private final ImageKmp imageOrigin;
    private final ImageKmp imagePre;
    private final ImageKmp imageRef;
    private final ImageKmp imageThumb;
    private final String imageTips;
    private final String key;
    private final ImageKmp privateImage;
    private final ImageKmp rawImage;
    private final ImageKmp rawThumbImage;
    private final String requestId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ImageInfoKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.ImageInfoKmp", r0, 10);
            r1.j("image_ori", true);
            r1.j("image_thumb", true);
            r1.j("preview_img", true);
            r1.j("ref_image", true);
            r1.j("key", true);
            r1.j("request_id", true);
            r1.j("tips", true);
            r1.j("private_img", true);
            r1.j("raw_image", true);
            r1.j("raw_thumb_image", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            ImageKmp.a r1 = ImageKmp.a.a;
            v2 r2 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            int r3 = 8;
            int r6 = 6;
            int r7 = 7;
            ImageKmp r13 = null;
            if (r0.decodeSequentially() == false) goto L5;
            ImageKmp.a r2 = ImageKmp.a.a;
            ImageKmp r11 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            ImageKmp r12 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            ImageKmp r9 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            ImageKmp r4 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            v2 r14 = v2.a;
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 4, r14, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 5, r14, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 6, r14, null);
            ImageKmp r15 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            ImageKmp r16 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            ImageKmp r17 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 9, r2, null);
            ImageKmp r18 = r16;
            String r19 = r5;
            String r110 = r8;
            ImageKmp r111 = r15;
            ImageKmp r20 = r11;
            int r21 = 1023;
            ImageKmp r112 = r4;
            ImageKmp r113 = r9;
            ImageKmp r22 = r12;
            String r114 = r10;
        L27:
            r0.endStructure(r1);
            return new ImageInfoKmp(r21, r20, r22, r113, r112, r114, r19, r110, r111, r18, r17, null);
        L5:
            ImageKmp r23 = null;
            ImageKmp r25 = null;
            ImageKmp r115 = null;
            String r116 = null;
            String r117 = null;
            ImageKmp r118 = null;
            String r119 = null;
            ImageKmp r120 = null;
            ImageKmp r26 = null;
            int r27 = 0;
            boolean r28 = true;
        L6:
            if (r28 == false) goto L26;
            int r29 = r0.decodeElementIndex(r1);
            switch(r29) {
                case -1: goto L25;
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r29);
        L25:
            r3 = 8;
            r6 = 6;
            r7 = 7;
            r28 = false;
            goto L6
        L11:
            r23 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 9, ImageKmp.a.a, r23);
            r27 = r27 | 512;
        L20:
            ImageKmp r30 = r120;
        L22:
            ImageKmp r31 = r26;
        L24:
            r120 = r30;
            r26 = r31;
            r3 = 8;
            r6 = 6;
            r7 = 7;
            goto L6
        L12:
            r25 = (ImageKmp) r0.decodeNullableSerializableElement(r1, r3, ImageKmp.a.a, r25);
            r27 = r27 | 256;
            goto L20
        L13:
            r115 = (ImageKmp) r0.decodeNullableSerializableElement(r1, r7, ImageKmp.a.a, r115);
            r27 = r27 | 128;
            goto L20
        L14:
            r117 = (String) r0.decodeNullableSerializableElement(r1, r6, v2.a, r117);
            r27 = r27 | 64;
            goto L20
        L16:
            r116 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r116);
            r27 = r27 | 32;
            goto L20
        L17:
            r119 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r119);
            r27 = r27 | 16;
            goto L20
        L18:
            r118 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 3, ImageKmp.a.a, r118);
            r27 = r27 | 8;
            goto L20
        L19:
            r120 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 2, ImageKmp.a.a, r120);
            r27 = r27 | 4;
            goto L20
        L21:
            r30 = r120;
            r26 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 1, ImageKmp.a.a, r26);
            r27 = r27 | 2;
            goto L22
        L23:
            r30 = r120;
            r31 = r26;
            r27 = r27 | 1;
            r13 = (ImageKmp) r0.decodeNullableSerializableElement(r1, 0, ImageKmp.a.a, r13);
            goto L24
        L26:
            r21 = r27;
            r17 = r23;
            r18 = r25;
            r20 = r13;
            r22 = r26;
            r19 = r116;
            r112 = r118;
            r110 = r117;
            r114 = r119;
            r111 = r115;
            r113 = r120;
            goto L27
        }

        public final void serialize(muc.f r2, Object r3) {
            ImageInfoKmp r4 = (ImageInfoKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            ImageInfoKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ImageInfoKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<ImageInfoKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageInfoKmp createFromParcel(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            ImageKmp r2 = null;
            if (r13.readInt() != 0) goto L5;
            ImageKmp r1 = null;
        L6:
            ImageKmp r3 = r1;
            if (r13.readInt() != 0) goto L9;
            ImageKmp r4 = null;
        L10:
            ImageKmp r5 = r4;
            if (r13.readInt() != 0) goto L13;
            ImageKmp r6 = null;
        L14:
            ImageKmp r7 = r6;
            if (r13.readInt() != 0) goto L17;
            ImageKmp r8 = null;
        L18:
            ImageKmp r9 = r8;
            String r10 = r13.readString();
            String r11 = r13.readString();
            String r12 = r13.readString();
            if (r13.readInt() != 0) goto L21;
            ImageKmp r14 = null;
        L22:
            ImageKmp r15 = r14;
            if (r13.readInt() != 0) goto L25;
            ImageKmp r16 = null;
        L26:
            ImageKmp r17 = r16;
            if (r13.readInt() == 0) goto L31;
            r2 = ImageKmp.CREATOR.createFromParcel(r13);
        L31:
            return new ImageInfoKmp(r3, r5, r7, r9, r10, r11, r12, r15, r17, r2);
        L25:
            r16 = ImageKmp.CREATOR.createFromParcel(r13);
            goto L26
        L21:
            r14 = ImageKmp.CREATOR.createFromParcel(r13);
            goto L22
        L17:
            r8 = ImageKmp.CREATOR.createFromParcel(r13);
            goto L18
        L13:
            r6 = ImageKmp.CREATOR.createFromParcel(r13);
            goto L14
        L9:
            r4 = ImageKmp.CREATOR.createFromParcel(r13);
            goto L10
        L5:
            r1 = ImageKmp.CREATOR.createFromParcel(r13);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ImageInfoKmp[] newArray(int r1) {
            return new ImageInfoKmp[r1];
        }
    }

    public ImageInfoKmp() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ ImageInfoKmp copy$default(ImageInfoKmp r11, ImageKmp r12, ImageKmp r13, ImageKmp r14, ImageKmp r15, String r16, String r17, String r18, ImageKmp r19, ImageKmp r20, ImageKmp r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        ImageKmp r2 = r11.imageOrigin;
    L7:
        if ((r22 & 2) == 0) goto L9;
        ImageKmp r3 = r11.imageThumb;
    L11:
        if ((r22 & 4) == 0) goto L13;
        ImageKmp r4 = r11.imagePre;
    L15:
        if ((r22 & 8) == 0) goto L17;
        ImageKmp r5 = r11.imageRef;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.key;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.requestId;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.imageTips;
    L31:
        if ((r22 & 128) == 0) goto L33;
        ImageKmp r9 = r11.privateImage;
    L35:
        if ((r22 & 256) == 0) goto L37;
        ImageKmp r10 = r11.rawImage;
    L39:
        if ((r22 & 512) == 0) goto L41;
        ImageKmp r1 = r11.rawThumbImage;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    @SerialName("image_ori")
    public static /* synthetic */ void getImageOrigin$annotations() {
    }

    @SerialName("preview_img")
    public static /* synthetic */ void getImagePre$annotations() {
    }

    @SerialName("ref_image")
    public static /* synthetic */ void getImageRef$annotations() {
    }

    @SerialName("image_thumb")
    public static /* synthetic */ void getImageThumb$annotations() {
    }

    @SerialName("tips")
    public static /* synthetic */ void getImageTips$annotations() {
    }

    @SerialName("key")
    public static /* synthetic */ void getKey$annotations() {
    }

    @SerialName("private_img")
    public static /* synthetic */ void getPrivateImage$annotations() {
    }

    @SerialName("raw_image")
    public static /* synthetic */ void getRawImage$annotations() {
    }

    @SerialName("raw_thumb_image")
    public static /* synthetic */ void getRawThumbImage$annotations() {
    }

    @SerialName("request_id")
    public static /* synthetic */ void getRequestId$annotations() {
    }

    public final ImageKmp component1() {
        return this.imageOrigin;
    }

    public final ImageKmp component10() {
        return this.rawThumbImage;
    }

    public final ImageKmp component2() {
        return this.imageThumb;
    }

    public final ImageKmp component3() {
        return this.imagePre;
    }

    public final ImageKmp component4() {
        return this.imageRef;
    }

    public final String component5() {
        return this.key;
    }

    public final String component6() {
        return this.requestId;
    }

    public final String component7() {
        return this.imageTips;
    }

    public final ImageKmp component8() {
        return this.privateImage;
    }

    public final ImageKmp component9() {
        return this.rawImage;
    }

    public final ImageInfoKmp copy(ImageKmp r13, ImageKmp r14, ImageKmp r15, ImageKmp r16, String r17, String r18, String r19, ImageKmp r20, ImageKmp r21, ImageKmp r22) {
        return new ImageInfoKmp(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageInfoKmp) == true) goto L8;
        return false;
    L8:
        ImageInfoKmp r6 = (ImageInfoKmp) r5;
        if (Intrinsics.areEqual(this.imageOrigin, r6.imageOrigin) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageThumb, r6.imageThumb) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imagePre, r6.imagePre) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageRef, r6.imageRef) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageTips, r6.imageTips) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.privateImage, r6.privateImage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.rawImage, r6.rawImage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.rawThumbImage, r6.rawThumbImage) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        ImageKmp r0 = this.imageOrigin;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ImageKmp r4 = this.imageThumb;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ImageKmp r7 = this.imagePre;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ImageKmp r10 = this.imageRef;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.key;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.requestId;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.imageTips;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        ImageKmp r22 = this.privateImage;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        ImageKmp r25 = this.rawImage;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        ImageKmp r28 = this.rawThumbImage;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
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
        return "ImageInfoKmp(imageOrigin=" + this.imageOrigin + ", imageThumb=" + this.imageThumb + ", imagePre=" + this.imagePre + ", imageRef=" + this.imageRef + ", key=" + this.key + ", requestId=" + this.requestId + ", imageTips=" + this.imageTips + ", privateImage=" + this.privateImage + ", rawImage=" + this.rawImage + ", rawThumbImage=" + this.rawThumbImage + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        ImageKmp r0 = this.imageOrigin;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        ImageKmp r1 = this.imageThumb;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        ImageKmp r2 = this.imagePre;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        ImageKmp r3 = this.imageRef;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        r4.writeString(this.key);
        r4.writeString(this.requestId);
        r4.writeString(this.imageTips);
        ImageKmp r6 = this.privateImage;
        if (r6 != null) goto L21;
        r4.writeInt(0);
    L22:
        ImageKmp r7 = this.rawImage;
        if (r7 != null) goto L25;
        r4.writeInt(0);
    L26:
        ImageKmp r8 = this.rawThumbImage;
        if (r8 != null) goto L29;
        r4.writeInt(0);
        return;
    L29:
        r4.writeInt(1);
        r8.writeToParcel(r4, r5);
        return;
    L25:
        r4.writeInt(1);
        r7.writeToParcel(r4, r5);
        goto L26
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

    public final ImageKmp getImageOrigin() {
        return this.imageOrigin;
    }

    public final ImageKmp getImagePre() {
        return this.imagePre;
    }

    public final ImageKmp getImageRef() {
        return this.imageRef;
    }

    public final ImageKmp getImageThumb() {
        return this.imageThumb;
    }

    public final String getImageTips() {
        return this.imageTips;
    }

    public final String getKey() {
        return this.key;
    }

    public final ImageKmp getPrivateImage() {
        return this.privateImage;
    }

    public final ImageKmp getRawImage() {
        return this.rawImage;
    }

    public final ImageKmp getRawThumbImage() {
        return this.rawThumbImage;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(ImageInfoKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, ImageKmp.a.a, r5.imageOrigin);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, ImageKmp.a.a, r5.imageThumb);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, ImageKmp.a.a, r5.imagePre);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, ImageKmp.a.a, r5.imageRef);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, v2.a, r5.key);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        boolean r9 = true;
    L54:
        if (r9 == false) goto L57;
        r6.encodeNullableSerializableElement(r7, 5, v2.a, r5.requestId);
    L57:
        if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L60;
    L58:
        boolean r10 = true;
    L63:
        if (r10 == false) goto L66;
        r6.encodeNullableSerializableElement(r7, 6, v2.a, r5.imageTips);
    L66:
        if (r6.shouldEncodeElementDefault(r7, 7) == false) goto L69;
    L67:
        boolean r11 = true;
    L72:
        if (r11 == false) goto L75;
        r6.encodeNullableSerializableElement(r7, 7, ImageKmp.a.a, r5.privateImage);
    L75:
        if (r6.shouldEncodeElementDefault(r7, 8) == false) goto L78;
    L76:
        boolean r12 = true;
    L81:
        if (r12 == false) goto L84;
        r6.encodeNullableSerializableElement(r7, 8, ImageKmp.a.a, r5.rawImage);
    L84:
        if (r6.shouldEncodeElementDefault(r7, 9) == false) goto L87;
    L85:
        r0 = true;
    L89:
        if (r0 == false) goto L92;
        r6.encodeNullableSerializableElement(r7, 9, ImageKmp.a.a, r5.rawThumbImage);
        return;
    L92:
        return;
    L87:
        if (r5.rawThumbImage == null) goto L89;
    L78:
        if (r5.rawImage != null) goto L76;
        r12 = false;
        goto L81
    L69:
        if (r5.privateImage != null) goto L67;
        r11 = false;
        goto L72
    L60:
        if (r5.imageTips != null) goto L58;
        r10 = false;
        goto L63
    L51:
        if (r5.requestId != null) goto L49;
        r9 = false;
        goto L54
    L42:
        if (r5.key != null) goto L40;
        r8 = false;
        goto L45
    L33:
        if (r5.imageRef != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.imagePre != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.imageThumb != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.imageOrigin != null) goto L4;
        r1 = false;
        goto L9
    }

    public ImageInfoKmp(ImageKmp r1, ImageKmp r2, ImageKmp r3, ImageKmp r4, String r5, String r6, String r7, ImageKmp r8, ImageKmp r9, ImageKmp r10) {
        this.imageOrigin = r1;
        this.imageThumb = r2;
        this.imagePre = r3;
        this.imageRef = r4;
        this.key = r5;
        this.requestId = r6;
        this.imageTips = r7;
        this.privateImage = r8;
        this.rawImage = r9;
        this.rawThumbImage = r10;
    }

    public ImageInfoKmp(int r2, ImageKmp r3, ImageKmp r4, ImageKmp r5, ImageKmp r6, String r7, String r8, String r9, ImageKmp r10, ImageKmp r11, ImageKmp r12, q2 r13) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.imageOrigin = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.imageThumb = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.imagePre = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.imageRef = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.key = null;
    L25:
        if ((r2 & 32) != 0) goto L27;
        this.requestId = null;
    L29:
        if ((r2 & 64) != 0) goto L31;
        this.imageTips = null;
    L33:
        if ((r2 & 128) != 0) goto L35;
        this.privateImage = null;
    L37:
        if ((r2 & 256) != 0) goto L39;
        this.rawImage = null;
    L41:
        if ((r2 & 512) != 0) goto L43;
        this.rawThumbImage = null;
        return;
    L43:
        this.rawThumbImage = r12;
        return;
    L39:
        this.rawImage = r11;
        goto L41
    L35:
        this.privateImage = r10;
        goto L37
    L31:
        this.imageTips = r9;
        goto L33
    L27:
        this.requestId = r8;
        goto L29
    L23:
        this.key = r7;
        goto L25
    L19:
        this.imageRef = r6;
        goto L21
    L15:
        this.imagePre = r5;
        goto L17
    L11:
        this.imageThumb = r4;
        goto L13
    L7:
        this.imageOrigin = r3;
        goto L9
    }

    public /* synthetic */ ImageInfoKmp(ImageKmp r12, ImageKmp r13, ImageKmp r14, ImageKmp r15, String r16, String r17, String r18, ImageKmp r19, ImageKmp r20, ImageKmp r21, int r22, DefaultConstructorMarker r23) {
        ImageKmp r2 = null;
        if ((r22 & 1) == 0) goto L5;
        ImageKmp r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        ImageKmp r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        ImageKmp r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        ImageKmp r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        ImageKmp r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        ImageKmp r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
