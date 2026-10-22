package com.ss.android.lark.message.card.view.richtext;

import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class w0 {
    public static YogaNode a(YogaProperty r6) {
        YogaNode r0 = new YogaNode();
        if (r6 != null) goto L5;
        return r0;
    L5:
        int r1 = r6.position;
        if (r1 == (-1)) goto L8;
        r0.setPositionType(YogaPositionType.fromInt(r1));
    L10:
        if (YogaConstants.isUndefined(r6.aspectRatio) == true) goto L12;
        r0.setAspectRatio(r6.aspectRatio);
    L12:
        int r2 = r6.flexDirection;
        if (r2 == (-1)) goto L15;
        r0.setFlexDirection(YogaFlexDirection.fromInt(r2));
    L16:
        int r3 = r6.flexWrap;
        if (r3 == (-1)) goto L19;
        r0.setWrap(YogaWrap.fromInt(r3));
    L21:
        if (YogaConstants.isUndefined(r6.flexBasis) == true) goto L23;
        r0.setFlexBasis(r6.flexBasis);
    L25:
        if (Float.compare(r6.flexGrow, -1.0f) == 0) goto L27;
        r0.setFlexGrow(r6.flexGrow);
    L29:
        if (Float.compare(r6.flexShrink, -1.0f) == 0) goto L31;
        r0.setFlexShrink(r6.flexShrink);
    L32:
        int r4 = r6.justifyContent;
        if (r4 == (-1)) goto L35;
        r0.setJustifyContent(YogaJustify.fromInt(r4));
    L36:
        int r5 = r6.alignContent;
        if (r5 == (-1)) goto L39;
        r0.setAlignContent(YogaAlign.fromInt(r5));
    L40:
        int r7 = r6.alignItems;
        if (r7 == (-1)) goto L43;
        r0.setAlignItems(YogaAlign.fromInt(r7));
    L44:
        int r8 = r6.alignSelf;
        if (r8 == (-1)) goto L47;
        r0.setAlignSelf(YogaAlign.fromInt(r8));
    L48:
        int r9 = r6.display;
        if (r9 == (-1)) goto L51;
        r0.setDisplay(YogaDisplay.fromInt(r9));
    L53:
        if (YogaConstants.isUndefined(r6.maxWidth) == true) goto L56;
        r0.setMaxWidth(r6.maxWidth);
    L59:
        if (YogaConstants.isUndefined(r6.minWidth) == true) goto L62;
        r0.setMinWidth(r6.minWidth);
    L65:
        if (YogaConstants.isUndefined(r6.width) == true) goto L68;
        r0.setWidth(r6.width);
    L72:
        if (YogaConstants.isUndefined(r6.maxHeight) == true) goto L75;
        r0.setMaxHeight(r6.maxHeight);
    L78:
        if (YogaConstants.isUndefined(r6.minHeight) == true) goto L81;
        r0.setMinHeight(r6.minHeight);
    L84:
        if (YogaConstants.isUndefined(r6.height) == true) goto L87;
        r0.setHeight(r6.height);
    L91:
        if (YogaConstants.isUndefined(r6.marginTop) == true) goto L94;
        r0.setMargin(YogaEdge.TOP, r6.marginTop);
    L97:
        if (YogaConstants.isUndefined(r6.marginRight) == true) goto L100;
        r0.setMargin(YogaEdge.RIGHT, r6.marginRight);
    L103:
        if (YogaConstants.isUndefined(r6.marginBottom) == true) goto L106;
        r0.setMargin(YogaEdge.BOTTOM, r6.marginBottom);
    L109:
        if (YogaConstants.isUndefined(r6.marginLeft) == true) goto L112;
        r0.setMargin(YogaEdge.LEFT, r6.marginLeft);
    L114:
        YogaEdge r10 = YogaEdge.TOP;
        r0.setPadding(r10, r6.paddingTop);
        YogaEdge r11 = YogaEdge.RIGHT;
        r0.setPadding(r11, r6.paddingRight);
        YogaEdge r12 = YogaEdge.BOTTOM;
        r0.setPadding(r12, r6.paddingBottom);
        YogaEdge r13 = YogaEdge.LEFT;
        r0.setPadding(r13, r6.paddingLeft);
        if (YogaConstants.isUndefined(r6.left) == true) goto L118;
        r0.setPosition(r13, r6.left);
    L118:
        if (YogaConstants.isUndefined(r6.right) == true) goto L121;
        r0.setPosition(r11, r6.right);
    L121:
        if (YogaConstants.isUndefined(r6.top) == true) goto L124;
        r0.setPosition(r10, r6.top);
    L124:
        if (YogaConstants.isUndefined(r6.bottom) == true) goto L126;
        r0.setPosition(r12, r6.bottom);
    L126:
        return r0;
    L112:
        if (YogaConstants.isUndefined(r6.marginLeftPercent) == true) goto L114;
        r0.setMarginPercent(YogaEdge.LEFT, r6.marginLeftPercent);
        goto L114
    L106:
        if (YogaConstants.isUndefined(r6.marginBottomPercent) == true) goto L109;
        r0.setMarginPercent(YogaEdge.BOTTOM, r6.marginBottomPercent);
        goto L109
    L100:
        if (YogaConstants.isUndefined(r6.marginRightPercent) == true) goto L103;
        r0.setMarginPercent(YogaEdge.RIGHT, r6.marginRightPercent);
        goto L103
    L94:
        if (YogaConstants.isUndefined(r6.marginTopPercent) == true) goto L97;
        r0.setMarginPercent(YogaEdge.TOP, r6.marginTopPercent);
        goto L97
    L87:
        if (YogaConstants.isUndefined(r6.heightPercent) == true) goto L89;
        r0.setHeightPercent(r6.heightPercent);
        goto L91
    L89:
        r0.setHeightAuto();
        goto L91
    L81:
        if (YogaConstants.isUndefined(r6.minHeightPercent) == true) goto L84;
        r0.setMinHeightPercent(r6.minHeightPercent);
        goto L84
    L75:
        if (YogaConstants.isUndefined(r6.maxHeightPercent) == true) goto L78;
        r0.setMaxHeightPercent(r6.maxHeightPercent);
        goto L78
    L68:
        if (YogaConstants.isUndefined(r6.widthPercent) == true) goto L70;
        r0.setWidthPercent(r6.widthPercent);
        goto L72
    L70:
        r0.setWidthAuto();
        goto L72
    L62:
        if (YogaConstants.isUndefined(r6.minWidthPercent) == true) goto L65;
        r0.setMinWidthPercent(r6.minWidthPercent);
        goto L65
    L56:
        if (YogaConstants.isUndefined(r6.maxWidthPercent) == true) goto L59;
        r0.setMaxWidthPercent(r6.maxWidthPercent);
        goto L59
    L51:
        r0.setDisplay(YogaDisplay.FLEX);
        goto L53
    L47:
        r0.setAlignSelf(YogaAlign.AUTO);
        goto L48
    L43:
        r0.setAlignItems(YogaAlign.STRETCH);
        goto L44
    L39:
        r0.setAlignContent(YogaAlign.AUTO);
        goto L40
    L35:
        r0.setJustifyContent(YogaJustify.FLEX_START);
        goto L36
    L31:
        r0.setFlexShrink(1.0f);
        goto L32
    L27:
        r0.setFlexGrow(0.0f);
        goto L29
    L23:
        r0.setFlexBasisAuto();
        goto L25
    L19:
        r0.setWrap(YogaWrap.WRAP);
        goto L21
    L15:
        r0.setFlexDirection(YogaFlexDirection.ROW);
        goto L16
    L8:
        r0.setPositionType(YogaPositionType.RELATIVE);
        goto L10
    }
}
