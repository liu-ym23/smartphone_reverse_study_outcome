package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class TextShadowNode$$PropsSetter extends BaseTextShadowNode$$PropsSetter {
    public TextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r5, String r6, x0 r7) {
        TextShadowNode r0 = (TextShadowNode) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1801128308: goto L34;
            case -1215680224: goto L30;
            case -356469693: goto L26;
            case 679001436: goto L22;
            case 1381862785: goto L18;
            case 1713623170: goto L14;
            case 2010704238: goto L10;
            case 2050754629: goto L6;
            default: goto L37;
        };
    L37:
        switch(r3) {
            case 0: goto L54;
            case 1: goto L52;
            case 2: goto L50;
            case 3: goto L48;
            case 4: goto L46;
            case 5: goto L44;
            case 6: goto L42;
            case 7: goto L40;
            default: goto L38;
        };
    L38:
        super.a(r5, r6, r7);
        return;
    L40:
        r0.setAutoFontSizeLineRanges(r7.a(r6));
        return;
    L42:
        r0.setAutoFontSizePresetSizes(r7.a(r6));
        return;
    L44:
        r0.setVerticalTextAlign(r7.h(r6));
        return;
    L46:
        r0.setHyphen(r7.f(r6, 0));
        return;
    L48:
        r0.setEnableFullJustify(r7.b(r6, false));
        return;
    L50:
        r0.setAutoFontSize(r7.a(r6));
        return;
    L52:
        r0.setLineHeight(r7.e(r6, 1.0E21f));
        return;
    L54:
        r0.setEnableTailColorConvert(r7.b(r6, false));
        return;
    L6:
        if (r6.equals("-x-auto-font-size-line-ranges") == false) goto L37;
        r3 = 7;
        goto L37
    L10:
        if (r6.equals("-x-auto-font-size-preset-sizes") == false) goto L37;
        r3 = 6;
        goto L37
    L14:
        if (r6.equals("text-single-line-vertical-align") == false) goto L37;
        r3 = 5;
        goto L37
    L18:
        if (r6.equals("hyphens") == false) goto L37;
        r3 = 4;
        goto L37
    L22:
        if (r6.equals("enable-full-justify") == false) goto L37;
        r3 = 3;
        goto L37
    L26:
        if (r6.equals("-x-auto-font-size") == false) goto L37;
        r3 = 2;
        goto L37
    L30:
        if (r6.equals("line-height") == false) goto L37;
        r3 = 1;
        goto L37
    L34:
        if (r6.equals("tail-color-convert") == false) goto L37;
        r3 = 0;
        goto L37
    }
}
