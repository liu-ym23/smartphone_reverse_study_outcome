package com.lynx.tasm.behavior.ui.swiper;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class XSwiperUI$$PropsSetter extends UISimpleView$$PropsSetter {
    public XSwiperUI$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        XSwiperUI r5 = (XSwiperUI) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -2096030894: goto L142;
            case -1992012396: goto L138;
            case -1984141450: goto L134;
            case -1860862959: goto L130;
            case -1596393144: goto L126;
            case -1498085729: goto L122;
            case -1439500848: goto L118;
            case -1363870918: goto L114;
            case -1029251878: goto L110;
            case -842605868: goto L106;
            case -686438324: goto L102;
            case -645426670: goto L98;
            case -538499326: goto L94;
            case -509897868: goto L90;
            case -476367237: goto L86;
            case -111166008: goto L82;
            case 3357091: goto L78;
            case 24002884: goto L74;
            case 201065357: goto L70;
            case 364166425: goto L66;
            case 433748736: goto L62;
            case 487784663: goto L58;
            case 570418373: goto L54;
            case 873902905: goto L50;
            case 1013897100: goto L46;
            case 1090700700: goto L42;
            case 1126940025: goto L38;
            case 1439562083: goto L34;
            case 1599847372: goto L30;
            case 1663357090: goto L26;
            case 1665556140: goto L22;
            case 1696908181: goto L18;
            case 1702954660: goto L14;
            case 1744363728: goto L10;
            case 2050488869: goto L6;
            default: goto L145;
        };
    L145:
        switch(r13) {
            case 0: goto L216;
            case 1: goto L214;
            case 2: goto L212;
            case 3: goto L210;
            case 4: goto L208;
            case 5: goto L206;
            case 6: goto L204;
            case 7: goto L202;
            case 8: goto L200;
            case 9: goto L198;
            case 10: goto L196;
            case 11: goto L194;
            case 12: goto L192;
            case 13: goto L190;
            case 14: goto L188;
            case 15: goto L186;
            case 16: goto L184;
            case 17: goto L182;
            case 18: goto L180;
            case 19: goto L178;
            case 20: goto L176;
            case 21: goto L174;
            case 22: goto L172;
            case 23: goto L170;
            case 24: goto L168;
            case 25: goto L166;
            case 26: goto L164;
            case 27: goto L162;
            case 28: goto L160;
            case 29: goto L158;
            case 30: goto L156;
            case 31: goto L154;
            case 32: goto L152;
            case 33: goto L150;
            case 34: goto L148;
            default: goto L146;
        };
    L146:
        super.a(r10, r11, r12);
        return;
    L148:
        r5.setIndicatorColor(r12.f10815a.getString(r11));
        return;
    L150:
        r5.setEnableNestedChild(r12.e(r11, false));
        return;
    L152:
        r5.setHandleGesture(r12.e(r11, true));
        return;
    L154:
        r5.setFinishReset(r12.e(r11, false));
        return;
    L156:
        r5.setPageMargin(r12.f10815a.getDynamic(r11));
        return;
    L158:
        r5.setTransitionThrottle(r12.c(r11, 0));
        return;
    L160:
        r5.setSmoothScroll(r12.e(r11, true));
        return;
    L162:
        r5.setAutoPlay(r12.e(r11, false));
        return;
    L164:
        r5.setCurrentIndex(r12.c(r11, 0));
        return;
    L166:
        r5.setNormalTranslationFactor(r12.a(r11, 0.0d));
        return;
    L168:
        r5.setForceCanScroll(r12.e(r11, false));
        return;
    L170:
        r5.setBounceDuration(r12.c(r11, 500));
        return;
    L172:
        r5.setInterval(r12.c(r11, 5000));
        return;
    L174:
        r5.setKeepItemView(r12.e(r11, false));
        return;
    L176:
        r5.setScrollBeforeDetached(r12.e(r11, false));
        return;
    L178:
        r5.setTouchable(r12.e(r11, false));
        return;
    L180:
        r5.setMaxYScale(r12.a(r11, 0.0d));
        return;
    L182:
        r5.setPreviousMargin(r12.f10815a.getDynamic(r11));
        return;
    L184:
        r5.setMode(r12.f10815a.getString(r11));
        return;
    L186:
        r5.setNextMargin(r12.f10815a.getDynamic(r11));
        return;
    L188:
        r5.setMinYScale(r12.a(r11, 0.0d));
        return;
    L190:
        r5.setBounceEndThreshold(r12.b(0.3f, r11));
        return;
    L192:
        r5.setBounceBeginThreshold(r12.b(0.3f, r11));
        return;
    L194:
        r5.setEnableBounce(r12.e(r11, false));
        return;
    L196:
        r5.setMaxXScale(r12.a(r11, 0.0d));
        return;
    L198:
        r5.setCompatible(r12.e(r11, true));
        return;
    L200:
        r5.setIndicatorActiveColor(r12.f10815a.getString(r11));
        return;
    L202:
        r5.setMinXScale(r12.a(r11, 0.0d));
        return;
    L204:
        r5.setOrientation(r12.f10815a.getString(r11));
        return;
    L206:
        r5.setCircular(r12.e(r11, false));
        return;
    L208:
        r5.setIndicator(r12.e(r11, false));
        return;
    L210:
        r5.setIgnoreLayoutUpdate(r12.e(r11, false));
        return;
    L212:
        r5.setVertical(r12.e(r11, false));
        return;
    L214:
        r5.setDuration(r12.c(r11, 500));
        return;
    L216:
        r5.setEnableViceLoop(r12.e(r11, true));
        return;
    L6:
        if (r11.equals("indicator-color") == false) goto L145;
        r13 = 34;
        goto L145
    L10:
        if (r11.equals("enable-nested-child") == false) goto L145;
        r13 = 33;
        goto L145
    L14:
        if (r11.equals("handle-gesture") == false) goto L145;
        r13 = 32;
        goto L145
    L18:
        if (r11.equals("finish-reset") == false) goto L145;
        r13 = 31;
        goto L145
    L22:
        if (r11.equals("page-margin") == false) goto L145;
        r13 = 30;
        goto L145
    L26:
        if (r11.equals("transition-throttle") == false) goto L145;
        r13 = 29;
        goto L145
    L30:
        if (r11.equals("smooth-scroll") == false) goto L145;
        r13 = 28;
        goto L145
    L34:
        if (r11.equals("autoplay") == false) goto L145;
        r13 = 27;
        goto L145
    L38:
        if (r11.equals("current") == false) goto L145;
        r13 = 26;
        goto L145
    L42:
        if (r11.equals("norm-translation-factor") == false) goto L145;
        r13 = 25;
        goto L145
    L46:
        if (r11.equals("force-can-scroll") == false) goto L145;
        r13 = 24;
        goto L145
    L50:
        if (r11.equals("bounce-duration") == false) goto L145;
        r13 = 23;
        goto L145
    L54:
        if (r11.equals("interval") == false) goto L145;
        r13 = 22;
        goto L145
    L58:
        if (r11.equals("keep-item-view") == false) goto L145;
        r13 = 21;
        goto L145
    L62:
        if (r11.equals("scroll-before-detached") == false) goto L145;
        r13 = 20;
        goto L145
    L66:
        if (r11.equals("touchable") == false) goto L145;
        r13 = 19;
        goto L145
    L70:
        if (r11.equals("max-y-scale") == false) goto L145;
        r13 = 18;
        goto L145
    L74:
        if (r11.equals("previous-margin") == false) goto L145;
        r13 = 17;
        goto L145
    L78:
        if (r11.equals("mode") == false) goto L145;
        r13 = 16;
        goto L145
    L82:
        if (r11.equals("next-margin") == false) goto L145;
        r13 = 15;
        goto L145
    L86:
        if (r11.equals("min-y-scale") == false) goto L145;
        r13 = 14;
        goto L145
    L90:
        if (r11.equals("bounce-end-threshold") == false) goto L145;
        r13 = 13;
        goto L145
    L94:
        if (r11.equals("bounce-begin-threshold") == false) goto L145;
        r13 = 12;
        goto L145
    L98:
        if (r11.equals("enable-bounce") == false) goto L145;
        r13 = 11;
        goto L145
    L102:
        if (r11.equals("max-x-scale") == false) goto L145;
        r13 = 10;
        goto L145
    L106:
        if (r11.equals("compatible") == false) goto L145;
        r13 = 9;
        goto L145
    L110:
        if (r11.equals("indicator-active-color") == false) goto L145;
        r13 = 8;
        goto L145
    L114:
        if (r11.equals("min-x-scale") == false) goto L145;
        r13 = 7;
        goto L145
    L118:
        if (r11.equals("orientation") == false) goto L145;
        r13 = 6;
        goto L145
    L122:
        if (r11.equals("circular") == false) goto L145;
        r13 = 5;
        goto L145
    L126:
        if (r11.equals("indicator-dots") == false) goto L145;
        r13 = 4;
        goto L145
    L130:
        if (r11.equals("ignore-layout-update") == false) goto L145;
        r13 = 3;
        goto L145
    L134:
        if (r11.equals("vertical") == false) goto L145;
        r13 = 2;
        goto L145
    L138:
        if (r11.equals("duration") == false) goto L145;
        r13 = 1;
        goto L145
    L142:
        if (r11.equals("enable-vice-loop") == false) goto L145;
        r13 = 0;
        goto L145
    }
}
