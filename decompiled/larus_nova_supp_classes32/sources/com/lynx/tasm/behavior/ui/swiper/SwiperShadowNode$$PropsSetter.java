package com.lynx.tasm.behavior.ui.swiper;

import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SwiperShadowNode$$PropsSetter extends CustomLayoutShadowNode$$PropsSetter {
    public SwiperShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r6, String r7, x0 r8) {
        SwiperShadowNode r0 = (SwiperShadowNode) r6;
        r7.getClass();
        switch(r7.hashCode()) {
            case -1984141450: goto L30;
            case -686438324: goto L26;
            case -111166008: goto L22;
            case 3357091: goto L18;
            case 24002884: goto L14;
            case 201065357: goto L10;
            case 1665556140: goto L6;
            default: goto L33;
        };
    L33:
        byte r1 = -1;
    L35:
        switch(r1) {
            case 0: goto L50;
            case 1: goto L48;
            case 2: goto L46;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L38;
            default: goto L36;
        };
    L36:
        super.a(r6, r7, r8);
        return;
    L38:
        r0.setPageMargin(r8.d(r7));
        return;
    L40:
        r0.setMaxYScale(r8.c(r7, 0.0d));
        return;
    L42:
        r0.setPreviousMargin(r8.d(r7));
        return;
    L44:
        r0.setMode(r8.h(r7));
        return;
    L46:
        r0.setNextMargin(r8.d(r7));
        return;
    L48:
        r0.setMaxXScale(r8.c(r7, 0.0d));
        return;
    L50:
        r0.setVertical(r8.b(r7, false));
        return;
    L6:
        if (r7.equals("page-margin") == false) goto L33;
        r1 = 6;
        goto L35
    L10:
        if (r7.equals("max-y-scale") == false) goto L33;
        r1 = 5;
        goto L35
    L14:
        if (r7.equals("previous-margin") == false) goto L33;
        r1 = 4;
        goto L35
    L18:
        if (r7.equals("mode") == false) goto L33;
        r1 = 3;
        goto L35
    L22:
        if (r7.equals("next-margin") == false) goto L33;
        r1 = 2;
        goto L35
    L26:
        if (r7.equals("max-x-scale") == false) goto L33;
        r1 = 1;
        goto L35
    L30:
        if (r7.equals("vertical") == false) goto L33;
        r1 = 0;
        goto L35
    }
}
