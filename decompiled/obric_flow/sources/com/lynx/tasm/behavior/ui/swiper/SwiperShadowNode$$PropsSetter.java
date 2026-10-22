package com.lynx.tasm.behavior.ui.swiper;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class SwiperShadowNode$$PropsSetter extends CustomLayoutShadowNode$$PropsSetter {
    public SwiperShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void b(ShadowNode r10, String r11, y0 r12) {
        SwiperShadowNode r5 = (SwiperShadowNode) r10;
        r11.getClass();
        ReadableMap r13 = r12.f10815a;
        byte r14 = -1;
        switch(r11.hashCode()) {
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
        r5.setPageMargin(r13.getDynamic(r11));
        return;
    L38:
        r5.setMaxYScale(r12.a(r11, 0.0d));
        return;
    L40:
        r5.setPreviousMargin(r13.getDynamic(r11));
        return;
    L42:
        r5.setMode(r13.getString(r11));
        return;
    L44:
        r5.setNextMargin(r13.getDynamic(r11));
        return;
    L46:
        r5.setMaxXScale(r12.a(r11, 0.0d));
        return;
    L48:
        r5.setVertical(r12.e(r11, false));
        return;
    L6:
        if (r11.equals("page-margin") == false) goto L33;
        r14 = 6;
        goto L33
    L10:
        if (r11.equals("max-y-scale") == false) goto L33;
        r14 = 5;
        goto L33
    L14:
        if (r11.equals("previous-margin") == false) goto L33;
        r14 = 4;
        goto L33
    L18:
        if (r11.equals("mode") == false) goto L33;
        r14 = 3;
        goto L33
    L22:
        if (r11.equals("next-margin") == false) goto L33;
        r14 = 2;
        goto L33
    L26:
        if (r11.equals("max-x-scale") == false) goto L33;
        r14 = 1;
        goto L33
    L30:
        if (r11.equals("vertical") == false) goto L33;
        r14 = 0;
        goto L33
    }
}
