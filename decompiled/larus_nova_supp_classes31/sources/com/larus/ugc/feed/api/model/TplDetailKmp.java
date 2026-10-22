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
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 S2\u00060\u0001j\u0002`\u0002:\u0002RSB\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u0010\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0092\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010>J\u0006\u0010?\u001a\u00020\u0004J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0004HÖ\u0001J\t\u0010E\u001a\u00020\u0006HÖ\u0001J\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0004J%\u0010K\u001a\u00020G2\u0006\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0001¢\u0006\u0002\bQR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001eR \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010'R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010'R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001eR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b.\u0010\u0018\u001a\u0004\b/\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b0\u0010\u0018\u001a\u0004\b1\u0010\u001a¨\u0006T"}, d2 = {"Lcom/larus/ugc/feed/api/model/TplDetailKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "createType", "", "tagType", "", "buttonType", "actionType", "buttonName", "buttonIcon", "Lcom/larus/ugc/feed/api/model/IconKmp;", "buttonMiniIcon", "buttonDesc", "sendQuery", "promptStartPos", "promptEndPos", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/IconKmp;Lcom/larus/ugc/feed/api/model/IconKmp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/IconKmp;Lcom/larus/ugc/feed/api/model/IconKmp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreateType$annotations", "()V", "getCreateType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTagType$annotations", "getTagType", "()Ljava/lang/String;", "getButtonType$annotations", "getButtonType", "getActionType$annotations", "getActionType", "getButtonName$annotations", "getButtonName", "getButtonIcon$annotations", "getButtonIcon", "()Lcom/larus/ugc/feed/api/model/IconKmp;", "getButtonMiniIcon$annotations", "getButtonMiniIcon", "getButtonDesc$annotations", "getButtonDesc", "getSendQuery$annotations", "getSendQuery", "getPromptStartPos$annotations", "getPromptStartPos", "getPromptEndPos$annotations", "getPromptEndPos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/IconKmp;Lcom/larus/ugc/feed/api/model/IconKmp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/ugc/feed/api/model/TplDetailKmp;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class TplDetailKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<TplDetailKmp> CREATOR = null;
    public static final b Companion = null;
    private final Integer actionType;
    private final String buttonDesc;
    private final IconKmp buttonIcon;
    private final IconKmp buttonMiniIcon;
    private final String buttonName;
    private final String buttonType;
    private final Integer createType;
    private final Integer promptEndPos;
    private final Integer promptStartPos;
    private final String sendQuery;
    private final String tagType;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TplDetailKmp> {
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
            g2 r1 = new g2("com.larus.ugc.feed.api.model.TplDetailKmp", r0, 11);
            r1.j("create_type", true);
            r1.j("tag_type", true);
            r1.j("button_type", true);
            r1.j("action_type", true);
            r1.j("button_name", true);
            r1.j("button_icon", true);
            r1.j("button_mini_icon", true);
            r1.j("button_desc", true);
            r1.j("send_query", true);
            r1.j("prompt_start_pos", true);
            r1.j("prompt_end_pos", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            w0 r1 = w0.a;
            v2 r2 = v2.a;
            IconKmp.a r3 = IconKmp.a.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r3), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r25) {
            Intrinsics.checkNotNullParameter(r25, "decoder");
            g2 r1 = b;
            muc.c r0 = r25.beginStructure(r1);
            int r7 = 7;
            int r8 = 9;
            int r11 = 8;
            Integer r14 = null;
            if (r0.decodeSequentially() == false) goto L5;
            w0 r2 = w0.a;
            Integer r12 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            v2 r15 = v2.a;
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 1, r15, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 2, r15, null);
            Integer r4 = (Integer) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 4, r15, null);
            IconKmp.a r3 = IconKmp.a.a;
            IconKmp r5 = (IconKmp) r0.decodeNullableSerializableElement(r1, 5, r3, null);
            IconKmp r6 = (IconKmp) r0.decodeNullableSerializableElement(r1, 6, r3, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 7, r15, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 8, r15, null);
            Integer r18 = (Integer) r0.decodeNullableSerializableElement(r1, 9, r2, null);
            Integer r19 = (Integer) r0.decodeNullableSerializableElement(r1, 10, r2, null);
            IconKmp r110 = r6;
            IconKmp r111 = r5;
            String r112 = r16;
            String r113 = r17;
            Integer r114 = r18;
            String r115 = r9;
            Integer r20 = r12;
            int r21 = 2047;
            Integer r116 = r4;
            String r117 = r10;
            String r118 = r13;
        L30:
            r0.endStructure(r1);
            return new TplDetailKmp(r21, r20, r118, r115, r116, r117, r111, r110, r112, r113, r114, r19, null);
        L5:
            int r119 = 10;
            String r22 = null;
            Integer r23 = null;
            IconKmp r24 = null;
            String r26 = null;
            Integer r120 = null;
            String r121 = null;
            String r122 = null;
            Integer r123 = null;
            String r27 = null;
            IconKmp r28 = null;
            int r29 = 0;
            boolean r210 = true;
        L6:
            if (r210 == false) goto L29;
            int r30 = r0.decodeElementIndex(r1);
            switch(r30) {
                case -1: goto L28;
                case 0: goto L26;
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r30);
        L12:
            r120 = (Integer) r0.decodeNullableSerializableElement(r1, r8, w0.a, r120);
            r29 = r29 | 512;
        L16:
            IconKmp r31 = r28;
        L18:
            r28 = r31;
        L23:
            String r32 = r27;
        L27:
            r28 = r28;
            r27 = r32;
            r7 = 7;
            r8 = 9;
            r11 = 8;
            r119 = 10;
            goto L6
        L13:
            r122 = (String) r0.decodeNullableSerializableElement(r1, r11, v2.a, r122);
            r29 = r29 | 256;
            goto L16
        L14:
            r26 = (String) r0.decodeNullableSerializableElement(r1, r7, v2.a, r26);
            r29 = r29 | 128;
            goto L16
        L15:
            r24 = (IconKmp) r0.decodeNullableSerializableElement(r1, 6, IconKmp.a.a, r24);
            r29 = r29 | 64;
            goto L16
        L17:
            r31 = (IconKmp) r0.decodeNullableSerializableElement(r1, 5, IconKmp.a.a, r28);
            r29 = r29 | 32;
            goto L18
        L19:
            r121 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r121);
            r29 = r29 | 16;
            goto L23
        L20:
            r14 = (Integer) r0.decodeNullableSerializableElement(r1, 3, w0.a, r14);
            r29 = r29 | 8;
            goto L23
        L22:
            r28 = r28;
            r27 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r27);
            r29 = r29 | 4;
            goto L23
        L24:
            r32 = r27;
            r28 = r28;
            r22 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r22);
            r29 = r29 | 2;
            goto L27
        L26:
            r32 = r27;
            r28 = r28;
            r29 = r29 | 1;
            r123 = (Integer) r0.decodeNullableSerializableElement(r1, 0, w0.a, r123);
            goto L27
        L28:
            r7 = 7;
            r8 = 9;
            r11 = 8;
            r119 = 10;
            r210 = false;
            goto L6
        L11:
            r23 = (Integer) r0.decodeNullableSerializableElement(r1, r119, w0.a, r23);
            r29 = r29 | 1024;
            goto L6
        L29:
            Integer r124 = r123;
            r19 = r23;
            r110 = r24;
            r112 = r26;
            r114 = r120;
            r20 = r124;
            r113 = r122;
            r118 = r22;
            r115 = r27;
            r117 = r121;
            r116 = r14;
            r21 = r29;
            r111 = r28;
            goto L30
        }

        public final void serialize(muc.f r2, Object r3) {
            TplDetailKmp r4 = (TplDetailKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            TplDetailKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TplDetailKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<TplDetailKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TplDetailKmp createFromParcel(Parcel r14) {
            Intrinsics.checkNotNullParameter(r14, "parcel");
            if (r14.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            String r4 = r14.readString();
            String r5 = r14.readString();
            if (r14.readInt() != 0) goto L9;
            Integer r6 = null;
        L10:
            String r7 = r14.readString();
            if (r14.readInt() != 0) goto L13;
            IconKmp r1 = null;
        L14:
            IconKmp r8 = r1;
            if (r14.readInt() != 0) goto L17;
            IconKmp r2 = null;
        L18:
            IconKmp r9 = r2;
            String r10 = r14.readString();
            String r11 = r14.readString();
            if (r14.readInt() != 0) goto L21;
            Integer r12 = null;
        L23:
            if (r14.readInt() != 0) goto L25;
            Integer r15 = null;
        L27:
            return new TplDetailKmp(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r15);
        L25:
            r15 = Integer.valueOf(r14.readInt());
            goto L27
        L21:
            r12 = Integer.valueOf(r14.readInt());
            goto L23
        L17:
            r2 = IconKmp.CREATOR.createFromParcel(r14);
            goto L18
        L13:
            r1 = IconKmp.CREATOR.createFromParcel(r14);
            goto L14
        L9:
            r6 = Integer.valueOf(r14.readInt());
            goto L10
        L5:
            r3 = Integer.valueOf(r14.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TplDetailKmp[] newArray(int r1) {
            return new TplDetailKmp[r1];
        }
    }

    public TplDetailKmp() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ TplDetailKmp copy$default(TplDetailKmp r12, Integer r13, String r14, String r15, Integer r16, String r17, IconKmp r18, IconKmp r19, String r20, String r21, Integer r22, Integer r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        Integer r2 = r12.createType;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.tagType;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.buttonType;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r5 = r12.actionType;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.buttonName;
    L23:
        if ((r24 & 32) == 0) goto L25;
        IconKmp r7 = r12.buttonIcon;
    L27:
        if ((r24 & 64) == 0) goto L29;
        IconKmp r8 = r12.buttonMiniIcon;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = r12.buttonDesc;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = r12.sendQuery;
    L39:
        if ((r24 & 512) == 0) goto L41;
        Integer r11 = r12.promptStartPos;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        Integer r1 = r12.promptEndPos;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    @SerialName("action_type")
    public static /* synthetic */ void getActionType$annotations() {
    }

    @SerialName("button_desc")
    public static /* synthetic */ void getButtonDesc$annotations() {
    }

    @SerialName("button_icon")
    public static /* synthetic */ void getButtonIcon$annotations() {
    }

    @SerialName("button_mini_icon")
    public static /* synthetic */ void getButtonMiniIcon$annotations() {
    }

    @SerialName("button_name")
    public static /* synthetic */ void getButtonName$annotations() {
    }

    @SerialName("button_type")
    public static /* synthetic */ void getButtonType$annotations() {
    }

    @SerialName("create_type")
    public static /* synthetic */ void getCreateType$annotations() {
    }

    @SerialName("prompt_end_pos")
    public static /* synthetic */ void getPromptEndPos$annotations() {
    }

    @SerialName("prompt_start_pos")
    public static /* synthetic */ void getPromptStartPos$annotations() {
    }

    @SerialName("send_query")
    public static /* synthetic */ void getSendQuery$annotations() {
    }

    @SerialName("tag_type")
    public static /* synthetic */ void getTagType$annotations() {
    }

    public final Integer component1() {
        return this.createType;
    }

    public final Integer component10() {
        return this.promptStartPos;
    }

    public final Integer component11() {
        return this.promptEndPos;
    }

    public final String component2() {
        return this.tagType;
    }

    public final String component3() {
        return this.buttonType;
    }

    public final Integer component4() {
        return this.actionType;
    }

    public final String component5() {
        return this.buttonName;
    }

    public final IconKmp component6() {
        return this.buttonIcon;
    }

    public final IconKmp component7() {
        return this.buttonMiniIcon;
    }

    public final String component8() {
        return this.buttonDesc;
    }

    public final String component9() {
        return this.sendQuery;
    }

    public final TplDetailKmp copy(Integer r14, String r15, String r16, Integer r17, String r18, IconKmp r19, IconKmp r20, String r21, String r22, Integer r23, Integer r24) {
        return new TplDetailKmp(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TplDetailKmp) == true) goto L8;
        return false;
    L8:
        TplDetailKmp r6 = (TplDetailKmp) r5;
        if (Intrinsics.areEqual(this.createType, r6.createType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tagType, r6.tagType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.buttonType, r6.buttonType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionType, r6.actionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.buttonName, r6.buttonName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonIcon, r6.buttonIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.buttonMiniIcon, r6.buttonMiniIcon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.buttonDesc, r6.buttonDesc) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sendQuery, r6.sendQuery) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.promptStartPos, r6.promptStartPos) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.promptEndPos, r6.promptEndPos) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.createType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.tagType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.buttonType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.actionType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.buttonName;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        IconKmp r16 = this.buttonIcon;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        IconKmp r19 = this.buttonMiniIcon;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.buttonDesc;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.sendQuery;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.promptStartPos;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.promptEndPos;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
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
        return "TplDetailKmp(createType=" + this.createType + ", tagType=" + this.tagType + ", buttonType=" + this.buttonType + ", actionType=" + this.actionType + ", buttonName=" + this.buttonName + ", buttonIcon=" + this.buttonIcon + ", buttonMiniIcon=" + this.buttonMiniIcon + ", buttonDesc=" + this.buttonDesc + ", sendQuery=" + this.sendQuery + ", promptStartPos=" + this.promptStartPos + ", promptEndPos=" + this.promptEndPos + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        Integer r0 = this.createType;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        r4.writeString(this.tagType);
        r4.writeString(this.buttonType);
        Integer r1 = this.actionType;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        r4.writeString(this.buttonName);
        IconKmp r2 = this.buttonIcon;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        IconKmp r3 = this.buttonMiniIcon;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        r4.writeString(this.buttonDesc);
        r4.writeString(this.sendQuery);
        Integer r6 = this.promptStartPos;
        if (r6 != null) goto L21;
        r4.writeInt(0);
    L22:
        Integer r7 = this.promptEndPos;
        if (r7 != null) goto L25;
        r4.writeInt(0);
        return;
    L25:
        r4.writeInt(1);
        r4.writeInt(r7.intValue());
        return;
    L21:
        r4.writeInt(1);
        r4.writeInt(r6.intValue());
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
        r4.writeInt(r1.intValue());
        goto L10
    L5:
        r4.writeInt(1);
        r4.writeInt(r0.intValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public final Integer getActionType() {
        return this.actionType;
    }

    public final String getButtonDesc() {
        return this.buttonDesc;
    }

    public final IconKmp getButtonIcon() {
        return this.buttonIcon;
    }

    public final IconKmp getButtonMiniIcon() {
        return this.buttonMiniIcon;
    }

    public final String getButtonName() {
        return this.buttonName;
    }

    public final String getButtonType() {
        return this.buttonType;
    }

    public final Integer getCreateType() {
        return this.createType;
    }

    public final Integer getPromptEndPos() {
        return this.promptEndPos;
    }

    public final Integer getPromptStartPos() {
        return this.promptStartPos;
    }

    public final String getSendQuery() {
        return this.sendQuery;
    }

    public final String getTagType() {
        return this.tagType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(TplDetailKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, w0.a, r5.createType);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, v2.a, r5.tagType);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.buttonType);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, w0.a, r5.actionType);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        boolean r8 = true;
    L45:
        if (r8 == false) goto L48;
        r6.encodeNullableSerializableElement(r7, 4, v2.a, r5.buttonName);
    L48:
        if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L51;
    L49:
        boolean r9 = true;
    L54:
        if (r9 == false) goto L57;
        r6.encodeNullableSerializableElement(r7, 5, IconKmp.a.a, r5.buttonIcon);
    L57:
        if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L60;
    L58:
        boolean r10 = true;
    L63:
        if (r10 == false) goto L66;
        r6.encodeNullableSerializableElement(r7, 6, IconKmp.a.a, r5.buttonMiniIcon);
    L66:
        if (r6.shouldEncodeElementDefault(r7, 7) == false) goto L69;
    L67:
        boolean r11 = true;
    L72:
        if (r11 == false) goto L75;
        r6.encodeNullableSerializableElement(r7, 7, v2.a, r5.buttonDesc);
    L75:
        if (r6.shouldEncodeElementDefault(r7, 8) == false) goto L78;
    L76:
        boolean r12 = true;
    L81:
        if (r12 == false) goto L84;
        r6.encodeNullableSerializableElement(r7, 8, v2.a, r5.sendQuery);
    L84:
        if (r6.shouldEncodeElementDefault(r7, 9) == false) goto L87;
    L85:
        boolean r13 = true;
    L90:
        if (r13 == false) goto L93;
        r6.encodeNullableSerializableElement(r7, 9, w0.a, r5.promptStartPos);
    L93:
        if (r6.shouldEncodeElementDefault(r7, 10) == false) goto L96;
    L94:
        r0 = true;
    L98:
        if (r0 == false) goto L101;
        r6.encodeNullableSerializableElement(r7, 10, w0.a, r5.promptEndPos);
        return;
    L101:
        return;
    L96:
        if (r5.promptEndPos == null) goto L98;
    L87:
        if (r5.promptStartPos != null) goto L85;
        r13 = false;
        goto L90
    L78:
        if (r5.sendQuery != null) goto L76;
        r12 = false;
        goto L81
    L69:
        if (r5.buttonDesc != null) goto L67;
        r11 = false;
        goto L72
    L60:
        if (r5.buttonMiniIcon != null) goto L58;
        r10 = false;
        goto L63
    L51:
        if (r5.buttonIcon != null) goto L49;
        r9 = false;
        goto L54
    L42:
        if (r5.buttonName != null) goto L40;
        r8 = false;
        goto L45
    L33:
        if (r5.actionType != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.buttonType != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.tagType != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.createType != null) goto L4;
        r1 = false;
        goto L9
    }

    public TplDetailKmp(Integer r1, String r2, String r3, Integer r4, String r5, IconKmp r6, IconKmp r7, String r8, String r9, Integer r10, Integer r11) {
        this.createType = r1;
        this.tagType = r2;
        this.buttonType = r3;
        this.actionType = r4;
        this.buttonName = r5;
        this.buttonIcon = r6;
        this.buttonMiniIcon = r7;
        this.buttonDesc = r8;
        this.sendQuery = r9;
        this.promptStartPos = r10;
        this.promptEndPos = r11;
    }

    public TplDetailKmp(int r2, Integer r3, String r4, String r5, Integer r6, String r7, IconKmp r8, IconKmp r9, String r10, String r11, Integer r12, Integer r13, q2 r14) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.createType = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.tagType = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.buttonType = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.actionType = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.buttonName = null;
    L25:
        if ((r2 & 32) != 0) goto L27;
        this.buttonIcon = null;
    L29:
        if ((r2 & 64) != 0) goto L31;
        this.buttonMiniIcon = null;
    L33:
        if ((r2 & 128) != 0) goto L35;
        this.buttonDesc = null;
    L37:
        if ((r2 & 256) != 0) goto L39;
        this.sendQuery = null;
    L41:
        if ((r2 & 512) != 0) goto L43;
        this.promptStartPos = null;
    L45:
        if ((r2 & 1024) != 0) goto L47;
        this.promptEndPos = null;
        return;
    L47:
        this.promptEndPos = r13;
        return;
    L43:
        this.promptStartPos = r12;
        goto L45
    L39:
        this.sendQuery = r11;
        goto L41
    L35:
        this.buttonDesc = r10;
        goto L37
    L31:
        this.buttonMiniIcon = r9;
        goto L33
    L27:
        this.buttonIcon = r8;
        goto L29
    L23:
        this.buttonName = r7;
        goto L25
    L19:
        this.actionType = r6;
        goto L21
    L15:
        this.buttonType = r5;
        goto L17
    L11:
        this.tagType = r4;
        goto L13
    L7:
        this.createType = r3;
        goto L9
    }

    public /* synthetic */ TplDetailKmp(Integer r13, String r14, String r15, Integer r16, String r17, IconKmp r18, IconKmp r19, String r20, String r21, Integer r22, Integer r23, int r24, DefaultConstructorMarker r25) {
        Integer r2 = null;
        if ((r24 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        IconKmp r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        IconKmp r8 = null;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r24 & 512) == 0) goto L41;
        Integer r11 = null;
    L43:
        if ((r24 & 1024) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
        return;
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
