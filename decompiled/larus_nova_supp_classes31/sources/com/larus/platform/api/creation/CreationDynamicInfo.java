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
import zp9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 C2\u00060\u0001j\u0002`\u0002:\u0002BCBC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0010\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u0004J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0004HÖ\u0001J\t\u00105\u001a\u00020\u0007HÖ\u0001J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0004J%\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAR(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006D"}, d2 = {"Lcom/larus/platform/api/creation/CreationDynamicInfo;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "promptStartPos", "", "promptEndPos", "actionButtonName", "", "msgId", "tplInfo", "Lcom/larus/platform/api/creation/TplInfo;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/TplInfo;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/TplInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPromptStartPos$annotations", "()V", "getPromptStartPos", "()Ljava/lang/Integer;", "setPromptStartPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPromptEndPos$annotations", "getPromptEndPos", "setPromptEndPos", "getActionButtonName$annotations", "getActionButtonName", "()Ljava/lang/String;", "setActionButtonName", "(Ljava/lang/String;)V", "getMsgId$annotations", "getMsgId", "setMsgId", "getTplInfo$annotations", "getTplInfo", "()Lcom/larus/platform/api/creation/TplInfo;", "setTplInfo", "(Lcom/larus/platform/api/creation/TplInfo;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/TplInfo;)Lcom/larus/platform/api/creation/CreationDynamicInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationDynamicInfo implements Parcelable {
    public static final Parcelable.Creator<CreationDynamicInfo> CREATOR = null;
    public static final b Companion = null;
    public final Integer a;
    public final Integer b;
    public final String c;
    public final String d;
    public final TplInfo e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationDynamicInfo> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            w0 r1 = w0.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(v2.a), kuc.a.d(h.a), kuc.a.d(TplInfo.a.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.platform.api.creation.CreationDynamicInfo", r0, 5);
            r1.j("prompt_start_pos", true);
            r1.j("prompt_end_pos", true);
            r1.j("action_button_name", true);
            r1.j("msg_id", true);
            r1.j("tpl_info", true);
            b = r1;
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            Integer r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            w0 r2 = w0.a;
            Integer r5 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            Integer r3 = (Integer) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 3, h.a, null);
            Integer r17 = r3;
            String r18 = r4;
            TplInfo r20 = (TplInfo) r0.decodeNullableSerializableElement(r1, 4, TplInfo.a.a, null);
            Integer r16 = r5;
            String r19 = r6;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new CreationDynamicInfo(r15, r16, r17, r18, r19, r20);
        L5:
            Integer r9 = null;
            String r10 = null;
            String r11 = null;
            TplInfo r12 = null;
            int r7 = 0;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L22;
            int r14 = r0.decodeElementIndex(r1);
            if (r14 != (-1)) goto L9;
            r13 = false;
            goto L6
        L9:
            if (r14 != 0) goto L10;
            r8 = (Integer) r0.decodeNullableSerializableElement(r1, 0, w0.a, r8);
            r7 = r7 | 1;
            goto L6
        L10:
            if (r14 != 1) goto L11;
            r9 = (Integer) r0.decodeNullableSerializableElement(r1, 1, w0.a, r9);
            r7 = r7 | 2;
            goto L6
        L11:
            if (r14 != 2) goto L12;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r10);
            r7 = r7 | 4;
            goto L6
        L12:
            if (r14 != 3) goto L13;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 3, h.a, r11);
            r7 = r7 | 8;
            goto L6
        L13:
            if (r14 != 4) goto L16;
            r12 = (TplInfo) r0.decodeNullableSerializableElement(r1, 4, TplInfo.a.a, r12);
            r7 = r7 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r14);
        L22:
            r15 = r7;
            r16 = r8;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            goto L23
        }

        public final void serialize(muc.f r7, Object r8) {
            CreationDynamicInfo r9 = (CreationDynamicInfo) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = CreationDynamicInfo.Companion;
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
            r10.encodeNullableSerializableElement(r0, 1, w0.a, r9.b);
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
            r10.encodeNullableSerializableElement(r0, 3, h.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            r2 = true;
        L44:
            if (r2 == false) goto L46;
            r10.encodeNullableSerializableElement(r0, 4, TplInfo.a.a, r9.e);
        L46:
            r10.endStructure(r0);
            return;
        L42:
            if (r9.e == null) goto L44;
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

        public final d<CreationDynamicInfo> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationDynamicInfo> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationDynamicInfo createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            TplInfo r2 = null;
            if (r8.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            if (r8.readInt() != 0) goto L9;
            Integer r4 = null;
        L10:
            String r5 = r8.readString();
            String r6 = r8.readString();
            if (r8.readInt() == 0) goto L15;
            r2 = TplInfo.CREATOR.createFromParcel(r8);
        L15:
            return new CreationDynamicInfo(r3, r4, r5, r6, r2);
        L9:
            r4 = Integer.valueOf(r8.readInt());
            goto L10
        L5:
            r3 = Integer.valueOf(r8.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CreationDynamicInfo[] newArray(int r1) {
            return new CreationDynamicInfo[r1];
        }
    }

    public CreationDynamicInfo() {
        this(null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationDynamicInfo) == true) goto L8;
        return false;
    L8:
        CreationDynamicInfo r6 = (CreationDynamicInfo) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        TplInfo r13 = this.e;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "CreationDynamicInfo(promptStartPos=" + this.a + ", promptEndPos=" + this.b + ", actionButtonName=" + this.c + ", msgId=" + this.d + ", tplInfo=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        Integer r0 = this.a;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        Integer r1 = this.b;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        r4.writeString(this.c);
        r4.writeString(this.d);
        TplInfo r2 = this.e;
        if (r2 != null) goto L13;
        r4.writeInt(0);
        return;
    L13:
        r4.writeInt(1);
        r2.writeToParcel(r4, r5);
        return;
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

    public CreationDynamicInfo(Integer r1, Integer r2, String r3, String r4, TplInfo r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public CreationDynamicInfo(int r3, Integer r4, Integer r5, String r6, String r7, TplInfo r8) {
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
        return;
    L23:
        this.e = r8;
        return;
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
