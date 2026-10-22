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
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 `2\u00060\u0001j\u0002`\u0002:\u0002_`B¯\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015B§\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010@\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010:J¶\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010KJ\u0006\u0010L\u001a\u00020\bJ\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\bHÖ\u0001J\t\u0010R\u001a\u00020\u0004HÖ\u0001J\u0016\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\bJ%\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0001¢\u0006\u0002\b^R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010$R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010\u001dR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010\u001dR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001dR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010\u001dR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001b\u001a\u0004\b3\u0010\u001dR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001dR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001b\u001a\u0004\b7\u0010\u001dR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010;\u0012\u0004\b8\u0010\u001b\u001a\u0004\b9\u0010:¨\u0006a"}, d2 = {"Lcom/larus/ugc/feed/api/tracker/params/MobFeedStaytimeParamsKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "botId", "", "currentPage", "enterMethod", "pageIndex", "", "previousPage", "recommendFrom", "clickFrom", "templateId", "templateRecExtra", "templateRecReqId", "templateSource", "templateSubType", "templateType", "duration", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBotId$annotations", "()V", "getBotId", "()Ljava/lang/String;", "getCurrentPage$annotations", "getCurrentPage", "getEnterMethod$annotations", "getEnterMethod", "getPageIndex$annotations", "getPageIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreviousPage$annotations", "getPreviousPage", "getRecommendFrom$annotations", "getRecommendFrom", "getClickFrom$annotations", "getClickFrom", "getTemplateId$annotations", "getTemplateId", "getTemplateRecExtra$annotations", "getTemplateRecExtra", "getTemplateRecReqId$annotations", "getTemplateRecReqId", "getTemplateSource$annotations", "getTemplateSource", "getTemplateSubType$annotations", "getTemplateSubType", "getTemplateType$annotations", "getTemplateType", "getDuration$annotations", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/ugc/feed/api/tracker/params/MobFeedStaytimeParamsKmp;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class MobFeedStaytimeParamsKmp implements Parcelable {
    public static final Parcelable.Creator<MobFeedStaytimeParamsKmp> CREATOR = null;
    public static final b Companion = null;
    public final String a;
    public final String b;
    public final String c;
    public final Integer d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final Long n;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MobFeedStaytimeParamsKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.tracker.params.MobFeedStaytimeParamsKmp", r0, 14);
            r1.j("bot_id", true);
            r1.j("current_page", true);
            r1.j("enter_method", true);
            r1.j("page_index", true);
            r1.j("previous_page", true);
            r1.j("recommend_from", true);
            r1.j("click_from", true);
            r1.j("template_id", true);
            r1.j("template_rec_extra", true);
            r1.j("template_rec_req_id", true);
            r1.j("template_source", true);
            r1.j("template_sub_type", true);
            r1.j("template_type", true);
            r1.j("duration", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(w0.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(g1.a)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r32) {
            Intrinsics.checkNotNullParameter(r32, "decoder");
            g2 r1 = b;
            muc.c r0 = r32.beginStructure(r1);
            int r10 = 9;
            int r11 = 10;
            String r4 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r12 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            Integer r5 = (Integer) r0.decodeNullableSerializableElement(r1, 3, w0.a, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 8, r2, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 9, r2, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 10, r2, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 11, r2, null);
            String r29 = (String) r0.decodeNullableSerializableElement(r1, 12, r2, null);
            Long r30 = (Long) r0.decodeNullableSerializableElement(r1, 13, g1.a, null);
            Integer r20 = r5;
            String r21 = r6;
            String r22 = r7;
            String r23 = r8;
            String r24 = r9;
            String r26 = r14;
            String r27 = r16;
            String r19 = r12;
            String r25 = r13;
            String r28 = r17;
            String r18 = r3;
            String r110 = r15;
            int r111 = 16383;
        L36:
            r0.endStructure(r1);
            return new MobFeedStaytimeParamsKmp(r111, r110, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
        L5:
            int r112 = 13;
            String r31 = null;
            String r33 = null;
            Long r34 = null;
            String r35 = null;
            String r36 = null;
            String r37 = null;
            String r113 = null;
            String r114 = null;
            String r115 = null;
            Integer r210 = null;
            String r211 = null;
            String r212 = null;
            String r213 = null;
            int r38 = 0;
            boolean r39 = true;
        L6:
            if (r39 == false) goto L35;
            int r116 = r0.decodeElementIndex(r1);
            switch(r116) {
                case -1: goto L33;
                case 0: goto L32;
                case 1: goto L30;
                case 2: goto L28;
                case 3: goto L26;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L18;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L12;
                case 13: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r116);
        L32:
            String r40 = r115;
            String r117 = r211;
            String r41 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r40);
            r38 = r38 | 1;
        L34:
            r213 = r213;
            r210 = r210;
            r212 = r212;
            r211 = r117;
            r31 = r31;
            r10 = 9;
            r11 = 10;
            r112 = 13;
            r115 = r41;
            r33 = r33;
            goto L6
        L33:
            r41 = r115;
            r117 = r211;
            r39 = false;
            goto L34
        L11:
            r34 = (Long) r0.decodeNullableSerializableElement(r1, r112, g1.a, r34);
            r38 = r38 | 8192;
        L13:
            String r118 = r213;
        L25:
            Integer r119 = r210;
        L27:
            String r214 = r31;
        L29:
            String r120 = r33;
            r31 = r214;
            String r121 = r212;
        L31:
            r213 = r118;
            r210 = r119;
            r212 = r121;
            r33 = r120;
            r10 = 9;
            r11 = 10;
            r112 = 13;
            goto L6
        L12:
            r4 = (String) r0.decodeNullableSerializableElement(r1, 12, v2.a, r4);
            r38 = r38 | 4096;
            goto L13
        L14:
            r37 = (String) r0.decodeNullableSerializableElement(r1, 11, v2.a, r37);
            r38 = r38 | 2048;
        L17:
            r118 = r213;
            goto L25
        L15:
            r35 = (String) r0.decodeNullableSerializableElement(r1, r11, v2.a, r35);
            r38 = r38 | 1024;
            goto L17
        L16:
            r36 = (String) r0.decodeNullableSerializableElement(r1, r10, v2.a, r36);
            r38 = r38 | 512;
            goto L17
        L18:
            r118 = (String) r0.decodeNullableSerializableElement(r1, 8, v2.a, r213);
            r38 = r38 | 256;
            goto L25
        L20:
            r118 = r213;
            r114 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r114);
            r38 = r38 | 128;
            goto L25
        L21:
            r118 = r213;
            r31 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r31);
            r38 = r38 | 64;
            goto L25
        L23:
            r118 = r213;
            r113 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r113);
            r38 = r38 | 32;
            goto L25
        L24:
            r118 = r213;
            r33 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r33);
            r38 = r38 | 16;
            goto L25
        L26:
            r118 = r213;
            r119 = (Integer) r0.decodeNullableSerializableElement(r1, 3, w0.a, r210);
            r38 = r38 | 8;
            goto L27
        L28:
            r119 = r210;
            r118 = r213;
            r214 = r31;
            r212 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r212);
            r38 = r38 | 4;
            goto L29
        L30:
            r119 = r210;
            r121 = r212;
            r118 = r213;
            r120 = r33;
            r38 = r38 | 2;
            r211 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r211);
            r31 = r31;
            goto L31
        L35:
            String r122 = r33;
            String r42 = r115;
            Integer r123 = r210;
            r18 = r211;
            String r124 = r212;
            String r125 = r213;
            r110 = r42;
            r29 = r4;
            r30 = r34;
            r27 = r35;
            r26 = r36;
            r28 = r37;
            r111 = r38;
            r25 = r125;
            r22 = r113;
            r24 = r114;
            r21 = r122;
            r23 = r31;
            r20 = r123;
            r19 = r124;
            goto L36
        }

        public final void serialize(muc.f r7, Object r8) {
            MobFeedStaytimeParamsKmp r9 = (MobFeedStaytimeParamsKmp) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = MobFeedStaytimeParamsKmp.Companion;
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
            r10.encodeNullableSerializableElement(r0, 3, w0.a, r9.d);
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
            boolean r16 = true;
        L90:
            if (r16 == false) goto L93;
            r10.encodeNullableSerializableElement(r0, 9, v2.a, r9.j);
        L93:
            if (r10.shouldEncodeElementDefault(r0, 10) == false) goto L96;
        L97:
            boolean r17 = true;
        L99:
            if (r17 == false) goto L102;
            r10.encodeNullableSerializableElement(r0, 10, v2.a, r9.k);
        L102:
            if (r10.shouldEncodeElementDefault(r0, 11) == false) goto L105;
        L106:
            boolean r18 = true;
        L108:
            if (r18 == false) goto L111;
            r10.encodeNullableSerializableElement(r0, 11, v2.a, r9.l);
        L111:
            if (r10.shouldEncodeElementDefault(r0, 12) == false) goto L114;
        L115:
            boolean r19 = true;
        L117:
            if (r19 == false) goto L120;
            r10.encodeNullableSerializableElement(r0, 12, v2.a, r9.m);
        L120:
            if (r10.shouldEncodeElementDefault(r0, 13) == false) goto L123;
        L124:
            r2 = true;
        L125:
            if (r2 == false) goto L127;
            r10.encodeNullableSerializableElement(r0, 13, g1.a, r9.n);
        L127:
            r10.endStructure(r0);
            return;
        L123:
            if (r9.n == null) goto L125;
        L114:
            if (r9.m != null) goto L115;
            r19 = false;
            goto L117
        L105:
            if (r9.l != null) goto L106;
            r18 = false;
            goto L108
        L96:
            if (r9.k != null) goto L97;
            r17 = false;
            goto L99
        L87:
            if (r9.j != null) goto L88;
            r16 = false;
            goto L90
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

        public final d<MobFeedStaytimeParamsKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<MobFeedStaytimeParamsKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final MobFeedStaytimeParamsKmp createFromParcel(Parcel r19) {
            Intrinsics.checkNotNullParameter(r19, "parcel");
            String r2 = r19.readString();
            String r3 = r19.readString();
            String r4 = r19.readString();
            if (r19.readInt() != 0) goto L5;
            Integer r5 = null;
        L6:
            String r7 = r19.readString();
            String r8 = r19.readString();
            String r9 = r19.readString();
            String r10 = r19.readString();
            String r11 = r19.readString();
            String r12 = r19.readString();
            String r13 = r19.readString();
            String r14 = r19.readString();
            String r15 = r19.readString();
            if (r19.readInt() != 0) goto L9;
            Long r16 = null;
        L11:
            return new MobFeedStaytimeParamsKmp(r2, r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        L9:
            r16 = Long.valueOf(r19.readLong());
            goto L11
        L5:
            r5 = Integer.valueOf(r19.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final MobFeedStaytimeParamsKmp[] newArray(int r1) {
            return new MobFeedStaytimeParamsKmp[r1];
        }
    }

    public MobFeedStaytimeParamsKmp() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MobFeedStaytimeParamsKmp) == true) goto L8;
        return false;
    L8:
        MobFeedStaytimeParamsKmp r6 = (MobFeedStaytimeParamsKmp) r5;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
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
        Integer r10 = this.d;
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
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Long r40 = this.n;
        if (r40 == null) goto L59;
        r1 = r40.hashCode();
    L59:
        return r39 + r1;
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
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

    public final String toString() {
        return "MobFeedStaytimeParamsKmp(botId=" + this.a + ", currentPage=" + this.b + ", enterMethod=" + this.c + ", pageIndex=" + this.d + ", previousPage=" + this.e + ", recommendFrom=" + this.f + ", clickFrom=" + this.g + ", templateId=" + this.h + ", templateRecExtra=" + this.i + ", templateRecReqId=" + this.j + ", templateSource=" + this.k + ", templateSubType=" + this.l + ", templateType=" + this.m + ", duration=" + this.n + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeString(this.c);
        Integer r5 = this.d;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
        r3.writeString(this.i);
        r3.writeString(this.j);
        r3.writeString(this.k);
        r3.writeString(this.l);
        r3.writeString(this.m);
        Long r6 = this.n;
        if (r6 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeLong(r6.longValue());
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public MobFeedStaytimeParamsKmp(String r1, String r2, String r3, Integer r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, Long r14) {
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
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }

    public MobFeedStaytimeParamsKmp(int r6, String r7, String r8, String r9, Integer r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, Long r20) {
        if ((r6 & 0) == 0) goto L5;
        b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r6 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r6 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r6 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r6 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r6 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r6 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r6 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r6 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r6 & 512) != 0) goto L43;
        this.j = null;
    L45:
        if ((r6 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r6 & 2048) != 0) goto L51;
        this.l = null;
    L53:
        if ((r6 & 4096) != 0) goto L55;
        this.m = null;
    L57:
        if ((r6 & 8192) != 0) goto L59;
        this.n = null;
        return;
    L59:
        this.n = r20;
        return;
    L55:
        this.m = r19;
        goto L57
    L51:
        this.l = r18;
        goto L53
    L47:
        this.k = r17;
        goto L49
    L43:
        this.j = r16;
        goto L45
    L39:
        this.i = r15;
        goto L41
    L35:
        this.h = r14;
        goto L37
    L31:
        this.g = r13;
        goto L33
    L27:
        this.f = r12;
        goto L29
    L23:
        this.e = r11;
        goto L25
    L19:
        this.d = r10;
        goto L21
    L15:
        this.c = r9;
        goto L17
    L11:
        this.b = r8;
        goto L13
    L7:
        this.a = r7;
        goto L9
    }
}
