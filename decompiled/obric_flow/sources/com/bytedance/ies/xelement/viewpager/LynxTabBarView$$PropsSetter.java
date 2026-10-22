package com.bytedance.ies.xelement.viewpager;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class LynxTabBarView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxTabBarView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r10, String r11, y0 r12) {
        LynxTabBarView r5 = (LynxTabBarView) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -1491502497: goto L78;
            case -1369575443: goto L74;
            case -1351291312: goto L70;
            case -1332194002: goto L66;
            case -904864243: goto L62;
            case -887638045: goto L58;
            case -827357317: goto L54;
            case 127387944: goto L50;
            case 181584780: goto L46;
            case 182873757: goto L42;
            case 195239007: goto L38;
            case 292087426: goto L34;
            case 310371557: goto L30;
            case 598588904: goto L26;
            case 626647517: goto L22;
            case 790454668: goto L18;
            case 909098312: goto L14;
            case 1027794903: goto L10;
            case 1823781940: goto L6;
            default: goto L81;
        };
    L81:
        switch(r13) {
            case 0: goto L120;
            case 1: goto L118;
            case 2: goto L116;
            case 3: goto L114;
            case 4: goto L112;
            case 5: goto L110;
            case 6: goto L108;
            case 7: goto L106;
            case 8: goto L104;
            case 9: goto L102;
            case 10: goto L100;
            case 11: goto L98;
            case 12: goto L96;
            case 13: goto L94;
            case 14: goto L92;
            case 15: goto L90;
            case 16: goto L88;
            case 17: goto L86;
            case 18: goto L84;
            default: goto L82;
        };
    L82:
        super.a(r10, r11, r12);
        return;
    L84:
        r5.setBorderTop(r12.b(0.0f, r11));
        return;
    L86:
        r5.setDisableAttachEvent(r12.e(r11, true));
        return;
    L88:
        r5.setTabIndicatorRadius(r12.b(0.0f, r11));
        return;
    L90:
        r5.setTabHeightRpx(r12.b(0.0f, r11));
        return;
    L92:
        r5.setTabIndicatorHeight(r12.b(0.0f, r11));
        return;
    L94:
        r5.setBorderHeight(r12.b(0.0f, r11));
        return;
    L96:
        r5.setBorderWidth(r12.b(0.0f, r11));
        return;
    L98:
        r5.setBorderLineColor(r12.f10815a.getString(r11));
        return;
    L100:
        r5.set(r12.b(0.0f, r11));
        return;
    L102:
        r5.setTabInterspace(r12.b(0.0f, r11));
        return;
    L104:
        r5.setTabNewGesture(r12.e(r11, false));
        return;
    L106:
        r5.setTabPaddingRight(r12.c(r11, 0));
        return;
    L108:
        r5.setTabPaddingLeft(r12.c(r11, 0));
        return;
    L110:
        r5.setTablayoutGravity(r12.f10815a.getString(r11));
        return;
    L112:
        r5.setOriginChangeEvent(r12.e(r11, false));
        return;
    L114:
        r5.setBackground(r12.f10815a.getString(r11));
        return;
    L116:
        r5.setTabIndicatorWidth(r12.b(0.0f, r11));
        return;
    L118:
        r5.setTabIndicatorColor(r12.f10815a.getString(r11));
        return;
    L120:
        r5.setTabHeight(r12.b(0.0f, r11));
        return;
    L6:
        if (r11.equals("border-top") == false) goto L81;
        r13 = 18;
        goto L81
    L10:
        if (r11.equals("disable-attach-event") == false) goto L81;
        r13 = 17;
        goto L81
    L14:
        if (r11.equals("tab-indicator-radius") == false) goto L81;
        r13 = 16;
        goto L81
    L18:
        if (r11.equals("tab-height-rpx") == false) goto L81;
        r13 = 15;
        goto L81
    L22:
        if (r11.equals("tab-indicator-height") == false) goto L81;
        r13 = 14;
        goto L81
    L26:
        if (r11.equals("border-height") == false) goto L81;
        r13 = 13;
        goto L81
    L30:
        if (r11.equals("border-width") == false) goto L81;
        r13 = 12;
        goto L81
    L34:
        if (r11.equals("border-color") == false) goto L81;
        r13 = 11;
        goto L81
    L38:
        if (r11.equals("tab-indicator-top") == false) goto L81;
        r13 = 10;
        goto L81
    L42:
        if (r11.equals("tab-inter-space") == false) goto L81;
        r13 = 9;
        goto L81
    L46:
        if (r11.equals("tab-new-gesture-enable") == false) goto L81;
        r13 = 8;
        goto L81
    L50:
        if (r11.equals("tab-padding-right") == false) goto L81;
        r13 = 7;
        goto L81
    L54:
        if (r11.equals("tab-padding-left") == false) goto L81;
        r13 = 6;
        goto L81
    L58:
        if (r11.equals("tab-layout-gravity") == false) goto L81;
        r13 = 5;
        goto L81
    L62:
        if (r11.equals("android-force-bind-change-event") == false) goto L81;
        r13 = 4;
        goto L81
    L66:
        if (r11.equals("background") == false) goto L81;
        r13 = 3;
        goto L81
    L70:
        if (r11.equals("tab-indicator-width") == false) goto L81;
        r13 = 2;
        goto L81
    L74:
        if (r11.equals("tab-indicator-color") == false) goto L81;
        r13 = 1;
        goto L81
    L78:
        if (r11.equals("tab-height") == false) goto L81;
        r13 = 0;
        goto L81
    }
}
