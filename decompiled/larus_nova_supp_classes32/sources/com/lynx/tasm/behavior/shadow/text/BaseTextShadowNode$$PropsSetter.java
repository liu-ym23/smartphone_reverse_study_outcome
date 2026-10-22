package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class BaseTextShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public BaseTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r7, String r8, x0 r9) {
        BaseTextShadowNode r0 = (BaseTextShadowNode) r7;
        r8.getClass();
        switch(r8.hashCode()) {
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
        byte r1 = -1;
    L135:
        switch(r1) {
            case 0: goto L200;
            case 1: goto L198;
            case 2: goto L196;
            case 3: goto L194;
            case 4: goto L192;
            case 5: goto L190;
            case 6: goto L188;
            case 7: goto L186;
            case 8: goto L184;
            case 9: goto L182;
            case 10: goto L180;
            case 11: goto L178;
            case 12: goto L176;
            case 13: goto L174;
            case 14: goto L172;
            case 15: goto L170;
            case 16: goto L168;
            case 17: goto L166;
            case 18: goto L164;
            case 19: goto L162;
            case 20: goto L160;
            case 21: goto L158;
            case 22: goto L156;
            case 23: goto L154;
            case 24: goto L152;
            case 25: goto L150;
            case 26: goto L148;
            case 27: goto L146;
            case 28: goto L144;
            case 29: goto L142;
            case 30: goto L140;
            case 31: goto L138;
            default: goto L136;
        };
    L136:
        super.a(r7, r8, r9);
        return;
    L138:
        r0.setTextMaxLength(r9.h(r8));
        return;
    L140:
        r0.setTextIndent(r9.a(r8));
        return;
    L142:
        r0.setTextMaxLine(r9.h(r8));
        return;
    L144:
        r0.setFontFeatureSettings(r9.f(r8, 0));
        return;
    L146:
        r0.setTextVerticalAlign(r9.h(r8));
        return;
    L148:
        r0.setTextAlign(r9.f(r8, 3));
        return;
    L150:
        r0.setFontWeight(r9.f(r8, 0));
        return;
    L152:
        r0.setTextDecoration(r9.a(r8));
        return;
    L154:
        r0.setWordBreakStrategy(r9.f(r8, 0));
        return;
    L156:
        r0.setUseWebLineHeight(r9.b(r8, false));
        return;
    L158:
        r0.setFontFamily(r9.h(r8));
        return;
    L160:
        r0.setColor(r9.d(r8));
        return;
    L162:
        r0.setText(r9.d(r8));
        return;
    L164:
        r0.setEnableEmojiCompat(r9.b(r8, false));
        return;
    L166:
        r0.setEnableFontScaling(r9.h(r8));
        return;
    L168:
        r0.setTextOverflow(r9.f(r8, 0));
        return;
    L170:
        r0.setDirection(r9.f(r8, 0));
        return;
    L172:
        r0.setEnableBitmapGradient(r9.b(r8, false));
        return;
    L174:
        r0.setBaselineShift(r9.h(r8));
        return;
    L176:
        r0.setLineHeight(r9.e(r8, 1.0E21f));
        return;
    L178:
        r0.setTextFakeBold(r9.b(r8, false));
        return;
    L180:
        r0.setFontFeatureSettings(r9.a(r8));
        return;
    L182:
        r0.setFontSize(r9.e(r8, 1.0E21f));
        return;
    L184:
        r0.setFontVariationSettings(r9.a(r8));
        return;
    L186:
        r0.setLineSpacing(r9.e(r8, 0.0f));
        return;
    L188:
        r0.setFontStyle(r9.f(r8, 0));
        return;
    L190:
        r0.setTextStrokeWidth(r9.e(r8, 0.0f));
        return;
    L192:
        r0.setTextStrokeColor(r9.d(r8));
        return;
    L194:
        r0.setLetterSpacing(r9.e(r8, 1.0E21f));
        return;
    L196:
        r0.setWhiteSpace(r9.f(r8, 0));
        return;
    L198:
        r0.setTextShadow(r9.a(r8));
        return;
    L200:
        r0.setIncludeFontPadding(r9.b(r8, false));
        return;
    L6:
        if (r8.equals("text-maxlength") == false) goto L133;
        r1 = 31;
        goto L135
    L10:
        if (r8.equals("text-indent") == false) goto L133;
        r1 = 30;
        goto L135
    L14:
        if (r8.equals("text-maxline") == false) goto L133;
        r1 = 29;
        goto L135
    L18:
        if (r8.equals("font-optical-sizing") == false) goto L133;
        r1 = 28;
        goto L135
    L22:
        if (r8.equals("text-vertical-align") == false) goto L133;
        r1 = 27;
        goto L135
    L26:
        if (r8.equals("text-align") == false) goto L133;
        r1 = 26;
        goto L135
    L30:
        if (r8.equals("font-weight") == false) goto L133;
        r1 = 25;
        goto L135
    L34:
        if (r8.equals("text-decoration") == false) goto L133;
        r1 = 24;
        goto L135
    L38:
        if (r8.equals("word-break") == false) goto L133;
        r1 = 23;
        goto L135
    L42:
        if (r8.equals("use-web-line-height") == false) goto L133;
        r1 = 22;
        goto L135
    L46:
        if (r8.equals("font-family") == false) goto L133;
        r1 = 21;
        goto L135
    L50:
        if (r8.equals("color") == false) goto L133;
        r1 = 20;
        goto L135
    L54:
        if (r8.equals("text") == false) goto L133;
        r1 = 19;
        goto L135
    L58:
        if (r8.equals("android-emoji-compat") == false) goto L133;
        r1 = 18;
        goto L135
    L62:
        if (r8.equals("enable-font-scaling") == false) goto L133;
        r1 = 17;
        goto L135
    L66:
        if (r8.equals("text-overflow") == false) goto L133;
        r1 = 16;
        goto L135
    L70:
        if (r8.equals("direction") == false) goto L133;
        r1 = 15;
        goto L135
    L74:
        if (r8.equals("bitmap-gradient") == false) goto L133;
        r1 = 14;
        goto L135
    L78:
        if (r8.equals("custom-baseline-shift") == false) goto L133;
        r1 = 13;
        goto L135
    L82:
        if (r8.equals("line-height") == false) goto L133;
        r1 = 12;
        goto L135
    L86:
        if (r8.equals("text-fake-bold") == false) goto L133;
        r1 = 11;
        goto L135
    L90:
        if (r8.equals("font-feature-settings") == false) goto L133;
        r1 = 10;
        goto L135
    L94:
        if (r8.equals("font-size") == false) goto L133;
        r1 = 9;
        goto L135
    L98:
        if (r8.equals("font-variation-settings") == false) goto L133;
        r1 = 8;
        goto L135
    L102:
        if (r8.equals("line-spacing") == false) goto L133;
        r1 = 7;
        goto L135
    L106:
        if (r8.equals("font-style") == false) goto L133;
        r1 = 6;
        goto L135
    L110:
        if (r8.equals("text-stroke-width") == false) goto L133;
        r1 = 5;
        goto L135
    L114:
        if (r8.equals("text-stroke-color") == false) goto L133;
        r1 = 4;
        goto L135
    L118:
        if (r8.equals("letter-spacing") == false) goto L133;
        r1 = 3;
        goto L135
    L122:
        if (r8.equals("white-space") == false) goto L133;
        r1 = 2;
        goto L135
    L126:
        if (r8.equals("text-shadow") == false) goto L133;
        r1 = 1;
        goto L135
    L130:
        if (r8.equals("include-font-padding") == false) goto L133;
        r1 = 0;
        goto L135
    }
}
