package com.ss.android.lark.message.card.view.richtext;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class YogaProperty implements Serializable {
    private static final long serialVersionUID = 5197740916295279064L;
    public int alignContent;
    public int alignItems;
    public int alignSelf;
    public float aspectRatio;
    public float bottom;
    public int display;
    public float flexBasis;
    public int flexDirection;
    public float flexGrow;
    public float flexShrink;
    public int flexWrap;
    public float height;
    public float heightPercent;
    public int justifyContent;
    public float left;
    public float marginBottom;
    public float marginBottomPercent;
    public float marginLeft;
    public float marginLeftPercent;
    public float marginRight;
    public float marginRightPercent;
    public float marginTop;
    public float marginTopPercent;
    public float maxHeight;
    public float maxHeightPercent;
    public float maxWidth;
    public float maxWidthPercent;
    public float minHeight;
    public float minHeightPercent;
    public float minWidth;
    public float minWidthPercent;
    public float paddingBottom;
    public float paddingLeft;
    public float paddingRight;
    public float paddingTop;
    public int position;
    public float right;
    public float top;
    public float width;
    public float widthPercent;

    public int hashCode() {
        int r0 = ((this.flexDirection * 31) + this.flexWrap) * 31;
        float r1 = this.flexBasis;
        int r2 = 0;
        if (r1 == 0.0f) goto L5;
        int r3 = Float.floatToIntBits(r1);
    L6:
        int r4 = (r0 + r3) * 31;
        float r5 = this.flexGrow;
        if (r5 == 0.0f) goto L9;
        int r6 = Float.floatToIntBits(r5);
    L10:
        int r7 = (r4 + r6) * 31;
        float r8 = this.flexShrink;
        if (r8 == 0.0f) goto L13;
        int r9 = Float.floatToIntBits(r8);
    L14:
        int r10 = (((((((((((((r7 + r9) * 31) + this.justifyContent) * 31) + this.alignContent) * 31) + this.alignItems) * 31) + this.alignSelf) * 31) + this.display) * 31) + this.position) * 31;
        float r11 = this.aspectRatio;
        if (r11 == 0.0f) goto L17;
        int r12 = Float.floatToIntBits(r11);
    L18:
        int r13 = (r10 + r12) * 31;
        float r14 = this.maxWidth;
        if (r14 == 0.0f) goto L21;
        int r15 = Float.floatToIntBits(r14);
    L22:
        int r16 = (r13 + r15) * 31;
        float r17 = this.maxWidthPercent;
        if (r17 == 0.0f) goto L25;
        int r18 = Float.floatToIntBits(r17);
    L26:
        int r19 = (r16 + r18) * 31;
        float r20 = this.minWidth;
        if (r20 == 0.0f) goto L29;
        int r21 = Float.floatToIntBits(r20);
    L30:
        int r22 = (r19 + r21) * 31;
        float r23 = this.minWidthPercent;
        if (r23 == 0.0f) goto L33;
        int r24 = Float.floatToIntBits(r23);
    L34:
        int r25 = (r22 + r24) * 31;
        float r26 = this.width;
        if (r26 == 0.0f) goto L37;
        int r27 = Float.floatToIntBits(r26);
    L38:
        int r28 = (r25 + r27) * 31;
        float r29 = this.widthPercent;
        if (r29 == 0.0f) goto L41;
        int r30 = Float.floatToIntBits(r29);
    L42:
        int r31 = (r28 + r30) * 31;
        float r32 = this.maxHeight;
        if (r32 == 0.0f) goto L45;
        int r33 = Float.floatToIntBits(r32);
    L46:
        int r34 = (r31 + r33) * 31;
        float r35 = this.maxHeightPercent;
        if (r35 == 0.0f) goto L49;
        int r36 = Float.floatToIntBits(r35);
    L50:
        int r37 = (r34 + r36) * 31;
        float r38 = this.minHeight;
        if (r38 == 0.0f) goto L53;
        int r39 = Float.floatToIntBits(r38);
    L54:
        int r40 = (r37 + r39) * 31;
        float r41 = this.minHeightPercent;
        if (r41 == 0.0f) goto L57;
        int r42 = Float.floatToIntBits(r41);
    L58:
        int r43 = (r40 + r42) * 31;
        float r44 = this.height;
        if (r44 == 0.0f) goto L61;
        int r45 = Float.floatToIntBits(r44);
    L62:
        int r46 = (r43 + r45) * 31;
        float r47 = this.heightPercent;
        if (r47 == 0.0f) goto L65;
        int r48 = Float.floatToIntBits(r47);
    L66:
        int r49 = (r46 + r48) * 31;
        float r50 = this.marginTop;
        if (r50 == 0.0f) goto L69;
        int r51 = Float.floatToIntBits(r50);
    L70:
        int r52 = (r49 + r51) * 31;
        float r53 = this.marginRight;
        if (r53 == 0.0f) goto L73;
        int r54 = Float.floatToIntBits(r53);
    L74:
        int r55 = (r52 + r54) * 31;
        float r56 = this.marginBottom;
        if (r56 == 0.0f) goto L77;
        int r57 = Float.floatToIntBits(r56);
    L78:
        int r58 = (r55 + r57) * 31;
        float r59 = this.marginLeft;
        if (r59 == 0.0f) goto L81;
        int r60 = Float.floatToIntBits(r59);
    L82:
        int r61 = (r58 + r60) * 31;
        float r62 = this.paddingTop;
        if (r62 == 0.0f) goto L85;
        int r63 = Float.floatToIntBits(r62);
    L86:
        int r64 = (r61 + r63) * 31;
        float r65 = this.paddingRight;
        if (r65 == 0.0f) goto L89;
        int r66 = Float.floatToIntBits(r65);
    L90:
        int r67 = (r64 + r66) * 31;
        float r68 = this.paddingBottom;
        if (r68 == 0.0f) goto L93;
        int r69 = Float.floatToIntBits(r68);
    L94:
        int r70 = (r67 + r69) * 31;
        float r71 = this.paddingLeft;
        if (r71 == 0.0f) goto L97;
        int r72 = Float.floatToIntBits(r71);
    L98:
        int r73 = (r70 + r72) * 31;
        float r74 = this.top;
        if (r74 == 0.0f) goto L101;
        int r75 = Float.floatToIntBits(r74);
    L102:
        int r76 = (r73 + r75) * 31;
        float r77 = this.right;
        if (r77 == 0.0f) goto L105;
        int r78 = Float.floatToIntBits(r77);
    L106:
        int r79 = (r76 + r78) * 31;
        float r80 = this.bottom;
        if (r80 == 0.0f) goto L109;
        int r81 = Float.floatToIntBits(r80);
    L110:
        int r82 = (r79 + r81) * 31;
        float r83 = this.left;
        if (r83 == 0.0f) goto L114;
        r2 = Float.floatToIntBits(r83);
    L114:
        return r82 + r2;
    L109:
        r81 = 0;
        goto L110
    L105:
        r78 = 0;
        goto L106
    L101:
        r75 = 0;
        goto L102
    L97:
        r72 = 0;
        goto L98
    L93:
        r69 = 0;
        goto L94
    L89:
        r66 = 0;
        goto L90
    L85:
        r63 = 0;
        goto L86
    L81:
        r60 = 0;
        goto L82
    L77:
        r57 = 0;
        goto L78
    L73:
        r54 = 0;
        goto L74
    L69:
        r51 = 0;
        goto L70
    L65:
        r48 = 0;
        goto L66
    L61:
        r45 = 0;
        goto L62
    L57:
        r42 = 0;
        goto L58
    L53:
        r39 = 0;
        goto L54
    L49:
        r36 = 0;
        goto L50
    L45:
        r33 = 0;
        goto L46
    L41:
        r30 = 0;
        goto L42
    L37:
        r27 = 0;
        goto L38
    L33:
        r24 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public YogaProperty() {
        this.flexDirection = -1;
        this.flexWrap = -1;
        this.flexBasis = 1.0E21f;
        this.flexGrow = -1.0f;
        this.flexShrink = -1.0f;
        this.justifyContent = -1;
        this.alignContent = -1;
        this.alignItems = -1;
        this.alignSelf = -1;
        this.display = -1;
        this.position = -1;
        this.aspectRatio = 1.0E21f;
        this.maxWidth = 1.0E21f;
        this.maxWidthPercent = 1.0E21f;
        this.minWidth = 1.0E21f;
        this.minWidthPercent = 1.0E21f;
        this.width = 1.0E21f;
        this.widthPercent = 1.0E21f;
        this.maxHeight = 1.0E21f;
        this.maxHeightPercent = 1.0E21f;
        this.minHeight = 1.0E21f;
        this.minHeightPercent = 1.0E21f;
        this.height = 1.0E21f;
        this.heightPercent = 1.0E21f;
        this.marginTop = 1.0E21f;
        this.marginTopPercent = 1.0E21f;
        this.marginRight = 1.0E21f;
        this.marginRightPercent = 1.0E21f;
        this.marginBottom = 1.0E21f;
        this.marginBottomPercent = 1.0E21f;
        this.marginLeft = 1.0E21f;
        this.marginLeftPercent = 1.0E21f;
        this.paddingTop = 0.0f;
        this.paddingRight = 0.0f;
        this.paddingBottom = 0.0f;
        this.paddingLeft = 0.0f;
        this.top = 1.0E21f;
        this.right = 1.0E21f;
        this.bottom = 1.0E21f;
        this.left = 1.0E21f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L120:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L120;
        YogaProperty r6 = (YogaProperty) r5;
        if (this.flexDirection == r6.flexDirection) goto L14;
        return false;
    L14:
        if (this.flexWrap == r6.flexWrap) goto L17;
        return false;
    L17:
        if (Float.compare(r6.flexBasis, this.flexBasis) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(r6.flexGrow, this.flexGrow) == 0) goto L23;
        return false;
    L23:
        if (Float.compare(r6.flexShrink, this.flexShrink) == 0) goto L26;
        return false;
    L26:
        if (this.justifyContent == r6.justifyContent) goto L29;
        return false;
    L29:
        if (this.alignContent == r6.alignContent) goto L32;
        return false;
    L32:
        if (this.alignItems == r6.alignItems) goto L35;
        return false;
    L35:
        if (this.alignSelf == r6.alignSelf) goto L38;
        return false;
    L38:
        if (this.display == r6.display) goto L41;
        return false;
    L41:
        if (this.position == r6.position) goto L44;
        return false;
    L44:
        if (this.aspectRatio == r6.aspectRatio) goto L47;
        return false;
    L47:
        if (Float.compare(r6.maxWidth, this.maxWidth) == 0) goto L50;
        return false;
    L50:
        if (Float.compare(r6.maxWidthPercent, this.maxWidthPercent) == 0) goto L53;
        return false;
    L53:
        if (Float.compare(r6.minWidth, this.minWidth) == 0) goto L56;
        return false;
    L56:
        if (Float.compare(r6.minWidthPercent, this.minWidthPercent) == 0) goto L59;
        return false;
    L59:
        if (Float.compare(r6.width, this.width) == 0) goto L62;
        return false;
    L62:
        if (Float.compare(r6.widthPercent, this.widthPercent) == 0) goto L65;
        return false;
    L65:
        if (Float.compare(r6.maxHeight, this.maxHeight) == 0) goto L68;
        return false;
    L68:
        if (Float.compare(r6.maxHeightPercent, this.maxHeightPercent) == 0) goto L71;
        return false;
    L71:
        if (Float.compare(r6.minHeight, this.minHeight) == 0) goto L74;
        return false;
    L74:
        if (Float.compare(r6.minHeightPercent, this.minHeightPercent) == 0) goto L77;
        return false;
    L77:
        if (Float.compare(r6.height, this.height) == 0) goto L80;
        return false;
    L80:
        if (Float.compare(r6.heightPercent, this.heightPercent) == 0) goto L83;
        return false;
    L83:
        if (Float.compare(r6.marginTop, this.marginTop) == 0) goto L86;
        return false;
    L86:
        if (Float.compare(r6.marginRight, this.marginRight) == 0) goto L89;
        return false;
    L89:
        if (Float.compare(r6.marginBottom, this.marginBottom) == 0) goto L92;
        return false;
    L92:
        if (Float.compare(r6.marginLeft, this.marginLeft) == 0) goto L95;
        return false;
    L95:
        if (Float.compare(r6.paddingTop, this.paddingTop) == 0) goto L98;
        return false;
    L98:
        if (Float.compare(r6.paddingRight, this.paddingRight) == 0) goto L101;
        return false;
    L101:
        if (Float.compare(r6.paddingBottom, this.paddingBottom) == 0) goto L104;
        return false;
    L104:
        if (Float.compare(r6.paddingLeft, this.paddingLeft) == 0) goto L107;
        return false;
    L107:
        if (Float.compare(r6.top, this.top) == 0) goto L110;
        return false;
    L110:
        if (Float.compare(r6.right, this.right) == 0) goto L113;
        return false;
    L113:
        if (Float.compare(r6.bottom, this.bottom) == 0) goto L116;
        return false;
    L116:
        if (Float.compare(r6.left, this.left) == 0) goto L121;
        return false;
    L121:
        return true;
    }
}
