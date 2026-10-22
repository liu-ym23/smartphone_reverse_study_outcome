package com.lynx.tasm.behavior.ui.image;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class AbsUIImage$$PropsSetter extends LynxUI$$PropsSetter {
    public AbsUIImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r5, String r10, y0 r11) {
        AbsUIImage r12 = (AbsUIImage) r5;
        r10.getClass();
        byte r13 = -1;
        switch(r10.hashCode()) {
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
        switch(r13) {
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
        super.a(r5, r10, r11);
        return;
    L68:
        r12.setAutoSize(r11.e(r10, false));
        return;
    L70:
        r12.setCapInsets(r11.f10815a.getString(r10));
        return;
    L72:
        r12.setDisableDefaultPlaceholder(r11.e(r10, false));
        return;
    L74:
        r12.setBlurRadius(r11.f10815a.getString(r10));
        return;
    L76:
        r12.setPlaceholder(r11.f10815a.getString(r10));
        return;
    L78:
        r12.setCapInsetsBackUp(r11.f10815a.getString(r10));
        return;
    L80:
        r12.setPreFetchHeight(r11.f10815a.getString(r10));
        return;
    L82:
        r12.setObjectFit(r11.f10815a.getString(r10));
        return;
    L84:
        r12.setSource(r11.f10815a.getString(r10));
        return;
    L86:
        r12.setPreFetchWidth(r11.f10815a.getString(r10));
        return;
    L88:
        r12.setDisableDefaultResize(r11.e(r10, false));
        return;
    L90:
        r12.setLoopCount(r11.c(r10, 0));
        return;
    L92:
        r12.setRepeat(r11.e(r10, false));
        return;
    L94:
        r12.setCoverStart(r11.e(r10, false));
        return;
    L96:
        r12.setCapInsetsScale(r11.f10815a.getString(r10));
        return;
    L6:
        if (r10.equals("auto-size") == false) goto L65;
        r13 = 14;
        goto L65
    L10:
        if (r10.equals("capInsets") == false) goto L65;
        r13 = 13;
        goto L65
    L14:
        if (r10.equals("disable-default-placeholder") == false) goto L65;
        r13 = 12;
        goto L65
    L18:
        if (r10.equals("blur-radius") == false) goto L65;
        r13 = 11;
        goto L65
    L22:
        if (r10.equals("placeholder") == false) goto L65;
        r13 = 10;
        goto L65
    L26:
        if (r10.equals("cap-insets") == false) goto L65;
        r13 = 9;
        goto L65
    L30:
        if (r10.equals("prefetch-height") == false) goto L65;
        r13 = 8;
        goto L65
    L34:
        if (r10.equals("mode") == false) goto L65;
        r13 = 7;
        goto L65
    L38:
        if (r10.equals("src") == false) goto L65;
        r13 = 6;
        goto L65
    L42:
        if (r10.equals("prefetch-width") == false) goto L65;
        r13 = 5;
        goto L65
    L46:
        if (r10.equals("disable-default-resize") == false) goto L65;
        r13 = 4;
        goto L65
    L50:
        if (r10.equals("loop-count") == false) goto L65;
        r13 = 3;
        goto L65
    L54:
        if (r10.equals("repeat") == false) goto L65;
        r13 = 2;
        goto L65
    L58:
        if (r10.equals("cover-start") == false) goto L65;
        r13 = 1;
        goto L65
    L62:
        if (r10.equals("cap-insets-scale") == false) goto L65;
        r13 = 0;
        goto L65
    }
}
