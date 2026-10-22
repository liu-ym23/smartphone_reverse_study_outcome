package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class InlineTextShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    public InlineTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r9, String r10, x0 r11) {
        InlineTextShadowNode r0 = (InlineTextShadowNode) r9;
        r10.getClass();
        byte r7 = -1;
        switch(r10.hashCode()) {
            case -1820411228: goto L46;
            case -1559879186: goto L42;
            case -1032412580: goto L38;
            case -20727064: goto L34;
            case 605322756: goto L30;
            case 609634231: goto L26;
            case 610793468: goto L22;
            case 881039699: goto L18;
            case 1266923840: goto L14;
            case 1466337535: goto L10;
            case 2005447450: goto L6;
            default: goto L49;
        };
    L49:
        switch(r7) {
            case 0: goto L72;
            case 1: goto L70;
            case 2: goto L68;
            case 3: goto L66;
            case 4: goto L64;
            case 5: goto L62;
            case 6: goto L60;
            case 7: goto L58;
            case 8: goto L56;
            case 9: goto L54;
            case 10: goto L52;
            default: goto L50;
        };
    L50:
        super.a(r9, r10, r11);
        return;
    L52:
        r0.setBackgroundRepeat(r11.a(r10));
        return;
    L54:
        r0.setBorderRadius(1, r11.a(r10));
        return;
    L56:
        r0.setBackgroundSize(r11.a(r10));
        return;
    L58:
        r0.setBorderRadius(0, r11.a(r10));
        return;
    L60:
        r0.setBackgroundImage(r11.a(r10));
        return;
    L62:
        r0.setBorderRadius(4, r11.a(r10));
        return;
    L64:
        r0.setBackgroundColor(r11.f(r10, 0));
        return;
    L66:
        r0.setBackgroundPosition(r11.a(r10));
        return;
    L68:
        r0.setBorderRadius(2, r11.a(r10));
        return;
    L70:
        r0.setVerticalAlign(r11.a(r10));
        return;
    L72:
        r0.setBorderRadius(3, r11.a(r10));
        return;
    L6:
        if (r10.equals("background-repeat") == false) goto L49;
        r7 = 10;
        goto L49
    L10:
        if (r10.equals("border-top-left-radius") == false) goto L49;
        r7 = 9;
        goto L49
    L14:
        if (r10.equals("background-size") == false) goto L49;
        r7 = 8;
        goto L49
    L18:
        if (r10.equals("border-radius") == false) goto L49;
        r7 = 7;
        goto L49
    L22:
        if (r10.equals("background-image") == false) goto L49;
        r7 = 6;
        goto L49
    L26:
        if (r10.equals("border-bottom-left-radius") == false) goto L49;
        r7 = 5;
        goto L49
    L30:
        if (r10.equals("background-color") == false) goto L49;
        r7 = 4;
        goto L49
    L34:
        if (r10.equals("background-position") == false) goto L49;
        r7 = 3;
        goto L49
    L38:
        if (r10.equals("border-top-right-radius") == false) goto L49;
        r7 = 2;
        goto L49
    L42:
        if (r10.equals("vertical-align") == false) goto L49;
        r7 = 1;
        goto L49
    L46:
        if (r10.equals("border-bottom-right-radius") == false) goto L49;
        r7 = 0;
        goto L49
    }
}
