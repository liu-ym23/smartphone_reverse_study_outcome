package com.larus.platform.api.creation;

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
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 S2\u00060\u0001j\u0002`\u0002:\u0002RSB\u008b\u0001\u0012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u0010\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0092\u0001\u0010=\u001a\u00020\u00002\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010>J\u0006\u0010?\u001a\u00020\u0004J\u0013\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0004HÖ\u0001J\t\u0010E\u001a\u00020\u0006HÖ\u0001J\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0004J%\u0010K\u001a\u00020G2\u0006\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PH\u0001¢\u0006\u0002\bQR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001eR \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010'R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0018\u001a\u0004\b)\u0010'R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001eR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b.\u0010\u0018\u001a\u0004\b/\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b0\u0010\u0018\u001a\u0004\b1\u0010\u001a¨\u0006T"}, d2 = {"Lcom/larus/platform/api/creation/TplDetail;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "createType", "", "tagType", "", "buttonType", "actionType", "buttonName", "buttonIcon", "Lcom/larus/platform/api/creation/Icon;", "buttonMiniIcon", "buttonDesc", "sendQuery", "promptStartPos", "promptEndPos", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/platform/api/creation/Icon;Lcom/larus/platform/api/creation/Icon;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/platform/api/creation/Icon;Lcom/larus/platform/api/creation/Icon;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreateType$annotations", "()V", "getCreateType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTagType$annotations", "getTagType", "()Ljava/lang/String;", "getButtonType$annotations", "getButtonType", "getActionType$annotations", "getActionType", "getButtonName$annotations", "getButtonName", "getButtonIcon$annotations", "getButtonIcon", "()Lcom/larus/platform/api/creation/Icon;", "getButtonMiniIcon$annotations", "getButtonMiniIcon", "getButtonDesc$annotations", "getButtonDesc", "getSendQuery$annotations", "getSendQuery", "getPromptStartPos$annotations", "getPromptStartPos", "getPromptEndPos$annotations", "getPromptEndPos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/platform/api/creation/Icon;Lcom/larus/platform/api/creation/Icon;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/platform/api/creation/TplDetail;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class TplDetail implements Parcelable {
    public static final Parcelable.Creator<TplDetail> CREATOR = null;
    public static final b Companion = null;
    public final Integer a;
    public final String b;
    public final String c;
    public final Integer d;
    public final String e;
    public final Icon f;
    public final Icon g;
    public final String h;
    public final String i;
    public final Integer j;
    public final Integer k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TplDetail> {
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
            g2 r1 = new g2("com.larus.platform.api.creation.TplDetail", r0, 11);
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
            Icon.a r3 = Icon.a.a;
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
            Icon.a r3 = Icon.a.a;
            Icon r5 = (Icon) r0.decodeNullableSerializableElement(r1, 5, r3, null);
            Icon r6 = (Icon) r0.decodeNullableSerializableElement(r1, 6, r3, null);
            String r16 = (String) r0.decodeNullableSerializableElement(r1, 7, r15, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 8, r15, null);
            Integer r18 = (Integer) r0.decodeNullableSerializableElement(r1, 9, r2, null);
            Integer r19 = (Integer) r0.decodeNullableSerializableElement(r1, 10, r2, null);
            Icon r110 = r6;
            Icon r111 = r5;
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
            return new TplDetail(r21, r20, r118, r115, r116, r117, r111, r110, r112, r113, r114, r19);
        L5:
            int r119 = 10;
            String r22 = null;
            Integer r23 = null;
            Icon r24 = null;
            String r26 = null;
            Integer r120 = null;
            String r121 = null;
            String r122 = null;
            Integer r123 = null;
            String r27 = null;
            Icon r28 = null;
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
            Icon r31 = r28;
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
            r24 = (Icon) r0.decodeNullableSerializableElement(r1, 6, Icon.a.a, r24);
            r29 = r29 | 64;
            goto L16
        L17:
            r31 = (Icon) r0.decodeNullableSerializableElement(r1, 5, Icon.a.a, r28);
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

        public final void serialize(muc.f r7, Object r8) {
            TplDetail r9 = (TplDetail) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = TplDetail.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, w0.a, r9.a);
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
            r10.encodeNullableSerializableElement(r0, 5, Icon.a.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, Icon.a.a, r9.g);
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
            r10.encodeNullableSerializableElement(r0, 9, w0.a, r9.j);
        L93:
            if (r10.shouldEncodeElementDefault(r0, 10) == false) goto L96;
        L97:
            r2 = true;
        L98:
            if (r2 == false) goto L100;
            r10.encodeNullableSerializableElement(r0, 10, w0.a, r9.k);
        L100:
            r10.endStructure(r0);
            return;
        L96:
            if (r9.k == null) goto L98;
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

        public final d<TplDetail> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<TplDetail> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TplDetail createFromParcel(Parcel r14) {
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
            Icon r1 = null;
        L14:
            Icon r8 = r1;
            if (r14.readInt() != 0) goto L17;
            Icon r2 = null;
        L18:
            Icon r9 = r2;
            String r10 = r14.readString();
            String r11 = r14.readString();
            if (r14.readInt() != 0) goto L21;
            Integer r12 = null;
        L23:
            if (r14.readInt() != 0) goto L25;
            Integer r15 = null;
        L27:
            return new TplDetail(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r15);
        L25:
            r15 = Integer.valueOf(r14.readInt());
            goto L27
        L21:
            r12 = Integer.valueOf(r14.readInt());
            goto L23
        L17:
            r2 = Icon.CREATOR.createFromParcel(r14);
            goto L18
        L13:
            r1 = Icon.CREATOR.createFromParcel(r14);
            goto L14
        L9:
            r6 = Integer.valueOf(r14.readInt());
            goto L10
        L5:
            r3 = Integer.valueOf(r14.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final TplDetail[] newArray(int r1) {
            return new TplDetail[r1];
        }
    }

    public TplDetail() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TplDetail) == true) goto L8;
        return false;
    L8:
        TplDetail r6 = (TplDetail) r5;
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
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
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
        Icon r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Icon r19 = this.g;
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
        Integer r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.k;
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

    public final String toString() {
        return "TplDetail(createType=" + this.a + ", tagType=" + this.b + ", buttonType=" + this.c + ", actionType=" + this.d + ", buttonName=" + this.e + ", buttonIcon=" + this.f + ", buttonMiniIcon=" + this.g + ", buttonDesc=" + this.h + ", sendQuery=" + this.i + ", promptStartPos=" + this.j + ", promptEndPos=" + this.k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        Integer r0 = this.a;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        r4.writeString(this.b);
        r4.writeString(this.c);
        Integer r1 = this.d;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        r4.writeString(this.e);
        Icon r2 = this.f;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        Icon r3 = this.g;
        if (r3 != null) goto L17;
        r4.writeInt(0);
    L18:
        r4.writeString(this.h);
        r4.writeString(this.i);
        Integer r6 = this.j;
        if (r6 != null) goto L21;
        r4.writeInt(0);
    L22:
        Integer r7 = this.k;
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

    public TplDetail(@TplCreateType Integer r1, @TplTagType String r2, @TplButtonType String r3, @TplActionType Integer r4, String r5, Icon r6, Icon r7, String r8, String r9, Integer r10, Integer r11) {
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
    }

    public TplDetail(int r3, Integer r4, String r5, String r6, Integer r7, String r8, Icon r9, Icon r10, String r11, String r12, Integer r13, Integer r14) {
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
    L45:
        if ((r3 & 1024) != 0) goto L47;
        this.k = null;
        return;
    L47:
        this.k = r14;
        return;
    L43:
        this.j = r13;
        goto L45
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
