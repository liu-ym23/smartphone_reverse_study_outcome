package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AbsInlineImageShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    public AbsInlineImageShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r10, String r11, x0 r12) {
        AbsInlineImageShadowNode r0 = (AbsInlineImageShadowNode) r10;
        r11.getClass();
        switch(r11.hashCode()) {
            case -1820411228: goto L94;
            case -1559879186: goto L90;
            case -1032412580: goto L86;
            case -585734562: goto L82;
            case -570796884: goto L78;
            case -567450431: goto L74;
            case 114148: goto L70;
            case 3357091: goto L66;
            case 143851658: goto L62;
            case 158789336: goto L58;
            case 162135789: goto L54;
            case 307025104: goto L50;
            case 310371557: goto L46;
            case 419144785: goto L42;
            case 434082463: goto L38;
            case 437428916: goto L34;
            case 605322756: goto L30;
            case 609634231: goto L26;
            case 881039699: goto L22;
            case 956705090: goto L18;
            case 971642768: goto L14;
            case 974989221: goto L10;
            case 1466337535: goto L6;
            default: goto L97;
        };
    L97:
        byte r1 = -1;
    L98:
        Integer r8 = null;
        switch(r1) {
            case 0: goto L162;
            case 1: goto L160;
            case 2: goto L158;
            case 3: goto L153;
            case 4: goto L150;
            case 5: goto L148;
            case 6: goto L146;
            case 7: goto L144;
            case 8: goto L139;
            case 9: goto L136;
            case 10: goto L134;
            case 11: goto L132;
            case 12: goto L130;
            case 13: goto L125;
            case 14: goto L122;
            case 15: goto L120;
            case 16: goto L118;
            case 17: goto L116;
            case 18: goto L114;
            case 19: goto L109;
            case 20: goto L106;
            case 21: goto L104;
            case 22: goto L102;
            default: goto L100;
        };
    L100:
        super.a(r10, r11, r12);
        return;
    L102:
        r0.setBorderRadius(1, r12.a(r11));
        return;
    L104:
        r0.setBorderWidth(4, r12.f(r11, 0));
        return;
    L106:
        r0.setBorderStyle(4, r12.f(r11, -1));
        return;
    L114:
        r0.setBorderRadius(0, r12.a(r11));
        return;
    L116:
        r0.setBorderRadius(4, r12.a(r11));
        return;
    L118:
        r0.setBackgroundColor(r12.f(r11, 0));
        return;
    L120:
        r0.setBorderWidth(2, r12.f(r11, 0));
        return;
    L122:
        r0.setBorderStyle(2, r12.f(r11, -1));
        return;
    L130:
        r0.setBorderWidth(0, r12.f(r11, 0));
        return;
    L132:
        r0.setBorderStyle(0, r12.f(r11, -1));
        return;
    L134:
        r0.setBorderWidth(3, r12.f(r11, 0));
        return;
    L136:
        r0.setBorderStyle(3, r12.f(r11, -1));
        return;
    L144:
        r0.setMode(r12.h(r11));
        return;
    L146:
        r0.setSource(r12.h(r11));
        return;
    L148:
        r0.setBorderWidth(1, r12.f(r11, 0));
        return;
    L150:
        r0.setBorderStyle(1, r12.f(r11, -1));
        return;
    L158:
        r0.setBorderRadius(2, r12.a(r11));
        return;
    L160:
        r0.setVerticalAlign(r12.a(r11));
        return;
    L162:
        r0.setBorderRadius(3, r12.a(r11));
        return;
    L109:
        if (r12.k(r11) == true) goto L112;
        r8 = Integer.valueOf(r12.f(r11, 0));
    L112:
        r0.setBorderColor(3, r8);
        return;
    L125:
        if (r12.k(r11) == true) goto L128;
        r8 = Integer.valueOf(r12.f(r11, 0));
    L128:
        r0.setBorderColor(1, r8);
        return;
    L139:
        if (r12.k(r11) == true) goto L142;
        r8 = Integer.valueOf(r12.f(r11, 0));
    L142:
        r0.setBorderColor(2, r8);
        return;
    L153:
        if (r12.k(r11) == true) goto L156;
        r8 = Integer.valueOf(r12.f(r11, 0));
    L156:
        r0.setBorderColor(0, r8);
        return;
    L6:
        if (r11.equals("border-top-left-radius") == false) goto L97;
        r1 = 22;
        goto L98
    L10:
        if (r11.equals("border-bottom-width") == false) goto L97;
        r1 = 21;
        goto L98
    L14:
        if (r11.equals("border-bottom-style") == false) goto L97;
        r1 = 20;
        goto L98
    L18:
        if (r11.equals("border-bottom-color") == false) goto L97;
        r1 = 19;
        goto L98
    L22:
        if (r11.equals("border-radius") == false) goto L97;
        r1 = 18;
        goto L98
    L26:
        if (r11.equals("border-bottom-left-radius") == false) goto L97;
        r1 = 17;
        goto L98
    L30:
        if (r11.equals("background-color") == false) goto L97;
        r1 = 16;
        goto L98
    L34:
        if (r11.equals("border-right-width") == false) goto L97;
        r1 = 15;
        goto L98
    L38:
        if (r11.equals("border-right-style") == false) goto L97;
        r1 = 14;
        goto L98
    L42:
        if (r11.equals("border-right-color") == false) goto L97;
        r1 = 13;
        goto L98
    L46:
        if (r11.equals("border-width") == false) goto L97;
        r1 = 12;
        goto L98
    L50:
        if (r11.equals("border-style") == false) goto L97;
        r1 = 11;
        goto L98
    L54:
        if (r11.equals("border-top-width") == false) goto L97;
        r1 = 10;
        goto L98
    L58:
        if (r11.equals("border-top-style") == false) goto L97;
        r1 = 9;
        goto L98
    L62:
        if (r11.equals("border-top-color") == false) goto L97;
        r1 = 8;
        goto L98
    L66:
        if (r11.equals("mode") == false) goto L97;
        r1 = 7;
        goto L98
    L70:
        if (r11.equals(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L97;
        r1 = 6;
        goto L98
    L74:
        if (r11.equals("border-left-width") == false) goto L97;
        r1 = 5;
        goto L98
    L78:
        if (r11.equals("border-left-style") == false) goto L97;
        r1 = 4;
        goto L98
    L82:
        if (r11.equals("border-left-color") == false) goto L97;
        r1 = 3;
        goto L98
    L86:
        if (r11.equals("border-top-right-radius") == false) goto L97;
        r1 = 2;
        goto L98
    L90:
        if (r11.equals("vertical-align") == false) goto L97;
        r1 = 1;
        goto L98
    L94:
        if (r11.equals("border-bottom-right-radius") == false) goto L97;
        r1 = 0;
        goto L98
    }
}
