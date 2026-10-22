package com.bytedance.ies.xelement.banner;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxSwiperView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxSwiperView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        LynxSwiperView r5 = (LynxSwiperView) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1992012396: goto L86;
            case -1597449863: goto L82;
            case -1596393144: goto L78;
            case -1498085729: goto L74;
            case -1235498272: goto L70;
            case -1029251878: goto L66;
            case -313198140: goto L62;
            case -111166008: goto L58;
            case 3357091: goto L54;
            case 24002884: goto L50;
            case 364166425: goto L46;
            case 570418373: goto L42;
            case 914875020: goto L38;
            case 1126940025: goto L34;
            case 1127093697: goto L30;
            case 1255595234: goto L26;
            case 1439562083: goto L22;
            case 1599847372: goto L18;
            case 1616798838: goto L14;
            case 1665556140: goto L10;
            case 2050488869: goto L6;
            default: goto L89;
        };
    L89:
        switch(r13) {
            case 0: goto L132;
            case 1: goto L130;
            case 2: goto L128;
            case 3: goto L126;
            case 4: goto L124;
            case 5: goto L122;
            case 6: goto L120;
            case 7: goto L118;
            case 8: goto L116;
            case 9: goto L114;
            case 10: goto L112;
            case 11: goto L110;
            case 12: goto L108;
            case 13: goto L106;
            case 14: goto L104;
            case 15: goto L102;
            case 16: goto L100;
            case 17: goto L98;
            case 18: goto L96;
            case 19: goto L94;
            case 20: goto L92;
            default: goto L90;
        };
    L90:
        super.a(r10, r11, r12);
        return;
    L92:
        r5.setIndicatorColor(r12.f10815a.getString(r11));
        return;
    L94:
        r5.setPageMargin(r12.f10815a.getDynamic(r11));
        return;
    L96:
        r5.setShadowColor(r12.f10815a.getString(r11));
        return;
    L98:
        r5.setSmoothScroll(r12.e(r11, true));
        return;
    L100:
        r5.setAutoPlay(r12.e(r11, false));
        return;
    L102:
        r5.setHideShadow(r12.e(r11, true));
        return;
    L104:
        r5.setCurrentItemId(r12.f10815a.getString(r11));
        return;
    L106:
        r5.setCurrentIndex(r12.c(r11, 0));
        return;
    L108:
        r5.setItemWidth(r12.f10815a.getDynamic(r11));
        return;
    L110:
        r5.setInterval(r12.c(r11, 5000));
        return;
    L112:
        r5.setTouchable(r12.e(r11, false));
        return;
    L114:
        r5.setPreviousMargin(r12.f10815a.getDynamic(r11));
        return;
    L116:
        r5.setMode(r12.f10815a.getString(r11));
        return;
    L118:
        r5.setNextMargin(r12.f10815a.getDynamic(r11));
        return;
    L120:
        r5.setRenderHardwareTexture(r12.e(r11, false));
        return;
    L122:
        r5.setIndicatorActiveColor(r12.f10815a.getString(r11));
        return;
    L124:
        r5.setEndMargin(r12.f10815a.getDynamic(r11));
        return;
    L126:
        r5.setCircular(r12.e(r11, false));
        return;
    L128:
        r5.setIndicator(r12.e(r11, false));
        return;
    L130:
        r5.setStartMargin(r12.f10815a.getDynamic(r11));
        return;
    L132:
        r5.setDuration(r12.c(r11, 500));
        return;
    L6:
        if (r11.equals("indicator-color") == false) goto L89;
        r13 = 20;
        goto L89
    L10:
        if (r11.equals("page-margin") == false) goto L89;
        r13 = 19;
        goto L89
    L14:
        if (r11.equals("shadow-color") == false) goto L89;
        r13 = 18;
        goto L89
    L18:
        if (r11.equals("smooth-scroll") == false) goto L89;
        r13 = 17;
        goto L89
    L22:
        if (r11.equals("autoplay") == false) goto L89;
        r13 = 16;
        goto L89
    L26:
        if (r11.equals("hideshadow") == false) goto L89;
        r13 = 15;
        goto L89
    L30:
        if (r11.equals("current-item-id") == false) goto L89;
        r13 = 14;
        goto L89
    L34:
        if (r11.equals("current") == false) goto L89;
        r13 = 13;
        goto L89
    L38:
        if (r11.equals("item-width") == false) goto L89;
        r13 = 12;
        goto L89
    L42:
        if (r11.equals("interval") == false) goto L89;
        r13 = 11;
        goto L89
    L46:
        if (r11.equals("touchable") == false) goto L89;
        r13 = 10;
        goto L89
    L50:
        if (r11.equals("previous-margin") == false) goto L89;
        r13 = 9;
        goto L89
    L54:
        if (r11.equals("mode") == false) goto L89;
        r13 = 8;
        goto L89
    L58:
        if (r11.equals("next-margin") == false) goto L89;
        r13 = 7;
        goto L89
    L62:
        if (r11.equals("hardware_texture") == false) goto L89;
        r13 = 6;
        goto L89
    L66:
        if (r11.equals("indicator-active-color") == false) goto L89;
        r13 = 5;
        goto L89
    L70:
        if (r11.equals("end-margin") == false) goto L89;
        r13 = 4;
        goto L89
    L74:
        if (r11.equals("circular") == false) goto L89;
        r13 = 3;
        goto L89
    L78:
        if (r11.equals("indicator-dots") == false) goto L89;
        r13 = 2;
        goto L89
    L82:
        if (r11.equals("start-margin") == false) goto L89;
        r13 = 1;
        goto L89
    L86:
        if (r11.equals("duration") == false) goto L89;
        r13 = 0;
        goto L89
    }
}
