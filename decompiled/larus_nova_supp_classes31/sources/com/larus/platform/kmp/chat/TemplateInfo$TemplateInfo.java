package com.larus.platform.kmp.chat;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.api.creation.UserCreation;
import com.tencent.open.log.TraceLevel;
import juc.d;
import juc.n;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 `2\u00060\u0001j\u0002`\u0002:\u0002_`Bw\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013Bw\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\t\u0010A\u001a\u00020\u0004HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jy\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0006\u0010L\u001a\u00020\u0015J\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0015HÖ\u0001J\t\u0010R\u001a\u00020\bHÖ\u0001J\u0016\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0015J%\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0001¢\u0006\u0002\b^R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R&\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001a\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R$\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\u001a\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR$\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b7\u0010\u001a\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR$\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u0010\u001a\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006a"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "id", "", "type", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;", "prompt", "", "imageThumb", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;", "imageOri", "imagePreview", "ratioId", "styleId", "templatePrimaryId", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "<init>", "(JLcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;Ljava/lang/String;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;JJJLcom/larus/platform/api/creation/UserCreation;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;Ljava/lang/String;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;JJJLcom/larus/platform/api/creation/UserCreation;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()J", "setId", "(J)V", "getType$annotations", "getType", "()Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;", "setType", "(Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateType;)V", "getPrompt$annotations", "getPrompt", "()Ljava/lang/String;", "setPrompt", "(Ljava/lang/String;)V", "getImageThumb$annotations", "getImageThumb", "()Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;", "setImageThumb", "(Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;)V", "getImageOri$annotations", "getImageOri", "setImageOri", "getImagePreview$annotations", "getImagePreview", "setImagePreview", "getRatioId$annotations", "getRatioId", "setRatioId", "getStyleId$annotations", "getStyleId", "setStyleId", "getTemplatePrimaryId$annotations", "getTemplatePrimaryId", "setTemplatePrimaryId", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "setUserCreation", "(Lcom/larus/platform/api/creation/UserCreation;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class TemplateInfo$TemplateInfo implements Parcelable {
    public static final Parcelable.Creator<TemplateInfo$TemplateInfo> CREATOR = null;
    public static final b Companion = null;
    public static final Lazy<d<Object>>[] k = null;
    public final long a;
    public final TemplateInfo$TemplateType b;
    public final String c;
    public final TemplateInfo$TemplateImage d;
    public final TemplateInfo$TemplateImage e;
    public final TemplateInfo$TemplateImage f;
    public final long g;
    public final long h;
    public final long i;
    public final UserCreation j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TemplateInfo$TemplateInfo> {
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
            g2 r1 = new g2("com.larus.platform.kmp.chat.TemplateInfo.TemplateInfo", r0, 10);
            r1.j("id", true);
            r1.j("type", true);
            r1.j("prompt", true);
            r1.j("image_thumb", true);
            r1.j("image_ori", true);
            r1.j("image_preview", true);
            r1.j("ratio_id", true);
            r1.j("style_id", true);
            r1.j("template_primary_key", true);
            r1.j("userCreation", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            Lazy<d<Object>>[] r0 = TemplateInfo$TemplateInfo.k;
            g1 r2 = g1.a;
            TemplateInfo$TemplateImage.a r1 = TemplateInfo$TemplateImage.a.a;
            return new d[]{r2, kuc.a.d((d) r0[1].getValue()), kuc.a.d(v2.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), r2, r2, r2, kuc.a.d(UserCreation.a.a)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r31) {
            Intrinsics.checkNotNullParameter(r31, "decoder");
            g2 r1 = b;
            muc.c r0 = r31.beginStructure(r1);
            Lazy<d<Object>>[] r2 = TemplateInfo$TemplateInfo.k;
            int r4 = 8;
            TemplateInfo$TemplateType r14 = null;
            if (r0.decodeSequentially() == false) goto L5;
            long r15 = r0.decodeLongElement(r1, 0);
            TemplateInfo$TemplateType r3 = (TemplateInfo$TemplateType) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, null);
            TemplateInfo$TemplateImage.a r8 = TemplateInfo$TemplateImage.a.a;
            TemplateInfo$TemplateImage r6 = (TemplateInfo$TemplateImage) r0.decodeNullableSerializableElement(r1, 3, r8, null);
            TemplateInfo$TemplateImage r9 = (TemplateInfo$TemplateImage) r0.decodeNullableSerializableElement(r1, 4, r8, null);
            TemplateInfo$TemplateImage r7 = (TemplateInfo$TemplateImage) r0.decodeNullableSerializableElement(r1, 5, r8, null);
            long r10 = r0.decodeLongElement(r1, 6);
            long r12 = r0.decodeLongElement(r1, 7);
            long r17 = r0.decodeLongElement(r1, 8);
            UserCreation r22 = (UserCreation) r0.decodeNullableSerializableElement(r1, 9, UserCreation.a.a, null);
            TemplateInfo$TemplateImage r16 = r9;
            long r20 = r17;
            int r11 = 1023;
            long r18 = r12;
            String r13 = r5;
            TemplateInfo$TemplateImage r19 = r6;
            TemplateInfo$TemplateType r110 = r3;
            long r21 = r15;
            TemplateInfo$TemplateImage r111 = r7;
            long r112 = r10;
        L27:
            r0.endStructure(r1);
            return new TemplateInfo$TemplateInfo(r11, r21, r110, r13, r19, r16, r111, r112, r18, r20, r22);
        L5:
            long r113 = 0;
            UserCreation r23 = null;
            TemplateInfo$TemplateImage r24 = null;
            TemplateInfo$TemplateImage r25 = null;
            String r114 = null;
            TemplateInfo$TemplateImage r115 = null;
            long r116 = 0;
            long r26 = 0;
            long r27 = 0;
            int r28 = 0;
            boolean r29 = true;
        L6:
            if (r29 == false) goto L26;
            int r30 = r0.decodeElementIndex(r1);
            switch(r30) {
                case -1: goto L25;
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r30);
        L25:
            r4 = 8;
            r29 = false;
            goto L6
        L11:
            r23 = (UserCreation) r0.decodeNullableSerializableElement(r1, 9, UserCreation.a.a, r23);
            r28 = r28 | 512;
        L24:
            r4 = 8;
            goto L6
        L12:
            r27 = r0.decodeLongElement(r1, r4);
            r28 = r28 | 256;
            goto L24
        L13:
            r116 = r0.decodeLongElement(r1, 7);
            r28 = r28 | 128;
            goto L24
        L14:
            r113 = r0.decodeLongElement(r1, 6);
            r28 = r28 | 64;
            goto L24
        L15:
            r25 = (TemplateInfo$TemplateImage) r0.decodeNullableSerializableElement(r1, 5, TemplateInfo$TemplateImage.a.a, r25);
            r28 = r28 | 32;
            goto L24
        L16:
            r24 = (TemplateInfo$TemplateImage) r0.decodeNullableSerializableElement(r1, 4, TemplateInfo$TemplateImage.a.a, r24);
            r28 = r28 | 16;
            goto L24
        L17:
            r115 = (TemplateInfo$TemplateImage) r0.decodeNullableSerializableElement(r1, 3, TemplateInfo$TemplateImage.a.a, r115);
            r28 = r28 | 8;
            goto L24
        L19:
            r114 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r114);
            r28 = r28 | 4;
            goto L24
        L21:
            r14 = (TemplateInfo$TemplateType) r0.decodeNullableSerializableElement(r1, 1, (juc.c) r2[1].getValue(), r14);
            r28 = r28 | 2;
            goto L24
        L23:
            r26 = r0.decodeLongElement(r1, 0);
            r28 = r28 | 1;
            goto L24
        L26:
            r22 = r23;
            r13 = r114;
            r19 = r115;
            r110 = r14;
            r18 = r116;
            r20 = r27;
            r16 = r24;
            r112 = r113;
            r11 = r28;
            r111 = r25;
            r21 = r26;
            goto L27
        }

        public final void serialize(muc.f r12, Object r13) {
            TemplateInfo$TemplateInfo r14 = (TemplateInfo$TemplateInfo) r13;
            Intrinsics.checkNotNullParameter(r12, "encoder");
            Intrinsics.checkNotNullParameter(r14, "value");
            g2 r0 = b;
            muc.d r15 = r12.beginStructure(r0);
            Lazy<d<Object>>[] r1 = TemplateInfo$TemplateInfo.k;
            boolean r2 = false;
            if (r15.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r15.encodeLongElement(r0, 0, r14.a);
        L12:
            if (r15.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r15.encodeNullableSerializableElement(r0, 1, (n) r1[1].getValue(), r14.b);
        L21:
            if (r15.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r15.encodeNullableSerializableElement(r0, 2, v2.a, r14.c);
        L30:
            if (r15.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r15.encodeNullableSerializableElement(r0, 3, TemplateInfo$TemplateImage.a.a, r14.d);
        L39:
            if (r15.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r15.encodeNullableSerializableElement(r0, 4, TemplateInfo$TemplateImage.a.a, r14.e);
        L48:
            if (r15.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r8 = true;
        L54:
            if (r8 == false) goto L57;
            r15.encodeNullableSerializableElement(r0, 5, TemplateInfo$TemplateImage.a.a, r14.f);
        L57:
            if (r15.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r9 = true;
        L63:
            if (r9 == false) goto L66;
            r15.encodeLongElement(r0, 6, r14.g);
        L66:
            if (r15.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r10 = true;
        L72:
            if (r10 == false) goto L75;
            r15.encodeLongElement(r0, 7, r14.h);
        L75:
            if (r15.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r11 = true;
        L81:
            if (r11 == false) goto L84;
            r15.encodeLongElement(r0, 8, r14.i);
        L84:
            if (r15.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            r2 = true;
        L89:
            if (r2 == false) goto L91;
            r15.encodeNullableSerializableElement(r0, 9, UserCreation.a.a, r14.j);
        L91:
            r15.endStructure(r0);
            return;
        L87:
            if (r14.j == null) goto L89;
        L78:
            if (r14.i != 0) goto L79;
            r11 = false;
            goto L81
        L69:
            if (r14.h != (-1)) goto L70;
            r10 = false;
            goto L72
        L60:
            if (r14.g != (-1)) goto L61;
            r9 = false;
            goto L63
        L51:
            if (r14.f != null) goto L52;
            r8 = false;
            goto L54
        L42:
            if (r14.e != null) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r14.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r14.c, "") == false) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r14.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r14.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TemplateInfo$TemplateInfo> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<TemplateInfo$TemplateInfo> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateInfo createFromParcel(Parcel r18) {
            Intrinsics.checkNotNullParameter(r18, "parcel");
            long r3 = r18.readLong();
            UserCreation r5 = null;
            if (r18.readInt() != 0) goto L5;
            TemplateInfo$TemplateType r6 = null;
        L6:
            String r7 = r18.readString();
            if (r18.readInt() != 0) goto L9;
            TemplateInfo$TemplateImage r2 = null;
        L10:
            TemplateInfo$TemplateImage r8 = r2;
            if (r18.readInt() != 0) goto L13;
            TemplateInfo$TemplateImage r4 = null;
        L14:
            TemplateInfo$TemplateImage r9 = r4;
            if (r18.readInt() != 0) goto L17;
            TemplateInfo$TemplateImage r10 = null;
        L18:
            TemplateInfo$TemplateImage r11 = r10;
            long r12 = r18.readLong();
            long r13 = r18.readLong();
            long r15 = r18.readLong();
            if (r18.readInt() == 0) goto L23;
            r5 = UserCreation.CREATOR.createFromParcel(r18);
        L23:
            return new TemplateInfo$TemplateInfo(r3, r6, r7, r8, r9, r11, r12, r13, r15, r5);
        L17:
            r10 = TemplateInfo$TemplateImage.CREATOR.createFromParcel(r18);
            goto L18
        L13:
            r4 = TemplateInfo$TemplateImage.CREATOR.createFromParcel(r18);
            goto L14
        L9:
            r2 = TemplateInfo$TemplateImage.CREATOR.createFromParcel(r18);
            goto L10
        L5:
            r6 = TemplateInfo$TemplateType.valueOf(r18.readString());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateInfo[] newArray(int r1) {
            return new TemplateInfo$TemplateInfo[r1];
        }
    }

    public TemplateInfo$TemplateInfo() {
        this(0, null, null, null, null, 0, 0, 0, null, 1023);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof TemplateInfo$TemplateInfo) == true) goto L8;
        return false;
    L8:
        TemplateInfo$TemplateInfo r9 = (TemplateInfo$TemplateInfo) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        TemplateInfo$TemplateType r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.c;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        TemplateInfo$TemplateImage r9 = this.d;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        TemplateInfo$TemplateImage r12 = this.e;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        TemplateInfo$TemplateImage r15 = this.f;
        if (r15 != null) goto L21;
        int r16 = 0;
    L22:
        long r17 = this.g;
        int r18 = (((r14 + r16) * 31) + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        long r19 = this.h;
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        long r21 = this.i;
        int r22 = (r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31;
        UserCreation r23 = this.j;
        if (r23 == null) goto L27;
        r3 = r23.hashCode();
    L27:
        return r22 + r3;
    L21:
        r16 = r15.hashCode();
        goto L22
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateInfo(id=" + this.a + ", type=" + this.b + ", prompt=" + this.c + ", imageThumb=" + this.d + ", imageOri=" + this.e + ", imagePreview=" + this.f + ", ratioId=" + this.g + ", styleId=" + this.h + ", templatePrimaryId=" + this.i + ", userCreation=" + this.j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeLong(this.a);
        TemplateInfo$TemplateType r0 = this.b;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        r6.writeString(this.c);
        TemplateInfo$TemplateImage r1 = this.d;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        TemplateInfo$TemplateImage r2 = this.e;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L14:
        TemplateInfo$TemplateImage r3 = this.f;
        if (r3 != null) goto L17;
        r6.writeInt(0);
    L18:
        r6.writeLong(this.g);
        r6.writeLong(this.h);
        r6.writeLong(this.i);
        UserCreation r4 = this.j;
        if (r4 != null) goto L21;
        r6.writeInt(0);
        return;
    L21:
        r6.writeInt(1);
        r4.writeToParcel(r6, r7);
        return;
    L17:
        r6.writeInt(1);
        r3.writeToParcel(r6, r7);
        goto L18
    L13:
        r6.writeInt(1);
        r2.writeToParcel(r6, r7);
        goto L14
    L9:
        r6.writeInt(1);
        r1.writeToParcel(r6, r7);
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeString(r0.name());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
        k = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new eq9.a()), null, null, null, null, null, null, null, null};
    }

    public final TemplateInfo$TemplateType getType() {
        return this.b;
    }

    public /* synthetic */ TemplateInfo$TemplateInfo(long r20, String r22, TemplateInfo$TemplateImage r23, TemplateInfo$TemplateImage r24, TemplateInfo$TemplateImage r25, long r26, long r28, long r30, UserCreation r32, int r33) {
        long r2 = 0;
        if ((r33 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r33 & 4) == 0) goto L9;
        String r8 = "";
    L11:
        if ((r33 & 8) == 0) goto L13;
        TemplateInfo$TemplateImage r9 = null;
    L15:
        if ((r33 & 16) == 0) goto L17;
        TemplateInfo$TemplateImage r10 = null;
    L19:
        if ((r33 & 32) == 0) goto L21;
        TemplateInfo$TemplateImage r11 = null;
    L23:
        if ((r33 & 64) == 0) goto L25;
        long r14 = -1;
    L27:
        if ((r33 & 128) == 0) goto L29;
        long r16 = -1;
    L31:
        if ((r33 & 256) != 0) goto L35;
        r2 = r30;
    L35:
        if ((r33 & 512) == 0) goto L37;
        UserCreation r18 = null;
    L38:
        this(r5, null, r8, r9, r10, r11, r14, r16, r2, r18);
        return;
    L37:
        r18 = r32;
        goto L38
    L29:
        r16 = r28;
        goto L31
    L25:
        r14 = r26;
        goto L27
    L21:
        r11 = r25;
        goto L23
    L17:
        r10 = r24;
        goto L19
    L13:
        r9 = r23;
        goto L15
    L9:
        r8 = r22;
        goto L11
    L5:
        r5 = r20;
        goto L7
    }

    public TemplateInfo$TemplateInfo(long r1, TemplateInfo$TemplateType r3, String r4, TemplateInfo$TemplateImage r5, TemplateInfo$TemplateImage r6, TemplateInfo$TemplateImage r7, long r8, long r10, long r12, UserCreation r14) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
        this.i = r12;
        this.j = r14;
    }

    public TemplateInfo$TemplateInfo(int r11, long r12, TemplateInfo$TemplateType r14, String r15, TemplateInfo$TemplateImage r16, TemplateInfo$TemplateImage r17, TemplateInfo$TemplateImage r18, long r19, long r21, long r23, UserCreation r25) {
        if ((r11 & 0) != 0) goto L45;
        long r4 = 0;
        if ((r11 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r11 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r11 & 4) != 0) goto L15;
        String r2 = "";
    L16:
        this.c = r2;
        if ((r11 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r11 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r11 & 32) != 0) goto L27;
        this.f = null;
    L28:
        long r6 = -1;
        if ((r11 & 64) != 0) goto L31;
        this.g = -1;
    L33:
        if ((r11 & 128) == 0) goto L36;
        r6 = r21;
    L36:
        this.h = r6;
        if ((r11 & 256) == 0) goto L40;
        r4 = r23;
    L40:
        this.i = r4;
        if ((r11 & 512) != 0) goto L43;
        this.j = null;
        return;
    L43:
        this.j = r25;
        return;
    L31:
        this.g = r19;
        goto L33
    L27:
        this.f = r18;
        goto L28
    L23:
        this.e = r17;
        goto L25
    L19:
        this.d = r16;
        goto L21
    L15:
        r2 = r15;
        goto L16
    L11:
        this.b = r14;
        goto L13
    L7:
        this.a = r12;
        goto L9
    L45:
        b2.b(r11, 0, a.b);
        throw null;
    }
}
