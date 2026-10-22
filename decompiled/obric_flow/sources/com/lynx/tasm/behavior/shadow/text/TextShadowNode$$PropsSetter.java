package com.lynx.tasm.behavior.shadow.text;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class TextShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    public TextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void b(ShadowNode r10, String r11, y0 r12) {
        TextShadowNode r5 = (TextShadowNode) r10;
        r11.getClass();
        ReadableMap r13 = r12.f10815a;
        byte r14 = -1;
        switch(r11.hashCode()) {
            case -1801128308: goto L30;
            case -1215680224: goto L26;
            case -356469693: goto L22;
            case 679001436: goto L18;
            case 1381862785: goto L14;
            case 1713623170: goto L10;
            case 2010704238: goto L6;
            default: goto L33;
        };
    L33:
        switch(r14) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            default: goto L34;
        };
    L34:
        super.b(r10, r11, r12);
        return;
    L36:
        r5.setAutoFontSizePresetSizes(r13.getArray(r11));
        return;
    L38:
        r5.setVerticalTextAlign(r13.getString(r11));
        return;
    L40:
        r5.setHyphen(r12.c(r11, 0));
        return;
    L42:
        r5.setEnableFullJustify(r12.e(r11, false));
        return;
    L44:
        r5.setAutoFontSize(r13.getArray(r11));
        return;
    L46:
        r5.setLineHeight(r12.b(1.0E21f, r11));
        return;
    L48:
        r5.setEnableTailColorConvert(r12.e(r11, false));
        return;
    L6:
        if (r11.equals("-x-auto-font-size-preset-sizes") == false) goto L33;
        r14 = 6;
        goto L33
    L10:
        if (r11.equals("text-single-line-vertical-align") == false) goto L33;
        r14 = 5;
        goto L33
    L14:
        if (r11.equals("hyphens") == false) goto L33;
        r14 = 4;
        goto L33
    L18:
        if (r11.equals("enable-full-justify") == false) goto L33;
        r14 = 3;
        goto L33
    L22:
        if (r11.equals("-x-auto-font-size") == false) goto L33;
        r14 = 2;
        goto L33
    L26:
        if (r11.equals("line-height") == false) goto L33;
        r14 = 1;
        goto L33
    L30:
        if (r11.equals("tail-color-convert") == false) goto L33;
        r14 = 0;
        goto L33
    }
}
