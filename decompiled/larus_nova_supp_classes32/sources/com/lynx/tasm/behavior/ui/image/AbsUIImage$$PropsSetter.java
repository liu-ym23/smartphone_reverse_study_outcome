package com.lynx.tasm.behavior.ui.image;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AbsUIImage$$PropsSetter extends LynxUI$$PropsSetter {
    public AbsUIImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI r5, String r6, x0 r7) {
        AbsUIImage r0 = (AbsUIImage) r5;
        r6.getClass();
        byte r3 = -1;
        switch(r6.hashCode()) {
            case -1937917490: goto L62;
            case -1249491252: goto L58;
            case -934531685: goto L54;
            case -629825370: goto L50;
            case -320982203: goto L46;
            case -256430480: goto L42;
            case 114148: goto L38;
            case 3357091: goto L34;
            case 207594941: goto L30;
            case 516005201: goto L26;
            case 598246771: goto L22;
            case 681292984: goto L18;
            case 1198809474: goto L14;
            case 1515751784: goto L10;
            case 1615092063: goto L6;
            default: goto L65;
        };
    L65:
        switch(r3) {
            case 0: goto L96;
            case 1: goto L94;
            case 2: goto L92;
            case 3: goto L90;
            case 4: goto L88;
            case 5: goto L86;
            case 6: goto L84;
            case 7: goto L82;
            case 8: goto L80;
            case 9: goto L78;
            case 10: goto L76;
            case 11: goto L74;
            case 12: goto L72;
            case 13: goto L70;
            case 14: goto L68;
            default: goto L66;
        };
    L66:
        super.setProperty(r5, r6, r7);
        return;
    L68:
        r0.setAutoSize(r7.b(r6, false));
        return;
    L70:
        r0.setCapInsets(r7.h(r6));
        return;
    L72:
        r0.setDisableDefaultPlaceholder(r7.b(r6, false));
        return;
    L74:
        r0.setBlurRadius(r7.h(r6));
        return;
    L76:
        r0.setPlaceholder(r7.h(r6));
        return;
    L78:
        r0.setCapInsetsBackUp(r7.h(r6));
        return;
    L80:
        r0.setPreFetchHeight(r7.h(r6));
        return;
    L82:
        r0.setObjectFit(r7.h(r6));
        return;
    L84:
        r0.setSource(r7.h(r6));
        return;
    L86:
        r0.setPreFetchWidth(r7.h(r6));
        return;
    L88:
        r0.setDisableDefaultResize(r7.b(r6, false));
        return;
    L90:
        r0.setLoopCount(r7.f(r6, 0));
        return;
    L92:
        r0.setRepeat(r7.b(r6, false));
        return;
    L94:
        r0.setCoverStart(r7.b(r6, false));
        return;
    L96:
        r0.setCapInsetsScale(r7.h(r6));
        return;
    L6:
        if (r6.equals("auto-size") == false) goto L65;
        r3 = 14;
        goto L65
    L10:
        if (r6.equals("capInsets") == false) goto L65;
        r3 = 13;
        goto L65
    L14:
        if (r6.equals("disable-default-placeholder") == false) goto L65;
        r3 = 12;
        goto L65
    L18:
        if (r6.equals("blur-radius") == false) goto L65;
        r3 = 11;
        goto L65
    L22:
        if (r6.equals("placeholder") == false) goto L65;
        r3 = 10;
        goto L65
    L26:
        if (r6.equals("cap-insets") == false) goto L65;
        r3 = 9;
        goto L65
    L30:
        if (r6.equals("prefetch-height") == false) goto L65;
        r3 = 8;
        goto L65
    L34:
        if (r6.equals("mode") == false) goto L65;
        r3 = 7;
        goto L65
    L38:
        if (r6.equals(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L65;
        r3 = 6;
        goto L65
    L42:
        if (r6.equals("prefetch-width") == false) goto L65;
        r3 = 5;
        goto L65
    L46:
        if (r6.equals("disable-default-resize") == false) goto L65;
        r3 = 4;
        goto L65
    L50:
        if (r6.equals("loop-count") == false) goto L65;
        r3 = 3;
        goto L65
    L54:
        if (r6.equals("repeat") == false) goto L65;
        r3 = 2;
        goto L65
    L58:
        if (r6.equals("cover-start") == false) goto L65;
        r3 = 1;
        goto L65
    L62:
        if (r6.equals("cap-insets-scale") == false) goto L65;
        r3 = 0;
        goto L65
    }
}
