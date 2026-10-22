package com.larus.ugc.feed.api.tracker.params;

import android.os.Parcel;
import android.os.Parcelable;
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
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 N2\u00060\u0001j\u0002`\u0002:\u0002MNB\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011B\u007f\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0086\u0001\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u00020\bJ\u0013\u0010<\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\bHÖ\u0001J\t\u0010@\u001a\u00020\u0004HÖ\u0001J\u0016\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\bJ%\u0010F\u001a\u00020B2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\bLR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0005\u0010\u001bR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010 \u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0017\u001a\u0004\b,\u0010\u0019R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0017\u001a\u0004\b.\u0010\u0019¨\u0006O"}, d2 = {"Lcom/larus/ugc/feed/api/tracker/params/MobTemplateMenuClickParamsKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "recommendFrom", "", "isImageReferencePublic", "", "imageReferenceCount", "", "creatorId", "templateId", "showFrom", "templateSubType", "templateType", "templateUseTag", "buttonType", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRecommendFrom$annotations", "()V", "getRecommendFrom", "()Ljava/lang/String;", "isImageReferencePublic$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageReferenceCount$annotations", "getImageReferenceCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatorId$annotations", "getCreatorId", "getTemplateId$annotations", "getTemplateId", "getShowFrom$annotations", "getShowFrom", "getTemplateSubType$annotations", "getTemplateSubType", "getTemplateType$annotations", "getTemplateType", "getTemplateUseTag$annotations", "getTemplateUseTag", "getButtonType$annotations", "getButtonType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/ugc/feed/api/tracker/params/MobTemplateMenuClickParamsKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class MobTemplateMenuClickParamsKmp implements Parcelable {
    public static final Parcelable.Creator<MobTemplateMenuClickParamsKmp> CREATOR = null;
    public static final b Companion = null;
    public final String a;
    public final Boolean b;
    public final Integer c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MobTemplateMenuClickParamsKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.tracker.params.MobTemplateMenuClickParamsKmp", r0, 10);
            r1.j("recommend_from", true);
            r1.j("is_image_reference_public", true);
            r1.j("image_reference_count", true);
            r1.j("creator_id", true);
            r1.j("template_id", true);
            r1.j("show_from", true);
            r1.j("template_sub_type", true);
            r1.j("template_type", true);
            r1.j("template_use_tag", true);
            r1.j("button_type", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(i.a), kuc.a.d(w0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            int r3 = 8;
            int r6 = 6;
            int r7 = 7;
            String r13 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            Boolean r12 = (Boolean) r0.decodeNullableSerializableElement(r1, 1, i.a, null);
            Integer r9 = (Integer) r0.decodeNullableSerializableElement(r1, 2, w0.a, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r5 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 9, r2, null);
            String r16 = r15;
            String r18 = r5;
            String r19 = r8;
            String r110 = r14;
            String r20 = r11;
            int r21 = 1023;
            String r111 = r4;
            Integer r112 = r9;
            Boolean r22 = r12;
            String r113 = r10;
        L27:
            r0.endStructure(r1);
            return new MobTemplateMenuClickParamsKmp(r21, r20, r22, r112, r111, r113, r18, r19, r110, r16, r17);
        L5:
            String r24 = null;
            String r25 = null;
            String r114 = null;
            String r115 = null;
            String r116 = null;
            String r117 = null;
            String r118 = null;
            Integer r119 = null;
            Boolean r120 = null;
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
            r24 = (String) r0.decodeNullableSerializableElement(r1, 9, v2.a, r24);
            r26 = r26 | 512;
        L20:
            Integer r29 = r119;
        L22:
            Boolean r30 = r120;
        L24:
            r119 = r29;
            r120 = r30;
            r3 = 8;
            r6 = 6;
            r7 = 7;
            goto L6
        L12:
            r25 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r25);
            r26 = r26 | 256;
            goto L20
        L13:
            r114 = (String) r0.decodeNullableSerializableElement(r1, r7, v2.a, r114);
            r26 = r26 | 128;
            goto L20
        L14:
            r116 = (String) r0.decodeNullableSerializableElement(r1, r6, v2.a, r116);
            r26 = r26 | 64;
            goto L20
        L16:
            r115 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r115);
            r26 = r26 | 32;
            goto L20
        L17:
            r118 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r118);
            r26 = r26 | 16;
            goto L20
        L18:
            r117 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r117);
            r26 = r26 | 8;
            goto L20
        L19:
            r119 = (Integer) r0.decodeNullableSerializableElement(r1, 2, w0.a, r119);
            r26 = r26 | 4;
            goto L20
        L21:
            r29 = r119;
            r120 = (Boolean) r0.decodeNullableSerializableElement(r1, 1, i.a, r120);
            r26 = r26 | 2;
            goto L22
        L23:
            r29 = r119;
            r30 = r120;
            r26 = r26 | 1;
            r13 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r13);
            goto L24
        L26:
            r21 = r26;
            r17 = r24;
            r16 = r25;
            r20 = r13;
            r22 = r120;
            r18 = r115;
            r111 = r117;
            r19 = r116;
            r113 = r118;
            r110 = r114;
            r112 = r119;
            goto L27
        }

        public final void serialize(muc.f r7, Object r8) {
            MobTemplateMenuClickParamsKmp r9 = (MobTemplateMenuClickParamsKmp) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = MobTemplateMenuClickParamsKmp.Companion;
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
            r10.encodeNullableSerializableElement(r0, 1, i.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, w0.a, r9.c);
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
            r10.encodeNullableSerializableElement(r0, 6, v2.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r10.encodeNullableSerializableElement(r0, 7, v2.a, r9.h);
        L75:
            if (r10.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r10.encodeNullableSerializableElement(r0, 8, v2.a, r9.i);
        L84:
            if (r10.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            r2 = true;
        L89:
            if (r2 == false) goto L91;
            r10.encodeNullableSerializableElement(r0, 9, v2.a, r9.j);
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
            if (Intrinsics.areEqual(r9.b, Boolean.FALSE) == false) goto L16;
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

        public final d<MobTemplateMenuClickParamsKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<MobTemplateMenuClickParamsKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final MobTemplateMenuClickParamsKmp createFromParcel(Parcel r13) {
            Intrinsics.checkNotNullParameter(r13, "parcel");
            String r2 = r13.readString();
            if (r13.readInt() != 0) goto L6;
            Boolean r4 = null;
        L11:
            if (r13.readInt() != 0) goto L13;
            Integer r5 = null;
        L15:
            return new MobTemplateMenuClickParamsKmp(r2, r4, r5, r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString());
        L13:
            r5 = Integer.valueOf(r13.readInt());
            goto L15
        L6:
            if (r13.readInt() == 0) goto L8;
            boolean r1 = true;
        L9:
            r4 = Boolean.valueOf(r1);
            goto L11
        L8:
            r1 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final MobTemplateMenuClickParamsKmp[] newArray(int r1) {
            return new MobTemplateMenuClickParamsKmp[r1];
        }
    }

    public MobTemplateMenuClickParamsKmp() {
        this(null, Boolean.FALSE, null, null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MobTemplateMenuClickParamsKmp) == true) goto L8;
        return false;
    L8:
        MobTemplateMenuClickParamsKmp r6 = (MobTemplateMenuClickParamsKmp) r5;
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
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
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
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
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
        return "MobTemplateMenuClickParamsKmp(recommendFrom=" + this.a + ", isImageReferencePublic=" + this.b + ", imageReferenceCount=" + this.c + ", creatorId=" + this.d + ", templateId=" + this.e + ", showFrom=" + this.f + ", templateSubType=" + this.g + ", templateType=" + this.h + ", templateUseTag=" + this.i + ", buttonType=" + this.j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        Boolean r5 = this.b;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.c;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.d);
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
        r3.writeString(this.i);
        r3.writeString(this.j);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.booleanValue() ? 1 : 0);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public MobTemplateMenuClickParamsKmp(String r1, Boolean r2, Integer r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10) {
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

    public MobTemplateMenuClickParamsKmp(int r3, String r4, Boolean r5, Integer r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = Boolean.FALSE;
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
