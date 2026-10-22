package com.lynx.tasm.behavior.shadow.text;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class InlineTextShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    public InlineTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void b(ShadowNode r10, String r11, y0 r12) {
        InlineTextShadowNode r5 = (InlineTextShadowNode) r10;
        r11.getClass();
        ReadableMap r13 = r12.f10815a;
        byte r14 = -1;
        switch(r11.hashCode()) {
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
        switch(r14) {
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
        super.b(r10, r11, r12);
        return;
    L52:
        r5.setBackgroundRepeat(r13.getArray(r11));
        return;
    L54:
        r5.setBorderRadius(1, r13.getArray(r11));
        return;
    L56:
        r5.setBackgroundSize(r13.getArray(r11));
        return;
    L58:
        r5.setBorderRadius(0, r13.getArray(r11));
        return;
    L60:
        r5.setBackgroundImage(r13.getArray(r11));
        return;
    L62:
        r5.setBorderRadius(4, r13.getArray(r11));
        return;
    L64:
        r5.setBackgroundColor(r12.c(r11, 0));
        return;
    L66:
        r5.setBackgroundPosition(r13.getArray(r11));
        return;
    L68:
        r5.setBorderRadius(2, r13.getArray(r11));
        return;
    L70:
        r5.setVerticalAlign(r13.getArray(r11));
        return;
    L72:
        r5.setBorderRadius(3, r13.getArray(r11));
        return;
    L6:
        if (r11.equals("background-repeat") == false) goto L49;
        r14 = 10;
        goto L49
    L10:
        if (r11.equals("border-top-left-radius") == false) goto L49;
        r14 = 9;
        goto L49
    L14:
        if (r11.equals("background-size") == false) goto L49;
        r14 = 8;
        goto L49
    L18:
        if (r11.equals("border-radius") == false) goto L49;
        r14 = 7;
        goto L49
    L22:
        if (r11.equals("background-image") == false) goto L49;
        r14 = 6;
        goto L49
    L26:
        if (r11.equals("border-bottom-left-radius") == false) goto L49;
        r14 = 5;
        goto L49
    L30:
        if (r11.equals("background-color") == false) goto L49;
        r14 = 4;
        goto L49
    L34:
        if (r11.equals("background-position") == false) goto L49;
        r14 = 3;
        goto L49
    L38:
        if (r11.equals("border-top-right-radius") == false) goto L49;
        r14 = 2;
        goto L49
    L42:
        if (r11.equals("vertical-align") == false) goto L49;
        r14 = 1;
        goto L49
    L46:
        if (r11.equals("border-bottom-right-radius") == false) goto L49;
        r14 = 0;
        goto L49
    }
}
