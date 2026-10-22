package com.bytedance.ies.xelement.viewpager.viewpager;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class BaseLynxViewPager$$PropsSetter extends UISimpleView$$PropsSetter {
    public BaseLynxViewPager$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void a(LynxBaseUI r10, String r11, y0 r12) {
        BaseLynxViewPager r5 = (BaseLynxViewPager) r10;
        r11.getClass();
        byte r13 = -1;
        switch(r11.hashCode()) {
            case -2088137419: goto L110;
            case -1951374851: goto L106;
            case -1689248927: goto L102;
            case -1491502497: goto L98;
            case -1369575443: goto L94;
            case -1351291312: goto L90;
            case -1332194002: goto L86;
            case -887638045: goto L82;
            case -855908868: goto L78;
            case -827357317: goto L74;
            case -798067553: goto L70;
            case 127387944: goto L66;
            case 182873757: goto L62;
            case 210206703: goto L58;
            case 292087426: goto L54;
            case 310371557: goto L50;
            case 468669252: goto L46;
            case 487784663: goto L42;
            case 598588904: goto L38;
            case 626647517: goto L34;
            case 630404516: goto L30;
            case 790454668: goto L26;
            case 909098312: goto L22;
            case 942654657: goto L18;
            case 1095253835: goto L14;
            case 1219787336: goto L10;
            case 1581826371: goto L6;
            default: goto L113;
        };
    L113:
        switch(r13) {
            case 0: goto L168;
            case 1: goto L166;
            case 2: goto L164;
            case 3: goto L162;
            case 4: goto L160;
            case 5: goto L158;
            case 6: goto L156;
            case 7: goto L154;
            case 8: goto L152;
            case 9: goto L150;
            case 10: goto L148;
            case 11: goto L146;
            case 12: goto L144;
            case 13: goto L142;
            case 14: goto L140;
            case 15: goto L138;
            case 16: goto L136;
            case 17: goto L134;
            case 18: goto L132;
            case 19: goto L130;
            case 20: goto L128;
            case 21: goto L126;
            case 22: goto L124;
            case 23: goto L122;
            case 24: goto L120;
            case 25: goto L118;
            case 26: goto L116;
            default: goto L114;
        };
    L114:
        super.a(r10, r11, r12);
        return;
    L116:
        r5.setTabBarDragEnable(r12.e(r11, false));
        return;
    L118:
        r5.setUnSelectedTextSize(r12.b(0.0f, r11));
        return;
    L120:
        r5.setTextBoldMode(r12.f10815a.getString(r11));
        return;
    L122:
        r5.setSelect(r12.c(r11, 0));
        return;
    L124:
        r5.setTabIndicatorRadius(r12.b(0.0f, r11));
        return;
    L126:
        r5.setTabHeightRpx(r12.b(0.0f, r11));
        return;
    L128:
        r5.setAllowHorizontalGesture(r12.e(r11, false));
        return;
    L130:
        r5.setTabIndicatorHeight(r12.b(0.0f, r11));
        return;
    L132:
        r5.setBorderHeight(r12.b(0.0f, r11));
        return;
    L134:
        r5.setKeepItemView(r12.e(r11, false));
        return;
    L136:
        r5.setIndicatorVisibility(r12.f10815a.getString(r11));
        return;
    L138:
        r5.setBorderWidth(r12.b(0.0f, r11));
        return;
    L140:
        r5.setBorderLineColor(r12.f10815a.getString(r11));
        return;
    L142:
        r5.setSelectedTextSize(r12.b(0.0f, r11));
        return;
    L144:
        r5.setTabInterspace(r12.b(0.0f, r11));
        return;
    L146:
        r5.setTabPaddingRight(r12.c(r11, 0));
        return;
    L148:
        r5.setTabPaddingBottom(r12.c(r11, 0));
        return;
    L150:
        r5.setTabPaddingLeft(r12.c(r11, 0));
        return;
    L152:
        r5.setUnSelectedTextColor(r12.f10815a.getString(r11));
        return;
    L154:
        r5.setTablayoutGravity(r12.f10815a.getString(r11));
        return;
    L156:
        r5.setBackground(r12.f10815a.getString(r11));
        return;
    L158:
        r5.setTabIndicatorWidth(r12.b(0.0f, r11));
        return;
    L160:
        r5.setTabIndicatorColor(r12.f10815a.getString(r11));
        return;
    L162:
        r5.setTabHeight(r12.b(0.0f, r11));
        return;
    L164:
        r5.setTabPaddingTop(r12.c(r11, 0));
        return;
    L166:
        r5.setTabbarBackground(r12.f10815a.getString(r11));
        return;
    L168:
        r5.setSelectedTextColor(r12.f10815a.getString(r11));
        return;
    L6:
        if (r11.equals("tabbar-drag") == false) goto L113;
        r13 = 26;
        goto L113
    L10:
        if (r11.equals("unselected-text-size") == false) goto L113;
        r13 = 25;
        goto L113
    L14:
        if (r11.equals("text-bold-mode") == false) goto L113;
        r13 = 24;
        goto L113
    L18:
        if (r11.equals("select-index") == false) goto L113;
        r13 = 23;
        goto L113
    L22:
        if (r11.equals("tab-indicator-radius") == false) goto L113;
        r13 = 22;
        goto L113
    L26:
        if (r11.equals("tab-height-rpx") == false) goto L113;
        r13 = 21;
        goto L113
    L30:
        if (r11.equals("allow-horizontal-gesture") == false) goto L113;
        r13 = 20;
        goto L113
    L34:
        if (r11.equals("tab-indicator-height") == false) goto L113;
        r13 = 19;
        goto L113
    L38:
        if (r11.equals("border-height") == false) goto L113;
        r13 = 18;
        goto L113
    L42:
        if (r11.equals("keep-item-view") == false) goto L113;
        r13 = 17;
        goto L113
    L46:
        if (r11.equals("hide-indicator") == false) goto L113;
        r13 = 16;
        goto L113
    L50:
        if (r11.equals("border-width") == false) goto L113;
        r13 = 15;
        goto L113
    L54:
        if (r11.equals("border-color") == false) goto L113;
        r13 = 14;
        goto L113
    L58:
        if (r11.equals("selected-text-size") == false) goto L113;
        r13 = 13;
        goto L113
    L62:
        if (r11.equals("tab-inter-space") == false) goto L113;
        r13 = 12;
        goto L113
    L66:
        if (r11.equals("tab-padding-right") == false) goto L113;
        r13 = 11;
        goto L113
    L70:
        if (r11.equals("tab-padding-bottom") == false) goto L113;
        r13 = 10;
        goto L113
    L74:
        if (r11.equals("tab-padding-left") == false) goto L113;
        r13 = 9;
        goto L113
    L78:
        if (r11.equals("unselected-text-color") == false) goto L113;
        r13 = 8;
        goto L113
    L82:
        if (r11.equals("tab-layout-gravity") == false) goto L113;
        r13 = 7;
        goto L113
    L86:
        if (r11.equals("background") == false) goto L113;
        r13 = 6;
        goto L113
    L90:
        if (r11.equals("tab-indicator-width") == false) goto L113;
        r13 = 5;
        goto L113
    L94:
        if (r11.equals("tab-indicator-color") == false) goto L113;
        r13 = 4;
        goto L113
    L98:
        if (r11.equals("tab-height") == false) goto L113;
        r13 = 3;
        goto L113
    L102:
        if (r11.equals("tab-padding-top") == false) goto L113;
        r13 = 2;
        goto L113
    L106:
        if (r11.equals("tabbar-background") == false) goto L113;
        r13 = 1;
        goto L113
    L110:
        if (r11.equals("selected-text-color") == false) goto L113;
        r13 = 0;
        goto L113
    }
}
