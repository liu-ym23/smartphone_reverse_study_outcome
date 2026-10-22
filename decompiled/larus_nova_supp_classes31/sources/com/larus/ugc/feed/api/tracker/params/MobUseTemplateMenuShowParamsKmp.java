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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00060\u0001j\u0002`\u0002:\u0002IJBs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010Bu\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jz\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u00106J\u0006\u00107\u001a\u00020\bJ\u0013\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\bHÖ\u0001J\t\u0010<\u001a\u00020\u0004HÖ\u0001J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\bJ%\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0005\u0010\u001aR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0018¨\u0006K"}, d2 = {"Lcom/larus/ugc/feed/api/tracker/params/MobUseTemplateMenuShowParamsKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "recommendFrom", "", "isImageReferencePublic", "", "imageReferenceCount", "", "creatorId", "templateId", "showFrom", "templateSubType", "templateType", "templateUseTag", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRecommendFrom$annotations", "()V", "getRecommendFrom", "()Ljava/lang/String;", "isImageReferencePublic$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageReferenceCount$annotations", "getImageReferenceCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreatorId$annotations", "getCreatorId", "getTemplateId$annotations", "getTemplateId", "getShowFrom$annotations", "getShowFrom", "getTemplateSubType$annotations", "getTemplateSubType", "getTemplateType$annotations", "getTemplateType", "getTemplateUseTag$annotations", "getTemplateUseTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/ugc/feed/api/tracker/params/MobUseTemplateMenuShowParamsKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class MobUseTemplateMenuShowParamsKmp implements Parcelable {
    public static final Parcelable.Creator<MobUseTemplateMenuShowParamsKmp> CREATOR = null;
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

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MobUseTemplateMenuShowParamsKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.tracker.params.MobUseTemplateMenuShowParamsKmp", r0, 9);
            r1.j("recommend_from", true);
            r1.j("is_image_reference_public", true);
            r1.j("image_reference_count", true);
            r1.j("creator_id", true);
            r1.j("template_id", true);
            r1.j("show_from", true);
            r1.j("template_sub_type", true);
            r1.j("template_type", true);
            r1.j("template_use_tag", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(i.a), kuc.a.d(w0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            int r3 = 8;
            int r5 = 5;
            Boolean r12 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            Boolean r10 = (Boolean) r0.decodeNullableSerializableElement(r1, 1, i.a, null);
            Integer r7 = (Integer) r0.decodeNullableSerializableElement(r1, 2, w0.a, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r11 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            String r19 = (String) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            String r14 = r4;
            String r16 = r6;
            String r18 = r13;
            Integer r15 = r7;
            String r17 = r8;
            r12 = r10;
            String r110 = r11;
            int r111 = 511;
            String r112 = r9;
        L25:
            r0.endStructure(r1);
            return new MobUseTemplateMenuShowParamsKmp(r111, r112, r12, r15, r14, r17, r16, r110, r18, r19);
        L5:
            String r20 = null;
            String r21 = null;
            String r23 = null;
            Integer r113 = null;
            String r114 = null;
            String r115 = null;
            String r116 = null;
            String r117 = null;
            int r24 = 0;
            boolean r25 = true;
        L6:
            if (r25 == false) goto L24;
            int r26 = r0.decodeElementIndex(r1);
            switch(r26) {
                case -1: goto L23;
                case 0: goto L21;
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r26);
        L23:
            r3 = 8;
            r5 = 5;
            r25 = false;
            goto L6
        L11:
            r23 = (String) r0.decodeNullableSerializableElement(r1, r3, v2.a, r23);
            r24 = r24 | 256;
        L22:
            r3 = 8;
            r5 = 5;
            goto L6
        L12:
            r116 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r116);
            r24 = r24 | 128;
            goto L22
        L13:
            r115 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r115);
            r24 = r24 | 64;
            goto L22
        L14:
            r114 = (String) r0.decodeNullableSerializableElement(r1, r5, v2.a, r114);
            r24 = r24 | 32;
            goto L22
        L15:
            r20 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r20);
            r24 = r24 | 16;
            goto L22
        L16:
            r21 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r21);
            r24 = r24 | 8;
            goto L22
        L17:
            r113 = (Integer) r0.decodeNullableSerializableElement(r1, 2, w0.a, r113);
            r24 = r24 | 4;
            goto L22
        L19:
            r12 = (Boolean) r0.decodeNullableSerializableElement(r1, 1, i.a, r12);
            r24 = r24 | 2;
            goto L22
        L21:
            r24 = r24 | 1;
            r117 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r117);
            goto L22
        L24:
            r112 = r117;
            r19 = r23;
            r16 = r114;
            r110 = r115;
            r18 = r116;
            r17 = r20;
            r14 = r21;
            r15 = r113;
            r111 = r24;
            goto L25
        }

        public final void serialize(muc.f r7, Object r8) {
            MobUseTemplateMenuShowParamsKmp r9 = (MobUseTemplateMenuShowParamsKmp) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = MobUseTemplateMenuShowParamsKmp.Companion;
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
            r2 = true;
        L80:
            if (r2 == false) goto L82;
            r10.encodeNullableSerializableElement(r0, 8, v2.a, r9.i);
        L82:
            r10.endStructure(r0);
            return;
        L78:
            if (r9.i == null) goto L80;
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

        public final d<MobUseTemplateMenuShowParamsKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<MobUseTemplateMenuShowParamsKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final MobUseTemplateMenuShowParamsKmp createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            String r2 = r12.readString();
            if (r12.readInt() != 0) goto L6;
            Boolean r4 = null;
        L11:
            if (r12.readInt() != 0) goto L13;
            Integer r5 = null;
        L15:
            return new MobUseTemplateMenuShowParamsKmp(r2, r4, r5, r12.readString(), r12.readString(), r12.readString(), r12.readString(), r12.readString(), r12.readString());
        L13:
            r5 = Integer.valueOf(r12.readInt());
            goto L15
        L6:
            if (r12.readInt() == 0) goto L8;
            boolean r1 = true;
        L9:
            r4 = Boolean.valueOf(r1);
            goto L11
        L8:
            r1 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final MobUseTemplateMenuShowParamsKmp[] newArray(int r1) {
            return new MobUseTemplateMenuShowParamsKmp[r1];
        }
    }

    public MobUseTemplateMenuShowParamsKmp() {
        this(null, Boolean.FALSE, null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MobUseTemplateMenuShowParamsKmp) == true) goto L8;
        return false;
    L8:
        MobUseTemplateMenuShowParamsKmp r6 = (MobUseTemplateMenuShowParamsKmp) r5;
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
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
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
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
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
        return "MobUseTemplateMenuShowParamsKmp(recommendFrom=" + this.a + ", isImageReferencePublic=" + this.b + ", imageReferenceCount=" + this.c + ", creatorId=" + this.d + ", templateId=" + this.e + ", showFrom=" + this.f + ", templateSubType=" + this.g + ", templateType=" + this.h + ", templateUseTag=" + this.i + ')';
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

    public MobUseTemplateMenuShowParamsKmp(String r1, Boolean r2, Integer r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public MobUseTemplateMenuShowParamsKmp(int r3, String r4, Boolean r5, Integer r6, String r7, String r8, String r9, String r10, String r11, String r12) {
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
        return;
    L39:
        this.i = r12;
        return;
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
