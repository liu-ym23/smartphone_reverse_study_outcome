package com.lynx.tasm.behavior.shadow.text;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class AbsInlineImageShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    public AbsInlineImageShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void b(ShadowNode r11, String r12, y0 r13) {
        AbsInlineImageShadowNode r5 = (AbsInlineImageShadowNode) r11;
        r12.getClass();
        ReadableMap r10 = r13.f10815a;
        Integer r14 = null;
        switch(r12.hashCode()) {
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
            default: goto L4;
        };
    L4:
        byte r15 = -1;
    L97:
        switch(r15) {
            case 0: goto L160;
            case 1: goto L158;
            case 2: goto L156;
            case 3: goto L151;
            case 4: goto L148;
            case 5: goto L146;
            case 6: goto L144;
            case 7: goto L142;
            case 8: goto L137;
            case 9: goto L134;
            case 10: goto L132;
            case 11: goto L130;
            case 12: goto L128;
            case 13: goto L123;
            case 14: goto L120;
            case 15: goto L118;
            case 16: goto L116;
            case 17: goto L114;
            case 18: goto L112;
            case 19: goto L107;
            case 20: goto L104;
            case 21: goto L102;
            case 22: goto L100;
            default: goto L98;
        };
    L98:
        super.b(r11, r12, r13);
        return;
    L100:
        r5.setBorderRadius(1, r10.getArray(r12));
        return;
    L102:
        r5.setBorderWidth(4, r13.c(r12, 0));
        return;
    L104:
        r5.setBorderStyle(4, r13.c(r12, -1));
        return;
    L112:
        r5.setBorderRadius(0, r10.getArray(r12));
        return;
    L114:
        r5.setBorderRadius(4, r10.getArray(r12));
        return;
    L116:
        r5.setBackgroundColor(r13.c(r12, 0));
        return;
    L118:
        r5.setBorderWidth(2, r13.c(r12, 0));
        return;
    L120:
        r5.setBorderStyle(2, r13.c(r12, -1));
        return;
    L128:
        r5.setBorderWidth(0, r13.c(r12, 0));
        return;
    L130:
        r5.setBorderStyle(0, r13.c(r12, -1));
        return;
    L132:
        r5.setBorderWidth(3, r13.c(r12, 0));
        return;
    L134:
        r5.setBorderStyle(3, r13.c(r12, -1));
        return;
    L142:
        r5.setMode(r10.getString(r12));
        return;
    L144:
        r5.setSource(r10.getString(r12));
        return;
    L146:
        r5.setBorderWidth(1, r13.c(r12, 0));
        return;
    L148:
        r5.setBorderStyle(1, r13.c(r12, -1));
        return;
    L156:
        r5.setBorderRadius(2, r10.getArray(r12));
        return;
    L158:
        r5.setVerticalAlign(r10.getArray(r12));
        return;
    L160:
        r5.setBorderRadius(3, r10.getArray(r12));
        return;
    L107:
        if (r10.isNull(r12) == true) goto L110;
        r14 = Integer.valueOf(r13.c(r12, 0));
    L110:
        r5.setBorderColor(3, r14);
        return;
    L123:
        if (r10.isNull(r12) == true) goto L126;
        r14 = Integer.valueOf(r13.c(r12, 0));
    L126:
        r5.setBorderColor(1, r14);
        return;
    L137:
        if (r10.isNull(r12) == true) goto L140;
        r14 = Integer.valueOf(r13.c(r12, 0));
    L140:
        r5.setBorderColor(2, r14);
        return;
    L151:
        if (r10.isNull(r12) == true) goto L154;
        r14 = Integer.valueOf(r13.c(r12, 0));
    L154:
        r5.setBorderColor(0, r14);
        return;
    L6:
        if (r12.equals("border-top-left-radius") == false) goto L162;
        r15 = 22;
        goto L97
    L162:
        r15 = -1;
        goto L97
    L10:
        if (r12.equals("border-bottom-width") == false) goto L163;
        r15 = 21;
        goto L97
    L163:
        r15 = -1;
        goto L97
    L14:
        if (r12.equals("border-bottom-style") == false) goto L164;
        r15 = 20;
        goto L97
    L164:
        r15 = -1;
        goto L97
    L18:
        if (r12.equals("border-bottom-color") == false) goto L165;
        r15 = 19;
        goto L97
    L165:
        r15 = -1;
        goto L97
    L22:
        if (r12.equals("border-radius") == false) goto L166;
        r15 = 18;
        goto L97
    L166:
        r15 = -1;
        goto L97
    L26:
        if (r12.equals("border-bottom-left-radius") == false) goto L167;
        r15 = 17;
        goto L97
    L167:
        r15 = -1;
        goto L97
    L30:
        if (r12.equals("background-color") == false) goto L168;
        r15 = 16;
        goto L97
    L168:
        r15 = -1;
        goto L97
    L34:
        if (r12.equals("border-right-width") == false) goto L169;
        r15 = 15;
        goto L97
    L169:
        r15 = -1;
        goto L97
    L38:
        if (r12.equals("border-right-style") == false) goto L170;
        r15 = 14;
        goto L97
    L170:
        r15 = -1;
        goto L97
    L42:
        if (r12.equals("border-right-color") == false) goto L171;
        r15 = 13;
        goto L97
    L171:
        r15 = -1;
        goto L97
    L46:
        if (r12.equals("border-width") == false) goto L172;
        r15 = 12;
        goto L97
    L172:
        r15 = -1;
        goto L97
    L50:
        if (r12.equals("border-style") == false) goto L173;
        r15 = 11;
        goto L97
    L173:
        r15 = -1;
        goto L97
    L54:
        if (r12.equals("border-top-width") == false) goto L174;
        r15 = 10;
        goto L97
    L174:
        r15 = -1;
        goto L97
    L58:
        if (r12.equals("border-top-style") == false) goto L175;
        r15 = 9;
        goto L97
    L175:
        r15 = -1;
        goto L97
    L62:
        if (r12.equals("border-top-color") == false) goto L176;
        r15 = 8;
        goto L97
    L176:
        r15 = -1;
        goto L97
    L66:
        if (r12.equals("mode") == false) goto L177;
        r15 = 7;
        goto L97
    L177:
        r15 = -1;
        goto L97
    L70:
        if (r12.equals("src") == false) goto L178;
        r15 = 6;
        goto L97
    L178:
        r15 = -1;
        goto L97
    L74:
        if (r12.equals("border-left-width") == false) goto L179;
        r15 = 5;
        goto L97
    L179:
        r15 = -1;
        goto L97
    L78:
        if (r12.equals("border-left-style") == false) goto L180;
        r15 = 4;
        goto L97
    L180:
        r15 = -1;
        goto L97
    L82:
        if (r12.equals("border-left-color") == false) goto L181;
        r15 = 3;
        goto L97
    L181:
        r15 = -1;
        goto L97
    L86:
        if (r12.equals("border-top-right-radius") == false) goto L182;
        r15 = 2;
        goto L97
    L182:
        r15 = -1;
        goto L97
    L90:
        if (r12.equals("vertical-align") == false) goto L183;
        r15 = 1;
        goto L97
    L183:
        r15 = -1;
        goto L97
    L94:
        if (r12.equals("border-bottom-right-radius") == false) goto L184;
        r15 = 0;
        goto L97
    L184:
        r15 = -1;
        goto L97
    }
}
