package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u0000 :2\u00020\u0001:\u0001:B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%J\n\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0092\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\tHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u0006;"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/ReferenceSnapshot;", "", "id", "", "name", "protocolDestination", "iconUrl", "documentIconToken", "documentIconObjType", "", "documentIconInfo", "documentIconUrl", "accessTimeSec", "", "avatarKey", "avatarEntityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getProtocolDestination", "getIconUrl", "getDocumentIconToken", "getDocumentIconObjType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDocumentIconInfo", "getDocumentIconUrl", "getAccessTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAvatarKey", "getAvatarEntityId", "toEntry", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchEntry;", "type", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/InputReferenceType;", "restoreDocumentIcon", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/InputReferenceDocumentIcon;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/ReferenceSnapshot;", "equals", "", "other", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final class e1 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("access_time_sec")
    private final Long accessTimeSec;

    @SerializedName("avatar_entity_id")
    private final String avatarEntityId;

    @SerializedName("avatar_key")
    private final String avatarKey;

    @SerializedName("document_icon_info")
    private final String documentIconInfo;

    @SerializedName("document_icon_obj_type")
    private final Integer documentIconObjType;

    @SerializedName("document_icon_token")
    private final String documentIconToken;

    @SerializedName("document_icon_url")
    private final String documentIconUrl;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("id")
    private final String id;

    @SerializedName("name")
    private final String name;

    @SerializedName("protocol_destination")
    private final String protocolDestination;

    public static final class a {
        public static e1 a(c1 r14) {
            Intrinsics.checkNotNullParameter(r14, "entry");
            com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r0 = r14.a.f;
            com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r1 = r14.a;
            String r2 = r1.a;
            String r3 = r1.b;
            String r4 = r1.d;
            String r5 = r1.e;
            if (r0 == null) goto L5;
            String r6 = r0.a;
        L6:
            if (r0 == null) goto L8;
            Integer r7 = Integer.valueOf(r0.b);
        L9:
            if (r0 == null) goto L11;
            String r8 = r0.c;
        L12:
            if (r0 == null) goto L14;
            String r9 = r0.d;
        L15:
            Long r10 = r14.c;
            com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r15 = r14.a;
            return new e1(r2, r3, r4, r5, r6, r7, r8, r9, r10, r15.i, r15.j);
        L14:
            r9 = null;
            goto L15
        L11:
            r8 = null;
            goto L12
        L8:
            r7 = null;
            goto L9
        L5:
            r6 = null;
            goto L6
        }
    }

    static {
    }

    public e1() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r6 = (e1) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.protocolDestination, r6.protocolDestination) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.documentIconToken, r6.documentIconToken) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.documentIconObjType, r6.documentIconObjType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.documentIconInfo, r6.documentIconInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.documentIconUrl, r6.documentIconUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.accessTimeSec, r6.accessTimeSec) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.avatarEntityId, r6.avatarEntityId) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.protocolDestination;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.iconUrl;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.documentIconToken;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.documentIconObjType;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.documentIconInfo;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.documentIconUrl;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.accessTimeSec;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.avatarKey;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.avatarEntityId;
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
        return "ReferenceSnapshot(id=" + this.id + ", name=" + this.name + ", protocolDestination=" + this.protocolDestination + ", iconUrl=" + this.iconUrl + ", documentIconToken=" + this.documentIconToken + ", documentIconObjType=" + this.documentIconObjType + ", documentIconInfo=" + this.documentIconInfo + ", documentIconUrl=" + this.documentIconUrl + ", accessTimeSec=" + this.accessTimeSec + ", avatarKey=" + this.avatarKey + ", avatarEntityId=" + this.avatarEntityId + ')';
    }

    public final c1 a(InputReferenceType r18) {
        Intrinsics.checkNotNullParameter(r18, "type");
        if (r18 != InputReferenceType.GROUP) goto L8;
        Regex r1 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.a;
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r2 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.e(this.id, this.name, this.avatarKey, this.avatarEntityId);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new c1(r2, null, null, 6);
    L8:
        String r3 = this.id;
        if (r3 == null) goto L63;
        boolean r14 = true;
        if ((!StringsKt.isBlank(r3)) == false) goto L13;
        String r4 = r3;
    L14:
        if (r4 == null) goto L63;
        String r5 = this.name;
        if (r5 == null) goto L63;
        if ((!StringsKt.isBlank(r5)) == false) goto L21;
        String r6 = r5;
    L22:
        if (r6 == null) goto L63;
        String r7 = this.protocolDestination;
        String r8 = this.iconUrl;
        String r9 = this.documentIconToken;
        String r10 = "";
        if (r9 != null) goto L27;
        r9 = "";
    L27:
        Integer r11 = this.documentIconObjType;
        if (r11 == null) goto L30;
        int r12 = r11.intValue();
    L31:
        String r13 = this.documentIconInfo;
        if (r13 != null) goto L34;
        r13 = "";
    L34:
        String r15 = this.documentIconUrl;
        if (r15 == null) goto L38;
        r10 = r15;
    L38:
        com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r16 = new com.larus.bmhome.chat.component.bottom.core.inputtext.i0(r9, r12, r13, r10);
        if ((!StringsKt.isBlank(r16.a)) == false) goto L41;
    L48:
        boolean r17 = true;
    L49:
        if (r17 == false) goto L51;
        com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r19 = r16;
    L52:
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r20 = new com.larus.bmhome.chat.component.bottom.core.inputtext.d0(r4, r6, r18, r7, r8, r19, null, null, null, null, 960);
        Long r21 = this.accessTimeSec;
        if (r21 != null) goto L55;
    L60:
        r21 = null;
    L62:
        return new c1(r20, null, r21, 2);
    L55:
        if (r21.longValue() > 0) goto L58;
        r14 = false;
    L58:
        if (r14 == false) goto L60;
    L51:
        r19 = null;
        goto L52
    L41:
        if (r16.b != 0) goto L48;
        if ((!StringsKt.isBlank(r16.c)) == true) goto L48;
        if ((!StringsKt.isBlank(r16.d)) == true) goto L48;
        r17 = false;
        goto L49
    L30:
        r12 = 0;
        goto L31
    L21:
        r6 = null;
        goto L22
    L13:
        r4 = null;
    L63:
        return null;
    }

    public e1(String r1, String r2, String r3, String r4, String r5, Integer r6, String r7, String r8, Long r9, String r10, String r11) {
        this.id = r1;
        this.name = r2;
        this.protocolDestination = r3;
        this.iconUrl = r4;
        this.documentIconToken = r5;
        this.documentIconObjType = r6;
        this.documentIconInfo = r7;
        this.documentIconUrl = r8;
        this.accessTimeSec = r9;
        this.avatarKey = r10;
        this.avatarEntityId = r11;
    }
}
