package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/bean/PopWindowText;", "Landroid/os/Parcelable;", "title", "", "description", "textAlignment", "", "descriptionAlignment", "textColor", "Lcom/larus/bmhome/chat/bean/PopWindowColor;", "descriptionColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowColor;)V", "getTitle", "()Ljava/lang/String;", "getDescription", "getTextAlignment", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescriptionAlignment", "getTextColor", "()Lcom/larus/bmhome/chat/bean/PopWindowColor;", "getDescriptionColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/chat/bean/PopWindowColor;Lcom/larus/bmhome/chat/bean/PopWindowColor;)Lcom/larus/bmhome/chat/bean/PopWindowText;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PopWindowText implements Parcelable {
    public static final Parcelable.Creator<PopWindowText> CREATOR = null;

    @SerializedName("description")
    private final String description;

    @SerializedName("description_alignment")
    private final Integer descriptionAlignment;

    @SerializedName("description_color")
    private final PopWindowColor descriptionColor;

    @SerializedName("text_alignment")
    private final Integer textAlignment;

    @SerializedName("text_color")
    private final PopWindowColor textColor;

    @SerializedName("title")
    private final String title;

    public static final class a implements Parcelable.Creator<PopWindowText> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowText createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            String r2 = r9.readString();
            String r3 = r9.readString();
            PopWindowColor r4 = null;
            if (r9.readInt() != 0) goto L5;
            Integer r5 = null;
        L7:
            if (r9.readInt() != 0) goto L9;
            Integer r6 = null;
        L11:
            if (r9.readInt() != 0) goto L13;
            PopWindowColor r1 = null;
        L14:
            PopWindowColor r7 = r1;
            if (r9.readInt() == 0) goto L19;
            r4 = PopWindowColor.CREATOR.createFromParcel(r9);
        L19:
            return new PopWindowText(r2, r3, r5, r6, r7, r4);
        L13:
            r1 = PopWindowColor.CREATOR.createFromParcel(r9);
            goto L14
        L9:
            r6 = Integer.valueOf(r9.readInt());
            goto L11
        L5:
            r5 = Integer.valueOf(r9.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final PopWindowText[] newArray(int r1) {
            return new PopWindowText[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public PopWindowText() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PopWindowText copy$default(PopWindowText r4, String r5, String r6, Integer r7, Integer r8, PopWindowColor r9, PopWindowColor r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.title;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.description;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.textAlignment;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.descriptionAlignment;
    L14:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.textColor;
    L17:
        PopWindowColor r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.descriptionColor;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final Integer component3() {
        return this.textAlignment;
    }

    public final Integer component4() {
        return this.descriptionAlignment;
    }

    public final PopWindowColor component5() {
        return this.textColor;
    }

    public final PopWindowColor component6() {
        return this.descriptionColor;
    }

    public final PopWindowText copy(String r9, String r10, Integer r11, Integer r12, PopWindowColor r13, PopWindowColor r14) {
        return new PopWindowText(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PopWindowText) == true) goto L8;
        return false;
    L8:
        PopWindowText r6 = (PopWindowText) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textAlignment, r6.textAlignment) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.descriptionAlignment, r6.descriptionAlignment) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.descriptionColor, r6.descriptionColor) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.description;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.textAlignment;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.descriptionAlignment;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        PopWindowColor r13 = this.textColor;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        PopWindowColor r16 = this.descriptionColor;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "PopWindowText(title=" + this.title + ", description=" + this.description + ", textAlignment=" + this.textAlignment + ", descriptionAlignment=" + this.descriptionAlignment + ", textColor=" + this.textColor + ", descriptionColor=" + this.descriptionColor + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.title);
        r4.writeString(this.description);
        Integer r0 = this.textAlignment;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        Integer r1 = this.descriptionAlignment;
        if (r1 != null) goto L9;
        r4.writeInt(0);
    L10:
        PopWindowColor r2 = this.textColor;
        if (r2 != null) goto L13;
        r4.writeInt(0);
    L14:
        PopWindowColor r3 = this.descriptionColor;
        if (r3 != null) goto L17;
        r4.writeInt(0);
        return;
    L17:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        return;
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

    public final String getDescription() {
        return this.description;
    }

    public final Integer getDescriptionAlignment() {
        return this.descriptionAlignment;
    }

    public final PopWindowColor getDescriptionColor() {
        return this.descriptionColor;
    }

    public final Integer getTextAlignment() {
        return this.textAlignment;
    }

    public final PopWindowColor getTextColor() {
        return this.textColor;
    }

    public final String getTitle() {
        return this.title;
    }

    public PopWindowText(String r1, String r2, Integer r3, Integer r4, PopWindowColor r5, PopWindowColor r6) {
        this.title = r1;
        this.description = r2;
        this.textAlignment = r3;
        this.descriptionAlignment = r4;
        this.textColor = r5;
        this.descriptionColor = r6;
    }

    public /* synthetic */ PopWindowText(String r6, String r7, Integer r8, Integer r9, PopWindowColor r10, PopWindowColor r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Integer r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Integer r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        PopWindowColor r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        PopWindowColor r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
