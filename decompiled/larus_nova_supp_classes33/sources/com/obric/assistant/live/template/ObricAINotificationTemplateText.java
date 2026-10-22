package com.obric.assistant.live.template;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.livecard.api.entity.ColorToken;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003Jh\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0006HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;", "", "text", "", "maskedText", "textSize", "", "textColor", "textLightColor", "fontWeight", "maxLine", "color", "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getMaskedText", "setMaskedText", "getTextSize", "()I", "setTextSize", "(I)V", "getTextColor", "setTextColor", "getTextLightColor", "setTextLightColor", "getFontWeight", "setFontWeight", "getMaxLine", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAINotificationTemplateText {
    private ColorToken color;
    private String fontWeight;
    private String maskedText;
    private final Integer maxLine;
    private String text;
    private String textColor;
    private String textLightColor;
    private int textSize;

    public static /* synthetic */ ObricAINotificationTemplateText copy$default(ObricAINotificationTemplateText r9, String r10, String r11, int r12, String r13, String r14, String r15, Integer r16, ColorToken r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.text;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.maskedText;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r4 = r9.textSize;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.textColor;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.textLightColor;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.fontWeight;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Integer r8 = r9.maxLine;
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

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.maskedText;
    }

    public final int component3() {
        return this.textSize;
    }

    public final String component4() {
        return this.textColor;
    }

    public final String component5() {
        return this.textLightColor;
    }

    public final String component6() {
        return this.fontWeight;
    }

    public final Integer component7() {
        return this.maxLine;
    }

    public final ColorToken component8() {
        return this.color;
    }

    public final ObricAINotificationTemplateText copy(String r11, String r12, int r13, String r14, String r15, String r16, Integer r17, ColorToken r18) {
        Intrinsics.checkNotNullParameter(r11, "text");
        Intrinsics.checkNotNullParameter(r14, "textColor");
        return new ObricAINotificationTemplateText(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricAINotificationTemplateText) == true) goto L8;
        return false;
    L8:
        ObricAINotificationTemplateText r6 = (ObricAINotificationTemplateText) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maskedText, r6.maskedText) == true) goto L15;
        return false;
    L15:
        if (this.textSize == r6.textSize) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textColor, r6.textColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textLightColor, r6.textLightColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fontWeight, r6.fontWeight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.maxLine, r6.maxLine) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.color, r6.color) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.text.hashCode() * 31;
        String r1 = this.maskedText;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.textSize) * 31) + this.textColor.hashCode()) * 31;
        String r5 = this.textLightColor;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.fontWeight;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.maxLine;
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
        return "ObricAINotificationTemplateText(text=" + this.text + ", maskedText=" + this.maskedText + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", textLightColor=" + this.textLightColor + ", fontWeight=" + this.fontWeight + ", maxLine=" + this.maxLine + ", color=" + this.color + ')';
    }

    public final ColorToken getColor() {
        return this.color;
    }

    public final String getFontWeight() {
        return this.fontWeight;
    }

    public final String getMaskedText() {
        return this.maskedText;
    }

    public final Integer getMaxLine() {
        return this.maxLine;
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

    public ObricAINotificationTemplateText(String r2, String r3, int r4, String r5, String r6, String r7, Integer r8, ColorToken r9) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r5, "textColor");
        this.text = r2;
        this.maskedText = r3;
        this.textSize = r4;
        this.textColor = r5;
        this.textLightColor = r6;
        this.fontWeight = r7;
        this.maxLine = r8;
        this.color = r9;
    }

    public /* synthetic */ ObricAINotificationTemplateText(String r13, String r14, int r15, String r16, String r17, String r18, Integer r19, ColorToken r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 2) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r21 & 16) == 0) goto L9;
        String r8 = null;
    L11:
        if ((r21 & 32) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r21 & 64) == 0) goto L17;
        Integer r10 = null;
    L19:
        if ((r21 & 128) == 0) goto L21;
        ColorToken r11 = null;
    L22:
        this(r13, r5, r15, r16, r8, r9, r10, r11);
        return;
    L21:
        r11 = r20;
        goto L22
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }
}
