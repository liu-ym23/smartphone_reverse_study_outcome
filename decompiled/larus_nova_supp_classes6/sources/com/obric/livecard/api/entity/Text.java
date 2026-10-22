package com.obric.livecard.api.entity;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003Jh\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0005HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001d\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R$\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R&\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006<"}, d2 = {"Lcom/obric/livecard/api/entity/Text;", "", "text", "", "textSize", "", "textColor", "textLightColor", "fontWeight", "maskedText", "lineHeight", "color", "Lcom/obric/livecard/api/entity/ColorToken;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)V", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "getFontWeight$annotations", "()V", "getFontWeight", "()Ljava/lang/String;", "setFontWeight", "(Ljava/lang/String;)V", "getLineHeight$annotations", "getLineHeight", "()Ljava/lang/Integer;", "setLineHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaskedText", "setMaskedText", "getText", "setText", "getTextColor$annotations", "getTextColor", "setTextColor", "getTextLightColor$annotations", "getTextLightColor", "setTextLightColor", "getTextSize$annotations", "getTextSize", "()I", "setTextSize", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/livecard/api/entity/Text;", "equals", "", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class Text {
    private ColorToken color;
    private String fontWeight;
    private Integer lineHeight;
    private String maskedText;
    private String text;
    private String textColor;
    private String textLightColor;
    private int textSize;

    public static /* synthetic */ Text copy$default(Text r9, String r10, int r11, String r12, String r13, String r14, String r15, Integer r16, ColorToken r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.text;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r3 = r9.textSize;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.textColor;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.textLightColor;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.fontWeight;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.maskedText;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Integer r8 = r9.lineHeight;
    L31:
        if ((r18 & 128) == 0) goto L33;
        ColorToken r1 = r9.color;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    @Deprecated(message = "新版本废弃自定义字体")
    public static /* synthetic */ void getFontWeight$annotations() {
    }

    @Deprecated(message = "新版本废弃自定义字体")
    public static /* synthetic */ void getLineHeight$annotations() {
    }

    @Deprecated(message = "请使用colorToken")
    public static /* synthetic */ void getTextColor$annotations() {
    }

    @Deprecated(message = "请使用colorToken")
    public static /* synthetic */ void getTextLightColor$annotations() {
    }

    @Deprecated(message = "新版本废弃自定义字体")
    public static /* synthetic */ void getTextSize$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.textSize;
    }

    public final String component3() {
        return this.textColor;
    }

    public final String component4() {
        return this.textLightColor;
    }

    public final String component5() {
        return this.fontWeight;
    }

    public final String component6() {
        return this.maskedText;
    }

    public final Integer component7() {
        return this.lineHeight;
    }

    public final ColorToken component8() {
        return this.color;
    }

    public final Text copy(String r11, int r12, String r13, String r14, String r15, String r16, Integer r17, ColorToken r18) {
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r13, "textColor");
        return new Text(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Text) == true) goto L8;
        return false;
    L8:
        Text r6 = (Text) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (this.textSize == r6.textSize) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textLightColor, r6.textLightColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fontWeight, r6.fontWeight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maskedText, r6.maskedText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.lineHeight, r6.lineHeight) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.color, r6.color) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.text.hashCode() * 31) + this.textSize) * 31) + this.textColor.hashCode()) * 31;
        String r1 = this.textLightColor;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.fontWeight;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.maskedText;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.lineHeight;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        ColorToken r14 = this.color;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "Text(text=" + this.text + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", textLightColor=" + this.textLightColor + ", fontWeight=" + this.fontWeight + ", maskedText=" + this.maskedText + ", lineHeight=" + this.lineHeight + ", color=" + this.color + ')';
    }

    public final ColorToken getColor() {
        return this.color;
    }

    public final String getFontWeight() {
        return this.fontWeight;
    }

    public final Integer getLineHeight() {
        return this.lineHeight;
    }

    public final String getMaskedText() {
        return this.maskedText;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final String getTextLightColor() {
        return this.textLightColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final void setColor(ColorToken r1) {
        this.color = r1;
    }

    public final void setFontWeight(String r1) {
        this.fontWeight = r1;
    }

    public final void setLineHeight(Integer r1) {
        this.lineHeight = r1;
    }

    public final void setMaskedText(String r1) {
        this.maskedText = r1;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public final void setTextColor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textColor = r2;
    }

    public final void setTextLightColor(String r1) {
        this.textLightColor = r1;
    }

    public final void setTextSize(int r1) {
        this.textSize = r1;
    }

    public Text(String r2, int r3, String r4, String r5, String r6, String r7, Integer r8, ColorToken r9) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r4, "textColor");
        this.text = r2;
        this.textSize = r3;
        this.textColor = r4;
        this.textLightColor = r5;
        this.fontWeight = r6;
        this.maskedText = r7;
        this.lineHeight = r8;
        this.color = r9;
    }

    public /* synthetic */ Text(String r9, int r10, String r11, String r12, String r13, String r14, Integer r15, ColorToken r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 2) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r17 & 4) == 0) goto L9;
        String r2 = "";
    L10:
        ColorToken r4 = null;
        if ((r17 & 8) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r17 & 16) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r17 & 32) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r17 & 64) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r17 & 128) != 0) goto L30;
        r4 = r16;
    L30:
        this(r9, r1, r2, r3, r5, r6, r7, r4);
        return;
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r1 = r10;
        goto L7
    }
}
