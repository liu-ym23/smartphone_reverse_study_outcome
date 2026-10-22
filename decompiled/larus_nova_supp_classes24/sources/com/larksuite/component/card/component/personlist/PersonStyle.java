package com.larksuite.component.card.component.personlist;

import android.os.Parcel;
import android.os.Parcelable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0006\u0010/\u001a\u00020\u0003J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0007HÖ\u0001J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonStyle;", "Landroid/os/Parcelable;", "avatarSize", "", "avatarSpace", "nameSize", "nameToken", "", "nameLineHeight", "nameColor", "moreColor", "moreTextColor", "moreTextToken", "moreTextSize", "moreMaxCount", "margin", "Lcom/larksuite/component/card/component/personlist/PersonMargin;", "<init>", "(IIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/larksuite/component/card/component/personlist/PersonMargin;)V", "getAvatarSize", "()I", "getAvatarSpace", "getNameSize", "getNameToken", "()Ljava/lang/String;", "getNameLineHeight", "getNameColor", "getMoreColor", "getMoreTextColor", "getMoreTextToken", "getMoreTextSize", "getMoreMaxCount", "getMargin", "()Lcom/larksuite/component/card/component/personlist/PersonMargin;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonStyle implements Parcelable {
    public static final Parcelable.Creator<PersonStyle> CREATOR = null;
    private final int avatarSize;
    private final int avatarSpace;
    private final PersonMargin margin;
    private final String moreColor;
    private final int moreMaxCount;
    private final String moreTextColor;
    private final int moreTextSize;
    private final String moreTextToken;
    private final String nameColor;
    private final int nameLineHeight;
    private final int nameSize;
    private final String nameToken;

    public static final class a implements Parcelable.Creator<PersonStyle> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PersonStyle createFromParcel(Parcel r15) {
            Intrinsics.checkNotNullParameter(r15, "parcel");
            return new PersonStyle(r15.readInt(), r15.readInt(), r15.readInt(), r15.readString(), r15.readInt(), r15.readString(), r15.readString(), r15.readString(), r15.readString(), r15.readInt(), r15.readInt(), PersonMargin.CREATOR.createFromParcel(r15));
        }

        @Override // android.os.Parcelable.Creator
        public final PersonStyle[] newArray(int r1) {
            return new PersonStyle[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ PersonStyle copy$default(PersonStyle r13, int r14, int r15, int r16, String r17, int r19, String r110, String r20, String r21, String r22, int r23, int r24, PersonMargin r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        int r2 = r13.avatarSize;
    L7:
        if ((r26 & 2) == 0) goto L9;
        int r3 = r13.avatarSpace;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r4 = r13.nameSize;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r5 = r13.nameToken;
    L19:
        if ((r26 & 16) == 0) goto L21;
        int r6 = r13.nameLineHeight;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r7 = r13.nameColor;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = r13.moreColor;
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r9 = r13.moreTextColor;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r10 = r13.moreTextToken;
    L39:
        if ((r26 & 512) == 0) goto L41;
        int r11 = r13.moreTextSize;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        int r12 = r13.moreMaxCount;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        PersonMargin r1 = r13.margin;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r110;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final int component1() {
        return this.avatarSize;
    }

    public final int component10() {
        return this.moreTextSize;
    }

    public final int component11() {
        return this.moreMaxCount;
    }

    public final PersonMargin component12() {
        return this.margin;
    }

    public final int component2() {
        return this.avatarSpace;
    }

    public final int component3() {
        return this.nameSize;
    }

    public final String component4() {
        return this.nameToken;
    }

    public final int component5() {
        return this.nameLineHeight;
    }

    public final String component6() {
        return this.nameColor;
    }

    public final String component7() {
        return this.moreColor;
    }

    public final String component8() {
        return this.moreTextColor;
    }

    public final String component9() {
        return this.moreTextToken;
    }

    public final PersonStyle copy(int r15, int r16, int r17, String r19, int r110, String r20, String r21, String r22, String r23, int r24, int r25, PersonMargin r26) {
        Intrinsics.checkNotNullParameter(r19, "nameToken");
        Intrinsics.checkNotNullParameter(r20, "nameColor");
        Intrinsics.checkNotNullParameter(r21, "moreColor");
        Intrinsics.checkNotNullParameter(r22, "moreTextColor");
        Intrinsics.checkNotNullParameter(r23, "moreTextToken");
        Intrinsics.checkNotNullParameter(r26, "margin");
        return new PersonStyle(r15, r16, r17, r19, r110, r20, r21, r22, r23, r24, r25, r26);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PersonStyle) == true) goto L8;
        return false;
    L8:
        PersonStyle r6 = (PersonStyle) r5;
        if (this.avatarSize == r6.avatarSize) goto L12;
        return false;
    L12:
        if (this.avatarSpace == r6.avatarSpace) goto L15;
        return false;
    L15:
        if (this.nameSize == r6.nameSize) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nameToken, r6.nameToken) == true) goto L21;
        return false;
    L21:
        if (this.nameLineHeight == r6.nameLineHeight) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.nameColor, r6.nameColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.moreColor, r6.moreColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.moreTextColor, r6.moreTextColor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.moreTextToken, r6.moreTextToken) == true) goto L36;
        return false;
    L36:
        if (this.moreTextSize == r6.moreTextSize) goto L39;
        return false;
    L39:
        if (this.moreMaxCount == r6.moreMaxCount) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.margin, r6.margin) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.avatarSize * 31) + this.avatarSpace) * 31) + this.nameSize) * 31) + this.nameToken.hashCode()) * 31) + this.nameLineHeight) * 31) + this.nameColor.hashCode()) * 31) + this.moreColor.hashCode()) * 31) + this.moreTextColor.hashCode()) * 31) + this.moreTextToken.hashCode()) * 31) + this.moreTextSize) * 31) + this.moreMaxCount) * 31) + this.margin.hashCode();
    }

    public String toString() {
        return "PersonStyle(avatarSize=" + this.avatarSize + ", avatarSpace=" + this.avatarSpace + ", nameSize=" + this.nameSize + ", nameToken=" + this.nameToken + ", nameLineHeight=" + this.nameLineHeight + ", nameColor=" + this.nameColor + ", moreColor=" + this.moreColor + ", moreTextColor=" + this.moreTextColor + ", moreTextToken=" + this.moreTextToken + ", moreTextSize=" + this.moreTextSize + ", moreMaxCount=" + this.moreMaxCount + ", margin=" + this.margin + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeInt(this.avatarSize);
        r2.writeInt(this.avatarSpace);
        r2.writeInt(this.nameSize);
        r2.writeString(this.nameToken);
        r2.writeInt(this.nameLineHeight);
        r2.writeString(this.nameColor);
        r2.writeString(this.moreColor);
        r2.writeString(this.moreTextColor);
        r2.writeString(this.moreTextToken);
        r2.writeInt(this.moreTextSize);
        r2.writeInt(this.moreMaxCount);
        this.margin.writeToParcel(r2, r3);
    }

    public final int getAvatarSize() {
        return this.avatarSize;
    }

    public final int getAvatarSpace() {
        return this.avatarSpace;
    }

    public final PersonMargin getMargin() {
        return this.margin;
    }

    public final String getMoreColor() {
        return this.moreColor;
    }

    public final int getMoreMaxCount() {
        return this.moreMaxCount;
    }

    public final String getMoreTextColor() {
        return this.moreTextColor;
    }

    public final int getMoreTextSize() {
        return this.moreTextSize;
    }

    public final String getMoreTextToken() {
        return this.moreTextToken;
    }

    public final String getNameColor() {
        return this.nameColor;
    }

    public final int getNameLineHeight() {
        return this.nameLineHeight;
    }

    public final int getNameSize() {
        return this.nameSize;
    }

    public final String getNameToken() {
        return this.nameToken;
    }

    public PersonStyle(int r2, int r3, int r4, String r5, int r6, String r7, String r8, String r9, String r10, int r11, int r12, PersonMargin r13) {
        Intrinsics.checkNotNullParameter(r5, "nameToken");
        Intrinsics.checkNotNullParameter(r7, "nameColor");
        Intrinsics.checkNotNullParameter(r8, "moreColor");
        Intrinsics.checkNotNullParameter(r9, "moreTextColor");
        Intrinsics.checkNotNullParameter(r10, "moreTextToken");
        Intrinsics.checkNotNullParameter(r13, "margin");
        this.avatarSize = r2;
        this.avatarSpace = r3;
        this.nameSize = r4;
        this.nameToken = r5;
        this.nameLineHeight = r6;
        this.nameColor = r7;
        this.moreColor = r8;
        this.moreTextColor = r9;
        this.moreTextToken = r10;
        this.moreTextSize = r11;
        this.moreMaxCount = r12;
        this.margin = r13;
    }
}
