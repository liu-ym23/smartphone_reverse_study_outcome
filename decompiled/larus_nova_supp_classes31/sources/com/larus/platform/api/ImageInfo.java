package com.larus.platform.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00060\u0001j\u0002`\u0002:\u0002KLB\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010B\u007f\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0081\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u00108\u001a\u00020\u0012J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0012HÖ\u0001J\t\u0010>\u001a\u00020\tHÖ\u0001J\u0016\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0012J%\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\"R\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\"R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\"R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019¨\u0006M"}, d2 = {"Lcom/larus/platform/api/ImageInfo;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "imageOrigin", "Lcom/larus/platform/api/Image;", "imageThumb", "imagePre", "imageRef", "key", "", "requestId", "imageTips", "privateImage", "rawImage", "rawThumbImage", "<init>", "(Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lcom/larus/platform/api/Image;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageOrigin$annotations", "()V", "getImageOrigin", "()Lcom/larus/platform/api/Image;", "getImageThumb$annotations", "getImageThumb", "getImagePre$annotations", "getImagePre", "getImageRef$annotations", "getImageRef", "getKey$annotations", "getKey", "()Ljava/lang/String;", "getRequestId$annotations", "getRequestId", "getImageTips$annotations", "getImageTips", "getPrivateImage$annotations", "getPrivateImage", "getRawImage$annotations", "getRawImage", "getRawThumbImage$annotations", "getRawThumbImage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class ImageInfo implements Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = null;
    public static final b Companion = null;
    public final Image a;
    public final Image b;
    public final Image c;
    public final Image d;
    public final String e;
    public final String f;
    public final String g;
    public final Image h;
    public final Image i;
    public final Image j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<ImageInfo> {
        public static final a a = null;
        public static final nuc.g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            nuc.g2 r1 = new nuc.g2("com.larus.platform.api.ImageInfo", r0, 10);
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

        public final juc.d<?>[] childSerializers() {
            Image.a r1 = Image.a.a;
            nuc.v2 r2 = nuc.v2.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return nuc.i2.a;
        }

        public final Object deserialize(muc.e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            nuc.g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            int r3 = 8;
            int r6 = 6;
            int r7 = 7;
            Image r13 = null;
            if (r0.decodeSequentially() == false) goto L5;
            Image.a r2 = Image.a.a;
            Image r11 = (Image) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            Image r12 = (Image) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            Image r9 = (Image) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            Image r4 = (Image) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            nuc.v2 r14 = nuc.v2.a;
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 4, r14, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 5, r14, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 6, r14, null);
            Image r15 = (Image) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            Image r16 = (Image) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            Image r17 = (Image) r0.decodeNullableSerializableElement(r1, 9, r2, null);
            Image r18 = r16;
            String r19 = r5;
            String r110 = r8;
            Image r111 = r15;
            Image r20 = r11;
            int r21 = 1023;
            Image r112 = r4;
            Image r113 = r9;
            Image r22 = r12;
            String r114 = r10;
        L27:
            r0.endStructure(r1);
            return new ImageInfo(r21, r20, r22, r113, r112, r114, r19, r110, r111, r18, r17);
        L5:
            Image r24 = null;
            Image r25 = null;
            Image r115 = null;
            String r116 = null;
            String r117 = null;
            Image r118 = null;
            String r119 = null;
            Image r120 = null;
            Image r121 = null;
            int r26 = 0;
            boolean r27 = true;
        L6:
            if (r27 == false) goto L26;
            int r28 = r0.decodeElementIndex(r1);
            switch(r28) {
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
            throw new UnknownFieldException(r28);
        L25:
            r3 = 8;
            r6 = 6;
            r7 = 7;
            r27 = false;
            goto L6
        L11:
            r24 = (Image) r0.decodeNullableSerializableElement(r1, 9, Image.a.a, r24);
            r26 = r26 | 512;
        L20:
            Image r29 = r120;
        L22:
            Image r30 = r121;
        L24:
            r120 = r29;
            r121 = r30;
            r3 = 8;
            r6 = 6;
            r7 = 7;
            goto L6
        L12:
            r25 = (Image) r0.decodeNullableSerializableElement(r1, r3, Image.a.a, r25);
            r26 = r26 | 256;
            goto L20
        L13:
            r115 = (Image) r0.decodeNullableSerializableElement(r1, r7, Image.a.a, r115);
            r26 = r26 | 128;
            goto L20
        L14:
            r117 = (String) r0.decodeNullableSerializableElement(r1, r6, nuc.v2.a, r117);
            r26 = r26 | 64;
            goto L20
        L16:
            r116 = (String) r0.decodeNullableSerializableElement(r1, 5, nuc.v2.a, r116);
            r26 = r26 | 32;
            goto L20
        L17:
            r119 = (String) r0.decodeNullableSerializableElement(r1, 4, nuc.v2.a, r119);
            r26 = r26 | 16;
            goto L20
        L18:
            r118 = (Image) r0.decodeNullableSerializableElement(r1, 3, Image.a.a, r118);
            r26 = r26 | 8;
            goto L20
        L19:
            r120 = (Image) r0.decodeNullableSerializableElement(r1, 2, Image.a.a, r120);
            r26 = r26 | 4;
            goto L20
        L21:
            r29 = r120;
            r121 = (Image) r0.decodeNullableSerializableElement(r1, 1, Image.a.a, r121);
            r26 = r26 | 2;
            goto L22
        L23:
            r29 = r120;
            r30 = r121;
            r26 = r26 | 1;
            r13 = (Image) r0.decodeNullableSerializableElement(r1, 0, Image.a.a, r13);
            goto L24
        L26:
            r21 = r26;
            r17 = r24;
            r18 = r25;
            r20 = r13;
            r22 = r121;
            r19 = r116;
            r112 = r118;
            r110 = r117;
            r114 = r119;
            r111 = r115;
            r113 = r120;
            goto L27
        }

        public final void serialize(muc.f r7, Object r8) {
            ImageInfo r9 = (ImageInfo) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            nuc.g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = ImageInfo.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, Image.a.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, Image.a.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, Image.a.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, Image.a.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, nuc.v2.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, nuc.v2.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, nuc.v2.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r10.encodeNullableSerializableElement(r0, 7, Image.a.a, r9.h);
        L75:
            if (r10.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r10.encodeNullableSerializableElement(r0, 8, Image.a.a, r9.i);
        L84:
            if (r10.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            r2 = true;
        L89:
            if (r2 == false) goto L91;
            r10.encodeNullableSerializableElement(r0, 9, Image.a.a, r9.j);
        L91:
            r10.endStructure(r0);
            return;
        L87:
            if (r9.j == null) goto L89;
        L78:
            if (r9.i != null) goto L79;
            r15 = false;
            goto L81
        L69:
            if (r9.h != null) goto L70;
            r14 = false;
            goto L72
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

        public final juc.d<ImageInfo> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<ImageInfo> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageInfo createFromParcel(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            Image r2 = null;
            if (r13.readInt() != 0) goto L5;
            Image r1 = null;
        L6:
            Image r3 = r1;
            if (r13.readInt() != 0) goto L9;
            Image r4 = null;
        L10:
            Image r5 = r4;
            if (r13.readInt() != 0) goto L13;
            Image r6 = null;
        L14:
            Image r7 = r6;
            if (r13.readInt() != 0) goto L17;
            Image r8 = null;
        L18:
            Image r9 = r8;
            String r10 = r13.readString();
            String r11 = r13.readString();
            String r12 = r13.readString();
            if (r13.readInt() != 0) goto L21;
            Image r14 = null;
        L22:
            Image r15 = r14;
            if (r13.readInt() != 0) goto L25;
            Image r16 = null;
        L26:
            Image r17 = r16;
            if (r13.readInt() == 0) goto L31;
            r2 = Image.CREATOR.createFromParcel(r13);
        L31:
            return new ImageInfo(r3, r5, r7, r9, r10, r11, r12, r15, r17, r2);
        L25:
            r16 = Image.CREATOR.createFromParcel(r13);
            goto L26
        L21:
            r14 = Image.CREATOR.createFromParcel(r13);
            goto L22
        L17:
            r8 = Image.CREATOR.createFromParcel(r13);
            goto L18
        L13:
            r6 = Image.CREATOR.createFromParcel(r13);
            goto L14
        L9:
            r4 = Image.CREATOR.createFromParcel(r13);
            goto L10
        L5:
            r1 = Image.CREATOR.createFromParcel(r13);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ImageInfo[] newArray(int r1) {
            return new ImageInfo[r1];
        }
    }

    public ImageInfo() {
        this(null, null, null, null, null, null, null, null, null, 1023);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageInfo) == true) goto L8;
        return false;
    L8:
        ImageInfo r6 = (ImageInfo) r5;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Image r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Image r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Image r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Image r10 = this.d;
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
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Image r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Image r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Image r28 = this.j;
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

    public final String toString() {
        return "ImageInfo(imageOrigin=" + this.a + ", imageThumb=" + this.b + ", imagePre=" + this.c + ", imageRef=" + this.d + ", key=" + this.e + ", requestId=" + this.f + ", imageTips=" + this.g + ", privateImage=" + this.h + ", rawImage=" + this.i + ", rawThumbImage=" + this.j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        Image r0 = this.a;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        Image r1 = this.b;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        Image r2 = this.c;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        Image r3 = this.d;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        r4.writeString(this.e);
        r4.writeString(this.f);
        r4.writeString(this.g);
        Image r6 = this.h;
        if (r6 != null) goto L21;
        r4.writeInt(0);
    L22:
        Image r7 = this.i;
        if (r7 != null) goto L25;
        r4.writeInt(0);
    L26:
        Image r8 = this.j;
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
        CREATOR = new c();
    }

    public static ImageInfo a(ImageInfo r14, Image r15, Image r16, Image r17, Image r18, Image r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        Image r4 = r14.a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        Image r5 = r14.b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Image r6 = r14.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Image r7 = r14.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r8 = r14.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r9 = r14.f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r10 = r14.g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Image r11 = r14.h;
    L35:
        if ((r20 & 256) == 0) goto L37;
        Image r12 = r14.i;
    L39:
        if ((r20 & 512) == 0) goto L41;
        Image r13 = r14.j;
    L42:
        r14.getClass();
        return new ImageInfo(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L41:
        r13 = r19;
        goto L42
    L37:
        r12 = r18;
        goto L39
    L33:
        r11 = null;
        goto L35
    L29:
        r10 = null;
        goto L31
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public /* synthetic */ ImageInfo(Image r15, Image r16, Image r17, Image r18, String r19, String r20, String r21, Image r22, Image r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        Image r4 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Image r5 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Image r6 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Image r7 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r24 & 256) == 0) goto L33;
        Image r12 = null;
    L35:
        if ((r24 & 512) == 0) goto L37;
        Image r13 = null;
    L38:
        this(r4, r5, r6, r7, r8, r9, r10, null, r12, r13);
        return;
    L37:
        r13 = r23;
        goto L38
    L33:
        r12 = r22;
        goto L35
    L29:
        r10 = r21;
        goto L31
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public ImageInfo(Image r1, Image r2, Image r3, Image r4, String r5, String r6, String r7, Image r8, Image r9, Image r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public ImageInfo(int r3, Image r4, Image r5, Image r6, Image r7, String r8, String r9, String r10, Image r11, Image r12, Image r13) {
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
    L37:
        if ((r3 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r3 & 512) != 0) goto L43;
        this.j = null;
        return;
    L43:
        this.j = r13;
        return;
    L39:
        this.i = r12;
        goto L41
    L35:
        this.h = r11;
        goto L37
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
