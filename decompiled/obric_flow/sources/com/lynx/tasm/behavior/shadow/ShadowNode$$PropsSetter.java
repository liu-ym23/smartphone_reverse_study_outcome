package com.lynx.tasm.behavior.shadow;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.utils.ShadowNodeSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowNode$$PropsSetter implements ShadowNodeSetter<ShadowNode> {
    public ShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void b(ShadowNode r5, String r10, y0 r11) {
        r10.getClass();
        ReadableMap r12 = r11.f10815a;
        byte r13 = -1;
        switch(r10.hashCode()) {
            case -1559879186: goto L26;
            case -992853731: goto L22;
            case -804847959: goto L18;
            case 856740501: goto L14;
            case 1443214456: goto L10;
            case 2100930194: goto L6;
            default: goto L29;
        };
    L29:
        switch(r13) {
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            default: goto L30;
        };
    L30:
        return;
    L31:
        r5.setEventThrough(r12.getDynamic(r10));
        return;
    L33:
        r5.setDataset(r12.getMap(r10));
        return;
    L35:
        r5.setEventThroughPropagation(r12.getDynamic(r10));
        return;
    L37:
        r5.setPointerEvents(r11.c(r10, 0));
        return;
    L39:
        r5.setIgnoreFocus(r12.getDynamic(r10));
        return;
    L41:
        r5.setVerticalAlign(r12.getArray(r10));
        return;
    L6:
        if (r10.equals("event-through") == false) goto L29;
        r13 = 5;
        goto L29
    L10:
        if (r10.equals("dataset") == false) goto L29;
        r13 = 4;
        goto L29
    L14:
        if (r10.equals("enable-touch-pseudo-propagation") == false) goto L29;
        r13 = 3;
        goto L29
    L18:
        if (r10.equals("pointer-events") == false) goto L29;
        r13 = 2;
        goto L29
    L22:
        if (r10.equals("ignore-focus") == false) goto L29;
        r13 = 1;
        goto L29
    L26:
        if (r10.equals("vertical-align") == false) goto L29;
        r13 = 0;
        goto L29
    }
}
