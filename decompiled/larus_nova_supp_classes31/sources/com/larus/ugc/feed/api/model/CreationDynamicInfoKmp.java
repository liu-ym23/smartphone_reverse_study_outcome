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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 C2\u00060\u0001j\u0002`\u0002:\u0002BCBC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0010\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020\u0004J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0004HÖ\u0001J\t\u00105\u001a\u00020\u0007HÖ\u0001J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0004J%\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAR(\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006D"}, d2 = {"Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "promptStartPos", "", "promptEndPos", "actionButtonName", "", "msgId", "tplInfo", "Lcom/larus/ugc/feed/api/model/TplInfoKmp;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/TplInfoKmp;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/TplInfoKmp;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPromptStartPos$annotations", "()V", "getPromptStartPos", "()Ljava/lang/Integer;", "setPromptStartPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPromptEndPos$annotations", "getPromptEndPos", "setPromptEndPos", "getActionButtonName$annotations", "getActionButtonName", "()Ljava/lang/String;", "setActionButtonName", "(Ljava/lang/String;)V", "getMsgId$annotations", "getMsgId", "setMsgId", "getTplInfo$annotations", "getTplInfo", "()Lcom/larus/ugc/feed/api/model/TplInfoKmp;", "setTplInfo", "(Lcom/larus/ugc/feed/api/model/TplInfoKmp;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/ugc/feed/api/model/TplInfoKmp;)Lcom/larus/ugc/feed/api/model/CreationDynamicInfoKmp;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class CreationDynamicInfoKmp implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CreationDynamicInfoKmp> CREATOR = null;
    public static final b Companion = null;
    private String actionButtonName;
    private String msgId;
    private Integer promptEndPos;
    private Integer promptStartPos;
    private TplInfoKmp tplInfo;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationDynamicInfoKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final d<?>[] childSerializers() {
            w0 r1 = w0.a;
            v2 r2 = v2.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(TplInfoKmp.a.a)};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.model.CreationDynamicInfoKmp", r0, 5);
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

        public final Object deserialize(e r23) {
            Intrinsics.checkNotNullParameter(r23, "decoder");
            g2 r1 = b;
            muc.c r0 = r23.beginStructure(r1);
            Integer r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            w0 r2 = w0.a;
            Integer r5 = (Integer) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            Integer r3 = (Integer) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            v2 r6 = v2.a;
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 2, r6, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 3, r6, null);
            Integer r17 = r3;
            String r18 = r4;
            TplInfoKmp r20 = (TplInfoKmp) r0.decodeNullableSerializableElement(r1, 4, TplInfoKmp.a.a, null);
            Integer r16 = r5;
            String r19 = r7;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new CreationDynamicInfoKmp(r15, r16, r17, r18, r19, r20, null);
        L5:
            Integer r9 = null;
            String r10 = null;
            String r11 = null;
            TplInfoKmp r12 = null;
            int r13 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L22;
            int r110 = r0.decodeElementIndex(r1);
            if (r110 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r110 != 0) goto L10;
            r8 = (Integer) r0.decodeNullableSerializableElement(r1, 0, w0.a, r8);
            r13 = r13 | 1;
            goto L6
        L10:
            if (r110 != 1) goto L11;
            r9 = (Integer) r0.decodeNullableSerializableElement(r1, 1, w0.a, r9);
            r13 = r13 | 2;
            goto L6
        L11:
            if (r110 != 2) goto L12;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r10);
            r13 = r13 | 4;
            goto L6
        L12:
            if (r110 != 3) goto L13;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r11);
            r13 = r13 | 8;
            goto L6
        L13:
            if (r110 != 4) goto L16;
            r12 = (TplInfoKmp) r0.decodeNullableSerializableElement(r1, 4, TplInfoKmp.a.a, r12);
            r13 = r13 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r110);
        L22:
            r15 = r13;
            r16 = r8;
            r17 = r9;
            r18 = r10;
            r19 = r11;
            r20 = r12;
            goto L23
        }

        public final void serialize(muc.f r2, Object r3) {
            CreationDynamicInfoKmp r4 = (CreationDynamicInfoKmp) r3;
            Intrinsics.checkNotNullParameter(r2, "encoder");
            Intrinsics.checkNotNullParameter(r4, "value");
            g2 r0 = b;
            muc.d r5 = r2.beginStructure(r0);
            CreationDynamicInfoKmp.write$Self$feed_kmp_api_release(r4, r5, r0);
            r5.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationDynamicInfoKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<CreationDynamicInfoKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreationDynamicInfoKmp createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            TplInfoKmp r2 = null;
            if (r8.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            if (r8.readInt() != 0) goto L9;
            Integer r4 = null;
        L10:
            String r5 = r8.readString();
            String r6 = r8.readString();
            if (r8.readInt() == 0) goto L15;
            r2 = TplInfoKmp.CREATOR.createFromParcel(r8);
        L15:
            return new CreationDynamicInfoKmp(r3, r4, r5, r6, r2);
        L9:
            r4 = Integer.valueOf(r8.readInt());
            goto L10
        L5:
            r3 = Integer.valueOf(r8.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CreationDynamicInfoKmp[] newArray(int r1) {
            return new CreationDynamicInfoKmp[r1];
        }
    }

    public CreationDynamicInfoKmp() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ CreationDynamicInfoKmp copy$default(CreationDynamicInfoKmp r3, Integer r4, Integer r5, String r6, String r7, TplInfoKmp r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.promptStartPos;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.promptEndPos;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.actionButtonName;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.msgId;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.tplInfo;
    L17:
        Integer r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    @SerialName("action_button_name")
    public static /* synthetic */ void getActionButtonName$annotations() {
    }

    @SerialName("msg_id")
    public static /* synthetic */ void getMsgId$annotations() {
    }

    @SerialName("prompt_end_pos")
    public static /* synthetic */ void getPromptEndPos$annotations() {
    }

    @SerialName("prompt_start_pos")
    public static /* synthetic */ void getPromptStartPos$annotations() {
    }

    @SerialName("tpl_info")
    public static /* synthetic */ void getTplInfo$annotations() {
    }

    public final Integer component1() {
        return this.promptStartPos;
    }

    public final Integer component2() {
        return this.promptEndPos;
    }

    public final String component3() {
        return this.actionButtonName;
    }

    public final String component4() {
        return this.msgId;
    }

    public final TplInfoKmp component5() {
        return this.tplInfo;
    }

    public final CreationDynamicInfoKmp copy(Integer r8, Integer r9, String r10, String r11, TplInfoKmp r12) {
        return new CreationDynamicInfoKmp(r8, r9, r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationDynamicInfoKmp) == true) goto L8;
        return false;
    L8:
        CreationDynamicInfoKmp r6 = (CreationDynamicInfoKmp) r5;
        if (Intrinsics.areEqual(this.promptStartPos, r6.promptStartPos) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promptEndPos, r6.promptEndPos) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionButtonName, r6.actionButtonName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.msgId, r6.msgId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tplInfo, r6.tplInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.promptStartPos;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.promptEndPos;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.actionButtonName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.msgId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        TplInfoKmp r13 = this.tplInfo;
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

    public String toString() {
        return "CreationDynamicInfoKmp(promptStartPos=" + this.promptStartPos + ", promptEndPos=" + this.promptEndPos + ", actionButtonName=" + this.actionButtonName + ", msgId=" + this.msgId + ", tplInfo=" + this.tplInfo + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        Integer r0 = this.promptStartPos;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        Integer r1 = this.promptEndPos;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        r4.writeString(this.actionButtonName);
        r4.writeString(this.msgId);
        TplInfoKmp r2 = this.tplInfo;
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
        $stable = 8;
        CREATOR = new c();
    }

    public final String getActionButtonName() {
        return this.actionButtonName;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final Integer getPromptEndPos() {
        return this.promptEndPos;
    }

    public final Integer getPromptStartPos() {
        return this.promptStartPos;
    }

    public final TplInfoKmp getTplInfo() {
        return this.tplInfo;
    }

    public final void setActionButtonName(String r1) {
        this.actionButtonName = r1;
    }

    public final void setMsgId(String r1) {
        this.msgId = r1;
    }

    public final void setPromptEndPos(Integer r1) {
        this.promptEndPos = r1;
    }

    public final void setPromptStartPos(Integer r1) {
        this.promptStartPos = r1;
    }

    public final void setTplInfo(TplInfoKmp r1) {
        this.tplInfo = r1;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$feed_kmp_api_release(CreationDynamicInfoKmp r5, muc.d r6, f r7) {
        boolean r0 = false;
        if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
    L4:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r6.encodeNullableSerializableElement(r7, 0, w0.a, r5.promptStartPos);
    L12:
        if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L15;
    L13:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r6.encodeNullableSerializableElement(r7, 1, w0.a, r5.promptEndPos);
    L21:
        if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L24;
    L22:
        boolean r3 = true;
    L27:
        if (r3 == false) goto L30;
        r6.encodeNullableSerializableElement(r7, 2, v2.a, r5.actionButtonName);
    L30:
        if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L33;
    L31:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L39;
        r6.encodeNullableSerializableElement(r7, 3, v2.a, r5.msgId);
    L39:
        if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L42;
    L40:
        r0 = true;
    L44:
        if (r0 == false) goto L47;
        r6.encodeNullableSerializableElement(r7, 4, TplInfoKmp.a.a, r5.tplInfo);
        return;
    L47:
        return;
    L42:
        if (r5.tplInfo == null) goto L44;
    L33:
        if (r5.msgId != null) goto L31;
        r4 = false;
        goto L36
    L24:
        if (r5.actionButtonName != null) goto L22;
        r3 = false;
        goto L27
    L15:
        if (r5.promptEndPos != null) goto L13;
        r2 = false;
        goto L18
    L6:
        if (r5.promptStartPos != null) goto L4;
        r1 = false;
        goto L9
    }

    public CreationDynamicInfoKmp(Integer r1, Integer r2, String r3, String r4, TplInfoKmp r5) {
        this.promptStartPos = r1;
        this.promptEndPos = r2;
        this.actionButtonName = r3;
        this.msgId = r4;
        this.tplInfo = r5;
    }

    public CreationDynamicInfoKmp(int r2, Integer r3, Integer r4, String r5, String r6, TplInfoKmp r7, q2 r8) {
        if ((r2 & 0) == 0) goto L5;
        b2.b(r2, 0, a.b);
        throw null;
    L5:
        if ((r2 & 1) != 0) goto L7;
        this.promptStartPos = null;
    L9:
        if ((r2 & 2) != 0) goto L11;
        this.promptEndPos = null;
    L13:
        if ((r2 & 4) != 0) goto L15;
        this.actionButtonName = null;
    L17:
        if ((r2 & 8) != 0) goto L19;
        this.msgId = null;
    L21:
        if ((r2 & 16) != 0) goto L23;
        this.tplInfo = null;
        return;
    L23:
        this.tplInfo = r7;
        return;
    L19:
        this.msgId = r6;
        goto L21
    L15:
        this.actionButtonName = r5;
        goto L17
    L11:
        this.promptEndPos = r4;
        goto L13
    L7:
        this.promptStartPos = r3;
        goto L9
    }

    public /* synthetic */ CreationDynamicInfoKmp(Integer r5, Integer r6, String r7, String r8, TplInfoKmp r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        Integer r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        Integer r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        TplInfoKmp r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
