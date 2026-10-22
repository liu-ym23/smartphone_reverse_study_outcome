package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.utils.ShadowNodeSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ShadowNode$$PropsSetter implements ShadowNodeSetter<ShadowNode> {
    public ShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r4, String r5, x0 r6) {
        r5.getClass();
        byte r2 = -1;
        switch(r5.hashCode()) {
            case -1559879186: goto L26;
            case -992853731: goto L22;
            case -804847959: goto L18;
            case 856740501: goto L14;
            case 1443214456: goto L10;
            case 2100930194: goto L6;
            default: goto L29;
        };
    L29:
        switch(r2) {
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
        r4.setEventThrough(r6.d(r5));
        return;
    L33:
        r4.setDataset(r6.g(r5));
        return;
    L35:
        r4.setEventThroughPropagation(r6.d(r5));
        return;
    L37:
        r4.setPointerEvents(r6.f(r5, 0));
        return;
    L39:
        r4.setIgnoreFocus(r6.d(r5));
        return;
    L41:
        r4.setVerticalAlign(r6.a(r5));
        return;
    L6:
        if (r5.equals("event-through") == false) goto L29;
        r2 = 5;
        goto L29
    L10:
        if (r5.equals("dataset") == false) goto L29;
        r2 = 4;
        goto L29
    L14:
        if (r5.equals("enable-touch-pseudo-propagation") == false) goto L29;
        r2 = 3;
        goto L29
    L18:
        if (r5.equals("pointer-events") == false) goto L29;
        r2 = 2;
        goto L29
    L22:
        if (r5.equals("ignore-focus") == false) goto L29;
        r2 = 1;
        goto L29
    L26:
        if (r5.equals("vertical-align") == false) goto L29;
        r2 = 0;
        goto L29
    }
}
