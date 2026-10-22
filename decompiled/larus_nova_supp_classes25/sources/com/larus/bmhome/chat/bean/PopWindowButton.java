package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u000bJ\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowButton;", "Landroid/os/Parcelable;", ChatDraftItem.TYPE_TEXT, "", "textColor", "Lcom/larus/bmhome/chat/bean/PopWindowColor;", "backgroundColor", "schema", "bizReqId", "params", "actionType", "", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowColor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getText", "()Ljava/lang/String;", "getTextColor", "()Lcom/larus/bmhome/chat/bean/PopWindowColor;", "getBackgroundColor", "getSchema", "getBizReqId", "getParams", "getActionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowColor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/PopWindowButton;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PopWindowButton implements Parcelable {
    public static final Parcelable.Creator<PopWindowButton> CREATOR = null;

    @SerializedName("action_type")
    private final Integer actionType;

    @SerializedName("background_color")
    private final PopWindowColor backgroundColor;

    @SerializedName("biz_req_id")
    private final String bizReqId;

    @SerializedName("params")
    private final String params;

    @SerializedName("schema")
    private final String schema;

    @SerializedName(ChatDraftItem.TYPE_TEXT)
    private final String text;

    @SerializedName("text_color")
    private final PopWindowColor textColor;

    public static final class a implements Parcelable.Creator<PopWindowButton> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowButton createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r2 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            PopWindowColor r1 = null;
        L6:
            PopWindowColor r4 = r1;
            if (r10.readInt() != 0) goto L9;
            PopWindowColor r3 = null;
        L10:
            PopWindowColor r5 = r3;
            String r6 = r10.readString();
            String r7 = r10.readString();
            String r8 = r10.readString();
            if (r10.readInt() != 0) goto L13;
            Integer r11 = null;
        L15:
            return new PopWindowButton(r2, r4, r5, r6, r7, r8, r11);
        L13:
            r11 = Integer.valueOf(r10.readInt());
            goto L15
        L9:
            r3 = PopWindowColor.CREATOR.createFromParcel(r10);
            goto L10
        L5:
            r1 = PopWindowColor.CREATOR.createFromParcel(r10);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowButton[] newArray(int r1) {
            return new PopWindowButton[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowButton() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PopWindowButton copy$default(PopWindowButton r5, String r6, PopWindowColor r7, PopWindowColor r8, String r9, String r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.text;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.textColor;
    L8:
        PopWindowColor r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.backgroundColor;
    L11:
        PopWindowColor r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.schema;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.bizReqId;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.params;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.actionType;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.text;
    }

    public final PopWindowColor component2() {
        return this.textColor;
    }

    public final PopWindowColor component3() {
        return this.backgroundColor;
    }

    public final String component4() {
        return this.schema;
    }

    public final String component5() {
        return this.bizReqId;
    }

    public final String component6() {
        return this.params;
    }

    public final Integer component7() {
        return this.actionType;
    }

    public final PopWindowButton copy(String r10, PopWindowColor r11, PopWindowColor r12, String r13, String r14, String r15, Integer r16) {
        return new PopWindowButton(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PopWindowButton) == true) goto L8;
        return false;
    L8:
        PopWindowButton r6 = (PopWindowButton) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.schema, r6.schema) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bizReqId, r6.bizReqId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.actionType, r6.actionType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PopWindowColor r4 = this.textColor;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        PopWindowColor r7 = this.backgroundColor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.schema;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.bizReqId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.params;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.actionType;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
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
        return "PopWindowButton(text=" + this.text + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", schema=" + this.schema + ", bizReqId=" + this.bizReqId + ", params=" + this.params + ", actionType=" + this.actionType + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.text);
        PopWindowColor r0 = this.textColor;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        PopWindowColor r1 = this.backgroundColor;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        r4.writeString(this.schema);
        r4.writeString(this.bizReqId);
        r4.writeString(this.params);
        Integer r6 = this.actionType;
        if (r6 != null) goto L13;
        r4.writeInt(0);
        return;
    L13:
        r4.writeInt(1);
        r4.writeInt(r6.intValue());
        return;
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        goto L10
    L5:
        r4.writeInt(1);
        r0.writeToParcel(r4, r5);
        goto L6
    }

    public final Integer getActionType() {
        return this.actionType;
    }

    public final PopWindowColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBizReqId() {
        return this.bizReqId;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getText() {
        return this.text;
    }

    public final PopWindowColor getTextColor() {
        return this.textColor;
    }

    public PopWindowButton(String r1, PopWindowColor r2, PopWindowColor r3, String r4, String r5, String r6, Integer r7) {
        this.text = r1;
        this.textColor = r2;
        this.backgroundColor = r3;
        this.schema = r4;
        this.bizReqId = r5;
        this.params = r6;
        this.actionType = r7;
    }

    public /* synthetic */ PopWindowButton(String r7, PopWindowColor r8, PopWindowColor r9, String r10, String r11, String r12, Integer r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        PopWindowColor r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        PopWindowColor r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        Integer r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
