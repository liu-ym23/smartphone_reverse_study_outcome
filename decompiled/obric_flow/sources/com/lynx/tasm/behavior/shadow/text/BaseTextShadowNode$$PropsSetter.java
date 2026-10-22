package com.lynx.tasm.behavior.shadow.text;

import com.bytedance.ai.event.MessageIndication;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class BaseTextShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public BaseTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void b(ShadowNode r10, String r11, y0 r12) {
        BaseTextShadowNode r5 = (BaseTextShadowNode) r10;
        r11.getClass();
        ReadableMap r13 = r12.f10815a;
        byte r14 = -1;
        switch(r11.hashCode()) {
            case -2137322088: goto L130;
            case -2125209152: goto L126;
            case -2006495646: goto L122;
            case -1988401764: goto L118;
            case -1961254866: goto L114;
            case -1942970735: goto L110;
            case -1923578189: goto L106;
            case -1846328470: goto L102;
            case -1613296421: goto L98;
            case -1586082113: goto L94;
            case -1477575976: goto L90;
            case -1328339619: goto L86;
            case -1215680224: goto L82;
            case -1080127274: goto L78;
            case -1004442098: goto L74;
            case -962590849: goto L70;
            case -930515806: goto L66;
            case -231573485: goto L62;
            case -20349561: goto L58;
            case 3556653: goto L54;
            case 94842723: goto L50;
            case 108532386: goto L46;
            case 125536225: goto L42;
            case 375997564: goto L38;
            case 431477072: goto L34;
            case 598800822: goto L30;
            case 746232421: goto L26;
            case 856877710: goto L22;
            case 1050625329: goto L18;
            case 1629007544: goto L14;
            case 1889098060: goto L10;
            case 2104465578: goto L6;
            default: goto L133;
        };
    L133:
        switch(r14) {
            case 0: goto L198;
            case 1: goto L196;
            case 2: goto L194;
            case 3: goto L192;
            case 4: goto L190;
            case 5: goto L188;
            case 6: goto L186;
            case 7: goto L184;
            case 8: goto L182;
            case 9: goto L180;
            case 10: goto L178;
            case 11: goto L176;
            case 12: goto L174;
            case 13: goto L172;
            case 14: goto L170;
            case 15: goto L168;
            case 16: goto L166;
            case 17: goto L164;
            case 18: goto L162;
            case 19: goto L160;
            case 20: goto L158;
            case 21: goto L156;
            case 22: goto L154;
            case 23: goto L152;
            case 24: goto L150;
            case 25: goto L148;
            case 26: goto L146;
            case 27: goto L144;
            case 28: goto L142;
            case 29: goto L140;
            case 30: goto L138;
            case 31: goto L136;
            default: goto L134;
        };
    L134:
        super.b(r10, r11, r12);
        return;
    L136:
        r5.setTextMaxLength(r13.getString(r11));
        return;
    L138:
        r5.setTextIndent(r13.getArray(r11));
        return;
    L140:
        r5.setTextMaxLine(r13.getString(r11));
        return;
    L142:
        r5.setFontFeatureSettings(r12.c(r11, 0));
        return;
    L144:
        r5.setTextVerticalAlign(r13.getString(r11));
        return;
    L146:
        r5.setTextAlign(r12.c(r11, 3));
        return;
    L148:
        r5.setFontWeight(r12.c(r11, 0));
        return;
    L150:
        r5.setTextDecoration(r13.getArray(r11));
        return;
    L152:
        r5.setWordBreakStrategy(r12.c(r11, 0));
        return;
    L154:
        r5.setUseWebLineHeight(r12.e(r11, false));
        return;
    L156:
        r5.setFontFamily(r13.getString(r11));
        return;
    L158:
        r5.setColor(r13.getDynamic(r11));
        return;
    L160:
        r5.setText(r13.getDynamic(r11));
        return;
    L162:
        r5.setEnableEmojiCompat(r12.e(r11, false));
        return;
    L164:
        r5.setEnableFontScaling(r13.getString(r11));
        return;
    L166:
        r5.setTextOverflow(r12.c(r11, 0));
        return;
    L168:
        r5.setDirection(r12.c(r11, 0));
        return;
    L170:
        r5.setEnableBitmapGradient(r12.e(r11, false));
        return;
    L172:
        r5.setBaselineShift(r13.getString(r11));
        return;
    L174:
        r5.setLineHeight(r12.b(1.0E21f, r11));
        return;
    L176:
        r5.setTextFakeBold(r12.e(r11, false));
        return;
    L178:
        r5.setFontFeatureSettings(r13.getArray(r11));
        return;
    L180:
        r5.setFontSize(r12.b(1.0E21f, r11));
        return;
    L182:
        r5.setFontVariationSettings(r13.getArray(r11));
        return;
    L184:
        r5.setLineSpacing(r12.b(0.0f, r11));
        return;
    L186:
        r5.setFontStyle(r12.c(r11, 0));
        return;
    L188:
        r5.setTextStrokeWidth(r12.b(0.0f, r11));
        return;
    L190:
        r5.setTextStrokeColor(r13.getDynamic(r11));
        return;
    L192:
        r5.setLetterSpacing(r12.b(1.0E21f, r11));
        return;
    L194:
        r5.setWhiteSpace(r12.c(r11, 0));
        return;
    L196:
        r5.setTextShadow(r13.getArray(r11));
        return;
    L198:
        r5.setIncludeFontPadding(r12.e(r11, false));
        return;
    L6:
        if (r11.equals("text-maxlength") == false) goto L133;
        r14 = 31;
        goto L133
    L10:
        if (r11.equals("text-indent") == false) goto L133;
        r14 = 30;
        goto L133
    L14:
        if (r11.equals("text-maxline") == false) goto L133;
        r14 = 29;
        goto L133
    L18:
        if (r11.equals("font-optical-sizing") == false) goto L133;
        r14 = 28;
        goto L133
    L22:
        if (r11.equals("text-vertical-align") == false) goto L133;
        r14 = 27;
        goto L133
    L26:
        if (r11.equals("text-align") == false) goto L133;
        r14 = 26;
        goto L133
    L30:
        if (r11.equals("font-weight") == false) goto L133;
        r14 = 25;
        goto L133
    L34:
        if (r11.equals("text-decoration") == false) goto L133;
        r14 = 24;
        goto L133
    L38:
        if (r11.equals("word-break") == false) goto L133;
        r14 = 23;
        goto L133
    L42:
        if (r11.equals("use-web-line-height") == false) goto L133;
        r14 = 22;
        goto L133
    L46:
        if (r11.equals("font-family") == false) goto L133;
        r14 = 21;
        goto L133
    L50:
        if (r11.equals("color") == false) goto L133;
        r14 = 20;
        goto L133
    L54:
        if (r11.equals(MessageIndication.CONTENT_TYPE_TEXT) == false) goto L133;
        r14 = 19;
        goto L133
    L58:
        if (r11.equals("android-emoji-compat") == false) goto L133;
        r14 = 18;
        goto L133
    L62:
        if (r11.equals("enable-font-scaling") == false) goto L133;
        r14 = 17;
        goto L133
    L66:
        if (r11.equals("text-overflow") == false) goto L133;
        r14 = 16;
        goto L133
    L70:
        if (r11.equals("direction") == false) goto L133;
        r14 = 15;
        goto L133
    L74:
        if (r11.equals("bitmap-gradient") == false) goto L133;
        r14 = 14;
        goto L133
    L78:
        if (r11.equals("custom-baseline-shift") == false) goto L133;
        r14 = 13;
        goto L133
    L82:
        if (r11.equals("line-height") == false) goto L133;
        r14 = 12;
        goto L133
    L86:
        if (r11.equals("text-fake-bold") == false) goto L133;
        r14 = 11;
        goto L133
    L90:
        if (r11.equals("font-feature-settings") == false) goto L133;
        r14 = 10;
        goto L133
    L94:
        if (r11.equals("font-size") == false) goto L133;
        r14 = 9;
        goto L133
    L98:
        if (r11.equals("font-variation-settings") == false) goto L133;
        r14 = 8;
        goto L133
    L102:
        if (r11.equals("line-spacing") == false) goto L133;
        r14 = 7;
        goto L133
    L106:
        if (r11.equals("font-style") == false) goto L133;
        r14 = 6;
        goto L133
    L110:
        if (r11.equals("text-stroke-width") == false) goto L133;
        r14 = 5;
        goto L133
    L114:
        if (r11.equals("text-stroke-color") == false) goto L133;
        r14 = 4;
        goto L133
    L118:
        if (r11.equals("letter-spacing") == false) goto L133;
        r14 = 3;
        goto L133
    L122:
        if (r11.equals("white-space") == false) goto L133;
        r14 = 2;
        goto L133
    L126:
        if (r11.equals("text-shadow") == false) goto L133;
        r14 = 1;
        goto L133
    L130:
        if (r11.equals("include-font-padding") == false) goto L133;
        r14 = 0;
        goto L133
    }
}
