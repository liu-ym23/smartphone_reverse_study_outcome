package com.bytedance.ies.xelement.text.text;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxTextShadowNode$$PropsSetter extends TextShadowNode$$PropsSetter {
    public LynxTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void b(ShadowNode r5, String r10, y0 r11) {
        LynxTextShadowNode r12 = (LynxTextShadowNode) r5;
        r10.getClass();
        ReadableMap r13 = r11.f10815a;
        byte r14 = -1;
        switch(r10.hashCode()) {
            case -1550570986: goto L14;
            case 125841635: goto L10;
            case 1629007544: goto L6;
            default: goto L17;
        };
    L17:
        switch(r14) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            default: goto L18;
        };
    L18:
        super.b(r5, r10, r11);
        return;
    L20:
        r12.setTextMaxLine(r13.getString(r10));
        return;
    L22:
        r12.setEllipsizeMode(r13.getString(r10));
        return;
    L24:
        r12.setRichType(r13.getString(r10));
        return;
    L6:
        if (r10.equals("text-maxline") == false) goto L17;
        r14 = 2;
        goto L17
    L10:
        if (r10.equals("ellipsize-mode") == false) goto L17;
        r14 = 1;
        goto L17
    L14:
        if (r10.equals("richtype") == false) goto L17;
        r14 = 0;
        goto L17
    }
}
