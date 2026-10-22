package com.obric.livecard.api.entity;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Deprecated(message = "新版本废弃自定义字体")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/obric/livecard/api/entity/TextIconStyle;", "", "backgroundColor", "", "textSize", "", "textColor", "textLightColor", "fontWeight", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getFontWeight", "setFontWeight", "getTextColor", "setTextColor", "getTextLightColor", "setTextLightColor", "getTextSize", "()I", "setTextSize", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextIconStyle {
    private String backgroundColor;
    private String fontWeight;
    private String textColor;
    private String textLightColor;
    private int textSize;

    public static /* synthetic */ TextIconStyle copy$default(TextIconStyle r3, String r4, int r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.backgroundColor;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.textSize;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.textColor;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.textLightColor;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.fontWeight;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.backgroundColor;
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

    public final TextIconStyle copy(String r8, int r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "backgroundColor");
        Intrinsics.checkNotNullParameter(r10, "textColor");
        return new TextIconStyle(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextIconStyle) == true) goto L8;
        return false;
    L8:
        TextIconStyle r6 = (TextIconStyle) r5;
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L12;
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
        if (Intrinsics.areEqual(this.fontWeight, r6.fontWeight) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.backgroundColor.hashCode() * 31) + this.textSize) * 31) + this.textColor.hashCode()) * 31;
        String r1 = this.textLightColor;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.fontWeight;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "TextIconStyle(backgroundColor=" + this.backgroundColor + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", textLightColor=" + this.textLightColor + ", fontWeight=" + this.fontWeight + ')';
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getFontWeight() {
        return this.fontWeight;
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

    public final void setBackgroundColor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.backgroundColor = r2;
    }

    public final void setFontWeight(String r1) {
        this.fontWeight = r1;
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

    public TextIconStyle(String r2, int r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "backgroundColor");
        Intrinsics.checkNotNullParameter(r4, "textColor");
        this.backgroundColor = r2;
        this.textSize = r3;
        this.textColor = r4;
        this.textLightColor = r5;
        this.fontWeight = r6;
    }

    public /* synthetic */ TextIconStyle(String r8, int r9, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        String r6 = null;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
